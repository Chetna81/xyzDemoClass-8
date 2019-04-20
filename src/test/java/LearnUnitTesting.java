import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LearnUnitTesting extends Utils {


    @Before
    //this will be executed before every test run
    public void setUp() {
        // this is to setup your path to the chrome driver
        System.setProperty("webdriver.chrome.driver", "src\\test\\softwaretest\\chromedriver.exe");

        // this is to create the object for your driver which is in the class
        driver = new ChromeDriver();

        // The implicit wait is set for the life of the webDriver Object instance.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // this is to maximise your browser window
        driver.manage().window().maximize();

        // this is the website you want to visit for your testing purposes
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void Register_Successfully() {
        //registration for new user
        //driver.findElement(By.linkText("Register")).click();
        clickElementBy(By.linkText("Register"));

        //asking driver to select gender
        //driver.findElement(By.id("gender-female")).click();
        clickElementBy(By.id("gender-female"));

        //asking driver to enter the first name
        //driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("krish");
        enterText(By.id("FirstName"), "krish");

        //asking driver to enter the last name
        //driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("patel");
        enterText(By.id("LastName"), "patel");

        // asking driver to select day of  birth
        //driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("10");
        selectTextByValue(By.xpath("//select[@name='DateOfBirthDay']"), "10");

        //asking driver to select day of  month
        //driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("october");
        enterText(By.xpath("//select[@name='DateOfBirthMonth']"), "october");

        //asking driver to select day of year
        //driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("2010");
        enterText(By.xpath("//select[@name='DateOfBirthYear']"), "2010");

        //asking driver to enter the email id
        //driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("krishsuvagiya@yahoo.com");
        String email = "krishsuvagiya" + getRandomNumber() + "@yahoo.com";
        enterText(By.xpath("//input[@id='Email']"), email);
        System.out.println(email);


        //asking driver to enter password
        //driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("krish123");
        enterText(By.xpath("//input[@id='Password']"), "krish123");

        //asking driver to enter confirm password
        //driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("krish123");
        enterText(By.xpath("//input[@id='ConfirmPassword']"), "krish123");

        //asking driver to click on register button
        //driver.findElement(By.xpath("//input[@id='register-button']")).click();
        clickElementBy(By.xpath("//input[@id='register-button']"));

        //verify actual result equals expected result
        //String actualresult  = driver.findElement(By.xpath("Your Registration Completed")).getText();
        String expectedMessage = "Your registration completed";
        //String expectedresult = "Your registration completed";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        //Assert.assertEquals(expectedresult,"Your Registration Completed");
        Assert.assertEquals(expectedMessage, actualMessage);
        }


    @Test
    public void Computer() {
        //click on computer
        //driver.findElement(By.linkText("Computers")).click();
        clickElementBy(By.linkText("Computers"));

        //click on notebooks
        //driver.findElement(By.partialLinkText("Notebooks")).click();
        clickElementBy(By.partialLinkText("Notebooks"));

        //verify actual result equals expected result
        String expectedMessage = "Notebooks";
        //String message = driver.findElement(By.xpath("//h1[contains(text(),'Notebooks')]")).getText();
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Notebooks')]"));
        //Assert.assertEquals("Notebooks", message);
        Assert.assertEquals(expectedMessage, actualMessage);

        System.out.println("User should be able to navigate notebook category page");
        }


    @Test
    public void electronics()
        {
        //click to the Electronic
        //driver.findElement(By.linkText("Electronics")).click();
        clickElementBy(By.linkText("Electronics"));

        //click to Cellphones page
        //driver.findElement(By.partialLinkText("Cell phones")).click();
        clickElementBy(By.partialLinkText("Cell phones"));

        //verify actual result equals expected result
        String expectedMessage = "Cell phones";
        //String message = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        //Assert.assertEquals("Cell phones", message);
        Assert.assertEquals(expectedMessage,actualMessage);

        System.out.println("User should be able to navigate electronics category page");
        }

    @Test
    public void login()
        {
        //asking driver should be able to login for new user
        //driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        clickElementBy(By.xpath("//a[@class='ico-login']"));

        //asking driver to enter email id
        //driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("krishsuvagiya1@yahoo.com");
        //String email = "krishsuvagiya@yahoo.com";
        enterText(By.xpath("//input[@id='Email']"),"krishsuvagiya4224@yahoo.com");


        //asking driver to enter password
        //driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("krish123");
        enterText(By.xpath("//input[@id='Password']"), "krish123");

        //asking driver to click on login button
        //driver.findElement(By.xpath("//input[@value='Log in']")).click();
        clickElementBy(By.xpath("//input[@value='Log in']"));

        //verify actual result equals expected result
        String expectedMessage = "Log out";
        //String message = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
        String actualMessage = getTextFromElement(By.xpath("//a[@class='ico-logout']"));
        //Assert.assertEquals("Log out", message);
        Assert.assertEquals(expectedMessage,actualMessage);
        //System.out.println("User should be login successfully");
    }

    @Test
    public void shopping_cart() {
        //click on add to cart
        //driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
        clickElementBy(By.xpath("//input[@value='Add to cart']"));

        //get actual mess
        String expectedMessage = "Build your own computer";
        //String message = driver.findElement(By.xpath("//div[@class='product-name']")).getText();
        String actualMessage = getTextFromElement(By.xpath("//div[@class='product-name']"));
        //Assert.assertEquals("Build your own computer", message);
        Assert.assertEquals(expectedMessage,actualMessage);
        System.out.println("User should be able to add product");
    }

    @After
    // this will be executed after every Test run
    public void tearDown() {
        driver.quit();
    }
}

