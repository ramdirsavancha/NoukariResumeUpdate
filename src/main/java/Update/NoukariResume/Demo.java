package Update.NoukariResume;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	private WebDriver driver;

	public void loginPage() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String parent_window = driver.getWindowHandle();

		Set<String> child_win = driver.getWindowHandles();
		ArrayList<String> arr = new ArrayList<String>(child_win);
		for (String ch : arr) {
			driver.switchTo().window(ch);
			System.out.println(driver.getTitle());
		}
		
	}

	public void clickLoginLink() throws Exception {
		driver.findElement(By.id("login_Layer")).click();
		Thread.sleep(5000);
		Set<String> all_win = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(all_win);
		for (String win : al) {
			driver.switchTo().window(win);
			System.out.println(driver.getTitle());

			driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
					.sendKeys("ramakrishna.altimetrik@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Testing@2023");
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			Thread.sleep(5000);
		}
	}

	public void HomePage() throws Exception {

		driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
		driver.findElement(By.xpath("//a[text()='View & Update Profile']")).click();
		// driver.findElement(By.xpath("//em[text()='Edit']")).click();
		// driver.findElement(By.xpath("//button[text()='SAVE']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250)");
		driver.findElement(By.xpath("//span[contains(text(),'Resume Headline')]/following-sibling::span")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@class='action s12']/button[contains(@type,'submit')][contains(text(),'Save')]"))
				.click();
		Thread.sleep(500);

	}

	public void logout() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,-250)");
		driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

	public static void main(String[] args) throws Exception {
		Demo dm = new Demo();
		dm.loginPage();
		dm.clickLoginLink();
		dm.HomePage();
		dm.logout();

	}

}
