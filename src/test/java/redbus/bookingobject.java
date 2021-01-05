package redbus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bookingobject {
	public WebDriver driver;
	By search = By.id("src");
	By To = By.id("dest");
	By source = By.xpath("//*[@id='search']/div/div[1]/div/ul/li");
	By dest = By.xpath("//*[@id='search']/div/div[2]/div/ul/li");
	By month = By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]");
	By next = By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button");
	By day = By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td");
	By searchbutton = By.id("search_btn");

	// By closepop=By.cssSelector("div[class='close']");
	public bookingobject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement search() {

		return driver.findElement(search);
	}

	public WebElement To() {

		return driver.findElement(To);
	}

	public By Destlist() {
		// TODO Auto-generated method stub
		return dest;
	}

	public By source() {
		// TODO Auto-generated method stub
		return source;
	}

	public WebElement month() {

		return driver.findElement(month);
	}

	public WebElement next() {

		return driver.findElement(next);
	}

	public By day() {
		// TODO Auto-generated method stub
		return day;
	}

	public WebElement serachbutton() {
		// TODO Auto-generated method stub
		return driver.findElement(searchbutton);
	}
	/*
	 * public WebElement close() { // TODO Auto-generated method stub return
	 * driver.findElement(closepop); }
	 */
}