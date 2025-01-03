package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod(description = "Set up brow and navigate to base URL")
    public void setUp(String browser) {
        String brow = browser.toLowerCase().trim();

        switch (brow) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported brow: " + brow);
        }

//        LoggingPreferences logs = new LoggingPreferences();
//        logs.enable(LogType.BROWSER, Level.ALL);

//        driver.get(ConfigReader.getProperty("baseUrl"));
//        Logger.log("Driver setup completed.");
    }
}
