Docker Compose will build the Spring Boot and MySQL images, create the containers, and start them.
With Docker, you can achieve consistent application execution across different environments.

Before the application to be run it is good to have <img align="center" src="src/main/resources/images/docker-svgrepo-com.svg" alt="gautamkrishnar" height="20" width="20" /> [Docker Desktop](https://www.docker.com/products/docker-desktop/)
### Bash scripts are available within the project:

- **build.sh:** 
 Compile the App and move the JAR executable file to the root folder under runnable.jar

- **up.sh:** 
  to start the project using Docker Compose. Will create two image for MySQl and api to expose endpoints

```
MYSQL_DATABASE=countries MYSQL_PASSWORD=password docker-compose up --build
```

- **down.sh:** to shut down project.

the port in use is 8090 and we have implemented the CRUD operations for the Country demo 
for Rest and GraphQL endpoints.


For the App to connect itself to the MySQL database, as an enhanced security measure, we provided the database credentials as environment variables via the services’ environment attributes so these are textually hidden from the project source code:
- MYSQL_DATABASE: The database name.
- MYSQL_PASSWORD: The database root’s password, we use the root user account for simplicity only.

The environment attributes present in the app service are provided as environment variables to the App container at run time, we are talking about:
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD

Spring Boot automatically assigns these variables to the related application.properties configurations listed below:
- spring.datasource.url
- spring.datasource.username
- spring.datasource.password