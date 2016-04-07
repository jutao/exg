package edu.jt.exg.logic.v_order_task;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.V_order_taskAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Taskkey|Orderkey|Invalid|Register_time|Update_time|Req_name|Req_id|User_id|User_name";
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
	
	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(V_order_taskAction v_order_taskAction){
		if(v_order_taskAction.action.equals("initmultiquery") || v_order_taskAction.action.equals("multiquery") ||
				v_order_taskAction.action.equals("initsinglequery") || v_order_taskAction.action.equals("singlequery") ||
				v_order_taskAction.action.equals("initquery") || v_order_taskAction.action.equals("query") || 
				v_order_taskAction.action.equals("${action}")){

				//auto timestamp init for query
				v_order_taskAction.setRegister_timeHourMapFrom(v_order_taskAction.register_timeHourMapFrom);
				v_order_taskAction.setRegister_timeMinuteMapFrom(v_order_taskAction.register_timeMinuteMapFrom);
				v_order_taskAction.setRegister_timeHourMapTo(v_order_taskAction.register_timeHourMapTo);
				v_order_taskAction.setRegister_timeMinuteMapTo(v_order_taskAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				v_order_taskAction.setUpdate_timeHourMapFrom(v_order_taskAction.update_timeHourMapFrom);
				v_order_taskAction.setUpdate_timeMinuteMapFrom(v_order_taskAction.update_timeMinuteMapFrom);
				v_order_taskAction.setUpdate_timeHourMapTo(v_order_taskAction.update_timeHourMapTo);
				v_order_taskAction.setUpdate_timeMinuteMapTo(v_order_taskAction.update_timeMinuteMapTo);

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