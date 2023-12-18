package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement yourCart;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement PageTitle;
	@FindBy(xpath = "//div[text()='QTY']") private WebElement quantityLebel;
	@FindBy(xpath = "//div[text()='Description']") private WebElement descLebel;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueBtn;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement chqoutBtn;
	@FindBy(xpath = "//div[@class='header_label']") private WebElement menuBtn;
    public Cart_Page()
    {
    	PageFactory.initElements(driver,this);
    }
    public String verifyyourCart()
    {
    	return yourCart.getText();
    }
    public String verifyPageTitle()
    {
    	return PageTitle.getText();
    }
    public String verifyquantityLebel()
    {
    	return quantityLebel.getText();
    }
    public String verifydescLebel()
    {
    	return descLebel.getText();
    }
    public String verifycontinueBtn()
    {
        continueBtn.click();
        return driver.getCurrentUrl();
    }
    public String verifychqoutBtn()
    {
    	chqoutBtn.click();
    	return driver.getCurrentUrl();
    }
    public String verifymenuBtn()
    {
         WebElement menubtn = driver.findElement(By.xpath("//div[@class='header_label"));
         menubtn.click();
         return driver.getWindowHandle();
    	
    }
    
   
    
}
