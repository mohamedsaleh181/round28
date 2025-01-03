package testPackage;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Duckduckgo;

public class DuckduckgoTest extends BaseTest {

//    @Test
    public void ValidateTitle(){
        driver.navigate().to(ConfigReader.getProperty("duckduckgoURL"));
        String title = driver.getTitle();
        Assert.assertEquals(title, ConfigReader.getProperty("duckduckgoTitle"));
        driver.quit();
    }

    @Test
    public void validateLogo(){
        Duckduckgo duckduckgo = new Duckduckgo(driver);
        duckduckgo.navigateToDuckduckgo();
        WebElement logo = duckduckgo.getLogo();
        Assert.assertTrue(logo.isDisplayed());
        driver.quit();
    }
}

