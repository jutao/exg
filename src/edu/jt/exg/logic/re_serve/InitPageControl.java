package edu.jt.exg.logic.re_serve;
import java.io.Serializable;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.Re_serveAction;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Serveid|Name|Price|Varieties|Description|Top_pic1|Pic1|Pic2|Pic3|Pic4|Pic5|Yubei1|Yubei2|Yubei3|Display|Invalid|Register_time|Update_time";
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
	public static void initInvalidMap(Re_serveAction re_serveAction){
		if(re_serveAction.invalidMap==null) re_serveAction.invalidMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getSelectMap(re_serveAction.invalidMap, "1004");//有效无效区分：1004
		re_serveAction.setInvalidMap(re_serveAction.invalidMap);
	}


	
	/**
	 * timestamp初始化
	 */
	public static void initTimestamp(Re_serveAction re_serveAction){
		if(re_serveAction.action.equals("initmultiquery") || re_serveAction.action.equals("multiquery") ||
				re_serveAction.action.equals("initsinglequery") || re_serveAction.action.equals("singlequery") ||
				re_serveAction.action.equals("initquery") || re_serveAction.action.equals("query") || 
				re_serveAction.action.equals("${action}")){

				//auto timestamp init for query
				re_serveAction.setRegister_timeHourMapFrom(re_serveAction.register_timeHourMapFrom);
				re_serveAction.setRegister_timeMinuteMapFrom(re_serveAction.register_timeMinuteMapFrom);
				re_serveAction.setRegister_timeHourMapTo(re_serveAction.register_timeHourMapTo);
				re_serveAction.setRegister_timeMinuteMapTo(re_serveAction.register_timeMinuteMapTo);
				//auto timestamp init for query
				re_serveAction.setUpdate_timeHourMapFrom(re_serveAction.update_timeHourMapFrom);
				re_serveAction.setUpdate_timeMinuteMapFrom(re_serveAction.update_timeMinuteMapFrom);
				re_serveAction.setUpdate_timeHourMapTo(re_serveAction.update_timeHourMapTo);
				re_serveAction.setUpdate_timeMinuteMapTo(re_serveAction.update_timeMinuteMapTo);

		}else{

		}
	}

	
	/**
	 * s:checkboxlist初始化
	 */
	public static void initVarietiesMap(Re_serveAction re_serveAction){
		if(re_serveAction.varietiesMap==null) re_serveAction.varietiesMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getCheckMap(re_serveAction.varietiesMap, "1005");//维修服务类型：1005
		re_serveAction.setVarietiesMap(re_serveAction.varietiesMap);
		}
	
	/**
	 * s:radio初始化
	 */
	
}