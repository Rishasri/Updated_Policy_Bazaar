package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CarInsurancePOM {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	public CarInsurancePOM(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()=\"Policybazaar\"]")
	WebElement go_To_home;
	public void click_policy_bazaar_logo()
	{
		js.executeScript("arguments[0].click()", go_To_home);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

    @FindBy(xpath="//i[@class=\"arrow\"]")
    WebElement InsuranceProduct;
    public void insuranceproduct() 
    {
    	InsuranceProduct.click();
    }

    @FindBy(xpath="//a[text()=\"Car Insurance\"]")
    WebElement CarInsurance;
    public void carinsurance()
    {
    	CarInsurance.click();
    	String Title = driver.getTitle();
		Assert.assertEquals(Title, "Car Insurance Online - Buy/Renew Car Insurance Policy & Save Upto 85%*");
		System.out.println("Navigated Successfully");
    }

    @FindBy(xpath="//span[text()=\"car? Click here\"]")
    WebElement clickhere;
    public void Clickhere() 
    {
    	JavascriptExecutor js24 = (JavascriptExecutor) driver;
		js24.executeScript("arguments[0].click()", clickhere);
		String next = driver.findElement(By.xpath("//span[text()='Select City & RTO']")).getText();
		Assert.assertEquals(next, "Select City & RTO", "Not Navigated to citypage");
		System.out.println("Navigated to Citypage");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @FindBy(xpath="//div[text()=\"Chennai \"]")
    WebElement city;
    public void city() throws InterruptedException 
    {
    	js.executeScript("arguments[0].click()",city);
		//Thread.sleep(2000);
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Chennai ']/following-sibling::div")));
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Chennai ']/following-sibling::div")).isDisplayed(),
				"Not Selected City");
		System.out.println("Selected City");
    }

    @FindBy(xpath="//label[@data-id=\"903\"]")
    WebElement rto;
    public void rto() throws InterruptedException 
    {
    	js.executeScript("arguments[0].click()",rto);
//    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Select Car Brand']")));
		Thread.sleep(2000);
		String next2 = driver.findElement(By.xpath("//span[text()='Select Car Brand']")).getText();
		Assert.assertEquals(next2, "Select Car Brand", "Not selected RTO");
		System.out.println("Selected RTO");
    }

    @FindBy(xpath="(//label[@data-id=\"33\"])[1]")
    WebElement brand;
    public void brand()  
    {
    	brand.click();
    }

    @FindBy(xpath="//label[@data-id=\"222\"]")
    WebElement model;
    public void model()
    {
    	model.click();
    	String Model = driver.findElement(By.xpath("//span[text()='Select Car Fuel Type']")).getText();
		Assert.assertEquals(Model, "Select Car Fuel Type", "Not Selected Model");
		System.out.println("Selected Model");
    }

    @FindBy(xpath="//span[text()=\"Petrol\"]")
    WebElement Fuel;
    public void Fuel() throws InterruptedException 
    {
    	Fuel.click();
    }

    @FindBy(xpath="//span[text()=\"Delta AMT\"][@class=\"text\"]")
    WebElement variant;
    public void variant() throws InterruptedException 
    {
    	Assert.assertTrue(variant.isDisplayed());
		variant.click();
    }

    @FindBy(xpath="//input[@id =\"txtName\"]")
    WebElement name;
    public void name() 
    {
    	name.sendKeys("1$a");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Please enter character only']")).isDisplayed());
		System.out.println("Error Message:Please enter character only");
    }

    @FindBy(xpath="//input[@id =\"txtEmail\"]")
    WebElement email;
    public void email() 
    {
    	email.sendKeys("abc");
    	Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[text()='Please enter valid email address']")).isDisplayed());
		System.out.println("Error Message:Please enter valid email address");
    }

    @FindBy(xpath="//input[@type=\"tel\"]")
    WebElement Mobilenum;
    public void mobnum() 
    {
    	Mobilenum.sendKeys("");
    	Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Please enter mobile number']")).isDisplayed());
		System.out.println("Error Message:Please enter mobile number");
    }

    @FindBy(xpath="//div[@class=\"button btnOrange\"][text()=\"View Prices \"]")
    WebElement viewprice;
    public void viewprice() 
    {
    	viewprice.click();
    }
}