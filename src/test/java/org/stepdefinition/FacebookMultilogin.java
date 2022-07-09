package org.stepdefinition;

import org.pom.PojoLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookMultilogin extends PojoLogin {
	@Given("open facebook using chrome browser")
	public void open_facebook_using_chrome_browser() {
		chromeBrowser();
		launchUrl("https://www.facebook.com/");
		maximize();
				
	   
	}@When("user enter username as{string} and password as {string}")
	public void user_enter_username_as_and_password_as(String string, String string2) {
	    PojoLogin p = new PojoLogin();
	    sendValue(p.getTxtEmail(), string);
	    sendValue(p.getTxtPwd(), string2);
	    
	}

	@Then("user should not login")
	public void user_should_not_login() {
		PojoLogin p = new PojoLogin();
		click(p.getLgnbtn());
	}


	
	    
	}



