import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BasePage {

    //Clicking element
    public static void clickElementBy(By by)
    {
        driver.findElement(by).click();

    }
    //enterText element
    public static void enterText(By by , String text)
    {
        driver.findElement (by).sendKeys(text);

    }
    //selectTextByValue element
    public static void selectTextByValue(By by,String text)
    {
        Select select = new Select(driver.findElement(by));

        select.selectByValue(text);
    }
    //waitForElement
    public static void waitForElement(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
     //getTextFromElement
    public static String getTextFromElement(By by){
       return driver.findElement(by).getText();
    }

    public static int getRandomNumber(){
        return (int)(Math.random() * 5000 + 1);
    }
    //Clear Text from inout box/area
    public static void clearField(By by)
    {
        BasePage.driver.findElement(by).clear();
    }
    }




