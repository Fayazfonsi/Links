package Links;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class Links {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void f() {

		driver.findElement(By.cssSelector("#simpleLink")).click();
		ArrayList<String> b = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(b.get(1));

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".home-banner")));
		driver.close();
		driver.switchTo().window(b.get(0));
	}

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\chrome driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/links");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
