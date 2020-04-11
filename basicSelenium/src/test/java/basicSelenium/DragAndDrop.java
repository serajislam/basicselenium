package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://jqueryui.com");
		Thread.sleep(2000);

		//clicking  droppable content 
		WebElement droppable = driver.findElement(By.xpath("//a[contains(text(),'Droppable')]"));
		highLightElementMethod(driver, droppable);
		droppable.click();

		Thread.sleep(2000);

		
		//switching to iframe
		driver.switchTo().frame(0);
		// creating Actions class object 
		Actions action = new Actions(driver);
		
		//Dragging and dropping to destination location
		action.clickAndHold(driver.findElement(By.id("draggable")))
		.moveToElement(driver.findElement(By.id("droppable"))).release().perform();

		Thread.sleep(2000);

		//switching driver to default content
		driver.switchTo().defaultContent();
		WebElement datePicker = driver.findElement(By.xpath("//a[contains(text(),'Datepicker')]"));
		highLightElementMethod(driver, datePicker);
		datePicker.click();
		Thread.sleep(2000);

	}

	public static void highLightElementMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: #90EE90; border: 4px solid orange;');",
				element);
	}

}
