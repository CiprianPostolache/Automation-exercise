package AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automation {

	public static void main(String[] args) {
		
		//Go to http://automationpractice.com/index.php
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lpostolache\\Downloads\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
       
       //Login with the above credentials
       driver.findElement(By.cssSelector("a[class='login']")).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
       driver.findElement(By.id("email")).sendKeys("weswap@mailinator.com");
       driver.findElement(By.id("passwd")).sendKeys("password");
       driver.findElement(By.id("SubmitLogin")).click();
       
       //Add an item from the home page to the cart by ‘Add to cart’
       driver.findElement(By.cssSelector("a[title='Home']")).click();
       Actions action = new Actions(driver);
       WebElement firstitem = driver.findElement(By.cssSelector("a[title='Faded Short Sleeve T-shirts']"));
       action.moveToElement(firstitem).moveToElement(driver.findElement(By.cssSelector("a[data-id-product='1']"))).click().build().perform();
       
       //Go to checkout and then add another item
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Proceed to checkout']")));
       driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Continue shopping']")));
       driver.findElement(By.cssSelector("a[title='Continue shopping']")).click(); 
       WebElement seconditem = driver.findElement(By.cssSelector("a[title='Blouse']"));
       action.moveToElement(seconditem).moveToElement(driver.findElement(By.cssSelector("a[data-id-product='2']"))).click().build().perform();
       
       //Proceed to checkout and keep the same address and proceed again
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Proceed to checkout']")));
       driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']")));
       driver.findElement(By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']")).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='processAddress']")));
       driver.findElement(By.cssSelector("button[name='processAddress']")).click();
       
       //Accept the terms of service
       if ( !driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected() )
       {driver.findElement(By.cssSelector("input[type='checkbox']")).click();}
       
       //Pay using bank-wire payment and confirm your order
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='button btn btn-default standard-checkout button-medium']")));
       driver.findElement(By.cssSelector("button[class='button btn btn-default standard-checkout button-medium']")).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Pay by bank wire']")));
       driver.findElement(By.cssSelector("a[title='Pay by bank wire']")).click();
       if ( !driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']")).isSelected() )
       {driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']")).click();}
       
	}
	

}
