Feature:Login functionality
Scenario Outline:To Check login functionality with mulitiple credentials
Given open facebook using chrome browser
When user enter username as"<username>" and password as "<password>"
Then user should not login



Examples:
|username|password|
|naga|1234|
|rajan|5677888|

