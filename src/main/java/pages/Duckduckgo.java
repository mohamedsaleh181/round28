package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Duckduckgo {
    private final WebDriver driver;

    private static final String LOGO_SELECTOR = "//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div[1]/section[1]/a";

    public Duckduckgo(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToDuckduckgo(){
        driver.navigate().to(ConfigReader.getProperty("duckduckgoURL"));
    }

    public WebElement getLogo(){
        return driver.findElement(By.xpath(LOGO_SELECTOR));
    }
}
