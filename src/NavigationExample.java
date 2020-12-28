
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class NavigationExample {
	WebDriver browser;
	
	@Test
	public void searchText() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.get("http:\\www.google.com");
		browser.manage().window().maximize();

		// browser.findElement(By.id("viewport"));
		WebElement eleSearch = browser.findElement(By.xpath("//input[@type='text' and @title='Search']"));
		eleSearch.sendKeys("Yellowstone national park");
		eleSearch.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		browser.findElement(By.xpath("(//input[@value='Google Search' and @type='submit'])[2]")).click();
	}
	
	@AfterClass
	public void tearDown() {
		browser.close();
	}
}
