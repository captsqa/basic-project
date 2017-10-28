package com.sqa.cp.core;

import java.util.concurrent.*;

import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class FirefoxDrivenTest extends Core {

	public FirefoxDrivenTest(String baseURL) {
		super(baseURL);
	}

	@BeforeClass(alwaysRun = true)
	public void setupFirefox() throws Exception {
		// No need to setup FF driver as its deafult driver
		setDriver(new FirefoxDriver());
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(this.getBaseUrl());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// Close the driver and quits the browser.
		this.driver.quit();
	}
}
