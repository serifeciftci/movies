## Documentation

This is an application where you can search for movie recommendations by customer id. When an
existing customer id is entered, the application will search for recommendations in the movies.xml
file based on the interests of the customer which can be found in the profiles.json file.
Both files can be found in the src/main/resources/input folder and are loaded after the application
context has been loaded.

### Prerequisites
Following technologies are used during development of this application
* Java 8
* Apache Maven 3.5.3

### How to run the application from the commend line
Change your current directory to the movies folder and run the following commands:
* mvn install (compile application)
* mvn spring-boot:run (run application)

### Endpoint
Once the application is run, you can make a call to:
http://localhost:8080/api/yourapp/v1/movie/suggestion/customer/id/{id}
where {id} is the customer id. Existing customer id's can be found in the profiles.json file.

### Improvements
This application does not find a movie recommendation based on the genre of the customer
interest that are listed in the profiles.json file.