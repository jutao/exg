package edu.jt.exg.logic.v_task;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.V_taskAction;
import core.ListKeyBean;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_taskAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(V_taskAction v_taskAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			v_taskAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			v_taskAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			v_taskAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(v_taskAction.start==null) v_taskAction.start="0";
        else if(v_taskAction.start.length()==0) v_taskAction.start="0";
        if(v_taskAction.range==null) v_taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_taskAction.range.length()==0) v_taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_taskAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_taskAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(V_taskAction v_taskAction){
    	//获取记录范围*************************************************
    	v_taskAction.action=v_taskAction.request.getParameter("action");
        if(v_taskAction.start==null) v_taskAction.start="0";
        else if(v_taskAction.start.length()==0) v_taskAction.start="0";
        if(v_taskAction.range==null) v_taskAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_taskAction.range.length()==0) v_taskAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_taskAction);
    }
    
    /**
	 * 设置排序
	 * @param V_taskAction action句柄
	 */
    private void setOrderByMap(V_taskAction v_taskAction){
        v_taskAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(V_taskSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param V_taskAction action句柄
	 */
	public void setControlsValues(V_taskAction v_taskAction){
			InitPageControl.initTimestamp(v_taskAction);
	
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param V_taskAction action句柄
	 * @param params 设置参数
	 */
	public V_taskBean getQueryConditionsFromParams(V_taskAction v_taskAction,String params){
		V_taskBean v_taskBean=V_taskUtility.getIocHandel().getBean("V_taskBean",V_taskBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("taskid=")==0){
			pos=tmp.indexOf("taskid=");
			v_taskBean.setTaskid(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("userkey=")==0){
			pos=tmp.indexOf("userkey=");
			v_taskBean.setUserkey(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("serverkey=")==0){
			pos=tmp.indexOf("serverkey=");
			v_taskBean.setServerkey(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("tipFrom=")==0){
			pos=tmp.indexOf("tipFrom=");
			v_taskBean.setTipFrom(Double.valueOf(tmp.substring(pos+8,tmp.length())));
		}else if(array[i].indexOf("tipTo=")==0){
			pos=tmp.indexOf("tipTo=");
			v_taskBean.setTipTo(Double.valueOf(tmp.substring(pos+6,tmp.length())));
		}
		if(array[i].indexOf("epsonFrom=")==0){
			pos=tmp.indexOf("epsonFrom=");
			v_taskBean.setEpsonFrom(Double.valueOf(tmp.substring(pos+10,tmp.length())));
		}else if(array[i].indexOf("epsonTo=")==0){
			pos=tmp.indexOf("epsonTo=");
			v_taskBean.setEpsonTo(Double.valueOf(tmp.substring(pos+8,tmp.length())));
		}
		if(array[i].indexOf("pro_description=")==0){
			pos=tmp.indexOf("pro_description=");
			v_taskBean.setPro_description(tmp.substring(pos+16,tmp.length()));
		}
		if(array[i].indexOf("pro_image1=")==0){
			pos=tmp.indexOf("pro_image1=");
			v_taskBean.setPro_image1(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image2=")==0){
			pos=tmp.indexOf("pro_image2=");
			v_taskBean.setPro_image2(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image3=")==0){
			pos=tmp.indexOf("pro_image3=");
			v_taskBean.setPro_image3(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image4=")==0){
			pos=tmp.indexOf("pro_image4=");
			v_taskBean.setPro_image4(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("pro_image5=")==0){
			pos=tmp.indexOf("pro_image5=");
			v_taskBean.setPro_image5(tmp.substring(pos+11,tmp.length()));
		}
		if(array[i].indexOf("solve_image1=")==0){
			pos=tmp.indexOf("solve_image1=");
			v_taskBean.setSolve_image1(tmp.substring(pos+13,tmp.length()));
		}
		if(array[i].indexOf("solve_image2=")==0){
			pos=tmp.indexOf("solve_image2=");
			v_taskBean.setSolve_image2(tmp.substring(pos+13,tmp.length()));
		}
		if(array[i].indexOf("solve_image3=")==0){
			pos=tmp.indexOf("solve_image3=");
			v_taskBean.setSolve_image3(tmp.substring(pos+13,tmp.length()));
		}
		if(array[i].indexOf("seat=")==0){
			pos=tmp.indexOf("seat=");
			v_taskBean.setSeat(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("status=")==0){
			pos=tmp.indexOf("status=");
			v_taskBean.setStatus(tmp.substring(pos+7,tmp.length()));
		}
		if(array[i].indexOf("invalid=")==0){
			pos=tmp.indexOf("invalid=");
			v_taskBean.setInvalid(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("register_timeFrom=")==0){
			pos=tmp.indexOf("register_timeFrom=");
			tmp=tmp.substring(pos+18,tmp.length());
			v_taskBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("register_timeTo=")==0){
			pos=tmp.indexOf("register_timeTo=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_taskBean.setRegister_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("update_timeFrom=")==0){
			pos=tmp.indexOf("update_timeFrom=");
			tmp=tmp.substring(pos+16,tmp.length());
			v_taskBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}else if(array[i].indexOf("update_timeTo=")==0){
			pos=tmp.indexOf("update_timeTo=");
			tmp=tmp.substring(pos+14,tmp.length());
			v_taskBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,"yyyy-MM-dd hh:mm:ss"));
		}
		if(array[i].indexOf("name=")==0){
			pos=tmp.indexOf("name=");
			v_taskBean.setName(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("user_id=")==0){
			pos=tmp.indexOf("user_id=");
			v_taskBean.setUser_id(tmp.substring(pos+8,tmp.length()));
		}
		if(array[i].indexOf("icon=")==0){
			pos=tmp.indexOf("icon=");
			v_taskBean.setIcon(tmp.substring(pos+5,tmp.length()));
		}
		if(array[i].indexOf("server_name=")==0){
			pos=tmp.indexOf("server_name=");
			v_taskBean.setServer_name(tmp.substring(pos+12,tmp.length()));
		}
		if(array[i].indexOf("server_priceFrom=")==0){
			pos=tmp.indexOf("server_priceFrom=");
			v_taskBean.setServer_priceFrom(Double.valueOf(tmp.substring(pos+17,tmp.length())));
		}else if(array[i].indexOf("server_priceTo=")==0){
			pos=tmp.indexOf("server_priceTo=");
			v_taskBean.setServer_priceTo(Double.valueOf(tmp.substring(pos+15,tmp.length())));
		}
		if(array[i].indexOf("total_priceFrom=")==0){
			pos=tmp.indexOf("total_priceFrom=");
			v_taskBean.setTotal_priceFrom(Double.valueOf(tmp.substring(pos+16,tmp.length())));
		}else if(array[i].indexOf("total_priceTo=")==0){
			pos=tmp.indexOf("total_priceTo=");
			v_taskBean.setTotal_priceTo(Double.valueOf(tmp.substring(pos+14,tmp.length())));
		}

		}
		return v_taskBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param V_taskAction action句柄
	 */
	public V_taskBean getQueryConditionsFromForm(V_taskAction v_taskAction){
		V_taskBean v_taskBean=V_taskUtility.getIocHandel().getBean("V_taskBean",V_taskBean.class);
		v_taskBean=setV_taskBeanCommonAttributes(v_taskBean,v_taskAction);
				v_taskBean.setTipFrom(v_taskAction.tipFrom);
		v_taskBean.setTipTo(v_taskAction.tipTo);
		v_taskBean.setEpsonFrom(v_taskAction.epsonFrom);
		v_taskBean.setEpsonTo(v_taskAction.epsonTo);
		v_taskAction.register_timeFrom=Utilities.setTimeStampFunction(v_taskAction.register_timeDateFrom,v_taskAction.register_timeHourFrom,v_taskAction.register_timeMinuteFrom);
		v_taskBean.setRegister_timeFrom(v_taskAction.register_timeFrom);
		v_taskAction.register_timeTo=Utilities.setTimeStampFunction(v_taskAction.register_timeDateTo,v_taskAction.register_timeHourTo,v_taskAction.register_timeMinuteTo);
		v_taskBean.setRegister_timeTo(v_taskAction.register_timeTo);
		v_taskAction.update_timeFrom=Utilities.setTimeStampFunction(v_taskAction.update_timeDateFrom,v_taskAction.update_timeHourFrom,v_taskAction.update_timeMinuteFrom);
		v_taskBean.setUpdate_timeFrom(v_taskAction.update_timeFrom);
		v_taskAction.update_timeTo=Utilities.setTimeStampFunction(v_taskAction.update_timeDateTo,v_taskAction.update_timeHourTo,v_taskAction.update_timeMinuteTo);
		v_taskBean.setUpdate_timeTo(v_taskAction.update_timeTo);
		v_taskBean.setServer_priceFrom(v_taskAction.server_priceFrom);
		v_taskBean.setServer_priceTo(v_taskAction.server_priceTo);
		v_taskBean.setTotal_priceFrom(v_taskAction.total_priceFrom);
		v_taskBean.setTotal_priceTo(v_taskAction.total_priceTo);

		return v_taskBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param V_taskAction action句柄
	 */
	public String readControlsWrite2Datas(V_taskAction v_taskAction){
		String errorMsg="";
				V_taskBean v_taskBean=V_taskUtility.getIocHandel().getBean("V_taskBean",V_taskBean.class);
		if(v_taskAction.action.equals("create")) v_taskBean.setId(Utilities.getRandomPK(true));
		else v_taskBean.setId(v_taskAction.id);
		v_taskBean=setV_taskBeanCommonAttributes(v_taskBean,v_taskAction);
		v_taskBean.setTip(v_taskAction.tip);
		v_taskBean.setEpson(v_taskAction.epson);
		v_taskBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		v_taskBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
		v_taskBean.setServer_price(v_taskAction.server_price);
		v_taskBean.setTotal_price(v_taskAction.total_price);

		
		
		
		
		
		
		
		
		
		v_taskAction.batisDao=V_taskUtility.getIocHandel().getBean("V_taskBatisDao",V_taskBatisDao.class);
		if(v_taskAction.action.equals("create")) errorMsg=Integer.toString(v_taskAction.batisDao.insert(v_taskBean));
		else errorMsg=Integer.toString(v_taskAction.batisDao.updateByKey(v_taskBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param V_taskAction action句柄
	 */
	public void readDatasWrite2Controls(V_taskAction v_taskAction){
		
		
		
		
		
		
		v_taskAction.batisDao=V_taskUtility.getIocHandel().getBean("V_taskBatisDao",V_taskBatisDao.class);
		V_taskBean v_taskBean=v_taskAction.batisDao.findByKey(v_taskAction.id);
		
		
		
		write2ControlsCommon(v_taskAction,v_taskBean);
				if(v_taskBean.getTip()!=null)
			if(v_taskBean.getTip().doubleValue()!=0) v_taskAction.setTip(v_taskBean.getTip());
		if(v_taskBean.getEpson()!=null)
			if(v_taskBean.getEpson().doubleValue()!=0) v_taskAction.setEpson(v_taskBean.getEpson());
		//auto timestamp
		if(v_taskAction.action.equals("detail")) v_taskAction.setRegister_time(v_taskBean.getRegister_time());//auto timestamp只作detail显示
		//auto timestamp
		if(v_taskAction.action.equals("detail")) v_taskAction.setUpdate_time(v_taskBean.getUpdate_time());//auto timestamp只作detail显示
		if(v_taskBean.getServer_price()!=null)
			if(v_taskBean.getServer_price().doubleValue()!=0) v_taskAction.setServer_price(v_taskBean.getServer_price());
		if(v_taskBean.getTotal_price()!=null)
			if(v_taskBean.getTotal_price().doubleValue()!=0) v_taskAction.setTotal_price(v_taskBean.getTotal_price());

	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param V_taskAction action句柄
	 * @param V_taskBean action句柄
	 */
	public void readConditionsWrite2Controls(V_taskAction v_taskAction,V_taskBean v_taskBean){
		write2ControlsCommon(v_taskAction,v_taskBean);
				if(v_taskBean.getTipFrom()!=null)
			if(v_taskBean.getTipFrom().doubleValue()!=0) v_taskAction.setTipFrom(v_taskBean.getTipFrom());
		if(v_taskBean.getTipTo()!=null)
			if(v_taskBean.getTipTo().doubleValue()!=0) v_taskAction.setTipTo(v_taskBean.getTipTo());
		if(v_taskBean.getEpsonFrom()!=null)
			if(v_taskBean.getEpsonFrom().doubleValue()!=0) v_taskAction.setEpsonFrom(v_taskBean.getEpsonFrom());
		if(v_taskBean.getEpsonTo()!=null)
			if(v_taskBean.getEpsonTo().doubleValue()!=0) v_taskAction.setEpsonTo(v_taskBean.getEpsonTo());
		if(v_taskBean.getRegister_timeFrom()!=null){
			v_taskAction.setRegister_timeFrom(v_taskBean.getRegister_timeFrom());
			v_taskAction.setRegister_timeDateFrom(Utilities.csi.getSqlDate(v_taskBean.getRegister_timeFrom()));
			cale.setTimeInMillis(v_taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_taskAction.setRegister_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_taskAction.setRegister_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_taskAction.setRegister_timeHourSelectFrom(v_taskAction.register_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_taskAction.setRegister_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_taskAction.setRegister_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_taskAction.setRegister_timeMinuteSelectFrom(v_taskAction.register_timeMinuteFrom);
		}
		if(v_taskBean.getRegister_timeTo()!=null){
			v_taskAction.setRegister_timeTo(v_taskBean.getRegister_timeTo());
			v_taskAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(v_taskBean.getRegister_timeTo()));
			cale.setTimeInMillis(v_taskBean.getRegister_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_taskAction.setRegister_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_taskAction.setRegister_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_taskAction.setRegister_timeHourSelectTo(v_taskAction.register_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_taskAction.setRegister_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_taskAction.setRegister_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_taskAction.setRegister_timeMinuteSelectTo(v_taskAction.register_timeMinuteTo);
		}
		if(v_taskBean.getUpdate_timeFrom()!=null){
			v_taskAction.setUpdate_timeFrom(v_taskBean.getUpdate_timeFrom());
			v_taskAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(v_taskBean.getUpdate_timeFrom()));
			cale.setTimeInMillis(v_taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_taskAction.setUpdate_timeHourFrom("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_taskAction.setUpdate_timeHourFrom(Integer.toString(cale.get(Calendar.HOUR)));
			v_taskAction.setUpdate_timeHourSelectFrom(v_taskAction.update_timeHourFrom);
			if(cale.get(Calendar.MINUTE)<10) v_taskAction.setUpdate_timeMinuteFrom("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_taskAction.setUpdate_timeMinuteFrom(Integer.toString(cale.get(Calendar.MINUTE)));
			v_taskAction.setUpdate_timeMinuteSelectFrom(v_taskAction.update_timeMinuteFrom);
		}
		if(v_taskBean.getUpdate_timeTo()!=null){
			v_taskAction.setUpdate_timeTo(v_taskBean.getUpdate_timeTo());
			v_taskAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(v_taskBean.getUpdate_timeTo()));
			cale.setTimeInMillis(v_taskBean.getUpdate_timeFrom().getTime());
			if(cale.get(Calendar.HOUR)<10) v_taskAction.setUpdate_timeHourTo("0" + Integer.toString(cale.get(Calendar.HOUR)));
			else v_taskAction.setUpdate_timeHourTo(Integer.toString(cale.get(Calendar.HOUR)));
			v_taskAction.setUpdate_timeHourSelectTo(v_taskAction.update_timeHourTo);
			if(cale.get(Calendar.MINUTE)<10) v_taskAction.setUpdate_timeMinuteTo("0" + Integer.toString(cale.get(Calendar.MINUTE)));
			else v_taskAction.setUpdate_timeMinuteTo(Integer.toString(cale.get(Calendar.MINUTE)));
			v_taskAction.setUpdate_timeMinuteSelectTo(v_taskAction.update_timeMinuteTo);
		}
		if(v_taskBean.getServer_priceFrom()!=null)
			if(v_taskBean.getServer_priceFrom().doubleValue()!=0) v_taskAction.setServer_priceFrom(v_taskBean.getServer_priceFrom());
		if(v_taskBean.getServer_priceTo()!=null)
			if(v_taskBean.getServer_priceTo().doubleValue()!=0) v_taskAction.setServer_priceTo(v_taskBean.getServer_priceTo());
		if(v_taskBean.getTotal_priceFrom()!=null)
			if(v_taskBean.getTotal_priceFrom().doubleValue()!=0) v_taskAction.setTotal_priceFrom(v_taskBean.getTotal_priceFrom());
		if(v_taskBean.getTotal_priceTo()!=null)
			if(v_taskBean.getTotal_priceTo().doubleValue()!=0) v_taskAction.setTotal_priceTo(v_taskBean.getTotal_priceTo());

	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param V_taskAction action句柄
	 * @param V_taskBean action句柄
	 * @param type 控件类型
	 */
	public V_taskBean wrapperV_taskBean(V_taskAction v_taskAction,V_taskBean v_taskBean,String type){
		
		return v_taskBean;
	}
	
	/**
	 * 记录显示包装
	 * @param V_taskAction action句柄
	 * @param type 控件类型
	 */
    public List<V_taskBean> wrapperRecorders(V_taskAction v_taskAction,String type){
    	V_taskBean v_task=null;
    	List<V_taskBean> newV_taskList=V_taskUtility.getIocHandel().getBean("List_V_taskBean",java.util.ArrayList.class);
    	for(int i=0;i<v_taskAction.v_taskList.size();i++){
    		v_task=v_taskAction.v_taskList.get(i);
    		v_task=wrapperV_taskBean(v_taskAction,v_task,type);
    		newV_taskList.add(v_task);
    	}
    	return newV_taskList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param V_taskAction action句柄
	 * @param V_taskBean action句柄
	 */
	private void write2ControlsCommon(V_taskAction v_taskAction,V_taskBean v_taskBean){
		v_taskAction.setId(v_taskBean.getId());
				//textfield
		if(v_taskBean.getTaskid()!=null)
			if(v_taskBean.getTaskid().trim().length()>0) v_taskAction.setTaskid(v_taskBean.getTaskid());
		//textfield
		if(v_taskBean.getUserkey()!=null)
			if(v_taskBean.getUserkey().trim().length()>0) v_taskAction.setUserkey(v_taskBean.getUserkey());
		//textfield
		if(v_taskBean.getServerkey()!=null)
			if(v_taskBean.getServerkey().trim().length()>0) v_taskAction.setServerkey(v_taskBean.getServerkey());
		//textfield
		if(v_taskBean.getPro_description()!=null)
			if(v_taskBean.getPro_description().trim().length()>0) v_taskAction.setPro_description(v_taskBean.getPro_description());
		//textfield
		if(v_taskBean.getPro_image1()!=null)
			if(v_taskBean.getPro_image1().trim().length()>0) v_taskAction.setPro_image1(v_taskBean.getPro_image1());
		//textfield
		if(v_taskBean.getPro_image2()!=null)
			if(v_taskBean.getPro_image2().trim().length()>0) v_taskAction.setPro_image2(v_taskBean.getPro_image2());
		//textfield
		if(v_taskBean.getPro_image3()!=null)
			if(v_taskBean.getPro_image3().trim().length()>0) v_taskAction.setPro_image3(v_taskBean.getPro_image3());
		//textfield
		if(v_taskBean.getPro_image4()!=null)
			if(v_taskBean.getPro_image4().trim().length()>0) v_taskAction.setPro_image4(v_taskBean.getPro_image4());
		//textfield
		if(v_taskBean.getPro_image5()!=null)
			if(v_taskBean.getPro_image5().trim().length()>0) v_taskAction.setPro_image5(v_taskBean.getPro_image5());
		//textfield
		if(v_taskBean.getSolve_image1()!=null)
			if(v_taskBean.getSolve_image1().trim().length()>0) v_taskAction.setSolve_image1(v_taskBean.getSolve_image1());
		//textfield
		if(v_taskBean.getSolve_image2()!=null)
			if(v_taskBean.getSolve_image2().trim().length()>0) v_taskAction.setSolve_image2(v_taskBean.getSolve_image2());
		//textfield
		if(v_taskBean.getSolve_image3()!=null)
			if(v_taskBean.getSolve_image3().trim().length()>0) v_taskAction.setSolve_image3(v_taskBean.getSolve_image3());
		//textfield
		if(v_taskBean.getSeat()!=null)
			if(v_taskBean.getSeat().trim().length()>0) v_taskAction.setSeat(v_taskBean.getSeat());
		//textfield
		if(v_taskBean.getStatus()!=null)
			if(v_taskBean.getStatus().trim().length()>0) v_taskAction.setStatus(v_taskBean.getStatus());
		//textfield
		if(v_taskBean.getInvalid()!=null)
			if(v_taskBean.getInvalid().trim().length()>0) v_taskAction.setInvalid(v_taskBean.getInvalid());
		//textfield
		if(v_taskBean.getName()!=null)
			if(v_taskBean.getName().trim().length()>0) v_taskAction.setName(v_taskBean.getName());
		//textfield
		if(v_taskBean.getUser_id()!=null)
			if(v_taskBean.getUser_id().trim().length()>0) v_taskAction.setUser_id(v_taskBean.getUser_id());
		//textfield
		if(v_taskBean.getIcon()!=null)
			if(v_taskBean.getIcon().trim().length()>0) v_taskAction.setIcon(v_taskBean.getIcon());
		//textfield
		if(v_taskBean.getServer_name()!=null)
			if(v_taskBean.getServer_name().trim().length()>0) v_taskAction.setServer_name(v_taskBean.getServer_name());

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param V_taskBean action句柄
	 * @param V_taskAction action句柄
	 */
	private V_taskBean setV_taskBeanCommonAttributes(V_taskBean v_taskBean,V_taskAction v_taskAction){
				v_taskBean.setTaskid(v_taskAction.taskid);
		v_taskBean.setUserkey(v_taskAction.userkey);
		v_taskBean.setServerkey(v_taskAction.serverkey);
		v_taskBean.setPro_description(v_taskAction.pro_description);
		v_taskBean.setPro_image1(v_taskAction.pro_image1);
		v_taskBean.setPro_image2(v_taskAction.pro_image2);
		v_taskBean.setPro_image3(v_taskAction.pro_image3);
		v_taskBean.setPro_image4(v_taskAction.pro_image4);
		v_taskBean.setPro_image5(v_taskAction.pro_image5);
		v_taskBean.setSolve_image1(v_taskAction.solve_image1);
		v_taskBean.setSolve_image2(v_taskAction.solve_image2);
		v_taskBean.setSolve_image3(v_taskAction.solve_image3);
		v_taskBean.setSeat(v_taskAction.seat);
		v_taskBean.setStatus(v_taskAction.status);
		v_taskBean.setInvalid(v_taskAction.invalid);
		v_taskBean.setName(v_taskAction.name);
		v_taskBean.setUser_id(v_taskAction.user_id);
		v_taskBean.setIcon(v_taskAction.icon);
		v_taskBean.setServer_name(v_taskAction.server_name);

		return v_taskBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param v_taskQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(V_taskBean queryConditionsBean){
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
		if(queryConditionsBean.getStatus().trim().length()>0)
			paramStr.append("&status=").append(queryConditionsBean.getStatus().trim());
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
		if(queryConditionsBean.getName().trim().length()>0)
			paramStr.append("&name=").append(queryConditionsBean.getName().trim());
		if(queryConditionsBean.getUser_id().trim().length()>0)
			paramStr.append("&user_id=").append(queryConditionsBean.getUser_id().trim());
		if(queryConditionsBean.getIcon().trim().length()>0)
			paramStr.append("&icon=").append(queryConditionsBean.getIcon().trim());
		if(queryConditionsBean.getServer_name().trim().length()>0)
			paramStr.append("&server_name=").append(queryConditionsBean.getServer_name().trim());
		if(queryConditionsBean.getServer_priceFrom()!=null)
				paramStr.append("&server_priceFrom=").append(queryConditionsBean.getServer_priceFrom());
		if(queryConditionsBean.getServer_priceTo()!=null)
				paramStr.append("&server_priceTo=").append(queryConditionsBean.getServer_priceTo());
		if(queryConditionsBean.getTotal_priceFrom()!=null)
				paramStr.append("&total_priceFrom=").append(queryConditionsBean.getTotal_priceFrom());
		if(queryConditionsBean.getTotal_priceTo()!=null)
				paramStr.append("&total_priceTo=").append(queryConditionsBean.getTotal_priceTo());

		return paramStr.toString();
	}
}