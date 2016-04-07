package edu.jt.exg.logic.charge_detail;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Charge_detailAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Charge_detailAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Charge_detailAction charge_detailAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			charge_detailAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			charge_detailAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			charge_detailAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(charge_detailAction.start==null) charge_detailAction.start="0";
        else if(charge_detailAction.start.length()==0) charge_detailAction.start="0";
        if(charge_detailAction.range==null) charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(charge_detailAction.range.length()==0) charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(charge_detailAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Charge_detailAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Charge_detailAction charge_detailAction){
    	//获取记录范围*************************************************
    	charge_detailAction.action=charge_detailAction.request.getParameter("action");
        if(charge_detailAction.start==null) charge_detailAction.start="0";
        else if(charge_detailAction.start.length()==0) charge_detailAction.start="0";
        if(charge_detailAction.range==null) charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(charge_detailAction.range.length()==0) charge_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(charge_detailAction);
    }
    
    /**
	 * 设置排序
	 * @param Charge_detailAction action句柄
	 */
    private void setOrderByMap(Charge_detailAction charge_detailAction){
        charge_detailAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Charge_detailSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Charge_detailAction action句柄
	 */
	public void setControlsValues(Charge_detailAction charge_detailAction){
			InitPageControl.initCategoryMap(charge_detailAction);
		InitPageControl.initStatusMap(charge_detailAction);
		InitPageControl.initInvalidMap(charge_detailAction);
		InitPageControl.initTimestamp(charge_detailAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Charge_detailAction action句柄
	 * @param params 设置参数
	 */
	public Charge_detailBean getQueryConditionsFromParams(Charge_detailAction charge_detailAction,String params){
		Charge_detailBean charge_detailBean=Charge_detailUtility.getIocHandel().getBean("Charge_detailBean",Charge_detailBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("chargeid=")==0){
			pos=tmp.indexOf("chargeid=");
			charge_detailBean.setChargeid(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("userkey=")==0){
			pos=tmp.indexOf("userkey=");
			charge_detailBean.setUserkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("amountFrom=")==0){
			pos=tmp.indexOf("amountFrom=");
			charge_detailBean.setAmountFrom(Double.valueOf(tmp.substring(pos+11,tmp.length())));
		}else if(array[i].indexOf("amountTo=")==0){
			pos=tmp.indexOf("amountTo=");
			charge_detailBean.setAmountTo(Double.valueOf(tmp.substring(pos+9,tmp.length())));
		}
		if(array[i].indexOf("category=")==0){
			pos=tmp.indexOf("category=");
			charge_detailBean.setCategory(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			charge_detailBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			charge_detailBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			charge_detailBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			charge_detailBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			charge_detailBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			charge_detailBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return charge_detailBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param Charge_detailAction action句柄
	 */
	public Charge_detailBean getQueryConditionsFromForm(Charge_detailAction charge_detailAction){
		Charge_detailBean charge_detailBean=Charge_detailUtility.getIocHandel().getBean("Charge_detailBean",Charge_detailBean.class);
		charge_detailBean=setCharge_detailBeanCommonAttributes(charge_detailBean,charge_detailAction);
				charge_detailBean.setAmountFrom(charge_detailAction.amountFrom);
		charge_detailBean.setAmountTo(charge_detailAction.amountTo);
		charge_detailAction.register_timeFrom=Utilities.setTimeStampFunction(charge_detailAction.register_timeDateFrom,charge_detailAction.register_timeHourFrom,charge_detailAction.register_timeMinuteFrom);
		charge_detailBean.setRegister_timeFrom(charge_detailAction.register_timeFrom);
		charge_detailAction.register_timeTo=Utilities.setTimeStampFunction(charge_detailAction.register_timeDateTo,charge_detailAction.register_timeHourTo,charge_detailAction.register_timeMinuteTo);
		charge_detailBean.setRegister_timeTo(charge_detailAction.register_timeTo);
		charge_detailAction.update_timeFrom=Utilities.setTimeStampFunction(charge_detailAction.update_timeDateFrom,charge_detailAction.update_timeHourFrom,charge_detailAction.update_timeMinuteFrom);
		charge_detailBean.setUpdate_timeFrom(charge_detailAction.update_timeFrom);
		charge_detailAction.update_timeTo=Utilities.setTimeStampFunction(charge_detailAction.update_timeDateTo,charge_detailAction.update_timeHourTo,charge_detailAction.update_timeMinuteTo);
		charge_detailBean.setUpdate_timeTo(charge_detailAction.update_timeTo);

		return charge_detailBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Charge_detailAction action句柄
	 */
	public String readControlsWrite2Datas(Charge_detailAction charge_detailAction){
		String errorMsg="";
				Charge_detailBean charge_detailBean=Charge_detailUtility.getIocHandel().getBean("Charge_detailBean",Charge_detailBean.class);
		if(charge_detailAction.action.equals("create")) charge_detailBean.setId(Utilities.getRandomPK(true));
		else charge_detailBean.setId(charge_detailAction.id);
		charge_detailBean=setCharge_detailBeanCommonAttributes(charge_detailBean,charge_detailAction);
		charge_detailBean.setAmount(charge_detailAction.amount);
		charge_detailBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		charge_detailBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		charge_detailAction.batisDao=Charge_detailUtility.getIocHandel().getBean("Charge_detailBatisDao",Charge_detailBatisDao.class);
		if(charge_detailAction.action.equals("create")) errorMsg=Integer.toString(charge_detailAction.batisDao.insert(charge_detailBean));
		else errorMsg=Integer.toString(charge_detailAction.batisDao.updateByKey(charge_detailBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param Charge_detailAction action句柄
	 */
	public void readDatasWrite2Controls(Charge_detailAction charge_detailAction){
		
		
		
		
		
		
		charge_detailAction.batisDao=Charge_detailUtility.getIocHandel().getBean("Charge_detailBatisDao",Charge_detailBatisDao.class);
		Charge_detailBean charge_detailBean=charge_detailAction.batisDao.findByKey(charge_detailAction.id);
		
		
		
		write2ControlsCommon(charge_detailAction,charge_detailBean);
				if(charge_detailBean.getAmount()!=null)
			if(charge_detailBean.getAmount().doubleValue()!=0) charge_detailAction.setAmount(charge_detailBean.getAmount());
		//auto timestamp
		if(charge_detailAction.action.equals("detail")) charge_detailAction.setRegister_time(charge_detailBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(charge_detailAction.action.equals("detail")) charge_detailAction.setUpdate_time(charge_detailBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param Charge_detailAction action句柄
	 * @param Charge_detailBean action句柄
	 */
	public void readConditionsWrite2Controls(Charge_detailAction charge_detailAction,Charge_detailBean charge_detailBean){
		write2ControlsCommon(charge_detailAction,charge_detailBean);
				if(charge_detailBean.getAmountFrom()!=null)
			if(charge_detailBean.getAmountFrom().doubleValue()!=0) charge_detailAction.setAmountFrom(charge_detailBean.getAmountFrom());
		if(charge_detailBean.getAmountTo()!=null)
			if(charge_detailBean.getAmountTo().doubleValue()!=0) charge_detailAction.setAmountTo(charge_detailBean.getAmountTo());
		if(charge_detailBean.getRegister_timeFrom()!=null){
			charge_detailAction.setRegister_timeFrom(charge_detailBean.getRegister_timeFrom());
			charge_detailAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(charge_detailBean.getRegister_timeFrom()));
			cale.setTimeInMillis(charge_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) charge_detailAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else charge_detailAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			charge_detailAction.setRegister_timeHourSelectFrom(charge_detailAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) charge_detailAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else charge_detailAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			charge_detailAction.setRegister_timeMinuteSelectFrom(charge_detailAction.register_timeMinuteFrom);
		}
		if(charge_detailBean.getRegister_timeTo()!=null){
			charge_detailAction.setRegister_timeTo(charge_detailBean.getRegister_timeTo());
			charge_detailAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(charge_detailBean.getRegister_timeTo()));
			cale.setTimeInMillis(charge_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) charge_detailAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else charge_detailAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			charge_detailAction.setRegister_timeHourSelectTo(charge_detailAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) charge_detailAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else charge_detailAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			charge_detailAction.setRegister_timeMinuteSelectTo(charge_detailAction.register_timeMinuteTo);
		}
		if(charge_detailBean.getUpdate_timeFrom()!=null){
			charge_detailAction.setUpdate_timeFrom(charge_detailBean.getUpdate_timeFrom());
			charge_detailAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(charge_detailBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(charge_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) charge_detailAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else charge_detailAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			charge_detailAction.setUpdate_timeHourSelectFrom(charge_detailAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) charge_detailAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else charge_detailAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			charge_detailAction.setUpdate_timeMinuteSelectFrom(charge_detailAction.update_timeMinuteFrom);
		}
		if(charge_detailBean.getUpdate_timeTo()!=null){
			charge_detailAction.setUpdate_timeTo(charge_detailBean.getUpdate_timeTo());
			charge_detailAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(charge_detailBean.getUpdate_timeTo()));
			cale.setTimeInMillis(charge_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) charge_detailAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else charge_detailAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			charge_detailAction.setUpdate_timeHourSelectTo(charge_detailAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) charge_detailAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else charge_detailAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			charge_detailAction.setUpdate_timeMinuteSelectTo(charge_detailAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param Charge_detailAction action句柄
	 * @param Charge_detailBean action句柄
	 * @param type 控件类型
	 */
	public Charge_detailBean wrapperCharge_detailBean(Charge_detailAction charge_detailAction,Charge_detailBean charge_detailBean,String type){
				//s:select***************************************************************************
		InitPageControl.initCategoryMap(charge_detailAction);
		charge_detailBean.setCategory(Utilities.getWrapperSelect(charge_detailBean.getCategory(),charge_detailAction.categoryMap));
		//s:select***************************************************************************
		InitPageControl.initStatusMap(charge_detailAction);
		charge_detailBean.setStatus(Utilities.getWrapperSelect(charge_detailBean.getStatus(),charge_detailAction.statusMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(charge_detailAction);
		charge_detailBean.setInvalid(Utilities.getWrapperSelect(charge_detailBean.getInvalid(),charge_detailAction.invalidMap));

		return charge_detailBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Charge_detailAction action句柄
	 * @param type 控件类型
	 */
    public List<Charge_detailBean> wrapperRecorders(Charge_detailAction charge_detailAction,String type){
    	Charge_detailBean charge_detail=null;
    	List<Charge_detailBean> newCharge_detailList=Charge_detailUtility.getIocHandel().getBean("List_Charge_detailBean",java.util.ArrayList.class);
    	for(int i=0;i<charge_detailAction.charge_detailList.size();i++){
    		charge_detail=charge_detailAction.charge_detailList.get(i);
    		charge_detail=wrapperCharge_detailBean(charge_detailAction,charge_detail,type);
    		newCharge_detailList.add(charge_detail);
    	}
    	return newCharge_detailList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param Charge_detailAction action句柄
	 * @param Charge_detailBean action句柄
	 */
	private void write2ControlsCommon(Charge_detailAction charge_detailAction,Charge_detailBean charge_detailBean){
		charge_detailAction.setId(charge_detailBean.getId());
				//textfield
		if(charge_detailBean.getChargeid()!=null)
			if(charge_detailBean.getChargeid().trim().length()>0) charge_detailAction.setChargeid(charge_detailBean.getChargeid());
		//textfield
		if(charge_detailBean.getUserkey()!=null)
			if(charge_detailBean.getUserkey().trim().length()>0) charge_detailAction.setUserkey(charge_detailBean.getUserkey());
		//select
		if(charge_detailBean.getCategory()!=null){
			if(charge_detailBean.getCategory().trim().length()>0){
				if(!charge_detailAction.action.equals("detail")){
					charge_detailAction.setCategory(charge_detailBean.getCategory());
					charge_detailAction.setCategorySelect(charge_detailBean.getCategory());
				}else charge_detailAction.setCategory(Utilities.getWrapperSelect(charge_detailBean.getCategory(),charge_detailAction.categoryMap));
			}
		}
		//select
		if(charge_detailBean.getStatus()!=null){
			if(charge_detailBean.getStatus().trim().length()>0){
				if(!charge_detailAction.action.equals("detail")){
					charge_detailAction.setStatus(charge_detailBean.getStatus());
					charge_detailAction.setStatusSelect(charge_detailBean.getStatus());
				}else charge_detailAction.setStatus(Utilities.getWrapperSelect(charge_detailBean.getStatus(),charge_detailAction.statusMap));
			}
		}
		//select
		if(charge_detailBean.getInvalid()!=null){
			if(charge_detailBean.getInvalid().trim().length()>0){
				if(!charge_detailAction.action.equals("detail")){
					charge_detailAction.setInvalid(charge_detailBean.getInvalid());
					charge_detailAction.setInvalidSelect(charge_detailBean.getInvalid());
				}else charge_detailAction.setInvalid(Utilities.getWrapperSelect(charge_detailBean.getInvalid(),charge_detailAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param Charge_detailBean action句柄
	 * @param Charge_detailAction action句柄
	 */
	private Charge_detailBean setCharge_detailBeanCommonAttributes(Charge_detailBean charge_detailBean,Charge_detailAction charge_detailAction){
				charge_detailBean.setChargeid(charge_detailAction.chargeid);
		charge_detailBean.setUserkey(charge_detailAction.userkey);
		charge_detailBean.setCategory(charge_detailAction.category);
		charge_detailBean.setStatus(charge_detailAction.status);
		charge_detailBean.setInvalid(charge_detailAction.invalid);

		return charge_detailBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param charge_detailQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Charge_detailBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getChargeid().trim().length()>0)
			paramStr.append("&chargeid=").append(queryConditionsBean.getChargeid().trim());
		if(queryConditionsBean.getUserkey().trim().length()>0)
			paramStr.append("&userkey=").append(queryConditionsBean.getUserkey().trim());
		if(queryConditionsBean.getAmountFrom()!=null)
				paramStr.append("&amountFrom=").append(queryConditionsBean.getAmountFrom());
		if(queryConditionsBean.getAmountTo()!=null)
				paramStr.append("&amountTo=").append(queryConditionsBean.getAmountTo());
		if(queryConditionsBean.getCategory()!=null)
			if(queryConditionsBean.getCategory().trim().length()>0)
				paramStr.append("&category=").append(queryConditionsBean.getCategory().trim());
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