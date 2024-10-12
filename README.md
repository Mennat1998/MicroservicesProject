#Microservices Project 

# Flow of my code
Any Request user send first will go to The Authentication Filter Created in Api Gateway and it will check  on authorization Header
if it is presented will validate token if it is correct allow him to redirect to the corresponding microservice otherWise it will
throw exception 

# Here we have authentication service
- to able the user to register
- to able user login and gives him jwt token to be authentication

# Also we have employee service
- CRUD methods for Employee entity
- Validation on the employee data inserted using custom validation
- handling errors using custom exception handling
- maintaining multi-language validation messages (English , arabic ) depends on header parameter

# Discovery service
- to register our services inside it

# Api Gateway 
- to allow us to talk to our services through it


# steps
- After Running All services, Eureka is running on port http://localhost:8761 to see registerd instances
- ApiGateWay is running on port 8080 http://localhost:8080/auth/register use this to register
- Then http://localhost:8080/auth/getToken to login and get access token
- then to access employee service you need to add authorization bearer and add token and access employee methods
- For Example: http://localhost:8080/employee to get all employees and so on 
