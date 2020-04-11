package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibility {

	public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("http://www.testdiary.com/training/selenium/selenium-test-page");
			
			
			 //isDisplayed() method returns boolean value either True or False
			 boolean isDisplayMethood = driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).isDisplayed();
			System.out.println("Element displayed  methood is " + isDisplayMethood);
			
			
			
			 //isEnabled() method returns boolean value either True or False
			boolean isEnabledMethod = driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).isEnabled();
			System.out.println("Element enabled method is " +isEnabledMethod);
			
			
			//isSelected() method returns boolean value either True or False
			
			WebElement selBox = driver.findElement(By.id("seleniumbox"));
			
			boolean isSelectedMethsod = selBox.isSelected();
			
			if(isSelectedMethsod == false)
			{
				selBox.click();
				
				System.out.println("Box is selected");
			}
			else
			{
				System.out.println("Box was selected by default");
			}
			
			driver.close();
			
			
			

	}
	
}
