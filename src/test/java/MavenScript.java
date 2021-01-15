import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenScript {
	WebDriver driver;
	@Test(priority=1)
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://shareurthoughts.herokuapp.com/admin/login/?next=/admin/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void logOut() {
		driver.findElement(By.xpath("//a[@href='/admin/logout/']")).click();
	}
}
