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
import page.Inventory_Page_2;
import page.LoginPage;
import utility.CaptureScreenShot;

public class Check_out_Page_2_Test extends TestBase
{
	LoginPage login;
	Inventory_Page_2 invent;
	Cart_Page cart;
	Checkout_Page_1 check1;
	Check_out_Page_2 check2;
	
@BeforeMethod(alwaysRun = true)
public void setup() throws IOException, InterruptedException 
{
	initialization();
 	 login=new LoginPage();
 	 invent=new Inventory_Page_2();
 	 cart=new Cart_Page();
 	 check1=new Checkout_Page_1();
 	 check2=new Check_out_Page_2();
 	 login.LoginToApplication();
 	 check1.clickyourcartBtn();
 	 cart.verifychqoutBtn();
 	 check1.inputInformation();
	  
} 
@Test
public void verifycheckoutLebelTest()
{
	String expchechoutLbl="Checkout: Overview";
	String actcheckoutLbl=check2.verifycheckoutLebel();
	Assert.assertEquals(expchechoutLbl,actcheckoutLbl);
	Reporter.log("Verify Checkout Text = " + actcheckoutLbl);
}
@Test
public void verifyQuantityLebelTest()
{
	String expqtyLebel="QTY";
	String actqtyLebel=check2.verifyQuantityLebel();
	Assert.assertEquals(expqtyLebel,actqtyLebel);
	Reporter.log("Verify Quantity Lebel = " + actqtyLebel);
}
@Test
public void verifydescriptionLebelTest()
{
	String expdescLebel="Description";
	String actdescLebel=check2.verifydescriptionLebel();
	Assert.assertEquals(expdescLebel,actdescLebel);
	Reporter.log("Verify Description Lebel = " + actdescLebel);
}
@Test
public void verifypaymentInfoTest()
{
	String exppaymentInfo="Payment Information";
	String actpaymentInfo=check2.verifypaymentInfo();
	Assert.assertEquals(exppaymentInfo,actpaymentInfo);
	Reporter.log("Verify Payment Information = " + actpaymentInfo);
}
@Test
public void verifyshippingInfoTest()
{
	String expshippingInfo="Shipping Information";
	String actshippingInfo=check2.verifyshippingInfo();
	Assert.assertEquals(expshippingInfo,actshippingInfo);
	Reporter.log("Verify Shipping Information = " + actshippingInfo);
}
@Test
public void verifytotalRsTest()
{
	String exptotal="Price Total";
	String acttotal=check2.verifytotalRs();
	Assert.assertEquals(exptotal,acttotal);
	Reporter.log("Verify Total Price = " + acttotal);
}
@Test
public void verifyclickoncancelBtnTest()
{
	String expURL="https://www.saucedemo.com/inventory.html";
	String actURL=check2.clickoncancelBtn();
	Assert.assertEquals(expURL,actURL);
	Reporter.log("Verify Click On Cancel Button = " + actURL);
}
@Test
public void verifyclickonfinishBtnTest()
{
	String expURL1="https://www.saucedemo.com/checkout-complete.html";
	String actURL1=check2.clickonfinishBtn();
	Assert.assertEquals(expURL1,actURL1);
	Reporter.log("Verify Click On Finish Button = " + actURL1);
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

