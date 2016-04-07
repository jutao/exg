package edu.jt.exg.logic.order_task;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Order_taskAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Order_taskAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Order_taskAction order_taskAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			order_taskAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			order_taskAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			order_taskAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(order_taskAction.start==null) order_taskAction.start="0";
        else if(order_taskAction.start.length()==0) order_taskAction.start="0";
        if(order_taskAction.range==null) order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(order_taskAction.range.length()==0) order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(order_taskAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Order_taskAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Order_taskAction order_taskAction){
    	//获取记录范围*************************************************
    	order_taskAction.action=order_taskAction.request.getParameter("action");
        if(order_taskAction.start==null) order_taskAction.start="0";
        else if(order_taskAction.start.length()==0) order_taskAction.start="0";
        if(order_taskAction.range==null) order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(order_taskAction.range.length()==0) order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(order_taskAction);
    }
    
    /**
	 * 设置排序
	 * @param Order_taskAction action句柄
	 */
    private void setOrderByMap(Order_taskAction order_taskAction){
        order_taskAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Order_taskSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Order_taskAction action句柄
	 */
	public void setControlsValues(Order_taskAction order_taskAction){
			InitPageControl.initInvalidMap(order_taskAction);
		InitPageControl.initTimestamp(order_taskAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Order_taskAction action句柄
	 * @param params 设置参数
	 */
	public Order_taskBean getQueryConditionsFromParams(Order_taskAction order_taskAction,String params){
		Order_taskBean order_taskBean=Order_taskUtility.getIocHandel().getBean("Order_taskBean",Order_taskBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("taskkey=")==0){
			pos=tmp.indexOf("taskkey=");
			order_taskBean.setTaskkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("orderkey=")==0){
			pos=tmp.indexOf("orderkey=");
			order_taskBean.setOrderkey(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			order_taskBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			order_taskBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			order_taskBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			order_taskBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			order_taskBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return order_taskBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param Order_taskAction action句柄
	 */
	public Order_taskBean getQueryConditionsFromForm(Order_taskAction order_taskAction){
		Order_taskBean order_taskBean=Order_taskUtility.getIocHandel().getBean("Order_taskBean",Order_taskBean.class);
		order_taskBean=setOrder_taskBeanCommonAttributes(order_taskBean,order_taskAction);
				order_taskAction.register_timeFrom=Utilities.setTimeStampFunction(order_taskAction.register_timeDateFrom,order_taskAction.register_timeHourFrom,order_taskAction.register_timeMinuteFrom);
		order_taskBean.setRegister_timeFrom(order_taskAction.register_timeFrom);
		order_taskAction.register_timeTo=Utilities.setTimeStampFunction(order_taskAction.register_timeDateTo,order_taskAction.register_timeHourTo,order_taskAction.register_timeMinuteTo);
		order_taskBean.setRegister_timeTo(order_taskAction.register_timeTo);
		order_taskAction.update_timeFrom=Utilities.setTimeStampFunction(order_taskAction.update_timeDateFrom,order_taskAction.update_timeHourFrom,order_taskAction.update_timeMinuteFrom);
		order_taskBean.setUpdate_timeFrom(order_taskAction.update_timeFrom);
		order_taskAction.update_timeTo=Utilities.setTimeStampFunction(order_taskAction.update_timeDateTo,order_taskAction.update_timeHourTo,order_taskAction.update_timeMinuteTo);
		order_taskBean.setUpdate_timeTo(order_taskAction.update_timeTo);

		return order_taskBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Order_taskAction action句柄
	 */
	public String readControlsWrite2Datas(Order_taskAction order_taskAction){
		String errorMsg="";
				Order_taskBean order_taskBean=Order_taskUtility.getIocHandel().getBean("Order_taskBean",Order_taskBean.class);
		if(order_taskAction.action.equals("create")) order_taskBean.setId(Utilities.getRandomPK(true));
		else order_taskBean.setId(order_taskAction.id);
		order_taskBean=setOrder_taskBeanCommonAttributes(order_taskBean,order_taskAction);
		order_taskBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		order_taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		order_taskAction.batisDao=Order_taskUtility.getIocHandel().getBean("Order_taskBatisDao",Order_taskBatisDao.class);
		if(order_taskAction.action.equals("create")) errorMsg=Integer.toString(order_taskAction.batisDao.insert(order_taskBean));
		else errorMsg=Integer.toString(order_taskAction.batisDao.updateByKey(order_taskBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param Order_taskAction action句柄
	 */
	public void readDatasWrite2Controls(Order_taskAction order_taskAction){
		
		
		
		
		
		
		order_taskAction.batisDao=Order_taskUtility.getIocHandel().getBean("Order_taskBatisDao",Order_taskBatisDao.class);
		Order_taskBean order_taskBean=order_taskAction.batisDao.findByKey(order_taskAction.id);
		
		
		
		write2ControlsCommon(order_taskAction,order_taskBean);
				//auto timestamp
		if(order_taskAction.action.equals("detail")) order_taskAction.setRegister_time(order_taskBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(order_taskAction.action.equals("detail")) order_taskAction.setUpdate_time(order_taskBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param Order_taskAction action句柄
	 * @param Order_taskBean action句柄
	 */
	public void readConditionsWrite2Controls(Order_taskAction order_taskAction,Order_taskBean order_taskBean){
		write2ControlsCommon(order_taskAction,order_taskBean);
				if(order_taskBean.getRegister_timeFrom()!=null){
			order_taskAction.setRegister_timeFrom(order_taskBean.getRegister_timeFrom());
			order_taskAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(order_taskBean.getRegister_timeFrom()));
			cale.setTimeInMillis(order_taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_taskAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_taskAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			order_taskAction.setRegister_timeHourSelectFrom(order_taskAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) order_taskAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_taskAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			order_taskAction.setRegister_timeMinuteSelectFrom(order_taskAction.register_timeMinuteFrom);
		}
		if(order_taskBean.getRegister_timeTo()!=null){
			order_taskAction.setRegister_timeTo(order_taskBean.getRegister_timeTo());
			order_taskAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(order_taskBean.getRegister_timeTo()));
			cale.setTimeInMillis(order_taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_taskAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_taskAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			order_taskAction.setRegister_timeHourSelectTo(order_taskAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) order_taskAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_taskAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			order_taskAction.setRegister_timeMinuteSelectTo(order_taskAction.register_timeMinuteTo);
		}
		if(order_taskBean.getUpdate_timeFrom()!=null){
			order_taskAction.setUpdate_timeFrom(order_taskBean.getUpdate_timeFrom());
			order_taskAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(order_taskBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(order_taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_taskAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_taskAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			order_taskAction.setUpdate_timeHourSelectFrom(order_taskAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) order_taskAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_taskAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			order_taskAction.setUpdate_timeMinuteSelectFrom(order_taskAction.update_timeMinuteFrom);
		}
		if(order_taskBean.getUpdate_timeTo()!=null){
			order_taskAction.setUpdate_timeTo(order_taskBean.getUpdate_timeTo());
			order_taskAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(order_taskBean.getUpdate_timeTo()));
			cale.setTimeInMillis(order_taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_taskAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_taskAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			order_taskAction.setUpdate_timeHourSelectTo(order_taskAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) order_taskAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_taskAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			order_taskAction.setUpdate_timeMinuteSelectTo(order_taskAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param Order_taskAction action句柄
	 * @param Order_taskBean action句柄
	 * @param type 控件类型
	 */
	public Order_taskBean wrapperOrder_taskBean(Order_taskAction order_taskAction,Order_taskBean order_taskBean,String type){
				//s:select***************************************************************************
		InitPageControl.initInvalidMap(order_taskAction);
		order_taskBean.setInvalid(Utilities.getWrapperSelect(order_taskBean.getInvalid(),order_taskAction.invalidMap));

		return order_taskBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Order_taskAction action句柄
	 * @param type 控件类型
	 */
    public List<Order_taskBean> wrapperRecorders(Order_taskAction order_taskAction,String type){
    	Order_taskBean order_task=null;
    	List<Order_taskBean> newOrder_taskList=Order_taskUtility.getIocHandel().getBean("List_Order_taskBean",java.util.ArrayList.class);
    	for(int i=0;i<order_taskAction.order_taskList.size();i++){
    		order_task=order_taskAction.order_taskList.get(i);
    		order_task=wrapperOrder_taskBean(order_taskAction,order_task,type);
    		newOrder_taskList.add(order_task);
    	}
    	return newOrder_taskList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param Order_taskAction action句柄
	 * @param Order_taskBean action句柄
	 */
	private void write2ControlsCommon(Order_taskAction order_taskAction,Order_taskBean order_taskBean){
		order_taskAction.setId(order_taskBean.getId());
				//textfield
		if(order_taskBean.getTaskkey()!=null)
			if(order_taskBean.getTaskkey().trim().length()>0) order_taskAction.setTaskkey(order_taskBean.getTaskkey());
		//textfield
		if(order_taskBean.getOrderkey()!=null)
			if(order_taskBean.getOrderkey().trim().length()>0) order_taskAction.setOrderkey(order_taskBean.getOrderkey());
		//select
		if(order_taskBean.getInvalid()!=null){
			if(order_taskBean.getInvalid().trim().length()>0){
				if(!order_taskAction.action.equals("detail")){
					order_taskAction.setInvalid(order_taskBean.getInvalid());
					order_taskAction.setInvalidSelect(order_taskBean.getInvalid());
				}else order_taskAction.setInvalid(Utilities.getWrapperSelect(order_taskBean.getInvalid(),order_taskAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param Order_taskBean action句柄
	 * @param Order_taskAction action句柄
	 */
	private Order_taskBean setOrder_taskBeanCommonAttributes(Order_taskBean order_taskBean,Order_taskAction order_taskAction){
				order_taskBean.setTaskkey(order_taskAction.taskkey);
		order_taskBean.setOrderkey(order_taskAction.orderkey);
		order_taskBean.setInvalid(order_taskAction.invalid);

		return order_taskBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param order_taskQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Order_taskBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getTaskkey().trim().length()>0)
			paramStr.append("&taskkey=").append(queryConditionsBean.getTaskkey().trim());
		if(queryConditionsBean.getOrderkey().trim().length()>0)
			paramStr.append("&orderkey=").append(queryConditionsBean.getOrderkey().trim());
		if(queryConditionsBean.getInvalid()!=null)
			if(queryConditionsBean.getInvalid().trim().length()>0)
				paramStr.append("&invalid=").append(queryConditionsBean.getInvalid().trim());
		if(queryConditionsBean.getRegister_timeFrom()!=null)
				paramStr.append("&register_timeFrom=").append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getRegister_timeFrom()));
		if(queryConditionsBean.getRegister_timeTo()!=null)
				paramStr.append("&register_timeTo=").append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getRegister_timeTo()));
		if(queryConditionsBean.getUpdate_timeFrom()!=null)
				paramStr.append("&update_timeFrom=").append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getUpdate_timeFrom()));
		if(queryConditionsBean.getUpdate_timeTo()!=null)
				paramStr.append("&update_timeTo=").append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getUpdate_timeTo()));

		return paramStr.toString();
	}
}