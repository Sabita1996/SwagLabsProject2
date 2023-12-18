package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page_Finish extends TestBase
{
  @FindBy(xpath = "//span[text()='Checkout: Complete!']") private WebElement chqoutComplete;
  @FindBy(xpath = "//img[@alt='Pony Express']") private WebElement imgThickMark;
  @FindBy(xpath = "//h2[text()='Thank you for your order!']") private WebElement thankyouText;
  @FindBy(xpath = "//div[@class='complete-text']") private WebElement yourorderText;
  @FindBy(xpath = "//button[text()='Back Home']") private WebElement backhomeBtn;

 public  Checkout_Page_Finish()
 {
	 PageFactory.initElements(driver,this);
 }
 public String verifychqoutComplete()
 {
	 return chqoutComplete.getText();
 }
 public boolean verifyimgThickMark()
 {
	 return imgThickMark.isDisplayed();
 }
 public String VerifythankyouText()
 {
	 return thankyouText.getText();
 }
 public String verifyyourorderText()
 {
	 return yourorderText.getText();
 }
 public String clickonbackhomeBtn()
 {
	 backhomeBtn.click();
	 return driver.getCurrentUrl();
 }
 
  
  
}
