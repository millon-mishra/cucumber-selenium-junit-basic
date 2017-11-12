# Cucumber and Selenium WebDriver with Java and Maven
---
Cucumber, the buzz word in Automation testing. Here is the post on Cucumber and Selenium WebDriver implementation with Java to automate Web Application.

# Implemented the cucumber framework automation in this post taking Gmail login as example

## INTRODUCTION
Cucumber and Selenium WebDriver with Java is powerful combination with respect to Web Application automation. Cucumber is easy to learn and implement. Cucumber allow to write the test cases in format which is very similar to English understandable format, written by using language 'Gherkin'. Because of its easy implementation, language usage which is near to common English language and Selenium WebDriver combination which allow to run the same code on multiple browsers and different platform, combination of Cucumber and SeleniumWebDriver with java is more famous. 

## BASICS
Cucumber has three important sections 
* feature file
* step definition
* runner Class

Whole system run based on these files. Along with this, for this post created the Project using Maven which runs based on dependencies added in the pom.xml


## PROCESS OVERVIEW
Cucumber execution process depends on above mentioned 3 files. Lets address them in brief

### feature file
Feature file is like normal text file however extension should be as .feature. The language used in writing the feature file is Gherkin. feature file is referred by Stake holders, Business Analysts, Developers and also Testers. feature file contains the Scenarios, which are based on the User Stories. It need to use few specific keywords of Gherkin. First line of feature file should start with the Feature, followed by Scenario. There can be multiple Scenarios in the Feature file. Each Scenario can be complete using Given, When, Then, And, But.

```
Sample feature file

Feature: Gmail Testing
  Scenario: Gmail Login
    Given gmail url opened
    Then fill the user id
    And fill the password
    Then click on Login


  Scenario: Compose Email
    Given user logged in
    Then click on Compose button
    And fill the to subject content
    Then click on Send

  Scenario: Gmail logout
    Given user logged in
    When logout button visible
    Then click on logout
```

### stepDefinition
Once completed with writing scenario, as mentioned above, next step is to move ahead with writing the methods / functions for the scenarios mentioned in feature file. Typically, this section contains the actual login implementation for automation. Language would be based on the once choose for automation. Say like java, ruby, python and more. As part of this post, Java is language used and project created as Maven Project.

### RunnerClass
In simple terms, this can be referred as main class in typical java program from where the execution starts. In Cucumber, the execution starts from the RunnerClass. 
Along with these 3 section, when project created as Maven, one more important section is about POM.xml, all the dependencies of the project would be added in the POX.xml file. Dependencies are just like jar files references. Instead of typical way of downloading the jars and assigning to the project, would add dependencies of the jars into the POM.xml

## Basic dependencies which are required for Cucumber framework

1. Maven dependency for JUNIT
2. Maven dependency for Selenium-Java (Selenium WebDriver)
3. Maven dependency for Cucumber-core
4. Maven dependency for Cucumber-java
5. Maven dependency for Cucumber-junit

NOW THAT WE HAVE ENOUGH CONTENT ON CUCUMBER, LETS IMPLEMENT

As part of this post, we would be automation gmail login using Cucumber Framework

## PREREQUISITES:
1. Download and install Firefox developer edition 
```
https://www.mozilla.org/en-US/firefox/developer/
```
2. geckodriver.exe if using Selenium-Java webdriver version 3.0 or higher
```
https://github.com/mozilla/geckodriver/releases
```

## PROJECT SETUP
1. Step 1 : Create a maven java project using IntelliJ (maven java quickstart archetype)
2. Step 2 : Update the POM XML file with the above described 5 dependencies
````
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>nl.sogeti.millon</groupId>
    <artifactId>cucumber-selenium-junit-basic</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>cucumber-selenium-junit-basic</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.7.1</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-core</artifactId>
            <version>2.1.0</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java8</artifactId>
            <version>2.1.0</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>2.1.0</version>
        </dependency>
    </dependencies>
</project>

````
3. Step 3 : in the project src/test, create two folder test and resources
4. Step 4 : Create a feature file in the resource folder 
````
Feature: Gmail Testing

  Scenario: Gmail Login
    Given url opened
    Then enter user id and click next
    Then enter password
    And click login

  Scenario: Gmail Close
    Then Close browser
````
4. Step 5 : Generate a step definition file folowing the guide in the link [Creating Step Definition in IntelliJ](http://www.jetbrains.com/help/idea/creating-step-definition.html)
5. Step 6 : The step definition file should make use of the driver location as folows
````
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
        obj.findElement(By.id("identifierId")).sendKeys("*****");
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

````
6. Step 6 : Write a Runner file with the feature and report location
````
package nl.sogeti.millon;

/**
 * Created by MILLMISH on 12-11-2017.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Demo.feature",
        format = {"pretty","html:target/Reports"}
)
public class SystemtestRunnerTest {
}

````

## References
1. [Cucumber and Selenium WebDriver with Java and Maven](https://www.linkedin.com/pulse/cucumber-selenium-webdriver-java-maven-prashanth-aedulapuram/)
2. [Creating Step Definition IntelliJ IDEA](http://www.jetbrains.com/help/idea/creating-step-definition.html)
3. [Maven central repository for POM dependency search](https://search.maven.org/#search%7Cga%7C1%7C)
4. [Cucumber Tutorial - TutorialsPoint](https://www.tutorialspoint.com/cucumber/)
5. [Selenium Webdriver Tutorial - TutorialsPoint](https://www.tutorialspoint.com/selenium/selenium_webdriver.htm)