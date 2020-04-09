package TestCases;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import PageFactoryConcept.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	ExpediaHomePage home;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		baseUrl = "https://www.expedia.com/";
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		home = new ExpediaHomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	
	@Test
	public void testTitle() {
		String title1 = "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
		String title = driver.getTitle();
		System.out.println("The title of Website is:" + title  );
		if (title1.equalsIgnoreCase(title)){
			System.out.println("Title correct !");
		}
		else 
		{
			System.out.println("OOPs!!! Title Incorrect");
		}
	}

	@Test
	public void testHeaderFlightTab() {
		
		
		home.headerFlightClick();
	}
	
	@Test
	public void testHeaderHotelTab() {
		
		
		home.headerHotelClick();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
