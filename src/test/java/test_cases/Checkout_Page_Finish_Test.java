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
import page.Check_out_Page_2;
import page.Checkout_Page_1;
import page.Checkout_Page_Finish;
import page.Inventory_Page_2;
import page.LoginPage;
import utility.CaptureScreenShot;

public class Checkout_Page_Finish_Test extends TestBase
{
	LoginPage login;
	Inventory_Page_2 invent;
	Cart_Page cart;
	Checkout_Page_1 check1;
	Check_out_Page_2 check2;
	Checkout_Page_Finish complete;
	
 @BeforeMethod
 public void setup() throws InterruptedException, IOException
 {
	 initialization();
 	 login=new LoginPage();
 	 invent=new Inventory_Page_2();
 	 cart=new Cart_Page();
 	 check1=new Checkout_Page_1();
 	 check2=new Check_out_Page_2();
 	 complete=new Checkout_Page_Finish();
 	 login.LoginToApplication();
 	 check1.clickyourcartBtn();
 	 cart.verifychqoutBtn();
 	 check1.inputInformation();
 	 check2.clickonfinishBtn();
 	 
	 
	 
 }
 @Test
 public void verifychqoutCompleteTest()
 {
	 String expText="Checkout: Complete!";
	 String actText=complete.verifychqoutComplete();
	 Assert.assertEquals(expText,actText);
	 Reporter.log("Verify Text Checkout Complete = " + actText);
 }
 @Test
 public void verifyimgThickMarkTest()
 {
	 boolean result=complete.verifyimgThickMark();
	 Assert.assertEquals(result,true);
	 Reporter.log("Verify Thick Mark Img = " + result);
 }
 @Test
 public void VerifythankyouTextTest()
 {
	 String expthnkyouText="Thank you for your order!";
	 String actthnkyouText=complete.VerifythankyouText();
	 Assert.assertEquals(expthnkyouText,actthnkyouText);
	 Reporter.log("Verify Thankyou Text = " + actthnkyouText);
 }
 @Test
 public void verifyyourorderTextTest()
 {
	 String expyourorderText="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
	 String actyourorderText=complete.verifyyourorderText();
	 Assert.assertEquals(expyourorderText,actyourorderText);
	 Reporter.log("Verify your order Text = " + actyourorderText);
	 
	 
 }
 @Test
 public void clickonbackhomeBtnTest()
 {
	 String ExpURL="https://www.saucedemo.com/inventory.html";
	 String actURL=complete.clickonbackhomeBtn();
	 Assert.assertEquals(ExpURL,actURL);
	 Reporter.log("Click On Backhome Button = " + actURL);
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
