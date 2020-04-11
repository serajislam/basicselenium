package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFileChrome {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		//entering a text
		driver.findElement(By.id("textbox")).sendKeys("I am text file");
		Thread.sleep(2000);
		
		//enabling download button by clicking Generate File
		driver.findElement(By.id("createTxt")).click();
		Thread.sleep(2000);
		
		// downloading file
		driver.findElement(By.id("link-to-download")).click();
		Thread.sleep(2000);
		
		//entering a text
		driver.findElement(By.id("pdfbox")).sendKeys("I am PDF file");
		Thread.sleep(2000);
		
		//enabling download button by clicking Generate File
		driver.findElement(By.id("createPdf")).click();
		Thread.sleep(2000);
		
		// downloading file
		driver.findElement(By.id("pdf-link-to-download")).click();
		Thread.sleep(2000);
		

	}

}
