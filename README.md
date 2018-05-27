##  CQRS Using Event Driven Architecture With Spring BOOT + AxonIQ + Async JPA Persistence

The starting point of CQRS design pattern is the notion of differentiating between READ and WRITE model. In the essence 
this design professes if the QUERY capabilities of an application is very different or complex or may be relational DB are
not apt for it, it's better to separate/segregate  query model.

The corner stone in implementing CQRS is Event Driven Architecture. In simple terminology, in event driven architecture,
modules interact with each other using EVENT and each module are independent & not aware of each other. The module enroll/subscribe to event
& take actions. This enable use to cut the module dependencies (in pom.xml) and ease out creation of micro-services.

The following picture shows CQRS design pattern build using event driven architecture:

![alt text](./images/CQRS.jpg)

NOTE:
1. If QUERY model is not complex, do not go in the direction of CQRS
2. EVENT != MESSAGE
3. Event Driven != CQRS
4. Event is never physically deleted i.e. delete is another event. This aides in ML and AI

In my opinion a monolithic application can be split into micro-services based architecture in following steps:

**Step 1.** Implement Modularization i.e. create modules, each module is dedicated to perform single functional responsibility
   (also termed implementation of separation of concerns)

**Step 2.** Cut Module inter-dependencies

The **Step 2** is very important and is the make or break situation in the endeavour to rollout micro-services based architecture.
Event Driven architecture style plays very important part in implementing **Step 2.** AxonIQ is a nice framework to implement 
Event Driven programing model in a Domain Driven Design way.

EventDrivenMicroServiceUsingAxonIQ mico-serivce is Policy application with:
1. Separate WRITE model
2. Separate READ model
3. Events are stored in embedded AxonIQDB  (using async JPA)
4. READ is performed using JPA [using jpa-eclipselink](https://github.com/mgorav/jpa-eclipselink) + Derby

NOTE: In above programining style, write needs to fast & asynchronous. JPA vendor does not provide async persitence but 
[using jpa-eclipselink](https://github.com/mgorav/jpa-eclipselink) this can be achieved
 

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
 
 
