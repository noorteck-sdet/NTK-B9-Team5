package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise3Lakhwinder {
	public static void main(String[] args) throws InterruptedException {

		String url = "https://demo.nopcommerce.com/";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
		registerLink.click();

		String title = driver.getTitle();

		if (title.equals("nopCommerce demo store. Register")) {

			System.out.println("title same as expected");
		} else {
			System.out.println("Actual does not match expected");
		}
		WebElement genderRadio = driver.findElement(By.id("gender-male"));
		genderRadio.click();

		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.sendKeys("Lakha");

		WebElement lastName = driver.findElement(By.id("LastName"));
		lastName.sendKeys("Virdi");

		WebElement DOBday = driver.findElement(By.name("DateOfBirthDay"));
		WebElement DOBmonth = driver.findElement(By.name("DateOfBirthMonth"));
		WebElement DOByear = driver.findElement(By.name("DateOfBirthYear"));

		Select selectDay = new Select(DOBday);
		Select selectMonth = new Select(DOBmonth);
		Select selectYear = new Select(DOByear);

		selectDay.selectByVisibleText("11");
		selectMonth.selectByVisibleText("May");
		selectYear.selectByVisibleText("1983");

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("lakhavirdi@gmail.com");

		WebElement companyName = driver.findElement(By.id("Company"));
		companyName.sendKeys("Noorteck");

		WebElement newsletter = driver.findElement(By.id("Newsletter"));
		newsletter.click();

		WebElement password = driver.findElement(By.id("Password"));
		WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
		WebElement registerBtn = driver.findElement(By.id("register-button"));

		password.sendKeys("123456");
		confirmPassword.sendKeys("123456");

		registerBtn.click();
		Thread.sleep(2000);
		String resultMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();

		if (resultMessage.equals("Your registration completed!!!")) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
		Thread.sleep(3000);
		driver.quit();

	}
}

