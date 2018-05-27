##  CQRS Using Event Driven Architecture using Spring BOOT + AxonIQ + Async JPA Persistence

The starting point of CQRS design pattern is the notion of differentiating between READ and WRITE model. In the essence 
this design professes if the QUERY capabilities of an application is very different or complex or may be relational DB are
not apt for it, it's better to separate/segregate  query model.

The corner stone in implementing CQRS is event driven architecture. In simple terminology, in event driven architecture,
modules interact with each other using EVENT and each module are independent & not aware of each other. The module enroll/subscribe to event
& take actions. This enable use to cut the module dependencies (in pom.xml) and ease out creation of micro-services.

The following picture shows CQRS design pattern build using event driven architecture:

![alt text](./images/CQRS.jpg)

NOTE:
1. If QUERY model is not complex, do not go in the direction of CQRS
2. EVENT != MESSAGE
3. Event Driven != CQRS

In my opinion a monolithic application can be split in micro-services bases architecture in following steps:
Step 1. Implement Modularization i.e. create modules, each module is dedicated to perform single functional responsibility
   (also termed implementation of separation of concerns)
Step 2. Cut Module inter-dependencies

The Step 2 is very important and is the make & break situation in the endeavour to rollout micro-services based architecture.
Event Driven architecture style plays very important part in implementing Step 2. AxonIQ provide a nice framework to implement 
Event Driven architecture style and the nice part is it supports Domain Driven Design.

EventDrivenMicroServiceUsingAxonIQ is Policy application with:
1. Separate WRITE model
2. Separte READ model
3. Event are stored in embedded AxonIQDB  (using async JPA)
4. READ is performed using JPA [using jpa-eclipselink](https://github.com/mgorav/jpa-eclipselink) + Derby

 

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

This will run the application on the port 8888. All the APIs exposed can be accessed by open the swagger ui as shown below:

````
    http://localhost:8888/swagger-ui.html
    
````

 ![alt text](./images/swaggerui.png)
 
 
