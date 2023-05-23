package hw2Zaki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercies3Zaki {

	public static void main(String[] args) throws InterruptedException {
		// setting the webdrivermangaer and our url
		String url = "https://demo.nopcommerce.com/";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		Thread.sleep(2000);
		
		// clicking the register button
		WebElement clickingReg =  driver.findElement(By.linkText("Register"));
		clickingReg.click();
		Thread.sleep(3000);
		
		// verifying the page title it should be "is nopCommerce demo store. Register"
		String PageTitle = driver.getTitle();
		System.out.println("Page title is : " + PageTitle);
		
		// Filling out the personal information part 
		//1. gender 
		WebElement gender = driver.findElement(By.id("gender-male"));
		gender.click();
		Thread.sleep(3000);
		//2. FirstName 
		WebElement FirstName = driver.findElement(By.id("FirstName"));
		FirstName.sendKeys("Ahmad Zaki");
		//3.LastName 
		WebElement LastName = driver.findElement(By.id("LastName"));
		LastName.sendKeys("Naby Zada");
		//4.date of birth dropdown
		WebElement dob = driver.findElement(By.name("DateOfBirthDay"));
		Select select = new Select(dob);
		select.selectByValue("7");
			//4.1 selecting the 
				WebElement dobM = driver.findElement(By.name("DateOfBirthMonth"));
				Select select1 = new Select(dobM);
				select1.selectByVisibleText("October");
				Thread.sleep(2000);
			//4.2 selecting the year 
				WebElement doby = driver.findElement(By.name("DateOfBirthYear"));
				Select select2 = new Select(doby);
				select2.selectByValue("2001");
				Thread.sleep(2000);
		//5. adding the email
				WebElement email = driver.findElement(By.id("Email"));
				email.sendKeys("ahdmd.mmdjaaddasfj@gmail.com");
				Thread.sleep(2000);
		//6. entering the company name 
				WebElement companyName = driver.findElement(By.id("Company"));
				companyName.sendKeys("HOg rider");
				Thread.sleep(2000);
		//7. unchecking the checkbox 
				WebElement uncheking = driver.findElement(By.id("Newsletter"));
				uncheking.click();
				Thread.sleep(2000);
		//8. Entering the password 
				WebElement EnterPass = driver.findElement(By.id("Password"));
				EnterPass.sendKeys("BruhBruh");
				Thread.sleep(2000);
				//8.1 Confirmin the password 
				WebElement ConfirmPass = driver.findElement(By.id("ConfirmPassword"));
				ConfirmPass.sendKeys("BruhBruh");
				Thread.sleep(2000);
		//9. clicking the register btn
				WebElement Registerbtn = driver.findElement(By.id("register-button"));
				Registerbtn.click();
				Thread.sleep(2000);
				
		//10. confirmation
				WebElement confirmation = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
				String a = confirmation.getText();
				System.out.println(a);
				//10.1 Checking if it is correct 
				if(a.equals("Your registration completed!!!")){
					System.out.println("TESTCASE PASSED");
				}else {
					System.out.println("TESTCASE FAILED");
				}
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
	}
}
