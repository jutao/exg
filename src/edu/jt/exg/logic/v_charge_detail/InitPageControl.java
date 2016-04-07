package edu.jt.exg.logic.v_charge_detail;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.V_charge_detailAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Chargeid|Userkey|Amount|Category|Status|Invalid|Register_time|Update_time|Name|User_id|Icon";
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
	public static void initTimestamp(V_charge_detailAction v_charge_detailAction){
		if(v_charge_detailAction.action.equals("initmultiquery") || v_charge_detailAction.action.equals("multiquery") ||
				v_charge_detailAction.action.equals("initsinglequery") || v_charge_detailAction.action.equals("singlequery") ||
				v_charge_detailAction.action.equals("initquery") || v_charge_detailAction.action.equals("query") || 
				v_charge_detailAction.action.equals("${action}")){

				//auto timestamp init for query
				v_charge_detailAction.setRegister_timeHourMapFrom(v_charge_detailAction.register_timeHourMapFrom);
				v_charge_detailAction.setRegister_timeMinuteMapFrom(v_charge_detailAction.register_timeMinuteMapFrom);
				v_charge_detailAction.setRegister_timeHourMapTo(v_charge_detailAction.register_timeHourMapTo);
				v_charge_detailAction.setRegister_timeMinuteMapTo(v_charge_detailAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				v_charge_detailAction.setUpdate_timeHourMapFrom(v_charge_detailAction.update_timeHourMapFrom);
				v_charge_detailAction.setUpdate_timeMinuteMapFrom(v_charge_detailAction.update_timeMinuteMapFrom);
				v_charge_detailAction.setUpdate_timeHourMapTo(v_charge_detailAction.update_timeHourMapTo);
				v_charge_detailAction.setUpdate_timeMinuteMapTo(v_charge_detailAction.update_timeMinuteMapTo);

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