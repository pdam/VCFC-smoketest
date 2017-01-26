package com.pluribus.vcf.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import static org.testng.Assert.assertTrue;

/**
 *
 * @author Haritha
 */
public class TestInfra {

    private WebDriver driver;
    private ResourceBundle bundle;
    private String accessKey = "uZCXEzKXwgzgzMr3G7R6";
    private String server = "hub-cloud.browserstack.com";
    private String uName  = "pratikdam1";
   

    @BeforeTest(alwaysRun = true)
   public void startDriver() throws Exception {
    	Runtime.getRuntime().exec("src/test/resources/BrowserStackLocal --key uZCXEzKXwgzgzMr3G7R6 --daemon  start");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setPlatform(Platform.MAC);
		capability.setCapability("build", "VCFC Test Cases");
		capability.setCapability("browserstack.local", "true");
		
		driver = new RemoteWebDriver(
			      new URL("https://pratikdam1:uZCXEzKXwgzgzMr3G7R6@hub-cloud.browserstack.com/wd/hub"),
			      capability
			    );
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

        // Get a handle to the driver. This will throw an exception if a matching driver cannot be located

        driver.get("https://10.9.10.208/");

    }

    @AfterTest(alwaysRun = true)
    public void setupAfterSuite() throws IOException {
        driver.close();
        driver.quit();
        Runtime.getRuntime().exec("src/test/resources/BrowserStackLocal --key uZCXEzKXwgzgzMr3G7R6 --daemon  stop");
    }

    public boolean isContainsText(String text) {
        return driver.getPageSource().contains(text);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver getDriver(String host1) {
        driver.navigate().to(host1);
        int i = 10;
        while (!driver.getTitle().equalsIgnoreCase("Login Form")) {
            try {
                Thread.sleep(2000);
                if (driver.getTitle().contains("Fabric Stats")) {
                    break;
                } else {
                    driver.navigate().refresh();
                }
                Logger.getLogger(TestInfra.class.getName()).log(Level.INFO, "Page title is " + driver.getTitle());
                Logger.getLogger(TestInfra.class.getName()).log(Level.INFO, "Waiting for tomcat to start");
            } catch (InterruptedException ex) {
                Logger.getLogger(TestInfra.class.getName()).log(Level.SEVERE, null, ex);
            }
            i--;
            if (i <= 0) {
                break;
            }
        }
        return driver;
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void pageRefresh() {
        driver.navigate().refresh();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenShot() {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Date date = new Date();
//        String filePath = null;
//        if (System.getProperty("logPath") != null) {
//            filePath = System.getProperty("logPath").toString() + "/" + "ScreenShot" + date.getTime() + ".png";
//            try {
//                FileUtils.copyFile(scrFile, new File(filePath));
//            } catch (IOException ex) {
//                Logger.getLogger(TestInfra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    public String isRequired(String field) {
        String isrequired = getBundle().getString("errors.required").replace("{0}", field);
        return isrequired;
    }

    public String matchPattern(String field) {
        String isrequired = getBundle().getString("errors.required").replace("{0}", field);
        return isrequired;
    }
}

