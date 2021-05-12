package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoreTest {
    public WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("file:///Users/kristina_maksimova/untitled/src/main/resources/qa-test.html");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
