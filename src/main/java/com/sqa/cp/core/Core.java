/**
 * File Name: Core.java<br>
 * Chhaya Patel<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Oct 18, 2017
 */
package com.sqa.cp.core;

/**
 * Core //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Chhaya Patel
 * @version 1.0.0
 * @since 1.0
 */
import org.apache.log4j.*;
import org.openqa.selenium.*;

public class Core {

	private static int count = 1;

	public static int getCount() {
		return count;
	}

	private String baseUrl;

	protected WebDriver driver;

	private ChromeDrivenTest curTest;

	private Logger log = Logger.getLogger(this.getClass());

	public Core(ChromeDrivenTest test) {
		this.curTest = test;
		this.baseUrl = test.getBaseUrl();
		this.driver = test.getDriver();
	}

	public Core(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Core(String baseUrl, WebDriver driver) {
		super();
		this.baseUrl = baseUrl;
		this.driver = driver;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return this.baseUrl;
	}

	public ChromeDrivenTest getCurTest() {
		return this.curTest;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	// Method that checks if the element is present on the page.
	public boolean isElementPresent(String xpathString) {
		return AutoBasics.isElementPresent(getDriver(), By.xpath(xpathString), getLog());
	}

	// Example of a non static implementation of the static helper method
	public void takeScreenshot() {
		AutoBasics.takeScreenshot("screenshots/", "Craigs list- ", count, getDriver(), this.getLog());
		count++;
	}

	// Example of a non static implementation of the static helper method
	public void takeScreenshot(String name) {
		AutoBasics.takeScreenshot("screenshots/", name, count, getDriver(), this.getLog());
		count++;
	}

	protected void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}