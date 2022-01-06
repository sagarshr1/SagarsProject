package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
	
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Initialized Driver");

	}

	@Test(dataProvider = "getLoginData")
	public void homePageNavigation(String userName, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigate to URL");
		LandingPage l = new LandingPage(driver);
		l.loginLink().click();
		log.info("clicked on Login");
		LoginPage login = new LoginPage(driver);
		login.email().sendKeys(userName);
		log.info("Sent UserName");
		login.password().sendKeys(password);
		log.info("Sent Password");
		// System.out.println(text);
		login.submitBtn().click();
		log.info("Clicked on Submit");

	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "test1";
		data[0][1] = "Password1";
		// data[0][2]="Restricted User";

		data[1][0] = "test2";
		data[1][1] = "Password2";
//		data[1][2]="Valid User";

		return data;

	}

}
