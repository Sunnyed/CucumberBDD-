Feature: Login Page feature

Scenario: Login Page Title
Given User is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forget password link
Given User is on login page
Then forget your passowrd link should be displayed

Scenario: Login with correct Credentials
Given User is on login page
When user enters the username "sunnyed47@gmail.com"
And user enters the password "Selenium@12345"
And user clicks on the login button
Then user gets the title of the page
And page title should be "My account - My Store"