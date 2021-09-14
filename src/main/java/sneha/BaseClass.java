package sneha;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver initializeDriver() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\SNEHA\\Desktop\\Assignment_Selenium\\qualicoach\\src\\main\\java\\resources\\Data.properties");
			prop.load(fis);
			String browser = prop.getProperty("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SNEHA\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SNEHA\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}
	public static void scrollBy(int x,int y){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

}

