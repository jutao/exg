package edu.jt.exg.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usercheck")
public class UserCheck {

	/*
	 * 是否验证通过
	 */
	private Boolean result = false;
	
	@XmlElement(name = "result")
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	
}
