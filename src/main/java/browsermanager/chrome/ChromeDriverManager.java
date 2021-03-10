package browsermanager.chrome;

import driver.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }
}