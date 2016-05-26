package edu.jt.exg.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;

import utility.CommonMethod;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Order_masterAction;
import edu.jt.exg.action.Re_serveAction;
import edu.jt.exg.action.TaskAction;
import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.Order_master;
import edu.jt.exg.dto.Order_masters;
import edu.jt.exg.dto.Task;
import edu.jt.exg.dto.Tasks;
import edu.jt.exg.logic.order_master.Order_masterBatisDao;
import edu.jt.exg.logic.order_master.Order_masterBean;
import edu.jt.exg.logic.order_master.Order_masterUtility;
import edu.jt.exg.logic.order_task.Order_taskBatisDao;
import edu.jt.exg.logic.order_task.Order_taskBean;
import edu.jt.exg.logic.order_task.Order_taskUtility;
import edu.jt.exg.logic.task.TaskBatisDao;
import edu.jt.exg.logic.task.TaskBean;
import edu.jt.exg.logic.task.TaskUtility;
import edu.jt.exg.logic.user.UserBatisDao;
import edu.jt.exg.logic.user.UserBean;
import edu.jt.exg.logic.user.UserUtility;
import edu.jt.exg.logic.v_order_master.V_order_masterBatisDao;
import edu.jt.exg.logic.v_order_master.V_order_masterBean;
import edu.jt.exg.logic.v_order_master.V_order_masterUtility;
import edu.jt.exg.logic.v_order_task.V_order_taskBatisDao;
import edu.jt.exg.logic.v_order_task.V_order_taskBean;
import edu.jt.exg.logic.v_order_task.V_order_taskUtility;
import edu.jt.exg.logic.v_task.V_taskBatisDao;
import edu.jt.exg.logic.v_task.V_taskBean;
import edu.jt.exg.logic.v_task.V_taskUtility;


public class Order_masterServiceImpl implements Order_masterService {
    private static final long serialVersionUID = 1L;

	/**
	 * 记录起始读取位置
	 */
	public String start=null;
	public String getStart(){return start;}
	public void setStart(String start){this.start=start;}
	
	/**
	 * 记录范围
	 */
	public String range=ConstSetup.REFERENCE_RANGE;
	
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}

	/**
	 * 排序规则
	 */
	public LinkedHashMap<String,String> orderByMap=null;
	
	@Override
	public Callback CreateOrder_master(Order_master order_master) {
		Callback callback = new Callback();
		//检查维修员是否有已经接受的还没做完的任务
		Order_masterBatisDao dao = Order_masterUtility.getIocHandel().getBean("Order_masterBatisDao",
				Order_masterBatisDao.class);
		Order_masterBean status10=new Order_masterBean();
		Order_masterBean status30=new Order_masterBean();
		status10.setRepair_userkey(order_master.getRepair_userkey());
		status10.setStatus("10");
		status30.setRepair_userkey(order_master.getRepair_userkey());
		status30.setStatus("30");
		List<Order_masterBean> status10s=dao.finder(status10);
		List<Order_masterBean> status30s=dao.finder(status30);
		if(status10s.size()!=0||status30s.size()!=0){
			callback.setCode(500);
			callback.setResult(false);
			return callback;
		}
		//检查这个任务是否被人接单
		Order_taskBean order_task=new Order_taskBean();
		Order_taskBatisDao taskBatisDao=Order_taskUtility.getIocHandel().getBean("Order_taskBatisDao",
				Order_taskBatisDao.class);
		order_task.setTaskkey(order_master.getTaskKey());
		if(taskBatisDao.finder(order_task).size()!=0){
			callback.setCode(600);
			callback.setResult(false);
			return callback;
		}
		
		
		
		String id="";
		Order_masterBean order_masterBean = new Order_masterBean();
		if (null != order_master) {
			BeanUtils.copyProperties(order_master, order_masterBean);
			order_masterBean.setId(Utilities.getRandomPK(true));
			id=order_masterBean.getId();
			order_masterBean.setStatus("10");
			order_masterBean.setInvalid("0");
			order_masterBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
			int result = dao.insert(order_masterBean);
			if (result == 0) {
				callback.setResult(false);
			} else {
				callback.setResult(true);
				callback.setMessage(id);

			}
		} else {
			callback.setResult(false);
		}
		
		if(callback.getResult()){
			//创建接单任务关系表
			Order_taskBean order_taskBean=new Order_taskBean();
			Order_taskBatisDao order_taskBatisDao=Order_taskUtility.getIocHandel().getBean("Order_taskBatisDao",
					Order_taskBatisDao.class);
			order_taskBean.setInvalid("0");
			order_taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
			order_taskBean.setOrderkey(id);
			order_taskBean.setTaskkey(order_master.getTaskKey());
			order_taskBatisDao.insert(order_taskBean);
			
			//将任务的状态改为进行中
			TaskBean taskBean=new TaskBean();
			TaskBatisDao taskDao=TaskUtility.getIocHandel().getBean("TaskBatisDao",
					TaskBatisDao.class);
			taskBean=taskDao.findByKey(order_master.getTaskKey());
			taskBean.setStatus("20");
			taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
			taskDao.updateByKey(taskBean);
		}
		
		return callback;
	}
	@Override
	public List<Order_masters> GetOrder_masterBefore(Order_master order_master) {
		List<Order_masters> result = new ArrayList<Order_masters>();

		List<V_order_masterBean> restatus10 = null;
		List<V_order_masterBean> restatus30 = null;
		List<V_order_masterBean> res = null;

		try {
			V_order_masterBatisDao dao = V_order_masterUtility.getIocHandel().getBean(
					"V_order_masterBatisDao", V_order_masterBatisDao.class);
			//找出已结单的
			V_order_masterBean condition = new V_order_masterBean();
			condition.setInvalid("0");
			condition.setRepair_userkey(order_master.getRepair_userkey());
			condition.setStatus("10");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus10 = dao.finder(orderByMap,condition);
			
			//找出执行中的
			condition = new V_order_masterBean();
			condition.setInvalid("0");
			condition.setRepair_userkey(order_master.getRepair_userkey());
			condition.setStatus("30");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus30 = dao.finder(orderByMap,condition);
			
			//拼接
			res=restatus10;
			res.addAll(restatus30);
			
			if (null != res) {
				for (int i = 0; i < res.size(); i++) {
					Order_masters dto = new Order_masters();
					BeanUtils.copyProperties(res.get(i), dto);
					dto=OrderInfo(dto);
					V_order_taskBatisDao v_order_taskBatisDao= V_order_taskUtility.getIocHandel().getBean(
							"V_order_taskBatisDao", V_order_taskBatisDao.class);
					V_order_taskBean v_order_taskBean=new V_order_taskBean();
					v_order_taskBean.setOrderkey(dto.getId());
					List<V_order_taskBean>  list=v_order_taskBatisDao.finder(v_order_taskBean);
					if(list.size()>0){
						V_order_taskBean order_taskBean=list.get(0);
						dto.setTask_user_name(order_taskBean.getUser_name());
						dto.setTask_userid(order_taskBean.getUser_id());
						UserBatisDao userDao=UserUtility.getIocHandel().getBean(
								"UserBatisDao", UserBatisDao.class);
						UserBean userBean=new UserBean();
						userBean.setUserid(order_taskBean.getUser_id());
						List<UserBean>  listUser=userDao.finder(userBean);
						if(listUser.size()>0){
							dto.setTask_usericon(listUser.get(0).getIcon());
						}
						TaskBatisDao taskDao=TaskUtility.getIocHandel().getBean(
								"TaskBatisDao", TaskBatisDao.class);
						TaskBean taskBean=taskDao.findByKey(order_taskBean.getTaskkey());
						Task task=new Task();
						BeanUtils.copyProperties(taskBean, task);
						task=TaskInfo(task);
						dto.setTask(task);
					}
					
					result.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Order_masters> GetOrder_masterAlready(Order_master order_master) {
		List<Order_masters> result = new ArrayList<Order_masters>();

		List<V_order_masterBean> restatus20 = null;
		List<V_order_masterBean> restatus40 = null;
		List<V_order_masterBean> res = null;

		try {
			V_order_masterBatisDao dao = V_order_masterUtility.getIocHandel().getBean(
					"V_order_masterBatisDao", V_order_masterBatisDao.class);
			//找出已结单的
			V_order_masterBean condition = new V_order_masterBean();
			condition.setInvalid("0");
			condition.setRepair_userkey(order_master.getRepair_userkey());
			condition.setStatus("20");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus20 = dao.finder(orderByMap,condition);
			
			//找出执行中的
			condition = new V_order_masterBean();
			condition.setInvalid("0");
			condition.setRepair_userkey(order_master.getRepair_userkey());
			condition.setStatus("40");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus40 = dao.finder(orderByMap,condition);
			
			//拼接
			res=restatus20;
			res.addAll(restatus40);
			
			if (null != res) {
				for (int i = 0; i < res.size(); i++) {
					Order_masters dto = new Order_masters();
					BeanUtils.copyProperties(res.get(i), dto);
					dto=OrderInfo(dto);
					V_order_taskBatisDao v_order_taskBatisDao= V_order_taskUtility.getIocHandel().getBean(
							"V_order_taskBatisDao", V_order_taskBatisDao.class);
					V_order_taskBean v_order_taskBean=new V_order_taskBean();
					v_order_taskBean.setOrderkey(dto.getId());
					List<V_order_taskBean>  list=v_order_taskBatisDao.finder(v_order_taskBean);
					if(list.size()>0){
						V_order_taskBean order_taskBean=list.get(0);
						dto.setTask_user_name(order_taskBean.getUser_name());
						dto.setTask_userid(order_taskBean.getUser_id());
						UserBatisDao userDao=UserUtility.getIocHandel().getBean(
								"UserBatisDao", UserBatisDao.class);
						UserBean userBean=new UserBean();
						userBean.setUserid(order_taskBean.getUser_id());
						List<UserBean>  listUser=userDao.finder(userBean);
						if(listUser.size()>0){
							dto.setTask_usericon(listUser.get(0).getIcon());
						}
						TaskBatisDao taskDao=TaskUtility.getIocHandel().getBean(
								"TaskBatisDao", TaskBatisDao.class);
						TaskBean taskBean=taskDao.findByKey(order_taskBean.getTaskkey());
						Task task=new Task();
						BeanUtils.copyProperties(taskBean, task);
						task=TaskInfo(task);
						dto.setTask(task);
					}
					
					result.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 将code转换成中文传输给客户端
	private Order_masters OrderInfo(Order_masters order_masters) {
		Order_masterAction order_masterAction = new Order_masterAction();


		if (order_masters.getStatus() != null && !order_masters.getStatus().equals("")) {
			order_masterAction.statusMap = Utilities.csi
					.getLinkedHashMap_String_String();
			CommonMethod.getSelectMap(order_masterAction.statusMap, "1007");// 接单状态：1007
			order_masters.setStatusName(Utilities.getWrapperSelect(order_masters.getStatus(),
					order_masterAction.statusMap));
		}

		return order_masters;
	}
	// 将code转换成中文传输给客户端
	private Task TaskInfo(Task tasks) {
		TaskAction taskAction = new TaskAction();
		Re_serveAction re_serveAction = new Re_serveAction();

		if (tasks.getCategory() != null && !tasks.getCategory().equals("")) {
			re_serveAction.varietiesMap = Utilities.csi
					.getLinkedHashMap_String_String();
			CommonMethod.getSelectMap(re_serveAction.varietiesMap, "1005");// 任务区分：1004
			tasks.setCategoryName(Utilities.getWrapperSelect(
					tasks.getCategory(), re_serveAction.varietiesMap));
		}

		if (tasks.getStatus() != null && !tasks.getStatus().equals("")) {
			taskAction.statusMap = Utilities.csi
					.getLinkedHashMap_String_String();
			CommonMethod.getSelectMap(taskAction.statusMap, "1006");// 任务状态：1006
			tasks.setStatusName(Utilities.getWrapperSelect(tasks.getStatus(),
					taskAction.statusMap));
		}

		return tasks;
	}
	@Override
	public Callback UpdateOrder_taskTo_30(Order_masters order_masters) {
		int result=1;
		Order_masterBean order_masterBean=new Order_masterBean();
		BeanUtils.copyProperties(order_masters, order_masterBean);
		order_masterBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
		order_masterBean.setStatus("30");
		Order_masterBatisDao order_masterBatisDao= Order_masterUtility.getIocHandel().getBean(
				"Order_masterBatisDao", Order_masterBatisDao.class);
		result=order_masterBatisDao.updateByKey(order_masterBean);
		//更新任务到进行中
		TaskBean taskBean=new TaskBean();
		BeanUtils.copyProperties(order_masters.getTask(), taskBean);
		TaskBatisDao taskBatisDao= TaskUtility.getIocHandel().getBean(
				"TaskBatisDao", TaskBatisDao.class);
		taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
		taskBean.setStatus("20");
		taskBean.setServerkey(order_masters.getTask().getCategory());
		result=taskBatisDao.updateByKey(taskBean);
		Callback callback=new Callback();
		if(result==1){
			callback.setResult(true);
		}else{
			callback.setResult(false);
		}
		
		return callback;
	}
}
