package Tests;

import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationTests extends CoreTest {
    String login = "test@protei.ru";
    String password = "test";

    @Test
    public void AuthorizationWithLoginAndPassword(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.waitForElementPresent(mainPageObject.GENDER_FIELD, "Cannot find present gender field", 15);
    }

    @Test
    public void AuthorizationOnlyWithLogin(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, "");
        mainPageObject.waitForElementPresent(mainPageObject.INVALID_LOGIN_OR_PASSWORD_LABEL, "Cannot find present label for invalid password or login", 15);
        mainPageObject.waitForElementNotPresent(mainPageObject.GENDER_FIELD, "We find present gender field", 15);
    }

    @Test
    public void AuthorizationOnlyWithPassword(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization("", password);
        mainPageObject.waitForElementPresent(mainPageObject.INVALID_LOGIN, "Cannot find present label for invalid password or login", 15);
        mainPageObject.waitForElementNotPresent(mainPageObject.GENDER_FIELD, "We find present gender field", 15);
    }

    @Test
    public void EmptyAuthorization(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.waitForElementAndClick(mainPageObject.SUBMIT_BUTTON, "Cannot find or click button 'SUBMIT'", 10);
        mainPageObject.waitForElementPresent(mainPageObject.INVALID_LOGIN, "Cannot find present label for invalid password or login", 15);
        mainPageObject.waitForElementNotPresent(mainPageObject.GENDER_FIELD, "We find present gender field", 15);
    }



}
