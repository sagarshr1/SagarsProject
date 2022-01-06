package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By loginlink = By.cssSelector("a[href*='sign_in']");
	By getTitle = By.cssSelector(
			"div.page-wrapper div.container-fluid:nth-child(1) div.row div.carousel.slide div.carousel-inner div.item.active div.header-text.hidden-xs:nth-child(2) div.col-md-6.text-left h2:nth-child(1) > span:nth-child(1)");

	By menuBar = By.cssSelector("ul[class='navigation clearfix']");
	

	public WebElement loginLink() {
	return driver.findElement(loginlink);
	}

	public WebElement getTitle() {
		return driver.findElement(getTitle);
	}
	
	public WebElement menuBar() {
		return driver.findElement(menuBar);
	}

}
