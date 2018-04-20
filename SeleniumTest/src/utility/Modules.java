package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Modules {
	public static HSSFWorkbook wb;
	public static WebDriver driver;
	
	public static WebDriver launchBrowser(String name){
		System.setProperty("webdriver.firefox.bin","C:/Program Files/Mozilla Firefox53/firefox.exe");
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","./src/utility/geckodriver.exe");
		driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","./src/utility/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(name.equalsIgnoreCase("ie")){
			System.out.println("ie entered");
			System.setProperty("webdriver.ie.driver","./src/utility/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
	}

	public static void closeBrowser(WebDriver driver){
		try{
			driver.quit();
		}
		catch(Exception e){
			
		}
	}


		
		public static WebDriver LogintoXero(WebDriver driver) throws InterruptedException{
			driver.get("https://login.xero.com/");

			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("samjot2012@gmail.com");
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("SAMjot1995");
			
			driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
			Thread.sleep(6000);
			
			String homeTiltle=driver.getTitle();
			if(homeTiltle.contains("tekarch"))
				System.out.println("home page verified");
			else
				System.out.println("home page is not verified");
			return driver;
		
		
	}
		public static WebDriver LogintoXero(WebDriver driver,String id,String password,boolean remember) throws InterruptedException{
			driver.get("https://login.xero.com/");
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(id);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
			
			driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
			Thread.sleep(6000);
			return driver;
			
		}
		
		
		
		public static WebDriver IncorrectPass(WebDriver driver) throws InterruptedException{
			driver.get("https://login.xero.com/");

			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("samjot2012@gmail.com");
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Samjot1995");
			driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
			
			String newAccountText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
			if(newAccountText.equalsIgnoreCase("Your email or password is incorrect"))
				System.out.println(" error message verified");
			else
				System.out.println("couldnt verify error message");
			return driver;
		
		
	}
		public static WebDriver IncorrectPass(WebDriver driver,String id,String password,boolean remember) throws InterruptedException{
			driver.get("https://login.xero.com/");
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(id);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
			
			driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
			Thread.sleep(6000);
			return driver;
		}
			
		public static WebDriver TabsTest(WebDriver driver) throws InterruptedException{
			driver.get("https://login.xero.com/");

			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("samjot2012@gmail.com");
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("SAMjot1995");
			
			driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(".//*[@id='Reports']")).click();
			driver.findElement(By.xpath(".//*[@id='Contacts']")).click();
			driver.findElement(By.xpath(".//*[@id='Settings']")).click();
			driver.findElement(By.xpath(".//*[@id='quicklaunchTab']")).click();
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a")).click();
			
			String newAccountTexts=driver.findElement(By.xpath(".//*[@id='rt']/div[1]/h3")).getText();
			if(newAccountTexts.equalsIgnoreCase("Help"))
				System.out.println(" all tabs verified");
			else
				System.out.println("couldnt verify all tabs");
			return driver;
		
		
	}
		public static WebDriver TabsTest(WebDriver driver,String id,String password,boolean remember) throws InterruptedException{
			driver.get("https://login.xero.com/");
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(id);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
			
			driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
			driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(".//*[@id='Reports']")).click();
			driver.findElement(By.xpath(".//*[@id='Contacts']")).click();
			driver.findElement(By.xpath(".//*[@id='Settings']")).click();
			driver.findElement(By.xpath(".//*[@id='quicklaunchTab']")).click();
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a")).click();
			Thread.sleep(6000);
			return driver;
			
		}
	
	public static String[][] readXlSheet(String link,String sheetName) throws IOException{
		FileInputStream fio=new FileInputStream(new File(link));
		wb=new HSSFWorkbook(fio);
		HSSFSheet sheet=wb.getSheet(sheetName);
		int trow=sheet.getLastRowNum()+1;
		int tcol=sheet.getRow(0).getLastCellNum();
		String[][] s = new String[trow][tcol];
		System.out.println("total rows="+trow+" and total column="+tcol);
		for(int i=0;i<trow;i++){
			for(int j=0;j<tcol;j++){
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC)
					s[i][j]=String.valueOf((int)sheet.getRow(i).getCell(j).getNumericCellValue());
				else
				s[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();	
		
			}
		}
		
		return s;
	}
	
	public static void writeXlSheet(String link, String sheetName,String text,int row,int col) throws IOException {
		File f=new File(link);
		FileInputStream fio=new FileInputStream(f);
		HSSFWorkbook wb=new HSSFWorkbook(fio);
		HSSFSheet sheet=wb.getSheet(sheetName);
		sheet.getRow(row).getCell(col).setCellValue(text);
		FileOutputStream fop=new FileOutputStream(f);
		wb.write(fop);
		fop.flush();
		fop.close();
		}
	
	
	public static void setXlColorStyle(String link,String sheetName,int iRow,int iCol,String status) throws IOException{
		File f=new File(link);
		FileInputStream fio=new FileInputStream(f);
		HSSFWorkbook wb=new HSSFWorkbook(fio);
		HSSFSheet sheet=wb.getSheet(sheetName);
		
		
		HSSFRow row = sheet.getRow(iRow);
		HSSFCell cell = row.getCell(iCol);
		
		if(status.equalsIgnoreCase("pass"))
			fillBackgroundColor(wb, "green", cell);
		else
			fillBackgroundColor(wb, "red", cell);
		
		FileOutputStream fop=new FileOutputStream(f);
		wb.write(fop);
		fop.flush();
		fop.close();
		}
	public static void fillBackgroundColor(HSSFWorkbook wb,String color,HSSFCell cell){
		HSSFCellStyle style=(HSSFCellStyle) wb.createCellStyle();
		if(color.equalsIgnoreCase("green")){
			style.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			}
		else if(color.equalsIgnoreCase("red")){
			style.setFillForegroundColor(new HSSFColor.RED().getIndex());
			}
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
	}
	
	
	public static String CaptureScreen(WebDriver driver,String name) throws IOException{
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest="./Screenshots/"+name+".png";
		FileUtils.copyFile(src, new File(dest));
		return dest;
	}
}