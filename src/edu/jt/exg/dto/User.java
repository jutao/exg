package edu.jt.exg.dto;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public User(){super();}
	
	
		private String id="";
		@XmlElement(name = "id")
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private Integer level=null;
		@XmlElement(name = "level")
		public Integer getLevel(){return level;}
		public void setLevel(Integer level){this.level = level;}
		
		private String userid="";
		@XmlElement(name = "userid")
		public String getUserid(){return userid;}
		public void setUserid(String userid){this.userid = userid;}
		
		private String name="";
		@XmlElement(name = "name")
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		private String nickname="";
		@XmlElement(name = "nickname")
		public String getNickname(){return nickname;}
		public void setNickname(String nickname){this.nickname = nickname;}
		
		private String icon="";
		@XmlElement(name = "icon")
		public String getIcon(){return icon;}
		public void setIcon(String icon){this.icon = icon;}
		
		private String id_number="";
		@XmlElement(name = "id_number")
		public String getId_number(){return id_number;}
		public void setId_number(String id_number){this.id_number = id_number;}
		
		private String email="";
		@XmlElement(name = "email")
		public String getEmail(){return email;}
		public void setEmail(String email){this.email = email;}
		
		private String gender="";
		@XmlElement(name = "gender")
		public String getGender(){return gender;}
		public void setGender(String gender){this.gender = gender;}
		
		private String address_province="";
		@XmlElement(name = "address_province")
		public String getAddress_province(){return address_province;}
		public void setAddress_province(String address_province){this.address_province = address_province;}
		
		private String address_city="";
		@XmlElement(name = "address_city")
		public String getAddress_city(){return address_city;}
		public void setAddress_city(String address_city){this.address_city = address_city;}
		
		private String address_area="";
		@XmlElement(name = "address_area")
		public String getAddress_area(){return address_area;}
		public void setAddress_area(String address_area){this.address_area = address_area;}
		
		private String address_details="";
		@XmlElement(name = "address_details")
		public String getAddress_details(){return address_details;}
		public void setAddress_details(String address_details){this.address_details = address_details;}
		
		private String hometown="";
		@XmlElement(name = "hometown")
		public String getHometown(){return hometown;}
		public void setHometown(String hometown){this.hometown = hometown;}
		
		private String occupation="";
		@XmlElement(name = "occupation")
		public String getOccupation(){return occupation;}
		public void setOccupation(String occupation){this.occupation = occupation;}
		
		private String interest="";
		@XmlElement(name = "interest")
		public String getInterest(){return interest;}
		public void setInterest(String interest){this.interest = interest;}
		
		private String bankname="";
		@XmlElement(name = "bankname")
		public String getBankname(){return bankname;}
		public void setBankname(String bankname){this.bankname = bankname;}
		
		private String bank_branch="";
		@XmlElement(name = "bank_branch")
		public String getBank_branch(){return bank_branch;}
		public void setBank_branch(String bank_branch){this.bank_branch = bank_branch;}
		
		private String card_number="";
		@XmlElement(name = "card_number")
		public String getCard_number(){return card_number;}
		public void setCard_number(String card_number){this.card_number = card_number;}
		
		private Double balance=null;
		@XmlElement(name = "balance")
		public Double getBalance(){return balance;}
		public void setBalance(Double balance){this.balance = balance;}
		
		private Integer point=null;
		@XmlElement(name = "point")
		public Integer getPoint(){return point;}
		public void setPoint(Integer point){this.point = point;}
		
		private String recommender_code="";
		@XmlElement(name = "recommender_code")
		public String getRecommender_code(){return recommender_code;}
		public void setRecommender_code(String recommender_code){this.recommender_code = recommender_code;}
		
		private String login_password="";
		@XmlElement(name = "login_password")
		public String getLogin_password(){return login_password;}
		public void setLogin_password(String login_password){this.login_password = login_password;}
		
		private String gesture_password="";
		@XmlElement(name = "gesture_password")
		public String getGesture_password(){return gesture_password;}
		public void setGesture_password(String gesture_password){this.gesture_password = gesture_password;}
		
		private String trading_password="";
		@XmlElement(name = "trading_password")
		public String getTrading_password(){return trading_password;}
		public void setTrading_password(String trading_password){this.trading_password = trading_password;}
		
		private String category="";
		@XmlElement(name = "category")
		public String getCategory(){return category;}
		public void setCategory(String category){this.category = category;}
		
		private String usertype="";
		@XmlElement(name = "usertype")
		public String getUsertype(){return usertype;}
		public void setUsertype(String usertype){this.usertype = usertype;}
		
		private String qualificat="";
		@XmlElement(name = "qualificat")
		public String getQualificat(){return qualificat;}
		public void setQualificat(String qualificat){this.qualificat = qualificat;}
		
		private String invalid="";
		@XmlElement(name = "invalid")
		public String getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		
}