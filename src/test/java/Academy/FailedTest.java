package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class FailedTest extends Base {
	
	private static Logger log = LogManager.getLogger(FailedTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();

	}

	@Test
	public void FailedTestCase() throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL");

		LandingPage l = new LandingPage(driver);
		String title = l.getTitle().getText();
		Assert.assertEquals(title, "Incorrect Title");
		log.info("Title Matches");
		Assert.assertTrue(l.menuBar().isDisplayed());
		log.info("Menu Bar displayed");
		System.out.println("Added line");
		System.out.println("Added line2");
		System.out.println("Added line3");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
