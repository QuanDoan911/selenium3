package logigear_mail.testcases;

import driver.DriverProperty;
import driver.DriverUtilities;
import driver.manage.DriverManagerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import utilities.BrowserSettingHelper;
import utilities.JsonHelper;

import java.io.File;
import java.io.IOException;

import static common.Constants.*;

public class BaseTest {

    public String testCaseName;

    @BeforeClass
    public void beforeClass() {
        testCaseName = this.getClass().getSimpleName();
    }

    @BeforeMethod
    public void beforeMethod() throws IllegalAccessException {
        DriverProperty property = BrowserSettingHelper.getDriverProperty(BROWSER_CONFIGURATION, BROWSER + "." + RUN_ON);
        DriverManagerFactory.createWebDriver(property);
        DriverUtilities.maximizeBrowser();
    }

    @AfterMethod
    public void afterMethod() {
        DriverUtilities.closeBrowser();
    }

    @DataProvider
    public Object[][] getDataForTest() throws IOException {
        String DataFilePath = TEST_DATA_JSON + File.separator + this.getClass().getPackage().getName().replace(".", File.separator) + File.separator + "data.json";
        Object[][] data = JsonHelper.getData(testCaseName, DataFilePath);
        return data;
    }
}
