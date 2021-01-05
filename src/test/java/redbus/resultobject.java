package redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class resultobject {
	public WebDriver driver;
	By total = By.cssSelector("span[class='f-bold busFound']");
	
	By busnames = By.xpath("//div[@class='travels lh-24 f-bold d-color']");

	public resultobject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement totalbus()
	{
		return driver.findElement(total);
	}

	public By busnames() {
		// TODO Auto-generated method stub
		return busnames;
	}

}
