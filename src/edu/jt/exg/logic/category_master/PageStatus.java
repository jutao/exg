package edu.jt.exg.logic.category_master;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Category_masterAction;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Category_masterAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Category_masterAction category_masterAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			category_masterAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			category_masterAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			category_masterAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(category_masterAction.start==null) category_masterAction.start="0";
        else if(category_masterAction.start.length()==0) category_masterAction.start="0";
        if(category_masterAction.range==null) category_masterAction.range=ConstSetup.REFERENCE_RANGE;
        else if(category_masterAction.range.length()==0) category_masterAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(category_masterAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Category_masterAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Category_masterAction category_masterAction){
    	//获取记录范围*************************************************
    	category_masterAction.action=category_masterAction.request.getParameter("action");
        if(category_masterAction.start==null) category_masterAction.start="0";
        else if(category_masterAction.start.length()==0) category_masterAction.start="0";
        if(category_masterAction.range==null) category_masterAction.range=ConstSetup.REFERENCE_RANGE;
        else if(category_masterAction.range.length()==0) category_masterAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(category_masterAction);
    }
    
    /**
	 * 设置排序
	 * @param Category_masterAction action句柄
	 */
    private void setOrderByMap(Category_masterAction category_masterAction){
        category_masterAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Category_masterSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Category_masterAction action句柄
	 */
	public void setControlsValues(Category_masterAction category_masterAction){
			InitPageControl.initInvalidMap(category_masterAction);
		InitPageControl.initTimestamp(category_masterAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Category_masterAction action句柄
	 * @param params 设置参数
	 */
	public Category_masterBean getQueryConditionsFromParams(Category_masterAction category_masterAction,String params){
		Category_masterBean category_masterBean=Category_masterUtility.getIocHandel().getBean("Category_masterBean",Category_masterBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("parent_code=")==0){
			pos=tmp.indexOf("parent_code=");
			category_masterBean.setParent_code(tmp.substring(pos+12,tmp.length()));
		}
		if(array[i].indexOf("code=")==0){
			pos=tmp.indexOf("code=");
			category_masterBean.setCode(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("name=")==0){
			pos=tmp.indexOf("name=");
			category_masterBean.setName(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("displayFrom=")==0){
			pos=tmp.indexOf("displayFrom=");
			category_masterBean.setDisplayFrom(Integer.valueOf(tmp.substring(pos+12,tmp.length())));
		}else if(array[i].indexOf("displayTo=")!=-1){
			pos=tmp.indexOf("displayTo=");
			category_masterBean.setDisplayTo(Integer.valueOf(tmp.substring(pos+10,tmp.length())));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			category_masterBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			category_masterBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			category_masterBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			category_masterBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			category_masterBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return category_masterBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param Category_masterAction action句柄
	 */
	public Category_masterBean getQueryConditionsFromForm(Category_masterAction category_masterAction){
		Category_masterBean category_masterBean=Category_masterUtility.getIocHandel().getBean("Category_masterBean",Category_masterBean.class);
		category_masterBean=setCategory_masterBeanCommonAttributes(category_masterBean,category_masterAction);
				category_masterBean.setDisplayFrom(category_masterAction.displayFrom);
		category_masterBean.setDisplayTo(category_masterAction.displayTo);
		category_masterAction.register_timeFrom=Utilities.setTimeStampFunction(category_masterAction.register_timeDateFrom,category_masterAction.register_timeHourFrom,category_masterAction.register_timeMinuteFrom);
		category_masterBean.setRegister_timeFrom(category_masterAction.register_timeFrom);
		category_masterAction.register_timeTo=Utilities.setTimeStampFunction(category_masterAction.register_timeDateTo,category_masterAction.register_timeHourTo,category_masterAction.register_timeMinuteTo);
		category_masterBean.setRegister_timeTo(category_masterAction.register_timeTo);
		category_masterAction.update_timeFrom=Utilities.setTimeStampFunction(category_masterAction.update_timeDateFrom,category_masterAction.update_timeHourFrom,category_masterAction.update_timeMinuteFrom);
		category_masterBean.setUpdate_timeFrom(category_masterAction.update_timeFrom);
		category_masterAction.update_timeTo=Utilities.setTimeStampFunction(category_masterAction.update_timeDateTo,category_masterAction.update_timeHourTo,category_masterAction.update_timeMinuteTo);
		category_masterBean.setUpdate_timeTo(category_masterAction.update_timeTo);

		return category_masterBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Category_masterAction action句柄
	 */
	public String readControlsWrite2Datas(Category_masterAction category_masterAction){
		String errorMsg="";
				Category_masterBean category_masterBean=Category_masterUtility.getIocHandel().getBean("Category_masterBean",Category_masterBean.class);
		if(category_masterAction.action.equals("create")) category_masterBean.setId(Utilities.getRandomPK(true));
		else category_masterBean.setId(category_masterAction.id);
		category_masterBean=setCategory_masterBeanCommonAttributes(category_masterBean,category_masterAction);
		category_masterBean.setDisplay(category_masterAction.display);
		category_masterBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		category_masterBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		category_masterAction.batisDao=Category_masterUtility.getIocHandel().getBean("Category_masterBatisDao",Category_masterBatisDao.class);
		if(category_masterAction.action.equals("create")) errorMsg=Integer.toString(category_masterAction.batisDao.insert(category_masterBean));
		else errorMsg=Integer.toString(category_masterAction.batisDao.updateByKey(category_masterBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param Category_masterAction action句柄
	 */
	public void readDatasWrite2Controls(Category_masterAction category_masterAction){
		
		
		
		
		
		
		category_masterAction.batisDao=Category_masterUtility.getIocHandel().getBean("Category_masterBatisDao",Category_masterBatisDao.class);
		Category_masterBean category_masterBean=category_masterAction.batisDao.findByKey(category_masterAction.id);
		
		
		
		write2ControlsCommon(category_masterAction,category_masterBean);
				if(category_masterBean.getDisplay()!=null)
			if(category_masterBean.getDisplay().intValue()>=0) category_masterAction.setDisplay(category_masterBean.getDisplay());
		//auto timestamp
		if(category_masterAction.action.equals("detail")) category_masterAction.setRegister_time(category_masterBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(category_masterAction.action.equals("detail")) category_masterAction.setUpdate_time(category_masterBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param Category_masterAction action句柄
	 * @param Category_masterBean action句柄
	 */
	public void readConditionsWrite2Controls(Category_masterAction category_masterAction,Category_masterBean category_masterBean){
		write2ControlsCommon(category_masterAction,category_masterBean);
				if(category_masterBean.getDisplayFrom()!=null)
			if(category_masterBean.getDisplayFrom().intValue()>=0) category_masterAction.setDisplayFrom(category_masterBean.getDisplayFrom());
		if(category_masterBean.getDisplayTo()!=null)
			if(category_masterBean.getDisplayTo().intValue()>=0) category_masterAction.setDisplayTo(category_masterBean.getDisplayTo());
		if(category_masterBean.getRegister_timeFrom()!=null){
			category_masterAction.setRegister_timeFrom(category_masterBean.getRegister_timeFrom());
			category_masterAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(category_masterBean.getRegister_timeFrom()));
			cale.setTimeInMillis(category_masterBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) category_masterAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else category_masterAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			category_masterAction.setRegister_timeHourSelectFrom(category_masterAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) category_masterAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else category_masterAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			category_masterAction.setRegister_timeMinuteSelectFrom(category_masterAction.register_timeMinuteFrom);
		}
		if(category_masterBean.getRegister_timeTo()!=null){
			category_masterAction.setRegister_timeTo(category_masterBean.getRegister_timeTo());
			category_masterAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(category_masterBean.getRegister_timeTo()));
			cale.setTimeInMillis(category_masterBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) category_masterAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else category_masterAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			category_masterAction.setRegister_timeHourSelectTo(category_masterAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) category_masterAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else category_masterAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			category_masterAction.setRegister_timeMinuteSelectTo(category_masterAction.register_timeMinuteTo);
		}
		if(category_masterBean.getUpdate_timeFrom()!=null){
			category_masterAction.setUpdate_timeFrom(category_masterBean.getUpdate_timeFrom());
			category_masterAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(category_masterBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(category_masterBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) category_masterAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else category_masterAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			category_masterAction.setUpdate_timeHourSelectFrom(category_masterAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) category_masterAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else category_masterAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			category_masterAction.setUpdate_timeMinuteSelectFrom(category_masterAction.update_timeMinuteFrom);
		}
		if(category_masterBean.getUpdate_timeTo()!=null){
			category_masterAction.setUpdate_timeTo(category_masterBean.getUpdate_timeTo());
			category_masterAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(category_masterBean.getUpdate_timeTo()));
			cale.setTimeInMillis(category_masterBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) category_masterAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else category_masterAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			category_masterAction.setUpdate_timeHourSelectTo(category_masterAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) category_masterAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else category_masterAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			category_masterAction.setUpdate_timeMinuteSelectTo(category_masterAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param Category_masterAction action句柄
	 * @param Category_masterBean action句柄
	 * @param type 控件类型
	 */
	public Category_masterBean wrapperCategory_masterBean(Category_masterAction category_masterAction,Category_masterBean category_masterBean,String type){
				//s:select***************************************************************************
		InitPageControl.initInvalidMap(category_masterAction);
		category_masterBean.setInvalid(Utilities.getWrapperSelect(category_masterBean.getInvalid(),category_masterAction.invalidMap));

		return category_masterBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Category_masterAction action句柄
	 * @param type 控件类型
	 */
    public List<Category_masterBean> wrapperRecorders(Category_masterAction category_masterAction,String type){
    	Category_masterBean category_master=null;
    	List<Category_masterBean> newCategory_masterList=Category_masterUtility.getIocHandel().getBean("List_Category_masterBean",java.util.ArrayList.class);
    	for(int i=0;i<category_masterAction.category_masterList.size();i++){
    		category_master=category_masterAction.category_masterList.get(i);
    		category_master=wrapperCategory_masterBean(category_masterAction,category_master,type);
    		newCategory_masterList.add(category_master);
    	}
    	return newCategory_masterList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param Category_masterAction action句柄
	 * @param Category_masterBean action句柄
	 */
	private void write2ControlsCommon(Category_masterAction category_masterAction,Category_masterBean category_masterBean){
		category_masterAction.setId(category_masterBean.getId());
				//textfield
		if(category_masterBean.getParent_code()!=null)
			if(category_masterBean.getParent_code().trim().length()>0) category_masterAction.setParent_code(category_masterBean.getParent_code());
		//textfield
		if(category_masterBean.getCode()!=null)
			if(category_masterBean.getCode().trim().length()>0) category_masterAction.setCode(category_masterBean.getCode());
		//textfield
		if(category_masterBean.getName()!=null)
			if(category_masterBean.getName().trim().length()>0) category_masterAction.setName(category_masterBean.getName());
		//select
		if(category_masterBean.getInvalid()!=null){
			if(category_masterBean.getInvalid().trim().length()>0){
				if(!category_masterAction.action.equals("detail")){
					category_masterAction.setInvalid(category_masterBean.getInvalid());
					category_masterAction.setInvalidSelect(category_masterBean.getInvalid());
				}else category_masterAction.setInvalid(Utilities.getWrapperSelect(category_masterBean.getInvalid(),category_masterAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param Category_masterBean action句柄
	 * @param Category_masterAction action句柄
	 */
	private Category_masterBean setCategory_masterBeanCommonAttributes(Category_masterBean category_masterBean,Category_masterAction category_masterAction){
				category_masterBean.setParent_code(category_masterAction.parent_code);
		category_masterBean.setCode(category_masterAction.code);
		category_masterBean.setName(category_masterAction.name);
		category_masterBean.setInvalid(category_masterAction.invalid);

		return category_masterBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param category_masterQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Category_masterBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getParent_code().trim().length()>0)
			paramStr.append("&parent_code=").append(queryConditionsBean.getParent_code().trim());
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