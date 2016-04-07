package edu.jt.exg.logic.mgr_user;

import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.Mgr_userAction;

//页面控件初始化设置
public class InitPageControl implements Serializable {

	private static final long serialVersionUID = 19761210;

	public InitPageControl() {
		super();
	}

	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr() {
		String tmp = "Usertype|Userid|Name|Nickname|Icon|Id_number|Email|Gender|Address_province|Address_city|Address_area|Address_details|Signature|Hometown|Occupation|Interest|Bankname|Bank_branch|Bank_provinces_cities|Card_number|Balance|Point|Recommender_code|Login_password|Gesture_password|Trading_password|Yubei1|Yubei2|Yubei3|Invalid|Register_time|Update_time";
		return tmp;
	}

	public static void initUsertypeMap(Mgr_userAction mgr_userAction) {
		if (mgr_userAction.usertypeMap == null)
			mgr_userAction.usertypeMap = Utilities.csi
					.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(mgr_userAction.usertypeMap, "1001");// 管理员类型：1001
		mgr_userAction.setUsertypeMap(mgr_userAction.usertypeMap);
	}

	 public static void initInvalidMap(Mgr_userAction mgr_userAction){
	 if(mgr_userAction.invalidMap==null)
	 mgr_userAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
	 CommonMethod.getSelectMap(mgr_userAction.invalidMap, "1004");//有效无效区分：1004
	 mgr_userAction.setInvalidMap(mgr_userAction.invalidMap);
	 }

	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Mgr_userAction mgr_userAction) {
		if (mgr_userAction.action.equals("initmultiquery")
				|| mgr_userAction.action.equals("multiquery")
				|| mgr_userAction.action.equals("initsinglequery")
				|| mgr_userAction.action.equals("singlequery")
				|| mgr_userAction.action.equals("initquery")
				|| mgr_userAction.action.equals("query")
				|| mgr_userAction.action.equals("${action}")) {

			// auto timestamp init for query
			mgr_userAction
					.setRegister_timeHourMapFrom(mgr_userAction.register_timeHourMapFrom);
			mgr_userAction
					.setRegister_timeMinuteMapFrom(mgr_userAction.register_timeMinuteMapFrom);
			mgr_userAction
					.setRegister_timeHourMapTo(mgr_userAction.register_timeHourMapTo);
			mgr_userAction
					.setRegister_timeMinuteMapTo(mgr_userAction.register_timeMinuteMapTo);
			// auto timestamp init for query
			mgr_userAction
					.setUpdate_timeHourMapFrom(mgr_userAction.update_timeHourMapFrom);
			mgr_userAction
					.setUpdate_timeMinuteMapFrom(mgr_userAction.update_timeMinuteMapFrom);
			mgr_userAction
					.setUpdate_timeHourMapTo(mgr_userAction.update_timeHourMapTo);
			mgr_userAction
					.setUpdate_timeMinuteMapTo(mgr_userAction.update_timeMinuteMapTo);

		} else {

		}
	}

	/**
	 * s:checkboxlist初始化
	 */

	/**
	 * s:radio初始化
	 */

}