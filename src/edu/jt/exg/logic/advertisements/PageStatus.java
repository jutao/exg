package edu.jt.exg.logic.advertisements;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.AdvertisementsAction;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param AdvertisementsAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(AdvertisementsAction advertisementsAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			advertisementsAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			advertisementsAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			advertisementsAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(advertisementsAction.start==null) advertisementsAction.start="0";
        else if(advertisementsAction.start.length()==0) advertisementsAction.start="0";
        if(advertisementsAction.range==null) advertisementsAction.range=ConstSetup.REFERENCE_RANGE;
        else if(advertisementsAction.range.length()==0) advertisementsAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(advertisementsAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param AdvertisementsAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(AdvertisementsAction advertisementsAction){
    	//获取记录范围*************************************************
    	advertisementsAction.action=advertisementsAction.request.getParameter("action");
        if(advertisementsAction.start==null) advertisementsAction.start="0";
        else if(advertisementsAction.start.length()==0) advertisementsAction.start="0";
        if(advertisementsAction.range==null) advertisementsAction.range=ConstSetup.REFERENCE_RANGE;
        else if(advertisementsAction.range.length()==0) advertisementsAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(advertisementsAction);
    }
    
    /**
	 * 设置排序
	 * @param AdvertisementsAction action句柄
	 */
    private void setOrderByMap(AdvertisementsAction advertisementsAction){
        advertisementsAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(AdvertisementsSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param AdvertisementsAction action句柄
	 */
	public void setControlsValues(AdvertisementsAction advertisementsAction){
//			InitPageControl.initCategoryMap(advertisementsAction);
		InitPageControl.initInvalidMap(advertisementsAction);
		InitPageControl.initTimestamp(advertisementsAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param AdvertisementsAction action句柄
	 * @param params 设置参数
	 */
	public AdvertisementsBean getQueryConditionsFromParams(AdvertisementsAction advertisementsAction,String params){
		AdvertisementsBean advertisementsBean=AdvertisementsUtility.getIocHandel().getBean("AdvertisementsBean",AdvertisementsBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("name=")==0){
			pos=tmp.indexOf("name=");
			advertisementsBean.setName(tmp.substring(pos+5,tmp.length()));
		}
//		if(array[i].indexOf("targetkey=")==0){
//			pos=tmp.indexOf("targetkey=");
//			advertisementsBean.setTargetkey(tmp.substring(pos+10,tmp.length()));
//		}
		if(array[i].indexOf("top_pic1=")==0){
			pos=tmp.indexOf("top_pic1=");
			advertisementsBean.setTop_pic1(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("url=")==0){
			pos=tmp.indexOf("url=");
			advertisementsBean.setUrl(tmp.substring(pos+4,tmp.length()));
		}
//		if(array[i].indexOf("category=")==0){
//			pos=tmp.indexOf("category=");
//			advertisementsBean.setCategory(tmp.substring(pos+9,tmp.length()));
//		}
		if(array[i].indexOf("displayFrom=")==0){
			pos=tmp.indexOf("displayFrom=");
			advertisementsBean.setDisplayFrom(Integer.valueOf(tmp.substring(pos+12,tmp.length())));
		}else if(array[i].indexOf("displayTo=")!=-1){
			pos=tmp.indexOf("displayTo=");
			advertisementsBean.setDisplayTo(Integer.valueOf(tmp.substring(pos+10,tmp.length())));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			advertisementsBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			advertisementsBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			advertisementsBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			advertisementsBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			advertisementsBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return advertisementsBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param AdvertisementsAction action句柄
	 */
	public AdvertisementsBean getQueryConditionsFromForm(AdvertisementsAction advertisementsAction){
		AdvertisementsBean advertisementsBean=AdvertisementsUtility.getIocHandel().getBean("AdvertisementsBean",AdvertisementsBean.class);
		advertisementsBean=setAdvertisementsBeanCommonAttributes(advertisementsBean,advertisementsAction);
				advertisementsBean.setDisplayFrom(advertisementsAction.displayFrom);
		advertisementsBean.setDisplayTo(advertisementsAction.displayTo);
		advertisementsAction.register_timeFrom=Utilities.setTimeStampFunction(advertisementsAction.register_timeDateFrom,advertisementsAction.register_timeHourFrom,advertisementsAction.register_timeMinuteFrom);
		advertisementsBean.setRegister_timeFrom(advertisementsAction.register_timeFrom);
		advertisementsAction.register_timeTo=Utilities.setTimeStampFunction(advertisementsAction.register_timeDateTo,advertisementsAction.register_timeHourTo,advertisementsAction.register_timeMinuteTo);
		advertisementsBean.setRegister_timeTo(advertisementsAction.register_timeTo);
		advertisementsAction.update_timeFrom=Utilities.setTimeStampFunction(advertisementsAction.update_timeDateFrom,advertisementsAction.update_timeHourFrom,advertisementsAction.update_timeMinuteFrom);
		advertisementsBean.setUpdate_timeFrom(advertisementsAction.update_timeFrom);
		advertisementsAction.update_timeTo=Utilities.setTimeStampFunction(advertisementsAction.update_timeDateTo,advertisementsAction.update_timeHourTo,advertisementsAction.update_timeMinuteTo);
		advertisementsBean.setUpdate_timeTo(advertisementsAction.update_timeTo);

		return advertisementsBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param AdvertisementsAction action句柄
	 */
	public String readControlsWrite2Datas(AdvertisementsAction advertisementsAction){
		String errorMsg="";
				AdvertisementsBean advertisementsBean=AdvertisementsUtility.getIocHandel().getBean("AdvertisementsBean",AdvertisementsBean.class);
		if(advertisementsAction.action.equals("create")) advertisementsBean.setId(Utilities.getRandomPK(true));
		else advertisementsBean.setId(advertisementsAction.id);
		advertisementsBean=setAdvertisementsBeanCommonAttributes(advertisementsBean,advertisementsAction);
		advertisementsBean.setDisplay(advertisementsAction.display);
		advertisementsBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		advertisementsBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		advertisementsAction.batisDao=AdvertisementsUtility.getIocHandel().getBean("AdvertisementsBatisDao",AdvertisementsBatisDao.class);
		if(advertisementsAction.action.equals("create")) errorMsg=Integer.toString(advertisementsAction.batisDao.insert(advertisementsBean));
		else errorMsg=Integer.toString(advertisementsAction.batisDao.updateByKey(advertisementsBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param AdvertisementsAction action句柄
	 */
	public void readDatasWrite2Controls(AdvertisementsAction advertisementsAction){
		
		
		
		
		
		
		advertisementsAction.batisDao=AdvertisementsUtility.getIocHandel().getBean("AdvertisementsBatisDao",AdvertisementsBatisDao.class);
		AdvertisementsBean advertisementsBean=advertisementsAction.batisDao.findByKey(advertisementsAction.id);
		
		
		
		write2ControlsCommon(advertisementsAction,advertisementsBean);
				if(advertisementsBean.getDisplay()!=null)
			if(advertisementsBean.getDisplay().intValue()>=0) advertisementsAction.setDisplay(advertisementsBean.getDisplay());
		//auto timestamp
		if(advertisementsAction.action.equals("detail")) advertisementsAction.setRegister_time(advertisementsBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(advertisementsAction.action.equals("detail")) advertisementsAction.setUpdate_time(advertisementsBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param AdvertisementsAction action句柄
	 * @param AdvertisementsBean action句柄
	 */
	public void readConditionsWrite2Controls(AdvertisementsAction advertisementsAction,AdvertisementsBean advertisementsBean){
		write2ControlsCommon(advertisementsAction,advertisementsBean);
				if(advertisementsBean.getDisplayFrom()!=null)
			if(advertisementsBean.getDisplayFrom().intValue()>=0) advertisementsAction.setDisplayFrom(advertisementsBean.getDisplayFrom());
		if(advertisementsBean.getDisplayTo()!=null)
			if(advertisementsBean.getDisplayTo().intValue()>=0) advertisementsAction.setDisplayTo(advertisementsBean.getDisplayTo());
		if(advertisementsBean.getRegister_timeFrom()!=null){
			advertisementsAction.setRegister_timeFrom(advertisementsBean.getRegister_timeFrom());
			advertisementsAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(advertisementsBean.getRegister_timeFrom()));
			cale.setTimeInMillis(advertisementsBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) advertisementsAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else advertisementsAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			advertisementsAction.setRegister_timeHourSelectFrom(advertisementsAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) advertisementsAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else advertisementsAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			advertisementsAction.setRegister_timeMinuteSelectFrom(advertisementsAction.register_timeMinuteFrom);
		}
		if(advertisementsBean.getRegister_timeTo()!=null){
			advertisementsAction.setRegister_timeTo(advertisementsBean.getRegister_timeTo());
			advertisementsAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(advertisementsBean.getRegister_timeTo()));
			cale.setTimeInMillis(advertisementsBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) advertisementsAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else advertisementsAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			advertisementsAction.setRegister_timeHourSelectTo(advertisementsAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) advertisementsAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else advertisementsAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			advertisementsAction.setRegister_timeMinuteSelectTo(advertisementsAction.register_timeMinuteTo);
		}
		if(advertisementsBean.getUpdate_timeFrom()!=null){
			advertisementsAction.setUpdate_timeFrom(advertisementsBean.getUpdate_timeFrom());
			advertisementsAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(advertisementsBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(advertisementsBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) advertisementsAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else advertisementsAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			advertisementsAction.setUpdate_timeHourSelectFrom(advertisementsAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) advertisementsAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else advertisementsAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			advertisementsAction.setUpdate_timeMinuteSelectFrom(advertisementsAction.update_timeMinuteFrom);
		}
		if(advertisementsBean.getUpdate_timeTo()!=null){
			advertisementsAction.setUpdate_timeTo(advertisementsBean.getUpdate_timeTo());
			advertisementsAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(advertisementsBean.getUpdate_timeTo()));
			cale.setTimeInMillis(advertisementsBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) advertisementsAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else advertisementsAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			advertisementsAction.setUpdate_timeHourSelectTo(advertisementsAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) advertisementsAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else advertisementsAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			advertisementsAction.setUpdate_timeMinuteSelectTo(advertisementsAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param AdvertisementsAction action句柄
	 * @param AdvertisementsBean action句柄
	 * @param type 控件类型
	 */
	public AdvertisementsBean wrapperAdvertisementsBean(AdvertisementsAction advertisementsAction,AdvertisementsBean advertisementsBean,String type){
				//上传照片显示***********************************************************************
		if(type.equals("show")) advertisementsBean.setTop_pic1(Utilities.getWrapperUploadFileLinkString(advertisementsAction.request,advertisementsBean.getTop_pic1(),"image"));
		else advertisementsBean.setTop_pic1(advertisementsBean.getTop_pic1());
//		//s:select***************************************************************************
//		InitPageControl.initCategoryMap(advertisementsAction);
//		advertisementsBean.setCategory(Utilities.getWrapperSelect(advertisementsBean.getCategory(),advertisementsAction.categoryMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(advertisementsAction);
		advertisementsBean.setInvalid(Utilities.getWrapperSelect(advertisementsBean.getInvalid(),advertisementsAction.invalidMap));

		return advertisementsBean;
	}
	
	/**
	 * 记录显示包装
	 * @param AdvertisementsAction action句柄
	 * @param type 控件类型
	 */
    public List<AdvertisementsBean> wrapperRecorders(AdvertisementsAction advertisementsAction,String type){
    	AdvertisementsBean advertisements=null;
    	List<AdvertisementsBean> newAdvertisementsList=AdvertisementsUtility.getIocHandel().getBean("List_AdvertisementsBean",java.util.ArrayList.class);
    	for(int i=0;i<advertisementsAction.advertisementsList.size();i++){
    		advertisements=advertisementsAction.advertisementsList.get(i);
    		advertisements=wrapperAdvertisementsBean(advertisementsAction,advertisements,type);
    		newAdvertisementsList.add(advertisements);
    	}
    	return newAdvertisementsList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param AdvertisementsAction action句柄
	 * @param AdvertisementsBean action句柄
	 */
	private void write2ControlsCommon(AdvertisementsAction advertisementsAction,AdvertisementsBean advertisementsBean){
		advertisementsAction.setId(advertisementsBean.getId());
				//textfield
		if(advertisementsBean.getName()!=null)
			if(advertisementsBean.getName().trim().length()>0) advertisementsAction.setName(advertisementsBean.getName());
//		//textfield
//		if(advertisementsBean.getTargetkey()!=null)
//			if(advertisementsBean.getTargetkey().trim().length()>0) advertisementsAction.setTargetkey(advertisementsBean.getTargetkey());
		//img upload
		if(advertisementsBean.getTop_pic1()!=null){
			if(advertisementsBean.getTop_pic1().trim().length()>0) advertisementsAction.setTop_pic1(advertisementsBean.getTop_pic1());
			else advertisementsAction.setTop_pic1("");
		}else advertisementsAction.setTop_pic1("");
		//textfield
		if(advertisementsBean.getUrl()!=null)
			if(advertisementsBean.getUrl().trim().length()>0) advertisementsAction.setUrl(advertisementsBean.getUrl());
//		//select
//		if(advertisementsBean.getCategory()!=null){
//			if(advertisementsBean.getCategory().trim().length()>0){
//				if(!advertisementsAction.action.equals("detail")){
//					advertisementsAction.setCategory(advertisementsBean.getCategory());
//					advertisementsAction.setCategorySelect(advertisementsBean.getCategory());
//				}else advertisementsAction.setCategory(Utilities.getWrapperSelect(advertisementsBean.getCategory(),advertisementsAction.categoryMap));
//			}
//		}
		//select
		if(advertisementsBean.getInvalid()!=null){
			if(advertisementsBean.getInvalid().trim().length()>0){
				if(!advertisementsAction.action.equals("detail")){
					advertisementsAction.setInvalid(advertisementsBean.getInvalid());
					advertisementsAction.setInvalidSelect(advertisementsBean.getInvalid());
				}else advertisementsAction.setInvalid(Utilities.getWrapperSelect(advertisementsBean.getInvalid(),advertisementsAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param AdvertisementsBean action句柄
	 * @param AdvertisementsAction action句柄
	 */
	private AdvertisementsBean setAdvertisementsBeanCommonAttributes(AdvertisementsBean advertisementsBean,AdvertisementsAction advertisementsAction){
				advertisementsBean.setName(advertisementsAction.name);
//		advertisementsBean.setTargetkey(advertisementsAction.targetkey);
		advertisementsBean.setTop_pic1(advertisementsAction.top_pic1);
		advertisementsBean.setUrl(advertisementsAction.url);
//		advertisementsBean.setCategory(advertisementsAction.category);
		advertisementsBean.setInvalid(advertisementsAction.invalid);

		return advertisementsBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param advertisementsQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(AdvertisementsBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getName().trim().length()>0)
			paramStr.append("&name=").append(queryConditionsBean.getName().trim());
//		if(queryConditionsBean.getTargetkey().trim().length()>0)
//			paramStr.append("&targetkey=").append(queryConditionsBean.getTargetkey().trim());
		if(queryConditionsBean.getTop_pic1().trim().length()>0)
			paramStr.append("&top_pic1=").append(queryConditionsBean.getTop_pic1().trim());
		if(queryConditionsBean.getUrl().trim().length()>0)
			paramStr.append("&url=").append(queryConditionsBean.getUrl().trim());
//		if(queryConditionsBean.getCategory()!=null)
//			if(queryConditionsBean.getCategory().trim().length()>0)
//				paramStr.append("&category=").append(queryConditionsBean.getCategory().trim());
		if(queryConditionsBean.getDisplayFrom()!=null)
				paramStr.append("&displayFrom=").append(queryConditionsBean.getDisplayFrom());
		if(queryConditionsBean.getDisplayTo()!=null)
				paramStr.append("&displayTo=").append(queryConditionsBean.getDisplayTo());
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