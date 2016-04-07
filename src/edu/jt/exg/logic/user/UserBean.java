package edu.jt.exg.logic.user;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public UserBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private Integer level=null;
		public Integer getLevel(){return level;}
		public void setLevel(Integer level){this.level = level;}
		
		private Integer levelFrom=null;
		public Integer getLevelFrom(){return levelFrom;}
		public void setLevelFrom(Integer levelFrom){this.levelFrom = levelFrom;}
		
		private Integer levelTo=null;
		public Integer getLevelTo(){return levelTo;}
		public void setLevelTo(Integer levelTo){this.levelTo = levelTo;}
		
		private String userid="";
		public String getUserid(){return userid;}
		public void setUserid(String userid){this.userid = userid;}
		
		private String name="";
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		private String nickname="";
		public String getNickname(){return nickname;}
		public void setNickname(String nickname){this.nickname = nickname;}
		
		private String icon="";
		public String getIcon(){return icon;}
		public void setIcon(String icon){this.icon = icon;}
		
		private String id_number="";
		public String getId_number(){return id_number;}
		public void setId_number(String id_number){this.id_number = id_number;}
		
		private String email="";
		public String getEmail(){return email;}
		public void setEmail(String email){this.email = email;}
		
		private String gender="";
		public String getGender(){return gender;}
		public void setGender(String gender){this.gender = gender;}
		
		private String address_province="";
		public String getAddress_province(){return address_province;}
		public void setAddress_province(String address_province){this.address_province = address_province;}
		
		private String address_city="";
		public String getAddress_city(){return address_city;}
		public void setAddress_city(String address_city){this.address_city = address_city;}
		
		private String address_area="";
		public String getAddress_area(){return address_area;}
		public void setAddress_area(String address_area){this.address_area = address_area;}
		
		private String address_details="";
		public String getAddress_details(){return address_details;}
		public void setAddress_details(String address_details){this.address_details = address_details;}
		
		private String hometown="";
		public String getHometown(){return hometown;}
		public void setHometown(String hometown){this.hometown = hometown;}
		
		private String occupation="";
		public String getOccupation(){return occupation;}
		public void setOccupation(String occupation){this.occupation = occupation;}
		
		private String interest="";
		public String getInterest(){return interest;}
		public void setInterest(String interest){this.interest = interest;}
		
		private String bankname="";
		public String getBankname(){return bankname;}
		public void setBankname(String bankname){this.bankname = bankname;}
		
		private String bank_branch="";
		public String getBank_branch(){return bank_branch;}
		public void setBank_branch(String bank_branch){this.bank_branch = bank_branch;}
		
		private String card_number="";
		public String getCard_number(){return card_number;}
		public void setCard_number(String card_number){this.card_number = card_number;}
		
		private Double balance=null;
		public Double getBalance(){return balance;}
		public void setBalance(Double balance){this.balance = balance;}
		
		private Double balanceFrom=null;
		public Double getBalanceFrom(){return balanceFrom;}
		public void setBalanceFrom(Double balanceFrom){this.balanceFrom = balanceFrom;}
		
		private Double balanceTo=null;
		public Double getBalanceTo(){return balanceTo;}
		public void setBalanceTo(Double balanceTo){this.balanceTo = balanceTo;}
		
		private Integer point=null;
		public Integer getPoint(){return point;}
		public void setPoint(Integer point){this.point = point;}
		
		private Integer pointFrom=null;
		public Integer getPointFrom(){return pointFrom;}
		public void setPointFrom(Integer pointFrom){this.pointFrom = pointFrom;}
		
		private Integer pointTo=null;
		public Integer getPointTo(){return pointTo;}
		public void setPointTo(Integer pointTo){this.pointTo = pointTo;}
		
		private String recommender_code="";
		public String getRecommender_code(){return recommender_code;}
		public void setRecommender_code(String recommender_code){this.recommender_code = recommender_code;}
		
		private String login_password="";
		public String getLogin_password(){return login_password;}
		public void setLogin_password(String login_password){this.login_password = login_password;}
		
		private String gesture_password="";
		public String getGesture_password(){return gesture_password;}
		public void setGesture_password(String gesture_password){this.gesture_password = gesture_password;}
		
		private String trading_password="";
		public String getTrading_password(){return trading_password;}
		public void setTrading_password(String trading_password){this.trading_password = trading_password;}
		
		private String category="";
		public String getCategory(){return category;}
		public void setCategory(String category){this.category = category;}
		
		private String usertype="";
		public String getUsertype(){return usertype;}
		public void setUsertype(String usertype){this.usertype = usertype;}
		
		private String qualificat="";
		public String getQualificat(){return qualificat;}
		public void setQualificat(String qualificat){this.qualificat = qualificat;}
		
		private String yubei1="";
		public String getYubei1(){return yubei1;}
		public void setYubei1(String yubei1){this.yubei1 = yubei1;}
		
		private String yubei2="";
		public String getYubei2(){return yubei2;}
		public void setYubei2(String yubei2){this.yubei2 = yubei2;}
		
		private String yubei3="";
		public String getYubei3(){return yubei3;}
		public void setYubei3(String yubei3){this.yubei3 = yubei3;}
		
		private String invalid="";
		public String getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		
		private Timestamp register_time=null;
		public Timestamp getRegister_time(){return register_time;}
		public void setRegister_time(Timestamp register_time){this.register_time = register_time;}
		
		private Timestamp register_timeFrom=null;
		public Timestamp getRegister_timeFrom(){return register_timeFrom;}
		public void setRegister_timeFrom(Timestamp register_timeFrom){this.register_timeFrom = register_timeFrom;}
		
		private Timestamp register_timeTo=null;
		public Timestamp getRegister_timeTo(){return register_timeTo;}
		public void setRegister_timeTo(Timestamp register_timeTo){this.register_timeTo = register_timeTo;}
		
		private Timestamp update_time=null;
		public Timestamp getUpdate_time(){return update_time;}
		public void setUpdate_time(Timestamp update_time){this.update_time = update_time;}
		
		private Timestamp update_timeFrom=null;
		public Timestamp getUpdate_timeFrom(){return update_timeFrom;}
		public void setUpdate_timeFrom(Timestamp update_timeFrom){this.update_timeFrom = update_timeFrom;}
		
		private Timestamp update_timeTo=null;
		public Timestamp getUpdate_timeTo(){return update_timeTo;}
		public void setUpdate_timeTo(Timestamp update_timeTo){this.update_timeTo = update_timeTo;}
		

}