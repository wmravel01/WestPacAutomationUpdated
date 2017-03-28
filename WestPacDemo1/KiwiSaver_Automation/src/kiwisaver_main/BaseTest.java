package kiwisaver_main;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {

	public static WebDriver driver;
	public static String current;
	public static File file;
	public static Properties prop;
	//static Logger log = Logger.getLogger("BaseTest");
	
	@Before
	public void openBrowser() throws IOException{
		System.out.println("Called openBrowser");
		System.setProperty("webdriver.chrome.driver",
				"\\WestPacDemo1\\KiwiSaver_Automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.westpac.co.nz/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void closeBrowser() {
		System.out.println("Browser is closed");
		driver.quit();
	}

                
}