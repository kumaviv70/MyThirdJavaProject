import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeWebDriverWait {
	public static WebDriver driver;
	
	@BeforeClass
	public static void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void exampleWait() {
		System.out.println("Wait examples");
		
		WebElement homePg = driver.findElement(By.cssSelector("a[href='//www.phptravels.net']"));
		homePg.click();
		String parentWin = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		while(iter.hasNext()) {
			String handle = iter.next();
			if(!handle.matches(parentWin)) {
				driver.switchTo().window(handle);
				/*
				 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
			}
				
		}
		
		// ** Implicit Wait
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// ** Fluent wait
		/*
		 * Wait<WebDriver> wait=new FluentWait<WebDriver>(driver) .withTimeout(10,
		 * TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS)
		 * .ignoring(NoSuchElementException.class);
		 */
		
		// Webdriver wait	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
//		WebElement flight = driver.findElement(By.cssSelector("a.text-center.flights"));
		WebElement flight = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.text-center.flights")));
		System.out.println(flight.isDisplayed());
		flight.click();
	}
	
	@AfterClass
	public static void closeBrowser() {
//		driver.quit();
	}

}
