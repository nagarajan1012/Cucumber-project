Feature: Login
Scenario: login with invalid credentials
Given User enter facebook login page using chrome
When user enter valid email and invalid password
Then Click on login button

