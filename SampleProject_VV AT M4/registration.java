package HotelBooking;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefsHotelBooking {
	private WebDriver driver;
	private HotelBookingPageFactory objhbpg;
	
	@Before
	public void openBrowsser() {
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	objhbpg = new HotelBookingPageFactory(driver);

	driver.get("file:///D:/BDD/BDD%20certf/hotelBooking/hotelBooking/hotelbooking.html");
	}
		
@Test
	public void chkRegistrationTitle() throws Exception {
		String title=driver.getTitle();
		if(title.contentEquals("Hotel Booking")) System.out.println("****** Title Matched");
		else System.out.println("****** Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.close();
	}

	@Test
	public void chkRegistration() throws Exception {
		objhbpg.setPffname("Neelima");	Thread.sleep(1000);
		objhbpg.setPflname("Padmawar");	Thread.sleep(1000);
		objhbpg.setPfemail("neel.p@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("8908765432");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
		objhbpg.setPfpersons(7);	Thread.sleep(1000);
		objhbpg.setPfcardholder("Neelima Padmawar");	Thread.sleep(1000);
		objhbpg.setPfdebit("5678567867897890");	Thread.sleep(1000);
		objhbpg.setPfcvv("078");	Thread.sleep(1000);
		objhbpg.setPfmonth("6");	Thread.sleep(1000);
		objhbpg.setPfyear("2020"); 
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		objhbpg.setPfbutton();
		driver.close();
		driver.navigate().to("file:///D:/BDD/BDD%20certf/hotelBookingSolution/hotelBooking/success.html");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.close();
	}

	
	@Test
	public void blankFirstName() throws Exception {
	/***** Blank First Name ******/
		objhbpg.setPffname("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("******" + alertMessage);
	
	/***** Blank Last Name ******/
/****
first enter first name and then leave last name blank else every time
 it will give alert message for first name 
 ***/	
		objhbpg.setPffname("Neelima");	Thread.sleep(1000);     
		objhbpg.setPflname("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("******" + alertMessage);

		/***** Blank Mobile No. ******/
		objhbpg.setPflname("Padmawar");	Thread.sleep(1000);
		objhbpg.setPfemail("neel.p@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("******" + alertMessage);

	/***** Incorrect Mobile No. ******/
		objhbpg.setPfmobile("12345678900");	Thread.sleep(1000);
		objhbpg.setPfbutton();
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("******" + alertMessage);

		/***** Doesn't Select City. ******/
		objhbpg.setPfcity("Select City");	
		Thread.sleep(1000);
		objhbpg.setPfbutton();
			String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("******" + alertMessage);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Select State");	Thread.sleep(1000);
		
		driver.close();
}
