package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.rediff.com");
		WebElement signButton = driver.findElement(By.xpath("//a[@class='signin']"));
		highLightElementMethod(driver, signButton);
		signButton.click();

		Thread.sleep(2000);
		WebElement userNameBox = driver.findElement(By.id("login1"));
		highLightElementMethod(driver, userNameBox);
		userNameBox.sendKeys("serajislam1988@gmail.com");
		Thread.sleep(2000);

		WebElement sinButton = driver.findElement(By.name("proceed"));
		highLightElementMethod(driver, sinButton);
		sinButton.click();

		Thread.sleep(2000);

		
		//Handling alert
		Alert alert = driver.switchTo().alert();
		String actAltText = alert.getText();
		String expAltText = "Please enter your password";

		if (actAltText.equalsIgnoreCase(expAltText)) {
			System.out.println("This is correct alert text");
		} else {
			System.out.println("This is incorrect text");
		}

		driver.quit();

	}

	// Creating a custom function
	public static void highLightElementMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #90EE90; border: 4px solid orange;');",element);
	}

}
