package edu.jt.exg.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public Category(){super();}
	
		private String id="";
		@XmlElement(name = "id")
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String parent_code="";
		@XmlElement(name = "parent_code")
		public String getParent_code(){return parent_code;}
		public void setParent_code(String parent_code){this.parent_code = parent_code;}
		
		private String code="";
		@XmlElement(name = "code")
		public String getCode(){return code;}
		public void setCode(String code){this.code = code;}
		
		private String name="";
		@XmlElement(name = "name")
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		private Integer display=null;
		@XmlElement(name = "disply")
		public Integer getDisplay(){return display;}
		public void setDisplay(Integer display){this.display = display;}
}