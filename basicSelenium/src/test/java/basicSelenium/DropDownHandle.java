package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public  static void main(String[]args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		driver.get("http://newtours.demoaut.com");
		
		WebElement userNameBox = driver.findElement(By.name("userName"));
		highLightElementMethod(driver,userNameBox);
		userNameBox.sendKeys("khokon");
		Thread.sleep(2000);
		
		WebElement passBox = driver.findElement(By.name("password"));
		highLightElementMethod(driver,passBox);
		passBox.sendKeys("khokon1");
		Thread.sleep(2000);
		
		WebElement signInButton = driver.findElement(By.name("login"));
		highLightElementMethod(driver,signInButton);
		signInButton.click();
		Thread.sleep(2000);
		
		//creating Select class object 
		Select passDropDown = new Select(driver.findElement(By.name("passCount")));
		//highLightElementMethod(driver, passDropDown);
		// selecting from dropdown using selectByVisibleText
		passDropDown.selectByVisibleText("2");
		Thread.sleep(2000);
		
		//creating Select class object 
		Select departFrom = new Select(driver.findElement(By.name("fromPort")));
		// selecting from dropdown using selectByValue
		departFrom.selectByValue("Frankfurt");
		Thread.sleep(2000);
		
		
		driver.quit();
	}


	public static void highLightElementMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #90EE90; border: 4px solid orange;');",element);
	}
}
