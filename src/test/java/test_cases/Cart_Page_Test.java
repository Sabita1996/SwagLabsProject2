package test_cases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.Cart_Page;
import page.Inventory_Page_2;
import page.LoginPage;
import utility.CaptureScreenShot;

public class Cart_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page_2 invent;
	Cart_Page cart;

  @BeforeMethod(alwaysRun = true)
  public void setup() throws InterruptedException, IOException
  {
 	 initialization();
 	 login=new LoginPage();
 	 invent=new Inventory_Page_2();
 	 cart=new Cart_Page();
 	 login.LoginToApplication();
 	 WebElement addToCartBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	 addToCartBtn.click();
 	 
  }
  
  @Test
  public void verifyyourCartTest()
  {
	  String expYourCart="Your Cart";
	  String actYourCart=cart.verifyyourCart();
	  Assert.assertEquals(expYourCart,actYourCart);
	  Reporter.log("Your cart Title in cart page = " + actYourCart);
			  
  }
  @Test
  public void verifyappTitleTest()
  
  {
	   String expTitle="Swag Labs";
	   String actTitle=cart.verifyPageTitle();
	   Assert.assertEquals(expTitle,actTitle);
	   Reporter.log("Title of cart page = " + actTitle);

  }
  @Test
  public void verifyquantityLebelTest()
  {
	  String expqtyLebel="QTY";
	  String actqtyLebel=cart.verifyquantityLebel();
	  Assert.assertEquals(expqtyLebel,actqtyLebel);
	  Reporter.log("Visibility of QTY Lebel = " + actqtyLebel);
  }
  @Test      
  public void verifydescLebelTest()
  {
	  String expDescLebel="Description";
	  String actDescLebel=cart.verifydescLebel();
	  Assert.assertEquals(expDescLebel,actDescLebel);
	  Reporter.log("Visibility of Description Lebel = " + actDescLebel);
  }
  @Test
  public void continueBtnTest()
  {
	  String expURL="https://www.saucedemo.com/inventory.html";
	  String actURL=cart.verifycontinueBtn();
	  Assert.assertEquals(expURL,actURL);
	  Reporter.log("Verify Continue Button = " + actURL);
	  
  }
  @Test
  public void chqoutBtnTest()
  {
	  String expURL1="https://www.saucedemo.com/checkout-step-one.html";
	  String actURL1=cart.verifychqoutBtn();
	  Assert.assertEquals(expURL1,actURL1);
	  Reporter.log("Verify Check OutBtn = " + actURL1);
	  
	  
  }
  
  
  @AfterMethod(alwaysRun = true)
  public void closeBrowser(ITestResult it) throws IOException
  {
 	 if(it.FAILURE==it.getStatus())
 	 {
 		CaptureScreenShot.screenshot(it.getName()); 
 	 }
 	 driver.close();
  }
  
}
