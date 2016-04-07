package edu.jt.exg.logic.v_address;
import java.io.Serializable;

//页面控件初始化设置
public class InitPageControl implements Serializable{

	private static final long serialVersionUID = 19761210;

	public InitPageControl(){super();}
	
	/**
	 * 初始化选择列字符串供hidden控件使用,动态列排序初始化,不包括主键
	 */
	public static String getColumnSetupAllStr(){
		String tmp="Province_name|City_code|City_name|Area_code|Area_name";
		return tmp;
	}
	
}