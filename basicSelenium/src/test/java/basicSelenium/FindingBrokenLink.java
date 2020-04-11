package basicSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingBrokenLink {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		driver.get("http://newtours.demoaut.com");
		
		//getting all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//getting total number of links
		int totalLink = links.size();
		System.out.println("Total links are " +totalLink);
		
		//printing total link
		for(int i=0;i<links.size();i++)
		{
			String linkURL = links.get(i).getAttribute("href");
			//System.out.println(linkURL);
			
			
			
			//setting connction to target web page 
			URL url = new URL(linkURL);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			Thread.sleep(4000);
			httpConn.connect();
			
			int resCode = httpConn.getResponseCode();
			if(resCode>=400)
			{
				System.out.println(linkURL + " " + "Brokrn Link");
			}
			else
			{
				System.out.println(linkURL + " " + "Valid Link");
			}
			
		}
		
		driver.close();
		

	}

}
