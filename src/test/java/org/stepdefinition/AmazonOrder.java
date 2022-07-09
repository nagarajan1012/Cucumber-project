package org.stepdefinition;

import java.io.IOException;
import java.util.Set;

import org.base.BaseClass;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AmazonOrder extends BaseClass {
	@Given("Login Amazon using Chrome Browser")
	public void login_Amazon_using_Chrome_Browser() {
		chromeBrowser();
		launchUrl("https://www.amazon.in/");
		maximize();
		
	    
	}

	@When("Search any item using search box")
	public void search_any_item_using_search_box() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("preworkout");
	    driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@When("Click on any item and place order")
	public void click_on_any_item_and_place_order() throws InterruptedException, IOException {
		driver.findElement(By.xpath("(//img[@class='s-image'])[8]")).click();
		String window1 = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for (String window2 : allwindow) {
			if (!window2.equals(window1)) {
				driver.switchTo().window(window2);
				driver.findElement(By.id("add-to-cart-button")).click();
				Thread.sleep(3000);
				screenSHot("Added to cart.png");
				
			}
			
		}
	    
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
	    
	}


}
