package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoLogin extends BaseClass {
	public PojoLogin() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="email")
	private WebElement txtEmail;
	@FindBy(id="pass")
	private WebElement txtPwd;
	@FindBy(name="login")
	private WebElement lgnbtn;
	public WebElement getTxtEmail() {
		return txtEmail;
	}
	public WebElement getTxtPwd() {
		return txtPwd;
	}
	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	
	

}
