package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.ShopPage;

public class BaseTests {
	
	WebDriver driver;
	MyAccountPage myAccountPage;
	MainPage mainPage;
	ExcelCitac citacIzExcela;
	CartPage cartPage;
	ShopPage shopPage;
	
	
	@BeforeClass
	public void beforeClass() throws IOException{
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		
		driver = new ChromeDriver();
		this.myAccountPage = new MyAccountPage(driver);
		this.mainPage = new MainPage(driver);
		this.shopPage = new ShopPage(driver);
		this.cartPage = new CartPage(driver);
		this.citacIzExcela = new ExcelCitac("data/testPlan.xlsx");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void afterClass() throws IOException {
		
		driver.close();
	}

}
