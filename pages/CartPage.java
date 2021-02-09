package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	WebDriver driver;
	WebElement productName;
	WebElement deleteButton;
	WebElement cartIsEmpty;
	WebElement totalPrice;
	List<WebElement> products;
	
	public WebElement getProductName() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}
	

	public WebElement getDeleteButton() {
		//return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[1]/a"));
		return driver.findElement(By.className("remove"));
	}

	public WebElement getcartIsEmpty() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p"));
	}
	
	
	public WebElement getTotalPrice() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div[2]/div[2]/table/tbody/tr[3]/td/strong/span"));
	}

	

	public List<WebElement> getProducts() {
		return driver.findElements(By.className("cart_item"));
	}



	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void deleteProductClick() {
		getDeleteButton().click();
	}
	
	
	
	
	
}
