package basicSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadingDataFromExcelFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		ReadingDataFromExcelFile exr = new ReadingDataFromExcelFile();
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://newtours.demoaut.com/");
		
		//reading column from excel
		ArrayList <String>userName = exr.excelReader(0);
		ArrayList <String>password = exr.excelReader(1);
		
		for(int i=0;i<userName.size();i++)
		{
			
			driver.findElement(By.name("userName")).sendKeys(userName.get(i));
			driver.findElement(By.name("password")).sendKeys(password.get(i));
			driver.findElement(By.name("login")).click();
			
			
			// explicit wait
			WebDriverWait expWait = new WebDriverWait(driver,20);
			expWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'SIGN-OFF')]")));
			driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
			
		}
		
		driver.quit();
		
	}
	
	//generic method to read data from excel
	public ArrayList<String> excelReader(int colNum) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\\\Data\\\\credentials.xls");
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheet("credentials");
		Iterator<Row> it = sh.iterator();
		it.next();
		ArrayList<String> list = new ArrayList<String>();
		
		while(it.hasNext())
		{
			list.add(it.next().getCell(colNum).getStringCellValue());
		}
		
		//System.out.println(list);
		return list;
		
		
		
	}
	
	
	
	/*
	 * Method for how read data from excel 
	public void excelReader(int colNum) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\\\Data\\\\credentials.xls");
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheet("credentials");
		Iterator<Row> it = sh.iterator();
		it.next();
		ArrayList<String> list = new ArrayList<String>();
		
		while(it.hasNext())
		{
			list.add(it.next().getCell(colNum).getStringCellValue());
		}
		
		System.out.println(list);
		
		
		
	}
	*/
	
	
	

	//FileInputStream fis = new FileInputStream(".\\Data\\credentials.xls");
	//HSSFWorkbook wb = new HSSFWorkbook(fis);
	//HSSFSheet sh = wb.getSheet("credentials");
	
	
	
	//First Approach
	/*Iterator <Row> rowIt = sh.iterator();
	 
	//To skip header 
	rowIt.next();
	
	while(rowIt.hasNext())
	{
		System.out.println(rowIt.next().getCell(0).getStringCellValue());
		
	}
	*/
	
	

	/*
	//2nd Approach 
	int rowSize = sh.getLastRowNum();
	//System.out.println(rowSize);
	
	for(int i=0;i<=rowSize;i++)
	{
		HSSFRow row = sh.getRow(i);
		System.out.println(row.getCell(0).toString());
		//System.out.println(row.getCell(1).toString());
	}
	*/

}
