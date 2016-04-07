package edu.jt.exg.logic.re_serve;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.Re_serveAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Re_serveAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(Re_serveAction re_serveAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			re_serveAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			re_serveAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			re_serveAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(re_serveAction.start==null) re_serveAction.start="0";
        else if(re_serveAction.start.length()==0) re_serveAction.start="0";
        if(re_serveAction.range==null) re_serveAction.range=ConstSetup.REFERENCE_RANGE;
        else if(re_serveAction.range.length()==0) re_serveAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(re_serveAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param Re_serveAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(Re_serveAction re_serveAction){
    	//获取记录范围*************************************************
    	re_serveAction.action=re_serveAction.request.getParameter("action");
        if(re_serveAction.start==null) re_serveAction.start="0";
        else if(re_serveAction.start.length()==0) re_serveAction.start="0";
        if(re_serveAction.range==null) re_serveAction.range=ConstSetup.REFERENCE_RANGE;
        else if(re_serveAction.range.length()==0) re_serveAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(re_serveAction);
    }
    
    /**
	 * 设置排序
	 * @param Re_serveAction action句柄
	 */
    private void setOrderByMap(Re_serveAction re_serveAction){
        re_serveAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(Re_serveSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param Re_serveAction action句柄
	 */
	public void setControlsValues(Re_serveAction re_serveAction){
			InitPageControl.initInvalidMap(re_serveAction);
		InitPageControl.initTimestamp(re_serveAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param Re_serveAction action句柄
	 * @param params 设置参数
	 */
	public Re_serveBean getQueryConditionsFromParams(Re_serveAction re_serveAction,String params){
		Re_serveBean re_serveBean=Re_serveUtility.getIocHandel().getBean("Re_serveBean",Re_serveBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("serveid=")==0){
			pos=tmp.indexOf("serveid=");
			re_serveBean.setServeid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("name=")==0){
			pos=tmp.indexOf("name=");
			re_serveBean.setName(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("priceFrom=")==0){
			pos=tmp.indexOf("priceFrom=");
			re_serveBean.setPriceFrom(Double.valueOf(tmp.substring(pos+10,tmp.length())));
		}else if(array[i].indexOf("priceTo=")==0){
			pos=tmp.indexOf("priceTo=");
			re_serveBean.setPriceTo(Double.valueOf(tmp.substring(pos+8,tmp.length())));
		}
		if(array[i].indexOf("varieties=")==0){
			pos=tmp.indexOf("varieties=");
			re_serveBean.setVarieties(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("description=")==0){
			pos=tmp.indexOf("description=");
			re_serveBean.setDescription(tmp.substring(pos+12,tmp.length()));
		}
		if(array[i].indexOf("top_pic1=")==0){
			pos=tmp.indexOf("top_pic1=");
			re_serveBean.setTop_pic1(tmp.substring(pos+9,tmp.length()));
		}
		if(array[i].indexOf("pic1=")==0){
			pos=tmp.indexOf("pic1=");
			re_serveBean.setPic1(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic2=")==0){
			pos=tmp.indexOf("pic2=");
			re_serveBean.setPic2(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic3=")==0){
			pos=tmp.indexOf("pic3=");
			re_serveBean.setPic3(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic4=")==0){
			pos=tmp.indexOf("pic4=");
			re_serveBean.setPic4(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("pic5=")==0){
			pos=tmp.indexOf("pic5=");
			re_serveBean.setPic5(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("yubei1=")==0){
			pos=tmp.indexOf("yubei1=");
			re_serveBean.setYubei1(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("yubei2=")==0){
			pos=tmp.indexOf("yubei2=");
			re_serveBean.setYubei2(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("yubei3=")==0){
			pos=tmp.indexOf("yubei3=");
			re_serveBean.setYubei3(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("displayFrom=")==0){
			pos=tmp.indexOf("displayFrom=");
			re_serveBean.setDisplayFrom(Integer.valueOf(tmp.substring(pos+12,tmp.length())));
		}else if(array[i].indexOf("displayTo=")!=-1){
			pos=tmp.indexOf("displayTo=");
			re_serveBean.setDisplayTo(Integer.valueOf(tmp.substring(pos+10,tmp.length())));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			re_serveBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			re_serveBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			re_serveBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			re_serveBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			re_serveBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}

		}
		return re_serveBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param Re_serveAction action句柄
	 */
	public Re_serveBean getQueryConditionsFromForm(Re_serveAction re_serveAction){
		Re_serveBean re_serveBean=Re_serveUtility.getIocHandel().getBean("Re_serveBean",Re_serveBean.class);
		re_serveBean=setRe_serveBeanCommonAttributes(re_serveBean,re_serveAction);
				re_serveBean.setPriceFrom(re_serveAction.priceFrom);
		re_serveBean.setPriceTo(re_serveAction.priceTo);
		re_serveBean.setDisplayFrom(re_serveAction.displayFrom);
		re_serveBean.setDisplayTo(re_serveAction.displayTo);
		re_serveAction.register_timeFrom=Utilities.setTimeStampFunction(re_serveAction.register_timeDateFrom,re_serveAction.register_timeHourFrom,re_serveAction.register_timeMinuteFrom);
		re_serveBean.setRegister_timeFrom(re_serveAction.register_timeFrom);
		re_serveAction.register_timeTo=Utilities.setTimeStampFunction(re_serveAction.register_timeDateTo,re_serveAction.register_timeHourTo,re_serveAction.register_timeMinuteTo);
		re_serveBean.setRegister_timeTo(re_serveAction.register_timeTo);
		re_serveAction.update_timeFrom=Utilities.setTimeStampFunction(re_serveAction.update_timeDateFrom,re_serveAction.update_timeHourFrom,re_serveAction.update_timeMinuteFrom);
		re_serveBean.setUpdate_timeFrom(re_serveAction.update_timeFrom);
		re_serveAction.update_timeTo=Utilities.setTimeStampFunction(re_serveAction.update_timeDateTo,re_serveAction.update_timeHourTo,re_serveAction.update_timeMinuteTo);
		re_serveBean.setUpdate_timeTo(re_serveAction.update_timeTo);

		return re_serveBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param Re_serveAction action句柄
	 */
	public String readControlsWrite2Datas(Re_serveAction re_serveAction){
		String errorMsg="";
				Re_serveBean re_serveBean=Re_serveUtility.getIocHandel().getBean("Re_serveBean",Re_serveBean.class);
		if(re_serveAction.action.equals("create")) re_serveBean.setId(Utilities.getRandomPK(true));
		else re_serveBean.setId(re_serveAction.id);
		re_serveBean=setRe_serveBeanCommonAttributes(re_serveBean,re_serveAction);
		re_serveBean.setPrice(re_serveAction.price);
		re_serveBean.setDisplay(re_serveAction.display);
		re_serveBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		re_serveBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		
		
		
		
		
		
		
		
		
		re_serveAction.batisDao=Re_serveUtility.getIocHandel().getBean("Re_serveBatisDao",Re_serveBatisDao.class);
		if(re_serveAction.action.equals("create")) errorMsg=Integer.toString(re_serveAction.batisDao.insert(re_serveBean));
		else errorMsg=Integer.toString(re_serveAction.batisDao.updateByKey(re_serveBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param Re_serveAction action句柄
	 */
	public void readDatasWrite2Controls(Re_serveAction re_serveAction){
		
		
		
		
		
		
		re_serveAction.batisDao=Re_serveUtility.getIocHandel().getBean("Re_serveBatisDao",Re_serveBatisDao.class);
		Re_serveBean re_serveBean=re_serveAction.batisDao.findByKey(re_serveAction.id);
		
		
		
		write2ControlsCommon(re_serveAction,re_serveBean);
				if(re_serveBean.getPrice()!=null)
			if(re_serveBean.getPrice().doubleValue()!=0) re_serveAction.setPrice(re_serveBean.getPrice());
		if(re_serveBean.getDisplay()!=null)
			if(re_serveBean.getDisplay().intValue()>=0) re_serveAction.setDisplay(re_serveBean.getDisplay());
		//auto timestamp
		if(re_serveAction.action.equals("detail")) re_serveAction.setRegister_time(re_serveBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(re_serveAction.action.equals("detail")) re_serveAction.setUpdate_time(re_serveBean.getUpdate_time());//auto timestamp只作detail显示

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param Re_serveAction action句柄
	 * @param Re_serveBean action句柄
	 */
	public void readConditionsWrite2Controls(Re_serveAction re_serveAction,Re_serveBean re_serveBean){
		write2ControlsCommon(re_serveAction,re_serveBean);
				if(re_serveBean.getPriceFrom()!=null)
			if(re_serveBean.getPriceFrom().doubleValue()!=0) re_serveAction.setPriceFrom(re_serveBean.getPriceFrom());
		if(re_serveBean.getPriceTo()!=null)
			if(re_serveBean.getPriceTo().doubleValue()!=0) re_serveAction.setPriceTo(re_serveBean.getPriceTo());
		if(re_serveBean.getDisplayFrom()!=null)
			if(re_serveBean.getDisplayFrom().intValue()>=0) re_serveAction.setDisplayFrom(re_serveBean.getDisplayFrom());
		if(re_serveBean.getDisplayTo()!=null)
			if(re_serveBean.getDisplayTo().intValue()>=0) re_serveAction.setDisplayTo(re_serveBean.getDisplayTo());
		if(re_serveBean.getRegister_timeFrom()!=null){
			re_serveAction.setRegister_timeFrom(re_serveBean.getRegister_timeFrom());
			re_serveAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(re_serveBean.getRegister_timeFrom()));
			cale.setTimeInMillis(re_serveBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) re_serveAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else re_serveAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			re_serveAction.setRegister_timeHourSelectFrom(re_serveAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) re_serveAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else re_serveAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			re_serveAction.setRegister_timeMinuteSelectFrom(re_serveAction.register_timeMinuteFrom);
		}
		if(re_serveBean.getRegister_timeTo()!=null){
			re_serveAction.setRegister_timeTo(re_serveBean.getRegister_timeTo());
			re_serveAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(re_serveBean.getRegister_timeTo()));
			cale.setTimeInMillis(re_serveBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) re_serveAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else re_serveAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			re_serveAction.setRegister_timeHourSelectTo(re_serveAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) re_serveAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else re_serveAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			re_serveAction.setRegister_timeMinuteSelectTo(re_serveAction.register_timeMinuteTo);
		}
		if(re_serveBean.getUpdate_timeFrom()!=null){
			re_serveAction.setUpdate_timeFrom(re_serveBean.getUpdate_timeFrom());
			re_serveAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(re_serveBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(re_serveBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) re_serveAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else re_serveAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			re_serveAction.setUpdate_timeHourSelectFrom(re_serveAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) re_serveAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else re_serveAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			re_serveAction.setUpdate_timeMinuteSelectFrom(re_serveAction.update_timeMinuteFrom);
		}
		if(re_serveBean.getUpdate_timeTo()!=null){
			re_serveAction.setUpdate_timeTo(re_serveBean.getUpdate_timeTo());
			re_serveAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(re_serveBean.getUpdate_timeTo()));
			cale.setTimeInMillis(re_serveBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) re_serveAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else re_serveAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			re_serveAction.setUpdate_timeHourSelectTo(re_serveAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) re_serveAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else re_serveAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			re_serveAction.setUpdate_timeMinuteSelectTo(re_serveAction.update_timeMinuteTo);
		}

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param Re_serveAction action句柄
	 * @param Re_serveBean action句柄
	 * @param type 控件类型
	 */
	public Re_serveBean wrapperRe_serveBean(Re_serveAction re_serveAction,Re_serveBean re_serveBean,String type){
				//s:checkbox************************************************************************
		re_serveBean.setVarieties(Utilities.getWrapperCheckbox(re_serveBean.getVarieties(),"Y","N"));
		//上传照片显示***********************************************************************
		if(type.equals("show")) re_serveBean.setTop_pic1(Utilities.getWrapperUploadFileLinkString(re_serveAction.request,re_serveBean.getTop_pic1(),"image"));
		else re_serveBean.setTop_pic1(re_serveBean.getTop_pic1());
		//上传照片显示***********************************************************************
		if(type.equals("show")) re_serveBean.setPic1(Utilities.getWrapperUploadFileLinkString(re_serveAction.request,re_serveBean.getPic1(),"image"));
		else re_serveBean.setPic1(re_serveBean.getPic1());
		//上传照片显示***********************************************************************
		if(type.equals("show")) re_serveBean.setPic2(Utilities.getWrapperUploadFileLinkString(re_serveAction.request,re_serveBean.getPic2(),"image"));
		else re_serveBean.setPic2(re_serveBean.getPic2());
		//上传照片显示***********************************************************************
		if(type.equals("show")) re_serveBean.setPic3(Utilities.getWrapperUploadFileLinkString(re_serveAction.request,re_serveBean.getPic3(),"image"));
		else re_serveBean.setPic3(re_serveBean.getPic3());
		//上传照片显示***********************************************************************
		if(type.equals("show")) re_serveBean.setPic4(Utilities.getWrapperUploadFileLinkString(re_serveAction.request,re_serveBean.getPic4(),"image"));
		else re_serveBean.setPic4(re_serveBean.getPic4());
		//上传照片显示***********************************************************************
		if(type.equals("show")) re_serveBean.setPic5(Utilities.getWrapperUploadFileLinkString(re_serveAction.request,re_serveBean.getPic5(),"image"));
		else re_serveBean.setPic5(re_serveBean.getPic5());
		//s:select***************************************************************************
		InitPageControl.initInvalidMap(re_serveAction);
		re_serveBean.setInvalid(Utilities.getWrapperSelect(re_serveBean.getInvalid(),re_serveAction.invalidMap));

		return re_serveBean;
	}
	
	/**
	 * 记录显示包装
	 * @param Re_serveAction action句柄
	 * @param type 控件类型
	 */
    public List<Re_serveBean> wrapperRecorders(Re_serveAction re_serveAction,String type){
    	Re_serveBean re_serve=null;
    	List<Re_serveBean> newRe_serveList=Re_serveUtility.getIocHandel().getBean("List_Re_serveBean",java.util.ArrayList.class);
    	for(int i=0;i<re_serveAction.re_serveList.size();i++){
    		re_serve=re_serveAction.re_serveList.get(i);
    		re_serve=wrapperRe_serveBean(re_serveAction,re_serve,type);
    		newRe_serveList.add(re_serve);
    	}
    	return newRe_serveList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param Re_serveAction action句柄
	 * @param Re_serveBean action句柄
	 */
	private void write2ControlsCommon(Re_serveAction re_serveAction,Re_serveBean re_serveBean){
		re_serveAction.setId(re_serveBean.getId());
				//textfield
		if(re_serveBean.getServeid()!=null)
			if(re_serveBean.getServeid().trim().length()>0) re_serveAction.setServeid(re_serveBean.getServeid());
		//textfield
		if(re_serveBean.getName()!=null)
			if(re_serveBean.getName().trim().length()>0) re_serveAction.setName(re_serveBean.getName());
		//checkbox
		if(re_serveBean.getVarieties()!=null){
			if(re_serveBean.getVarieties().trim().length()>0){
				if(!re_serveAction.action.equals("detail")){
					if(!re_serveBean.getVarieties().equals("false")) re_serveAction.setVarieties("true");//checkbox选中
					else re_serveAction.setVarieties("false");
				}else re_serveAction.setVarieties(Utilities.getWrapperCheckbox(re_serveBean.getVarieties(),"Y","N"));
			}
		}
		//textfield
		if(re_serveBean.getDescription()!=null)
			if(re_serveBean.getDescription().trim().length()>0) re_serveAction.setDescription(re_serveBean.getDescription());
		//img upload
		if(re_serveBean.getTop_pic1()!=null){
			if(re_serveBean.getTop_pic1().trim().length()>0) re_serveAction.setTop_pic1(re_serveBean.getTop_pic1());
			else re_serveAction.setTop_pic1("");
		}else re_serveAction.setTop_pic1("");
		//img upload
		if(re_serveBean.getPic1()!=null){
			if(re_serveBean.getPic1().trim().length()>0) re_serveAction.setPic1(re_serveBean.getPic1());
			else re_serveAction.setPic1("");
		}else re_serveAction.setPic1("");
		//img upload
		if(re_serveBean.getPic2()!=null){
			if(re_serveBean.getPic2().trim().length()>0) re_serveAction.setPic2(re_serveBean.getPic2());
			else re_serveAction.setPic2("");
		}else re_serveAction.setPic2("");
		//img upload
		if(re_serveBean.getPic3()!=null){
			if(re_serveBean.getPic3().trim().length()>0) re_serveAction.setPic3(re_serveBean.getPic3());
			else re_serveAction.setPic3("");
		}else re_serveAction.setPic3("");
		//img upload
		if(re_serveBean.getPic4()!=null){
			if(re_serveBean.getPic4().trim().length()>0) re_serveAction.setPic4(re_serveBean.getPic4());
			else re_serveAction.setPic4("");
		}else re_serveAction.setPic4("");
		//img upload
		if(re_serveBean.getPic5()!=null){
			if(re_serveBean.getPic5().trim().length()>0) re_serveAction.setPic5(re_serveBean.getPic5());
			else re_serveAction.setPic5("");
		}else re_serveAction.setPic5("");
		//textfield
		if(re_serveBean.getYubei1()!=null)
			if(re_serveBean.getYubei1().trim().length()>0) re_serveAction.setYubei1(re_serveBean.getYubei1());
		//textfield
		if(re_serveBean.getYubei2()!=null)
			if(re_serveBean.getYubei2().trim().length()>0) re_serveAction.setYubei2(re_serveBean.getYubei2());
		//textfield
		if(re_serveBean.getYubei3()!=null)
			if(re_serveBean.getYubei3().trim().length()>0) re_serveAction.setYubei3(re_serveBean.getYubei3());
		//select
		if(re_serveBean.getInvalid()!=null){
			if(re_serveBean.getInvalid().trim().length()>0){
				if(!re_serveAction.action.equals("detail")){
					re_serveAction.setInvalid(re_serveBean.getInvalid());
					re_serveAction.setInvalidSelect(re_serveBean.getInvalid());
				}else re_serveAction.setInvalid(Utilities.getWrapperSelect(re_serveBean.getInvalid(),re_serveAction.invalidMap));
			}
		}

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param Re_serveBean action句柄
	 * @param Re_serveAction action句柄
	 */
	private Re_serveBean setRe_serveBeanCommonAttributes(Re_serveBean re_serveBean,Re_serveAction re_serveAction){
				re_serveBean.setServeid(re_serveAction.serveid);
		re_serveBean.setName(re_serveAction.name);
		re_serveBean.setVarieties(re_serveAction.varieties);
		re_serveBean.setDescription(re_serveAction.description);
		re_serveBean.setTop_pic1(re_serveAction.top_pic1);
		re_serveBean.setPic1(re_serveAction.pic1);
		re_serveBean.setPic2(re_serveAction.pic2);
		re_serveBean.setPic3(re_serveAction.pic3);
		re_serveBean.setPic4(re_serveAction.pic4);
		re_serveBean.setPic5(re_serveAction.pic5);
		re_serveBean.setYubei1(re_serveAction.yubei1);
		re_serveBean.setYubei2(re_serveAction.yubei2);
		re_serveBean.setYubei3(re_serveAction.yubei3);
		re_serveBean.setInvalid(re_serveAction.invalid);

		return re_serveBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param re_serveQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(Re_serveBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getServeid().trim().length()>0)
			paramStr.append("&serveid=").append(queryConditionsBean.getServeid().trim());
		if(queryConditionsBean.getName().trim().length()>0)
			paramStr.append("&name=").append(queryConditionsBean.getName().trim());
		if(queryConditionsBean.getPriceFrom()!=null)
				paramStr.append("&priceFrom=").append(queryConditionsBean.getPriceFrom());
		if(queryConditionsBean.getPriceTo()!=null)
				paramStr.append("&priceTo=").append(queryConditionsBean.getPriceTo());
		if(queryConditionsBean.getVarieties().trim().length()>0)
			if(!queryConditionsBean.getVarieties().trim().equals("false"))
				paramStr.append("&varieties=").append(queryConditionsBean.getVarieties().trim());
		if(queryConditionsBean.getDescription().trim().length()>0)
			paramStr.append("&description=").append(queryConditionsBean.getDescription().trim());
		if(queryConditionsBean.getTop_pic1().trim().length()>0)
			paramStr.append("&top_pic1=").append(queryConditionsBean.getTop_pic1().trim());
		if(queryConditionsBean.getPic1().trim().length()>0)
			paramStr.append("&pic1=").append(queryConditionsBean.getPic1().trim());
		if(queryConditionsBean.getPic2().trim().length()>0)
			paramStr.append("&pic2=").append(queryConditionsBean.getPic2().trim());
		if(queryConditionsBean.getPic3().trim().length()>0)
			paramStr.append("&pic3=").append(queryConditionsBean.getPic3().trim());
		if(queryConditionsBean.getPic4().trim().length()>0)
			paramStr.append("&pic4=").append(queryConditionsBean.getPic4().trim());
		if(queryConditionsBean.getPic5().trim().length()>0)
			paramStr.append("&pic5=").append(queryConditionsBean.getPic5().trim());
		if(queryConditionsBean.getYubei1().trim().length()>0)
			paramStr.append("&yubei1=").append(queryConditionsBean.getYubei1().trim());
		if(queryConditionsBean.getYubei2().trim().length()>0)
			paramStr.append("&yubei2=").append(queryConditionsBean.getYubei2().trim());
		if(queryConditionsBean.getYubei3().trim().length()>0)
			paramStr.append("&yubei3=").append(queryConditionsBean.getYubei3().trim());
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