package PageFactoryConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaHomePage {
	WebDriver driver;

	@FindBy(id = "header-logo")
	WebElement Expedialogo;
	
	@FindBy(xpath = "//a[contains(text(), 'List your property')]")
	WebElement listYourProperty;
	
	@FindBy(xpath = "//li[@id ='account-menu']/button[@id = 'header-account-menu']")
	WebElement account; 
	
	@FindBy(id="account-signin")
	WebElement login; 
	
	@FindBy(id = "account-register")
	WebElement accRegister;
	
	@FindBy(id = "header-history")
	WebElement myLists;
	
	@FindBy(id="header-itineraries")
	WebElement myTrips;
	
	@FindBy(id = "header-support-menu")
	WebElement support;
	
	@FindBy(id = "support-cs")
	WebElement customerSupport;
	
	@FindBy (id = "support-feedback")
	WebElement feedback;
	
	@FindBy (id = "header-language-2058")
	WebElement espanol;
	
	@FindBy (id = "header-language-2052")
	WebElement langChinese;
	
	@FindBy (id = "primary-header-flight")
	WebElement flights;
	
	@FindBy (id = "primary-header-hotel")
	WebElement hotels;

	@FindBy (id = "primary-header-package")
	WebElement bundlesAndSave;
	
	@FindBy (id = "primary-header-car")
	WebElement cars;
	
	@FindBy (id = "primary-header-cruise")
	WebElement cruises;
	
	@FindBy (id = "primary-header-activity")
	WebElement thingsToDO;
	
	@FindBy (id = "primary-header-vacationRental")
	WebElement vacationRentals;
	
	@FindBy (id = "primary-header-deals")
	WebElement deals;
	
	@FindBy (id = "primary-header-rewards")
	WebElement rewards;
	
	@FindBy (id = "primary-header-mobile")
	WebElement mobile;
	
	@FindBy(xpath = "//span[@class = 'symbol rtb_hotels']")
	WebElement tickSymbol1;
	
	@FindBy(xpath = "//ul[@id = 'reasons-to-believe-banner']/li[1]/span[@class ='reason']")
	WebElement tickSymbol1_text;
	
	@FindBy(xpath = "//span [@class = 'symbol rtb_lowest_price']")
	WebElement tickSymbol2;
	
	@FindBy(xpath = "//ul[@id = 'reasons-to-believe-banner']/li[2]/span[@class ='reason']")
	WebElement tickSymbol2_text;
	
	public ExpediaHomePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void headerFlightClick()
	{
		flights.click();
		System.out.println("The Flight link in Header bar is clicked");
	}
	
	public void headerHotelClick()
	{
		hotels.click();
		System.out.println("The hotel link in Header bar is clicked");
	}
	
	public void headerPackageClick()
	{
		bundlesAndSave.click();
		System.out.println("The 'Bundle And Save' link in Header bar is clicked");
	}
	
	public void headerCarsClick()
	{
		cars.click();
		System.out.println("The cars link in Header bar is clicked");
	}
	
	public void headerCruisesClick()
	{
		cruises.click();
		System.out.println("The Cruises link in Header bar is clicked");
	}
	
	public void headerActivityClick()
	{
		thingsToDO.click();
		System.out.println("The Things To Do link in Header bar is clicked");
	}
	
	public void headerVacationRentalsClick()
	{
		vacationRentals.click();
		System.out.println("The Vacation Rentals link in Header bar is clicked");
		
	}
	
	public void headerDealsClickClick()
	{
		deals.click();
		System.out.println("The Deals link in Header bar is clicked");
	}	
	
	public void headerRewardsClick()
	{
		rewards.click();
		System.out.println("The Reward link in Header bar is clicked");
	}
	
	public void headerMobileClick()
	{
		mobile.click();
		System.out.println("The Mobile link in Header bar is clicked");
	}
	
	
	
}
