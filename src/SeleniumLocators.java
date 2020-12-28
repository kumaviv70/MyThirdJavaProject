
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {
	public static WebDriver driver;
	public WebElement butAlert, butPromptAlert, showAlert, pTrue;

	// 1. JUnit tag -
	// https://dzone.com/articles/tutorial-on-junit-annotations-in-selenium-with-exa
	@BeforeClass
	public static void startBrowser() {
		// 2. Start browser
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://compendiumdev.co.uk/selenium/alerts.html");
		driver.manage().window().maximize();
	}

	@Before
	public void runBeforeEachTest() {
		System.out.println("Runs before each test");
	}

	@Test
	public void getTitle() {
		// Retrieve title, current url
		String titlePg = driver.getTitle();
		String pgUrl = driver.getCurrentUrl();
//		String titlePgsrc = driver.getPageSource();

		System.out.println("Title: " + titlePg);
		System.out.println("Page Url: " + pgUrl);
	}
	
	@Test
	public void xPathExamples() {
		// F12 to get dev tools
		// Find elements by - id, xpath
		butAlert = driver.findElement(By.id("alertexamples"));

		// By xpath
		WebElement butConfirmBox = driver.findElement(By.xpath("//input[@value='Show confirm box']"));
		Point pnt = butAlert.getLocation();
		System.out.println(pnt.getX());
		butConfirmBox.click();
		
		// Alerts
		driver.switchTo().alert().accept();
		String butAlertTxt = butAlert.getAttribute("value");
		System.out.println("butAlertTxt: " + butAlertTxt);

		// Locator - https://www.toolsqa.com/selenium-webdriver/write-effective-xpaths/
		// * Contains
		showAlert = driver.findElement(By.xpath("//input[contains(@id,'alert')]"));
		System.out.println(showAlert.getAttribute("value"));
		// * Starts-with
		butPromptAlert = driver.findElement(By.xpath("//input[starts-with(@id,'prom')]"));
		System.out.println(butPromptAlert.getAttribute("value"));
		// * Text
		pTrue = driver.findElement(By.xpath("//p[text()='true']"));
		System.out.println(pTrue.getText());
		// * And & or
		// pTrue = driver.findElement(By.xpath("//input[@placeholder ='Full Name' and @type = 'text']));
		// pTrue = driver.findElement(By.xpath("//input[@placeholder ='Full Name' or @type = 'text']"));
		
		// Get attribute
		String type = butConfirmBox.getAttribute("type");
		System.out.println(type);
		
		// X-path axis
		// * Ancestor
		driver.get("https://www.united.com/en/us/customercare");
		// * contains
		WebElement pText = driver.findElement(By.xpath("//p[contains(text(),'changing times')]"));
		System.out.println(pText.getText());
		
		Set<String> s=driver.getWindowHandles();
		Iterator<String> Itr=s.iterator();
		while(Itr.hasNext()) {
			String chdWin = Itr.next();
			System.out.println(chdWin);
		}
		List<WebElement> custCare = driver.findElements(By.xpath("(//*[contains(text(),'1-800')])[1]//ancestor::div"));
		int ctrEle = custCare.size();
		System.out.println("ctrEle : "+ctrEle);
		
		// css selector
		WebElement close=driver.findElement(By.cssSelector(".app-components-Modal-styles__closeIcon--2a-8F"));
		close.click();
		
		List<WebElement> addressFields = driver.findElements(By.className("div.app-containers-CustomerCareContainer-CustomerCare-Information-styles__input--3VTlp"));
		Iterator<WebElement> addEle = addressFields.iterator();
		while(addEle.hasNext()){
			WebElement ele = addEle.next();
			System.out.println(ele.getText());
		}
	}

	@Test
	public void location() {
		butAlert = driver.findElement(By.id("alertexamples"));
		Point pnt = butAlert.getLocation();
		System.out.println(pnt.getX());
//		butAlert.click();
	}

	@Test
	public void addition() {
		int a;
		a = 5 * 10;
		assertEquals(50, a);
	}

	@After
	public void runAfterEachTest() {
		System.out.println("Runs after each test");
	}

	@Ignore
	public void ignoreRunningThisMethod() {
		System.out.println("Method not executed");
	}

	@AfterClass
	public static void afterClassTest() {
//		driver.quit();
	}
}
