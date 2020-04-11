package basicSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingAllLink {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.ebay.com");
		
		
		//Capturing All links 
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//Printing total number of links
		int linkSize = links.size();
		System.out.println("Total links are " +linkSize);
		
		//printing all links
		for(int i=0;i<linkSize;i++)
		{
			String linkText = links.get(i).getAttribute("href");
			
			System.out.println(linkText);
			
		}
		
		driver.close();
		
	}

}
