# Cake-application-angular

This is an angular ui app backed by spring boot web ap which serves end points to manage cake resource.
Cake-ui is the angular app and cake-service is the spring web app that exposes rest api's.

 
## End points

Cake-service application has 5 end points and all are prefixed with /api.

-  Url '/api' and '/api/cakes' returns lits of cakes. (Served by CakeController.class)
- Post to '/api/cake' end point creates a new cake. (Served by CakeRestController.class) 
  Input json to create cake is  
  ```json
  {
    "title": "carrot cake",
    "desc":  "carrot cake with cream",
    "image": "URL of image"
  }
  ```
- Get on '/api/cake/{id}' returns a cake for the given Id. (Served by CakeRestController.class)
- '/swagger-ui.html' returns Swagger document. (Served by Swagger library)

## How to build and run without Docker

Download the code using https://github.com/pacificmist0900/cake-application-angular.git.

There are two main options to run this project. 
 1. Run angular application(cake-ui) and spring boot app(cake-service) separately.
 
    ### Pre-requisites
 
        node must be installed. I ran this with node version 10.6.0. 
    > To run angular app, go to cake-ui and run npm start. This starts the app on port 4200. The app can be accessed on localhost:4200.
    To run spring boot application, open the app in an IDE and run CakeMgrApplication and pass spring.profiles.active=h2. This starts the spring boot app on port 8085

2. Package both spring-boot app and angular app inside same jar. 
    >Run mvn clean install from the root of the cake-application-angular project. Go to cake-application-angular/cake-service/target and run "java -jar -Dspring.profiles.active=h2 cake-service-0.0.1-SNAPSHOT.jar". This starts the app on port 8085 and the app can be accessed
on localhost:8085


## How to build and run Docker image

### Pre-requisites

- Docker must be installed.
- Docker daemon must be running.

### How to build 

Download the code using https://github.com/pacificmist0900/cake-application-angular.git.
 - mvn clean install. This creates the fat spring boot jar with angular app (in static folder) in cake-service/target
 - ```docker build -t cake-waracle .``` builds docker image. This should be run from cake-application-angular root.
 - To run Docker image, run ```docker run -p 5000:8085 cake-waracle ```. This starts the app on localhost:5000

## Cake-service architecture 
 -  Spring boot
 - h2 as in memory database
 - liquibase to manage database
 
 Cake service runs on port 8085 and currently only supports h2 spring profile. So it has to be run with spring profile "h2".
 During startup liquibase creates the database and creates a record in cake table. 
 
 
 
## Cake-ui architecture 
- Angular app
- proxies all calls to /api/** to localhost:8085 which is where cake-service should be running. 
- localhost:4200(npm start) shows the home page of the app which lists all the cakes. 
- Users can navigate to create screen by clicking on create button to add a new cake to the system.
- Basic UI validation is done to make sure that all cake fields are populated before creating a new cake.


## TODO
 - Add component level tests in UI
 - Add an integration tests(or e2e) test using may be serenity pattern to test both ui and backend.
 - Add oauth in cake-service. 
