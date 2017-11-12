package nl.sogeti.millon.stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by MILLMISH on 12-11-2017.
 */
public class MyStepdefs {

    public static WebDriver obj = null;


    @Given("^url opened$")
    public void urlOpened() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver", "D:\\millon\\projects\\cito\\cucumber-selenium-junit-basic\\geckodriver.exe");
        obj = new FirefoxDriver();
        obj.manage().window().maximize();
        obj.get("https://mail.google.com");
    }

    @Then("^enter user id and click next$")
    public void enterUserIdAndClickNext() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        obj.findElement(By.id("identifierId")).sendKeys("****");
        obj.findElement(By.className("CwaK9")).click();
        Thread.sleep(2000);
    }

    @Then("^enter password$")
    public void enterPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        obj.findElement(By.className("Xb9hP")).sendKeys("****");
    }

    @And("^click login$")
    public void clickLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        obj.findElement(By.className("CwaK9")).click();
        Thread.sleep(6000);
    }

    @Then("^Close browser$")
    public void closeBrowser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        obj.quit();
    }
}
