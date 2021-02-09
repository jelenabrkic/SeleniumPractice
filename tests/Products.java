package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Products extends BaseTests {
	
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}

	//@Test 
	public void addProductToCart() throws InterruptedException {
		
		String productName = citacIzExcela.getStringData("addProductToCart", 6, 3);
		
		shopPage.addToCartClick();
		Thread.sleep(2000);
		shopPage.viewCartClick();
		
		Thread.sleep(2000);
		
		String name = cartPage.getProductName().getText();
		Assert.assertEquals(name, productName);
		
	}
	
	//@Test
	public void addThreeProductsToCart() throws InterruptedException {
		
		shopPage.addThreeProducts();
		Thread.sleep(2000);
		shopPage.viewCartClick();
		Thread.sleep(2000);
		
		int numOfProducts = citacIzExcela.getIntData("addProductToCart", 8, 3);
		int numberOfElements = cartPage.getProducts().size();
		Assert.assertEquals(numberOfElements, numOfProducts);
	}
	
	
	@Test
	public void addTwoProductsToCart() throws InterruptedException {
		
		shopPage.addTwoProducts();
		shopPage.viewCartClick();
		Thread.sleep(2000);
		cartPage.deleteProductClick();
		Thread.sleep(5000);
		
		int numOfProducts = citacIzExcela.getIntData("addProductToCart", 9, 3);
		int numberOfProducts = cartPage.getProducts().size();
		Assert.assertEquals(numberOfProducts, numOfProducts);
		
	}
	
	@Test
	public void deleteProductFromCart() throws InterruptedException {
		
		String errorMessage = citacIzExcela.getStringData("deleteProductFromCart", 6, 3);
		
		mainPage.navigateToCart();
		Thread.sleep(2000);
		cartPage.deleteProductClick();
		Thread.sleep(5000);
		
		String errorText = cartPage.getcartIsEmpty().getText();
		Assert.assertEquals(errorText, errorMessage);
		
	}
	

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	
}
