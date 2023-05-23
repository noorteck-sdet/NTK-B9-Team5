package hw1Zaki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2Zaki {
	public static void main(String[] args) throws InterruptedException {

		// 1.set the property
		System.setProperty("webdriver.chrome.driver", "/Users/zaki/Desktop/chromedriver_mac_arm64/chromedriver");

		// 2.create the driver object
		WebDriver driver = new ChromeDriver();
		// 3. get the link of site
		driver.get("https://demo.guru99.com/test/newtours/");
		Thread.sleep(3000);
		// 4.find the register button
		WebElement registerbtn = driver.findElement(By.linkText("REGISTER"));
		registerbtn.click();
		Thread.sleep(3000);
		// 5.getting the title of the page
		String title = driver.getTitle();
		System.out.println(" page title : " + title);
		// 6. Enter first Name
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("Ahmad");
		Thread.sleep(3000);
		// 7.enter lastName
		WebElement LastName = driver.findElement(By.name("lastName"));
		LastName.sendKeys("Naby Zada");
		Thread.sleep(3000);
		// 8. enter phone number
		WebElement phonenumber = driver.findElement(By.name("phone"));
		phonenumber.sendKeys("517 315 7944");
		Thread.sleep(3000);
		// 9. enter email
		WebElement Email = driver.findElement(By.name("userName"));
		Email.sendKeys("test@gmail.com");
		Thread.sleep(3000);
		// 10.enter address
		WebElement address = driver.findElement(By.name("address1"));
		address.sendKeys("2341 W dunlap ave");
		Thread.sleep(3000);
		// 11. enter city
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Phenix");
		Thread.sleep(3000);
		// 12. enter state
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("arizona");
		Thread.sleep(3000);
		// 13.zip code
		WebElement zipCode = driver.findElement(By.name("postalCode"));
		zipCode.sendKeys("85602");
		Thread.sleep(3000);
		// 14.Enter userName
		WebElement UserName = driver.findElement(By.name("email"));
		UserName.sendKeys("Ahmad.naby");
		Thread.sleep(3000);
		// 15. Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("password");
		Thread.sleep(3000);
		// 16. re-enter the password
		WebElement reEnterPass = driver.findElement(By.name("confirmPassword"));
		reEnterPass.sendKeys("password");
		Thread.sleep(3000);
		// 17. click submit
		WebElement submitbtn = driver.findElement(By.name("submit"));
		submitbtn.click();
		// 18. checking the thank you note
		WebElement thankutxt = driver.findElement(By.xpath("Thank you for registering."));
		if (thankutxt.isDisplayed()) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		Thread.sleep(4000);
		driver.quit();

	}
}
