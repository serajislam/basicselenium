package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://html.com/input-type-file");
		
		//getting file upload element 
		WebElement fileUploadBox = driver.findElement(By.id("fileupload"));
		highLightElementMethod(driver,fileUploadBox);
		
		//uploading file
		fileUploadBox.sendKeys("C:\\Users\\mdsis\\Downloads\\chromedriver_win32");
		
		WebElement fileSubmitButton = driver.findElement(By.xpath("//input[@value='submit']"));
		highLightElementMethod(driver,fileSubmitButton);
		fileSubmitButton.click();
		Thread.sleep(2000);
		
		
		

	}
	
	public static void highLightElementMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #90EE90; border: 4px solid orange;');",element);
	}

}
