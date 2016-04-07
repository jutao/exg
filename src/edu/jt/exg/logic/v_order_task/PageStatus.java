package edu.jt.exg.logic.v_order_task;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.V_order_taskAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_order_taskAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(V_order_taskAction v_order_taskAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			v_order_taskAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			v_order_taskAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			v_order_taskAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(v_order_taskAction.start==null) v_order_taskAction.start="0";
        else if(v_order_taskAction.start.length()==0) v_order_taskAction.start="0";
        if(v_order_taskAction.range==null) v_order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_order_taskAction.range.length()==0) v_order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_order_taskAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_order_taskAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(V_order_taskAction v_order_taskAction){
    	//获取记录范围*************************************************
    	v_order_taskAction.action=v_order_taskAction.request.getParameter("action");
        if(v_order_taskAction.start==null) v_order_taskAction.start="0";
        else if(v_order_taskAction.start.length()==0) v_order_taskAction.start="0";
        if(v_order_taskAction.range==null) v_order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_order_taskAction.range.length()==0) v_order_taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_order_taskAction);
    }
    
    /**
	 * 设置排序
	 * @param V_order_taskAction action句柄
	 */
    private void setOrderByMap(V_order_taskAction v_order_taskAction){
        v_order_taskAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(V_order_taskSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param V_order_taskAction action句柄
	 */
	public void setControlsValues(V_order_taskAction v_order_taskAction){
			InitPageControl.initTimestamp(v_order_taskAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param V_order_taskAction action句柄
	 * @param params 设置参数
	 */
	public V_order_taskBean getQueryConditionsFromParams(V_order_taskAction v_order_taskAction,String params){
		V_order_taskBean v_order_taskBean=V_order_taskUtility.getIocHandel().getBean("V_order_taskBean",V_order_taskBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("taskkey=")==0){
			pos=tmp.indexOf("taskkey=");
			v_order_taskBean.setTaskkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("orderkey=")==0){
			pos=tmp.indexOf("orderkey=");
			v_order_taskBean.setOrderkey(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			v_order_taskBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			v_order_taskBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_order_taskBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_order_taskBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			v_order_taskBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("req_name=")==0){
			pos=tmp.indexOf("req_name=");
			v_order_taskBean.setReq_name(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("req_id=")==0){
			pos=tmp.indexOf("req_id=");
			v_order_taskBean.setReq_id(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("user_id=")==0){
			pos=tmp.indexOf("user_id=");
			v_order_taskBean.setUser_id(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("user_name=")==0){
			pos=tmp.indexOf("user_name=");
			v_order_taskBean.setUser_name(tmp.substring(pos+10,tmp.length()));
		}

		}
		return v_order_taskBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param V_order_taskAction action句柄
	 */
	public V_order_taskBean getQueryConditionsFromForm(V_order_taskAction v_order_taskAction){
		V_order_taskBean v_order_taskBean=V_order_taskUtility.getIocHandel().getBean("V_order_taskBean",V_order_taskBean.class);
		v_order_taskBean=setV_order_taskBeanCommonAttributes(v_order_taskBean,v_order_taskAction);
				v_order_taskAction.register_timeFrom=Utilities.setTimeStampFunction(v_order_taskAction.register_timeDateFrom,v_order_taskAction.register_timeHourFrom,v_order_taskAction.register_timeMinuteFrom);
		v_order_taskBean.setRegister_timeFrom(v_order_taskAction.register_timeFrom);
		v_order_taskAction.register_timeTo=Utilities.setTimeStampFunction(v_order_taskAction.register_timeDateTo,v_order_taskAction.register_timeHourTo,v_order_taskAction.register_timeMinuteTo);
		v_order_taskBean.setRegister_timeTo(v_order_taskAction.register_timeTo);
		v_order_taskAction.update_timeFrom=Utilities.setTimeStampFunction(v_order_taskAction.update_timeDateFrom,v_order_taskAction.update_timeHourFrom,v_order_taskAction.update_timeMinuteFrom);
		v_order_taskBean.setUpdate_timeFrom(v_order_taskAction.update_timeFrom);
		v_order_taskAction.update_timeTo=Utilities.setTimeStampFunction(v_order_taskAction.update_timeDateTo,v_order_taskAction.update_timeHourTo,v_order_taskAction.update_timeMinuteTo);
		v_order_taskBean.setUpdate_timeTo(v_order_taskAction.update_timeTo);

		return v_order_taskBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param V_order_taskAction action句柄
	 */
	public String readControlsWrite2Datas(V_order_taskAction v_order_taskAction){
		String errorMsg="";
				V_order_taskBean v_order_taskBean=V_order_taskUtility.getIocHandel().getBean("V_order_taskBean",V_order_taskBean.class);
		if(v_order_taskAction.action.equals("create")) v_order_taskBean.setId(Utilities.getRandomPK(true));
		else v_order_taskBean.setId(v_order_taskAction.id);
		v_order_taskBean=setV_order_taskBeanCommonAttributes(v_order_taskBean,v_order_taskAction);
		v_order_taskBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		v_order_taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		v_order_taskAction.batisDao=V_order_taskUtility.getIocHandel().getBean("V_order_taskBatisDao",V_order_taskBatisDao.class);
		if(v_order_taskAction.action.equals("create")) errorMsg=Integer.toString(v_order_taskAction.batisDao.insert(v_order_taskBean));
		else errorMsg=Integer.toString(v_order_taskAction.batisDao.updateByKey(v_order_taskBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param V_order_taskAction action句柄
	 */
	public void readDatasWrite2Controls(V_order_taskAction v_order_taskAction){
		
		
		
		
		
		
		v_order_taskAction.batisDao=V_order_taskUtility.getIocHandel().getBean("V_order_taskBatisDao",V_order_taskBatisDao.class);
		V_order_taskBean v_order_taskBean=v_order_taskAction.batisDao.findByKey(v_order_taskAction.id);
		
		
		
		write2ControlsCommon(v_order_taskAction,v_order_taskBean);
				//auto timestamp
		if(v_order_taskAction.action.equals("detail")) v_order_taskAction.setRegister_time(v_order_taskBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(v_order_taskAction.action.equals("detail")) v_order_taskAction.setUpdate_time(v_order_taskBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param V_order_taskAction action句柄
	 * @param V_order_taskBean action句柄
	 */
	public void readConditionsWrite2Controls(V_order_taskAction v_order_taskAction,V_order_taskBean v_order_taskBean){
		write2ControlsCommon(v_order_taskAction,v_order_taskBean);
				if(v_order_taskBean.getRegister_timeFrom()!=null){
			v_order_taskAction.setRegister_timeFrom(v_order_taskBean.getRegister_timeFrom());
			v_order_taskAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(v_order_taskBean.getRegister_timeFrom()));
			cale.setTimeInMillis(v_order_taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_taskAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_taskAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_taskAction.setRegister_timeHourSelectFrom(v_order_taskAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_order_taskAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_taskAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_taskAction.setRegister_timeMinuteSelectFrom(v_order_taskAction.register_timeMinuteFrom);
		}
		if(v_order_taskBean.getRegister_timeTo()!=null){
			v_order_taskAction.setRegister_timeTo(v_order_taskBean.getRegister_timeTo());
			v_order_taskAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(v_order_taskBean.getRegister_timeTo()));
			cale.setTimeInMillis(v_order_taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_taskAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_taskAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_taskAction.setRegister_timeHourSelectTo(v_order_taskAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_order_taskAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_taskAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_taskAction.setRegister_timeMinuteSelectTo(v_order_taskAction.register_timeMinuteTo);
		}
		if(v_order_taskBean.getUpdate_timeFrom()!=null){
			v_order_taskAction.setUpdate_timeFrom(v_order_taskBean.getUpdate_timeFrom());
			v_order_taskAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(v_order_taskBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(v_order_taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_taskAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_taskAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_taskAction.setUpdate_timeHourSelectFrom(v_order_taskAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_order_taskAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_taskAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_taskAction.setUpdate_timeMinuteSelectFrom(v_order_taskAction.update_timeMinuteFrom);
		}
		if(v_order_taskBean.getUpdate_timeTo()!=null){
			v_order_taskAction.setUpdate_timeTo(v_order_taskBean.getUpdate_timeTo());
			v_order_taskAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(v_order_taskBean.getUpdate_timeTo()));
			cale.setTimeInMillis(v_order_taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_taskAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_taskAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_taskAction.setUpdate_timeHourSelectTo(v_order_taskAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_order_taskAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_taskAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_taskAction.setUpdate_timeMinuteSelectTo(v_order_taskAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param V_order_taskAction action句柄
	 * @param V_order_taskBean action句柄
	 * @param type 控件类型
	 */
	public V_order_taskBean wrapperV_order_taskBean(V_order_taskAction v_order_taskAction,V_order_taskBean v_order_taskBean,String type){
		
		return v_order_taskBean;
	}
	
	/**
	 * 记录显示包装
	 * @param V_order_taskAction action句柄
	 * @param type 控件类型
	 */
    public List<V_order_taskBean> wrapperRecorders(V_order_taskAction v_order_taskAction,String type){
    	V_order_taskBean v_order_task=null;
    	List<V_order_taskBean> newV_order_taskList=V_order_taskUtility.getIocHandel().getBean("List_V_order_taskBean",java.util.ArrayList.class);
    	for(int i=0;i<v_order_taskAction.v_order_taskList.size();i++){
    		v_order_task=v_order_taskAction.v_order_taskList.get(i);
    		v_order_task=wrapperV_order_taskBean(v_order_taskAction,v_order_task,type);
    		newV_order_taskList.add(v_order_task);
    	}
    	return newV_order_taskList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param V_order_taskAction action句柄
	 * @param V_order_taskBean action句柄
	 */
	private void write2ControlsCommon(V_order_taskAction v_order_taskAction,V_order_taskBean v_order_taskBean){
		v_order_taskAction.setId(v_order_taskBean.getId());
				//textfield
		if(v_order_taskBean.getTaskkey()!=null)
			if(v_order_taskBean.getTaskkey().trim().length()>0) v_order_taskAction.setTaskkey(v_order_taskBean.getTaskkey());
		//textfield
		if(v_order_taskBean.getOrderkey()!=null)
			if(v_order_taskBean.getOrderkey().trim().length()>0) v_order_taskAction.setOrderkey(v_order_taskBean.getOrderkey());
		//textfield
		if(v_order_taskBean.getInvalid()!=null)
			if(v_order_taskBean.getInvalid().trim().length()>0) v_order_taskAction.setInvalid(v_order_taskBean.getInvalid());
		//textfield
		if(v_order_taskBean.getReq_name()!=null)
			if(v_order_taskBean.getReq_name().trim().length()>0) v_order_taskAction.setReq_name(v_order_taskBean.getReq_name());
		//textfield
		if(v_order_taskBean.getReq_id()!=null)
			if(v_order_taskBean.getReq_id().trim().length()>0) v_order_taskAction.setReq_id(v_order_taskBean.getReq_id());
		//textfield
		if(v_order_taskBean.getUser_id()!=null)
			if(v_order_taskBean.getUser_id().trim().length()>0) v_order_taskAction.setUser_id(v_order_taskBean.getUser_id());
		//textfield
		if(v_order_taskBean.getUser_name()!=null)
			if(v_order_taskBean.getUser_name().trim().length()>0) v_order_taskAction.setUser_name(v_order_taskBean.getUser_name());

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param V_order_taskBean action句柄
	 * @param V_order_taskAction action句柄
	 */
	private V_order_taskBean setV_order_taskBeanCommonAttributes(V_order_taskBean v_order_taskBean,V_order_taskAction v_order_taskAction){
				v_order_taskBean.setTaskkey(v_order_taskAction.taskkey);
		v_order_taskBean.setOrderkey(v_order_taskAction.orderkey);
		v_order_taskBean.setInvalid(v_order_taskAction.invalid);
		v_order_taskBean.setReq_name(v_order_taskAction.req_name);
		v_order_taskBean.setReq_id(v_order_taskAction.req_id);
		v_order_taskBean.setUser_id(v_order_taskAction.user_id);
		v_order_taskBean.setUser_name(v_order_taskAction.user_name);

		return v_order_taskBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param v_order_taskQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(V_order_taskBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getTaskkey().trim().length()>0)
			paramStr.append("&taskkey=").append(queryConditionsBean.getTaskkey().trim());
		if(queryConditionsBean.getOrderkey().trim().length()>0)
			paramStr.append("&orderkey=").append(queryConditionsBean.getOrderkey().trim());
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
		if(queryConditionsBean.getReq_name().trim().length()>0)
			paramStr.append("&req_name=").append(queryConditionsBean.getReq_name().trim());
		if(queryConditionsBean.getReq_id().trim().length()>0)
			paramStr.append("&req_id=").append(queryConditionsBean.getReq_id().trim());
		if(queryConditionsBean.getUser_id().trim().length()>0)
			paramStr.append("&user_id=").append(queryConditionsBean.getUser_id().trim());
		if(queryConditionsBean.getUser_name().trim().length()>0)
			paramStr.append("&user_name=").append(queryConditionsBean.getUser_name().trim());

		return paramStr.toString();
	}
}