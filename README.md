
# Employee Backend

This repository is a collection of code that is used for supporting the RESTful APIs that are built and deployed as part of Employee Application

This Wiki Page will contain Information on how to get it up and running on your local machines for Testing
and development purpose.

# Pre-Requisites
1. Java 8
2. [Gradle 3.x or Higher](https://gradle.org/install)
3. IntelliJ or [STS](https://spring.io/tools/sts/all)
4. H2 In memory databas --> Note: You do not have to install any Databases


#Run the Application
gradle bootRun



The below steps help you to hit the REST APIs that insert the employee records and read the existing records as per the input criteria

1. Insert the existing employee

Use postman with the below request:

	POST request:

	localhost:8080/employee

Request body sample:

 	{
        "id": "1234Sharada",
        "name": "Sharada",
        "age": 62,
        "gender": "female"
 	}

Sample output: 

	{
    	"id": "1234Sharada",
   		"name": "Sharada",
    	"age": 62,
    	"gender": "female"
	}



2. Read the existing documents:

	GET request:

	localhost:8080/employees?gender=<>&minage=<>&maxage=<>

Example:

localhost:8080/employees?gender=female&minage=20&maxage=35


Sample Output:

[
    {
        "id": "123Rashmi",
        "name": "Rashmi",
        "age": 27,
        "gender": "female"
    },
    {
        "id": "123",
        "name": "Rasagna",
        "age": 31,
        "gender": "female"
    }
]



3. To view database table and its rows please hit the URL 

	localhost:8080/console

	In the login window seen ensure the user name password and database name as as below
	UserName: sa
	Password:        --> empty
	JDBC URL: jdbc:h2:mem:empdb

	After logging in, please click on EMPLOYEE table to run the queries
