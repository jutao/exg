package edu.jt.exg.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;

import utility.CommonMethod;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Re_serveAction;
import edu.jt.exg.action.TaskAction;
import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.Order_masters;
import edu.jt.exg.dto.Task;
import edu.jt.exg.dto.Tasks;
import edu.jt.exg.dto.V_task;
import edu.jt.exg.logic.order_master.Order_masterBatisDao;
import edu.jt.exg.logic.order_master.Order_masterBean;
import edu.jt.exg.logic.order_master.Order_masterUtility;
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

public class TaskServiceImpl implements TaskService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 记录起始读取位置
	 */
	public String start = null;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * 记录范围
	 */
	public String range = ConstSetup.REFERENCE_RANGE;

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	/**
	 * 排序规则
	 */
	public LinkedHashMap<String, String> orderByMap = null;

	@Override
	public Callback CreateTask(Task task) {
		Callback callback = new Callback();
		//检查是否有发布了还未被解决的任务
		TaskBatisDao dao = TaskUtility.getIocHandel().getBean("TaskBatisDao",
				TaskBatisDao.class);
		TaskBean status10=new TaskBean();
		TaskBean status20=new TaskBean();
		status10.setUserkey(task.getUserkey());
		status10.setStatus("10");
		status20.setUserkey(task.getUserkey());
		status20.setStatus("20");
		List<TaskBean> status10s=dao.finder(status10);
		List<TaskBean> status20s=dao.finder(status20);
		if(status10s.size()!=0||status20s.size()!=0){
			callback.setCode(500);
			callback.setResult(false);
			return callback;
		}
		
		TaskBean taskBean = new TaskBean();
		
		String id="";
		if (null != task) {
			BeanUtils.copyProperties(task, taskBean);
			taskBean.setId(Utilities.getRandomPK(true));
			id=taskBean.getId();
			taskBean.setStatus("10");
			taskBean.setInvalid("0");
			//这里用searverKey来代替category
			taskBean.setServerkey(task.getCategory());
			if (task.getTip() == null) {
				taskBean.setTip(0.00);
			}
			if (task.getEpson() == null) {
				taskBean.setEpson(0.00);
			}
			taskBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
			taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

			int result = dao.insert(taskBean);
			if (result == 0) {
				callback.setResult(false);
			} else {
				callback.setResult(true);
				callback.setMessage(id);
			}
		} else {
			callback.setResult(false);
		}
		return callback;
	}

	@Override
	public List<Tasks> GetTask(Task task) {

		List<Tasks> result = new ArrayList<Tasks>();

		List<V_taskBean> res = null;

		try {
			V_taskBatisDao dao = V_taskUtility.getIocHandel().getBean(
					"V_taskBatisDao", V_taskBatisDao.class);
		
			V_taskBean condition = new V_taskBean();
			condition.setInvalid("0");
			condition.setServerkey(task.getCategory());
			BeanUtils.copyProperties(task, condition);
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_taskBatisDao.UPDATE_TIME_DESC, null);
			res = dao.finder(orderByMap,condition);
			if (null != res) {
				for (int i = 0; i < res.size(); i++) {
					Tasks dto = new Tasks();
					BeanUtils.copyProperties(res.get(i), dto);
					dto.setCategory(res.get(i).getServerkey());
					dto = TaskInfo(dto);
					UserBatisDao userDao=UserUtility.getIocHandel().getBean(
							"UserBatisDao", UserBatisDao.class); 
					UserBean userbean=userDao.findByKey(dto.getUserkey());
					dto.setNickname(userbean.getNickname());
					result.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public Callback finderAlTask(Task task) {
		Callback callBack=new Callback();
		TaskBatisDao dao = TaskUtility.getIocHandel().getBean("TaskBatisDao",
				TaskBatisDao.class);
		TaskBean bean=new TaskBean();
		bean.setId(task.getId());
		bean.setStatus("20");
		List<TaskBean> list=dao.finder(bean);
		if(list.size()>0){
			//说明已经被接单
			callBack.setResult(true);
		}else{
			callBack.setResult(false);
		}
		return callBack;
	}
	// 将code转换成中文传输给客户端
	private Tasks TaskInfo(Tasks tasks) {
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
	// 将code转换成中文传输给客户端
	private V_task v_TaskInfo(V_task V_task) {
		TaskAction taskAction = new TaskAction();
		Re_serveAction re_serveAction = new Re_serveAction();
		
		if (V_task.getCategory() != null && !V_task.getCategory().equals("")) {
			re_serveAction.varietiesMap = Utilities.csi
					.getLinkedHashMap_String_String();
			CommonMethod.getSelectMap(re_serveAction.varietiesMap, "1005");// 任务区分：1004
			V_task.setCategoryName(Utilities.getWrapperSelect(
					V_task.getCategory(), re_serveAction.varietiesMap));
		}
		
		if (V_task.getStatus() != null && !V_task.getStatus().equals("")) {
			taskAction.statusMap = Utilities.csi
					.getLinkedHashMap_String_String();
			CommonMethod.getSelectMap(taskAction.statusMap, "1006");// 任务状态：1006
			V_task.setStatusName(Utilities.getWrapperSelect(V_task.getStatus(),
					taskAction.statusMap));
		}
		
		return V_task;
	}

	@Override
	public List<V_task> GetTaskBefore(Task task) {
		List<V_task> result = new ArrayList<V_task>();

		List<V_taskBean> restatus10 = null;
		List<V_taskBean> restatus20 = null;
		List<V_taskBean> res = null;

		try {
			V_taskBatisDao dao = V_taskUtility.getIocHandel().getBean(
					"V_taskBatisDao", V_taskBatisDao.class);
			//找出已结单的
			V_taskBean condition = new V_taskBean();
			condition.setInvalid("0");
			condition.setUserkey(task.getUserkey());
			condition.setStatus("10");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus10 = dao.finder(orderByMap,condition);
			
			//找出执行中的
			condition = new V_taskBean();
			condition.setInvalid("0");
			condition.setUserkey(task.getUserkey());
			condition.setStatus("20");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus20 = dao.finder(orderByMap,condition);
			
			//拼接
			res=restatus10;
			res.addAll(restatus20);
			
			if (null != res) {
				for (int i = 0; i < res.size(); i++) {
					V_task dto = new V_task();
					BeanUtils.copyProperties(res.get(i), dto);
					dto.setCategory(res.get(i).getServerkey());
					dto=v_TaskInfo(dto);
					
					V_order_taskBatisDao order_taskBatisDao=V_order_taskUtility.getIocHandel().getBean(
							"V_order_taskBatisDao", V_order_taskBatisDao.class);
					V_order_taskBean order_task=new V_order_taskBean();
					order_task.setTaskkey(dto.getId());
					List<V_order_taskBean> v_order_tasklist=order_taskBatisDao.finder(order_task);
					if(v_order_tasklist.size()>0){
						V_order_masterBatisDao order_masterDao=V_order_masterUtility.getIocHandel().getBean(
								"V_order_masterBatisDao", V_order_masterBatisDao.class);
						V_order_masterBean order_master=order_masterDao.findByKey(v_order_tasklist.get(0).getOrderkey());
						if(order_master!=null){
							dto.setReq_icon(order_master.getReq_icon());
							dto.setReq_id(order_master.getReq_id());
							dto.setReq_name(order_master.getReq_name());
						}
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
	public List<V_task> GetTaskAlerdy(Task task) {
		List<V_task> result = new ArrayList<V_task>();

		List<V_taskBean> restatus30 = null;
		List<V_taskBean> restatus40 = null;
		List<V_taskBean> res = null;

		try {
			V_taskBatisDao dao = V_taskUtility.getIocHandel().getBean(
					"V_taskBatisDao", V_taskBatisDao.class);
			//找出已结单的
			V_taskBean condition = new V_taskBean();
			condition.setInvalid("0");
			condition.setUserkey(task.getUserkey());
			condition.setStatus("30");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus30 = dao.finder(orderByMap,condition);
			
			//找出执行中的
			condition = new V_taskBean();
			condition.setInvalid("0");
			condition.setUserkey(task.getUserkey());
			condition.setStatus("40");
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(V_order_masterBatisDao.UPDATE_TIME_DESC, null);
			restatus40 = dao.finder(orderByMap,condition);
			
			//拼接
			res=restatus30;
			res.addAll(restatus40);
			
			if (null != res) {
				for (int i = 0; i < res.size(); i++) {
					V_task dto = new V_task();
					BeanUtils.copyProperties(res.get(i), dto);
					dto.setCategory(res.get(i).getServerkey());
					dto=v_TaskInfo(dto);
					
					V_order_taskBatisDao order_taskBatisDao=V_order_taskUtility.getIocHandel().getBean(
							"V_order_taskBatisDao", V_order_taskBatisDao.class);
					V_order_taskBean order_task=new V_order_taskBean();
					//设置任务接单表的任务key
					order_task.setTaskkey(dto.getId());
					List<V_order_taskBean> v_order_tasklist=order_taskBatisDao.finder(order_task);
					if(v_order_tasklist.size()>0){
						V_order_masterBatisDao order_masterDao=V_order_masterUtility.getIocHandel().getBean(
								"V_order_masterBatisDao", V_order_masterBatisDao.class);
						V_order_masterBean order_master=order_masterDao.findByKey(v_order_tasklist.get(0).getOrderkey());
						if(order_master!=null){
							dto.setReq_icon(order_master.getReq_icon());
							dto.setReq_id(order_master.getReq_id());
							dto.setReq_name(order_master.getReq_name());
						}
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
	public Callback UpDateTask(V_task v_task) {
		int result=1;
		
		TaskBean taskBean=new TaskBean();
		BeanUtils.copyProperties(v_task, taskBean);
		taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
		taskBean.setServerkey(v_task.getCategory());
		TaskBatisDao dao=TaskUtility.getIocHandel().getBean(
				"TaskBatisDao", TaskBatisDao.class);
		
		result=dao.updateByKey(taskBean);
		
		V_order_masterBatisDao masterDao=V_order_masterUtility.getIocHandel().getBean(
				"V_order_masterBatisDao", V_order_masterBatisDao.class);
		V_order_masterBean v_order_master=new V_order_masterBean();
		v_order_master.setReq_id(v_task.getReq_id());
		v_order_master.setReq_name(v_task.getReq_name());
		v_order_master.setStatus("30");
		List<V_order_masterBean> v_Order_masters=masterDao.finder(v_order_master);
		if(v_Order_masters.size()>0){
			Order_masterBatisDao masterdao=Order_masterUtility.getIocHandel().getBean(
					"Order_masterBatisDao", Order_masterBatisDao.class);
			Order_masterBean orderBean=masterdao.findByKey(v_Order_masters.get(0).getId());
			orderBean.setStatus("20");
			orderBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
			result=masterdao.updateByKey(orderBean);
		}
		Callback callback=new Callback();
		if(result==1){
			callback.setResult(true);
		}else{
			callback.setResult(false);
		}
		return callback;
	}
}
