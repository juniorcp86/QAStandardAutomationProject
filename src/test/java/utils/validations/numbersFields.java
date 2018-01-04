package utils.validations;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.browser.prepareBrowser;

/**
 * Creation Date: 03/01/2018
 * Created By: Created by @JuniorCasique.
 * Description: Class with scenarios with tests for fields that allows only numbers fields (phone number, extension number, age, postal code and others).
 */
public class numbersFields extends prepareBrowser {
    public int i;
    public Logger log;

    /**
     * Name: phoneNumber()
     * Creation Date: 03/01/2018
     * Description: Use this function to review scenarios with fields that allows to write personal phone number, home number and/or business number.
     * It has one argument:
     * 1. String fieldId: Gets id/xpath/classname or any unique element to identify field on front-end.
     * */
    protected void phoneNumber(String fieldId) {
        log = Logger.getLogger(numbersFields.class);
        log.info("Starting scenarios for test with phoneNumber()");
        //Scenario for empty numbers field
        log.info("Starting scenario for empty numbers field.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("");
        log.info("Finishing scenario for empty numbers field.");
        //Scenario for fill with blanks
        log.info("Starting scenario for fill with blanks.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("     ");
        log.info("Finishing scenario for fill with blanks.");
        //Scenario for fill just with letters
        log.info("Starting scenario for fill just with letters.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("ABCDEFGHIJKLMNO");
        log.info("Finishing scenario for fill just with letters.");
        //Scenario for fill just with special characters
        log.info("Starting scenario for fill just with special characters.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("!@#$%^&*()_+={}");
        log.info("Finishing scenario for fill just with special characters.");
        //Scenario for fill just with special characters and letters
        log.info("Starting scenario for fill just with special characters and letters.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("!@#$%^&*()abcde");
        log.info("Finishing scenario for fill just with special characters and letters.");
        //Scenario for fill just with special characters and numbers
        log.info("Starting scenario for fill just with special characters and numbers.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("!@#$%^&*()12345");
        log.info("Finishing scenario for fill just with special characters and numbers.");
        //Scenario for fill just with letters and numbers
        log.info("Starting scenario for fill just with letters and numbers.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("abcdefgh1234567");
        log.info("Finishing scenario for fill just with letters and numbers.");
        //Scenario with minimal numbers allow
        log.info("Starting scenario with minimal numbers allow.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("1");
        log.info("Finishing scenario with minimal numbers allow.");
        //Scenario with maximal numbers allow
        log.info("Starting scenario with maximal numbers allow.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("12345678901234567890");
        log.info("Finishing scenario with maximal numbers allow.");
        //Scenario with correct quantity numbers allow.
        log.info("Starting scenario for .");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("123456789012345");
        log.info("Finishing scenario with correct quantity numbers allow.");
        log.info("Finishing scenarios for test with phoneNumber()");
    }

    /**
     * Name: extensionNumber()
     * Creation Date: 03/01/2018
     * Description: Use this function to review scenarios with fields that allows to write extension number.
     * It has one argument:
     * 1. String fieldId: Gets id/xpath/classname or any unique element to identify field on front-end.
     * */
    protected void extensionNumber(String fieldId) {
        log = Logger.getLogger(numbersFields.class);
        log.info("Starting scenarios for test with extensionNumber()");
        //Scenario for empty numbers field
        log.info("Starting scenario for empty numbers field.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("");
        log.info("Finishing scenario for empty numbers field.");
        //Scenario for fill with blanks
        log.info("Starting scenario for fill with blanks.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("  ");
        log.info("Finishing scenario for fill with blanks.");
        //Scenario for fill just with letters
        log.info("Starting scenario for fill just with letters.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("ABC");
        log.info("Finishing scenario for fill just with letters.");
        //Scenario for fill just with special characters
        log.info("Starting scenario for fill just with special characters.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("!@#");
        log.info("Finishing scenario for fill just with special characters.");
        //Scenario for fill just with special characters and letters
        log.info("Starting scenario for fill just with special characters and letters.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("!de");
        log.info("Finishing scenario for fill just with special characters and letters.");
        //Scenario for fill just with special characters and numbers
        log.info("Starting scenario for fill just with special characters and numbers.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("!12");
        log.info("Finishing scenario for fill just with special characters and numbers.");
        //Scenario for fill just with letters and numbers
        log.info("Starting scenario for fill just with letters and numbers.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("a12");
        log.info("Finishing scenario for fill just with letters and numbers.");
        //Scenario with minimal numbers allow
        log.info("Starting scenario with minimal numbers allow.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("1");
        log.info("Finishing scenario with minimal numbers allow.");
        //Scenario with maximal numbers allow
        log.info("Starting scenario with maximal numbers allow.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("1234567890");
        log.info("Finishing scenario with maximal numbers allow.");
        //Scenario for correct extension quantity number allow
        log.info("Starting scenario for correct extension quantity number allow.");
        driver.findElement(By.id(fieldId)).clear();
        driver.findElement(By.id(fieldId)).sendKeys("123");
        log.info("Finishing scenario for correct extension quantity number allow.");
        log.info("Finishing scenarios for test with extensionNumber()");
    }
}