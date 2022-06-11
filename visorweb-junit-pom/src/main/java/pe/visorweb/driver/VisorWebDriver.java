package pe.visorweb.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VisorWebDriver {

	public enum NavegadorWeb { FIREFOX, CHROME }
	
	public static WebDriver obtenerInstancia(NavegadorWeb navegador) {
		if (navegador == NavegadorWeb.FIREFOX) {
			return getDriverFirefox();
		}
		return getDriverChrome();
	}

	private static WebDriver getDriverChrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver getDriverFirefox() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	
}

