package edu.jt.exg.logic.category;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.CategoryAction;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param CategoryAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(CategoryAction categoryAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			categoryAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			categoryAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			categoryAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(categoryAction.start==null) categoryAction.start="0";
        else if(categoryAction.start.length()==0) categoryAction.start="0";
        if(categoryAction.range==null) categoryAction.range=ConstSetup.REFERENCE_RANGE;
        else if(categoryAction.range.length()==0) categoryAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(categoryAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param CategoryAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(CategoryAction categoryAction){
    	//获取记录范围*************************************************
    	categoryAction.action=categoryAction.request.getParameter("action");
        if(categoryAction.start==null) categoryAction.start="0";
        else if(categoryAction.start.length()==0) categoryAction.start="0";
        if(categoryAction.range==null) categoryAction.range=ConstSetup.REFERENCE_RANGE;
        else if(categoryAction.range.length()==0) categoryAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(categoryAction);
    }
    
    /**
	 * 设置排序
	 * @param CategoryAction action句柄
	 */
    private void setOrderByMap(CategoryAction categoryAction){
        categoryAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(CategorySqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param CategoryAction action句柄
	 */
	public void setControlsValues(CategoryAction categoryAction){
			InitPageControl.initInvalidMap(categoryAction);
		InitPageControl.initTimestamp(categoryAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param CategoryAction action句柄
	 * @param params 设置参数
	 */
	public CategoryBean getQueryConditionsFromParams(CategoryAction categoryAction,String params){
		CategoryBean categoryBean=CategoryUtility.getIocHandel().getBean("CategoryBean",CategoryBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("code=")==0){
			pos=tmp.indexOf("code=");
			categoryBean.setCode(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("name=")==0){
			pos=tmp.indexOf("name=");
			categoryBean.setName(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("displayFrom=")==0){
			pos=tmp.indexOf("displayFrom=");
			categoryBean.setDisplayFrom(Integer.valueOf(tmp.substring(pos+12,tmp.length())));
		}else if(array[i].indexOf("displayTo=")!=-1){
			pos=tmp.indexOf("displayTo=");
			categoryBean.setDisplayTo(Integer.valueOf(tmp.substring(pos+10,tmp.length())));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			categoryBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			categoryBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			categoryBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			categoryBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			categoryBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return categoryBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param CategoryAction action句柄
	 */
	public CategoryBean getQueryConditionsFromForm(CategoryAction categoryAction){
		CategoryBean categoryBean=CategoryUtility.getIocHandel().getBean("CategoryBean",CategoryBean.class);
		categoryBean=setCategoryBeanCommonAttributes(categoryBean,categoryAction);
				categoryBean.setDisplayFrom(categoryAction.displayFrom);
		categoryBean.setDisplayTo(categoryAction.displayTo);
		categoryAction.register_timeFrom=Utilities.setTimeStampFunction(categoryAction.register_timeDateFrom,categoryAction.register_timeHourFrom,categoryAction.register_timeMinuteFrom);
		categoryBean.setRegister_timeFrom(categoryAction.register_timeFrom);
		categoryAction.register_timeTo=Utilities.setTimeStampFunction(categoryAction.register_timeDateTo,categoryAction.register_timeHourTo,categoryAction.register_timeMinuteTo);
		categoryBean.setRegister_timeTo(categoryAction.register_timeTo);
		categoryAction.update_timeFrom=Utilities.setTimeStampFunction(categoryAction.update_timeDateFrom,categoryAction.update_timeHourFrom,categoryAction.update_timeMinuteFrom);
		categoryBean.setUpdate_timeFrom(categoryAction.update_timeFrom);
		categoryAction.update_timeTo=Utilities.setTimeStampFunction(categoryAction.update_timeDateTo,categoryAction.update_timeHourTo,categoryAction.update_timeMinuteTo);
		categoryBean.setUpdate_timeTo(categoryAction.update_timeTo);

		return categoryBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param CategoryAction action句柄
	 */
	public String readControlsWrite2Datas(CategoryAction categoryAction){
		String errorMsg="";
				CategoryBean categoryBean=CategoryUtility.getIocHandel().getBean("CategoryBean",CategoryBean.class);
		if(categoryAction.action.equals("create")) categoryBean.setId(Utilities.getRandomPK(true));
		else categoryBean.setId(categoryAction.id);
		categoryBean=setCategoryBeanCommonAttributes(categoryBean,categoryAction);
		categoryBean.setDisplay(categoryAction.display);
		categoryBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		categoryBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		categoryAction.batisDao=CategoryUtility.getIocHandel().getBean("CategoryBatisDao",CategoryBatisDao.class);
		if(categoryAction.action.equals("create")) errorMsg=Integer.toString(categoryAction.batisDao.insert(categoryBean));
		else errorMsg=Integer.toString(categoryAction.batisDao.updateByKey(categoryBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param CategoryAction action句柄
	 */
	public void readDatasWrite2Controls(CategoryAction categoryAction){
		
		
		
		
		
		
		categoryAction.batisDao=CategoryUtility.getIocHandel().getBean("CategoryBatisDao",CategoryBatisDao.class);
		CategoryBean categoryBean=categoryAction.batisDao.findByKey(categoryAction.id);
		
		
		
		write2ControlsCommon(categoryAction,categoryBean);
				if(categoryBean.getDisplay()!=null)
			if(categoryBean.getDisplay().intValue()>=0) categoryAction.setDisplay(categoryBean.getDisplay());
		//auto timestamp
		if(categoryAction.action.equals("detail")) categoryAction.setRegister_time(categoryBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(categoryAction.action.equals("detail")) categoryAction.setUpdate_time(categoryBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param CategoryAction action句柄
	 * @param CategoryBean action句柄
	 */
	public void readConditionsWrite2Controls(CategoryAction categoryAction,CategoryBean categoryBean){
		write2ControlsCommon(categoryAction,categoryBean);
				if(categoryBean.getDisplayFrom()!=null)
			if(categoryBean.getDisplayFrom().intValue()>=0) categoryAction.setDisplayFrom(categoryBean.getDisplayFrom());
		if(categoryBean.getDisplayTo()!=null)
			if(categoryBean.getDisplayTo().intValue()>=0) categoryAction.setDisplayTo(categoryBean.getDisplayTo());
		if(categoryBean.getRegister_timeFrom()!=null){
			categoryAction.setRegister_timeFrom(categoryBean.getRegister_timeFrom());
			categoryAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(categoryBean.getRegister_timeFrom()));
			cale.setTimeInMillis(categoryBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) categoryAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else categoryAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			categoryAction.setRegister_timeHourSelectFrom(categoryAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) categoryAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else categoryAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			categoryAction.setRegister_timeMinuteSelectFrom(categoryAction.register_timeMinuteFrom);
		}
		if(categoryBean.getRegister_timeTo()!=null){
			categoryAction.setRegister_timeTo(categoryBean.getRegister_timeTo());
			categoryAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(categoryBean.getRegister_timeTo()));
			cale.setTimeInMillis(categoryBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) categoryAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else categoryAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			categoryAction.setRegister_timeHourSelectTo(categoryAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) categoryAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else categoryAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			categoryAction.setRegister_timeMinuteSelectTo(categoryAction.register_timeMinuteTo);
		}
		if(categoryBean.getUpdate_timeFrom()!=null){
			categoryAction.setUpdate_timeFrom(categoryBean.getUpdate_timeFrom());
			categoryAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(categoryBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(categoryBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) categoryAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else categoryAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			categoryAction.setUpdate_timeHourSelectFrom(categoryAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) categoryAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else categoryAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			categoryAction.setUpdate_timeMinuteSelectFrom(categoryAction.update_timeMinuteFrom);
		}
		if(categoryBean.getUpdate_timeTo()!=null){
			categoryAction.setUpdate_timeTo(categoryBean.getUpdate_timeTo());
			categoryAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(categoryBean.getUpdate_timeTo()));
			cale.setTimeInMillis(categoryBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) categoryAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else categoryAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			categoryAction.setUpdate_timeHourSelectTo(categoryAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) categoryAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else categoryAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			categoryAction.setUpdate_timeMinuteSelectTo(categoryAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param CategoryAction action句柄
	 * @param CategoryBean action句柄
	 * @param type 控件类型
	 */
	public CategoryBean wrapperCategoryBean(CategoryAction categoryAction,CategoryBean categoryBean,String type){
				//s:select***************************************************************************
		InitPageControl.initInvalidMap(categoryAction);
		categoryBean.setInvalid(Utilities.getWrapperSelect(categoryBean.getInvalid(),categoryAction.invalidMap));

		return categoryBean;
	}
	
	/**
	 * 记录显示包装
	 * @param CategoryAction action句柄
	 * @param type 控件类型
	 */
    public List<CategoryBean> wrapperRecorders(CategoryAction categoryAction,String type){
    	CategoryBean category=null;
    	List<CategoryBean> newCategoryList=CategoryUtility.getIocHandel().getBean("List_CategoryBean",java.util.ArrayList.class);
    	for(int i=0;i<categoryAction.categoryList.size();i++){
    		category=categoryAction.categoryList.get(i);
    		category=wrapperCategoryBean(categoryAction,category,type);
    		newCategoryList.add(category);
    	}
    	return newCategoryList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param CategoryAction action句柄
	 * @param CategoryBean action句柄
	 */
	private void write2ControlsCommon(CategoryAction categoryAction,CategoryBean categoryBean){
		categoryAction.setId(categoryBean.getId());
				//textfield
		if(categoryBean.getCode()!=null)
			if(categoryBean.getCode().trim().length()>0) categoryAction.setCode(categoryBean.getCode());
		//textfield
		if(categoryBean.getName()!=null)
			if(categoryBean.getName().trim().length()>0) categoryAction.setName(categoryBean.getName());
		//select
		if(categoryBean.getInvalid()!=null){
			if(categoryBean.getInvalid().trim().length()>0){
				if(!categoryAction.action.equals("detail")){
					categoryAction.setInvalid(categoryBean.getInvalid());
					categoryAction.setInvalidSelect(categoryBean.getInvalid());
				}else categoryAction.setInvalid(Utilities.getWrapperSelect(categoryBean.getInvalid(),categoryAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param CategoryBean action句柄
	 * @param CategoryAction action句柄
	 */
	private CategoryBean setCategoryBeanCommonAttributes(CategoryBean categoryBean,CategoryAction categoryAction){
				categoryBean.setCode(categoryAction.code);
		categoryBean.setName(categoryAction.name);
		categoryBean.setInvalid(categoryAction.invalid);

		return categoryBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param categoryQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(CategoryBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getCode().trim().length()>0)
			paramStr.append("&code=").append(queryConditionsBean.getCode().trim());
		if(queryConditionsBean.getName().trim().length()>0)
			paramStr.append("&name=").append(queryConditionsBean.getName().trim());
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