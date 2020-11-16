import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\www.bing.com");
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getPageSource());
		driver.findElement(By.id("sb_form_q")).sendKeys("hello");
		driver.findElement(By.xpath("//label[@for='sb_form_go']")).click();
//		driver.findElement(By.cssSelector(".search.icon.tooltip")).click();
//		driver.findElement(By.cssSelector("label[class*='tooltip']")).click();
//		driver.findElement(By.cssSelector("label[for='sb_form_go']")).click();
		//("//li[@class='tile_grp']//li[@class='pntile'][2]//preceding-sibling::li")
		driver.close();
		driver.quit();
	}
}
