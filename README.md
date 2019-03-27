Author - Nishant Malhotra
email - nishant.malhotra07@gmail.com

Technology used - Java 11, Spring Boot, Spring Cloud, Rest Services

Description of Application - 

The application is a basic movie review fetching application, and uses dummy data. The purpose of building this application is to depict the microservice architecture using Eureka servers.
The application comprises of 3 services and a server:

1. Movie Info Service - This service gives the information about the movies to the movie catalogue service via REST Api
2. Movie Data Srvice - This service will provide ratings data to movie catalogue service via REST API.
3. Movie Catalogue Service - This service will be user's end api, which user will interact. This service fetches data from  
   Movie Info Service and  Movie Data Service, binds them and exposes a single API to the user to consume.
4. Discovery-Server - This is the Eureka discovery Server, which registers rest of the services and provides load balancing and routing        capabilities within the application. The user interacts with his server and is routed to the application servers. All the individual        services too interact with this server to get the URLs of the remaing servers.
