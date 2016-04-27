package edu.jt.exg.action;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import utility.SingleServletModel;
import utility.ShowPage;
import utility.Utilities;
import edu.jt.exg.logic.user.PageStatus;
import edu.jt.exg.logic.user.UserBean;
import edu.jt.exg.logic.user.UserBatisDao;

import com.opensymphony.xwork2.ActionSupport;

import core.ExportFileName;
import core.ListKeyBean;

public class UserAttributeAction extends ActionSupport{

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
	
	
	public UserBatisDao batisDao=null;
	
	
	/**
	 * 翻页字符串
	 */
	public ShowPage showPage=null;
	public ShowPage getShowPage(){return showPage;}
	public void setShowPage(ShowPage showPage){this.showPage = showPage;}
	
	/**
	 * 查询页面显示列表清单
	 */
	public List<UserBean> userList=null;
	public List<UserBean> getUserList(){return userList;}
	public void setUserList(List<UserBean> userList){this.userList = userList;}
	
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
		public String adressJson="";
		public String getAdressJson(){return adressJson;}
		public void setAdressJson(String adressJson){this.adressJson = adressJson;}
	
		public String userid="";
		public String getUserid(){return userid;}
		public void setUserid(String userid){this.userid = userid;}
		
		public String name="";
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		public String nickname="";
		public String getNickname(){return nickname;}
		public void setNickname(String nickname){this.nickname = nickname;}
		
		public String id_number="";
		public String getId_number(){return id_number;}
		public void setId_number(String id_number){this.id_number = id_number;}
		
		public String email="";
		public String getEmail(){return email;}
		public void setEmail(String email){this.email = email;}
		
		public String address_details="";
		public String getAddress_details(){return address_details;}
		public void setAddress_details(String address_details){this.address_details = address_details;}
		
		public String hometown="";
		public String getHometown(){return hometown;}
		public void setHometown(String hometown){this.hometown = hometown;}
		
		public String occupation="";
		public String getOccupation(){return occupation;}
		public void setOccupation(String occupation){this.occupation = occupation;}
		
		public String interest="";
		public String getInterest(){return interest;}
		public void setInterest(String interest){this.interest = interest;}
		
		public String bank_branch="";
		public String getBank_branch(){return bank_branch;}
		public void setBank_branch(String bank_branch){this.bank_branch = bank_branch;}
		
		public String card_number="";
		public String getCard_number(){return card_number;}
		public void setCard_number(String card_number){this.card_number = card_number;}
		
		public String recommender_code="";
		public String getRecommender_code(){return recommender_code;}
		public void setRecommender_code(String recommender_code){this.recommender_code = recommender_code;}
		
		public String login_password="";
		public String getLogin_password(){return login_password;}
		public void setLogin_password(String login_password){this.login_password = login_password;}
		
		public String gesture_password="";
		public String getGesture_password(){return gesture_password;}
		public void setGesture_password(String gesture_password){this.gesture_password = gesture_password;}
		
		public String trading_password="";
		public String getTrading_password(){return trading_password;}
		public void setTrading_password(String trading_password){this.trading_password = trading_password;}
		
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
		
		public String usertype="";
		public String getUsertype(){return usertype;}
		public void setUsertype(String usertype){this.usertype = usertype;}
		public LinkedHashMap<String, String> usertypeMap=null;
		public LinkedHashMap<String, String> getUsertypeMap(){return usertypeMap;}
		public void setUsertypeMap(LinkedHashMap<String, String> usertypeMap){this.usertypeMap = usertypeMap;}
		public List<String> usertypeList=null;
		public List<String> getUsertypeList(){return usertypeList;}
		public void setUsertypeList(List<String> usertypeList){this.usertypeList = usertypeList;}
	
	/**
	 * s:textarea
	 */
	

	/**
	 * editor
	 */
	
	
	/**
	 * s:hidden iframe use s:file(textarea,editor)
	 */
			public String icon="";
		public String getIcon(){return icon;}
		public void setIcon(String icon){this.icon = icon;}
		
		public String qualificat="";
		public String getQualificat(){return qualificat;}
		public void setQualificat(String qualificat){this.qualificat = qualificat;}
		

	
	/**
	 * s:combobox
	 */
	
	
	//s:textfield
			public Integer level=null;
		public Integer getLevel(){return level;}
		public void setLevel(Integer level){this.level = level;}
		//for query
		public Integer levelFrom=null;
		public Integer getLevelFrom(){return levelFrom;}
		public void setLevelFrom(Integer levelFrom){this.levelFrom = levelFrom;}
		public Integer levelTo=null;
		public Integer getLevelTo(){return levelTo;}
		public void setLevelTo(Integer levelTo){this.levelTo = levelTo;}
		
		public Integer point=null;
		public Integer getPoint(){return point;}
		public void setPoint(Integer point){this.point = point;}
		//for query
		public Integer pointFrom=null;
		public Integer getPointFrom(){return pointFrom;}
		public void setPointFrom(Integer pointFrom){this.pointFrom = pointFrom;}
		public Integer pointTo=null;
		public Integer getPointTo(){return pointTo;}
		public void setPointTo(Integer pointTo){this.pointTo = pointTo;}
		

	
	//s:textfield
	
	
	//s:textfield
	
	
	//s:textfield
			public Double balance=null;
		public Double getBalance(){return balance;}
		public void setBalance(Double balance){this.balance = balance;}
		//for query
		public Double balanceFrom=null;
		public Double getBalanceFrom(){return balanceFrom;}
		public void setBalanceFrom(Double balanceFrom){this.balanceFrom = balanceFrom;}
		public Double balanceTo=null;
		public Double getBalanceTo(){return balanceTo;}
		public void setBalanceTo(Double balanceTo){this.balanceTo = balanceTo;}
		

	
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
			public String gender=null;
		public String getGender(){return gender;}
		public void setGender(String gender){this.gender = gender;}
		public String genderSelect=null;
		public String getGenderSelect(){return genderSelect;}
		public void setGenderSelect(String genderSelect){this.genderSelect = genderSelect;}
		public LinkedHashMap<String, String> genderMap=null;
		public LinkedHashMap<String, String> getGenderMap(){return genderMap;}
		public void setGenderMap(LinkedHashMap<String, String> genderMap){this.genderMap = genderMap;}
		
		public String address_province=null;
		public String getAddress_province(){return address_province;}
		public void setAddress_province(String address_province){this.address_province = address_province;}
		public String address_provinceSelect=null;
		public String getAddress_provinceSelect(){return address_provinceSelect;}
		public void setAddress_provinceSelect(String address_provinceSelect){this.address_provinceSelect = address_provinceSelect;}
		public LinkedHashMap<String, String> address_provinceMap=null;
		public LinkedHashMap<String, String> getAddress_provinceMap(){return address_provinceMap;}
		public void setAddress_provinceMap(LinkedHashMap<String, String> address_provinceMap){this.address_provinceMap = address_provinceMap;}
		
		public String address_city=null;
		public String getAddress_city(){return address_city;}
		public void setAddress_city(String address_city){this.address_city = address_city;}
		public String address_citySelect=null;
		public String getAddress_citySelect(){return address_citySelect;}
		public void setAddress_citySelect(String address_citySelect){this.address_citySelect = address_citySelect;}
		public LinkedHashMap<String, String> address_cityMap=null;
		public LinkedHashMap<String, String> getAddress_cityMap(){return address_cityMap;}
		public void setAddress_cityMap(LinkedHashMap<String, String> address_cityMap){this.address_cityMap = address_cityMap;}
		
		public String address_area=null;
		public String getAddress_area(){return address_area;}
		public void setAddress_area(String address_area){this.address_area = address_area;}
		public String address_areaSelect=null;
		public String getAddress_areaSelect(){return address_areaSelect;}
		public void setAddress_areaSelect(String address_areaSelect){this.address_areaSelect = address_areaSelect;}
		public LinkedHashMap<String, String> address_areaMap=null;
		public LinkedHashMap<String, String> getAddress_areaMap(){return address_areaMap;}
		public void setAddress_areaMap(LinkedHashMap<String, String> address_areaMap){this.address_areaMap = address_areaMap;}
		
		public String bankname=null;
		public String getBankname(){return bankname;}
		public void setBankname(String bankname){this.bankname = bankname;}
		public String banknameSelect=null;
		public String getBanknameSelect(){return banknameSelect;}
		public void setBanknameSelect(String banknameSelect){this.banknameSelect = banknameSelect;}
		public LinkedHashMap<String, String> banknameMap=null;
		public LinkedHashMap<String, String> getBanknameMap(){return banknameMap;}
		public void setBanknameMap(LinkedHashMap<String, String> banknameMap){this.banknameMap = banknameMap;}
		
		public String category=null;
		public String getCategory(){return category;}
		public void setCategory(String category){this.category = category;}
		public String categorySelect=null;
		public String getCategorySelect(){return categorySelect;}
		public void setCategorySelect(String categorySelect){this.categorySelect = categorySelect;}
		public LinkedHashMap<String, String> categoryMap=null;
		public LinkedHashMap<String, String> getCategoryMap(){return categoryMap;}
		public void setCategoryMap(LinkedHashMap<String, String> categoryMap){this.categoryMap = categoryMap;}
		
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