package edu.jt.exg.logic.category_master;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.Category_masterAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Parent_code|Code|Name|Display|Invalid|Register_time|Update_time";
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
	public static void initInvalidMap(Category_masterAction category_masterAction){
		if(category_masterAction.invalidMap==null) category_masterAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(category_masterAction.invalidMap, "1004");//有效无效 区分：1004
		category_masterAction.setInvalidMap(category_masterAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Category_masterAction category_masterAction){
		if(category_masterAction.action.equals("initmultiquery") || category_masterAction.action.equals("multiquery") ||
				category_masterAction.action.equals("initsinglequery") || category_masterAction.action.equals("singlequery") ||
				category_masterAction.action.equals("initquery") || category_masterAction.action.equals("query") || 
				category_masterAction.action.equals("${action}")){

				//auto timestamp init for query
				category_masterAction.setRegister_timeHourMapFrom(category_masterAction.register_timeHourMapFrom);
				category_masterAction.setRegister_timeMinuteMapFrom(category_masterAction.register_timeMinuteMapFrom);
				category_masterAction.setRegister_timeHourMapTo(category_masterAction.register_timeHourMapTo);
				category_masterAction.setRegister_timeMinuteMapTo(category_masterAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				category_masterAction.setUpdate_timeHourMapFrom(category_masterAction.update_timeHourMapFrom);
				category_masterAction.setUpdate_timeMinuteMapFrom(category_masterAction.update_timeMinuteMapFrom);
				category_masterAction.setUpdate_timeHourMapTo(category_masterAction.update_timeHourMapTo);
				category_masterAction.setUpdate_timeMinuteMapTo(category_masterAction.update_timeMinuteMapTo);

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