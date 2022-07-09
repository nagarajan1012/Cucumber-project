package org.stepdefinition;

import java.io.IOException;
import java.util.Set;

import org.base.BaseClass;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPractice extends BaseClass {
	@Given("login amazon using chrome browser")
	public void login_amazon_using_chrome_browser() {
		chromeBrowser();
		launchUrl("https://www.amazon.in/");
		maximize();
		
	    
	}

	@When("user search any product and select any product")
	public void user_search_any_product_and_select_any_product() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("preworkout");
	    driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@When("user buy that product")
	public void user_buy_that_product() throws IOException, InterruptedException {
		driver.findElement(By.xpath("(//img[@class='s-image'])[8]")).click();
		String window1 = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for (String window2 : allwindow) {
			if (!window2.equals(window1)) {
				driver.switchTo().window(window2);
				driver.findElement(By.id("add-to-cart-button")).click();
				Thread.sleep(3000);
				screenSHot("Added to cart.png");
	}}}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close(); 
	}

	@Given("user enter amazon using chrome")
	public void user_enter_amazon_using_chrome() {
		chromeBrowser();
		launchUrl("https://www.amazon.in/");
		maximize();
	}

	@When("user search fpr product")
	public void user_search_fpr_product() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("preworkout");
	    driver.findElement(By.id("nav-search-submit-button")).click();   
	}
	@Then("close browser")
	public void close_browser() {
		driver.close(); 
	}


}
