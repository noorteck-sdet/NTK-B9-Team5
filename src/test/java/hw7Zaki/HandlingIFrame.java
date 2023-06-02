package hw7Zaki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingIFrame {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview- \n" + "summary.html");
		driver.manage().window().maximize();

		WebElement selinum = driver.findElement(By.linkText("org.openqa.selenium"));
		selinum.click();
		Thread.sleep(2000);

		WebElement alert = driver.findElement(By.linkText("Alert"));
		alert.click();
		Thread.sleep(2000);

		WebElement interfaceAlert = driver.findElement(By.xpath("//h2[@title='Interface Alert']"));
		String text = interfaceAlert.getText().trim();

		if (text.equals("Interface Alert")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		WebElement Frames = driver.findElement(By.xpath("//a[text()='Frames'][1]"));
		Frames.click();

		driver.switchTo().frame("packageListFrame");

		WebElement chrome = driver.findElement(By.xpath("//a[text()='org.openqa.selenium.chrome']"));
		chrome.click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("packageFrame");
		WebElement ChromeDriver = driver.findElement(By.linkText("ChromeDriver"));
		ChromeDriver.click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		WebElement classChromeDrvier = driver.findElement(By.xpath("//h2[@title='Class ChromeDriver']"));
		String textf = classChromeDrvier.getText();

		if (textf.equals("Class ChromeDriver")) {
			System.err.println("Class ChromeDriver Test have beem PASSED ");
		} else {
			System.out.println("Class ChromeDriver Test have been FAILED");
		}

		Thread.sleep(3000);
		driver.quit();

	}
}
