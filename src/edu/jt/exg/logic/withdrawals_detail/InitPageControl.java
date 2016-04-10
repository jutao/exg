package edu.jt.exg.logic.withdrawals_detail;
import java.io.Serializable;
import java.util.List;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.Withdrawals_detailAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Chargeid|Userkey|Amount|Status|Invalid|Register_time|Update_time";
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
	public static void initStatusMap(Withdrawals_detailAction withdrawals_detailAction){
		if(withdrawals_detailAction.statusMap==null) withdrawals_detailAction.statusMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(withdrawals_detailAction.statusMap, "1011");//体现状态：1011
		withdrawals_detailAction.setStatusMap(withdrawals_detailAction.statusMap);
	}

public static void initInvalidMap(Withdrawals_detailAction withdrawals_detailAction){
		if(withdrawals_detailAction.invalidMap==null) withdrawals_detailAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(withdrawals_detailAction.invalidMap, "1004");//有效无效 区分：1004
		withdrawals_detailAction.setInvalidMap(withdrawals_detailAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Withdrawals_detailAction withdrawals_detailAction){
		if(withdrawals_detailAction.action.equals("initmultiquery") || withdrawals_detailAction.action.equals("multiquery") ||
				withdrawals_detailAction.action.equals("initsinglequery") || withdrawals_detailAction.action.equals("singlequery") ||
				withdrawals_detailAction.action.equals("initquery") || withdrawals_detailAction.action.equals("query") || 
				withdrawals_detailAction.action.equals("${action}")){

				//auto timestamp init for query
				withdrawals_detailAction.setRegister_timeHourMapFrom(withdrawals_detailAction.register_timeHourMapFrom);
				withdrawals_detailAction.setRegister_timeMinuteMapFrom(withdrawals_detailAction.register_timeMinuteMapFrom);
				withdrawals_detailAction.setRegister_timeHourMapTo(withdrawals_detailAction.register_timeHourMapTo);
				withdrawals_detailAction.setRegister_timeMinuteMapTo(withdrawals_detailAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				withdrawals_detailAction.setUpdate_timeHourMapFrom(withdrawals_detailAction.update_timeHourMapFrom);
				withdrawals_detailAction.setUpdate_timeMinuteMapFrom(withdrawals_detailAction.update_timeMinuteMapFrom);
				withdrawals_detailAction.setUpdate_timeHourMapTo(withdrawals_detailAction.update_timeHourMapTo);
				withdrawals_detailAction.setUpdate_timeMinuteMapTo(withdrawals_detailAction.update_timeMinuteMapTo);

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