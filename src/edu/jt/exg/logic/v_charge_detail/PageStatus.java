package edu.jt.exg.logic.v_charge_detail;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.V_charge_detailAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_charge_detailAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(V_charge_detailAction v_charge_detailAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			v_charge_detailAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			v_charge_detailAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			v_charge_detailAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(v_charge_detailAction.start==null) v_charge_detailAction.start="0";
        else if(v_charge_detailAction.start.length()==0) v_charge_detailAction.start="0";
        if(v_charge_detailAction.range==null) v_charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_charge_detailAction.range.length()==0) v_charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_charge_detailAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_charge_detailAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(V_charge_detailAction v_charge_detailAction){
    	//获取记录范围*************************************************
    	v_charge_detailAction.action=v_charge_detailAction.request.getParameter("action");
        if(v_charge_detailAction.start==null) v_charge_detailAction.start="0";
        else if(v_charge_detailAction.start.length()==0) v_charge_detailAction.start="0";
        if(v_charge_detailAction.range==null) v_charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_charge_detailAction.range.length()==0) v_charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_charge_detailAction);
    }
    
    /**
	 * 设置排序
	 * @param V_charge_detailAction action句柄
	 */
    private void setOrderByMap(V_charge_detailAction v_charge_detailAction){
        v_charge_detailAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(V_charge_detailSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param V_charge_detailAction action句柄
	 */
	public void setControlsValues(V_charge_detailAction v_charge_detailAction){
			InitPageControl.initTimestamp(v_charge_detailAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param V_charge_detailAction action句柄
	 * @param params 设置参数
	 */
	public V_charge_detailBean getQueryConditionsFromParams(V_charge_detailAction v_charge_detailAction,String params){
		V_charge_detailBean v_charge_detailBean=V_charge_detailUtility.getIocHandel().getBean("V_charge_detailBean",V_charge_detailBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("chargeid=")==0){
			pos=tmp.indexOf("chargeid=");
			v_charge_detailBean.setChargeid(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("userkey=")==0){
			pos=tmp.indexOf("userkey=");
			v_charge_detailBean.setUserkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("amountFrom=")==0){
			pos=tmp.indexOf("amountFrom=");
			v_charge_detailBean.setAmountFrom(Double.valueOf(tmp.substring(pos+11,tmp.length())));
		}else if(array[i].indexOf("amountTo=")==0){
			pos=tmp.indexOf("amountTo=");
			v_charge_detailBean.setAmountTo(Double.valueOf(tmp.substring(pos+9,tmp.length())));
		}
		if(array[i].indexOf("category=")==0){
			pos=tmp.indexOf("category=");
			v_charge_detailBean.setCategory(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			v_charge_detailBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			v_charge_detailBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			v_charge_detailBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_charge_detailBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_charge_detailBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			v_charge_detailBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("name=")==0){
			pos=tmp.indexOf("name=");
			v_charge_detailBean.setName(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("user_id=")==0){
			pos=tmp.indexOf("user_id=");
			v_charge_detailBean.setUser_id(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("icon=")==0){
			pos=tmp.indexOf("icon=");
			v_charge_detailBean.setIcon(tmp.substring(pos+5,tmp.length()));
		}

		}
		return v_charge_detailBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param V_charge_detailAction action句柄
	 */
	public V_charge_detailBean getQueryConditionsFromForm(V_charge_detailAction v_charge_detailAction){
		V_charge_detailBean v_charge_detailBean=V_charge_detailUtility.getIocHandel().getBean("V_charge_detailBean",V_charge_detailBean.class);
		v_charge_detailBean=setV_charge_detailBeanCommonAttributes(v_charge_detailBean,v_charge_detailAction);
				v_charge_detailBean.setAmountFrom(v_charge_detailAction.amountFrom);
		v_charge_detailBean.setAmountTo(v_charge_detailAction.amountTo);
		v_charge_detailAction.register_timeFrom=Utilities.setTimeStampFunction(v_charge_detailAction.register_timeDateFrom,v_charge_detailAction.register_timeHourFrom,v_charge_detailAction.register_timeMinuteFrom);
		v_charge_detailBean.setRegister_timeFrom(v_charge_detailAction.register_timeFrom);
		v_charge_detailAction.register_timeTo=Utilities.setTimeStampFunction(v_charge_detailAction.register_timeDateTo,v_charge_detailAction.register_timeHourTo,v_charge_detailAction.register_timeMinuteTo);
		v_charge_detailBean.setRegister_timeTo(v_charge_detailAction.register_timeTo);
		v_charge_detailAction.update_timeFrom=Utilities.setTimeStampFunction(v_charge_detailAction.update_timeDateFrom,v_charge_detailAction.update_timeHourFrom,v_charge_detailAction.update_timeMinuteFrom);
		v_charge_detailBean.setUpdate_timeFrom(v_charge_detailAction.update_timeFrom);
		v_charge_detailAction.update_timeTo=Utilities.setTimeStampFunction(v_charge_detailAction.update_timeDateTo,v_charge_detailAction.update_timeHourTo,v_charge_detailAction.update_timeMinuteTo);
		v_charge_detailBean.setUpdate_timeTo(v_charge_detailAction.update_timeTo);

		return v_charge_detailBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param V_charge_detailAction action句柄
	 */
	public String readControlsWrite2Datas(V_charge_detailAction v_charge_detailAction){
		String errorMsg="";
				V_charge_detailBean v_charge_detailBean=V_charge_detailUtility.getIocHandel().getBean("V_charge_detailBean",V_charge_detailBean.class);
		if(v_charge_detailAction.action.equals("create")) v_charge_detailBean.setId(Utilities.getRandomPK(true));
		else v_charge_detailBean.setId(v_charge_detailAction.id);
		v_charge_detailBean=setV_charge_detailBeanCommonAttributes(v_charge_detailBean,v_charge_detailAction);
		v_charge_detailBean.setAmount(v_charge_detailAction.amount);
		v_charge_detailBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		v_charge_detailBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		v_charge_detailAction.batisDao=V_charge_detailUtility.getIocHandel().getBean("V_charge_detailBatisDao",V_charge_detailBatisDao.class);
		if(v_charge_detailAction.action.equals("create")) errorMsg=Integer.toString(v_charge_detailAction.batisDao.insert(v_charge_detailBean));
		else errorMsg=Integer.toString(v_charge_detailAction.batisDao.updateByKey(v_charge_detailBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param V_charge_detailAction action句柄
	 */
	public void readDatasWrite2Controls(V_charge_detailAction v_charge_detailAction){
		
		
		
		
		
		
		v_charge_detailAction.batisDao=V_charge_detailUtility.getIocHandel().getBean("V_charge_detailBatisDao",V_charge_detailBatisDao.class);
		V_charge_detailBean v_charge_detailBean=v_charge_detailAction.batisDao.findByKey(v_charge_detailAction.id);
		
		
		
		write2ControlsCommon(v_charge_detailAction,v_charge_detailBean);
				if(v_charge_detailBean.getAmount()!=null)
			if(v_charge_detailBean.getAmount().doubleValue()!=0) v_charge_detailAction.setAmount(v_charge_detailBean.getAmount());
		//auto timestamp
		if(v_charge_detailAction.action.equals("detail")) v_charge_detailAction.setRegister_time(v_charge_detailBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(v_charge_detailAction.action.equals("detail")) v_charge_detailAction.setUpdate_time(v_charge_detailBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param V_charge_detailAction action句柄
	 * @param V_charge_detailBean action句柄
	 */
	public void readConditionsWrite2Controls(V_charge_detailAction v_charge_detailAction,V_charge_detailBean v_charge_detailBean){
		write2ControlsCommon(v_charge_detailAction,v_charge_detailBean);
				if(v_charge_detailBean.getAmountFrom()!=null)
			if(v_charge_detailBean.getAmountFrom().doubleValue()!=0) v_charge_detailAction.setAmountFrom(v_charge_detailBean.getAmountFrom());
		if(v_charge_detailBean.getAmountTo()!=null)
			if(v_charge_detailBean.getAmountTo().doubleValue()!=0) v_charge_detailAction.setAmountTo(v_charge_detailBean.getAmountTo());
		if(v_charge_detailBean.getRegister_timeFrom()!=null){
			v_charge_detailAction.setRegister_timeFrom(v_charge_detailBean.getRegister_timeFrom());
			v_charge_detailAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(v_charge_detailBean.getRegister_timeFrom()));
			cale.setTimeInMillis(v_charge_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_charge_detailAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_charge_detailAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_charge_detailAction.setRegister_timeHourSelectFrom(v_charge_detailAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_charge_detailAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_charge_detailAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_charge_detailAction.setRegister_timeMinuteSelectFrom(v_charge_detailAction.register_timeMinuteFrom);
		}
		if(v_charge_detailBean.getRegister_timeTo()!=null){
			v_charge_detailAction.setRegister_timeTo(v_charge_detailBean.getRegister_timeTo());
			v_charge_detailAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(v_charge_detailBean.getRegister_timeTo()));
			cale.setTimeInMillis(v_charge_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_charge_detailAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_charge_detailAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_charge_detailAction.setRegister_timeHourSelectTo(v_charge_detailAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_charge_detailAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_charge_detailAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_charge_detailAction.setRegister_timeMinuteSelectTo(v_charge_detailAction.register_timeMinuteTo);
		}
		if(v_charge_detailBean.getUpdate_timeFrom()!=null){
			v_charge_detailAction.setUpdate_timeFrom(v_charge_detailBean.getUpdate_timeFrom());
			v_charge_detailAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(v_charge_detailBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(v_charge_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_charge_detailAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_charge_detailAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_charge_detailAction.setUpdate_timeHourSelectFrom(v_charge_detailAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_charge_detailAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_charge_detailAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_charge_detailAction.setUpdate_timeMinuteSelectFrom(v_charge_detailAction.update_timeMinuteFrom);
		}
		if(v_charge_detailBean.getUpdate_timeTo()!=null){
			v_charge_detailAction.setUpdate_timeTo(v_charge_detailBean.getUpdate_timeTo());
			v_charge_detailAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(v_charge_detailBean.getUpdate_timeTo()));
			cale.setTimeInMillis(v_charge_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_charge_detailAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_charge_detailAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_charge_detailAction.setUpdate_timeHourSelectTo(v_charge_detailAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_charge_detailAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_charge_detailAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_charge_detailAction.setUpdate_timeMinuteSelectTo(v_charge_detailAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param V_charge_detailAction action句柄
	 * @param V_charge_detailBean action句柄
	 * @param type 控件类型
	 */
	public V_charge_detailBean wrapperV_charge_detailBean(V_charge_detailAction v_charge_detailAction,V_charge_detailBean v_charge_detailBean,String type){
		
		return v_charge_detailBean;
	}
	
	/**
	 * 记录显示包装
	 * @param V_charge_detailAction action句柄
	 * @param type 控件类型
	 */
    public List<V_charge_detailBean> wrapperRecorders(V_charge_detailAction v_charge_detailAction,String type){
    	V_charge_detailBean v_charge_detail=null;
    	List<V_charge_detailBean> newV_charge_detailList=V_charge_detailUtility.getIocHandel().getBean("List_V_charge_detailBean",java.util.ArrayList.class);
    	for(int i=0;i<v_charge_detailAction.v_charge_detailList.size();i++){
    		v_charge_detail=v_charge_detailAction.v_charge_detailList.get(i);
    		v_charge_detail=wrapperV_charge_detailBean(v_charge_detailAction,v_charge_detail,type);
    		newV_charge_detailList.add(v_charge_detail);
    	}
    	return newV_charge_detailList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param V_charge_detailAction action句柄
	 * @param V_charge_detailBean action句柄
	 */
	private void write2ControlsCommon(V_charge_detailAction v_charge_detailAction,V_charge_detailBean v_charge_detailBean){
		v_charge_detailAction.setId(v_charge_detailBean.getId());
				//textfield
		if(v_charge_detailBean.getChargeid()!=null)
			if(v_charge_detailBean.getChargeid().trim().length()>0) v_charge_detailAction.setChargeid(v_charge_detailBean.getChargeid());
		//textfield
		if(v_charge_detailBean.getUserkey()!=null)
			if(v_charge_detailBean.getUserkey().trim().length()>0) v_charge_detailAction.setUserkey(v_charge_detailBean.getUserkey());
		//textfield
		if(v_charge_detailBean.getCategory()!=null)
			if(v_charge_detailBean.getCategory().trim().length()>0) v_charge_detailAction.setCategory(v_charge_detailBean.getCategory());
		//textfield
		if(v_charge_detailBean.getStatus()!=null)
			if(v_charge_detailBean.getStatus().trim().length()>0) v_charge_detailAction.setStatus(v_charge_detailBean.getStatus());
		//textfield
		if(v_charge_detailBean.getInvalid()!=null)
			if(v_charge_detailBean.getInvalid().trim().length()>0) v_charge_detailAction.setInvalid(v_charge_detailBean.getInvalid());
		//textfield
		if(v_charge_detailBean.getName()!=null)
			if(v_charge_detailBean.getName().trim().length()>0) v_charge_detailAction.setName(v_charge_detailBean.getName());
		//textfield
		if(v_charge_detailBean.getUser_id()!=null)
			if(v_charge_detailBean.getUser_id().trim().length()>0) v_charge_detailAction.setUser_id(v_charge_detailBean.getUser_id());
		//textfield
		if(v_charge_detailBean.getIcon()!=null)
			if(v_charge_detailBean.getIcon().trim().length()>0) v_charge_detailAction.setIcon(v_charge_detailBean.getIcon());

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param V_charge_detailBean action句柄
	 * @param V_charge_detailAction action句柄
	 */
	private V_charge_detailBean setV_charge_detailBeanCommonAttributes(V_charge_detailBean v_charge_detailBean,V_charge_detailAction v_charge_detailAction){
				v_charge_detailBean.setChargeid(v_charge_detailAction.chargeid);
		v_charge_detailBean.setUserkey(v_charge_detailAction.userkey);
		v_charge_detailBean.setCategory(v_charge_detailAction.category);
		v_charge_detailBean.setStatus(v_charge_detailAction.status);
		v_charge_detailBean.setInvalid(v_charge_detailAction.invalid);
		v_charge_detailBean.setName(v_charge_detailAction.name);
		v_charge_detailBean.setUser_id(v_charge_detailAction.user_id);
		v_charge_detailBean.setIcon(v_charge_detailAction.icon);

		return v_charge_detailBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param v_charge_detailQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(V_charge_detailBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getChargeid().trim().length()>0)
			paramStr.append("&chargeid=").append(queryConditionsBean.getChargeid().trim());
		if(queryConditionsBean.getUserkey().trim().length()>0)
			paramStr.append("&userkey=").append(queryConditionsBean.getUserkey().trim());
		if(queryConditionsBean.getAmountFrom()!=null)
				paramStr.append("&amountFrom=").append(queryConditionsBean.getAmountFrom());
		if(queryConditionsBean.getAmountTo()!=null)
				paramStr.append("&amountTo=").append(queryConditionsBean.getAmountTo());
		if(queryConditionsBean.getCategory().trim().length()>0)
			paramStr.append("&category=").append(queryConditionsBean.getCategory().trim());
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
		if(queryConditionsBean.getName().trim().length()>0)
			paramStr.append("&name=").append(queryConditionsBean.getName().trim());
		if(queryConditionsBean.getUser_id().trim().length()>0)
			paramStr.append("&user_id=").append(queryConditionsBean.getUser_id().trim());
		if(queryConditionsBean.getIcon().trim().length()>0)
			paramStr.append("&icon=").append(queryConditionsBean.getIcon().trim());

		return paramStr.toString();
	}
}