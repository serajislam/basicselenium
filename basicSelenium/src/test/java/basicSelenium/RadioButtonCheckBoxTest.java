package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonCheckBoxTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.testdiary.com/training/selenium/selenium-test-page");
		
		
		//Radio Button test
		WebElement javaRadioButton  = driver.findElement(By.id("java1"));
		boolean radionButtonBefClick = javaRadioButton.isSelected();
		System.out.println("Before radion button select status " +radionButtonBefClick);
		Thread.sleep(2000);
		
		javaRadioButton.click();
		boolean radionButtonAftClick = javaRadioButton.isSelected();
		System.out.println("After radion button select status " +radionButtonAftClick);
		Thread.sleep(2000);
		
		
		//Check box test 
		WebElement selCheckBox = driver.findElement(By.xpath("//input[@id='seleniumbox']"));
		boolean chkBoxBefClick = selCheckBox.isSelected();
		System.out.println("Before check box click status is " +chkBoxBefClick);
		Thread.sleep(2000);
		
		
		selCheckBox.click();
		boolean chkBoxAftClick = selCheckBox.isSelected();
		System.out.println("After check box click status is " +chkBoxAftClick);
		Thread.sleep(2000);
		
		driver.close();
		
		
		

	}

}
