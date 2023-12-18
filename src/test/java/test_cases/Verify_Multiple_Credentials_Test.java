package test_cases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import page.LoginPage;
import utility.CaptureScreenShot;

public class Verify_Multiple_Credentials_Test extends TestBase
{
	LoginPage login;
    @BeforeMethod(alwaysRun = true)
    public void setup() throws InterruptedException, IOException
    {
    	initialization();
    	login=new LoginPage();
    }
    @DataProvider(name="credentials")
    public Object[][] getData()
    {
    	return new Object[][]
    			{
    		         {"standard_user","secret_sauce"},//Corr Ur/Corr Pass
    		         //{"standard_user1","secret_sauce"},//inCorr Ur/Corr Pass
    		         //{"standard_user","secret_sauce1"},//Corr Ur/inCorr Pass
    		         //{"standard_user1","secret_sauce1"}//inCorr Ur/inCorr Pass
    		         
    			};
    			 //{"locked_out_user","secret_sauce"},
		         //{"problem_user","secret_sauce"},
		        // {"performance_glitch_user","secret_sauce"},
		         //{"error_user","secret_sauce"},
		        // {"visual_user","secret_sauce"}
    			//correct id correct password
    			//incorrect id correct password
    			//correct id incorrect password
    			//incorrect id incorrect password
		         
		         
    }
    @Test(dataProvider = "credentials")
    public void loginToAppWithMultiCredsTest(String un,String pass)
    {
    	SoftAssert s=new SoftAssert();
    	String expURL="https://www.saucedemo.com/inventory.html";
    	String actURL=login.loginToAppWithMultiCreds(un, pass);
    	s.assertEquals(expURL, actURL);
    	s.assertAll();
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
