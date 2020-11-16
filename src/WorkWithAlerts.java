import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithAlerts {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://compendiumdev.co.uk/selenium/alerts.html");
		WebElement eleAlert = driver.findElement(By.xpath("//input[@id='alertexamples']"));
		eleAlert.click();
		String expStr="I am an alert box!";
		String msg=driver.switchTo().alert().getText();
		System.out.println(msg);
		assertEquals(expStr,msg);
		driver.switchTo().alert().accept();
		driver.quit();
	}

}
