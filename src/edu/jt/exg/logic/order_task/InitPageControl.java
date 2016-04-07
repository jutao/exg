package edu.jt.exg.logic.order_task;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.Order_taskAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Taskkey|Orderkey|Invalid|Register_time|Update_time";
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
	public static void initInvalidMap(Order_taskAction order_taskAction){
		if(order_taskAction.invalidMap==null) order_taskAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		order_taskAction.invalidMap.put("","");
		order_taskAction.invalidMap.put("1","value1");
		order_taskAction.invalidMap.put("2","value2");
		order_taskAction.invalidMap.put("3","value3");
		order_taskAction.setInvalidMap(order_taskAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Order_taskAction order_taskAction){
		if(order_taskAction.action.equals("initmultiquery") || order_taskAction.action.equals("multiquery") ||
				order_taskAction.action.equals("initsinglequery") || order_taskAction.action.equals("singlequery") ||
				order_taskAction.action.equals("initquery") || order_taskAction.action.equals("query") || 
				order_taskAction.action.equals("${action}")){

				//auto timestamp init for query
				order_taskAction.setRegister_timeHourMapFrom(order_taskAction.register_timeHourMapFrom);
				order_taskAction.setRegister_timeMinuteMapFrom(order_taskAction.register_timeMinuteMapFrom);
				order_taskAction.setRegister_timeHourMapTo(order_taskAction.register_timeHourMapTo);
				order_taskAction.setRegister_timeMinuteMapTo(order_taskAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				order_taskAction.setUpdate_timeHourMapFrom(order_taskAction.update_timeHourMapFrom);
				order_taskAction.setUpdate_timeMinuteMapFrom(order_taskAction.update_timeMinuteMapFrom);
				order_taskAction.setUpdate_timeHourMapTo(order_taskAction.update_timeHourMapTo);
				order_taskAction.setUpdate_timeMinuteMapTo(order_taskAction.update_timeMinuteMapTo);

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