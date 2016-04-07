package edu.jt.exg.logic.order_master;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.Order_masterAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Orderid|Repair_userkey|Outcome|Outcome_image1|Outcome_image2|Outcome_image3|Status|Invalid|Register_time|Update_time";
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
	public static void initStatusMap(Order_masterAction order_masterAction){
		if(order_masterAction.statusMap==null) order_masterAction.statusMap=Utilities.csi.getLinkedHashMap_String_String();
		order_masterAction.statusMap.put("","");
		order_masterAction.statusMap.put("1","value1");
		order_masterAction.statusMap.put("2","value2");
		order_masterAction.statusMap.put("3","value3");
		order_masterAction.setStatusMap(order_masterAction.statusMap);
	}

public static void initInvalidMap(Order_masterAction order_masterAction){
		if(order_masterAction.invalidMap==null) order_masterAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		order_masterAction.invalidMap.put("","");
		order_masterAction.invalidMap.put("1","value1");
		order_masterAction.invalidMap.put("2","value2");
		order_masterAction.invalidMap.put("3","value3");
		order_masterAction.setInvalidMap(order_masterAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Order_masterAction order_masterAction){
		if(order_masterAction.action.equals("initmultiquery") || order_masterAction.action.equals("multiquery") ||
				order_masterAction.action.equals("initsinglequery") || order_masterAction.action.equals("singlequery") ||
				order_masterAction.action.equals("initquery") || order_masterAction.action.equals("query") || 
				order_masterAction.action.equals("${action}")){

				//auto timestamp init for query
				order_masterAction.setRegister_timeHourMapFrom(order_masterAction.register_timeHourMapFrom);
				order_masterAction.setRegister_timeMinuteMapFrom(order_masterAction.register_timeMinuteMapFrom);
				order_masterAction.setRegister_timeHourMapTo(order_masterAction.register_timeHourMapTo);
				order_masterAction.setRegister_timeMinuteMapTo(order_masterAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				order_masterAction.setUpdate_timeHourMapFrom(order_masterAction.update_timeHourMapFrom);
				order_masterAction.setUpdate_timeMinuteMapFrom(order_masterAction.update_timeMinuteMapFrom);
				order_masterAction.setUpdate_timeHourMapTo(order_masterAction.update_timeHourMapTo);
				order_masterAction.setUpdate_timeMinuteMapTo(order_masterAction.update_timeMinuteMapTo);

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