package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.AssertJUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class LogInTests extends BaseTests {
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}
	
	@Test (priority = 1)
	public void logIn() throws InterruptedException {
		String username = citacIzExcela.getStringData("successfullLogIn", 5, 3);
		String password = String.valueOf(citacIzExcela.getIntData("successfullLogIn", 6, 3));
		String logOutText = citacIzExcela.getStringData("successfullLogIn", 9, 3);
		
		mainPage.navigateToMyAccount();
		
		myAccountPage.getUsernameInputField().clear();
		myAccountPage.insertUsername(username);
		
		myAccountPage.getPasswordInputField().clear();
		String pass = String.valueOf(password);
		myAccountPage.insertPassword(pass);
		myAccountPage.logInButtonClik();
		
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getLogOutLabel().getText();
		Assert.assertEquals(textForAssert, logOutText);
		
	}
	
	@Test (priority = 5)
	public void logInEmptyFields() {
		
		String errorMessage = citacIzExcela.getStringData("logInEmptyFields", 9, 3);
		String usernameEmptyField = "";
		String passwordEmptyField = "";
		
		mainPage.navigateToMyAccount();
		myAccountPage.getUsernameInputField().clear();
		myAccountPage.insertUsername(usernameEmptyField);
		
		myAccountPage.getPasswordInputField().clear();
		myAccountPage.insertPassword(passwordEmptyField);
		myAccountPage.logInButtonClik();
		
		String errorText = myAccountPage.getErrorText().getText();
		Assert.assertEquals(errorText, errorMessage);
	}
	
	@Test (priority = 10)
	public void invalidLogIn() {
		String usernameWrongCredentials = citacIzExcela.getStringData("logInWithWrongCredentials", 5, 3);
		String passwordWrongCredentials = String.valueOf(citacIzExcela.getIntData("logInWithWrongCredentials", 6, 3));
		String errorMessage = citacIzExcela.getStringData("logInWithWrongCredentials", 9, 3);
		
		mainPage.navigateToMyAccount();
		
		myAccountPage.getUsernameInputField().clear();
		myAccountPage.insertUsername(usernameWrongCredentials);
		
		myAccountPage.getPasswordInputField().clear();
		myAccountPage.insertPassword(passwordWrongCredentials);

		myAccountPage.logInButtonClik();
		
		String errorMessage2 = myAccountPage.getErrorMessage().getText();
		AssertJUnit.assertEquals(errorMessage2, errorMessage );
		
	}
	
	@Test (priority = 15)
	public void logOut() throws InterruptedException {
		logIn();
		myAccountPage.getLogOutLabel().click();
		
		String title = myAccountPage.getTitleLogIn().getText();
		AssertJUnit.assertEquals(title, "Login");
		
		Thread.sleep(2000);
	}
	
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	

	
}
