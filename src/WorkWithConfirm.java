import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WorkWithConfirm {
	
	private static WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://compendiumdev.co.uk/selenium/alerts.html");
	}

	@Test
	public void checkConfirmBox() {
		WebElement confirmBox = driver.findElement(By.xpath("//input[@id='confirmexample']"));
		confirmBox.click();
		driver.switchTo().alert().dismiss();
		String str = driver.findElement(By.id("confirmreturn")).getText();
		assertEquals("false", str);
		driver.quit();
	}
	
	@Test	
	public void switchFrame() {
		//driver.close();
		String url="http://testpages.herokuapp.com/styled/frames/frames-test.html";
		driver.get(url);
		String frameTitle=driver.switchTo().frame("left").getTitle();
		String txtFound="";
		txtFound=driver.findElement(By.xpath("//li[@id='left0']")).getText();
		System.out.println(frameTitle);
		assertEquals("Left List Item 0", txtFound);
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		driver.close();
	}

}
