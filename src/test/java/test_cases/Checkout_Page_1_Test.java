package test_cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.Cart_Page;
import page.Checkout_Page_1;
import page.Inventory_Page_2;
import page.LoginPage;
import utility.CaptureScreenShot;

public class Checkout_Page_1_Test extends TestBase
{
	public class Cart_Page_Test extends TestBase
	{
		LoginPage login;
		Inventory_Page_2 invent;
		Cart_Page cart;
		Checkout_Page_1 check1;
   @BeforeMethod
   public void setup() throws InterruptedException, IOException
   {
  	 initialization();
  	 login=new LoginPage();
  	 invent=new Inventory_Page_2();
  	 cart=new Cart_Page();
  	 check1=new Checkout_Page_1();
  	 login.LoginToApplication();
  	 check1.clickyourcartBtn();
  	 cart.verifyyourCart();
  	 cart.verifychqoutBtn();
  	 
  	 
  	 
   }
   @Test
   public void verifyURLOfCheckout_Page_1Test()
   {
	   String expURL="https://www.saucedemo.com/checkout-step-one.html";
	   String actURL=check1.verifyURLOfCheckout_Page_1();
	   Assert.assertEquals(expURL,actURL);
	   Reporter.log("Verification Of Chqout page = " + actURL);
   }
   @Test
   public void verifytitleOfCheckoutBtnTest()
   {
	   String expTitle="Checkout: Your Information";
	   String actTitle=check1.verifytitleOfCheckoutBtn();
	   Assert.assertEquals(expTitle,actTitle);
	   Reporter.log("Verification of Title = " + actTitle);
   }
   @Test
   public void inputInformationTest()
   {
	   String expURL="https://www.saucedemo.com/checkout-step-two.html";
	   String actURL=check1.inputInformation();
	   Assert.assertEquals(expURL, actURL);
	   Reporter.log("Title Of Checkout Page = " + actURL);
   }
   
   
   
   
   @AfterMethod
   public void closeBrowser(ITestResult it) throws IOException
   {
  	 if(it.FAILURE==it.getStatus())
  	 {
  		CaptureScreenShot.screenshot(it.getName()); 
  	 }
  	 driver.close();
   }
	}
}
