package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingErrorMessage {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.facebook.com");

		
		//Clicking forget account link
		WebElement forgAcc = driver.findElement(By.xpath("//a[contains(text(),'Forgot account?')]"));
		highLightElementMethod(driver, forgAcc);
		forgAcc.click();

		
		//Capturing error message
		WebElement msg = driver.findElement(By.xpath("//div[contains(text(),'Please enter your email or phone number to search')]"));
		highLightElementMethod(driver,msg);
		String errMsg = msg.getText();
		System.out.println(errMsg);

		//driver.quit();

	}

	public static void highLightElementMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #90EE90; border: 4px solid orange;');",element);
	}

}
