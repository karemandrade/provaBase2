package pageObject;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigPage {

	private WebDriver driver;

	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
		setDriver(new FirefoxDriver());
		getDriver().get("http://mantis-prova.base2.com.br/login_page.php");
		Thread.sleep(1000);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
}
