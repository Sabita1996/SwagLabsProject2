package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page_1 extends TestBase
{
     @FindBy(xpath = "//span[@class='title']") private WebElement titleOfCheckoutBtn;
     @FindBy(xpath = "//input[@name='firstName']") private WebElement firstNameTextBox;
     @FindBy(xpath = "//input[@name='lastName']") private WebElement lastNameTextBox;
     @FindBy(xpath = "//input[@name='postalCode']") private WebElement zipCodeTextBox;
     @FindBy(xpath = "//input[@name='continue']") private WebElement continueBtn;
     @FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement clickyourcartBtn;
     @FindBy(xpath = "//div[text()='Description']") private WebElement descText;
     public Checkout_Page_1()
     {
    	 PageFactory.initElements(driver, this);
     }
     public String verifyURLOfCheckout_Page_1()
     {
    	 return driver.getCurrentUrl();//https://www.saucedemo.com/checkout-step-two.html
     }
     public String verifytitleOfCheckoutBtn()
     {
    	 return titleOfCheckoutBtn.getText();
     }
     public String clickyourcartBtn()
     {
    	 clickyourcartBtn.click();
    	 return driver.getCurrentUrl();
     }
     
     public String inputInformation()
     {
    	 firstNameTextBox.sendKeys("Sabita");
    	 lastNameTextBox.sendKeys("Chakraborty");
    	 zipCodeTextBox.sendKeys("751006");
    	 continueBtn.click();
    	 return driver.getCurrentUrl();
    	 
     }
     
     
}
