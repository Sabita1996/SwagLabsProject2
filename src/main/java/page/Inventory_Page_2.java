package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.Handle_Dropdown_List;

public class Inventory_Page_2 extends TestBase
{
	//Object Repository
	
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appTitle;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement addToCart;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy(xpath = "//span[@class='title']") private WebElement productsTitle;
	//Element added
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikelightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement tshirtRedProduct;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkdinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	//Element remove
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackproduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikelightproduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeboltTShirtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removefleeceJacketProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeonesieProduct;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removetshirtRedProduct;
	//constructor
	public Inventory_Page_2()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyappTitle()
	{
		return appTitle.getText();
	}
	public String add6Products()
	{
		Handle_Dropdown_List.handleSelectClass(dropDown,"Price (low to high)");
		backpackProduct.click();
		bikelightProduct.click();
		boltTShirtProduct.click();
		fleeceJacketProduct.click();
		onesieProduct.click();
		tshirtRedProduct.click();
		return cartCount.getText();
	}
	public String remove2Products() throws InterruptedException
	{
		add6Products();
		Thread.sleep(3000);
		removebackpackproduct.click();
		removebikelightproduct.click();
		return cartCount.getText();
		
	}
	public boolean verifytwitterLogo()
	{
	    return twitterLogo.isDisplayed();
	}
	public boolean verifyfacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifylinkdinLogo()
	{
		return linkdinLogo.isDisplayed();
	}
	
	public String verifyproductsTitle()
	{
		return productsTitle.getText();
	}
	public String verifyfooterText()
	{
		return footerText.getText();
	}
	
}
