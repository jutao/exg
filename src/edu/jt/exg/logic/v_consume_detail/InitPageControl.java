package edu.jt.exg.logic.v_consume_detail;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.V_consume_detailAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Detailid|Taskkey|Quantity|Status|Invalid|Register_time|Update_time|User_name|User_id|User_icon";
		return tmp;
	}
	
	/**
	 * s:select初始化,value和text显示项必须相同
	 */
	public static void initInvalidMap(V_consume_detailAction v_consume_detailAction){
		if(v_consume_detailAction.invalidMap==null) v_consume_detailAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(v_consume_detailAction.invalidMap, "1004");//有效无效 区分：1004
		v_consume_detailAction.setInvalidMap(v_consume_detailAction.invalidMap);
	}
	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(V_consume_detailAction v_consume_detailAction){
		if(v_consume_detailAction.action.equals("initmultiquery") || v_consume_detailAction.action.equals("multiquery") ||
				v_consume_detailAction.action.equals("initsinglequery") || v_consume_detailAction.action.equals("singlequery") ||
				v_consume_detailAction.action.equals("initquery") || v_consume_detailAction.action.equals("query") || 
				v_consume_detailAction.action.equals("${action}")){

				//auto timestamp init for query
				v_consume_detailAction.setRegister_timeHourMapFrom(v_consume_detailAction.register_timeHourMapFrom);
				v_consume_detailAction.setRegister_timeMinuteMapFrom(v_consume_detailAction.register_timeMinuteMapFrom);
				v_consume_detailAction.setRegister_timeHourMapTo(v_consume_detailAction.register_timeHourMapTo);
				v_consume_detailAction.setRegister_timeMinuteMapTo(v_consume_detailAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				v_consume_detailAction.setUpdate_timeHourMapFrom(v_consume_detailAction.update_timeHourMapFrom);
				v_consume_detailAction.setUpdate_timeMinuteMapFrom(v_consume_detailAction.update_timeMinuteMapFrom);
				v_consume_detailAction.setUpdate_timeHourMapTo(v_consume_detailAction.update_timeHourMapTo);
				v_consume_detailAction.setUpdate_timeMinuteMapTo(v_consume_detailAction.update_timeMinuteMapTo);

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