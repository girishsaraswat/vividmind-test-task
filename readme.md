First run the application 
1. call the login api using postman
 
 URL = http://localhost:8080/api/v1/public/login
 Content-Type = application/json
 BodyParameters = { "username" :"admin"
		    "password" :"admin12"}
2. login api check username and password is authenticate after that respone in return token;

3. How to call refresh remote api
    URL = http://localhost:8080/api/v1/tours/refresh
    Header parameter:
    Authorization: token pass from the login api 
    BodyParameters :  {
			 "filters": ""}  // filter == null or filter =""   then import json
                                         //filter in other parameter then seaching by filter parameters 


  














 