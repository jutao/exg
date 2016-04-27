package edu.jt.exg.action;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import utility.SingleServletModel;
import utility.ShowPage;
import utility.Utilities;
import edu.jt.exg.logic.re_serve.PageStatus;
import edu.jt.exg.logic.re_serve.Re_serveBean;
import edu.jt.exg.logic.re_serve.Re_serveBatisDao;

import com.opensymphony.xwork2.ActionSupport;

import core.ExportFileName;
import core.ListKeyBean;

public class Re_serveAttributeAction extends ActionSupport{

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
	
	
	public Re_serveBatisDao batisDao=null;
	
	
	/**
	 * 翻页字符串
	 */
	public ShowPage showPage=null;
	public ShowPage getShowPage(){return showPage;}
	public void setShowPage(ShowPage showPage){this.showPage = showPage;}
	
	/**
	 * 查询页面显示列表清单
	 */
	public List<Re_serveBean> re_serveList=null;
	public List<Re_serveBean> getRe_serveList(){return re_serveList;}
	public void setRe_serveList(List<Re_serveBean> re_serveList){this.re_serveList = re_serveList;}
	
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
	public String id="";//key
	public String getId(){return id;}
	public void setId(String id){this.id = id;}
	
	
	
	/**
	 * s:textfield
	 */
			public String serveid="";
		public String getServeid(){return serveid;}
		public void setServeid(String serveid){this.serveid = serveid;}
		
		public String name="";
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		public String description="";
		public String getDescription(){return description;}
		public void setDescription(String description){this.description = description;}
		
		public String yubei1="";
		public String getYubei1(){return yubei1;}
		public void setYubei1(String yubei1){this.yubei1 = yubei1;}
		
		public String yubei2="";
		public String getYubei2(){return yubei2;}
		public void setYubei2(String yubei2){this.yubei2 = yubei2;}
		
		public String yubei3="";
		public String getYubei3(){return yubei3;}
		public void setYubei3(String yubei3){this.yubei3 = yubei3;}
		

	
	/**
	 * s:password
	 */
	
	
	/**
	 * s:checkbox
	 */
		public String varieties="";
		public String getVarieties(){return varieties;}
		public void setVarieties(String varieties){this.varieties = varieties;}
		public LinkedHashMap<String, String> varietiesMap=null;
		public LinkedHashMap<String, String> getVarietiesMap(){return varietiesMap;}
		public void setVarietiesMap(LinkedHashMap<String, String> varietiesMap){this.varietiesMap = varietiesMap;}
		public List<String> varietiesList=null;
		public List<String> getVarietiesList(){return varietiesList;}
		public void setVarietiesList(List<String> varietiesList){this.varietiesList = varietiesList;}

	
	/**
	 * s:textarea
	 */
	

	/**
	 * editor
	 */
	
	
	/**
	 * s:hidden iframe use s:file(textarea,editor)
	 */
			public String top_pic1="";
		public String getTop_pic1(){return top_pic1;}
		public void setTop_pic1(String top_pic1){this.top_pic1 = top_pic1;}
		
		public String pic1="";
		public String getPic1(){return pic1;}
		public void setPic1(String pic1){this.pic1 = pic1;}
		
		public String pic2="";
		public String getPic2(){return pic2;}
		public void setPic2(String pic2){this.pic2 = pic2;}
		
		public String pic3="";
		public String getPic3(){return pic3;}
		public void setPic3(String pic3){this.pic3 = pic3;}
		
		public String pic4="";
		public String getPic4(){return pic4;}
		public void setPic4(String pic4){this.pic4 = pic4;}
		
		public String pic5="";
		public String getPic5(){return pic5;}
		public void setPic5(String pic5){this.pic5 = pic5;}
		

	
	/**
	 * s:combobox
	 */
	
	
	//s:textfield
			public Integer display=null;
		public Integer getDisplay(){return display;}
		public void setDisplay(Integer display){this.display = display;}
		//for query
		public Integer displayFrom=null;
		public Integer getDisplayFrom(){return displayFrom;}
		public void setDisplayFrom(Integer displayFrom){this.displayFrom = displayFrom;}
		public Integer displayTo=null;
		public Integer getDisplayTo(){return displayTo;}
		public void setDisplayTo(Integer displayTo){this.displayTo = displayTo;}
		

	
	//s:textfield
	
	
	//s:textfield
	
	
	//s:textfield
			public Double price=null;
		public Double getPrice(){return price;}
		public void setPrice(Double price){this.price = price;}
		//for query
		public Double priceFrom=null;
		public Double getPriceFrom(){return priceFrom;}
		public void setPriceFrom(Double priceFrom){this.priceFrom = priceFrom;}
		public Double priceTo=null;
		public Double getPriceTo(){return priceTo;}
		public void setPriceTo(Double priceTo){this.priceTo = priceTo;}
		

	
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
			public String invalid=null;
		public String getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		public String invalidSelect=null;
		public String getInvalidSelect(){return invalidSelect;}
		public void setInvalidSelect(String invalidSelect){this.invalidSelect = invalidSelect;}
		public LinkedHashMap<String, String> invalidMap=null;
		public LinkedHashMap<String, String> getInvalidMap(){return invalidMap;}
		public void setInvalidMap(LinkedHashMap<String, String> invalidMap){this.invalidMap = invalidMap;}
		

	
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
			public Timestamp register_time=null;
		public Timestamp getRegister_time(){return register_time;}
		public void setRegister_time(Timestamp register_time){
		if(register_time==null) register_time=Utilities.csi.getCurrentTimestamp();
		this.register_time = register_time;
		}
		//for query
		public Timestamp register_timeFrom=null;
		public Timestamp getRegister_timeFrom(){return register_timeFrom;}
		public void setRegister_timeFrom(Timestamp register_timeFrom){this.register_timeFrom = register_timeFrom;}
		public Date register_timeDateFrom=null;
		public Date getRegister_timeDateFrom(){return register_timeDateFrom;}
		public void setRegister_timeDateFrom(Date register_timeDateFrom){this.register_timeDateFrom = register_timeDateFrom;}
		public String register_timeHourFrom=null;
		public String getRegister_timeHourFrom(){return register_timeHourFrom;}
		public void setRegister_timeHourFrom(String register_timeHourFrom){this.register_timeHourFrom = register_timeHourFrom;}
		public String register_timeHourSelectFrom=null;
		public String getRegister_timeHourSelectFrom(){return register_timeHourSelectFrom;}
		public void setRegister_timeHourSelectFrom(String register_timeHourSelectFrom){this.register_timeHourSelectFrom = register_timeHourSelectFrom;}
		public String register_timeMinuteFrom=null;
		public String getRegister_timeMinuteFrom(){return register_timeMinuteFrom;}
		public void setRegister_timeMinuteFrom(String register_timeMinuteFrom){this.register_timeMinuteFrom = register_timeMinuteFrom;}
		public String register_timeMinuteSelectFrom=null;
		public String getRegister_timeMinuteSelectFrom(){return register_timeMinuteSelectFrom;}
		public void setRegister_timeMinuteSelectFrom(String register_timeMinuteSelectFrom){this.register_timeMinuteSelectFrom = register_timeMinuteSelectFrom;}
		public LinkedHashMap<String,String> register_timeHourMapFrom=null;
		public LinkedHashMap<String, String> getRegister_timeHourMapFrom(){return register_timeHourMapFrom;}
		public void setRegister_timeHourMapFrom(LinkedHashMap<String, String> register_timeHourMapFrom){this.register_timeHourMapFrom = Utilities.csi.getLinkedHashMapWith24Hours(register_timeHourMapFrom);}
		public LinkedHashMap<String,String> register_timeMinuteMapFrom=null;
		public LinkedHashMap<String, String> getRegister_timeMinuteMapFrom(){return register_timeMinuteMapFrom;}
		public void setRegister_timeMinuteMapFrom(LinkedHashMap<String, String> register_timeMinuteMapFrom){this.register_timeMinuteMapFrom = Utilities.csi.getLinkedHashMapWith60Minutes(register_timeMinuteMapFrom);}
		public Timestamp register_timeTo=null;
		public Timestamp getRegister_timeTo(){return register_timeTo;}
		public void setRegister_timeTo(Timestamp register_timeTo){this.register_timeTo = register_timeTo;}
		public Date register_timeDateTo=null;
		public Date getRegister_timeDateTo(){return register_timeDateTo;}
		public void setRegister_timeDateTo(Date register_timeDateTo){this.register_timeDateTo = register_timeDateTo;}
		public String register_timeHourTo=null;
		public String getRegister_timeHourTo(){return register_timeHourTo;}
		public void setRegister_timeHourTo(String register_timeHourTo){this.register_timeHourTo = register_timeHourTo;}
		public String register_timeHourSelectTo=null;
		public String getRegister_timeHourSelectTo(){return register_timeHourSelectTo;}
		public void setRegister_timeHourSelectTo(String register_timeHourSelectTo){this.register_timeHourSelectTo = register_timeHourSelectTo;}
		public String register_timeMinuteTo=null;
		public String getRegister_timeMinuteTo(){return register_timeMinuteTo;}
		public void setRegister_timeMinuteTo(String register_timeMinuteTo){this.register_timeMinuteTo = register_timeMinuteTo;}
		public String register_timeMinuteSelectTo=null;
		public String getRegister_timeMinuteSelectTo(){return register_timeMinuteSelectTo;}
		public void setRegister_timeMinuteSelectTo(String register_timeMinuteSelectTo){this.register_timeMinuteSelectTo = register_timeMinuteSelectTo;}
		public LinkedHashMap<String,String> register_timeHourMapTo=null;
		public LinkedHashMap<String, String> getRegister_timeHourMapTo(){return register_timeHourMapTo;}
		public void setRegister_timeHourMapTo(LinkedHashMap<String, String> register_timeHourMapTo){this.register_timeHourMapTo = Utilities.csi.getLinkedHashMapWith24Hours(register_timeHourMapTo);}
		public LinkedHashMap<String,String> register_timeMinuteMapTo=null;
		public LinkedHashMap<String, String> getRegister_timeMinuteMapTo(){return register_timeMinuteMapTo;}
		public void setRegister_timeMinuteMapTo(LinkedHashMap<String, String> register_timeMinuteMapTo){this.register_timeMinuteMapTo = Utilities.csi.getLinkedHashMapWith60Minutes(register_timeMinuteMapTo);}
		
		public Timestamp update_time=null;
		public Timestamp getUpdate_time(){return update_time;}
		public void setUpdate_time(Timestamp update_time){
		if(update_time==null) update_time=Utilities.csi.getCurrentTimestamp();
		this.update_time = update_time;
		}
		//for query
		public Timestamp update_timeFrom=null;
		public Timestamp getUpdate_timeFrom(){return update_timeFrom;}
		public void setUpdate_timeFrom(Timestamp update_timeFrom){this.update_timeFrom = update_timeFrom;}
		public Date update_timeDateFrom=null;
		public Date getUpdate_timeDateFrom(){return update_timeDateFrom;}
		public void setUpdate_timeDateFrom(Date update_timeDateFrom){this.update_timeDateFrom = update_timeDateFrom;}
		public String update_timeHourFrom=null;
		public String getUpdate_timeHourFrom(){return update_timeHourFrom;}
		public void setUpdate_timeHourFrom(String update_timeHourFrom){this.update_timeHourFrom = update_timeHourFrom;}
		public String update_timeHourSelectFrom=null;
		public String getUpdate_timeHourSelectFrom(){return update_timeHourSelectFrom;}
		public void setUpdate_timeHourSelectFrom(String update_timeHourSelectFrom){this.update_timeHourSelectFrom = update_timeHourSelectFrom;}
		public String update_timeMinuteFrom=null;
		public String getUpdate_timeMinuteFrom(){return update_timeMinuteFrom;}
		public void setUpdate_timeMinuteFrom(String update_timeMinuteFrom){this.update_timeMinuteFrom = update_timeMinuteFrom;}
		public String update_timeMinuteSelectFrom=null;
		public String getUpdate_timeMinuteSelectFrom(){return update_timeMinuteSelectFrom;}
		public void setUpdate_timeMinuteSelectFrom(String update_timeMinuteSelectFrom){this.update_timeMinuteSelectFrom = update_timeMinuteSelectFrom;}
		public LinkedHashMap<String,String> update_timeHourMapFrom=null;
		public LinkedHashMap<String, String> getUpdate_timeHourMapFrom(){return update_timeHourMapFrom;}
		public void setUpdate_timeHourMapFrom(LinkedHashMap<String, String> update_timeHourMapFrom){this.update_timeHourMapFrom = Utilities.csi.getLinkedHashMapWith24Hours(update_timeHourMapFrom);}
		public LinkedHashMap<String,String> update_timeMinuteMapFrom=null;
		public LinkedHashMap<String, String> getUpdate_timeMinuteMapFrom(){return update_timeMinuteMapFrom;}
		public void setUpdate_timeMinuteMapFrom(LinkedHashMap<String, String> update_timeMinuteMapFrom){this.update_timeMinuteMapFrom = Utilities.csi.getLinkedHashMapWith60Minutes(update_timeMinuteMapFrom);}
		public Timestamp update_timeTo=null;
		public Timestamp getUpdate_timeTo(){return update_timeTo;}
		public void setUpdate_timeTo(Timestamp update_timeTo){this.update_timeTo = update_timeTo;}
		public Date update_timeDateTo=null;
		public Date getUpdate_timeDateTo(){return update_timeDateTo;}
		public void setUpdate_timeDateTo(Date update_timeDateTo){this.update_timeDateTo = update_timeDateTo;}
		public String update_timeHourTo=null;
		public String getUpdate_timeHourTo(){return update_timeHourTo;}
		public void setUpdate_timeHourTo(String update_timeHourTo){this.update_timeHourTo = update_timeHourTo;}
		public String update_timeHourSelectTo=null;
		public String getUpdate_timeHourSelectTo(){return update_timeHourSelectTo;}
		public void setUpdate_timeHourSelectTo(String update_timeHourSelectTo){this.update_timeHourSelectTo = update_timeHourSelectTo;}
		public String update_timeMinuteTo=null;
		public String getUpdate_timeMinuteTo(){return update_timeMinuteTo;}
		public void setUpdate_timeMinuteTo(String update_timeMinuteTo){this.update_timeMinuteTo = update_timeMinuteTo;}
		public String update_timeMinuteSelectTo=null;
		public String getUpdate_timeMinuteSelectTo(){return update_timeMinuteSelectTo;}
		public void setUpdate_timeMinuteSelectTo(String update_timeMinuteSelectTo){this.update_timeMinuteSelectTo = update_timeMinuteSelectTo;}
		public LinkedHashMap<String,String> update_timeHourMapTo=null;
		public LinkedHashMap<String, String> getUpdate_timeHourMapTo(){return update_timeHourMapTo;}
		public void setUpdate_timeHourMapTo(LinkedHashMap<String, String> update_timeHourMapTo){this.update_timeHourMapTo = Utilities.csi.getLinkedHashMapWith24Hours(update_timeHourMapTo);}
		public LinkedHashMap<String,String> update_timeMinuteMapTo=null;
		public LinkedHashMap<String, String> getUpdate_timeMinuteMapTo(){return update_timeMinuteMapTo;}
		public void setUpdate_timeMinuteMapTo(LinkedHashMap<String, String> update_timeMinuteMapTo){this.update_timeMinuteMapTo = Utilities.csi.getLinkedHashMapWith60Minutes(update_timeMinuteMapTo);}
		

}