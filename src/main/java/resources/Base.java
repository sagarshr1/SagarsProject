package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	public WebDriver driver;
	public Properties prop;
	
public WebDriver initializeDriver() throws IOException {
	
	
	
	FileInputStream fis = new FileInputStream("D:\\SeleniumWorkPlace\\E2EAutomation\\src\\main\\java\\resources\\config.properties");
	prop = new Properties();
	prop.load(fis);
	String browser = prop.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver","d://geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver","d://IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
		
	
}

public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts = ((TakesScreenshot) driver);
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destinationFile));
	
	
}


}
