package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement usernameInputField;
	WebElement passwordInputField;
	WebElement logInBtn;
	WebElement logOutLabel;
	WebElement errorText;
	WebElement errorMessage;
	WebElement titleLogIn;
	
	File fajl; 
	FileInputStream fis;  
	XSSFWorkbook wb;

	public WebElement getUsernameInputField() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLogInBtn() {
		return driver.findElement(By.name("login"));
	}
	
	public WebElement getLogOutLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/p[1]/a"));
	}

	
	
	public WebElement getErrorText() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/ul/li"));
	}

	
	public WebElement getErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/ul/li"));
	}
	

	public WebElement getTitleLogIn() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/h2"));
	}

	public MyAccountPage(WebDriver driver) throws IOException {
		this.driver = driver;
		this.fajl = new File("data/testPlan.xlsx");
		this.fis = new FileInputStream(fajl);
		this.wb = new XSSFWorkbook(fis);
	}
	
	public void insertUsername(String username) {
		this.getUsernameInputField().sendKeys(username);
	}
	
	public void insertPassword(String password) {
		this.getPasswordInputField().sendKeys(password);
	}
	
	public void logInButtonClik() {
		this.getLogInBtn().click();
	}
	
	public void logIn(String username, String password) {

		this.getUsernameInputField().sendKeys(username);
		this.getPasswordInputField().sendKeys(password);
		this.logInBtn.click();
	}
	
	public void successfullLogIn() {
		XSSFSheet sheet = wb.getSheet("successfullLogIn");
		XSSFRow red = sheet.getRow(3);
		XSSFCell username = red.getCell(5);
		XSSFCell password = red.getCell(6);
		System.out.print(username.getStringCellValue());
		System.out.print(password.getStringCellValue());
		
	}
	
	
	
}
