package edu.jt.exg.logic.order_master;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Order_masterAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Order_masterAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Order_masterAction order_masterAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			order_masterAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			order_masterAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			order_masterAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(order_masterAction.start==null) order_masterAction.start="0";
        else if(order_masterAction.start.length()==0) order_masterAction.start="0";
        if(order_masterAction.range==null) order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        else if(order_masterAction.range.length()==0) order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(order_masterAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Order_masterAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Order_masterAction order_masterAction){
    	//获取记录范围*************************************************
    	order_masterAction.action=order_masterAction.request.getParameter("action");
        if(order_masterAction.start==null) order_masterAction.start="0";
        else if(order_masterAction.start.length()==0) order_masterAction.start="0";
        if(order_masterAction.range==null) order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        else if(order_masterAction.range.length()==0) order_masterAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(order_masterAction);
    }
    
    /**
	 * 设置排序
	 * @param Order_masterAction action句柄
	 */
    private void setOrderByMap(Order_masterAction order_masterAction){
        order_masterAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Order_masterSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Order_masterAction action句柄
	 */
	public void setControlsValues(Order_masterAction order_masterAction){
			InitPageControl.initStatusMap(order_masterAction);
		InitPageControl.initInvalidMap(order_masterAction);
		InitPageControl.initTimestamp(order_masterAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Order_masterAction action句柄
	 * @param params 设置参数
	 */
	public Order_masterBean getQueryConditionsFromParams(Order_masterAction order_masterAction,String params){
		Order_masterBean order_masterBean=Order_masterUtility.getIocHandel().getBean("Order_masterBean",Order_masterBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("orderid=")==0){
			pos=tmp.indexOf("orderid=");
			order_masterBean.setOrderid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("repair_userkey=")==0){
			pos=tmp.indexOf("repair_userkey=");
			order_masterBean.setRepair_userkey(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("outcome=")==0){
			pos=tmp.indexOf("outcome=");
			order_masterBean.setOutcome(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("outcome_image1=")==0){
			pos=tmp.indexOf("outcome_image1=");
			order_masterBean.setOutcome_image1(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("outcome_image2=")==0){
			pos=tmp.indexOf("outcome_image2=");
			order_masterBean.setOutcome_image2(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("outcome_image3=")==0){
			pos=tmp.indexOf("outcome_image3=");
			order_masterBean.setOutcome_image3(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			order_masterBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			order_masterBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			order_masterBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			order_masterBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			order_masterBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			order_masterBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return order_masterBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param Order_masterAction action句柄
	 */
	public Order_masterBean getQueryConditionsFromForm(Order_masterAction order_masterAction){
		Order_masterBean order_masterBean=Order_masterUtility.getIocHandel().getBean("Order_masterBean",Order_masterBean.class);
		order_masterBean=setOrder_masterBeanCommonAttributes(order_masterBean,order_masterAction);
				order_masterAction.register_timeFrom=Utilities.setTimeStampFunction(order_masterAction.register_timeDateFrom,order_masterAction.register_timeHourFrom,order_masterAction.register_timeMinuteFrom);
		order_masterBean.setRegister_timeFrom(order_masterAction.register_timeFrom);
		order_masterAction.register_timeTo=Utilities.setTimeStampFunction(order_masterAction.register_timeDateTo,order_masterAction.register_timeHourTo,order_masterAction.register_timeMinuteTo);
		order_masterBean.setRegister_timeTo(order_masterAction.register_timeTo);
		order_masterAction.update_timeFrom=Utilities.setTimeStampFunction(order_masterAction.update_timeDateFrom,order_masterAction.update_timeHourFrom,order_masterAction.update_timeMinuteFrom);
		order_masterBean.setUpdate_timeFrom(order_masterAction.update_timeFrom);
		order_masterAction.update_timeTo=Utilities.setTimeStampFunction(order_masterAction.update_timeDateTo,order_masterAction.update_timeHourTo,order_masterAction.update_timeMinuteTo);
		order_masterBean.setUpdate_timeTo(order_masterAction.update_timeTo);

		return order_masterBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Order_masterAction action句柄
	 */
	public String readControlsWrite2Datas(Order_masterAction order_masterAction){
		String errorMsg="";
				Order_masterBean order_masterBean=Order_masterUtility.getIocHandel().getBean("Order_masterBean",Order_masterBean.class);
		if(order_masterAction.action.equals("create")) order_masterBean.setId(Utilities.getRandomPK(true));
		else order_masterBean.setId(order_masterAction.id);
		order_masterBean=setOrder_masterBeanCommonAttributes(order_masterBean,order_masterAction);
		order_masterBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		order_masterBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		order_masterAction.batisDao=Order_masterUtility.getIocHandel().getBean("Order_masterBatisDao",Order_masterBatisDao.class);
		if(order_masterAction.action.equals("create")) errorMsg=Integer.toString(order_masterAction.batisDao.insert(order_masterBean));
		else errorMsg=Integer.toString(order_masterAction.batisDao.updateByKey(order_masterBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param Order_masterAction action句柄
	 */
	public void readDatasWrite2Controls(Order_masterAction order_masterAction){
		
		
		
		
		
		
		order_masterAction.batisDao=Order_masterUtility.getIocHandel().getBean("Order_masterBatisDao",Order_masterBatisDao.class);
		Order_masterBean order_masterBean=order_masterAction.batisDao.findByKey(order_masterAction.id);
		
		
		
		write2ControlsCommon(order_masterAction,order_masterBean);
				//auto timestamp
		if(order_masterAction.action.equals("detail")) order_masterAction.setRegister_time(order_masterBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(order_masterAction.action.equals("detail")) order_masterAction.setUpdate_time(order_masterBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param Order_masterAction action句柄
	 * @param Order_masterBean action句柄
	 */
	public void readConditionsWrite2Controls(Order_masterAction order_masterAction,Order_masterBean order_masterBean){
		write2ControlsCommon(order_masterAction,order_masterBean);
				if(order_masterBean.getRegister_timeFrom()!=null){
			order_masterAction.setRegister_timeFrom(order_masterBean.getRegister_timeFrom());
			order_masterAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(order_masterBean.getRegister_timeFrom()));
			cale.setTimeInMillis(order_masterBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_masterAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_masterAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			order_masterAction.setRegister_timeHourSelectFrom(order_masterAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) order_masterAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_masterAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			order_masterAction.setRegister_timeMinuteSelectFrom(order_masterAction.register_timeMinuteFrom);
		}
		if(order_masterBean.getRegister_timeTo()!=null){
			order_masterAction.setRegister_timeTo(order_masterBean.getRegister_timeTo());
			order_masterAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(order_masterBean.getRegister_timeTo()));
			cale.setTimeInMillis(order_masterBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_masterAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_masterAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			order_masterAction.setRegister_timeHourSelectTo(order_masterAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) order_masterAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_masterAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			order_masterAction.setRegister_timeMinuteSelectTo(order_masterAction.register_timeMinuteTo);
		}
		if(order_masterBean.getUpdate_timeFrom()!=null){
			order_masterAction.setUpdate_timeFrom(order_masterBean.getUpdate_timeFrom());
			order_masterAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(order_masterBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(order_masterBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_masterAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_masterAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			order_masterAction.setUpdate_timeHourSelectFrom(order_masterAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) order_masterAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_masterAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			order_masterAction.setUpdate_timeMinuteSelectFrom(order_masterAction.update_timeMinuteFrom);
		}
		if(order_masterBean.getUpdate_timeTo()!=null){
			order_masterAction.setUpdate_timeTo(order_masterBean.getUpdate_timeTo());
			order_masterAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(order_masterBean.getUpdate_timeTo()));
			cale.setTimeInMillis(order_masterBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) order_masterAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else order_masterAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			order_masterAction.setUpdate_timeHourSelectTo(order_masterAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) order_masterAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else order_masterAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			order_masterAction.setUpdate_timeMinuteSelectTo(order_masterAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param Order_masterAction action句柄
	 * @param Order_masterBean action句柄
	 * @param type 控件类型
	 */
	public Order_masterBean wrapperOrder_masterBean(Order_masterAction order_masterAction,Order_masterBean order_masterBean,String type){
				//上传照片显示***********************************************************************
		if(type.equals("show")) order_masterBean.setOutcome_image1(Utilities.getWrapperUploadFileLinkString(order_masterAction.request,order_masterBean.getOutcome_image1(),"image"));
		else order_masterBean.setOutcome_image1(order_masterBean.getOutcome_image1());
		//上传照片显示***********************************************************************
		if(type.equals("show")) order_masterBean.setOutcome_image2(Utilities.getWrapperUploadFileLinkString(order_masterAction.request,order_masterBean.getOutcome_image2(),"image"));
		else order_masterBean.setOutcome_image2(order_masterBean.getOutcome_image2());
		//上传照片显示***********************************************************************
		if(type.equals("show")) order_masterBean.setOutcome_image3(Utilities.getWrapperUploadFileLinkString(order_masterAction.request,order_masterBean.getOutcome_image3(),"image"));
		else order_masterBean.setOutcome_image3(order_masterBean.getOutcome_image3());
		//s:select***************************************************************************
		InitPageControl.initStatusMap(order_masterAction);
		order_masterBean.setStatus(Utilities.getWrapperSelect(order_masterBean.getStatus(),order_masterAction.statusMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(order_masterAction);
		order_masterBean.setInvalid(Utilities.getWrapperSelect(order_masterBean.getInvalid(),order_masterAction.invalidMap));

		return order_masterBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Order_masterAction action句柄
	 * @param type 控件类型
	 */
    public List<Order_masterBean> wrapperRecorders(Order_masterAction order_masterAction,String type){
    	Order_masterBean order_master=null;
    	List<Order_masterBean> newOrder_masterList=Order_masterUtility.getIocHandel().getBean("List_Order_masterBean",java.util.ArrayList.class);
    	for(int i=0;i<order_masterAction.order_masterList.size();i++){
    		order_master=order_masterAction.order_masterList.get(i);
    		order_master=wrapperOrder_masterBean(order_masterAction,order_master,type);
    		newOrder_masterList.add(order_master);
    	}
    	return newOrder_masterList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param Order_masterAction action句柄
	 * @param Order_masterBean action句柄
	 */
	private void write2ControlsCommon(Order_masterAction order_masterAction,Order_masterBean order_masterBean){
		order_masterAction.setId(order_masterBean.getId());
				//textfield
		if(order_masterBean.getOrderid()!=null)
			if(order_masterBean.getOrderid().trim().length()>0) order_masterAction.setOrderid(order_masterBean.getOrderid());
		//textfield
		if(order_masterBean.getRepair_userkey()!=null)
			if(order_masterBean.getRepair_userkey().trim().length()>0) order_masterAction.setRepair_userkey(order_masterBean.getRepair_userkey());
		//textfield
		if(order_masterBean.getOutcome()!=null)
			if(order_masterBean.getOutcome().trim().length()>0) order_masterAction.setOutcome(order_masterBean.getOutcome());
		//img upload
		if(order_masterBean.getOutcome_image1()!=null){
			if(order_masterBean.getOutcome_image1().trim().length()>0) order_masterAction.setOutcome_image1(order_masterBean.getOutcome_image1());
			else order_masterAction.setOutcome_image1("");
		}else order_masterAction.setOutcome_image1("");
		//img upload
		if(order_masterBean.getOutcome_image2()!=null){
			if(order_masterBean.getOutcome_image2().trim().length()>0) order_masterAction.setOutcome_image2(order_masterBean.getOutcome_image2());
			else order_masterAction.setOutcome_image2("");
		}else order_masterAction.setOutcome_image2("");
		//img upload
		if(order_masterBean.getOutcome_image3()!=null){
			if(order_masterBean.getOutcome_image3().trim().length()>0) order_masterAction.setOutcome_image3(order_masterBean.getOutcome_image3());
			else order_masterAction.setOutcome_image3("");
		}else order_masterAction.setOutcome_image3("");
		//select
		if(order_masterBean.getStatus()!=null){
			if(order_masterBean.getStatus().trim().length()>0){
				if(!order_masterAction.action.equals("detail")){
					order_masterAction.setStatus(order_masterBean.getStatus());
					order_masterAction.setStatusSelect(order_masterBean.getStatus());
				}else order_masterAction.setStatus(Utilities.getWrapperSelect(order_masterBean.getStatus(),order_masterAction.statusMap));
			}
		}
		//select
		if(order_masterBean.getInvalid()!=null){
			if(order_masterBean.getInvalid().trim().length()>0){
				if(!order_masterAction.action.equals("detail")){
					order_masterAction.setInvalid(order_masterBean.getInvalid());
					order_masterAction.setInvalidSelect(order_masterBean.getInvalid());
				}else order_masterAction.setInvalid(Utilities.getWrapperSelect(order_masterBean.getInvalid(),order_masterAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param Order_masterBean action句柄
	 * @param Order_masterAction action句柄
	 */
	private Order_masterBean setOrder_masterBeanCommonAttributes(Order_masterBean order_masterBean,Order_masterAction order_masterAction){
				order_masterBean.setOrderid(order_masterAction.orderid);
		order_masterBean.setRepair_userkey(order_masterAction.repair_userkey);
		order_masterBean.setOutcome(order_masterAction.outcome);
		order_masterBean.setOutcome_image1(order_masterAction.outcome_image1);
		order_masterBean.setOutcome_image2(order_masterAction.outcome_image2);
		order_masterBean.setOutcome_image3(order_masterAction.outcome_image3);
		order_masterBean.setStatus(order_masterAction.status);
		order_masterBean.setInvalid(order_masterAction.invalid);

		return order_masterBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param order_masterQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Order_masterBean queryConditionsBean){
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
		if(queryConditionsBean.getStatus()!=null)
			if(queryConditionsBean.getStatus().trim().length()>0)
				paramStr.append("&status=").append(queryConditionsBean.getStatus().trim());
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