package lib.ui;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.regex.Pattern;

public class MainPage {
    public RemoteWebDriver driver;

    public static String
            LOGIN,
            LOGIN_OPTION,
            NAME,
            PASSWORD,
            SUBMIT_BUTTON,
            GENDER_FIELD,
            SELECT_GENDER_WOMAN,
            INVALID_LOGIN_OR_PASSWORD_LABEL,
            INVALID_LOGIN,
            ADD_OPTION_BUTTON,
            THE_DATA_ADDED,
            BUTTON_OK_ON_THE_LABEL_DATA_ADDED,

            TABLE_E_MAIL,
            TABLE_NAME,
            TABLE_GENDER,
            TABLE_OPTION_1,
            TABLE_OPTION_2,

            CHECKBOX_OPTION_1_1,
            CHECKBOX_OPTION_1_2,
            RADIOBUTTON_2_1,
            RADIOBUTTON_2_2,
            RADIOBUTTON_2_3;

    public MainPage(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public void assertElementHasText(String locator, String expected_text, String error_message)
    {
        WebElement title_element = waitForElementPresent(locator);
        String actual_text = title_element.getText();
        Assert.assertEquals(error_message, expected_text, actual_text);
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    /* CONSTRUCTOR waitForElementPresent */

    public WebElement waitForElementPresent(String locator, String error_message)
    {
        return waitForElementPresent(locator, error_message, 10);
    }

    public WebElement waitForElementPresent(String locator)
    {
        return waitForElementPresent(locator, "Element not found", 10);
    }

    /* CONSTRUCTOR waitForElementPresent */

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );

    }

    public By getLocatorByString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if(by_type.equals("xpath"))
        {
            return By.xpath(locator);
        }
        else if (by_type.equals("id"))
        {
            return By.id(locator);
        }
        else if (by_type.equals("name"))
        {
            return By.name(locator);
        }
        else if (by_type.equals("css"))
        {
            return By.cssSelector(locator);
        }
        else
        {
            throw new IllegalArgumentException("Cannot get type of locator. Locator " + locator_with_type);
        }
    }

    public String takeScreenshot(String name)
    {
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name +"_screenshot.png";
        try
            {
                FileUtils.copyFile(source, new File(path));
                System.out.println("The screenshot was taken: " + path);
            }
        catch (Exception e)
        {
            System.out.println("Cannot take screenshot. Error: " + e.getMessage());
        }
        return path;
    }

}
