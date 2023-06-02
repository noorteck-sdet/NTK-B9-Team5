package hw10Zaki;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercies10 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.manage().window().maximize();
		WebElement searchField = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		searchField.sendKeys("selenium (software)");

		WebElement searchBtn = driver.findElement(By.className("wikipedia-search-button"));
		searchBtn.click();
		Thread.sleep(2000);
		WebElement softwere = driver
				.findElement(By.xpath("//a[@href='https://en.wikipedia.org/wiki/Selenium_(software)']"));
		softwere.click();

		String windows = driver.getWindowHandle();
		driver.switchTo().window(windows);
		searchField.clear();
		searchField.sendKeys("ebay");
		searchBtn.click();
		Thread.sleep(2000);

		WebElement ebay = driver.findElement(By.xpath("//a[text()='EBay']"));
		ebay.click();
		driver.switchTo().window(windows);
		searchField.clear();

		searchField.sendKeys("Target Corporation");
		Thread.sleep(2000);
		searchBtn.click();
		Thread.sleep(2000);
		WebElement target = driver.findElement(By.linkText("Target Corporation"));
		target.click();

		driver.switchTo().window(windows);
		searchField.clear();
		searchField.sendKeys("Google");
		Thread.sleep(2000);
		searchBtn.click();
		Thread.sleep(2000);
		WebElement google = driver.findElement(By.linkText("Google"));
		google.click();

		driver.switchTo().window(windows);
		searchField.clear();

		searchField.sendKeys("Yahoo");
		searchBtn.click();
		Thread.sleep(2000);
		WebElement yahoo = driver.findElement(By.linkText("Yahoo!"));
		yahoo.click();

		Thread.sleep(4000);
		driver.quit();
		
		Set<String> set = new HashSet<String>();
		set.add(windows);
		
		
		
		for (String b : set) {
		
			System.out.println(b);
		}
	}
}
