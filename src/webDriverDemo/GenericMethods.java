package webDriverDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	WebDriver driver;	
	GenericMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getElement(String locator, String type){
		WebElement element ;
		if (type == "id"){
			element = driver.findElement(By.id(locator));
			System.out.println("Element found by id :" + locator);
			return element ;
		}
		else {
		     if (type == "xpath"){
		    	 element = driver.findElement(By.xpath(locator));
		    	 System.out.println("Element found by xpath" + locator);
					return element ; 
		     }
		     else{
		    	 System.out.println("No proper locator ");
		    	 return null;
		     }
		    	 
		     }
		
	}
	public List getElementList(String locator, String type){
		List<WebElement> elementList ;
		if (type == "id"){
			elementList = driver.findElements(By.id(locator));
			System.out.println("Element found by id :" + locator);
			return elementList ;
		}
		else {
		     if (type == "xpath"){
		    	 elementList = driver.findElements(By.xpath(locator));
		    	 System.out.println("Element found by xpath" + locator);
					return elementList ; 
		     }
		     else{
		    	 System.out.println("No proper locator ");
		    	 return null;
		     }
		    	 
		     }
	}
	public boolean isElementPresent(String locator, String type){
		List <WebElement> list = getElementList(locator, type);
		int size = list.size();
		if (size > 0)
		{
			
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	public WebElement waitForanElement(By locator , int timeout) 
	{  	WebElement element = null ;
		try{
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Element found in DOM");
		}catch (Exception e){
		System.out.println("Element not found in DOM");
		}
		return element;
		}
	}


