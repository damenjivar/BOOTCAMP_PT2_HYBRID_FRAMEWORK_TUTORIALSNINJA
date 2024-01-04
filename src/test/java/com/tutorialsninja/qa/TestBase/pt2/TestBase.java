package com.tutorialsninja.qa.TestBase.pt2;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.Utilities.pt2.Util;

public class TestBase {

	public WebDriver driver;
	public ChromeOptions options;
	public Properties prop;
	public FileInputStream ip;
	public Properties dataProp;
	public FileInputStream dataIp;

	public TestBase() throws Exception {

		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\Config\\pt2\\config.properties");
		prop.load(ip);

		dataProp = new Properties();
		dataIp = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\testData\\pt2\\dataProp.properties");
		dataProp.load(dataIp);
	}

	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if (browserName.equals(prop.getProperty("browser"))) {
			options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIMEOUT));
		driver.get(prop.getProperty("url"));

		return driver;
	}
}
