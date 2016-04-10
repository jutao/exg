package edu.jt.exg.logic.v_comment;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.V_commentAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Userkey|Targetkey|Detail|Pic1|Pic2|Pic3|Category|Display|Invalid|Register_time|Update_time|User_key|Neckname|Icon|User_id|Target_id|Target_name";
		return tmp;
	}

	/**
	 * s:select初始化,value和text显示项必须相同
	 */
	public static void initCategoryMap(V_commentAction v_commentAction){
		if(v_commentAction.categoryMap==null) v_commentAction.categoryMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(v_commentAction.categoryMap, "1008");//评价区分 区分：1008
		v_commentAction.setCategoryMap(v_commentAction.categoryMap);
	}

	public static void initInvalidMap(V_commentAction v_commentAction){
		if(v_commentAction.invalidMap==null) v_commentAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(v_commentAction.invalidMap, "1004");//有效无效 区分：1004
		v_commentAction.setInvalidMap(v_commentAction.invalidMap);
		}	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(V_commentAction v_commentAction){
		if(v_commentAction.action.equals("initmultiquery") || v_commentAction.action.equals("multiquery") ||
				v_commentAction.action.equals("initsinglequery") || v_commentAction.action.equals("singlequery") ||
				v_commentAction.action.equals("initquery") || v_commentAction.action.equals("query") || 
				v_commentAction.action.equals("${action}")){

				//auto timestamp init for query
				v_commentAction.setRegister_timeHourMapFrom(v_commentAction.register_timeHourMapFrom);
				v_commentAction.setRegister_timeMinuteMapFrom(v_commentAction.register_timeMinuteMapFrom);
				v_commentAction.setRegister_timeHourMapTo(v_commentAction.register_timeHourMapTo);
				v_commentAction.setRegister_timeMinuteMapTo(v_commentAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				v_commentAction.setUpdate_timeHourMapFrom(v_commentAction.update_timeHourMapFrom);
				v_commentAction.setUpdate_timeMinuteMapFrom(v_commentAction.update_timeMinuteMapFrom);
				v_commentAction.setUpdate_timeHourMapTo(v_commentAction.update_timeHourMapTo);
				v_commentAction.setUpdate_timeMinuteMapTo(v_commentAction.update_timeMinuteMapTo);

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