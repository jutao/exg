package edu.jt.exg.logic.v_consume_detail;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.V_consume_detailAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_consume_detailAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(V_consume_detailAction v_consume_detailAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			v_consume_detailAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			v_consume_detailAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			v_consume_detailAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(v_consume_detailAction.start==null) v_consume_detailAction.start="0";
        else if(v_consume_detailAction.start.length()==0) v_consume_detailAction.start="0";
        if(v_consume_detailAction.range==null) v_consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_consume_detailAction.range.length()==0) v_consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_consume_detailAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_consume_detailAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(V_consume_detailAction v_consume_detailAction){
    	//获取记录范围*************************************************
    	v_consume_detailAction.action=v_consume_detailAction.request.getParameter("action");
        if(v_consume_detailAction.start==null) v_consume_detailAction.start="0";
        else if(v_consume_detailAction.start.length()==0) v_consume_detailAction.start="0";
        if(v_consume_detailAction.range==null) v_consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_consume_detailAction.range.length()==0) v_consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_consume_detailAction);
    }
    
    /**
	 * 设置排序
	 * @param V_consume_detailAction action句柄
	 */
    private void setOrderByMap(V_consume_detailAction v_consume_detailAction){
        v_consume_detailAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(V_consume_detailSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param V_consume_detailAction action句柄
	 */
	public void setControlsValues(V_consume_detailAction v_consume_detailAction){
			InitPageControl.initTimestamp(v_consume_detailAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param V_consume_detailAction action句柄
	 * @param params 设置参数
	 */
	public V_consume_detailBean getQueryConditionsFromParams(V_consume_detailAction v_consume_detailAction,String params){
		V_consume_detailBean v_consume_detailBean=V_consume_detailUtility.getIocHandel().getBean("V_consume_detailBean",V_consume_detailBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("detailid=")==0){
			pos=tmp.indexOf("detailid=");
			v_consume_detailBean.setDetailid(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("taskkey=")==0){
			pos=tmp.indexOf("taskkey=");
			v_consume_detailBean.setTaskkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("quantityFrom=")==0){
			pos=tmp.indexOf("quantityFrom=");
			v_consume_detailBean.setQuantityFrom(Double.valueOf(tmp.substring(pos+13,tmp.length())));
		}else if(array[i].indexOf("quantityTo=")==0){
			pos=tmp.indexOf("quantityTo=");
			v_consume_detailBean.setQuantityTo(Double.valueOf(tmp.substring(pos+11,tmp.length())));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			v_consume_detailBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			v_consume_detailBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			v_consume_detailBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_consume_detailBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_consume_detailBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			v_consume_detailBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("user_name=")==0){
			pos=tmp.indexOf("user_name=");
			v_consume_detailBean.setUser_name(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("user_id=")==0){
			pos=tmp.indexOf("user_id=");
			v_consume_detailBean.setUser_id(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("user_icon=")==0){
			pos=tmp.indexOf("user_icon=");
			v_consume_detailBean.setUser_icon(tmp.substring(pos+10,tmp.length()));
		}

		}
		return v_consume_detailBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param V_consume_detailAction action句柄
	 */
	public V_consume_detailBean getQueryConditionsFromForm(V_consume_detailAction v_consume_detailAction){
		V_consume_detailBean v_consume_detailBean=V_consume_detailUtility.getIocHandel().getBean("V_consume_detailBean",V_consume_detailBean.class);
		v_consume_detailBean=setV_consume_detailBeanCommonAttributes(v_consume_detailBean,v_consume_detailAction);
				v_consume_detailBean.setQuantityFrom(v_consume_detailAction.quantityFrom);
		v_consume_detailBean.setQuantityTo(v_consume_detailAction.quantityTo);
		v_consume_detailAction.register_timeFrom=Utilities.setTimeStampFunction(v_consume_detailAction.register_timeDateFrom,v_consume_detailAction.register_timeHourFrom,v_consume_detailAction.register_timeMinuteFrom);
		v_consume_detailBean.setRegister_timeFrom(v_consume_detailAction.register_timeFrom);
		v_consume_detailAction.register_timeTo=Utilities.setTimeStampFunction(v_consume_detailAction.register_timeDateTo,v_consume_detailAction.register_timeHourTo,v_consume_detailAction.register_timeMinuteTo);
		v_consume_detailBean.setRegister_timeTo(v_consume_detailAction.register_timeTo);
		v_consume_detailAction.update_timeFrom=Utilities.setTimeStampFunction(v_consume_detailAction.update_timeDateFrom,v_consume_detailAction.update_timeHourFrom,v_consume_detailAction.update_timeMinuteFrom);
		v_consume_detailBean.setUpdate_timeFrom(v_consume_detailAction.update_timeFrom);
		v_consume_detailAction.update_timeTo=Utilities.setTimeStampFunction(v_consume_detailAction.update_timeDateTo,v_consume_detailAction.update_timeHourTo,v_consume_detailAction.update_timeMinuteTo);
		v_consume_detailBean.setUpdate_timeTo(v_consume_detailAction.update_timeTo);

		return v_consume_detailBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param V_consume_detailAction action句柄
	 */
	public String readControlsWrite2Datas(V_consume_detailAction v_consume_detailAction){
		String errorMsg="";
				V_consume_detailBean v_consume_detailBean=V_consume_detailUtility.getIocHandel().getBean("V_consume_detailBean",V_consume_detailBean.class);
		if(v_consume_detailAction.action.equals("create")) v_consume_detailBean.setId(Utilities.getRandomPK(true));
		else v_consume_detailBean.setId(v_consume_detailAction.id);
		v_consume_detailBean=setV_consume_detailBeanCommonAttributes(v_consume_detailBean,v_consume_detailAction);
		v_consume_detailBean.setQuantity(v_consume_detailAction.quantity);
		v_consume_detailBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		v_consume_detailBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		v_consume_detailAction.batisDao=V_consume_detailUtility.getIocHandel().getBean("V_consume_detailBatisDao",V_consume_detailBatisDao.class);
		if(v_consume_detailAction.action.equals("create")) errorMsg=Integer.toString(v_consume_detailAction.batisDao.insert(v_consume_detailBean));
		else errorMsg=Integer.toString(v_consume_detailAction.batisDao.updateByKey(v_consume_detailBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param V_consume_detailAction action句柄
	 */
	public void readDatasWrite2Controls(V_consume_detailAction v_consume_detailAction){
		
		
		
		
		
		
		v_consume_detailAction.batisDao=V_consume_detailUtility.getIocHandel().getBean("V_consume_detailBatisDao",V_consume_detailBatisDao.class);
		V_consume_detailBean v_consume_detailBean=v_consume_detailAction.batisDao.findByKey(v_consume_detailAction.id);
		
		
		
		write2ControlsCommon(v_consume_detailAction,v_consume_detailBean);
				if(v_consume_detailBean.getQuantity()!=null)
			if(v_consume_detailBean.getQuantity().doubleValue()!=0) v_consume_detailAction.setQuantity(v_consume_detailBean.getQuantity());
		//auto timestamp
		if(v_consume_detailAction.action.equals("detail")) v_consume_detailAction.setRegister_time(v_consume_detailBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(v_consume_detailAction.action.equals("detail")) v_consume_detailAction.setUpdate_time(v_consume_detailBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param V_consume_detailAction action句柄
	 * @param V_consume_detailBean action句柄
	 */
	public void readConditionsWrite2Controls(V_consume_detailAction v_consume_detailAction,V_consume_detailBean v_consume_detailBean){
		write2ControlsCommon(v_consume_detailAction,v_consume_detailBean);
				if(v_consume_detailBean.getQuantityFrom()!=null)
			if(v_consume_detailBean.getQuantityFrom().doubleValue()!=0) v_consume_detailAction.setQuantityFrom(v_consume_detailBean.getQuantityFrom());
		if(v_consume_detailBean.getQuantityTo()!=null)
			if(v_consume_detailBean.getQuantityTo().doubleValue()!=0) v_consume_detailAction.setQuantityTo(v_consume_detailBean.getQuantityTo());
		if(v_consume_detailBean.getRegister_timeFrom()!=null){
			v_consume_detailAction.setRegister_timeFrom(v_consume_detailBean.getRegister_timeFrom());
			v_consume_detailAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(v_consume_detailBean.getRegister_timeFrom()));
			cale.setTimeInMillis(v_consume_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_consume_detailAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_consume_detailAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_consume_detailAction.setRegister_timeHourSelectFrom(v_consume_detailAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_consume_detailAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_consume_detailAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_consume_detailAction.setRegister_timeMinuteSelectFrom(v_consume_detailAction.register_timeMinuteFrom);
		}
		if(v_consume_detailBean.getRegister_timeTo()!=null){
			v_consume_detailAction.setRegister_timeTo(v_consume_detailBean.getRegister_timeTo());
			v_consume_detailAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(v_consume_detailBean.getRegister_timeTo()));
			cale.setTimeInMillis(v_consume_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_consume_detailAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_consume_detailAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_consume_detailAction.setRegister_timeHourSelectTo(v_consume_detailAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_consume_detailAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_consume_detailAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_consume_detailAction.setRegister_timeMinuteSelectTo(v_consume_detailAction.register_timeMinuteTo);
		}
		if(v_consume_detailBean.getUpdate_timeFrom()!=null){
			v_consume_detailAction.setUpdate_timeFrom(v_consume_detailBean.getUpdate_timeFrom());
			v_consume_detailAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(v_consume_detailBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(v_consume_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_consume_detailAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_consume_detailAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_consume_detailAction.setUpdate_timeHourSelectFrom(v_consume_detailAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_consume_detailAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_consume_detailAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_consume_detailAction.setUpdate_timeMinuteSelectFrom(v_consume_detailAction.update_timeMinuteFrom);
		}
		if(v_consume_detailBean.getUpdate_timeTo()!=null){
			v_consume_detailAction.setUpdate_timeTo(v_consume_detailBean.getUpdate_timeTo());
			v_consume_detailAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(v_consume_detailBean.getUpdate_timeTo()));
			cale.setTimeInMillis(v_consume_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_consume_detailAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_consume_detailAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_consume_detailAction.setUpdate_timeHourSelectTo(v_consume_detailAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_consume_detailAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_consume_detailAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_consume_detailAction.setUpdate_timeMinuteSelectTo(v_consume_detailAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param V_consume_detailAction action句柄
	 * @param V_consume_detailBean action句柄
	 * @param type 控件类型
	 */
	public V_consume_detailBean wrapperV_consume_detailBean(V_consume_detailAction v_consume_detailAction,V_consume_detailBean v_consume_detailBean,String type){
		
		return v_consume_detailBean;
	}
	
	/**
	 * 记录显示包装
	 * @param V_consume_detailAction action句柄
	 * @param type 控件类型
	 */
    public List<V_consume_detailBean> wrapperRecorders(V_consume_detailAction v_consume_detailAction,String type){
    	V_consume_detailBean v_consume_detail=null;
    	List<V_consume_detailBean> newV_consume_detailList=V_consume_detailUtility.getIocHandel().getBean("List_V_consume_detailBean",java.util.ArrayList.class);
    	for(int i=0;i<v_consume_detailAction.v_consume_detailList.size();i++){
    		v_consume_detail=v_consume_detailAction.v_consume_detailList.get(i);
    		v_consume_detail=wrapperV_consume_detailBean(v_consume_detailAction,v_consume_detail,type);
    		newV_consume_detailList.add(v_consume_detail);
    	}
    	return newV_consume_detailList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param V_consume_detailAction action句柄
	 * @param V_consume_detailBean action句柄
	 */
	private void write2ControlsCommon(V_consume_detailAction v_consume_detailAction,V_consume_detailBean v_consume_detailBean){
		v_consume_detailAction.setId(v_consume_detailBean.getId());
				//textfield
		if(v_consume_detailBean.getDetailid()!=null)
			if(v_consume_detailBean.getDetailid().trim().length()>0) v_consume_detailAction.setDetailid(v_consume_detailBean.getDetailid());
		//textfield
		if(v_consume_detailBean.getTaskkey()!=null)
			if(v_consume_detailBean.getTaskkey().trim().length()>0) v_consume_detailAction.setTaskkey(v_consume_detailBean.getTaskkey());
		//textfield
		if(v_consume_detailBean.getStatus()!=null)
			if(v_consume_detailBean.getStatus().trim().length()>0) v_consume_detailAction.setStatus(v_consume_detailBean.getStatus());
		//textfield
		if(v_consume_detailBean.getInvalid()!=null)
			if(v_consume_detailBean.getInvalid().trim().length()>0) v_consume_detailAction.setInvalid(v_consume_detailBean.getInvalid());
		//textfield
		if(v_consume_detailBean.getUser_name()!=null)
			if(v_consume_detailBean.getUser_name().trim().length()>0) v_consume_detailAction.setUser_name(v_consume_detailBean.getUser_name());
		//textfield
		if(v_consume_detailBean.getUser_id()!=null)
			if(v_consume_detailBean.getUser_id().trim().length()>0) v_consume_detailAction.setUser_id(v_consume_detailBean.getUser_id());
		//textfield
		if(v_consume_detailBean.getUser_icon()!=null)
			if(v_consume_detailBean.getUser_icon().trim().length()>0) v_consume_detailAction.setUser_icon(v_consume_detailBean.getUser_icon());

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param V_consume_detailBean action句柄
	 * @param V_consume_detailAction action句柄
	 */
	private V_consume_detailBean setV_consume_detailBeanCommonAttributes(V_consume_detailBean v_consume_detailBean,V_consume_detailAction v_consume_detailAction){
				v_consume_detailBean.setDetailid(v_consume_detailAction.detailid);
		v_consume_detailBean.setTaskkey(v_consume_detailAction.taskkey);
		v_consume_detailBean.setStatus(v_consume_detailAction.status);
		v_consume_detailBean.setInvalid(v_consume_detailAction.invalid);
		v_consume_detailBean.setUser_name(v_consume_detailAction.user_name);
		v_consume_detailBean.setUser_id(v_consume_detailAction.user_id);
		v_consume_detailBean.setUser_icon(v_consume_detailAction.user_icon);

		return v_consume_detailBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param v_consume_detailQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(V_consume_detailBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getDetailid().trim().length()>0)
			paramStr.append("&detailid=").append(queryConditionsBean.getDetailid().trim());
		if(queryConditionsBean.getTaskkey().trim().length()>0)
			paramStr.append("&taskkey=").append(queryConditionsBean.getTaskkey().trim());
		if(queryConditionsBean.getQuantityFrom()!=null)
				paramStr.append("&quantityFrom=").append(queryConditionsBean.getQuantityFrom());
		if(queryConditionsBean.getQuantityTo()!=null)
				paramStr.append("&quantityTo=").append(queryConditionsBean.getQuantityTo());
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
		if(queryConditionsBean.getUser_name().trim().length()>0)
			paramStr.append("&user_name=").append(queryConditionsBean.getUser_name().trim());
		if(queryConditionsBean.getUser_id().trim().length()>0)
			paramStr.append("&user_id=").append(queryConditionsBean.getUser_id().trim());
		if(queryConditionsBean.getUser_icon().trim().length()>0)
			paramStr.append("&user_icon=").append(queryConditionsBean.getUser_icon().trim());

		return paramStr.toString();
	}
}