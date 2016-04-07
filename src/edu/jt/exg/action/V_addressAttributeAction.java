package edu.jt.exg.action;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import utility.ShowPage;
import utility.SingleServletModel;

import com.opensymphony.xwork2.ActionSupport;

import edu.jt.exg.logic.v_address.PageStatus;
import edu.jt.exg.logic.v_address.V_addressBatisDao;
import edu.jt.exg.logic.v_address.V_addressBean;

public class V_addressAttributeAction extends ActionSupport{

	private static final long serialVersionUID = 19761210;
	
	/**
	 * 记录起始读取位置
	 */
	public String start=null;
	public String getStart(){return start;}
	public void setStart(String start){this.start=start;}
	
	/**
	 * 记录范围
	 */
	public String range=null;
	
	/**
	 * 排序规则
	 */
	public LinkedHashMap<String,String> orderByMap=null;
	public HttpServletRequest request=null;
	public SingleServletModel singleServletModel=null;
	
	/**
	 * PageStatus句柄，设置页面显示状态
	 */
	public PageStatus ps=null;
	
	
	public V_addressBatisDao batisDao=null;
	
	
	/**
	 * 翻页字符串
	 */
	public ShowPage showPage=null;
	public ShowPage getShowPage(){return showPage;}
	public void setShowPage(ShowPage showPage){this.showPage = showPage;}
	
	/**
	 * 查询页面显示列表清单
	 */
	public List<V_addressBean> v_addressList=null;
	public List<V_addressBean> getV_addressList(){return v_addressList;}
	public void setV_addressList(List<V_addressBean> v_addressList){this.v_addressList = v_addressList;}
	
	/**
	 * action跳转动作
	 */
	public String action=null;//action param
	public String getAction(){return action;}
	public void setAction(String action){this.action = action;}
	
	/**
	 * 翻页范围
	 */
	public String scope=null;//scope param
	public String getScope(){return scope;}
	public void setScope(String scope){this.scope = scope;}
	
	/**
	 * s:hidden
	 */
	public String province_code="";//key
	public String getProvince_code(){return province_code;}
	public void setProvince_code(String province_code){this.province_code = province_code;}
	
	
	
	/**
	 * s:textfield
	 */
			public String province_name="";
		public String getProvince_name(){return province_name;}
		public void setProvince_name(String province_name){this.province_name = province_name;}
		
		public String city_code="";
		public String getCity_code(){return city_code;}
		public void setCity_code(String city_code){this.city_code = city_code;}
		
		public String city_name="";
		public String getCity_name(){return city_name;}
		public void setCity_name(String city_name){this.city_name = city_name;}
		
		public String area_code="";
		public String getArea_code(){return area_code;}
		public void setArea_code(String area_code){this.area_code = area_code;}
		
		public String area_name="";
		public String getArea_name(){return area_name;}
		public void setArea_name(String area_name){this.area_name = area_name;}
		

	
	/**
	 * s:password
	 */
	
	
	/**
	 * s:checkbox
	 */
	
	
	/**
	 * s:textarea
	 */
	

	/**
	 * editor
	 */
	
	
	/**
	 * s:hidden iframe use s:file(textarea,editor)
	 */
	
	
	/**
	 * s:combobox
	 */
	
	
	//s:textfield
	
	
	//s:textfield
	
	
	//s:textfield
	
	
	//s:textfield
	
	
	/**
	 * s:doubleselect
	 */
	
	
	/**
	 * s:radio
	 */
	
	
	/**
	 * s:checkboxlist
	 */
	
	
	/**
	 * s:select
	 */
	
	
	/**
	 * s:optiontransferselect
	 */
	
	
	/**
	 * sx:datetimepicker
	 */
	
	
	/**
	 * 设置日历当前时间显示
	 */
	public void setDateTimePickerNowDateShow(){
	
	}
	
	/**
	 * manual timestamp
	 */
	

	/**
	 * auto timstamp
	 */
	
}