Feature: User can login
User can login successfully to Facebook.

Scenario Outline: User Login.
Given  User on login page
When   I entred "<email>", "<password>"
And    I logout from facebook  
Then   logout and naviagte to home page 
Examples:
| email | password |
|aasasasas@gmail.com | P@ssw0rd |

