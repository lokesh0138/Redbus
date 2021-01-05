package redbus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class frontpage extends base {

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	//bookingobject b = new bookingobject(driver);

	// bookingobject b=new bookingobject(driver);
	@BeforeTest
	public void initialize() throws IOException {
		driver = start();

	}

	@Test(priority=1)
	public void open() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("window maximized");
		driver.get(prop.getProperty("URL"));
		log.info("URL launched");
		bookingobject b = new bookingobject(driver);
		example ex =new example();
		ArrayList data=ex.getdata("Yes");
		String yes=data.get(0).toString();
		log.info(yes);
		String from=data.get(1).toString();
		log.info(from);
		String to=data.get(02).toString();
		log.info(to);
		String Month=data.get(03).toString();
		String dat=data.get(04).toString();
		log.info(Month);
		log.info(dat);
		//ArrayList data=ex.getdata("Location");
		/*System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));*/
		
		b.search().sendKeys(from);
		Thread.sleep(3000);
		List<WebElement> option = driver.findElements(b.source());
		for (WebElement opt : option) {
			if (opt.getText().contains("Chennai")) {

				opt.click();
				break;
			}
		}
		b.To().sendKeys(to);
		List<WebElement> option2 = driver.findElements(b.Destlist());
		for (WebElement opt2 : option2) {
			// System.out.println(opt.getText());
			if (opt2.getText().contains("Bangalore")) {

				opt2.click();
				break;
			}
		}

		Thread.sleep(3000);
		/*
		 * while(!b.month().getText().contains("Jan")) { b.next().click();
		 * break; }
		 */

		while (true) {
			String mes = b.month().getText();
			if (mes.contains(Month)) {
				break;
			} else {
				b.next().click();
			}
		}
		// List<WebElement>
		// item=driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
		List<WebElement> item = driver.findElements(b.day());
		int count = item.size();
		for (int i = 0; i < count; i++) {
			// String
			// date=driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td")).get(i).getText();
			String date = driver.findElements(b.day()).get(i).getText();
			if (date.equalsIgnoreCase(dat)) {
				// driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td")).get(i).click();
				driver.findElements(b.day()).get(i).click();
				break;
			}
		}
		
		// Thread.sleep(3000);
		// b.day().click();
		//getscreenshot("open", driver);
		Thread.sleep(3000);
		//b.serachbutton().click();
		//Thread.sleep(3000);
	}
	
	@Test(priority=2)
		public void second() throws InterruptedException{
		bookingobject b = new bookingobject(driver);
		b.serachbutton().click();
		resultobject rp=new resultobject(driver);
		Thread.sleep(3000);
		String tot=rp.totalbus().getText();
		log.info("No of buses");
		log.info(tot);
		Thread.sleep(3000);
		List<WebElement> names=driver.findElements(rp.busnames());
		log.info("Bus names");
		int t=names.size();
		for(int k=0;k<t;k++){
			String name = driver.findElements(rp.busnames()).get(k).getText();
			log.info(name);
			//System.out.println(name);
		}
	}

	@AfterTest
	public void close() {
		driver.close();
	}
}
