package Tests;

import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FormTests extends CoreTest {
    String login = "test@protei.ru";
    String password = "test";
    String name = "testik";
    String gender_men = "Мужской";
    String gender_women = "Женский";


    @Test
    public void GenderMen(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);

        mainPageObject.AddOptionButton();
        mainPageObject.AssertTableInfo(login, name, gender_men, "Нет", "");
    }

    @Test
    public void GenderMenAndCheckTwo(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddCheckbox2();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "1.2", "");
    }

    @Test
    public void GenderWomenAndCheckOneAndTwo(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.SelectGenderOnWoman();
        mainPageObject.AddCheckbox1();
        mainPageObject.AddCheckbox2();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_women, "1.1, 1.2", "");
    }

    @Test
    public void GenderWomenAndCheckOne(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.SelectGenderOnWoman();
        mainPageObject.AddCheckbox1();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_women, "1.1", "");
    }

    @Test
    public void GenderWomenAndOptionTwo(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.SelectGenderOnWoman();
        mainPageObject.AddRadioButton1();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_women, "Нет", "2.1");
    }

    @Test
    public void GenderWomenAndCheckOneAndOptionTwo(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.SelectGenderOnWoman();
        mainPageObject.AddCheckbox1();
        mainPageObject.AddRadiobutton2();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_women, "1.1", "2.2");
    }

    @Test
    public void GenderMenAndCheckOneAndTwoAndOptionOne(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddCheckbox1();
        mainPageObject.AddCheckbox2();
        mainPageObject.AddRadioButton1();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "1.1, 1.2", "2.1");
    }

    @Test
    public void GenderMenAndCheckTwoAndOptionTwo(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddCheckbox2();
        mainPageObject.AddRadiobutton2();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "1.2", "2.2");
    }

    @Test
    public void GenderMenAndOptionOne(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddRadioButton1();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "Нет", "2.1");
    }

    @Test
    public void GenderMenAndCheckOneAndTwoAndOptionThree(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddCheckbox1();
        mainPageObject.AddCheckbox2();
        mainPageObject.AddRadiobutton3();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "1.1, 1.2", "2.3");
    }

    @Test
    public void GenderMenAndCheckOneAndTwoAndOptionTwo(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddCheckbox1();
        mainPageObject.AddCheckbox2();
        mainPageObject.AddRadiobutton2();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "1.1, 1.2", "2.2");
    }

    @Test
    public void GenderWomenAndCheckOneAndOptionOne(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.SelectGenderOnWoman();
        mainPageObject.AddCheckbox1();
        mainPageObject.AddRadioButton1();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_women, "1.1", "2.1");
    }

    @Test
    public void GenderWomenAndOptionThree(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.SelectGenderOnWoman();
        mainPageObject.AddRadiobutton3();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_women, "Нет", "2.3");
    }

    @Test
    public void GenderWomenAndCheckOneAndOptionThree(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.SelectGenderOnWoman();
        mainPageObject.AddCheckbox1();
        mainPageObject.AddRadiobutton3();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_women, "1.1", "2.3");
    }

    @Test
    public void GenderMenAndCheckOneAndOptionTwo(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddCheckbox1();
        mainPageObject.AddRadiobutton2();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "1.1", "2.2");
    }

    @Test
    public void GenderMenAndCheckTwoAndOptionThree(){
        MainPageObject mainPageObject = new MainPageObject((RemoteWebDriver) driver);

        mainPageObject.Authorization(login, password);
        mainPageObject.OptionName(login, name);
        mainPageObject.AddCheckbox2();
        mainPageObject.AddRadiobutton3();

        mainPageObject.AddOptionButton();

        mainPageObject.AssertTableInfo(login, name, gender_men, "1.2", "2.3");
    }
}
