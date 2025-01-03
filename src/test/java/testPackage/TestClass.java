package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class TestClass {
//    private static final LoggerUtil log = LoggerUtil.getLogger(TestClass.class);
private final  Logger log = LoggerFactory.getLogger(TestClass.class);

    // #1
    @Test
    public void ValidateTitle(){
        log.info("Starting the test case.");
        log.info("Opening the browser.");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://duckduckgo.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "DuckDuckGo - Your protection, our priority.");
        driver.quit();
    }
    // #2
    @Test
    public void validateLogo(){
//        WebDriver driver = new ChromeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://duckduckgo.com/");
//        WebElement logo = driver.findElement(By.cssSelector("a[title=\"Learn about DuckDuckGo\"] img"));
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div[1]/section[1]/a"));
        Assert.assertTrue(logo.isDisplayed());
        driver.quit();
    }
    // #3
    @Test
    public void validateFirstResultLink(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://duckduckgo.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
        List<WebElement> searchResults = driver.findElements(By.cssSelector("a[data-testid='result-title-a']"));
        searchResults.getFirst().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/documentation/webdriver/");
        driver.quit();
    }
    // #4
    @Test
    public void validateFourthResultText(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://duckduckgo.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.submit();
        List<WebElement> searchResults = driver.findElements(By.cssSelector("a[data-testid='result-title-a']"));
        String resultText = searchResults.get(3).getText();
        Assert.assertEquals(resultText, "TestNG Tutorial");
        driver.quit();
    }
    // #5
    @Test
    public void validatesecondResultLink(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://duckduckgo.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Cucumber IO");
        searchBox.submit();
        List<WebElement> searchResults = driver.findElements(By.cssSelector("a[data-testid='result-title-a']"));
        searchResults.get(1).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com"));
        driver.quit();
    }
    // #6
    @Test
    public void validateCheckedCheckBoxes(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.cssSelector("form input:nth-child(1)"));
        checkBox1.click();
        WebElement checkBox2 = driver.findElement(By.cssSelector("form input:nth-child(3)"));
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());
        driver.quit();
    }
    // #7
    @Test
    public void validateCountryForCompany(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        String country = driver.findElement(By.cssSelector("table#customers tr:nth-child(4) td:nth-child(3)")).getText();
        Assert.assertEquals(country, "Austria");
        driver.quit();
    }
    // #7-2
//    @Test
//    public void validateCountryForCompany02(){
//        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
//        List<WebElement> companies = driver.findElements(By.cssSelector("table#customers tr td:nth-child(1)"));
//        int rowIndex = 0;
//        for (int i = 0; i < companies.size(); i++){
//            if (companies.get(i).getText().equals("Ernst Handel")){
//                rowIndex = i;
//                break;
//            }
//        }
//        WebElement country = driver.findElement(By.cssSelector("table#customers tr:nth-child(" + rowIndex + 1 + ")" + "td:nth-child(1)"));
//        Assert.assertEquals(country.getText(), "Austria");
//        driver.quit();
//    }
    // #8
    @Test
    public void validateUploadingImage(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("C:\\Users\\Mohamed\\IdeaProjects\\round28\\src\\main\\resources\\image.jpg");
        driver.findElement(By.id("file-submit")).click();
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(), "image.jpg");
        driver.quit();
    }
    // #9
    @Test
    public void validateDragAndDrop(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        WebElement element = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element, target).perform();
        Assert.assertEquals(target.getText(), "Dropped!");
        driver.quit();
    }
}
