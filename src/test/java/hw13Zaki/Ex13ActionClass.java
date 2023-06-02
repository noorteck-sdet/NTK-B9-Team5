package hw13Zaki;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex13ActionClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		Actions action = new Actions(driver);
		
		WebElement stockholmsrc = driver.findElement(By.xpath("//div[@id='box2']"));
		WebElement stockholmtrg = driver.findElement(By.xpath("//div[@id='box102']"));
		action.clickAndHold(stockholmsrc).moveToElement(stockholmtrg).release().build().perform();
		
		
		WebElement Washingtonsrc = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement Washingtontrg = driver.findElement(By.xpath("//div[@id='box103']"));
		action.clickAndHold(Washingtonsrc).moveToElement(Washingtontrg).release().build().perform();
		
		WebElement cophenhagensrc = driver.findElement(By.xpath("//div[@id='box4']"));
		WebElement cophenhangentrg = driver.findElement(By.xpath("//div[@id='box104']"));
		action.clickAndHold(cophenhagensrc).moveToElement(cophenhangentrg).release().build().perform();
		
		WebElement Soelsrc = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement Soeltrg = driver.findElement(By.xpath("//div[@id='box105']"));
		action.clickAndHold(Soelsrc).moveToElement(Soeltrg).release().build().perform();
		
		WebElement romesrc = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement rometrg = driver.findElement(By.xpath("//div[@id='box106']"));
		action.clickAndHold(romesrc).moveToElement(rometrg).release().build().perform();
		
		WebElement spainsrc = driver.findElement(By.xpath("//div[@id='box7']"));
		WebElement spaintrg = driver.findElement(By.xpath("//div[@id='box107']"));
		action.clickAndHold(spainsrc).moveToElement(spaintrg).release().build().perform();
		
		WebElement norwaysrc = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement norwaytrg = driver.findElement(By.xpath("//div[@id='box101']"));
		action.clickAndHold(norwaysrc).moveToElement(norwaytrg).release().build().perform();
		
		
		
		
		System.out.println("Great SUCCESS");
		
		List<String > Clist = new ArrayList<String>();
		
		List<WebElement> countriestrg = driver.findElements(By.xpath("//div[@id='countries']"));
		for(WebElement i : countriestrg) {
			String a = i.getText();
			Clist.add(a);
		}
		
		for(String b : Clist) {
			if(b.contains("Italy")) {
				System.out.println("yes it's italy");
				action.dragAndDrop(romesrc, rometrg).build().perform();
			}else {
				System.out.println("idd");
			}
		}
		
		
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}
