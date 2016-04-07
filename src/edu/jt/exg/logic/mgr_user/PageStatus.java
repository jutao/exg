package edu.jt.exg.logic.mgr_user;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Mgr_userAction;


public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Mgr_userAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Mgr_userAction mgr_userAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			mgr_userAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			mgr_userAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			mgr_userAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(mgr_userAction.start==null) mgr_userAction.start="0";
        else if(mgr_userAction.start.length()==0) mgr_userAction.start="0";
        if(mgr_userAction.range==null) mgr_userAction.range=ConstSetup.REFERENCE_RANGE;
        else if(mgr_userAction.range.length()==0) mgr_userAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(mgr_userAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Mgr_userAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Mgr_userAction mgr_userAction){
    	//获取记录范围*************************************************
    	mgr_userAction.action=mgr_userAction.request.getParameter("action");
        if(mgr_userAction.start==null) mgr_userAction.start="0";
        else if(mgr_userAction.start.length()==0) mgr_userAction.start="0";
        if(mgr_userAction.range==null) mgr_userAction.range=ConstSetup.REFERENCE_RANGE;
        else if(mgr_userAction.range.length()==0) mgr_userAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(mgr_userAction);
    }
    
    /**
	 * 设置排序
	 * @param Mgr_userAction action句柄
	 */
    private void setOrderByMap(Mgr_userAction mgr_userAction){
        mgr_userAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Mgr_userSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Mgr_userAction action句柄
	 */
	public void setControlsValues(Mgr_userAction mgr_userAction){
		InitPageControl.initInvalidMap(mgr_userAction);
		InitPageControl.initUsertypeMap(mgr_userAction);
		InitPageControl.initTimestamp(mgr_userAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Mgr_userAction action句柄
	 * @param params 设置参数
	 */
	public Mgr_userBean getQueryConditionsFromParams(Mgr_userAction mgr_userAction,String params){
		Mgr_userBean mgr_userBean=Mgr_userUtility.getIocHandel().getBean("Mgr_userBean",Mgr_userBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("usertype=")==0){
			pos=tmp.indexOf("usertype=");
			mgr_userBean.setUsertype(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("userid=")==0){
			pos=tmp.indexOf("userid=");
			mgr_userBean.setUserid(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("name=")==0){
			pos=tmp.indexOf("name=");
			mgr_userBean.setName(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("login_password=")==0){
			pos=tmp.indexOf("login_password=");
			mgr_userBean.setLogin_password(tmp.substring(pos+15,tmp.length()));
		}
		if(array[i].indexOf("yubei1=")==0){
			pos=tmp.indexOf("yubei1=");
			mgr_userBean.setYubei1(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("yubei2=")==0){
			pos=tmp.indexOf("yubei2=");
			mgr_userBean.setYubei2(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("yubei3=")==0){
			pos=tmp.indexOf("yubei3=");
			mgr_userBean.setYubei3(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			mgr_userBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			mgr_userBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			mgr_userBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			mgr_userBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			mgr_userBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return mgr_userBean;
	}
	
	/**
	 * 得到form的查询条件	 
	 * @param Mgr_userAction action句柄
	 */
	public Mgr_userBean getQueryConditionsFromForm(Mgr_userAction mgr_userAction){
		Mgr_userBean mgr_userBean=Mgr_userUtility.getIocHandel().getBean("Mgr_userBean",Mgr_userBean.class);
		mgr_userBean=setMgr_userBeanCommonAttributes(mgr_userBean,mgr_userAction);
		mgr_userAction.register_timeFrom=Utilities.setTimeStampFunction(mgr_userAction.register_timeDateFrom,mgr_userAction.register_timeHourFrom,mgr_userAction.register_timeMinuteFrom);
		mgr_userBean.setRegister_timeFrom(mgr_userAction.register_timeFrom);
		mgr_userAction.register_timeTo=Utilities.setTimeStampFunction(mgr_userAction.register_timeDateTo,mgr_userAction.register_timeHourTo,mgr_userAction.register_timeMinuteTo);
		mgr_userBean.setRegister_timeTo(mgr_userAction.register_timeTo);
		mgr_userAction.update_timeFrom=Utilities.setTimeStampFunction(mgr_userAction.update_timeDateFrom,mgr_userAction.update_timeHourFrom,mgr_userAction.update_timeMinuteFrom);
		mgr_userBean.setUpdate_timeFrom(mgr_userAction.update_timeFrom);
		mgr_userAction.update_timeTo=Utilities.setTimeStampFunction(mgr_userAction.update_timeDateTo,mgr_userAction.update_timeHourTo,mgr_userAction.update_timeMinuteTo);
		mgr_userBean.setUpdate_timeTo(mgr_userAction.update_timeTo);

		return mgr_userBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Mgr_userAction action句柄
	 */
	public String readControlsWrite2Datas(Mgr_userAction mgr_userAction){
		String errorMsg="";
				Mgr_userBean mgr_userBean=Mgr_userUtility.getIocHandel().getBean("Mgr_userBean",Mgr_userBean.class);
		if(mgr_userAction.action.equals("create")) mgr_userBean.setId(Utilities.getRandomPK(true));
		else mgr_userBean.setId(mgr_userAction.id);
		mgr_userBean=setMgr_userBeanCommonAttributes(mgr_userBean,mgr_userAction);
		mgr_userBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		mgr_userBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		mgr_userAction.batisDao=Mgr_userUtility.getIocHandel().getBean("Mgr_userBatisDao",Mgr_userBatisDao.class);
		if(mgr_userAction.action.equals("create")) errorMsg=Integer.toString(mgr_userAction.batisDao.insert(mgr_userBean));
		else errorMsg=Integer.toString(mgr_userAction.batisDao.updateByKey(mgr_userBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控制
	 * @param Mgr_userAction action句柄
	 */
	public void readDatasWrite2Controls(Mgr_userAction mgr_userAction){
		
		
		
		
		
		
		mgr_userAction.batisDao=Mgr_userUtility.getIocHandel().getBean("Mgr_userBatisDao",Mgr_userBatisDao.class);
		Mgr_userBean mgr_userBean=mgr_userAction.batisDao.findByKey(mgr_userAction.id);
		
		
		
		write2ControlsCommon(mgr_userAction,mgr_userBean);
		//auto timestamp
		if(mgr_userAction.action.equals("detail")) mgr_userAction.setRegister_time(mgr_userBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(mgr_userAction.action.equals("detail")) mgr_userAction.setUpdate_time(mgr_userBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控制
	 * @param Mgr_userAction action句柄
	 * @param Mgr_userBean action句柄
	 */
	public void readConditionsWrite2Controls(Mgr_userAction mgr_userAction,Mgr_userBean mgr_userBean){
		write2ControlsCommon(mgr_userAction,mgr_userBean);
		if(mgr_userBean.getRegister_timeFrom()!=null){
			mgr_userAction.setRegister_timeFrom(mgr_userBean.getRegister_timeFrom());
			mgr_userAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(mgr_userBean.getRegister_timeFrom()));
			cale.setTimeInMillis(mgr_userBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) mgr_userAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else mgr_userAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			mgr_userAction.setRegister_timeHourSelectFrom(mgr_userAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) mgr_userAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else mgr_userAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			mgr_userAction.setRegister_timeMinuteSelectFrom(mgr_userAction.register_timeMinuteFrom);
		}
		if(mgr_userBean.getRegister_timeTo()!=null){
			mgr_userAction.setRegister_timeTo(mgr_userBean.getRegister_timeTo());
			mgr_userAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(mgr_userBean.getRegister_timeTo()));
			cale.setTimeInMillis(mgr_userBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) mgr_userAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else mgr_userAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			mgr_userAction.setRegister_timeHourSelectTo(mgr_userAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) mgr_userAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else mgr_userAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			mgr_userAction.setRegister_timeMinuteSelectTo(mgr_userAction.register_timeMinuteTo);
		}
		if(mgr_userBean.getUpdate_timeFrom()!=null){
			mgr_userAction.setUpdate_timeFrom(mgr_userBean.getUpdate_timeFrom());
			mgr_userAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(mgr_userBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(mgr_userBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) mgr_userAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else mgr_userAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			mgr_userAction.setUpdate_timeHourSelectFrom(mgr_userAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) mgr_userAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else mgr_userAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			mgr_userAction.setUpdate_timeMinuteSelectFrom(mgr_userAction.update_timeMinuteFrom);
		}
		if(mgr_userBean.getUpdate_timeTo()!=null){
			mgr_userAction.setUpdate_timeTo(mgr_userBean.getUpdate_timeTo());
			mgr_userAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(mgr_userBean.getUpdate_timeTo()));
			cale.setTimeInMillis(mgr_userBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) mgr_userAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else mgr_userAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			mgr_userAction.setUpdate_timeHourSelectTo(mgr_userAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) mgr_userAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else mgr_userAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			mgr_userAction.setUpdate_timeMinuteSelectTo(mgr_userAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列	 
	 * @param Mgr_userAction action句柄
	 * @param Mgr_userBean action句柄
	 * @param type 控件类型
	 */
	public Mgr_userBean wrapperMgr_userBean(Mgr_userAction mgr_userAction,Mgr_userBean mgr_userBean,String type){
				//s:select***************************************************************************
		InitPageControl.initInvalidMap(mgr_userAction);
		mgr_userBean.setInvalid(Utilities.getWrapperSelect(mgr_userBean.getInvalid(),mgr_userAction.invalidMap));
		InitPageControl.initUsertypeMap(mgr_userAction);
		mgr_userBean.setUsertype(Utilities.getWrapperSelect(mgr_userBean.getUsertype(),mgr_userAction.usertypeMap));

		return mgr_userBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Mgr_userAction action句柄
	 * @param type 控件类型
	 */
    public List<Mgr_userBean> wrapperRecorders(Mgr_userAction mgr_userAction,String type){
    	Mgr_userBean mgr_user=null;
    	List<Mgr_userBean> newMgr_userList=Mgr_userUtility.getIocHandel().getBean("List_Mgr_userBean",java.util.ArrayList.class);
    	for(int i=0;i<mgr_userAction.mgr_userList.size();i++){
    		mgr_user=mgr_userAction.mgr_userList.get(i);
    		mgr_user=wrapperMgr_userBean(mgr_userAction,mgr_user,type);
    		newMgr_userList.add(mgr_user);
    	}
    	return newMgr_userList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单必须推算出一级下拉的选项
	 * @param Mgr_userAction action句柄
	 * @param Mgr_userBean action句柄
	 */
	private void write2ControlsCommon(Mgr_userAction mgr_userAction,Mgr_userBean mgr_userBean){
		mgr_userAction.setId(mgr_userBean.getId());
		//textfield
		if(mgr_userBean.getUserid()!=null)
			if(mgr_userBean.getUserid().trim().length()>0) mgr_userAction.setUserid(mgr_userBean.getUserid());
		//textfield
		if(mgr_userBean.getName()!=null)
			if(mgr_userBean.getName().trim().length()>0) mgr_userAction.setName(mgr_userBean.getName());
		//textfield
		if(mgr_userBean.getLogin_password()!=null)
			if(mgr_userBean.getLogin_password().trim().length()>0) mgr_userAction.setLogin_password(mgr_userBean.getLogin_password());
		//textfield
		if(mgr_userBean.getYubei1()!=null)
			if(mgr_userBean.getYubei1().trim().length()>0) mgr_userAction.setYubei1(mgr_userBean.getYubei1());
		//textfield
		if(mgr_userBean.getYubei2()!=null)
			if(mgr_userBean.getYubei2().trim().length()>0) mgr_userAction.setYubei2(mgr_userBean.getYubei2());
		//textfield
		if(mgr_userBean.getYubei3()!=null)
			if(mgr_userBean.getYubei3().trim().length()>0) mgr_userAction.setYubei3(mgr_userBean.getYubei3());
		//select
		if(mgr_userBean.getInvalid()!=null){
			if(mgr_userBean.getInvalid().trim().length()>0){
				if(!mgr_userAction.action.equals("detail")){
					mgr_userAction.setInvalid(mgr_userBean.getInvalid());
					mgr_userAction.setInvalidSelect(mgr_userBean.getInvalid());
				}else mgr_userAction.setInvalid(Utilities.getWrapperSelect(mgr_userBean.getInvalid(),mgr_userAction.invalidMap));
			}
		}
		if(mgr_userBean.getUsertype()!=null){
			if(mgr_userBean.getUsertype().trim().length()>0){
				if(!mgr_userAction.action.equals("detail")){
					mgr_userAction.setUsertype(mgr_userBean.getUsertype());
					mgr_userAction.setUsertypeSelect(mgr_userBean.getUsertype());
				}else mgr_userAction.setUsertype(Utilities.getWrapperSelect(mgr_userBean.getUsertype(),mgr_userAction.usertypeMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置	 
	 * @param Mgr_userBean action句柄
	 * @param Mgr_userAction action句柄
	 */
	private Mgr_userBean setMgr_userBeanCommonAttributes(Mgr_userBean mgr_userBean,Mgr_userAction mgr_userAction){
				mgr_userBean.setUsertype(mgr_userAction.usertype);
		mgr_userBean.setUserid(mgr_userAction.userid);
		mgr_userBean.setName(mgr_userAction.name);
		mgr_userBean.setLogin_password(mgr_userAction.login_password);
		mgr_userBean.setYubei1(mgr_userAction.yubei1);
		mgr_userBean.setYubei2(mgr_userAction.yubei2);
		mgr_userBean.setYubei3(mgr_userAction.yubei3);
		mgr_userBean.setInvalid(mgr_userAction.invalid);

		return mgr_userBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param mgr_userQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Mgr_userBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
			if(queryConditionsBean.getUsertype().trim().length()>0)
				paramStr.append("&usertype=").append(queryConditionsBean.getUsertype().trim());
		if(queryConditionsBean.getUserid().trim().length()>0)
			paramStr.append("&userid=").append(queryConditionsBean.getUserid().trim());
		if(queryConditionsBean.getName().trim().length()>0)
			paramStr.append("&name=").append(queryConditionsBean.getName().trim());
		if(queryConditionsBean.getLogin_password().trim().length()>0)
			paramStr.append("&login_password=").append(queryConditionsBean.getLogin_password().trim());
		if(queryConditionsBean.getYubei1().trim().length()>0)
                    	paramStr.append("&yubei1=").append(queryConditionsBean.getYubei1().trim());
		if(queryConditionsBean.getYubei2().trim().length()>0)
			paramStr.append("&yubei2=").append(queryConditionsBean.getYubei2().trim());
		if(queryConditionsBean.getYubei3().trim().length()>0)
			paramStr.append("&yubei3=").append(queryConditionsBean.getYubei3().trim());
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