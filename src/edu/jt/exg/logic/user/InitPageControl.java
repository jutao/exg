package edu.jt.exg.logic.user;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.UserAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Level|Userid|Name|Nickname|Icon|Id_number|Email|Gender|Address_province|Address_city|Address_area|Address_details|Hometown|Occupation|Interest|Bankname|Bank_branch|Card_number|Balance|Point|Recommender_code|Login_password|Gesture_password|Trading_password|Category|Usertype|Qualificat|Yubei1|Yubei2|Yubei3|Invalid|Register_time|Update_time";
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
	public static void initGenderMap(UserAction userAction){
		if(userAction.genderMap==null) userAction.genderMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(userAction.genderMap, "1013");//性别区分：1013
		userAction.setGenderMap(userAction.genderMap);
	}

public static void initAddress_provinceMap(UserAction userAction){
		if(userAction.address_provinceMap==null) userAction.address_provinceMap=Utilities.csi.getLinkedHashMap_String_String();
		userAction.address_provinceMap.put("","");
		userAction.address_provinceMap.put("1","value1");
		userAction.address_provinceMap.put("2","value2");
		userAction.address_provinceMap.put("3","value3");
		userAction.setAddress_provinceMap(userAction.address_provinceMap);
	}

public static void initAddress_cityMap(UserAction userAction){
		if(userAction.address_cityMap==null) userAction.address_cityMap=Utilities.csi.getLinkedHashMap_String_String();
		userAction.address_cityMap.put("","");
		userAction.address_cityMap.put("1","value1");
		userAction.address_cityMap.put("2","value2");
		userAction.address_cityMap.put("3","value3");
		userAction.setAddress_cityMap(userAction.address_cityMap);
	}

public static void initAddress_areaMap(UserAction userAction){
		if(userAction.address_areaMap==null) userAction.address_areaMap=Utilities.csi.getLinkedHashMap_String_String();
		userAction.address_areaMap.put("","");
		userAction.address_areaMap.put("1","value1");
		userAction.address_areaMap.put("2","value2");
		userAction.address_areaMap.put("3","value3");
		userAction.setAddress_areaMap(userAction.address_areaMap);
	}

public static void initBanknameMap(UserAction userAction){
		if(userAction.banknameMap==null) userAction.banknameMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(userAction.banknameMap, "1012");//银行区分：1012
		userAction.setBanknameMap(userAction.banknameMap);
	}

public static void initCategoryMap(UserAction userAction){
		if(userAction.categoryMap==null) userAction.categoryMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(userAction.categoryMap, "1002");//用户区分：1002
		userAction.setCategoryMap(userAction.categoryMap);
	}

public static void initInvalidMap(UserAction userAction){
		if(userAction.invalidMap==null) userAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(userAction.invalidMap, "1004");//有效无效区分：1004
		userAction.setInvalidMap(userAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(UserAction userAction){
		if(userAction.action.equals("initmultiquery") || userAction.action.equals("multiquery") ||
				userAction.action.equals("initsinglequery") || userAction.action.equals("singlequery") ||
				userAction.action.equals("initquery") || userAction.action.equals("query") || 
				userAction.action.equals("${action}")){

				//auto timestamp init for query
				userAction.setRegister_timeHourMapFrom(userAction.register_timeHourMapFrom);
				userAction.setRegister_timeMinuteMapFrom(userAction.register_timeMinuteMapFrom);
				userAction.setRegister_timeHourMapTo(userAction.register_timeHourMapTo);
				userAction.setRegister_timeMinuteMapTo(userAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				userAction.setUpdate_timeHourMapFrom(userAction.update_timeHourMapFrom);
				userAction.setUpdate_timeMinuteMapFrom(userAction.update_timeMinuteMapFrom);
				userAction.setUpdate_timeHourMapTo(userAction.update_timeHourMapTo);
				userAction.setUpdate_timeMinuteMapTo(userAction.update_timeMinuteMapTo);

		}else{

		}
	}

	
	/**
	 * s:checkboxlist初始化
	 */
	public static void initUsertypeMap(UserAction userAction){
		if(userAction.usertypeMap==null) userAction.usertypeMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getCheckMap(userAction.usertypeMap, "1003");//已认证资格：1003
		userAction.setUsertypeMap(userAction.usertypeMap);
		}
	
	/**
	 * s:radio初始化
	 */
	
}