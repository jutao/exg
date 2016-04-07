package edu.jt.exg.logic.v_address;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import utility.ConstSetup;
import utility.Utilities;
import core.ListKeyBean;
import edu.jt.exg.action.V_addressAction;

public class PageStatus implements Serializable{
	
	private static final long serialVersionUID = 19761210;
	private Calendar cale=Calendar.getInstance();
	
	public PageStatus(){super();}
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_addressAction action句柄
	 * @param params 设置参数
	 */
    public void setRecordsRangeAndOrderByRules(V_addressAction v_addressAction,String params){
    	//获取记录范围*************************************************
    	String[] array=params.split("&");
    	String tmp="";
    	int pos=0;
    	for(int i=0;i<array.length;i++){
    		tmp=array[i];
    		if(array[i].indexOf("start=")!=-1){
    			pos=tmp.indexOf("start=");
    			v_addressAction.start=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("range=")!=-1){
    			pos=tmp.indexOf("range=");
    			v_addressAction.range=tmp.substring(pos+6,tmp.length());
    		}else if(array[i].indexOf("action=")!=-1){
    			pos=tmp.indexOf("action=");
    			v_addressAction.action=tmp.substring(pos+7,tmp.length());
    		}
    	}
        if(v_addressAction.start==null) v_addressAction.start="0";
        else if(v_addressAction.start.length()==0) v_addressAction.start="0";
        if(v_addressAction.range==null) v_addressAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_addressAction.range.length()==0) v_addressAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_addressAction);
    }
	
	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * @param V_addressAction action句柄
	 */
    public void setRecordsRangeAndOrderByRules(V_addressAction v_addressAction){
    	//获取记录范围*************************************************
    	v_addressAction.action=v_addressAction.request.getParameter("action");
        if(v_addressAction.start==null) v_addressAction.start="0";
        else if(v_addressAction.start.length()==0) v_addressAction.start="0";
        if(v_addressAction.range==null) v_addressAction.range=ConstSetup.REFERENCE_RANGE;
        else if(v_addressAction.range.length()==0) v_addressAction.range=ConstSetup.REFERENCE_RANGE;
        setOrderByMap(v_addressAction);
    }
    
    /**
	 * 设置排序
	 * @param V_addressAction action句柄
	 */
    private void setOrderByMap(V_addressAction v_addressAction){
        v_addressAction.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
    	//orderByMap.put(V_addressSqlStorehouse.UPDATEDATE_DESC,null);
    }
	
	/**
	 * 控件初始化
	 * @param V_addressAction action句柄
	 */
	public void setControlsValues(V_addressAction v_addressAction){
		
	}
	
	/**
	 * 从翻页的参数中得到查询查询条件
	 * @param V_addressAction action句柄
	 * @param params 设置参数
	 */
	public V_addressBean getQueryConditionsFromParams(V_addressAction v_addressAction,String params){
		V_addressBean v_addressBean=V_addressUtility.getIocHandel().getBean("V_addressBean",V_addressBean.class);
		String[] array=params.split("&");
		String tmp="";
		int pos=0;
		for(int i=0;i<array.length;i++){
			tmp=array[i];
			if(tmp.equals("start=") || tmp.equals("range=") || tmp.equals("action=")) continue;
					if(array[i].indexOf("province_name=")==0){
			pos=tmp.indexOf("province_name=");
			v_addressBean.setProvince_name(tmp.substring(pos+14,tmp.length()));
		}
		if(array[i].indexOf("city_code=")==0){
			pos=tmp.indexOf("city_code=");
			v_addressBean.setCity_code(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("city_name=")==0){
			pos=tmp.indexOf("city_name=");
			v_addressBean.setCity_name(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("area_code=")==0){
			pos=tmp.indexOf("area_code=");
			v_addressBean.setArea_code(tmp.substring(pos+10,tmp.length()));
		}
		if(array[i].indexOf("area_name=")==0){
			pos=tmp.indexOf("area_name=");
			v_addressBean.setArea_name(tmp.substring(pos+10,tmp.length()));
		}

		}
		return v_addressBean;
	}
	
	/**
	 * 得到form的查询条件
	 * @param V_addressAction action句柄
	 */
	public V_addressBean getQueryConditionsFromForm(V_addressAction v_addressAction){
		V_addressBean v_addressBean=V_addressUtility.getIocHandel().getBean("V_addressBean",V_addressBean.class);
		v_addressBean=setV_addressBeanCommonAttributes(v_addressBean,v_addressAction);
		
		return v_addressBean;
	}
	
	/**
	 * 读取控件值写入数据库
	 * @param V_addressAction action句柄
	 */
	public String readControlsWrite2Datas(V_addressAction v_addressAction){
		String errorMsg="";
				V_addressBean v_addressBean=V_addressUtility.getIocHandel().getBean("V_addressBean",V_addressBean.class);
		if(v_addressAction.action.equals("create")) v_addressBean.setProvince_code(Utilities.getRandomPK(true));
		else v_addressBean.setProvince_code(v_addressAction.province_code);
		v_addressBean=setV_addressBeanCommonAttributes(v_addressBean,v_addressAction);

		
		
		
		
		
		
		
		
		
		v_addressAction.batisDao=V_addressUtility.getIocHandel().getBean("V_addressBatisDao",V_addressBatisDao.class);
		if(v_addressAction.action.equals("create")) errorMsg=Integer.toString(v_addressAction.batisDao.insert(v_addressBean));
		else errorMsg=Integer.toString(v_addressAction.batisDao.updateByKey(v_addressBean));
		
		
		
		
		
		return errorMsg;
	}	
	
	/**
	 * 读取值写入控件
	 * @param V_addressAction action句柄
	 */
	public void readDatasWrite2Controls(V_addressAction v_addressAction){
		
		
		
		
		
		
		v_addressAction.batisDao=V_addressUtility.getIocHandel().getBean("V_addressBatisDao",V_addressBatisDao.class);
		V_addressBean v_addressBean=v_addressAction.batisDao.findByKey(v_addressAction.province_code);
		
		
		
		write2ControlsCommon(v_addressAction,v_addressBean);
		
	}
	
	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * @param V_addressAction action句柄
	 * @param V_addressBean action句柄
	 */
	public void readConditionsWrite2Controls(V_addressAction v_addressAction,V_addressBean v_addressBean){
		write2ControlsCommon(v_addressAction,v_addressBean);
		
	}
	
	/**
	 * 单条记录list页面显示或导出出列使用
	 * @param V_addressAction action句柄
	 * @param V_addressBean action句柄
	 * @param type 控件类型
	 */
	public V_addressBean wrapperV_addressBean(V_addressAction v_addressAction,V_addressBean v_addressBean,String type){
		
		return v_addressBean;
	}
	
	/**
	 * 记录显示包装
	 * @param V_addressAction action句柄
	 * @param type 控件类型
	 */
    public List<V_addressBean> wrapperRecorders(V_addressAction v_addressAction,String type){
    	V_addressBean v_address=null;
    	List<V_addressBean> newV_addressList=V_addressUtility.getIocHandel().getBean("List_V_addressBean",java.util.ArrayList.class);
    	for(int i=0;i<v_addressAction.v_addressList.size();i++){
    		v_address=v_addressAction.v_addressList.get(i);
    		v_address=wrapperV_addressBean(v_addressAction,v_address,type);
    		newV_addressList.add(v_address);
    	}
    	return newV_addressList;
    }
	
    /**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * @param V_addressAction action句柄
	 * @param V_addressBean action句柄
	 */
	private void write2ControlsCommon(V_addressAction v_addressAction,V_addressBean v_addressBean){
		v_addressAction.setProvince_code(v_addressBean.getProvince_code());
				//textfield
		if(v_addressBean.getProvince_name()!=null)
			if(v_addressBean.getProvince_name().trim().length()>0) v_addressAction.setProvince_name(v_addressBean.getProvince_name());
		//textfield
		if(v_addressBean.getCity_code()!=null)
			if(v_addressBean.getCity_code().trim().length()>0) v_addressAction.setCity_code(v_addressBean.getCity_code());
		//textfield
		if(v_addressBean.getCity_name()!=null)
			if(v_addressBean.getCity_name().trim().length()>0) v_addressAction.setCity_name(v_addressBean.getCity_name());
		//textfield
		if(v_addressBean.getArea_code()!=null)
			if(v_addressBean.getArea_code().trim().length()>0) v_addressAction.setArea_code(v_addressBean.getArea_code());
		//textfield
		if(v_addressBean.getArea_name()!=null)
			if(v_addressBean.getArea_name().trim().length()>0) v_addressAction.setArea_name(v_addressBean.getArea_name());

	}
	
	/**
	 * 非数值、日期、时间、password的字段设置
	 * @param V_addressBean action句柄
	 * @param V_addressAction action句柄
	 */
	private V_addressBean setV_addressBeanCommonAttributes(V_addressBean v_addressBean,V_addressAction v_addressAction){
				v_addressBean.setProvince_name(v_addressAction.province_name);
		v_addressBean.setCity_code(v_addressAction.city_code);
		v_addressBean.setCity_name(v_addressAction.city_name);
		v_addressBean.setArea_code(v_addressAction.area_code);
		v_addressBean.setArea_name(v_addressAction.area_name);

		return v_addressBean;
	}
    
	/**
	 * 保留翻页条件参数,主键不包括
	 * @param v_addressQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(V_addressBean queryConditionsBean){
		StringBuffer paramStr=new StringBuffer("");
				if(queryConditionsBean.getProvince_name().trim().length()>0)
			paramStr.append("&province_name=").append(queryConditionsBean.getProvince_name().trim());
		if(queryConditionsBean.getCity_code().trim().length()>0)
			paramStr.append("&city_code=").append(queryConditionsBean.getCity_code().trim());
		if(queryConditionsBean.getCity_name().trim().length()>0)
			paramStr.append("&city_name=").append(queryConditionsBean.getCity_name().trim());
		if(queryConditionsBean.getArea_code().trim().length()>0)
			paramStr.append("&area_code=").append(queryConditionsBean.getArea_code().trim());
		if(queryConditionsBean.getArea_name().trim().length()>0)
			paramStr.append("&area_name=").append(queryConditionsBean.getArea_name().trim());

		return paramStr.toString();
	}
}