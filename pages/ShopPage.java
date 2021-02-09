package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {

	WebDriver driver;
	WebElement addToCartBtn;
	WebElement viewCartBtn;
	List<WebElement> addButtons; 
	 
	
	public WebElement getAddToCartBtn() {
		return driver.findElement(By.className("ajax_add_to_cart"));
	}


	public WebElement getViewCartBtn() {
		return driver.findElement(By.className("wc-forward"));
	}


	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addToCartClick() {
		this.getAddToCartBtn().click();
	}
	
	public void viewCartClick() {
		this.getViewCartBtn().click();
	}
	

	public void addThreeProducts() {
		addButtons = driver.findElements(By.className("add_to_cart_button"));
		for(int i = 0; i < 3; i++) {
			addButtons.get(i).click();
		}
	}
	
	public void addTwoProducts() {
		addButtons = driver.findElements(By.className("add_to_cart_button"));
		for(int i = 0; i < 2; i++) {
			addButtons.get(i).click();
		}
	}
}
