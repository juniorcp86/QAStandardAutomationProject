package utils.browser;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Creation Date: 04/07/2017
 * Created By: Created by @JuniorCasique.
 * Description: This class is for start and set main characteristics browsers for every test.
 */
public class prepareBrowser {
    protected WebDriver driver;
    public Logger log;

    /**
     * Name: startBrowser()
     * Creation Date: 04/07/2017
     * Description: Function to creates instance for any browser (Firefox and Chrome)
     * It has one argument:
     * 1. browser: Value to be used and start specific driver for browser.
     * */
    @Parameters("browser")
    protected void startBrowser(String browser) {
        log = Logger.getLogger(prepareBrowser.class);
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            log.info("Creating instance for " + driver);
            driver.manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-fullscreen");
            driver = new ChromeDriver(chromeOptions);
            log.info("Creating instance for " + driver);
        }
        /**
         * Add flow for Safari, Internet Explorer and Edge.
         * For Safari
         * else if(browser.equalsIgnoreCase("safari")){
         *     driver = new SafariDriver();
         *     log.info("Creating instance for " + driver);
         * }
         * */
        else{
            log.info("There are no more browser driver to test");
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        log.info("Finish to create driver for browser starting test cases");
    }

    /**
     * Name: explicitWait()
     * Creation Date: 04/07/017
     * Description: This function helps to wait for some page resources.
     * It has two arguments:
     * 1. waitDriver: Browser's driver.
     * 2. timing: Value used to multiply and calculate time to wait for elements, page, etc.
     * */
    protected void explicitWait(WebDriver waitDriver, int timing){
        log = Logger.getLogger(prepareBrowser.class);
        synchronized (waitDriver){
            try{
                waitDriver.wait(timing * 1000);
                log.info("Waiting " + timing + " seconds");
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Name: takeScreenShot()
     * Creation Date: 05/07/2017
     * Description: Function to take entire screen shots on every browser.
     * It has two arguments:
     * 1. pathEvidence: Directory where evidences must be save.
     * 2. fileName: Screen shot name for image taken. Always has ".png" as extension.
     * 3. browser: It is an additional argument to create differente directories for all test on every browser.
     * */
    public void takeScreenShot(String pathEvidence, String fileName, String browser){
        if(browser.equals("firefox")){
            pathEvidence = pathEvidence + "Firefox//";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(pathEvidence + fileName + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            if(browser.equals("chrome")){
                pathEvidence = pathEvidence + "Chrome//";
                Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).withName(fileName).save(pathEvidence);
            }
        }
    }
}