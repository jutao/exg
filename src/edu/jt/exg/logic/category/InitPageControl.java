package edu.jt.exg.logic.category;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.CategoryAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Code|Name|Display|Invalid|Register_time|Update_time";
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
	public static void initInvalidMap(CategoryAction categoryAction){
		if(categoryAction.invalidMap==null) categoryAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(categoryAction.invalidMap, "1012");//有效无效 区分：1012
		categoryAction.setInvalidMap(categoryAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(CategoryAction categoryAction){
		if(categoryAction.action.equals("initmultiquery") || categoryAction.action.equals("multiquery") ||
				categoryAction.action.equals("initsinglequery") || categoryAction.action.equals("singlequery") ||
				categoryAction.action.equals("initquery") || categoryAction.action.equals("query") || 
				categoryAction.action.equals("${action}")){

				//auto timestamp init for query
				categoryAction.setRegister_timeHourMapFrom(categoryAction.register_timeHourMapFrom);
				categoryAction.setRegister_timeMinuteMapFrom(categoryAction.register_timeMinuteMapFrom);
				categoryAction.setRegister_timeHourMapTo(categoryAction.register_timeHourMapTo);
				categoryAction.setRegister_timeMinuteMapTo(categoryAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				categoryAction.setUpdate_timeHourMapFrom(categoryAction.update_timeHourMapFrom);
				categoryAction.setUpdate_timeMinuteMapFrom(categoryAction.update_timeMinuteMapFrom);
				categoryAction.setUpdate_timeHourMapTo(categoryAction.update_timeHourMapTo);
				categoryAction.setUpdate_timeMinuteMapTo(categoryAction.update_timeMinuteMapTo);

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