package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	WebDriver driver;
	WebElement cartTab;
	WebElement myAccountTab;
	WebElement shopTab;
	
	
	public WebElement getCart() {
		return driver.findElement(By.className("page-item-8"));
	}

	public WebElement getMyAccountTab() {
		return driver.findElement(By.className("page-item-10"));
	}

	public WebElement getShop() {
		return driver.findElement(By.className("page-item-7"));
	}


	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToMyAccount() {
		this.getMyAccountTab().click();
	}
	
	public void navigateToCart() {
		this.getCart().click();
	}
	
	public void navigateToShop() {
		this.getShop().click();
	}
}
