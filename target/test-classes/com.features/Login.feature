Feature: Login Functionality

Scenario: Login with valid credentials
Given user navigates to login page
And user enters valid email address "bharathkumar.kiaq@gmail.com" into email field
And user enters valid password "Bharath02112001@" into password field
When user click the login button
Then user should get successfully logged in

Scenario: Login with invalid credentials
Given user navigates to login page
And enters valid email address "bharath.kiaq@gmail.com" into email field
And enters valid password "Bharath@" into password field
When user click the login button
Then user should get the proper warning message about credentials mismatch