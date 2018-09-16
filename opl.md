# Test 

The traning modules for actuator, security and messaging hould be enhanced of unit tests  

# Spring 2.0 

The Spring Boot training should be updated to version 2.0.x.
The current version is 1.5.16 one of the 1.5.x maintenance releases. 
For 2018 its ok but in 2019 we need an update. 

A Pre-migration test shows with spring boot 2.0.3 that the following modules need refactoring: 

* Data - The CrudRepository changed in Spring 2.0. The Method findeOne(i) return a Optional instead of a T for example 
* Security - The Security Autonconfiguration changed in Spring 2. A simple Security Configuration doesent work. 
* Actuator - The actuator modules completly changed in Spring 2. The module can be compiled, but doesent work.  
* Messages - The amqp message module can't be compiled in Spring 2. 

The new **features** of spring boot 2 will be implemented in a new training named **Spring Boot Refresh**. 



