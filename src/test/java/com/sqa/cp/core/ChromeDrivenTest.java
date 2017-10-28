package com.sqa.cp.core;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

public class ChromeDrivenTest extends Core {

	public ChromeDrivenTest(String baseURL) {
		super(baseURL);
	}

	@BeforeClass(alwaysRun = true)
	public void setUpChrome() throws Exception {
		// Setup the WebDriver to use chrome
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		// Run command "Sudo chmod +x chrome driver" to give rights of executing
		// chrome driver file
		setDriver(new ChromeDriver());
		// Sets up default implicit wait to wait for 30 second.
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(this.getBaseUrl());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
	}
}
