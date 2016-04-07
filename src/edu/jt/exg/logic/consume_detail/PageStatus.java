package edu.jt.exg.logic.consume_detail;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Consume_detailAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Consume_detailAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Consume_detailAction consume_detailAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			consume_detailAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			consume_detailAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			consume_detailAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(consume_detailAction.start==null) consume_detailAction.start="0";
        else if(consume_detailAction.start.length()==0) consume_detailAction.start="0";
        if(consume_detailAction.range==null) consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(consume_detailAction.range.length()==0) consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(consume_detailAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Consume_detailAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Consume_detailAction consume_detailAction){
    	//获取记录范围*************************************************
    	consume_detailAction.action=consume_detailAction.request.getParameter("action");
        if(consume_detailAction.start==null) consume_detailAction.start="0";
        else if(consume_detailAction.start.length()==0) consume_detailAction.start="0";
        if(consume_detailAction.range==null) consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        else if(consume_detailAction.range.length()==0) consume_detailAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(consume_detailAction);
    }
    
    /**
	 * 设置排序
	 * @param Consume_detailAction action句柄
	 */
    private void setOrderByMap(Consume_detailAction consume_detailAction){
        consume_detailAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Consume_detailSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Consume_detailAction action句柄
	 */
	public void setControlsValues(Consume_detailAction consume_detailAction){
			InitPageControl.initStatusMap(consume_detailAction);
		InitPageControl.initInvalidMap(consume_detailAction);
		InitPageControl.initTimestamp(consume_detailAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Consume_detailAction action句柄
	 * @param params 设置参数
	 */
	public Consume_detailBean getQueryConditionsFromParams(Consume_detailAction consume_detailAction,String params){
		Consume_detailBean consume_detailBean=Consume_detailUtility.getIocHandel().getBean("Consume_detailBean",Consume_detailBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("detailid=")==0){
			pos=tmp.indexOf("detailid=");
			consume_detailBean.setDetailid(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("taskkey=")==0){
			pos=tmp.indexOf("taskkey=");
			consume_detailBean.setTaskkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("quantityFrom=")==0){
			pos=tmp.indexOf("quantityFrom=");
			consume_detailBean.setQuantityFrom(Double.valueOf(tmp.substring(pos+13,tmp.length())));
		}else if(array[i].indexOf("quantityTo=")==0){
			pos=tmp.indexOf("quantityTo=");
			consume_detailBean.setQuantityTo(Double.valueOf(tmp.substring(pos+11,tmp.length())));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			consume_detailBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			consume_detailBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			consume_detailBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			consume_detailBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			consume_detailBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			consume_detailBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return consume_detailBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param Consume_detailAction action句柄
	 */
	public Consume_detailBean getQueryConditionsFromForm(Consume_detailAction consume_detailAction){
		Consume_detailBean consume_detailBean=Consume_detailUtility.getIocHandel().getBean("Consume_detailBean",Consume_detailBean.class);
		consume_detailBean=setConsume_detailBeanCommonAttributes(consume_detailBean,consume_detailAction);
				consume_detailBean.setQuantityFrom(consume_detailAction.quantityFrom);
		consume_detailBean.setQuantityTo(consume_detailAction.quantityTo);
		consume_detailAction.register_timeFrom=Utilities.setTimeStampFunction(consume_detailAction.register_timeDateFrom,consume_detailAction.register_timeHourFrom,consume_detailAction.register_timeMinuteFrom);
		consume_detailBean.setRegister_timeFrom(consume_detailAction.register_timeFrom);
		consume_detailAction.register_timeTo=Utilities.setTimeStampFunction(consume_detailAction.register_timeDateTo,consume_detailAction.register_timeHourTo,consume_detailAction.register_timeMinuteTo);
		consume_detailBean.setRegister_timeTo(consume_detailAction.register_timeTo);
		consume_detailAction.update_timeFrom=Utilities.setTimeStampFunction(consume_detailAction.update_timeDateFrom,consume_detailAction.update_timeHourFrom,consume_detailAction.update_timeMinuteFrom);
		consume_detailBean.setUpdate_timeFrom(consume_detailAction.update_timeFrom);
		consume_detailAction.update_timeTo=Utilities.setTimeStampFunction(consume_detailAction.update_timeDateTo,consume_detailAction.update_timeHourTo,consume_detailAction.update_timeMinuteTo);
		consume_detailBean.setUpdate_timeTo(consume_detailAction.update_timeTo);

		return consume_detailBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Consume_detailAction action句柄
	 */
	public String readControlsWrite2Datas(Consume_detailAction consume_detailAction){
		String errorMsg="";
				Consume_detailBean consume_detailBean=Consume_detailUtility.getIocHandel().getBean("Consume_detailBean",Consume_detailBean.class);
		if(consume_detailAction.action.equals("create")) consume_detailBean.setId(Utilities.getRandomPK(true));
		else consume_detailBean.setId(consume_detailAction.id);
		consume_detailBean=setConsume_detailBeanCommonAttributes(consume_detailBean,consume_detailAction);
		consume_detailBean.setQuantity(consume_detailAction.quantity);
		consume_detailBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		consume_detailBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		consume_detailAction.batisDao=Consume_detailUtility.getIocHandel().getBean("Consume_detailBatisDao",Consume_detailBatisDao.class);
		if(consume_detailAction.action.equals("create")) errorMsg=Integer.toString(consume_detailAction.batisDao.insert(consume_detailBean));
		else errorMsg=Integer.toString(consume_detailAction.batisDao.updateByKey(consume_detailBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param Consume_detailAction action句柄
	 */
	public void readDatasWrite2Controls(Consume_detailAction consume_detailAction){
		
		
		
		
		
		
		consume_detailAction.batisDao=Consume_detailUtility.getIocHandel().getBean("Consume_detailBatisDao",Consume_detailBatisDao.class);
		Consume_detailBean consume_detailBean=consume_detailAction.batisDao.findByKey(consume_detailAction.id);
		
		
		
		write2ControlsCommon(consume_detailAction,consume_detailBean);
				if(consume_detailBean.getQuantity()!=null)
			if(consume_detailBean.getQuantity().doubleValue()!=0) consume_detailAction.setQuantity(consume_detailBean.getQuantity());
		//auto timestamp
		if(consume_detailAction.action.equals("detail")) consume_detailAction.setRegister_time(consume_detailBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(consume_detailAction.action.equals("detail")) consume_detailAction.setUpdate_time(consume_detailBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param Consume_detailAction action句柄
	 * @param Consume_detailBean action句柄
	 */
	public void readConditionsWrite2Controls(Consume_detailAction consume_detailAction,Consume_detailBean consume_detailBean){
		write2ControlsCommon(consume_detailAction,consume_detailBean);
				if(consume_detailBean.getQuantityFrom()!=null)
			if(consume_detailBean.getQuantityFrom().doubleValue()!=0) consume_detailAction.setQuantityFrom(consume_detailBean.getQuantityFrom());
		if(consume_detailBean.getQuantityTo()!=null)
			if(consume_detailBean.getQuantityTo().doubleValue()!=0) consume_detailAction.setQuantityTo(consume_detailBean.getQuantityTo());
		if(consume_detailBean.getRegister_timeFrom()!=null){
			consume_detailAction.setRegister_timeFrom(consume_detailBean.getRegister_timeFrom());
			consume_detailAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(consume_detailBean.getRegister_timeFrom()));
			cale.setTimeInMillis(consume_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) consume_detailAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else consume_detailAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			consume_detailAction.setRegister_timeHourSelectFrom(consume_detailAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) consume_detailAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else consume_detailAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			consume_detailAction.setRegister_timeMinuteSelectFrom(consume_detailAction.register_timeMinuteFrom);
		}
		if(consume_detailBean.getRegister_timeTo()!=null){
			consume_detailAction.setRegister_timeTo(consume_detailBean.getRegister_timeTo());
			consume_detailAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(consume_detailBean.getRegister_timeTo()));
			cale.setTimeInMillis(consume_detailBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) consume_detailAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else consume_detailAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			consume_detailAction.setRegister_timeHourSelectTo(consume_detailAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) consume_detailAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else consume_detailAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			consume_detailAction.setRegister_timeMinuteSelectTo(consume_detailAction.register_timeMinuteTo);
		}
		if(consume_detailBean.getUpdate_timeFrom()!=null){
			consume_detailAction.setUpdate_timeFrom(consume_detailBean.getUpdate_timeFrom());
			consume_detailAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(consume_detailBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(consume_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) consume_detailAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else consume_detailAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			consume_detailAction.setUpdate_timeHourSelectFrom(consume_detailAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) consume_detailAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else consume_detailAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			consume_detailAction.setUpdate_timeMinuteSelectFrom(consume_detailAction.update_timeMinuteFrom);
		}
		if(consume_detailBean.getUpdate_timeTo()!=null){
			consume_detailAction.setUpdate_timeTo(consume_detailBean.getUpdate_timeTo());
			consume_detailAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(consume_detailBean.getUpdate_timeTo()));
			cale.setTimeInMillis(consume_detailBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) consume_detailAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else consume_detailAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			consume_detailAction.setUpdate_timeHourSelectTo(consume_detailAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) consume_detailAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else consume_detailAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			consume_detailAction.setUpdate_timeMinuteSelectTo(consume_detailAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param Consume_detailAction action句柄
	 * @param Consume_detailBean action句柄
	 * @param type 控件类型
	 */
	public Consume_detailBean wrapperConsume_detailBean(Consume_detailAction consume_detailAction,Consume_detailBean consume_detailBean,String type){
				//s:select***************************************************************************
		InitPageControl.initStatusMap(consume_detailAction);
		consume_detailBean.setStatus(Utilities.getWrapperSelect(consume_detailBean.getStatus(),consume_detailAction.statusMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(consume_detailAction);
		consume_detailBean.setInvalid(Utilities.getWrapperSelect(consume_detailBean.getInvalid(),consume_detailAction.invalidMap));

		return consume_detailBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Consume_detailAction action句柄
	 * @param type 控件类型
	 */
    public List<Consume_detailBean> wrapperRecorders(Consume_detailAction consume_detailAction,String type){
    	Consume_detailBean consume_detail=null;
    	List<Consume_detailBean> newConsume_detailList=Consume_detailUtility.getIocHandel().getBean("List_Consume_detailBean",java.util.ArrayList.class);
    	for(int i=0;i<consume_detailAction.consume_detailList.size();i++){
    		consume_detail=consume_detailAction.consume_detailList.get(i);
    		consume_detail=wrapperConsume_detailBean(consume_detailAction,consume_detail,type);
    		newConsume_detailList.add(consume_detail);
    	}
    	return newConsume_detailList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param Consume_detailAction action句柄
	 * @param Consume_detailBean action句柄
	 */
	private void write2ControlsCommon(Consume_detailAction consume_detailAction,Consume_detailBean consume_detailBean){
		consume_detailAction.setId(consume_detailBean.getId());
				//textfield
		if(consume_detailBean.getDetailid()!=null)
			if(consume_detailBean.getDetailid().trim().length()>0) consume_detailAction.setDetailid(consume_detailBean.getDetailid());
		//textfield
		if(consume_detailBean.getTaskkey()!=null)
			if(consume_detailBean.getTaskkey().trim().length()>0) consume_detailAction.setTaskkey(consume_detailBean.getTaskkey());
		//select
		if(consume_detailBean.getStatus()!=null){
			if(consume_detailBean.getStatus().trim().length()>0){
				if(!consume_detailAction.action.equals("detail")){
					consume_detailAction.setStatus(consume_detailBean.getStatus());
					consume_detailAction.setStatusSelect(consume_detailBean.getStatus());
				}else consume_detailAction.setStatus(Utilities.getWrapperSelect(consume_detailBean.getStatus(),consume_detailAction.statusMap));
			}
		}
		//select
		if(consume_detailBean.getInvalid()!=null){
			if(consume_detailBean.getInvalid().trim().length()>0){
				if(!consume_detailAction.action.equals("detail")){
					consume_detailAction.setInvalid(consume_detailBean.getInvalid());
					consume_detailAction.setInvalidSelect(consume_detailBean.getInvalid());
				}else consume_detailAction.setInvalid(Utilities.getWrapperSelect(consume_detailBean.getInvalid(),consume_detailAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param Consume_detailBean action句柄
	 * @param Consume_detailAction action句柄
	 */
	private Consume_detailBean setConsume_detailBeanCommonAttributes(Consume_detailBean consume_detailBean,Consume_detailAction consume_detailAction){
				consume_detailBean.setDetailid(consume_detailAction.detailid);
		consume_detailBean.setTaskkey(consume_detailAction.taskkey);
		consume_detailBean.setStatus(consume_detailAction.status);
		consume_detailBean.setInvalid(consume_detailAction.invalid);

		return consume_detailBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param consume_detailQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Consume_detailBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getDetailid().trim().length()>0)
			paramStr.append("&detailid=").append(queryConditionsBean.getDetailid().trim());
		if(queryConditionsBean.getTaskkey().trim().length()>0)
			paramStr.append("&taskkey=").append(queryConditionsBean.getTaskkey().trim());
		if(queryConditionsBean.getQuantityFrom()!=null)
				paramStr.append("&quantityFrom=").append(queryConditionsBean.getQuantityFrom());
		if(queryConditionsBean.getQuantityTo()!=null)
				paramStr.append("&quantityTo=").append(queryConditionsBean.getQuantityTo());
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