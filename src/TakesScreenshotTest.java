import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TakesScreenshotTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(browser)
				.register(new AbstractWebDriverEventListener() {

					@Override
					public void onException(Throwable throwable, WebDriver browser) {

						File screen = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);

						try {
							FileUtils.copyFile(screen, new File("C:\\Temp\\screen.png"));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});

		try {
			eventDriver.findElement(By.id("viewport"));
			fail("some message");

		} catch (NoSuchElementException e) {

			// Triggering point for the <onException> event. }

		}
	}
}
