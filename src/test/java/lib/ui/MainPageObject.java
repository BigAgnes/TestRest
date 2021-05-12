package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPageObject extends MainPage {
     static {
          LOGIN = "id:loginEmail";
          LOGIN_OPTION = "id:dataEmail";
          NAME = "id:dataName";
          PASSWORD = "id:loginPassword";
          SUBMIT_BUTTON = "id:authButton";
          GENDER_FIELD = "id:dataGender";
          SELECT_GENDER_WOMAN = "xpath://select/option[2]";
          INVALID_LOGIN_OR_PASSWORD_LABEL = "id:invalidEmailPassword";
          INVALID_LOGIN = "id:emailFormatError";
          ADD_OPTION_BUTTON = "id:dataSend";
          THE_DATA_ADDED = "css:div.uk-margin.uk-modal-content";
          BUTTON_OK_ON_THE_LABEL_DATA_ADDED = "css:button.uk-button.uk-button-primary.uk-modal-close";
          TABLE_E_MAIL = "xpath://tbody/tr[1]/td";
          TABLE_NAME = "xpath://tbody/tr[1]/td[2]";
          TABLE_GENDER = "xpath://tbody/tr[1]/td[3]";
          TABLE_OPTION_1 = "xpath://tbody/tr[1]/td[4]";
          TABLE_OPTION_2 = "xpath://tbody/tr[1]/td[5]";
          CHECKBOX_OPTION_1_1 = "id:dataCheck11";
          CHECKBOX_OPTION_1_2 = "id:dataCheck12";
          RADIOBUTTON_2_1 = "id:dataSelect21";
          RADIOBUTTON_2_2 = "id:dataSelect22";
          RADIOBUTTON_2_3 = "id:dataSelect23";
    }
    public MainPageObject(RemoteWebDriver driver){
        super(driver);
    }

    public void Authorization(String login, String password){
        this.waitForElementAndSendKeys(LOGIN, login, "Cannot input text on field 'LOGIN'", 10);
        this.waitForElementAndSendKeys(PASSWORD, password, "Cannot input text on field 'PASSWORD'", 10);
        this.takeScreenshot("submit.png");
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find or click button 'SUBMIT'", 10);
    }

    public void OptionName(String login, String name){
        this.waitForElementAndSendKeys(LOGIN_OPTION, login, "Cannot input text on field 'LOGIN'", 10);
        this.waitForElementAndSendKeys(NAME, name, "Cannot input text on field 'NAME'", 10);
        this.takeScreenshot("submitWithName.png");

    }

    public void AddOptionButton(){
        this.waitForElementAndClick(ADD_OPTION_BUTTON, "Cannot find or click button 'ADD'", 10);
        this.waitForElementPresent(THE_DATA_ADDED, "Cannot find present label 'The data has been added.'");
        this.waitForElementAndClick(BUTTON_OK_ON_THE_LABEL_DATA_ADDED, "Cannot find or click button 'OK'", 10);
    }

    public void AddCheckbox1(){
        this.waitForElementAndClick(CHECKBOX_OPTION_1_1, "Cannot find or click checkbox", 10);
        this.takeScreenshot("check1.png");
    }

    public void AddCheckbox2(){
        this.waitForElementAndClick(CHECKBOX_OPTION_1_2, "Cannot find or click checkbox", 10);
        this.takeScreenshot("check2.png");
    }

    public void AddRadioButton1(){
        this.waitForElementAndClick(RADIOBUTTON_2_1, "Cannot find or click button", 10);
        this.takeScreenshot("radio1.png");
    }

    public void AddRadiobutton2(){
        this.waitForElementAndClick(RADIOBUTTON_2_2, "Cannot find or click button", 10);
        this.takeScreenshot("radio2.png");
    }

    public void AddRadiobutton3(){
        this.waitForElementAndClick(RADIOBUTTON_2_3, "Cannot find or click button", 10);
        this.takeScreenshot("radio3.png");
    }

    public void SelectGenderOnWoman(){
        this.waitForElementAndClick(GENDER_FIELD, "Cannot find or click select gender", 10);
        this.waitForElementAndClick(SELECT_GENDER_WOMAN, "Cannot find or click select gender",10);
        this.takeScreenshot("genderWoman.png");
    }

    public void AssertTableInfo(String login, String name, String gender_men, String option_1, String option_2){
        this.takeScreenshot("table.png");
        this.assertElementHasText(TABLE_E_MAIL, login, login + " does not match");
        this.assertElementHasText(TABLE_NAME, name, name + " does not match");
        this.assertElementHasText(TABLE_GENDER, gender_men, gender_men + " does not match");
        this.assertElementHasText(TABLE_OPTION_1, option_1, option_1 + " does not match");
        this.assertElementHasText(TABLE_OPTION_2, option_2, option_2 + " does not match");
    }
}
