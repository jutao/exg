package edu.jt.exg.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "callback")
public class Callback implements Serializable{
	private static final long serialVersionUID = 19761210;
	
	private int code;
	@XmlElement(name = "code")
	public int getCode(){return code;}
	public void setCode(int code){this.code = code;}
	
	private String message="";
	@XmlElement(name = "message")
	public String getMessage(){return message;}
	public void setMessage(String message){this.message = message;}
	
}
