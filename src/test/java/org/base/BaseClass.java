package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class  BaseClass {
	public static WebDriver driver;
	static Actions ac;
	static Robot r;
	static JavascriptExecutor js;
	static  Select s;
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	public static  void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
}
	public static void firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}
	public static  void launchUrl(String url) {
	driver.get(url);

}
	public static void maximize() {
		driver.manage().window().maximize();
		}
	public static void minimize() {
		driver.manage().window().minimize();
		
	}
	public static String getTitle() {
	String t = driver.getTitle();
	return t;

	}
	public static String pageUrl() {
		String cu = driver.getCurrentUrl();
		return cu;

	}
	public static void sendValue(WebElement element,String values) {
		element.sendKeys(values);
		
	}
	public static void click(WebElement click) {
		click.click();
	}
	public static void rightClick(WebElement target) {
		ac = new Actions(driver);
        ac.contextClick(target).perform();;
		}
	public static void doubleClick(WebElement target) {
		ac=new Actions(driver);
		ac.doubleClick(target).perform();;
		}
	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		}
	public static  void cut() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void selectAll() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);	
}
	public static void tab() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	public static void screenSHot(String filename) throws IOException {
		TakesScreenshot tk =(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest= new File("E:\\CucumberFrameWork\\Screenshot\\"+filename);
		FileUtils.copyFile(src, dest);
		}
	public static void Scrolldown(WebElement Element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", Element);

	}
	public static void Scrollup(WebElement Element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", Element);
		}
	public static void jsClick(WebElement Element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", Element);
		}
	public static void getAttribute(WebElement Element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')", Element);
	}
	public static Object getAttributeValueInConsole(WebElement Element) {
		js = (JavascriptExecutor)driver;
		Object value = js.executeScript("return arguments[0].getAttribute('value')", Element);
		System.out.println(value);
		return value;
		}
	public static void getSelectByIndex(WebElement element,int index) {
		s= new Select(element);
		s.selectByIndex(index);
		}
	public static void getSelectByValue(WebElement element,String value) {
		s= new Select(element);
		s.selectByValue(value);
		}
	public static void getSelectByVisibleText(WebElement element,String text) {
		s= new Select(element);
		s.selectByVisibleText(text);;
		}
	public static void dateAndTime() {
		Date d = new Date();
		System.out.println(d);
	}
	public static void windowHandling() {
	     String window1 = driver.getWindowHandle();
	     Set<String> window2 = driver.getWindowHandles();
	     for (String str : window2) {
	    	 if (!str.equals(window1)) {
	    		 driver.switchTo().window(str);
			}
			
		}
	}
	public static String toRead(String path,String sheetname,int row,int cell) throws IOException {
    File f = new File(path);
    FileInputStream fin = new FileInputStream(f);
    Workbook w = new XSSFWorkbook(fin);
    Sheet s = w.getSheet(sheetname);
    Row r = s.getRow(row);
    Cell c = r.getCell(cell);
    int ct = c.getCellType();
    String name;
    if (ct==1) {
    	 name = c.getStringCellValue();
		
	}
    else if (ct==0) {
    	Date dateCellValue = c.getDateCellValue();
    	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
    	 name = sdf.format(dateCellValue);
		
	}
    else {
		double numvalue = c.getNumericCellValue();
		long l=(long)numvalue;
	  name = String.valueOf(l);
    }
	return name;
	}
	public static void createnewrow(String path,String sheetname,int cell,String value) throws IOException {
		 File f = new File(path);
		    FileInputStream fin = new FileInputStream(f);
		    Workbook w = new XSSFWorkbook(fin);
		    Sheet s = w.getSheet(sheetname);
		    int newrow = s.getLastRowNum()+1;
		     Row cr = s.createRow(newrow);
		    Cell cc = cr.createCell(cell);
		    cc.setCellValue(value);
		  FileOutputStream fo = new FileOutputStream(f);
		   w.write(fo);
		  }
	
				
	}		
		   
	

	
    
	
    

	
	
