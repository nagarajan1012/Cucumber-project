package org.stepdefinition;

import org.pom.PojoLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLogin extends PojoLogin {
	@Given("User enter facebook login page using chrome")
	public void user_enter_facebook_login_page_using_chrome() {
	    chromeBrowser();
	    launchUrl("https://www.facebook.com/");
	    maximize();
	}

	@When("user enter valid email and invalid password")
	public void user_enter_valid_email_and_invalid_password() {
		PojoLogin p = new PojoLogin();
		sendValue(p.getTxtEmail(), "naga.avia@gmail.com");
		sendValue(p.getTxtPwd(), "12345");
		
	}
	  

	@Then("Click on login button")
	public void click_on_login_button() {
		PojoLogin p = new PojoLogin();
		click(p.getLgnbtn());
	   
	}}

