Feature:create order
Scenario: order any product in amazon
Given login amazon using chrome browser
When user search any product and select any product
And  user buy that product
Then close the browser






Scenario: search any product
Given user enter amazon using chrome
When user search fpr product
Then close browser


