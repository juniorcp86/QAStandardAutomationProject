package utils.externalConnections;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.browser.prepareBrowser;

/**
 * Creation Date: 04/07/2017
 * Created By: Created by @JuniorCasique.
 * Description: This class is to complete sign in with test email account using gmail.
 */
public class emailConnection extends prepareBrowser {
    protected WebDriver driver;
    public Logger log;

    /**
     * Name: emailConnection()
     * Creation Date: 05/07/2017
     * Description: Function to log in with test email.
     * It has two arguments:
     * 1. user: Gmail user account.
     * 2. password: Password for email account.
     * */
    protected void emailConnection(String user, String password){
        String emailURL = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        log = Logger.getLogger(emailConnection.class);
        log.info("Start connection with email page");
        log.info("Open a new tab and log in on test email");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND + "t");
        driver.get(emailURL);
        explicitWait(driver,5);
        log.info("Currently on email page " +  driver.getCurrentUrl());
        driver.findElement(By.id("logo"));//Google Logo
        driver.findElement(By.id("identifierId"));//TextField for email
        driver.findElement(By.id("identifierNext"));//Next button
        driver.findElement(By.id("identifierId")).sendKeys(user);//Email information
        log.info("Write email account");
        driver.findElement(By.id("identifierNext")).click();//Next button
        explicitWait(driver,5);
        driver.findElement(By.id("profileIdentifier"));//Email information load from previous step
        driver.findElement(By.name("password"));//TextField for password
        log.info("Write password");
        driver.findElement(By.id("passwordNext"));//Next button for password page
        driver.findElement(By.name("password")).sendKeys(password);//Password information
        explicitWait(driver,2);
        driver.findElement(By.id("passwordNext")).click();//Next button for password page
        explicitWait(driver,5);
        log.info("Successful log in with tet account");
        log.info("Finish connection with email page");
    }
}