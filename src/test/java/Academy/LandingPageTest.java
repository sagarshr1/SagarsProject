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

public class LandingPageTest extends Base {
	
	private static Logger log = LogManager.getLogger(LandingPageTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();

	}

	@Test
	public void homePageNavigation() throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL");

		LandingPage l = new LandingPage(driver);
		String title = l.getTitle().getText();
		Assert.assertEquals(title, "An Academy to Learn Earn & Shine  in your QA Career");
		log.info("Title Matches");
		Assert.assertTrue(l.menuBar().isDisplayed());
		log.info("Menu Bar displayed");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
