$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:/E:/CucumberFrameWork/Feature%20File/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "login with invalid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User enter facebook login page using chrome",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user enter valid email and invalid password",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Click on login button",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});