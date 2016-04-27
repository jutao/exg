package edu.jt.exg.logic.v_order_master;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.V_order_masterAction;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_order_masterAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(V_order_masterAction v_order_masterAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			v_order_masterAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			v_order_masterAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			v_order_masterAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(v_order_masterAction.start==null) v_order_masterAction.start="0";
        else if(v_order_masterAction.start.length()==0) v_order_masterAction.start="0";
        if(v_order_masterAction.range==null) v_order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_order_masterAction.range.length()==0) v_order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_order_masterAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_order_masterAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(V_order_masterAction v_order_masterAction){
    	//获取记录范围*************************************************
    	v_order_masterAction.action=v_order_masterAction.request.getParameter("action");
        if(v_order_masterAction.start==null) v_order_masterAction.start="0";
        else if(v_order_masterAction.start.length()==0) v_order_masterAction.start="0";
        if(v_order_masterAction.range==null) v_order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_order_masterAction.range.length()==0) v_order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_order_masterAction);
    }
    
    /**
	 * 设置排序
	 * @param V_order_masterAction action句柄
	 */
    private void setOrderByMap(V_order_masterAction v_order_masterAction){
        v_order_masterAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(V_order_masterSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param V_order_masterAction action句柄
	 */
	public void setControlsValues(V_order_masterAction v_order_masterAction){
			InitPageControl.initTimestamp(v_order_masterAction);
			InitPageControl.initStatusMap(v_order_masterAction);
			InitPageControl.initInvalidMap(v_order_masterAction);
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param V_order_masterAction action句柄
	 * @param params 设置参数
	 */
	public V_order_masterBean getQueryConditionsFromParams(V_order_masterAction v_order_masterAction,String params){
		V_order_masterBean v_order_masterBean=V_order_masterUtility.getIocHandel().getBean("V_order_masterBean",V_order_masterBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("orderid=")==0){
			pos=tmp.indexOf("orderid=");
			v_order_masterBean.setOrderid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("repair_userkey=")==0){
			pos=tmp.indexOf("repair_userkey=");
			v_order_masterBean.setRepair_userkey(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("outcome=")==0){
			pos=tmp.indexOf("outcome=");
			v_order_masterBean.setOutcome(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("outcome_image1=")==0){
			pos=tmp.indexOf("outcome_image1=");
			v_order_masterBean.setOutcome_image1(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("outcome_image2=")==0){
			pos=tmp.indexOf("outcome_image2=");
			v_order_masterBean.setOutcome_image2(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("outcome_image3=")==0){
			pos=tmp.indexOf("outcome_image3=");
			v_order_masterBean.setOutcome_image3(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			v_order_masterBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			v_order_masterBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			v_order_masterBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_order_masterBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_order_masterBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			v_order_masterBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("req_name=")==0){
			pos=tmp.indexOf("req_name=");
			v_order_masterBean.setReq_name(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("req_id=")==0){
			pos=tmp.indexOf("req_id=");
			v_order_masterBean.setReq_id(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("req_icon=")==0){
			pos=tmp.indexOf("req_icon=");
			v_order_masterBean.setReq_icon(tmp.substring(pos+9,tmp.length()));
		}

		}
		return v_order_masterBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param V_order_masterAction action句柄
	 */
	public V_order_masterBean getQueryConditionsFromForm(V_order_masterAction v_order_masterAction){
		V_order_masterBean v_order_masterBean=V_order_masterUtility.getIocHandel().getBean("V_order_masterBean",V_order_masterBean.class);
		v_order_masterBean=setV_order_masterBeanCommonAttributes(v_order_masterBean,v_order_masterAction);
				v_order_masterAction.register_timeFrom=Utilities.setTimeStampFunction(v_order_masterAction.register_timeDateFrom,v_order_masterAction.register_timeHourFrom,v_order_masterAction.register_timeMinuteFrom);
		v_order_masterBean.setRegister_timeFrom(v_order_masterAction.register_timeFrom);
		v_order_masterAction.register_timeTo=Utilities.setTimeStampFunction(v_order_masterAction.register_timeDateTo,v_order_masterAction.register_timeHourTo,v_order_masterAction.register_timeMinuteTo);
		v_order_masterBean.setRegister_timeTo(v_order_masterAction.register_timeTo);
		v_order_masterAction.update_timeFrom=Utilities.setTimeStampFunction(v_order_masterAction.update_timeDateFrom,v_order_masterAction.update_timeHourFrom,v_order_masterAction.update_timeMinuteFrom);
		v_order_masterBean.setUpdate_timeFrom(v_order_masterAction.update_timeFrom);
		v_order_masterAction.update_timeTo=Utilities.setTimeStampFunction(v_order_masterAction.update_timeDateTo,v_order_masterAction.update_timeHourTo,v_order_masterAction.update_timeMinuteTo);
		v_order_masterBean.setUpdate_timeTo(v_order_masterAction.update_timeTo);

		return v_order_masterBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param V_order_masterAction action句柄
	 */
	public String readControlsWrite2Datas(V_order_masterAction v_order_masterAction){
		String errorMsg="";
				V_order_masterBean v_order_masterBean=V_order_masterUtility.getIocHandel().getBean("V_order_masterBean",V_order_masterBean.class);
		if(v_order_masterAction.action.equals("create")) v_order_masterBean.setId(Utilities.getRandomPK(true));
		else v_order_masterBean.setId(v_order_masterAction.id);
		v_order_masterBean=setV_order_masterBeanCommonAttributes(v_order_masterBean,v_order_masterAction);
		v_order_masterBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		v_order_masterBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		v_order_masterAction.batisDao=V_order_masterUtility.getIocHandel().getBean("V_order_masterBatisDao",V_order_masterBatisDao.class);
		if(v_order_masterAction.action.equals("create")) errorMsg=Integer.toString(v_order_masterAction.batisDao.insert(v_order_masterBean));
		else errorMsg=Integer.toString(v_order_masterAction.batisDao.updateByKey(v_order_masterBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param V_order_masterAction action句柄
	 */
	public void readDatasWrite2Controls(V_order_masterAction v_order_masterAction){
		
		
		
		
		
		
		v_order_masterAction.batisDao=V_order_masterUtility.getIocHandel().getBean("V_order_masterBatisDao",V_order_masterBatisDao.class);
		V_order_masterBean v_order_masterBean=v_order_masterAction.batisDao.findByKey(v_order_masterAction.id);
		
		
		
		write2ControlsCommon(v_order_masterAction,v_order_masterBean);
				//auto timestamp
		if(v_order_masterAction.action.equals("detail")) v_order_masterAction.setRegister_time(v_order_masterBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(v_order_masterAction.action.equals("detail")) v_order_masterAction.setUpdate_time(v_order_masterBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param V_order_masterAction action句柄
	 * @param V_order_masterBean action句柄
	 */
	public void readConditionsWrite2Controls(V_order_masterAction v_order_masterAction,V_order_masterBean v_order_masterBean){
		write2ControlsCommon(v_order_masterAction,v_order_masterBean);
				if(v_order_masterBean.getRegister_timeFrom()!=null){
			v_order_masterAction.setRegister_timeFrom(v_order_masterBean.getRegister_timeFrom());
			v_order_masterAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(v_order_masterBean.getRegister_timeFrom()));
			cale.setTimeInMillis(v_order_masterBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_masterAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_masterAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_masterAction.setRegister_timeHourSelectFrom(v_order_masterAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_order_masterAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_masterAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_masterAction.setRegister_timeMinuteSelectFrom(v_order_masterAction.register_timeMinuteFrom);
		}
		if(v_order_masterBean.getRegister_timeTo()!=null){
			v_order_masterAction.setRegister_timeTo(v_order_masterBean.getRegister_timeTo());
			v_order_masterAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(v_order_masterBean.getRegister_timeTo()));
			cale.setTimeInMillis(v_order_masterBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_masterAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_masterAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_masterAction.setRegister_timeHourSelectTo(v_order_masterAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_order_masterAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_masterAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_masterAction.setRegister_timeMinuteSelectTo(v_order_masterAction.register_timeMinuteTo);
		}
		if(v_order_masterBean.getUpdate_timeFrom()!=null){
			v_order_masterAction.setUpdate_timeFrom(v_order_masterBean.getUpdate_timeFrom());
			v_order_masterAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(v_order_masterBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(v_order_masterBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_masterAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_masterAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_masterAction.setUpdate_timeHourSelectFrom(v_order_masterAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_order_masterAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_masterAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_masterAction.setUpdate_timeMinuteSelectFrom(v_order_masterAction.update_timeMinuteFrom);
		}
		if(v_order_masterBean.getUpdate_timeTo()!=null){
			v_order_masterAction.setUpdate_timeTo(v_order_masterBean.getUpdate_timeTo());
			v_order_masterAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(v_order_masterBean.getUpdate_timeTo()));
			cale.setTimeInMillis(v_order_masterBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_order_masterAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_order_masterAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_order_masterAction.setUpdate_timeHourSelectTo(v_order_masterAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_order_masterAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_order_masterAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_order_masterAction.setUpdate_timeMinuteSelectTo(v_order_masterAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param V_order_masterAction action句柄
	 * @param V_order_masterBean action句柄
	 * @param type 控件类型
	 */
	public V_order_masterBean wrapperV_order_masterBean(V_order_masterAction v_order_masterAction,V_order_masterBean v_order_masterBean,String type){
		//s:select***************************************************************************
				InitPageControl.initStatusMap(v_order_masterAction);
				v_order_masterBean.setStatus(Utilities.getWrapperSelect(v_order_masterBean.getStatus(),v_order_masterAction.statusMap));
				//s:select***************************************************************************
				InitPageControl.initInvalidMap(v_order_masterAction);
				v_order_masterBean.setInvalid(Utilities.getWrapperSelect(v_order_masterBean.getInvalid(),v_order_masterAction.invalidMap));

		return v_order_masterBean;
	}
	
	/**
	 * 记录显示包装
	 * @param V_order_masterAction action句柄
	 * @param type 控件类型
	 */
    public List<V_order_masterBean> wrapperRecorders(V_order_masterAction v_order_masterAction,String type){
    	V_order_masterBean v_order_master=null;
    	List<V_order_masterBean> newV_order_masterList=V_order_masterUtility.getIocHandel().getBean("List_V_order_masterBean",java.util.ArrayList.class);
    	for(int i=0;i<v_order_masterAction.v_order_masterList.size();i++){
    		v_order_master=v_order_masterAction.v_order_masterList.get(i);
    		v_order_master=wrapperV_order_masterBean(v_order_masterAction,v_order_master,type);
    		newV_order_masterList.add(v_order_master);
    	}
    	return newV_order_masterList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param V_order_masterAction action句柄
	 * @param V_order_masterBean action句柄
	 */
	private void write2ControlsCommon(V_order_masterAction v_order_masterAction,V_order_masterBean v_order_masterBean){
		v_order_masterAction.setId(v_order_masterBean.getId());
				//textfield
		if(v_order_masterBean.getOrderid()!=null)
			if(v_order_masterBean.getOrderid().trim().length()>0) v_order_masterAction.setOrderid(v_order_masterBean.getOrderid());
		//textfield
		if(v_order_masterBean.getRepair_userkey()!=null)
			if(v_order_masterBean.getRepair_userkey().trim().length()>0) v_order_masterAction.setRepair_userkey(v_order_masterBean.getRepair_userkey());
		//textfield
		if(v_order_masterBean.getOutcome()!=null)
			if(v_order_masterBean.getOutcome().trim().length()>0) v_order_masterAction.setOutcome(v_order_masterBean.getOutcome());
		//textfield
		if(v_order_masterBean.getOutcome_image1()!=null)
			if(v_order_masterBean.getOutcome_image1().trim().length()>0) v_order_masterAction.setOutcome_image1(v_order_masterBean.getOutcome_image1());
		//textfield
		if(v_order_masterBean.getOutcome_image2()!=null)
			if(v_order_masterBean.getOutcome_image2().trim().length()>0) v_order_masterAction.setOutcome_image2(v_order_masterBean.getOutcome_image2());
		//textfield
		if(v_order_masterBean.getOutcome_image3()!=null)
			if(v_order_masterBean.getOutcome_image3().trim().length()>0) v_order_masterAction.setOutcome_image3(v_order_masterBean.getOutcome_image3());
		//textfield
		if(v_order_masterBean.getReq_name()!=null)
			if(v_order_masterBean.getReq_name().trim().length()>0) v_order_masterAction.setReq_name(v_order_masterBean.getReq_name());
		//textfield
		if(v_order_masterBean.getReq_id()!=null)
			if(v_order_masterBean.getReq_id().trim().length()>0) v_order_masterAction.setReq_id(v_order_masterBean.getReq_id());
		//textfield
		if(v_order_masterBean.getReq_icon()!=null)
			if(v_order_masterBean.getReq_icon().trim().length()>0) v_order_masterAction.setReq_icon(v_order_masterBean.getReq_icon());

		//select
		if(v_order_masterBean.getStatus()!=null){
			if(v_order_masterBean.getStatus().trim().length()>0){
				if(!v_order_masterAction.action.equals("detail")){
					v_order_masterAction.setStatus(v_order_masterBean.getStatus());
					v_order_masterAction.setStatusSelect(v_order_masterBean.getStatus());
				}else v_order_masterAction.setStatus(Utilities.getWrapperSelect(v_order_masterBean.getStatus(),v_order_masterAction.statusMap));
			}
		}
		//select
		if(v_order_masterBean.getInvalid()!=null){
			if(v_order_masterBean.getInvalid().trim().length()>0){
				if(!v_order_masterAction.action.equals("detail")){
					v_order_masterAction.setInvalid(v_order_masterBean.getInvalid());
					v_order_masterAction.setInvalidSelect(v_order_masterBean.getInvalid());
				}else v_order_masterAction.setInvalid(Utilities.getWrapperSelect(v_order_masterBean.getInvalid(),v_order_masterAction.invalidMap));
			}
		}
	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param V_order_masterBean action句柄
	 * @param V_order_masterAction action句柄
	 */
	private V_order_masterBean setV_order_masterBeanCommonAttributes(V_order_masterBean v_order_masterBean,V_order_masterAction v_order_masterAction){
				v_order_masterBean.setOrderid(v_order_masterAction.orderid);
		v_order_masterBean.setRepair_userkey(v_order_masterAction.repair_userkey);
		v_order_masterBean.setOutcome(v_order_masterAction.outcome);
		v_order_masterBean.setOutcome_image1(v_order_masterAction.outcome_image1);
		v_order_masterBean.setOutcome_image2(v_order_masterAction.outcome_image2);
		v_order_masterBean.setOutcome_image3(v_order_masterAction.outcome_image3);
		v_order_masterBean.setStatus(v_order_masterAction.status);
		v_order_masterBean.setInvalid(v_order_masterAction.invalid);
		v_order_masterBean.setReq_name(v_order_masterAction.req_name);
		v_order_masterBean.setReq_id(v_order_masterAction.req_id);
		v_order_masterBean.setReq_icon(v_order_masterAction.req_icon);

		return v_order_masterBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param v_order_masterQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(V_order_masterBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getOrderid().trim().length()>0)
			paramStr.append("&orderid=").append(queryConditionsBean.getOrderid().trim());
		if(queryConditionsBean.getRepair_userkey().trim().length()>0)
			paramStr.append("&repair_userkey=").append(queryConditionsBean.getRepair_userkey().trim());
		if(queryConditionsBean.getOutcome().trim().length()>0)
			paramStr.append("&outcome=").append(queryConditionsBean.getOutcome().trim());
		if(queryConditionsBean.getOutcome_image1().trim().length()>0)
			paramStr.append("&outcome_image1=").append(queryConditionsBean.getOutcome_image1().trim());
		if(queryConditionsBean.getOutcome_image2().trim().length()>0)
			paramStr.append("&outcome_image2=").append(queryConditionsBean.getOutcome_image2().trim());
		if(queryConditionsBean.getOutcome_image3().trim().length()>0)
			paramStr.append("&outcome_image3=").append(queryConditionsBean.getOutcome_image3().trim());
		if(queryConditionsBean.getStatus().trim().length()>0)
			paramStr.append("&status=").append(queryConditionsBean.getStatus().trim());
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
		if(queryConditionsBean.getReq_icon().trim().length()>0)
			paramStr.append("&req_icon=").append(queryConditionsBean.getReq_icon().trim());

		return paramStr.toString();
	}
}