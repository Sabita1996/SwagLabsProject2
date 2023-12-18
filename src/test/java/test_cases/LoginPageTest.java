package test_cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class LoginPageTest extends TestBase
{
	 LoginPage login;
     @BeforeMethod(alwaysRun = true)
     public void setup() throws InterruptedException, IOException
     {
    	 initialization();
    	 login=new LoginPage();
     }
     @Test(priority=1,enabled=true,groups = "Sanity")
     public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
     {
    	 String expTitle=ReadData.readExcel(0,0);//Swag Labs/(0,0)
    	 String actTitle=login.verifyTitleOfApplication();
    	 Assert.assertEquals(expTitle, actTitle);
     }
     @Test(priority=2,enabled=true,groups = {"Sanity","Retesting"})
     public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
     {
    	 String ExpURL=ReadData.readExcel(0,1);//https://www.saucedemo.com/(0,1)
    	 String actURL=login.verifyURLOfApplication();
    	 Assert.assertEquals(ExpURL, actURL);
     }
     @Test(priority=3,enabled=true,groups = "Regression")
     public void LoginToApplicationTest() throws IOException
     {
    	 String expURL=ReadData.readExcel(0,2);//https://www.saucedemo.com/inventory.html/(0,2)
    	 String actURL=login.LoginToApplication();
    	 Assert.assertEquals(expURL,actURL);
     }
     @AfterMethod(alwaysRun = true)
     public void closeBrowser(ITestResult it) throws IOException
     {
    	 if(it.FAILURE==it.getStatus())
    	 {
    		CaptureScreenShot.screenshot(it.getName()); 
    	 }
    	 report.flush();
    	 driver.close();
     }
     
    	
     
     
     
     
     
     
     
     
     
     
}
