package edu.jt.exg.logic.comment;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.CommentAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param CommentAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(CommentAction commentAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			commentAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			commentAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			commentAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(commentAction.start==null) commentAction.start="0";
        else if(commentAction.start.length()==0) commentAction.start="0";
        if(commentAction.range==null) commentAction.range=ConstSetup.REFERENCE_RANGE;
        else if(commentAction.range.length()==0) commentAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(commentAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param CommentAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(CommentAction commentAction){
    	//获取记录范围*************************************************
    	commentAction.action=commentAction.request.getParameter("action");
        if(commentAction.start==null) commentAction.start="0";
        else if(commentAction.start.length()==0) commentAction.start="0";
        if(commentAction.range==null) commentAction.range=ConstSetup.REFERENCE_RANGE;
        else if(commentAction.range.length()==0) commentAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(commentAction);
    }
    
    /**
	 * 设置排序
	 * @param CommentAction action句柄
	 */
    private void setOrderByMap(CommentAction commentAction){
        commentAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(CommentSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param CommentAction action句柄
	 */
	public void setControlsValues(CommentAction commentAction){
			InitPageControl.initCategoryMap(commentAction);
		InitPageControl.initInvalidMap(commentAction);
		InitPageControl.initTimestamp(commentAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param CommentAction action句柄
	 * @param params 设置参数
	 */
	public CommentBean getQueryConditionsFromParams(CommentAction commentAction,String params){
		CommentBean commentBean=CommentUtility.getIocHandel().getBean("CommentBean",CommentBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("userkey=")==0){
			pos=tmp.indexOf("userkey=");
			commentBean.setUserkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("targetkey=")==0){
			pos=tmp.indexOf("targetkey=");
			commentBean.setTargetkey(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("detail=")==0){
			pos=tmp.indexOf("detail=");
			commentBean.setDetail(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("pic1=")==0){
			pos=tmp.indexOf("pic1=");
			commentBean.setPic1(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic2=")==0){
			pos=tmp.indexOf("pic2=");
			commentBean.setPic2(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic3=")==0){
			pos=tmp.indexOf("pic3=");
			commentBean.setPic3(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("category=")==0){
			pos=tmp.indexOf("category=");
			commentBean.setCategory(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("displayFrom=")==0){
			pos=tmp.indexOf("displayFrom=");
			commentBean.setDisplayFrom(Integer.valueOf(tmp.substring(pos+12,tmp.length())));
		}else if(array[i].indexOf("displayTo=")!=-1){
			pos=tmp.indexOf("displayTo=");
			commentBean.setDisplayTo(Integer.valueOf(tmp.substring(pos+10,tmp.length())));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			commentBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			commentBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			commentBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			commentBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			commentBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return commentBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param CommentAction action句柄
	 */
	public CommentBean getQueryConditionsFromForm(CommentAction commentAction){
		CommentBean commentBean=CommentUtility.getIocHandel().getBean("CommentBean",CommentBean.class);
		commentBean=setCommentBeanCommonAttributes(commentBean,commentAction);
				commentBean.setDisplayFrom(commentAction.displayFrom);
		commentBean.setDisplayTo(commentAction.displayTo);
		commentAction.register_timeFrom=Utilities.setTimeStampFunction(commentAction.register_timeDateFrom,commentAction.register_timeHourFrom,commentAction.register_timeMinuteFrom);
		commentBean.setRegister_timeFrom(commentAction.register_timeFrom);
		commentAction.register_timeTo=Utilities.setTimeStampFunction(commentAction.register_timeDateTo,commentAction.register_timeHourTo,commentAction.register_timeMinuteTo);
		commentBean.setRegister_timeTo(commentAction.register_timeTo);
		commentAction.update_timeFrom=Utilities.setTimeStampFunction(commentAction.update_timeDateFrom,commentAction.update_timeHourFrom,commentAction.update_timeMinuteFrom);
		commentBean.setUpdate_timeFrom(commentAction.update_timeFrom);
		commentAction.update_timeTo=Utilities.setTimeStampFunction(commentAction.update_timeDateTo,commentAction.update_timeHourTo,commentAction.update_timeMinuteTo);
		commentBean.setUpdate_timeTo(commentAction.update_timeTo);

		return commentBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param CommentAction action句柄
	 */
	public String readControlsWrite2Datas(CommentAction commentAction){
		String errorMsg="";
				CommentBean commentBean=CommentUtility.getIocHandel().getBean("CommentBean",CommentBean.class);
		if(commentAction.action.equals("create")) commentBean.setId(Utilities.getRandomPK(true));
		else commentBean.setId(commentAction.id);
		commentBean=setCommentBeanCommonAttributes(commentBean,commentAction);
		commentBean.setDisplay(commentAction.display);
		commentBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		commentBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		commentAction.batisDao=CommentUtility.getIocHandel().getBean("CommentBatisDao",CommentBatisDao.class);
		if(commentAction.action.equals("create")) errorMsg=Integer.toString(commentAction.batisDao.insert(commentBean));
		else errorMsg=Integer.toString(commentAction.batisDao.updateByKey(commentBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param CommentAction action句柄
	 */
	public void readDatasWrite2Controls(CommentAction commentAction){
		
		
		
		
		
		
		commentAction.batisDao=CommentUtility.getIocHandel().getBean("CommentBatisDao",CommentBatisDao.class);
		CommentBean commentBean=commentAction.batisDao.findByKey(commentAction.id);
		
		
		
		write2ControlsCommon(commentAction,commentBean);
				if(commentBean.getDisplay()!=null)
			if(commentBean.getDisplay().intValue()>=0) commentAction.setDisplay(commentBean.getDisplay());
		//auto timestamp
		if(commentAction.action.equals("detail")) commentAction.setRegister_time(commentBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(commentAction.action.equals("detail")) commentAction.setUpdate_time(commentBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param CommentAction action句柄
	 * @param CommentBean action句柄
	 */
	public void readConditionsWrite2Controls(CommentAction commentAction,CommentBean commentBean){
		write2ControlsCommon(commentAction,commentBean);
				if(commentBean.getDisplayFrom()!=null)
			if(commentBean.getDisplayFrom().intValue()>=0) commentAction.setDisplayFrom(commentBean.getDisplayFrom());
		if(commentBean.getDisplayTo()!=null)
			if(commentBean.getDisplayTo().intValue()>=0) commentAction.setDisplayTo(commentBean.getDisplayTo());
		if(commentBean.getRegister_timeFrom()!=null){
			commentAction.setRegister_timeFrom(commentBean.getRegister_timeFrom());
			commentAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(commentBean.getRegister_timeFrom()));
			cale.setTimeInMillis(commentBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) commentAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else commentAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			commentAction.setRegister_timeHourSelectFrom(commentAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) commentAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else commentAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			commentAction.setRegister_timeMinuteSelectFrom(commentAction.register_timeMinuteFrom);
		}
		if(commentBean.getRegister_timeTo()!=null){
			commentAction.setRegister_timeTo(commentBean.getRegister_timeTo());
			commentAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(commentBean.getRegister_timeTo()));
			cale.setTimeInMillis(commentBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) commentAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else commentAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			commentAction.setRegister_timeHourSelectTo(commentAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) commentAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else commentAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			commentAction.setRegister_timeMinuteSelectTo(commentAction.register_timeMinuteTo);
		}
		if(commentBean.getUpdate_timeFrom()!=null){
			commentAction.setUpdate_timeFrom(commentBean.getUpdate_timeFrom());
			commentAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(commentBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(commentBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) commentAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else commentAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			commentAction.setUpdate_timeHourSelectFrom(commentAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) commentAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else commentAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			commentAction.setUpdate_timeMinuteSelectFrom(commentAction.update_timeMinuteFrom);
		}
		if(commentBean.getUpdate_timeTo()!=null){
			commentAction.setUpdate_timeTo(commentBean.getUpdate_timeTo());
			commentAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(commentBean.getUpdate_timeTo()));
			cale.setTimeInMillis(commentBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) commentAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else commentAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			commentAction.setUpdate_timeHourSelectTo(commentAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) commentAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else commentAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			commentAction.setUpdate_timeMinuteSelectTo(commentAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param CommentAction action句柄
	 * @param CommentBean action句柄
	 * @param type 控件类型
	 */
	public CommentBean wrapperCommentBean(CommentAction commentAction,CommentBean commentBean,String type){
				//上传照片显示***********************************************************************
		if(type.equals("show")) commentBean.setPic1(Utilities.getWrapperUploadFileLinkString(commentAction.request,commentBean.getPic1(),"image"));
		else commentBean.setPic1(commentBean.getPic1());
		//上传照片显示***********************************************************************
		if(type.equals("show")) commentBean.setPic2(Utilities.getWrapperUploadFileLinkString(commentAction.request,commentBean.getPic2(),"image"));
		else commentBean.setPic2(commentBean.getPic2());
		//上传照片显示***********************************************************************
		if(type.equals("show")) commentBean.setPic3(Utilities.getWrapperUploadFileLinkString(commentAction.request,commentBean.getPic3(),"image"));
		else commentBean.setPic3(commentBean.getPic3());
		//s:select***************************************************************************
		InitPageControl.initCategoryMap(commentAction);
		commentBean.setCategory(Utilities.getWrapperSelect(commentBean.getCategory(),commentAction.categoryMap));
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(commentAction);
		commentBean.setInvalid(Utilities.getWrapperSelect(commentBean.getInvalid(),commentAction.invalidMap));

		return commentBean;
	}
	
	/**
	 * 记录显示包装
	 * @param CommentAction action句柄
	 * @param type 控件类型
	 */
    public List<CommentBean> wrapperRecorders(CommentAction commentAction,String type){
    	CommentBean comment=null;
    	List<CommentBean> newCommentList=CommentUtility.getIocHandel().getBean("List_CommentBean",java.util.ArrayList.class);
    	for(int i=0;i<commentAction.commentList.size();i++){
    		comment=commentAction.commentList.get(i);
    		comment=wrapperCommentBean(commentAction,comment,type);
    		newCommentList.add(comment);
    	}
    	return newCommentList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param CommentAction action句柄
	 * @param CommentBean action句柄
	 */
	private void write2ControlsCommon(CommentAction commentAction,CommentBean commentBean){
		commentAction.setId(commentBean.getId());
				//textfield
		if(commentBean.getUserkey()!=null)
			if(commentBean.getUserkey().trim().length()>0) commentAction.setUserkey(commentBean.getUserkey());
		//textfield
		if(commentBean.getTargetkey()!=null)
			if(commentBean.getTargetkey().trim().length()>0) commentAction.setTargetkey(commentBean.getTargetkey());
		//textfield
		if(commentBean.getDetail()!=null)
			if(commentBean.getDetail().trim().length()>0) commentAction.setDetail(commentBean.getDetail());
		//img upload
		if(commentBean.getPic1()!=null){
			if(commentBean.getPic1().trim().length()>0) commentAction.setPic1(commentBean.getPic1());
			else commentAction.setPic1("");
		}else commentAction.setPic1("");
		//img upload
		if(commentBean.getPic2()!=null){
			if(commentBean.getPic2().trim().length()>0) commentAction.setPic2(commentBean.getPic2());
			else commentAction.setPic2("");
		}else commentAction.setPic2("");
		//img upload
		if(commentBean.getPic3()!=null){
			if(commentBean.getPic3().trim().length()>0) commentAction.setPic3(commentBean.getPic3());
			else commentAction.setPic3("");
		}else commentAction.setPic3("");
		//select
		if(commentBean.getCategory()!=null){
			if(commentBean.getCategory().trim().length()>0){
				if(!commentAction.action.equals("detail")){
					commentAction.setCategory(commentBean.getCategory());
					commentAction.setCategorySelect(commentBean.getCategory());
				}else commentAction.setCategory(Utilities.getWrapperSelect(commentBean.getCategory(),commentAction.categoryMap));
			}
		}
		//select
		if(commentBean.getInvalid()!=null){
			if(commentBean.getInvalid().trim().length()>0){
				if(!commentAction.action.equals("detail")){
					commentAction.setInvalid(commentBean.getInvalid());
					commentAction.setInvalidSelect(commentBean.getInvalid());
				}else commentAction.setInvalid(Utilities.getWrapperSelect(commentBean.getInvalid(),commentAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param CommentBean action句柄
	 * @param CommentAction action句柄
	 */
	private CommentBean setCommentBeanCommonAttributes(CommentBean commentBean,CommentAction commentAction){
				commentBean.setUserkey(commentAction.userkey);
		commentBean.setTargetkey(commentAction.targetkey);
		commentBean.setDetail(commentAction.detail);
		commentBean.setPic1(commentAction.pic1);
		commentBean.setPic2(commentAction.pic2);
		commentBean.setPic3(commentAction.pic3);
		commentBean.setCategory(commentAction.category);
		commentBean.setInvalid(commentAction.invalid);

		return commentBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param commentQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(CommentBean queryConditionsBean){
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
		if(queryConditionsBean.getCategory()!=null)
			if(queryConditionsBean.getCategory().trim().length()>0)
				paramStr.append("&category=").append(queryConditionsBean.getCategory().trim());
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