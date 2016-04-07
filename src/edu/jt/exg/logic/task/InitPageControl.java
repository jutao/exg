package edu.jt.exg.logic.task;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.TaskAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Taskid|Userkey|Serverkey|Tip|Epson|Pro_description|Pro_image1|Pro_image2|Pro_image3|Pro_image4|Pro_image5|Solve_image1|Solve_image2|Solve_image3|Seat|Status|Invalid|Register_time|Update_time";
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
	public static void initStatusMap(TaskAction taskAction){
		if(taskAction.statusMap==null) taskAction.statusMap=Utilities.csi.getLinkedHashMap_String_String();
		taskAction.statusMap.put("","");
		taskAction.statusMap.put("1","value1");
		taskAction.statusMap.put("2","value2");
		taskAction.statusMap.put("3","value3");
		taskAction.setStatusMap(taskAction.statusMap);
	}

public static void initInvalidMap(TaskAction taskAction){
		if(taskAction.invalidMap==null) taskAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		taskAction.invalidMap.put("","");
		taskAction.invalidMap.put("1","value1");
		taskAction.invalidMap.put("2","value2");
		taskAction.invalidMap.put("3","value3");
		taskAction.setInvalidMap(taskAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(TaskAction taskAction){
		if(taskAction.action.equals("initmultiquery") || taskAction.action.equals("multiquery") ||
				taskAction.action.equals("initsinglequery") || taskAction.action.equals("singlequery") ||
				taskAction.action.equals("initquery") || taskAction.action.equals("query") || 
				taskAction.action.equals("${action}")){

				//auto timestamp init for query
				taskAction.setRegister_timeHourMapFrom(taskAction.register_timeHourMapFrom);
				taskAction.setRegister_timeMinuteMapFrom(taskAction.register_timeMinuteMapFrom);
				taskAction.setRegister_timeHourMapTo(taskAction.register_timeHourMapTo);
				taskAction.setRegister_timeMinuteMapTo(taskAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				taskAction.setUpdate_timeHourMapFrom(taskAction.update_timeHourMapFrom);
				taskAction.setUpdate_timeMinuteMapFrom(taskAction.update_timeMinuteMapFrom);
				taskAction.setUpdate_timeHourMapTo(taskAction.update_timeHourMapTo);
				taskAction.setUpdate_timeMinuteMapTo(taskAction.update_timeMinuteMapTo);

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