package edu.jt.exg.logic.advertisements;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.AdvertisementsAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Name|Targetkey|Top_pic1|Url|Category|Display|Invalid|Register_time|Update_time";
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
//	public static void initCategoryMap(AdvertisementsAction advertisementsAction){
//		if(advertisementsAction.categoryMap==null) advertisementsAction.categoryMap=Utilities.csi.getLinkedHashMap_String_String();
//		CommonMethod.getSelectMap(advertisementsAction.categoryMap, "1010");//广告 区分：1010
//		advertisementsAction.setCategoryMap(advertisementsAction.categoryMap);
//	}

public static void initInvalidMap(AdvertisementsAction advertisementsAction){
	if(advertisementsAction.invalidMap==null) advertisementsAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
	CommonMethod.getSelectMap(advertisementsAction.invalidMap, "1004");//有效无效 区分：1004
	advertisementsAction.setInvalidMap(advertisementsAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(AdvertisementsAction advertisementsAction){
		if(advertisementsAction.action.equals("initmultiquery") || advertisementsAction.action.equals("multiquery") ||
				advertisementsAction.action.equals("initsinglequery") || advertisementsAction.action.equals("singlequery") ||
				advertisementsAction.action.equals("initquery") || advertisementsAction.action.equals("query") || 
				advertisementsAction.action.equals("${action}")){

				//auto timestamp init for query
				advertisementsAction.setRegister_timeHourMapFrom(advertisementsAction.register_timeHourMapFrom);
				advertisementsAction.setRegister_timeMinuteMapFrom(advertisementsAction.register_timeMinuteMapFrom);
				advertisementsAction.setRegister_timeHourMapTo(advertisementsAction.register_timeHourMapTo);
				advertisementsAction.setRegister_timeMinuteMapTo(advertisementsAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				advertisementsAction.setUpdate_timeHourMapFrom(advertisementsAction.update_timeHourMapFrom);
				advertisementsAction.setUpdate_timeMinuteMapFrom(advertisementsAction.update_timeMinuteMapFrom);
				advertisementsAction.setUpdate_timeHourMapTo(advertisementsAction.update_timeHourMapTo);
				advertisementsAction.setUpdate_timeMinuteMapTo(advertisementsAction.update_timeMinuteMapTo);

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