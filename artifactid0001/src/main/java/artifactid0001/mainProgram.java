package artifactid0001;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.junit.After;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import java.lang.*;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import java.util.Scanner;
public class mainProgram {
	public WebDriver driver;
	protected static WebDriverWait wait;
	private static String userName;
	private static String password;
	private static String firefoxpath;
	public void set() {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter gittigidiyor username: ");

	    userName = myObj.nextLine();  // Read user input
	    System.out.println("Enter gittigidiyor password: ");

	    password = myObj.nextLine(); 
	    System.out.println("Enter path of firefox driver: ");
		firefoxpath = myObj.nextLine(); 
		System.setProperty("webdriver.gecko.driver", firefoxpath);
		driver = new FirefoxDriver(); 
		myObj.close();
	}
	public String login() {

		driver.get("https://www.gittigidiyor.com/uye-girisi");
		wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.id("L-UserNameField"))

				));
		driver.findElement(By.id("L-UserNameField")).sendKeys(userName);
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.id("L-PasswordField"))

				));
		driver.findElement(By.id("L-PasswordField")).sendKeys(password);
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.id("gg-login-enter"))

				));
		driver.findElement(By.id("gg-login-enter")).click();




		return driver.getCurrentUrl();
	}
	public String searchandnavigate() {
		wait = new WebDriverWait(driver,1500);
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.name("k"))

				));
		driver.findElement(By.name("k")).sendKeys("Bilgisayar");

		driver.findElement(By.name("k")).sendKeys(Keys.ENTER);


		String Xpath="/html/body/div[4]/div[1]/div/div[2]/div[5]/ul/li[2]/a";
		String Xpath2 = "/html/body/div[4]/div[2]/div/div/a";
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath2))

				));

		driver.findElement(By.xpath(Xpath2)).click();
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath))

				));
		driver.findElement(By.xpath(Xpath)).click();
		return driver.getCurrentUrl();
	}
	public boolean chooseItem() {

		String Xpath4 = "//p[contains(@class, 'robotobold')]";

		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath4))

				));
		String price =driver.findElement(By.xpath(Xpath4)).getText();
		

		String Xpath3 = Xpath4 + "/ancestor::a";

		String link1 = driver.findElement(By.xpath(Xpath3)).getAttribute("href");

		driver.get(link1);
		String Xpath5 = "//*[@id=\"add-to-basket\"]";
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath5))

				));
		driver.findElement(By.xpath(Xpath5)).click();
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath5))

				));
		driver.get("https://www.gittigidiyor.com/");
		String Xpath6 = "//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[2]/a";
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath6))

				));
		driver.findElement(By.xpath(Xpath6)).click();
		String Xpath7 =  "/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[5]/div[1]/div[2]/strong";

		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath7))

				));
		String price2 = driver.findElement(By.xpath(Xpath7)).getText();
		
		return (price2.equals(price));

	} 
	public String count() {

		String Xpath8 = "/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select"; 
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath8))

				));
		Select sbox = new Select(driver.findElement(By.xpath(Xpath8)));
		sbox.selectByValue("2");
		List<WebElement> l = sbox.getAllSelectedOptions();
		return l.get(0).getText();


	}
	public int empty() {
		String Xpath9 = "/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a[1]/i";
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath9))

				));

		driver.findElement(By.xpath(Xpath9)).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver.findElements(By.xpath(Xpath9)).size();


	}
}
