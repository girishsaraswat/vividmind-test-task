First run the application 


1. Call the Login API using postman
 
 URL = http://localhost:8080/api/v1/public/login
 Content-Type = application/json
 BodyParameters = 
 { 
 	"username" :"admin",
	"password" :"admin12"
  }
  
2. Login API will check username and password that those are Authenticated or not and After that response will appear with Token.

3. How to Call Refresh Remote API
    
    URL = http://localhost:8080/api/v1/tours/refresh
    
    Header parameter:-
    		Authorization: Pass the Token that you got from Login API 
    BodyParameters :  
    {
	"filter": ""
     }  
     // If filter == null or filter =""   
     	then import json for all Tours
     // If filter with other parameter 
         then will seach by filter parameter 


  














 
