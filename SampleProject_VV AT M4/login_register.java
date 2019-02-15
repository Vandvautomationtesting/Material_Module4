package HotelLogin;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageBean.HotelLoginPageFactory;

public class StepDefsHotelLogin {

	private WebDriver driver;
	private HotelLoginPageFactory objhlpg;

@Before
public void connectToBrowser() throws Throwable {
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	objhlpg = new HotelLoginPageFactory(driver);

	driver.get("file:///D:/BDD/BDD%20certf/hotelBooking/hotelBooking/login.html/");
}

@Test
public void check_the_heading_of_the_page() throws Throwable {
	String strheading = driver.findElement(By.xpath("//*[@id='mainCnt']/div[1]/div[1]/h1")).getText();
	if(strheading.contentEquals("Hotel Booking Application")) {
		System.out.println("******" +"Heading Matched");
	}
	else	{	System.out.println("******" + "Heading Not Matched"); 	}
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.close();
}

@Test
public void chkLogin() throws Throwable {
	/***** Blank userName *******/
	objhlpg.setPfuname("");
	Thread.sleep(1000);
	objhlpg.setPflogin();
	Thread.sleep(1000);
	String strmsg = driver.findElement(By.xpath("//*[@id='userErrMsg']")).getText();
	assertEquals(strmsg, "* Please enter userName.");
	
	/***** Correct userName *******/
	objhlpg.setPfuname("capgemini");
	
	/***** Blank userName *******/
	objhlpg.setPfpwd("");
	Thread.sleep(1000);
	objhlpg.setPflogin();
	Thread.sleep(1000);
	String strmsg = driver.findElement(By.xpath("//some xpath ...")).getText();
	assertEquals(strmsg, "* Please enter Password.");
	
	/***** Correct Password *******/
	objhlpg.setPfpwd("capg1234");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	objhlpg.setPflogin();
	driver.close();
	driver.navigate().to("file:///D:/BDD/BDD%20certf/hotelBooking/hotelBooking/hotelbooking.html");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.close();
}

@Test
public void chkIncorrectCredentials() throws Throwable {
	objhlpg.setPfuname("cg");
	objhlpg.setPfpwd("capg1234");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	objhlpg.setPflogin();
	String alertMessage = driver.switchTo().alert().getText();
    driver.switchTo().alert().accept();
    System.out.println("******" + alertMessage);
}
}
