package basicSelenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		driver.get("http://popuptest.com/goodpopups.html");
		Thread.sleep(2000);
		
		//clicking on pop up window
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]")).click();
		
		//getWindowHandles method 
		Set<String> winHandler = driver.getWindowHandles();
		
		//iterating windows using Iterator 
		Iterator<String> it = winHandler.iterator();
		
		//switching to windows using .next method
		String parentWin = it.next();
		String childWin = it.next();
		
		//switching to child window and performing action
		driver.switchTo().window(childWin);
		System.out.println("Child window title is " + driver.getTitle());
		Thread.sleep(2000);
		
		//closing driver from child window
		driver.close();
		
		
		//switching to parent window and performing action
		driver.switchTo().window(parentWin);
		System.out.println("Parent window title is " + driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		
		
		
		
	}

}
