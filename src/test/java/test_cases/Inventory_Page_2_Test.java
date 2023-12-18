package test_cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.Inventory_Page_2;
import page.LoginPage;
import utility.ReadData;

public class Inventory_Page_2_Test extends TestBase
{
   LoginPage login;
   Inventory_Page_2 invent;
   @BeforeMethod(alwaysRun = true)
   public void setup() throws InterruptedException, IOException
   {
  	 initialization();
  	 login=new LoginPage();
  	 invent=new Inventory_Page_2();
  	 login.LoginToApplication();
   }
   @Test(priority=4,enabled=true,groups = "Sanity")
   public void verifyappTitleTest()
   {
	   String expTitle="Swag Labs";
	   String actTitle=invent.verifyappTitle();
	   Assert.assertEquals(expTitle,actTitle);
	   Reporter.log("Title Of Inventory Page = " + actTitle);
   }
   @Test(priority=5,enabled=true,groups = "Retesting")
 public void verifytwitterLogoTest()
 {
	 boolean result=invent.verifytwitterLogo();
	 Assert.assertEquals(result,true);
	 Reporter.log("Visibility Of Twitter Logo = " + result);
 }
 @Test(priority=6,enabled=true,groups = {"Retesting","Regression"})
 public void verifyproductsTitleTest() throws EncryptedDocumentException, IOException
 {
	 String expProductTitle=ReadData.readExcel(0,3);//Products(0,3)
	 String actProductTitle=invent.verifyproductsTitle();
	 Assert.assertEquals(expProductTitle,actProductTitle);
	 Reporter.log("Title Of Products = " + actProductTitle);
 }
 @Test(priority=7,enabled=true,groups = {"Retesting","Regression"})
 public void verifyfooterTextTest()
 {
	 String expFooterName="© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
	 String actFooterName=invent.verifyfooterText();
	 Assert.assertEquals(expFooterName,actFooterName);
	 Reporter.log("Visibility of footer Text = " + actFooterName);
 }
 @Test
 public void verifyfacebookLogoTest()
 {
	 boolean result=invent.verifyfacebookLogo();
	 Assert.assertEquals(result,true);
	 Reporter.log("Visibility Of Facebook Logo = " + result);
 }
 @Test
 public void verifylinkdinLogo()
 {
	 boolean result=invent.verifylinkdinLogo();
	 Assert.assertEquals(result,true);
	 Reporter.log("Visibility of linkdin Logo = " + result);
 }
 @Test
 public void add6ProductsTest() throws EncryptedDocumentException, IOException
 {
	 String expcount=ReadData.readExcel(0,4);//6(0,4)
	 String actcount=invent.add6Products();
	 Assert.assertEquals(expcount,actcount);
	 Reporter.log("Total Products Added To Cart = " + actcount);
 }
 @Test
 public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
 {
	 String expcount=ReadData.readExcel(0,5);//4(0,5)
	 String actcount=invent.remove2Products();
	 Assert.assertEquals(expcount,actcount);
	 Reporter.log("Count Of Product After Removing = " + actcount);
 }
 
   
   @AfterMethod(alwaysRun = true)
   public void closeBrowser()
   {
  	 driver.close();
   }
	
}
