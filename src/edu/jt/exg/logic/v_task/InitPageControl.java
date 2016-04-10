package edu.jt.exg.logic.v_task;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.V_taskAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Taskid|Userkey|Serverkey|Tip|Epson|Pro_description|Pro_image1|Pro_image2|Pro_image3|Pro_image4|Pro_image5|Solve_image1|Solve_image2|Solve_image3|Seat|Status|Invalid|Register_time|Update_time|Name|User_id|Icon|Server_name|Server_price|Total_price";
		return tmp;
	}

	/**
	 * s:select初始化,value和text显示项必须相同
	 */
	public static void initStatusMap(V_taskAction v_taskAction){
		if(v_taskAction.statusMap==null) v_taskAction.statusMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(v_taskAction.statusMap, "1006");//任务状态 区分：1006
		v_taskAction.setStatusMap(v_taskAction.statusMap);
		}

	public static void initInvalidMap(V_taskAction v_taskAction){
		if(v_taskAction.invalidMap==null) v_taskAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(v_taskAction.invalidMap, "1004");//有效无效 区分：1004
		v_taskAction.setInvalidMap(v_taskAction.invalidMap);
		}
	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(V_taskAction v_taskAction){
		if(v_taskAction.action.equals("initmultiquery") || v_taskAction.action.equals("multiquery") ||
				v_taskAction.action.equals("initsinglequery") || v_taskAction.action.equals("singlequery") ||
				v_taskAction.action.equals("initquery") || v_taskAction.action.equals("query") || 
				v_taskAction.action.equals("${action}")){

				//auto timestamp init for query
				v_taskAction.setRegister_timeHourMapFrom(v_taskAction.register_timeHourMapFrom);
				v_taskAction.setRegister_timeMinuteMapFrom(v_taskAction.register_timeMinuteMapFrom);
				v_taskAction.setRegister_timeHourMapTo(v_taskAction.register_timeHourMapTo);
				v_taskAction.setRegister_timeMinuteMapTo(v_taskAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				v_taskAction.setUpdate_timeHourMapFrom(v_taskAction.update_timeHourMapFrom);
				v_taskAction.setUpdate_timeMinuteMapFrom(v_taskAction.update_timeMinuteMapFrom);
				v_taskAction.setUpdate_timeHourMapTo(v_taskAction.update_timeHourMapTo);
				v_taskAction.setUpdate_timeMinuteMapTo(v_taskAction.update_timeMinuteMapTo);

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