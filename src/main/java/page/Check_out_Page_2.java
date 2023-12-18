package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Check_out_Page_2 extends TestBase
{
  @FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement checkoutLebel;
  @FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement QuantityLebel;
  @FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement descriptionLebel;
  @FindBy(xpath = "//div[text()='Payment Information']") private WebElement paymentInfo;
  @FindBy(xpath = "//div[text()='Shipping Information']") private WebElement shippingInfo;
  @FindBy(xpath = "//div[text()='Price Total']") private WebElement totalRs;
  @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']") private WebElement totalSummery;
  @FindBy(xpath = "//button[@name='cancel']") private WebElement cancelBtn;
  @FindBy(xpath = "//button[@name='finish']") private WebElement finishBtn;
  public Check_out_Page_2()
  {
	  PageFactory.initElements(driver,this);
  }
  public String verifycheckoutLebel()
  {
	  return checkoutLebel.getText();
  }
  
  public String verifyQuantityLebel()
  {
	  return QuantityLebel.getText();
  }
  public String verifydescriptionLebel()
  {
	  return descriptionLebel.getText();
  }
  public String verifypaymentInfo()
  {
	  return paymentInfo.getText();
  }
  public String verifyshippingInfo()
  {
	  return shippingInfo.getText();
  }
  public String verifytotalRs()
  {
	  return totalRs.getText();
  }
  
  public String clickoncancelBtn()
  {
	  cancelBtn.click();
	  return driver.getCurrentUrl();
  }
  public String clickonfinishBtn()
  {
	  finishBtn.click();
	  return driver.getCurrentUrl();
  }
  
  
  
}