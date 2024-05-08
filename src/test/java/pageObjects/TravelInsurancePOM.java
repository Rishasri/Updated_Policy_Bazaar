package pageObjects;

import java.time.Duration;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.List;
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

public class TravelInsurancePOM {

	WebDriver driver;
	JavascriptExecutor js;

	public TravelInsurancePOM(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="(//div[@class='shadowHandlerBox'])[7]//ancestor::a")
	WebElement travelInsurance;
	public void clickTravelInsurance() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		travelInsurance.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-row\"]")));
		//Thread.sleep(2000);
		String nextPage = driver.getTitle();
		Assert.assertEquals(nextPage, "PolicyBazaar Travel Insurance", "Not Navigated to nextPage");
		System.out.println("Navigated to Destination" );
	}

	@FindBy(xpath="//*[@id=\"input-row\"]")
	WebElement Destination;
	public void clickDestination()
	{
		js.executeScript("arguments[0].click();", Destination);
	}

//	@FindBy(xpath="//input[@id='country']")
//	WebElement country;
//	public void sndCountry()
//	{
//		Actions act=new Actions(driver);
//		act.sendKeys("United");
//		
//	}

	@FindBy(xpath="//*[text()=\"United Kingdom\"]")
	WebElement UK;
	public void clickUnitedKingdom()
	{   
		UK.click();
		String ExpectedResult = driver.findElement(By.xpath("//div[@class=\"selectedCountryWrap\"]//p")).getText();
		Assert.assertTrue(ExpectedResult.contains("United Kingdom"), "Destination is not matched");
		System.out.println("Destination Validated Successfully:" + ExpectedResult);
	}

	@FindBy(xpath="//*[text()='Next']")
	WebElement next;
	public void clickNext() throws InterruptedException
	{
		next.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class=\"pqHeading__title\"]")));
		//Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@class=\"pqHeading__title\"]")).isDisplayed());
		System.out.println("Navigated to DatePage");
	}
 
	@FindBy(xpath="(//*[contains(@class,\"MuiInputBase-input\")])[1]")
	WebElement SDate;
	public void clickDate()
	{
		SDate.click();
	}

	@FindBy(xpath="//button[@class=\"MuiButtonBase-root MuiPickersDay-root MuiPickersDateRangeDay-day MuiPickersDateRangeDay-notSelectedDate MuiPickersDateRangeDay-dayOutsideRangeInterval\"]")
	List<WebElement> dates;
	public void selectDates()
	{	    
		for(WebElement ele: dates)
		{
			String val=ele.getText();
			if(val.equalsIgnoreCase("10"))
			{
				Assert.assertTrue(ele.isEnabled());
				System.out.println("StartDate Element is clickable");
				ele.click();
			}
			else if(val.equalsIgnoreCase("30"))
			{
				Assert.assertTrue(ele.isEnabled());
				System.out.println("EndDate Element is clickable");
				ele.click();
				break;
			}			
		}
	}

	@FindBy(xpath="//button[@class=\"travel_main_cta\"]")
	WebElement next2;
	public void clickNext2()
	{
		next2.click();
		String Travellers = driver.findElement(By.xpath("//h1[text()='How many people are travelling?']")).getText();
		Assert.assertEquals(Travellers, "How many people are travelling?");
		System.out.println("Navigated to Travellers page");
	}

	@FindBy(xpath="//*[@id='traveller_2']")
	WebElement select_no_passengers;
	public void clickNoOfPersons()
	{
		js.executeScript("arguments[0].click()",select_no_passengers);
	}
	
	@FindBy(xpath="//*[@id='divarrow_undefined'][1]")
	WebElement drop_1;
	public void clickdrop_1()
	{
		drop_1.click();
	}

	@FindBy(id="22 years_undefined")
	WebElement age_22;
	public void selectAge_22() throws InterruptedException
	{
		js.executeScript("arguments[0].click()",age_22);
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"customDropdown__select  \"])[1]")));

		String ExpectedResult1 = driver.findElement(By.xpath("(//div[@class=\"customDropdown__select  \"])[1]"))
				.getText();
		Assert.assertEquals(ExpectedResult1, "22 years");
		System.out.println("Age1 Validated:" + ExpectedResult1);
	}
 
	@FindBy(xpath="(//*[@id='divarrow_undefined'])[2]")
	WebElement drop_2;
	public void clickdrop_2()
	{
		drop_2.click();
	}

	@FindBy(id="21 years_undefined")
	WebElement age_21;
	public void selectAge_21()
	{
		js.executeScript("arguments[0].click()",age_21);
		String ExpectedResult2 = driver.findElement(By.xpath("(//div[@class=\"customDropdown__select  \"])[2]"))
				.getText();
		Assert.assertEquals(ExpectedResult2, "21 years");
		System.out.println("Age2 Validated:" + ExpectedResult2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@FindBy(xpath="//button[@class=\"travel_main_cta\"]")
	WebElement next3;
	public void clickNext3()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", next3);
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'medical')]")).isDisplayed());
		System.out.println("Navigated to MedicalHistory Page");
	}

	@FindBy(xpath="//input[@id=\"ped_yes\"]")
	WebElement yes;
	public void click_yes() throws InterruptedException
	{
		yes.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"ped_yes\"]")));
		//Thread.sleep(2000);
		Assert.assertTrue(yes.isSelected());
		System.out.println("RadioButton Validated");
	}

	@FindBy(xpath="//input[@id=\"ped_yes_traveller_0\"]")
	WebElement CheckBox1;

	public void CheckBox1() {
		CheckBox1.click();
		Assert.assertTrue(CheckBox1.isSelected());
		System.out.println("Checkbox1 Validated");
	}

	@FindBy(xpath="//input[@id=\"ped_yes_traveller_1\"]")
	WebElement CheckBox2;
	public void CheckBox2() {
		CheckBox2.click();
		Assert.assertTrue(CheckBox2.isSelected());
		System.out.println("Checkbox2 Validated");
	}

	@FindBy(xpath="//button[@class=\"travel_main_cta\"]")
	WebElement next4;
	public void clickNext4() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,280)", "");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"travel_main_cta\"]")));
		Thread.sleep(2000);
		next4.click();
	}

	@FindBy(xpath="(//*[@id='mobileNumber'])")
	WebElement mob;
	public void click_mobNo()
	{
		mob.click();
	}

	public void enter_mobNo()
	{
		mob.sendKeys("9812312346");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertTrue(driver.findElement(By.xpath("(*//div[@class=\"pqCtaWrapper\"])")).isEnabled());
		System.out.println("Mobile Number Entered");
	}

	@FindBy(xpath="//*[text()='View plans']")
	WebElement view_plan;
	public void click_view_plan() throws InterruptedException
	{
		view_plan.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'plans')]")));
		//Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'plans')]")).isDisplayed());
		System.out.println("Navigated to Plans page");
	}

	@FindBy(xpath="//input[@id=\"multiTrip\"]")
	WebElement plans;
	public void plans() 
	{
		plans.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@FindBy(xpath="//input[@id=\"30_days\"]")
	WebElement days;
	public void days() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"30_days\"]")));
		Thread.sleep(2000);
		days.click();
		Assert.assertTrue(days.isSelected());
		System.out.println("Selected 30 days");
		//Thread.sleep(4000);
	}

	@FindBy(xpath="//div[@class=\"pqCtaWrapper\"]")
	WebElement apply;
	public void apply() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"pqCtaWrapper\"]")));
		apply.click();
		//WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"pqCtaWrapper\"]")));
		Thread.sleep(4000);
		Assert.assertTrue(plans.isSelected());
		System.out.println("RadioButton Validated");
	}

	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/summary")
	WebElement sort_by;
	public void select_low_to_high() throws InterruptedException
	{	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.xpath("(//*[@class='filter_name_heading'])")).click();	
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("17_sort")));
			driver.findElement(By.id("17_sort")).click();
//			Thread.sleep(2000);
//			js.executeScript("arguments[0].click()",sort_by);
//			driver.findElement(By.id("17_sort")).click();
		
	}

	@FindBy(xpath="//p[@class=\"quotesCard--insurerName\"]")
	List<WebElement>companyname;
	public void companiesName()
	{
		System.out.println("Total Number of Companies: " + companyname .size());
		for (int i = 0; i < companyname .size(); i++) {
			System.out.println(companyname .get(i).getText());
		}
	}

	@FindBy(xpath="//span[@class=\"premiumPlanPrice\"]")
	List<WebElement>prices;
	public void prices() {
		for (int i = 0; i < prices.size(); i++) {
			System.out.println(prices.get(i).getText());
		}
	}
}