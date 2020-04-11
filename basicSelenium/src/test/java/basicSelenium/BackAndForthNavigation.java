package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Launching a site
		driver.get("https://www.amazon.com");
		System.out.println("Amazon title is " + driver.getTitle());
		Thread.sleep(3000);
		
		//Navigating a site
		driver.navigate().to("https://www.ebay.com");
		System.out.println("Ebay title is " + driver.getTitle());
		Thread.sleep(3000);
		
		//Navigating back it should go to amazon
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		
		//Navigating forward it should go to ebay
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		//refreshing a site it should refresh ebay 
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		driver.close();
		
		

	}
	
	public static void highLightElementMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #90EE90; border: 4px solid orange;');",element);
	}

}
