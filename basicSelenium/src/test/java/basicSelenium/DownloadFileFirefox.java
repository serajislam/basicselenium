package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileFirefox {

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference( "pdfjs.disabled", true );
		
		FirefoxOptions option =new FirefoxOptions();
		option.setProfile(profile);
		
		
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver(option);
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
		
		driver.close();
		

	}

}
