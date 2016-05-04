package edu.jt.exg.dto;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "advertisements")
public class Advertisements implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public Advertisements(){super();}
	
		private String id="";
		@XmlElement(name = "id")
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String name="";
		@XmlElement(name = "name")
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		private String top_pic1="";
		@XmlElement(name = "top_pic1")
		public String getTop_pic1(){return top_pic1;}
		public void setTop_pic1(String top_pic1){this.top_pic1 = top_pic1;}
		
		private String url="";
		@XmlElement(name = "url")
		public String getUrl(){return url;}
		public void setUrl(String url){this.url = url;}
		
		private Integer display=null;
		@XmlElement(name = "display")
		public Integer getDisplay(){return display;}
		public void setDisplay(Integer display){this.display = display;}
		
		private String invalid="";
		@XmlElement(name = "invalid")
		public String getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		

}