##  CQRS-based event driven architecture using Spring BOOT + AxonIQ + Async JPA Persistence

The first step towards moving from monolithic application to micro-services based architecture is craving out modules,
where each module represent a potential micro-service. But if, modules have dependencies on each other (via pom.xml) 
it's impossible to create micro-service out of model. The below picture shows  Command Query Responsibility Segregation 

![alt text](./images/CQRS.jpg)
 

### Instructions to setup and run EventDrivenMicroServiceUsingAxonIQ
1. Download & setup jpa-eclipse for async persistence in local maven repo
````
    git clone git@github.com:mgorav/jpa-eclipselink.git
    cd jpa-ecliselink
    mvn clean install -DskipTests
````

2. Download & setup EventDrivenMicroServiceUsingAxonIQ

````
    git clone git@github.com:mgorav/EvendDrivenMicroServiceUsingAxonIQ.git
    cd EvendDrivenMicroServiceUsingAxonIQ
    mvn clean install -DskipTests
````

3. Run EventDrivenMicroServiceUsingAxonIQ 

````
    java -jar target/EvendDrivenMicroServiceUsingAxonIQ-0.0.1-SNAPSHOT.jar
    
````

This will run the application on the port 8888. All the API exposed can be accessed by open the swagger ui as shown below:

````
    http://localhost:8888/swagger-ui.html
    
````

 ![alt text](./images/swaggerui.png)
 
 
