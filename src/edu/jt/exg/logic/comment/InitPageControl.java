package edu.jt.exg.logic.comment;
import java.io.Serializable;
import java.util.List;
import utility.Utilities;
import edu.jt.exg.action.CommentAction;
import core.ListKeyBean;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Userkey|Targetkey|Detail|Pic1|Pic2|Pic3|Category|Display|Invalid|Register_time|Update_time";
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
	public static void initCategoryMap(CommentAction commentAction){
		if(commentAction.categoryMap==null) commentAction.categoryMap=Utilities.csi.getLinkedHashMap_String_String();
		commentAction.categoryMap.put("","");
		commentAction.categoryMap.put("1","value1");
		commentAction.categoryMap.put("2","value2");
		commentAction.categoryMap.put("3","value3");
		commentAction.setCategoryMap(commentAction.categoryMap);
	}

public static void initInvalidMap(CommentAction commentAction){
		if(commentAction.invalidMap==null) commentAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		commentAction.invalidMap.put("","");
		commentAction.invalidMap.put("1","value1");
		commentAction.invalidMap.put("2","value2");
		commentAction.invalidMap.put("3","value3");
		commentAction.setInvalidMap(commentAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(CommentAction commentAction){
		if(commentAction.action.equals("initmultiquery") || commentAction.action.equals("multiquery") ||
				commentAction.action.equals("initsinglequery") || commentAction.action.equals("singlequery") ||
				commentAction.action.equals("initquery") || commentAction.action.equals("query") || 
				commentAction.action.equals("${action}")){

				//auto timestamp init for query
				commentAction.setRegister_timeHourMapFrom(commentAction.register_timeHourMapFrom);
				commentAction.setRegister_timeMinuteMapFrom(commentAction.register_timeMinuteMapFrom);
				commentAction.setRegister_timeHourMapTo(commentAction.register_timeHourMapTo);
				commentAction.setRegister_timeMinuteMapTo(commentAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				commentAction.setUpdate_timeHourMapFrom(commentAction.update_timeHourMapFrom);
				commentAction.setUpdate_timeMinuteMapFrom(commentAction.update_timeMinuteMapFrom);
				commentAction.setUpdate_timeHourMapTo(commentAction.update_timeHourMapTo);
				commentAction.setUpdate_timeMinuteMapTo(commentAction.update_timeMinuteMapTo);

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