package com.sqa.cp.core;

import java.util.concurrent.*;

import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

public class SafariDrivenTest extends Core {

	public SafariDrivenTest(String baseURL) {
		super(baseURL);
	}

	@BeforeClass()
	public void setUpSafari() throws Exception {
		// No need to set property for safari on Mac OS just get/set driver
		setDriver(new SafariDriver());
		// Sets up default implicit wait to wait for 30 second.
		setBaseUrl("https://sfbay.craigslist.org");
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(this.getBaseUrl());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// Close the driver and quits the browser.
		this.driver.quit();
	}
}
