package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		// switching the frame by ID
		driver.switchTo().frame("a077aa5e");

		Thread.sleep(2000);

		//performing action in side the frame
		WebElement imgLink = driver.findElement(By.xpath("html/body/a/img"));
		highLightElementMethod(driver,imgLink);
		imgLink.click();
		Thread.sleep(2000);
		
		//Switching to default content
		driver.switchTo().defaultContent();
		
		/*
		 * driver.findElement(By.xpath("//span[@class='icon icon-xs mdi-chart-bar']")).
		 * click();
		 * 
		 * driver.findElement(By.name("email")).sendKeys("serajIslam1988@gmail.com");
		 * driver.findElement(By.name("password")).sendKeys("Test@123");
		 * Thread.sleep(3000); driver.findElement(By.
		 * xpath("//div[@class='ui fluid large blue submit button']")).click();
		 * 
		 * //Finding all iframe tags on a web page List<WebElement> frame =
		 * driver.findElements(By.tagName("iframe")); int numberOfframe = frame.size();
		 * System.out.println("No. of Iframes on this Web Page are: " +numberOfframe);
		 */

	}
	
	// Creating a custom function
		public static void highLightElementMethod(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: #90EE90; border: 4px solid orange;');",element);
		}

}
