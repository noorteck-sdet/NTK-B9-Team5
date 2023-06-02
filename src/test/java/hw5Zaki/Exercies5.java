package hw5Zaki;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercies5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");

		WebElement DepCityDrop = driver.findElement(By.name("fromPort"));
		Thread.sleep(2000);
		Select select = new Select(DepCityDrop);
		select.selectByValue("Boston");

		List<WebElement> list = select.getOptions();

		for (WebElement i : list) {
			String text = i.getText();

			WebElement Destination = driver.findElement(By.xpath("//select[@name='toPort']"));
			Thread.sleep(3000);
			Select select1 = new Select(Destination);
			select1.selectByVisibleText("Rome");
			if (text.equals("Boston")) {
				System.out.println("Test Case Passed ");
			}
			
		}
		System.out.println("*************");
		// getting the page title and verifying them
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("BlazeDemo -reserve ")) {
			System.out.println("Page title validition PASSED ");

		} else {
			System.out.println("Page title should be : " + "BlazeDemo -reserve");
			System.out.println("Actual page title : " + pageTitle);
		}
		System.out.println("**************");

		// clicking the find flights button
		WebElement findFlightBtn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		findFlightBtn.click();
		Thread.sleep(2000);

		// getting the xpath of table header which is kinda the column which contains
		// the table header and storing it in a list of webelement
		List<WebElement> columnList = driver.findElements(By.xpath("//table[@class='table']//tr"));
		int columnSize = columnList.size();
		System.out.println("columnSize = " + columnSize);

		// getting the xpatha of table
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
		int rowSize = rowList.size();
		System.out.println("row Size : " + rowSize);

		// making a list and we gonna put the Linkedhashmap inside a list and we gonna
		// be doing upcasting with arraylist
		List<LinkedHashMap<String, String>> rowDataList = new ArrayList<LinkedHashMap<String, String>>();

		for (int row = 1; row <= rowSize; row++) {

			LinkedHashMap<String, String> rowMap = new LinkedHashMap<String, String>();

			for (int column = 1; column <= columnSize; column++) {
				// getting the table head it;s name
				String columnName = driver.findElement(By.xpath("//table[@class='table']//th[" + column + "]"))
						.getText();
				
			
				String columnValue = driver
						.findElement(By.xpath("//table[@class='table']//tr["+row+"]//td[" + column + "]"))
						.getText();

				System.out.println(columnName + "\t\t" + columnValue);

				// add the columName, columnValue to the rowMap
				rowMap.put(columnName, columnValue);
			}
			// add the rowMap to the List of Maps
						rowDataList.add(rowMap);
					
			System.out.println(rowMap);
			System.out.println("******************************");
		}
	
	
			

		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		

			
		
		Thread.sleep(2000);
		driver.quit();
	}
}
