package basejava;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.util.TimeUtils;

public class BaseHRMclass {
   
	//BROWSER INFO WEBDRIVER DRIVER =NEW CHROMEDIVER();
	//URL INFO
	//USERNAME AND PASSWORD
	
	public static Properties prop= new Properties();
     public static WebDriver driver;
   
     //Step1 constructor of class 
    public BaseHRMclass() {
    	
    	try {
    	
    	FileInputStream file =new FileInputStream("C:\\Users\\15145\\eclipse-workspace\\HRmanagement\\src\\test\\java\\enviornmentvariable\\Configue.properties");
         prop.load(file);
    	}

        catch(FileNotFoundException e) {
        	e.printStackTrace();
        	}
    	catch(IOException a) {
    		a.printStackTrace();
    	}
    }
     public static void initiation() {
    	 
    	 
    String	browsername=prop.getProperty("browser");
    if(browsername.equals("Firefox")) {
    	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
    	driver=new FirefoxDriver();}
    
    	else if (browsername.equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\15145\\eclipse-workspace\\Global\\chromedriver.exe");
    		driver=new ChromeDriver();
    	}
    driver.manage().window().maximize();
    driver.get(prop.getProperty("url"));
    															
    }
     //for taking screenshot 
     public static void screenshot(String Filename) {
    	File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    	FileUtils.copyFile(file, new File("C:\\Users\\15145\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshot\\screenshot"+Filename+".jpg"));
     }
    	catch(IOException e) {
    		e.printStackTrace();
    	}
	}}
    	 
     



