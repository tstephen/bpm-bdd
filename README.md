BPM BDD
=============================

A library to support [Behaviour Driven Development](https://en.wikipedia.org/wiki/Behavior-driven_development) of business processes with the [Flowable BPMN engine](http://flowable.org). 

Installation
=============================

Plain installation
---------------------------------

At this stage it is necessary to build the library from source: 

1. Clone source: 

   ```
   git clone https://github.com/Tim Stephenson/flowable-bdd.git
   ```

2. Build and install in local maven repo: 

    ```
    mvn clean install
    ```

Maven installation
---------------------------------

Would be a good addition!

Usage
=============================

1. Behaviour specifications are written in the usual text format, for example: 

   ```
   GIVEN: No particular pre-conditions
   WHEN: The Example1 process is started
   THEN: User Task 'doSomething' is created and completed
   THEN: The process is complete
   ```
   
2. A fluent Java API enables a highly readable translation of the spec to an executable form.

    ```java
    new FlowableSpec(flowableRule, "testExample1")
        .given("No particular pre-conditions")
        .whenEventOccurs("The Example1 process is started",
                EXAMPLE1_KEY, 
                FlowableSpec.buildSet(),
                FlowableSpec.buildMap(), 
                null)
        .thenUserTask("doSomething", 
                FlowableSpec.buildSet(),
                FlowableSpec.buildMap())
        .thenProcessIsComplete();
    ```
    
3. Embedding within a JUnit test provides a simple way to integrate the specification into continuous integration and deployment environments. See [Example1.java](https://github.com/Tim Stephenson/flowable-bdd/blob/master/src/test/java/org/flowable/bdd/examples/Example1Test.java) for the complete class. 
