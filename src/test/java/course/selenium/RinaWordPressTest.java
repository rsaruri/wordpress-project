package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RinaWordPressTest {
	 
		
		public static WebDriver driver;
			
		@BeforeAll
		public static void OpenWebDriver() {
			System.setProperty("webdriver.chrome.driver", "C:/temp/chromedriver.exe");
			driver  = new ChromeDriver();
		}
			
			
		@Test
		public void Login() throws InterruptedException {
			driver.get("http://demosite.center/wordpress/wp-login.php");
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("user_login"));
			username.sendKeys("admin");
			WebElement userpassword = driver.findElement(By.id("user_pass"));
			userpassword.sendKeys("demo123");
			new Actions(driver).sendKeys(Keys.ENTER).perform();
			//driver.findElement(By.id("wp-submit")).click();
			Thread.sleep(9000);
			
		}

		/*@Test
		public void TestLocateElements() {
			WebElement elementA = driver.findElement(By.id("wp-version-message"));
			WebElement elementB = driver.findElement(By.className("welcome-icon welcome-widgets-menus"));
			WebElement elementC = driver.findElement(By.xpath("//*[@id=\"welcome-panel\"]/a"));	
			WebElement elementD = driver.findElement(By.name("post_title"));
			WebElement elementH = driver.findElement(By.linkText("Write your first blog post"));
		}*/
		

		/*@Test
		public void LastPost() throws InterruptedException {
			WebElement PostElement = driver.findElement(By.id("menu-posts"));
			//WebElement PostElement = driver.findElement(By.xpath("//*[@href='edit.php']//*[@class='wp-menu-name']"));
			PostElement.click();
			Thread.sleep(2000);
			WebElement AllPostElement = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]//*[@class=\"wp-menu-image dashicons-before dashicons-admin-post\"]"));
			AllPostElement.click();
			WebElement ListPost = driver.findElement(By.id("the-list"));
 			String PostName=ListPost.findElement(By.xpath("//*[@id=\"post-1\"]/td[1]/strong/a")).getText();
			assertTrue(PostName.equals("Hello world"));
		}*/
		
		
		/*@Test
		public void TestPostAndTags() throws InterruptedException {
				WebElement postelement = driver.findElement(By.id("menu-posts"));
				new Actions(driver).moveToElement(postelement).perform();
				Thread.sleep(2000);
				WebElement tagelement = driver.findElement(By.xpath("//*[@href=\"edit-tags.php?taxonomy=post_tag\"]"));
				new Actions(driver).moveToElement(tagelement).perform();
				tagelement.click();
		}*/
		
		/*@Test
		public void SelectUncategorised() throws InterruptedException {	
			WebElement SelectPostElement = driver.findElement(By.id("cat"));
			SelectPostElement.click();
			Select CategoryFilter = new Select(SelectPostElement);
			CategoryFilter.selectByVisibleText("Uncategorised");
			driver.findElement(By.id("post-query-submit")).click();
		}*/
			
		@Test
		public void AddNewPost() throws InterruptedException{
			
			//Go to post
			WebElement PostElement = driver.findElement(By.id("menu-posts"));
			new Actions(driver).moveToElement(PostElement).perform();
			Thread.sleep(2000);
			
			//Go to add new post
			WebElement AddNewElement = driver.findElement(By.xpath("//*[@href=\"post-new.php\"]"));
			Thread.sleep(2000);
			new Actions(driver).moveToElement(AddNewElement).click().perform();
			Thread.sleep(2000);
			
			//Write the title of post
			WebElement AddTitlePost = driver.findElement(By.name("post_title"));
			AddTitlePost.sendKeys("Rina-This is my post title");
			Thread.sleep(2000);
			
			//Locate the frame that contains the editor
			WebElement contentFrame = driver.findElement(By.id("content_ifr"));
			
			//Switch to that frame
			driver.switchTo().frame(contentFrame);
			
			//Write the content of post
			WebElement AddContentPost = driver.findElement(By.xpath("//*[@data-id='content']"));
			AddContentPost.sendKeys("Rina-This is my post content");
			Thread.sleep(2000);
			
			//Switch back to the default frame
			WebElement webFrame = driver.findElement(By.id("wpwrap"));
			driver.switchTo().frame(webFrame);
			Thread.sleep(5000);
			
			//Click the publish button
			WebElement PublishPost = driver.findElement(By.id("publish"));
			PublishPost.click();
			Thread.sleep(2000);
			
			new Actions(driver).moveToElement(PostElement).perform();
			Thread.sleep(2000);
			WebElement AllPostElement = driver.findElement(By.id("menu-posts"));
			new Actions(driver).moveToElement(AllPostElement).click().perform();
		}
	
}
