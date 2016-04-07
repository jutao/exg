package edu.jt.exg.logic.charge_detail;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.Charge_detailAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Chargeid|Userkey|Amount|Category|Status|Invalid|Register_time|Update_time";
		return tmp;
	}

	/**
	 * 设置s:optiontransferselect集合初始化
	 */
	
	
	/**
	 * s:combobox初始化
	 */
	
	
	/**
	 * s:doubleselect初始化
	 */
	
	
	/**
	 * s:select初始化,value和text显示项必须相同
	 */
	public static void initCategoryMap(Charge_detailAction charge_detailAction){
		if(charge_detailAction.categoryMap==null) charge_detailAction.categoryMap=Utilities.csi.getLinkedHashMap_String_String();
		charge_detailAction.categoryMap.put("","");
		charge_detailAction.categoryMap.put("1","value1");
		charge_detailAction.categoryMap.put("2","value2");
		charge_detailAction.categoryMap.put("3","value3");
		charge_detailAction.setCategoryMap(charge_detailAction.categoryMap);
	}

public static void initStatusMap(Charge_detailAction charge_detailAction){
		if(charge_detailAction.statusMap==null) charge_detailAction.statusMap=Utilities.csi.getLinkedHashMap_String_String();
		charge_detailAction.statusMap.put("","");
		charge_detailAction.statusMap.put("1","value1");
		charge_detailAction.statusMap.put("2","value2");
		charge_detailAction.statusMap.put("3","value3");
		charge_detailAction.setStatusMap(charge_detailAction.statusMap);
	}

public static void initInvalidMap(Charge_detailAction charge_detailAction){
		if(charge_detailAction.invalidMap==null) charge_detailAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		charge_detailAction.invalidMap.put("","");
		charge_detailAction.invalidMap.put("1","value1");
		charge_detailAction.invalidMap.put("2","value2");
		charge_detailAction.invalidMap.put("3","value3");
		charge_detailAction.setInvalidMap(charge_detailAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Charge_detailAction charge_detailAction){
		if(charge_detailAction.action.equals("initmultiquery") || charge_detailAction.action.equals("multiquery") ||
				charge_detailAction.action.equals("initsinglequery") || charge_detailAction.action.equals("singlequery") ||
				charge_detailAction.action.equals("initquery") || charge_detailAction.action.equals("query") || 
				charge_detailAction.action.equals("${action}")){

				//auto timestamp init for query
				charge_detailAction.setRegister_timeHourMapFrom(charge_detailAction.register_timeHourMapFrom);
				charge_detailAction.setRegister_timeMinuteMapFrom(charge_detailAction.register_timeMinuteMapFrom);
				charge_detailAction.setRegister_timeHourMapTo(charge_detailAction.register_timeHourMapTo);
				charge_detailAction.setRegister_timeMinuteMapTo(charge_detailAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				charge_detailAction.setUpdate_timeHourMapFrom(charge_detailAction.update_timeHourMapFrom);
				charge_detailAction.setUpdate_timeMinuteMapFrom(charge_detailAction.update_timeMinuteMapFrom);
				charge_detailAction.setUpdate_timeHourMapTo(charge_detailAction.update_timeHourMapTo);
				charge_detailAction.setUpdate_timeMinuteMapTo(charge_detailAction.update_timeMinuteMapTo);

		}else{

		}
	}

	
	/**
	 * s:checkboxlist初始化
	 */
	
	
	/**
	 * s:radio初始化
	 */
	
}