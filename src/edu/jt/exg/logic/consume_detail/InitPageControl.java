package edu.jt.exg.logic.consume_detail;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.Consume_detailAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Detailid|Taskkey|Quantity|Status|Invalid|Register_time|Update_time";
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
	public static void initStatusMap(Consume_detailAction consume_detailAction){
		if(consume_detailAction.statusMap==null) consume_detailAction.statusMap=Utilities.csi.getLinkedHashMap_String_String();
		consume_detailAction.statusMap.put("","");
		consume_detailAction.statusMap.put("1","value1");
		consume_detailAction.statusMap.put("2","value2");
		consume_detailAction.statusMap.put("3","value3");
		consume_detailAction.setStatusMap(consume_detailAction.statusMap);
	}

public static void initInvalidMap(Consume_detailAction consume_detailAction){
		if(consume_detailAction.invalidMap==null) consume_detailAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		consume_detailAction.invalidMap.put("","");
		consume_detailAction.invalidMap.put("1","value1");
		consume_detailAction.invalidMap.put("2","value2");
		consume_detailAction.invalidMap.put("3","value3");
		consume_detailAction.setInvalidMap(consume_detailAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Consume_detailAction consume_detailAction){
		if(consume_detailAction.action.equals("initmultiquery") || consume_detailAction.action.equals("multiquery") ||
				consume_detailAction.action.equals("initsinglequery") || consume_detailAction.action.equals("singlequery") ||
				consume_detailAction.action.equals("initquery") || consume_detailAction.action.equals("query") || 
				consume_detailAction.action.equals("${action}")){

				//auto timestamp init for query
				consume_detailAction.setRegister_timeHourMapFrom(consume_detailAction.register_timeHourMapFrom);
				consume_detailAction.setRegister_timeMinuteMapFrom(consume_detailAction.register_timeMinuteMapFrom);
				consume_detailAction.setRegister_timeHourMapTo(consume_detailAction.register_timeHourMapTo);
				consume_detailAction.setRegister_timeMinuteMapTo(consume_detailAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				consume_detailAction.setUpdate_timeHourMapFrom(consume_detailAction.update_timeHourMapFrom);
				consume_detailAction.setUpdate_timeMinuteMapFrom(consume_detailAction.update_timeMinuteMapFrom);
				consume_detailAction.setUpdate_timeHourMapTo(consume_detailAction.update_timeHourMapTo);
				consume_detailAction.setUpdate_timeMinuteMapTo(consume_detailAction.update_timeMinuteMapTo);

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