package edu.jt.exg.logic.task;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.TaskAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param TaskAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(TaskAction taskAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			taskAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			taskAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			taskAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(taskAction.start==null) taskAction.start="0";
        else if(taskAction.start.length()==0) taskAction.start="0";
        if(taskAction.range==null) taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(taskAction.range.length()==0) taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(taskAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param TaskAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(TaskAction taskAction){
    	//获取记录范围*************************************************
    	taskAction.action=taskAction.request.getParameter("action");
        if(taskAction.start==null) taskAction.start="0";
        else if(taskAction.start.length()==0) taskAction.start="0";
        if(taskAction.range==null) taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(taskAction.range.length()==0) taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(taskAction);
    }
    
    /**
	 * 设置排序
	 * @param TaskAction action句柄
	 */
    private void setOrderByMap(TaskAction taskAction){
        taskAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(TaskSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param TaskAction action句柄
	 */
	public void setControlsValues(TaskAction taskAction){
			InitPageControl.initStatusMap(taskAction);
		InitPageControl.initInvalidMap(taskAction);
		InitPageControl.initTimestamp(taskAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param TaskAction action句柄
	 * @param params 设置参数
	 */
	public TaskBean getQueryConditionsFromParams(TaskAction taskAction,String params){
		TaskBean taskBean=TaskUtility.getIocHandel().getBean("TaskBean",TaskBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("taskid=")==0){
			pos=tmp.indexOf("taskid=");
			taskBean.setTaskid(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("userkey=")==0){
			pos=tmp.indexOf("userkey=");
			taskBean.setUserkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("serverkey=")==0){
			pos=tmp.indexOf("serverkey=");
			taskBean.setServerkey(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("tipFrom=")==0){
			pos=tmp.indexOf("tipFrom=");
			taskBean.setTipFrom(Double.valueOf(tmp.substring(pos+8,tmp.length())));
		}else if(array[i].indexOf("tipTo=")==0){
			pos=tmp.indexOf("tipTo=");
			taskBean.setTipTo(Double.valueOf(tmp.substring(pos+6,tmp.length())));
		}
		if(array[i].indexOf("epsonFrom=")==0){
			pos=tmp.indexOf("epsonFrom=");
			taskBean.setEpsonFrom(Double.valueOf(tmp.substring(pos+10,tmp.length())));
		}else if(array[i].indexOf("epsonTo=")==0){
			pos=tmp.indexOf("epsonTo=");
			taskBean.setEpsonTo(Double.valueOf(tmp.substring(pos+8,tmp.length())));
		}
		if(array[i].indexOf("pro_description=")==0){
			pos=tmp.indexOf("pro_description=");
			taskBean.setPro_description(tmp.substring(pos+16,tmp.length()));
		}
		if(array[i].indexOf("pro_image1=")==0){
			pos=tmp.indexOf("pro_image1=");
			taskBean.setPro_image1(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image2=")==0){
			pos=tmp.indexOf("pro_image2=");
			taskBean.setPro_image2(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image3=")==0){
			pos=tmp.indexOf("pro_image3=");
			taskBean.setPro_image3(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image4=")==0){
			pos=tmp.indexOf("pro_image4=");
			taskBean.setPro_image4(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image5=")==0){
			pos=tmp.indexOf("pro_image5=");
			taskBean.setPro_image5(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("solve_image1=")==0){
			pos=tmp.indexOf("solve_image1=");
			taskBean.setSolve_image1(tmp.substring(pos+13,tmp.length()));
		}
		if(array[i].indexOf("solve_image2=")==0){
			pos=tmp.indexOf("solve_image2=");
			taskBean.setSolve_image2(tmp.substring(pos+13,tmp.length()));
		}
		if(array[i].indexOf("solve_image3=")==0){
			pos=tmp.indexOf("solve_image3=");
			taskBean.setSolve_image3(tmp.substring(pos+13,tmp.length()));
		}
		if(array[i].indexOf("seat=")==0){
			pos=tmp.indexOf("seat=");
			taskBean.setSeat(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			taskBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			taskBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			taskBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			taskBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			taskBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			taskBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return taskBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param TaskAction action句柄
	 */
	public TaskBean getQueryConditionsFromForm(TaskAction taskAction){
		TaskBean taskBean=TaskUtility.getIocHandel().getBean("TaskBean",TaskBean.class);
		taskBean=setTaskBeanCommonAttributes(taskBean,taskAction);
				taskBean.setTipFrom(taskAction.tipFrom);
		taskBean.setTipTo(taskAction.tipTo);
		taskBean.setEpsonFrom(taskAction.epsonFrom);
		taskBean.setEpsonTo(taskAction.epsonTo);
		taskAction.register_timeFrom=Utilities.setTimeStampFunction(taskAction.register_timeDateFrom,taskAction.register_timeHourFrom,taskAction.register_timeMinuteFrom);
		taskBean.setRegister_timeFrom(taskAction.register_timeFrom);
		taskAction.register_timeTo=Utilities.setTimeStampFunction(taskAction.register_timeDateTo,taskAction.register_timeHourTo,taskAction.register_timeMinuteTo);
		taskBean.setRegister_timeTo(taskAction.register_timeTo);
		taskAction.update_timeFrom=Utilities.setTimeStampFunction(taskAction.update_timeDateFrom,taskAction.update_timeHourFrom,taskAction.update_timeMinuteFrom);
		taskBean.setUpdate_timeFrom(taskAction.update_timeFrom);
		taskAction.update_timeTo=Utilities.setTimeStampFunction(taskAction.update_timeDateTo,taskAction.update_timeHourTo,taskAction.update_timeMinuteTo);
		taskBean.setUpdate_timeTo(taskAction.update_timeTo);

		return taskBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param TaskAction action句柄
	 */
	public String readControlsWrite2Datas(TaskAction taskAction){
		String errorMsg="";
				TaskBean taskBean=TaskUtility.getIocHandel().getBean("TaskBean",TaskBean.class);
		if(taskAction.action.equals("create")) taskBean.setId(Utilities.getRandomPK(true));
		else taskBean.setId(taskAction.id);
		taskBean=setTaskBeanCommonAttributes(taskBean,taskAction);
		taskBean.setTip(taskAction.tip);
		taskBean.setEpson(taskAction.epson);
		taskBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		taskAction.batisDao=TaskUtility.getIocHandel().getBean("TaskBatisDao",TaskBatisDao.class);
		if(taskAction.action.equals("create")) errorMsg=Integer.toString(taskAction.batisDao.insert(taskBean));
		else errorMsg=Integer.toString(taskAction.batisDao.updateByKey(taskBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param TaskAction action句柄
	 */
	public void readDatasWrite2Controls(TaskAction taskAction){
		
		
		
		
		
		
		taskAction.batisDao=TaskUtility.getIocHandel().getBean("TaskBatisDao",TaskBatisDao.class);
		TaskBean taskBean=taskAction.batisDao.findByKey(taskAction.id);
		
		
		
		write2ControlsCommon(taskAction,taskBean);
				if(taskBean.getTip()!=null)
			if(taskBean.getTip().doubleValue()!=0) taskAction.setTip(taskBean.getTip());
		if(taskBean.getEpson()!=null)
			if(taskBean.getEpson().doubleValue()!=0) taskAction.setEpson(taskBean.getEpson());
		//auto timestamp
		if(taskAction.action.equals("detail")) taskAction.setRegister_time(taskBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(taskAction.action.equals("detail")) taskAction.setUpdate_time(taskBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param TaskAction action句柄
	 * @param TaskBean action句柄
	 */
	public void readConditionsWrite2Controls(TaskAction taskAction,TaskBean taskBean){
		write2ControlsCommon(taskAction,taskBean);
				if(taskBean.getTipFrom()!=null)
			if(taskBean.getTipFrom().doubleValue()!=0) taskAction.setTipFrom(taskBean.getTipFrom());
		if(taskBean.getTipTo()!=null)
			if(taskBean.getTipTo().doubleValue()!=0) taskAction.setTipTo(taskBean.getTipTo());
		if(taskBean.getEpsonFrom()!=null)
			if(taskBean.getEpsonFrom().doubleValue()!=0) taskAction.setEpsonFrom(taskBean.getEpsonFrom());
		if(taskBean.getEpsonTo()!=null)
			if(taskBean.getEpsonTo().doubleValue()!=0) taskAction.setEpsonTo(taskBean.getEpsonTo());
		if(taskBean.getRegister_timeFrom()!=null){
			taskAction.setRegister_timeFrom(taskBean.getRegister_timeFrom());
			taskAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(taskBean.getRegister_timeFrom()));
			cale.setTimeInMillis(taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) taskAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else taskAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			taskAction.setRegister_timeHourSelectFrom(taskAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) taskAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else taskAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			taskAction.setRegister_timeMinuteSelectFrom(taskAction.register_timeMinuteFrom);
		}
		if(taskBean.getRegister_timeTo()!=null){
			taskAction.setRegister_timeTo(taskBean.getRegister_timeTo());
			taskAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(taskBean.getRegister_timeTo()));
			cale.setTimeInMillis(taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) taskAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else taskAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			taskAction.setRegister_timeHourSelectTo(taskAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) taskAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else taskAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			taskAction.setRegister_timeMinuteSelectTo(taskAction.register_timeMinuteTo);
		}
		if(taskBean.getUpdate_timeFrom()!=null){
			taskAction.setUpdate_timeFrom(taskBean.getUpdate_timeFrom());
			taskAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(taskBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) taskAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else taskAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			taskAction.setUpdate_timeHourSelectFrom(taskAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) taskAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else taskAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			taskAction.setUpdate_timeMinuteSelectFrom(taskAction.update_timeMinuteFrom);
		}
		if(taskBean.getUpdate_timeTo()!=null){
			taskAction.setUpdate_timeTo(taskBean.getUpdate_timeTo());
			taskAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(taskBean.getUpdate_timeTo()));
			cale.setTimeInMillis(taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) taskAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else taskAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			taskAction.setUpdate_timeHourSelectTo(taskAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) taskAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else taskAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			taskAction.setUpdate_timeMinuteSelectTo(taskAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param TaskAction action句柄
	 * @param TaskBean action句柄
	 * @param type 控件类型
	 */
	public TaskBean wrapperTaskBean(TaskAction taskAction,TaskBean taskBean,String type){
				//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setPro_image1(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getPro_image1(),"image"));
		else taskBean.setPro_image1(taskBean.getPro_image1());
		//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setPro_image2(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getPro_image2(),"image"));
		else taskBean.setPro_image2(taskBean.getPro_image2());
		//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setPro_image3(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getPro_image3(),"image"));
		else taskBean.setPro_image3(taskBean.getPro_image3());
		//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setPro_image4(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getPro_image4(),"image"));
		else taskBean.setPro_image4(taskBean.getPro_image4());
		//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setPro_image5(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getPro_image5(),"image"));
		else taskBean.setPro_image5(taskBean.getPro_image5());
		//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setSolve_image1(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getSolve_image1(),"image"));
		else taskBean.setSolve_image1(taskBean.getSolve_image1());
		//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setSolve_image2(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getSolve_image2(),"image"));
		else taskBean.setSolve_image2(taskBean.getSolve_image2());
		//上传照片显示***********************************************************************
		if(type.equals("show")) taskBean.setSolve_image3(Utilities.getWrapperUploadFileLinkString(taskAction.request,taskBean.getSolve_image3(),"image"));
		else taskBean.setSolve_image3(taskBean.getSolve_image3());
		//s:select***************************************************************************
		InitPageControl.initStatusMap(taskAction);
		taskBean.setStatus(Utilities.getWrapperSelect(taskBean.getStatus(),taskAction.statusMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(taskAction);
		taskBean.setInvalid(Utilities.getWrapperSelect(taskBean.getInvalid(),taskAction.invalidMap));

		return taskBean;
	}
	
	/**
	 * 记录显示包装
	 * @param TaskAction action句柄
	 * @param type 控件类型
	 */
    public List<TaskBean> wrapperRecorders(TaskAction taskAction,String type){
    	TaskBean task=null;
    	List<TaskBean> newTaskList=TaskUtility.getIocHandel().getBean("List_TaskBean",java.util.ArrayList.class);
    	for(int i=0;i<taskAction.taskList.size();i++){
    		task=taskAction.taskList.get(i);
    		task=wrapperTaskBean(taskAction,task,type);
    		newTaskList.add(task);
    	}
    	return newTaskList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param TaskAction action句柄
	 * @param TaskBean action句柄
	 */
	private void write2ControlsCommon(TaskAction taskAction,TaskBean taskBean){
		taskAction.setId(taskBean.getId());
				//textfield
		if(taskBean.getTaskid()!=null)
			if(taskBean.getTaskid().trim().length()>0) taskAction.setTaskid(taskBean.getTaskid());
		//textfield
		if(taskBean.getUserkey()!=null)
			if(taskBean.getUserkey().trim().length()>0) taskAction.setUserkey(taskBean.getUserkey());
		//textfield
		if(taskBean.getServerkey()!=null)
			if(taskBean.getServerkey().trim().length()>0) taskAction.setServerkey(taskBean.getServerkey());
		//textfield
		if(taskBean.getPro_description()!=null)
			if(taskBean.getPro_description().trim().length()>0) taskAction.setPro_description(taskBean.getPro_description());
		//img upload
		if(taskBean.getPro_image1()!=null){
			if(taskBean.getPro_image1().trim().length()>0) taskAction.setPro_image1(taskBean.getPro_image1());
			else taskAction.setPro_image1("");
		}else taskAction.setPro_image1("");
		//img upload
		if(taskBean.getPro_image2()!=null){
			if(taskBean.getPro_image2().trim().length()>0) taskAction.setPro_image2(taskBean.getPro_image2());
			else taskAction.setPro_image2("");
		}else taskAction.setPro_image2("");
		//img upload
		if(taskBean.getPro_image3()!=null){
			if(taskBean.getPro_image3().trim().length()>0) taskAction.setPro_image3(taskBean.getPro_image3());
			else taskAction.setPro_image3("");
		}else taskAction.setPro_image3("");
		//img upload
		if(taskBean.getPro_image4()!=null){
			if(taskBean.getPro_image4().trim().length()>0) taskAction.setPro_image4(taskBean.getPro_image4());
			else taskAction.setPro_image4("");
		}else taskAction.setPro_image4("");
		//img upload
		if(taskBean.getPro_image5()!=null){
			if(taskBean.getPro_image5().trim().length()>0) taskAction.setPro_image5(taskBean.getPro_image5());
			else taskAction.setPro_image5("");
		}else taskAction.setPro_image5("");
		//img upload
		if(taskBean.getSolve_image1()!=null){
			if(taskBean.getSolve_image1().trim().length()>0) taskAction.setSolve_image1(taskBean.getSolve_image1());
			else taskAction.setSolve_image1("");
		}else taskAction.setSolve_image1("");
		//img upload
		if(taskBean.getSolve_image2()!=null){
			if(taskBean.getSolve_image2().trim().length()>0) taskAction.setSolve_image2(taskBean.getSolve_image2());
			else taskAction.setSolve_image2("");
		}else taskAction.setSolve_image2("");
		//img upload
		if(taskBean.getSolve_image3()!=null){
			if(taskBean.getSolve_image3().trim().length()>0) taskAction.setSolve_image3(taskBean.getSolve_image3());
			else taskAction.setSolve_image3("");
		}else taskAction.setSolve_image3("");
		//textfield
		if(taskBean.getSeat()!=null)
			if(taskBean.getSeat().trim().length()>0) taskAction.setSeat(taskBean.getSeat());
		//select
		if(taskBean.getStatus()!=null){
			if(taskBean.getStatus().trim().length()>0){
				if(!taskAction.action.equals("detail")){
					taskAction.setStatus(taskBean.getStatus());
					taskAction.setStatusSelect(taskBean.getStatus());
				}else taskAction.setStatus(Utilities.getWrapperSelect(taskBean.getStatus(),taskAction.statusMap));
			}
		}
		//select
		if(taskBean.getInvalid()!=null){
			if(taskBean.getInvalid().trim().length()>0){
				if(!taskAction.action.equals("detail")){
					taskAction.setInvalid(taskBean.getInvalid());
					taskAction.setInvalidSelect(taskBean.getInvalid());
				}else taskAction.setInvalid(Utilities.getWrapperSelect(taskBean.getInvalid(),taskAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param TaskBean action句柄
	 * @param TaskAction action句柄
	 */
	private TaskBean setTaskBeanCommonAttributes(TaskBean taskBean,TaskAction taskAction){
				taskBean.setTaskid(taskAction.taskid);
		taskBean.setUserkey(taskAction.userkey);
		taskBean.setServerkey(taskAction.serverkey);
		taskBean.setPro_description(taskAction.pro_description);
		taskBean.setPro_image1(taskAction.pro_image1);
		taskBean.setPro_image2(taskAction.pro_image2);
		taskBean.setPro_image3(taskAction.pro_image3);
		taskBean.setPro_image4(taskAction.pro_image4);
		taskBean.setPro_image5(taskAction.pro_image5);
		taskBean.setSolve_image1(taskAction.solve_image1);
		taskBean.setSolve_image2(taskAction.solve_image2);
		taskBean.setSolve_image3(taskAction.solve_image3);
		taskBean.setSeat(taskAction.seat);
		taskBean.setStatus(taskAction.status);
		taskBean.setInvalid(taskAction.invalid);

		return taskBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param taskQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(TaskBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getTaskid().trim().length()>0)
			paramStr.append("&taskid=").append(queryConditionsBean.getTaskid().trim());
		if(queryConditionsBean.getUserkey().trim().length()>0)
			paramStr.append("&userkey=").append(queryConditionsBean.getUserkey().trim());
		if(queryConditionsBean.getServerkey().trim().length()>0)
			paramStr.append("&serverkey=").append(queryConditionsBean.getServerkey().trim());
		if(queryConditionsBean.getTipFrom()!=null)
				paramStr.append("&tipFrom=").append(queryConditionsBean.getTipFrom());
		if(queryConditionsBean.getTipTo()!=null)
				paramStr.append("&tipTo=").append(queryConditionsBean.getTipTo());
		if(queryConditionsBean.getEpsonFrom()!=null)
				paramStr.append("&epsonFrom=").append(queryConditionsBean.getEpsonFrom());
		if(queryConditionsBean.getEpsonTo()!=null)
				paramStr.append("&epsonTo=").append(queryConditionsBean.getEpsonTo());
		if(queryConditionsBean.getPro_description().trim().length()>0)
			paramStr.append("&pro_description=").append(queryConditionsBean.getPro_description().trim());
		if(queryConditionsBean.getPro_image1().trim().length()>0)
			paramStr.append("&pro_image1=").append(queryConditionsBean.getPro_image1().trim());
		if(queryConditionsBean.getPro_image2().trim().length()>0)
			paramStr.append("&pro_image2=").append(queryConditionsBean.getPro_image2().trim());
		if(queryConditionsBean.getPro_image3().trim().length()>0)
			paramStr.append("&pro_image3=").append(queryConditionsBean.getPro_image3().trim());
		if(queryConditionsBean.getPro_image4().trim().length()>0)
			paramStr.append("&pro_image4=").append(queryConditionsBean.getPro_image4().trim());
		if(queryConditionsBean.getPro_image5().trim().length()>0)
			paramStr.append("&pro_image5=").append(queryConditionsBean.getPro_image5().trim());
		if(queryConditionsBean.getSolve_image1().trim().length()>0)
			paramStr.append("&solve_image1=").append(queryConditionsBean.getSolve_image1().trim());
		if(queryConditionsBean.getSolve_image2().trim().length()>0)
			paramStr.append("&solve_image2=").append(queryConditionsBean.getSolve_image2().trim());
		if(queryConditionsBean.getSolve_image3().trim().length()>0)
			paramStr.append("&solve_image3=").append(queryConditionsBean.getSolve_image3().trim());
		if(queryConditionsBean.getSeat().trim().length()>0)
			paramStr.append("&seat=").append(queryConditionsBean.getSeat().trim());
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