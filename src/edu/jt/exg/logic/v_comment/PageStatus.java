package edu.jt.exg.logic.v_comment;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.V_commentAction;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_commentAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(V_commentAction v_commentAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			v_commentAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			v_commentAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			v_commentAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(v_commentAction.start==null) v_commentAction.start="0";
        else if(v_commentAction.start.length()==0) v_commentAction.start="0";
        if(v_commentAction.range==null) v_commentAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_commentAction.range.length()==0) v_commentAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_commentAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_commentAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(V_commentAction v_commentAction){
    	//获取记录范围*************************************************
    	v_commentAction.action=v_commentAction.request.getParameter("action");
        if(v_commentAction.start==null) v_commentAction.start="0";
        else if(v_commentAction.start.length()==0) v_commentAction.start="0";
        if(v_commentAction.range==null) v_commentAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_commentAction.range.length()==0) v_commentAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_commentAction);
    }
    
    /**
	 * 设置排序
	 * @param V_commentAction action句柄
	 */
    private void setOrderByMap(V_commentAction v_commentAction){
        v_commentAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(V_commentSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param V_commentAction action句柄
	 */
	public void setControlsValues(V_commentAction v_commentAction){
			InitPageControl.initTimestamp(v_commentAction);
			InitPageControl.initInvalidMap(v_commentAction);
			InitPageControl.initCategoryMap(v_commentAction);
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param V_commentAction action句柄
	 * @param params 设置参数
	 */
	public V_commentBean getQueryConditionsFromParams(V_commentAction v_commentAction,String params){
		V_commentBean v_commentBean=V_commentUtility.getIocHandel().getBean("V_commentBean",V_commentBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("userkey=")==0){
			pos=tmp.indexOf("userkey=");
			v_commentBean.setUserkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("targetkey=")==0){
			pos=tmp.indexOf("targetkey=");
			v_commentBean.setTargetkey(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("detail=")==0){
			pos=tmp.indexOf("detail=");
			v_commentBean.setDetail(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("pic1=")==0){
			pos=tmp.indexOf("pic1=");
			v_commentBean.setPic1(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic2=")==0){
			pos=tmp.indexOf("pic2=");
			v_commentBean.setPic2(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic3=")==0){
			pos=tmp.indexOf("pic3=");
			v_commentBean.setPic3(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("category=")==0){
			pos=tmp.indexOf("category=");
			v_commentBean.setCategory(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("displayFrom=")==0){
			pos=tmp.indexOf("displayFrom=");
			v_commentBean.setDisplayFrom(Integer.valueOf(tmp.substring(pos+12,tmp.length())));
		}else if(array[i].indexOf("displayTo=")!=-1){
			pos=tmp.indexOf("displayTo=");
			v_commentBean.setDisplayTo(Integer.valueOf(tmp.substring(pos+10,tmp.length())));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			v_commentBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			v_commentBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_commentBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_commentBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			v_commentBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("user_key=")==0){
			pos=tmp.indexOf("user_key=");
			v_commentBean.setUser_key(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("neckname=")==0){
			pos=tmp.indexOf("neckname=");
			v_commentBean.setNeckname(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("icon=")==0){
			pos=tmp.indexOf("icon=");
			v_commentBean.setIcon(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("user_id=")==0){
			pos=tmp.indexOf("user_id=");
			v_commentBean.setUser_id(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("target_id=")==0){
			pos=tmp.indexOf("target_id=");
			v_commentBean.setTarget_id(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("target_name=")==0){
			pos=tmp.indexOf("target_name=");
			v_commentBean.setTarget_name(tmp.substring(pos+12,tmp.length()));
		}

		}
		return v_commentBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param V_commentAction action句柄
	 */
	public V_commentBean getQueryConditionsFromForm(V_commentAction v_commentAction){
		V_commentBean v_commentBean=V_commentUtility.getIocHandel().getBean("V_commentBean",V_commentBean.class);
		v_commentBean=setV_commentBeanCommonAttributes(v_commentBean,v_commentAction);
				v_commentBean.setDisplayFrom(v_commentAction.displayFrom);
		v_commentBean.setDisplayTo(v_commentAction.displayTo);
		v_commentAction.register_timeFrom=Utilities.setTimeStampFunction(v_commentAction.register_timeDateFrom,v_commentAction.register_timeHourFrom,v_commentAction.register_timeMinuteFrom);
		v_commentBean.setRegister_timeFrom(v_commentAction.register_timeFrom);
		v_commentAction.register_timeTo=Utilities.setTimeStampFunction(v_commentAction.register_timeDateTo,v_commentAction.register_timeHourTo,v_commentAction.register_timeMinuteTo);
		v_commentBean.setRegister_timeTo(v_commentAction.register_timeTo);
		v_commentAction.update_timeFrom=Utilities.setTimeStampFunction(v_commentAction.update_timeDateFrom,v_commentAction.update_timeHourFrom,v_commentAction.update_timeMinuteFrom);
		v_commentBean.setUpdate_timeFrom(v_commentAction.update_timeFrom);
		v_commentAction.update_timeTo=Utilities.setTimeStampFunction(v_commentAction.update_timeDateTo,v_commentAction.update_timeHourTo,v_commentAction.update_timeMinuteTo);
		v_commentBean.setUpdate_timeTo(v_commentAction.update_timeTo);

		return v_commentBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param V_commentAction action句柄
	 */
	public String readControlsWrite2Datas(V_commentAction v_commentAction){
		String errorMsg="";
				V_commentBean v_commentBean=V_commentUtility.getIocHandel().getBean("V_commentBean",V_commentBean.class);
		if(v_commentAction.action.equals("create")) v_commentBean.setId(Utilities.getRandomPK(true));
		else v_commentBean.setId(v_commentAction.id);
		v_commentBean=setV_commentBeanCommonAttributes(v_commentBean,v_commentAction);
		v_commentBean.setDisplay(v_commentAction.display);
		v_commentBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		v_commentBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		v_commentAction.batisDao=V_commentUtility.getIocHandel().getBean("V_commentBatisDao",V_commentBatisDao.class);
		if(v_commentAction.action.equals("create")) errorMsg=Integer.toString(v_commentAction.batisDao.insert(v_commentBean));
		else errorMsg=Integer.toString(v_commentAction.batisDao.updateByKey(v_commentBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param V_commentAction action句柄
	 */
	public void readDatasWrite2Controls(V_commentAction v_commentAction){
		
		
		
		
		
		
		v_commentAction.batisDao=V_commentUtility.getIocHandel().getBean("V_commentBatisDao",V_commentBatisDao.class);
		V_commentBean v_commentBean=v_commentAction.batisDao.findByKey(v_commentAction.id);
		
		
		
		write2ControlsCommon(v_commentAction,v_commentBean);
				if(v_commentBean.getDisplay()!=null)
			if(v_commentBean.getDisplay().intValue()>=0) v_commentAction.setDisplay(v_commentBean.getDisplay());
		//auto timestamp
		if(v_commentAction.action.equals("detail")) v_commentAction.setRegister_time(v_commentBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(v_commentAction.action.equals("detail")) v_commentAction.setUpdate_time(v_commentBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param V_commentAction action句柄
	 * @param V_commentBean action句柄
	 */
	public void readConditionsWrite2Controls(V_commentAction v_commentAction,V_commentBean v_commentBean){
		write2ControlsCommon(v_commentAction,v_commentBean);
				if(v_commentBean.getDisplayFrom()!=null)
			if(v_commentBean.getDisplayFrom().intValue()>=0) v_commentAction.setDisplayFrom(v_commentBean.getDisplayFrom());
		if(v_commentBean.getDisplayTo()!=null)
			if(v_commentBean.getDisplayTo().intValue()>=0) v_commentAction.setDisplayTo(v_commentBean.getDisplayTo());
		if(v_commentBean.getRegister_timeFrom()!=null){
			v_commentAction.setRegister_timeFrom(v_commentBean.getRegister_timeFrom());
			v_commentAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(v_commentBean.getRegister_timeFrom()));
			cale.setTimeInMillis(v_commentBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_commentAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_commentAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_commentAction.setRegister_timeHourSelectFrom(v_commentAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_commentAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_commentAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_commentAction.setRegister_timeMinuteSelectFrom(v_commentAction.register_timeMinuteFrom);
		}
		if(v_commentBean.getRegister_timeTo()!=null){
			v_commentAction.setRegister_timeTo(v_commentBean.getRegister_timeTo());
			v_commentAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(v_commentBean.getRegister_timeTo()));
			cale.setTimeInMillis(v_commentBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_commentAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_commentAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_commentAction.setRegister_timeHourSelectTo(v_commentAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_commentAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_commentAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_commentAction.setRegister_timeMinuteSelectTo(v_commentAction.register_timeMinuteTo);
		}
		if(v_commentBean.getUpdate_timeFrom()!=null){
			v_commentAction.setUpdate_timeFrom(v_commentBean.getUpdate_timeFrom());
			v_commentAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(v_commentBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(v_commentBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_commentAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_commentAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_commentAction.setUpdate_timeHourSelectFrom(v_commentAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_commentAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_commentAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_commentAction.setUpdate_timeMinuteSelectFrom(v_commentAction.update_timeMinuteFrom);
		}
		if(v_commentBean.getUpdate_timeTo()!=null){
			v_commentAction.setUpdate_timeTo(v_commentBean.getUpdate_timeTo());
			v_commentAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(v_commentBean.getUpdate_timeTo()));
			cale.setTimeInMillis(v_commentBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_commentAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_commentAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_commentAction.setUpdate_timeHourSelectTo(v_commentAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_commentAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_commentAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_commentAction.setUpdate_timeMinuteSelectTo(v_commentAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param V_commentAction action句柄
	 * @param V_commentBean action句柄
	 * @param type 控件类型
	 */
	public V_commentBean wrapperV_commentBean(V_commentAction v_commentAction,V_commentBean v_commentBean,String type){
		//s:select***************************************************************************
		InitPageControl.initCategoryMap(v_commentAction);
		v_commentBean.setCategory(Utilities.getWrapperSelect(v_commentBean.getCategory(),v_commentAction.categoryMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(v_commentAction);
		v_commentBean.setInvalid(Utilities.getWrapperSelect(v_commentBean.getInvalid(),v_commentAction.invalidMap));
		return v_commentBean;
	}
	
	/**
	 * 记录显示包装
	 * @param V_commentAction action句柄
	 * @param type 控件类型
	 */
    public List<V_commentBean> wrapperRecorders(V_commentAction v_commentAction,String type){
    	V_commentBean v_comment=null;
    	List<V_commentBean> newV_commentList=V_commentUtility.getIocHandel().getBean("List_V_commentBean",java.util.ArrayList.class);
    	for(int i=0;i<v_commentAction.v_commentList.size();i++){
    		v_comment=v_commentAction.v_commentList.get(i);
    		v_comment=wrapperV_commentBean(v_commentAction,v_comment,type);
    		newV_commentList.add(v_comment);
    	}
    	return newV_commentList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param V_commentAction action句柄
	 * @param V_commentBean action句柄
	 */
	private void write2ControlsCommon(V_commentAction v_commentAction,V_commentBean v_commentBean){
		v_commentAction.setId(v_commentBean.getId());
				//textfield
		if(v_commentBean.getUserkey()!=null)
			if(v_commentBean.getUserkey().trim().length()>0) v_commentAction.setUserkey(v_commentBean.getUserkey());
		//textfield
		if(v_commentBean.getTargetkey()!=null)
			if(v_commentBean.getTargetkey().trim().length()>0) v_commentAction.setTargetkey(v_commentBean.getTargetkey());
		//textfield
		if(v_commentBean.getDetail()!=null)
			if(v_commentBean.getDetail().trim().length()>0) v_commentAction.setDetail(v_commentBean.getDetail());
		//textfield
		if(v_commentBean.getPic1()!=null)
			if(v_commentBean.getPic1().trim().length()>0) v_commentAction.setPic1(v_commentBean.getPic1());
		//textfield
		if(v_commentBean.getPic2()!=null)
			if(v_commentBean.getPic2().trim().length()>0) v_commentAction.setPic2(v_commentBean.getPic2());
		//textfield
		if(v_commentBean.getPic3()!=null)
			if(v_commentBean.getPic3().trim().length()>0) v_commentAction.setPic3(v_commentBean.getPic3());
		//textfield
		if(v_commentBean.getUser_key()!=null)
			if(v_commentBean.getUser_key().trim().length()>0) v_commentAction.setUser_key(v_commentBean.getUser_key());
		//textfield
		if(v_commentBean.getNeckname()!=null)
			if(v_commentBean.getNeckname().trim().length()>0) v_commentAction.setNeckname(v_commentBean.getNeckname());
		//textfield
		if(v_commentBean.getIcon()!=null)
			if(v_commentBean.getIcon().trim().length()>0) v_commentAction.setIcon(v_commentBean.getIcon());
		//textfield
		if(v_commentBean.getUser_id()!=null)
			if(v_commentBean.getUser_id().trim().length()>0) v_commentAction.setUser_id(v_commentBean.getUser_id());
		//textfield
		if(v_commentBean.getTarget_id()!=null)
			if(v_commentBean.getTarget_id().trim().length()>0) v_commentAction.setTarget_id(v_commentBean.getTarget_id());
		//textfield
		if(v_commentBean.getTarget_name()!=null)
			if(v_commentBean.getTarget_name().trim().length()>0) v_commentAction.setTarget_name(v_commentBean.getTarget_name());

		//select
				if(v_commentBean.getCategory()!=null){
					if(v_commentBean.getCategory().trim().length()>0){
						if(!v_commentAction.action.equals("detail")){
							v_commentAction.setCategory(v_commentBean.getCategory());
							v_commentAction.setCategorySelect(v_commentBean.getCategory());
						}else v_commentAction.setCategory(Utilities.getWrapperSelect(v_commentBean.getCategory(),v_commentAction.categoryMap));
					}
				}		
				//select
				if(v_commentBean.getInvalid()!=null){
					if(v_commentBean.getInvalid().trim().length()>0){
						if(!v_commentAction.action.equals("detail")){
							v_commentAction.setInvalid(v_commentBean.getInvalid());
							v_commentAction.setInvalidSelect(v_commentBean.getInvalid());
						}else v_commentAction.setInvalid(Utilities.getWrapperSelect(v_commentBean.getInvalid(),v_commentAction.invalidMap));
					}
				}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param V_commentBean action句柄
	 * @param V_commentAction action句柄
	 */
	private V_commentBean setV_commentBeanCommonAttributes(V_commentBean v_commentBean,V_commentAction v_commentAction){
				v_commentBean.setUserkey(v_commentAction.userkey);
		v_commentBean.setTargetkey(v_commentAction.targetkey);
		v_commentBean.setDetail(v_commentAction.detail);
		v_commentBean.setPic1(v_commentAction.pic1);
		v_commentBean.setPic2(v_commentAction.pic2);
		v_commentBean.setPic3(v_commentAction.pic3);
		v_commentBean.setCategory(v_commentAction.category);
		v_commentBean.setInvalid(v_commentAction.invalid);
		v_commentBean.setUser_key(v_commentAction.user_key);
		v_commentBean.setNeckname(v_commentAction.neckname);
		v_commentBean.setIcon(v_commentAction.icon);
		v_commentBean.setUser_id(v_commentAction.user_id);
		v_commentBean.setTarget_id(v_commentAction.target_id);
		v_commentBean.setTarget_name(v_commentAction.target_name);

		return v_commentBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param v_commentQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(V_commentBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getUserkey().trim().length()>0)
			paramStr.append("&userkey=").append(queryConditionsBean.getUserkey().trim());
		if(queryConditionsBean.getTargetkey().trim().length()>0)
			paramStr.append("&targetkey=").append(queryConditionsBean.getTargetkey().trim());
		if(queryConditionsBean.getDetail().trim().length()>0)
			paramStr.append("&detail=").append(queryConditionsBean.getDetail().trim());
		if(queryConditionsBean.getPic1().trim().length()>0)
			paramStr.append("&pic1=").append(queryConditionsBean.getPic1().trim());
		if(queryConditionsBean.getPic2().trim().length()>0)
			paramStr.append("&pic2=").append(queryConditionsBean.getPic2().trim());
		if(queryConditionsBean.getPic3().trim().length()>0)
			paramStr.append("&pic3=").append(queryConditionsBean.getPic3().trim());
		if(queryConditionsBean.getCategory().trim().length()>0)
			paramStr.append("&category=").append(queryConditionsBean.getCategory().trim());
		if(queryConditionsBean.getDisplayFrom()!=null)
				paramStr.append("&displayFrom=").append(queryConditionsBean.getDisplayFrom());
		if(queryConditionsBean.getDisplayTo()!=null)
				paramStr.append("&displayTo=").append(queryConditionsBean.getDisplayTo());
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
		if(queryConditionsBean.getUser_key().trim().length()>0)
			paramStr.append("&user_key=").append(queryConditionsBean.getUser_key().trim());
		if(queryConditionsBean.getNeckname().trim().length()>0)
			paramStr.append("&neckname=").append(queryConditionsBean.getNeckname().trim());
		if(queryConditionsBean.getIcon().trim().length()>0)
			paramStr.append("&icon=").append(queryConditionsBean.getIcon().trim());
		if(queryConditionsBean.getUser_id().trim().length()>0)
			paramStr.append("&user_id=").append(queryConditionsBean.getUser_id().trim());
		if(queryConditionsBean.getTarget_id().trim().length()>0)
			paramStr.append("&target_id=").append(queryConditionsBean.getTarget_id().trim());
		if(queryConditionsBean.getTarget_name().trim().length()>0)
			paramStr.append("&target_name=").append(queryConditionsBean.getTarget_name().trim());

		return paramStr.toString();
	}
}