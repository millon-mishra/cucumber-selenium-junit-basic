$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Demo.feature");
formatter.feature({
  "name": "Gmail Testing",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Gmail Login",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "url opened",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.urlOpened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter user id and click next",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.enterUserIdAndClickNext()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter password",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.enterPassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click login",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Gmail Close",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
});