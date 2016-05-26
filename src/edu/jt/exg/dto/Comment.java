package edu.jt.exg.dto;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public Comment(){super();}
	
	
		private String id="";
		@XmlElement(name = "id")
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String userkey="";
		@XmlElement(name = "userkey")
		public String getUserkey(){return userkey;}
		public void setUserkey(String userkey){this.userkey = userkey;}
		
		private String targetkey="";
		@XmlElement(name = "targetkey")
		public String getTargetkey(){return targetkey;}
		public void setTargetkey(String targetkey){this.targetkey = targetkey;}
		
		private String detail="";
		@XmlElement(name = "detail")
		public String getDetail(){return detail;}
		public void setDetail(String detail){this.detail = detail;}
		
		private String category="";
		@XmlElement(name = "category")
		public String getCategory(){return category;}
		public void setCategory(String category){this.category = category;}
		
		private String invalid="";
		@XmlElement(name = "invalid")
		public String getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		
		private Timestamp register_time=null;
		@XmlElement(name = "register_time")
		public Timestamp getRegister_time(){return register_time;}
		public void setRegister_time(Timestamp register_time){this.register_time = register_time;}
		
		private Timestamp update_time=null;
		@XmlElement(name = "update_time")
		public Timestamp getUpdate_time(){return update_time;}
		public void setUpdate_time(Timestamp update_time){this.update_time = update_time;}
		
}