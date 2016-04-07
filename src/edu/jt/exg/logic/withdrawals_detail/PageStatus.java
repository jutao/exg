package edu.jt.exg.logic.withdrawals_detail;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Withdrawals_detailAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Withdrawals_detailAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Withdrawals_detailAction withdrawals_detailAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			withdrawals_detailAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			withdrawals_detailAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			withdrawals_detailAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(withdrawals_detailAction.start==null) withdrawals_detailAction.start="0";
        else if(withdrawals_detailAction.start.length()==0) withdrawals_detailAction.start="0";
        if(withdrawals_detailAction.range==null) withdrawals_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(withdrawals_detailAction.range.length()==0) withdrawals_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(withdrawals_detailAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Withdrawals_detailAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Withdrawals_detailAction withdrawals_detailAction){
    	//获取记录范围*************************************************
    	withdrawals_detailAction.action=withdrawals_detailAction.request.getParameter("action");
        if(withdrawals_detailAction.start==null) withdrawals_detailAction.start="0";
        else if(withdrawals_detailAction.start.length()==0) withdrawals_detailAction.start="0";
        if(withdrawals_detailAction.range==null) withdrawals_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(withdrawals_detailAction.range.length()==0) withdrawals_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(withdrawals_detailAction);
    }
    
    /**
	 * 设置排序
	 * @param Withdrawals_detailAction action句柄
	 */
    private void setOrderByMap(Withdrawals_detailAction withdrawals_detailAction){
        withdrawals_detailAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Withdrawals_detailSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Withdrawals_detailAction action句柄
	 */
	public void setControlsValues(Withdrawals_detailAction withdrawals_detailAction){
			InitPageControl.initStatusMap(withdrawals_detailAction);
		InitPageControl.initInvalidMap(withdrawals_detailAction);
		InitPageControl.initTimestamp(withdrawals_detailAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Withdrawals_detailAction action句柄
	 * @param params 设置参数
	 */
	public Withdrawals_detailBean getQueryConditionsFromParams(Withdrawals_detailAction withdrawals_detailAction,String params){
		Withdrawals_detailBean withdrawals_detailBean=Withdrawals_detailUtility.getIocHandel().getBean("Withdrawals_detailBean",Withdrawals_detailBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("chargeid=")==0){
			pos=tmp.indexOf("chargeid=");
			withdrawals_detailBean.setChargeid(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("userkey=")==0){
			pos=tmp.indexOf("userkey=");
			withdrawals_detailBean.setUserkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("amountFrom=")==0){
			pos=tmp.indexOf("amountFrom=");
			withdrawals_detailBean.setAmountFrom(Double.valueOf(tmp.substring(pos+11,tmp.length())));
		}else if(array[i].indexOf("amountTo=")==0){
			pos=tmp.indexOf("amountTo=");
			withdrawals_detailBean.setAmountTo(Double.valueOf(tmp.substring(pos+9,tmp.length())));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			withdrawals_detailBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			withdrawals_detailBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			withdrawals_detailBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			withdrawals_detailBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			withdrawals_detailBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			withdrawals_detailBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return withdrawals_detailBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param Withdrawals_detailAction action句柄
	 */
	public Withdrawals_detailBean getQueryConditionsFromForm(Withdrawals_detailAction withdrawals_detailAction){
		Withdrawals_detailBean withdrawals_detailBean=Withdrawals_detailUtility.getIocHandel().getBean("Withdrawals_detailBean",Withdrawals_detailBean.class);
		withdrawals_detailBean=setWithdrawals_detailBeanCommonAttributes(withdrawals_detailBean,withdrawals_detailAction);
				withdrawals_detailBean.setAmountFrom(withdrawals_detailAction.amountFrom);
		withdrawals_detailBean.setAmountTo(withdrawals_detailAction.amountTo);
		withdrawals_detailAction.register_timeFrom=Utilities.setTimeStampFunction(withdrawals_detailAction.register_timeDateFrom,withdrawals_detailAction.register_timeHourFrom,withdrawals_detailAction.register_timeMinuteFrom);
		withdrawals_detailBean.setRegister_timeFrom(withdrawals_detailAction.register_timeFrom);
		withdrawals_detailAction.register_timeTo=Utilities.setTimeStampFunction(withdrawals_detailAction.register_timeDateTo,withdrawals_detailAction.register_timeHourTo,withdrawals_detailAction.register_timeMinuteTo);
		withdrawals_detailBean.setRegister_timeTo(withdrawals_detailAction.register_timeTo);
		withdrawals_detailAction.update_timeFrom=Utilities.setTimeStampFunction(withdrawals_detailAction.update_timeDateFrom,withdrawals_detailAction.update_timeHourFrom,withdrawals_detailAction.update_timeMinuteFrom);
		withdrawals_detailBean.setUpdate_timeFrom(withdrawals_detailAction.update_timeFrom);
		withdrawals_detailAction.update_timeTo=Utilities.setTimeStampFunction(withdrawals_detailAction.update_timeDateTo,withdrawals_detailAction.update_timeHourTo,withdrawals_detailAction.update_timeMinuteTo);
		withdrawals_detailBean.setUpdate_timeTo(withdrawals_detailAction.update_timeTo);

		return withdrawals_detailBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Withdrawals_detailAction action句柄
	 */
	public String readControlsWrite2Datas(Withdrawals_detailAction withdrawals_detailAction){
		String errorMsg="";
				Withdrawals_detailBean withdrawals_detailBean=Withdrawals_detailUtility.getIocHandel().getBean("Withdrawals_detailBean",Withdrawals_detailBean.class);
		if(withdrawals_detailAction.action.equals("create")) withdrawals_detailBean.setId(Utilities.getRandomPK(true));
		else withdrawals_detailBean.setId(withdrawals_detailAction.id);
		withdrawals_detailBean=setWithdrawals_detailBeanCommonAttributes(withdrawals_detailBean,withdrawals_detailAction);
		withdrawals_detailBean.setAmount(withdrawals_detailAction.amount);
		withdrawals_detailBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		withdrawals_detailBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		withdrawals_detailAction.batisDao=Withdrawals_detailUtility.getIocHandel().getBean("Withdrawals_detailBatisDao",Withdrawals_detailBatisDao.class);
		if(withdrawals_detailAction.action.equals("create")) errorMsg=Integer.toString(withdrawals_detailAction.batisDao.insert(withdrawals_detailBean));
		else errorMsg=Integer.toString(withdrawals_detailAction.batisDao.updateByKey(withdrawals_detailBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param Withdrawals_detailAction action句柄
	 */
	public void readDatasWrite2Controls(Withdrawals_detailAction withdrawals_detailAction){
		
		
		
		
		
		
		withdrawals_detailAction.batisDao=Withdrawals_detailUtility.getIocHandel().getBean("Withdrawals_detailBatisDao",Withdrawals_detailBatisDao.class);
		Withdrawals_detailBean withdrawals_detailBean=withdrawals_detailAction.batisDao.findByKey(withdrawals_detailAction.id);
		
		
		
		write2ControlsCommon(withdrawals_detailAction,withdrawals_detailBean);
				if(withdrawals_detailBean.getAmount()!=null)
			if(withdrawals_detailBean.getAmount().doubleValue()!=0) withdrawals_detailAction.setAmount(withdrawals_detailBean.getAmount());
		//auto timestamp
		if(withdrawals_detailAction.action.equals("detail")) withdrawals_detailAction.setRegister_time(withdrawals_detailBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(withdrawals_detailAction.action.equals("detail")) withdrawals_detailAction.setUpdate_time(withdrawals_detailBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param Withdrawals_detailAction action句柄
	 * @param Withdrawals_detailBean action句柄
	 */
	public void readConditionsWrite2Controls(Withdrawals_detailAction withdrawals_detailAction,Withdrawals_detailBean withdrawals_detailBean){
		write2ControlsCommon(withdrawals_detailAction,withdrawals_detailBean);
				if(withdrawals_detailBean.getAmountFrom()!=null)
			if(withdrawals_detailBean.getAmountFrom().doubleValue()!=0) withdrawals_detailAction.setAmountFrom(withdrawals_detailBean.getAmountFrom());
		if(withdrawals_detailBean.getAmountTo()!=null)
			if(withdrawals_detailBean.getAmountTo().doubleValue()!=0) withdrawals_detailAction.setAmountTo(withdrawals_detailBean.getAmountTo());
		if(withdrawals_detailBean.getRegister_timeFrom()!=null){
			withdrawals_detailAction.setRegister_timeFrom(withdrawals_detailBean.getRegister_timeFrom());
			withdrawals_detailAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(withdrawals_detailBean.getRegister_timeFrom()));
			cale.setTimeInMillis(withdrawals_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) withdrawals_detailAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else withdrawals_detailAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			withdrawals_detailAction.setRegister_timeHourSelectFrom(withdrawals_detailAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) withdrawals_detailAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else withdrawals_detailAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			withdrawals_detailAction.setRegister_timeMinuteSelectFrom(withdrawals_detailAction.register_timeMinuteFrom);
		}
		if(withdrawals_detailBean.getRegister_timeTo()!=null){
			withdrawals_detailAction.setRegister_timeTo(withdrawals_detailBean.getRegister_timeTo());
			withdrawals_detailAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(withdrawals_detailBean.getRegister_timeTo()));
			cale.setTimeInMillis(withdrawals_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) withdrawals_detailAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else withdrawals_detailAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			withdrawals_detailAction.setRegister_timeHourSelectTo(withdrawals_detailAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) withdrawals_detailAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else withdrawals_detailAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			withdrawals_detailAction.setRegister_timeMinuteSelectTo(withdrawals_detailAction.register_timeMinuteTo);
		}
		if(withdrawals_detailBean.getUpdate_timeFrom()!=null){
			withdrawals_detailAction.setUpdate_timeFrom(withdrawals_detailBean.getUpdate_timeFrom());
			withdrawals_detailAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(withdrawals_detailBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(withdrawals_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) withdrawals_detailAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else withdrawals_detailAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			withdrawals_detailAction.setUpdate_timeHourSelectFrom(withdrawals_detailAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) withdrawals_detailAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else withdrawals_detailAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			withdrawals_detailAction.setUpdate_timeMinuteSelectFrom(withdrawals_detailAction.update_timeMinuteFrom);
		}
		if(withdrawals_detailBean.getUpdate_timeTo()!=null){
			withdrawals_detailAction.setUpdate_timeTo(withdrawals_detailBean.getUpdate_timeTo());
			withdrawals_detailAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(withdrawals_detailBean.getUpdate_timeTo()));
			cale.setTimeInMillis(withdrawals_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) withdrawals_detailAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else withdrawals_detailAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			withdrawals_detailAction.setUpdate_timeHourSelectTo(withdrawals_detailAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) withdrawals_detailAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else withdrawals_detailAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			withdrawals_detailAction.setUpdate_timeMinuteSelectTo(withdrawals_detailAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param Withdrawals_detailAction action句柄
	 * @param Withdrawals_detailBean action句柄
	 * @param type 控件类型
	 */
	public Withdrawals_detailBean wrapperWithdrawals_detailBean(Withdrawals_detailAction withdrawals_detailAction,Withdrawals_detailBean withdrawals_detailBean,String type){
				//s:select***************************************************************************
		InitPageControl.initStatusMap(withdrawals_detailAction);
		withdrawals_detailBean.setStatus(Utilities.getWrapperSelect(withdrawals_detailBean.getStatus(),withdrawals_detailAction.statusMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(withdrawals_detailAction);
		withdrawals_detailBean.setInvalid(Utilities.getWrapperSelect(withdrawals_detailBean.getInvalid(),withdrawals_detailAction.invalidMap));

		return withdrawals_detailBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Withdrawals_detailAction action句柄
	 * @param type 控件类型
	 */
    public List<Withdrawals_detailBean> wrapperRecorders(Withdrawals_detailAction withdrawals_detailAction,String type){
    	Withdrawals_detailBean withdrawals_detail=null;
    	List<Withdrawals_detailBean> newWithdrawals_detailList=Withdrawals_detailUtility.getIocHandel().getBean("List_Withdrawals_detailBean",java.util.ArrayList.class);
    	for(int i=0;i<withdrawals_detailAction.withdrawals_detailList.size();i++){
    		withdrawals_detail=withdrawals_detailAction.withdrawals_detailList.get(i);
    		withdrawals_detail=wrapperWithdrawals_detailBean(withdrawals_detailAction,withdrawals_detail,type);
    		newWithdrawals_detailList.add(withdrawals_detail);
    	}
    	return newWithdrawals_detailList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param Withdrawals_detailAction action句柄
	 * @param Withdrawals_detailBean action句柄
	 */
	private void write2ControlsCommon(Withdrawals_detailAction withdrawals_detailAction,Withdrawals_detailBean withdrawals_detailBean){
		withdrawals_detailAction.setId(withdrawals_detailBean.getId());
				//textfield
		if(withdrawals_detailBean.getChargeid()!=null)
			if(withdrawals_detailBean.getChargeid().trim().length()>0) withdrawals_detailAction.setChargeid(withdrawals_detailBean.getChargeid());
		//textfield
		if(withdrawals_detailBean.getUserkey()!=null)
			if(withdrawals_detailBean.getUserkey().trim().length()>0) withdrawals_detailAction.setUserkey(withdrawals_detailBean.getUserkey());
		//select
		if(withdrawals_detailBean.getStatus()!=null){
			if(withdrawals_detailBean.getStatus().trim().length()>0){
				if(!withdrawals_detailAction.action.equals("detail")){
					withdrawals_detailAction.setStatus(withdrawals_detailBean.getStatus());
					withdrawals_detailAction.setStatusSelect(withdrawals_detailBean.getStatus());
				}else withdrawals_detailAction.setStatus(Utilities.getWrapperSelect(withdrawals_detailBean.getStatus(),withdrawals_detailAction.statusMap));
			}
		}
		//select
		if(withdrawals_detailBean.getInvalid()!=null){
			if(withdrawals_detailBean.getInvalid().trim().length()>0){
				if(!withdrawals_detailAction.action.equals("detail")){
					withdrawals_detailAction.setInvalid(withdrawals_detailBean.getInvalid());
					withdrawals_detailAction.setInvalidSelect(withdrawals_detailBean.getInvalid());
				}else withdrawals_detailAction.setInvalid(Utilities.getWrapperSelect(withdrawals_detailBean.getInvalid(),withdrawals_detailAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param Withdrawals_detailBean action句柄
	 * @param Withdrawals_detailAction action句柄
	 */
	private Withdrawals_detailBean setWithdrawals_detailBeanCommonAttributes(Withdrawals_detailBean withdrawals_detailBean,Withdrawals_detailAction withdrawals_detailAction){
				withdrawals_detailBean.setChargeid(withdrawals_detailAction.chargeid);
		withdrawals_detailBean.setUserkey(withdrawals_detailAction.userkey);
		withdrawals_detailBean.setStatus(withdrawals_detailAction.status);
		withdrawals_detailBean.setInvalid(withdrawals_detailAction.invalid);

		return withdrawals_detailBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param withdrawals_detailQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Withdrawals_detailBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getChargeid().trim().length()>0)
			paramStr.append("&chargeid=").append(queryConditionsBean.getChargeid().trim());
		if(queryConditionsBean.getUserkey().trim().length()>0)
			paramStr.append("&userkey=").append(queryConditionsBean.getUserkey().trim());
		if(queryConditionsBean.getAmountFrom()!=null)
				paramStr.append("&amountFrom=").append(queryConditionsBean.getAmountFrom());
		if(queryConditionsBean.getAmountTo()!=null)
				paramStr.append("&amountTo=").append(queryConditionsBean.getAmountTo());
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