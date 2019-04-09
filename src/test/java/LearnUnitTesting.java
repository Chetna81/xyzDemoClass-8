import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LearnUnitTesting {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\softwaretest\\chromedriver.exe");
        driver = new ChromeDriver();
        // The implicit wait is set for the life of the webDriver Object instance.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // asking driver to get url
        driver.get("https://demo.nopcommerce.com/"); }
        @Test
        public void Register_Successfully(){
        //registration for new user
        driver.findElement(By.linkText("Register")).click();
        //enter the first name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("krish");
        //enter the last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("patel");
        //enter the email id
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("krishsuvagiya1@yahoo.com");
        //enter the password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("krish123");
        //enter the confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("krish123");
        //click to register button
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        String message = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
        Assert.assertEquals("Log out",message);
        System.out.println("User should be registration successfully");

        }
        @Test
        public void Computer(){
        //click on computer
        driver.findElement(By.linkText("Computers")).click();
        //click on noyebooks
        driver.findElement(By.partialLinkText("Notebooks")).click();
        String message = driver.findElement(By.xpath("//h1[contains(text(),'Notebooks')]")).getText();
        Assert.assertEquals("Notebooks", message);
        System.out.println("User should be able to navigate notebook category page");

        }
        @Test
        public void electronics(){
        //click to the Electronic
        driver.findElement(By.linkText("Electronics")).click();
        //click to Cellphones page
        driver.findElement(By.partialLinkText("Cell phones")).click();
        //get actual message
        String message = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        Assert.assertEquals("Cell phones",message);
        System.out.println("User should be able to navigate electronics category page");
        }
        @Test
        public void login(){
        //login for new user
         driver.findElement(By.xpath("//a[@class='ico-login']")).click();
         //enter the email id
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("krishsuvagiya1@yahoo.com");
         //enter the password
         driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("krish123");
         //click the login button
         driver.findElement(By.xpath("//input[@value='Log in']")).click();
         String message = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
         Assert.assertEquals("Log out",message);
         System.out.println("User should be login successfully");
        }
        @Test
        public void shopping_cart() {
        //click on add to cart
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
        //get actual message
        String message = driver.findElement(By.xpath("//div[@class='product-name']")).getText();
        Assert.assertEquals("Build your own computer",message);
        System.out.println("User should be able to add product");
        }
        @After
        public void tearDown()
        {
            driver.quit();
        }
        }

