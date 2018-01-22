package scenarios.onBoarding;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.validations.numbersFields;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Creation Date: 28/12/2017
 * Created By: Created by @JuniorCasique.
 * Description: This class is to be used as example and template for automation project.
 */
public class templateTest extends numbersFields {
    /** General variables to be used loading static information, counters and paths. Alphabetical sorting (Type, variableName). */
    public int i;
    public Logger log;
    private String baseURL;
    public String browser;
    public String pathEvidence;
    public WebDriverWait wait;
    /** Variables to define bigger and dynamic components. Alphabetical sorting (Type, variableName). */
    private InputStream filePropertiesFront = null;
    private InputStream filePropertiesGeneral = null;
    public Properties frontEndComponents;
    public Properties generalComponents;

    /**
     * Name: setUp()
     * Creation Date: 28/12/2017
     * Description: Used to initialize all values need it on scenarios for this class.
     * */
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{
        //Set up logger configuration.
        log = Logger.getLogger(templateTest.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Set Up automated test for " + getClass().getName());
        //Initializing properties information.
        frontEndComponents = new Properties();
        filePropertiesFront = new FileInputStream("frontEndComponents.properties");
        frontEndComponents.load(filePropertiesFront);
        generalComponents = new Properties();
        filePropertiesGeneral = new FileInputStream("general.properties");
        generalComponents.load(filePropertiesGeneral);
        baseURL = generalComponents.getProperty("environment");
        pathEvidence = generalComponents.getProperty("pathEvidence") + "templateTest//";//This variable is to set path for screenshots. The fourth field is the name for automation test case
        //Set up browser information. Using headless (browser without graphic interface) by default with i = 1.
        i = 3;
        browser = "headless";
        log.info("Finish set up");
    }

    /**
     * Name: loadAllHtmlElements()
     * Creation Date: 28/12/2017
     * Description: Used to verify that buttons, fields, texts and additional components were loaded on the page before start functionality tests.
     * */
    @Test(priority = 1)
    public void loadAllHtmlElements() throws InterruptedException {
        log.info("Starting test case: " + getClass().getName() + ".loadAllHtmlElements()");
        //Manage cycle for every browser
        while (i < 4) {
            //Currently using (i < 4), because I don't have all browsers working successfully. Currently, missing Safari, Internet Explorer and Edge.
            if (i == 1) {
                startBrowser(browser);
                wait = new WebDriverWait(driver, 60);
                log.info("Open browser connection with " + driver);
            } else if (i == 2) {
                browser = "firefox";
                startBrowser(browser);
                wait = new WebDriverWait(driver, 60);
                log.info("Open browser connection with " + driver);
            }
            else if (i == 3) {
                browser = "chrome";
                startBrowser(browser);
                wait = new WebDriverWait(driver, 60);
                log.info("Open browser connection with " + driver);
            }
            else {
                log.info("There is no browser to test");
                i = 1;
            }
            //Starting functionality of test case
            driver.get(baseURL);
            log.info("Navigate to " + driver.getCurrentUrl());
            log.info("Waiting for Home page");
            takeScreenShot(pathEvidence,browser);
            takeScreenShot(pathEvidence,browser);
            takeScreenShot(pathEvidence,browser);
            log.info("Success test");
            driver.quit();
            i++;
        }





        /*
        * BLOQUE PARA AGREGAR LO QUE DEBE SER EVALUADO EN ESTE ESCENARIO
        * */
        log.info("Finishing " + getClass().getName() + "loadAllHtmlElements()");
        i = 1;
        browser = "headless";
    }

    /**
     * Name: finishTests()
     * Creation Date: 28/12/2017
     * Description: Close all connections with properties and finish browser to be prepared to execute a new scenario.
     * */
    @AfterTest
    public void finishTests() throws Exception{
        filePropertiesFront.close();
        filePropertiesGeneral.close();
        driver.quit();
        log.info("Finishing all test cases for " + getClass().getName() + " and closing browser.");
    }
}