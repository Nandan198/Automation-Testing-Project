package AmazonProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public static void Project() {

		//Lunching Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximizing Window
		driver.manage().window().maximize();
		
		//Navigating to Amazon Website
		driver.get("https://www.amazon.in/");
		
		//Getting parent Window Handel
		String parent_window = driver.getWindowHandle();
		
		//Applying implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Locating Search Bar
	    WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	    
	    //Creating the object of actions Class
	    Actions act = new Actions(driver);
	    
	    //Clicking and SendKeys and Pressing enter on Search  bar
	    act.click(search).sendKeys("city of Djins:A year in Delhi",Keys.ENTER).build().perform();
	    
	    //Locate and click on Product
	    driver.findElement(By.cssSelector("img[src=\'https://m.media-amazon.com/images/I/615N9pAwIXL._AC_UY218_.jpg\']")).click();
	    
	    //Getting Parent and Child window
	    Set<String> handle=driver.getWindowHandles();
	    
	    //Switching to child window
	    for (String e : handle) {
	    	if(e.equalsIgnoreCase(parent_window))
	    	{

	    	}
	    	else
	    	{
	    	driver.switchTo().window(e);
	    	}
	    	}
	    //Applying implict Wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    //Locate and click on Buy Now
	    driver.findElement(By.id("buy-now-button")).click();
	    
	    //Locating And SendKeys and press enter after Passing email address
	    WebElement email =driver.findElement(By.name("email"));
	    email.sendKeys("nandankumar9008@gmail.com",Keys.ENTER);
	    
	    //Locating and SendKeys And Press Enter After Passing Password
	    WebElement password =driver.findElement(By.name("password"));
	    password.sendKeys("Nandan@9008",Keys.ENTER);
	    
	    //Adding implict Wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    
	    //Locate and click on other UPI Apps
	    driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[6]/div/div[3]/div/div/div[2]/div/div[2]/div/div/form/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/label/input")).click();
	    
	    //Locate and SendKeys of UPI ID
	    driver.findElement(By.name("__sif_encryptedVPA_collect")).sendKeys("9008522376@ybl");
	    
	    //Locate And Click on Verify button
	    driver.findElement(By.name("ppw-widgetEvent:ValidateUpiIdEvent")).click();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    //click on use this method
	    driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div/div[2]/span/span/span")).click();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    //Placing Order
	    driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/span")).click();
	    
	}

}
