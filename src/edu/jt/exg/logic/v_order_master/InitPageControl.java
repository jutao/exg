package edu.jt.exg.logic.v_order_master;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.V_order_masterAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Orderid|Repair_userkey|Outcome|Outcome_image1|Outcome_image2|Outcome_image3|Status|Invalid|Register_time|Update_time|Req_name|Req_id|Req_icon";
		return tmp;
	}

	
	/**
	 * s:select初始化,value和text显示项必须相同
	 */
	public static void initStatusMap(V_order_masterAction v_order_masterAction){
		if(v_order_masterAction.statusMap==null) v_order_masterAction.statusMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(v_order_masterAction.statusMap, "1007");//接单状态状态 区分：1007
		v_order_masterAction.setStatusMap(v_order_masterAction.statusMap);
		}

	public static void initInvalidMap(V_order_masterAction v_order_masterAction){
		if(v_order_masterAction.invalidMap==null) v_order_masterAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(v_order_masterAction.invalidMap, "1004");//有效无效 区分：1004
		v_order_masterAction.setInvalidMap(v_order_masterAction.invalidMap);
		}

	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(V_order_masterAction v_order_masterAction){
		if(v_order_masterAction.action.equals("initmultiquery") || v_order_masterAction.action.equals("multiquery") ||
				v_order_masterAction.action.equals("initsinglequery") || v_order_masterAction.action.equals("singlequery") ||
				v_order_masterAction.action.equals("initquery") || v_order_masterAction.action.equals("query") || 
				v_order_masterAction.action.equals("${action}")){

				//auto timestamp init for query
				v_order_masterAction.setRegister_timeHourMapFrom(v_order_masterAction.register_timeHourMapFrom);
				v_order_masterAction.setRegister_timeMinuteMapFrom(v_order_masterAction.register_timeMinuteMapFrom);
				v_order_masterAction.setRegister_timeHourMapTo(v_order_masterAction.register_timeHourMapTo);
				v_order_masterAction.setRegister_timeMinuteMapTo(v_order_masterAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				v_order_masterAction.setUpdate_timeHourMapFrom(v_order_masterAction.update_timeHourMapFrom);
				v_order_masterAction.setUpdate_timeMinuteMapFrom(v_order_masterAction.update_timeMinuteMapFrom);
				v_order_masterAction.setUpdate_timeHourMapTo(v_order_masterAction.update_timeHourMapTo);
				v_order_masterAction.setUpdate_timeMinuteMapTo(v_order_masterAction.update_timeMinuteMapTo);

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