# DMN and BPMN with JSON

This project is a maven project containing a demonstration on how to use DMN inside a BPMN Process.
Specifically 2 cases are covered here:
    
    * A DMN table receiving as input 2 parameters, each one in an independent variable
    * A DMN table receiving as input 2 parameters inside a collection of JSON objects

## Show me the important parts!

The project contains 2 process

[One Guest](src/main/resources/dishOneGuest.bpmn)

[Multiple Guests](src/main/resources/dishMultipleGuests.bpmn)

## How does it work?
* This project has 2 processes, for teaching reasons, each calls its own DMN table
* There is Postman Collection used to trigger a process instance via REST
* The process with multiple guests contains an 'end' listener to collection all the individual results and put them inside a collection
* Details of the process inside the BPMN files, BPMN is the documentation and the execution.

### Running the application
You can build and run the process application with Maven

#### Manually
1. Build the application using:

```
mvn clean install 
```
So to load the necessary libraries in your project

2. Run the project your favorite IDE or via command line with 

```
mvn spring-boot:run
```

## Environment Restrictions
Built and tested against Camunda BPM version 7.16.0 and JUnit 4

## Known Limitations
This project does not have testing classes. As the purpose is to only teach how to work with JSON and DMN.
The JSON part is limited to the input parameters not to output parameters. The code contains a hint where to do the conversion back to JSON.

