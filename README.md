# Kogito Template for Microservices 

This template showcases how easy it is to develop a cloud-native service with Kogito. It allows us to leverage our BPMN expertise within the context of service tasks. Finally, upon achieving operational status, the service is well-documented because the process itself serves as the documentation.

# Advantages

## Decision Makers:
Product Owners benefit from comprehensive transparency regarding the progress and development status of a service at all times. This constant insight allows for effective control and adjustment of project objectives, ensuring optimal resource allocation and facilitating decision-making at every level of the project.

## Developers:
Developers enjoy the advantage of being able to design every part of the service efficiently and free from unnecessary bulk (BloatCode). This lean development approach promotes high code quality and maintainability. Moreover, each component of the service is individually testable, which eases the detailed examination and validation of functionalities. Integration tests can be implemented simply and effectively thanks to the modular structure and clear interfaces between service components. This method not only improves the reliability and stability of the entire service but also accelerates the development process through rapid feedback and early identification of potential issues.

## Resuable and Company No-Code Repository

Unlike with a traditional approach, Kogito makes it easier to create reusable functions. An in-house NoCode repository is automatically created. Every additional service will be created faster, more cost-effectively, more clearly, and more reliably.

# How to use it?

To experiment with the processes, please use Visual Studio Code and load the Kogito Bundle extension.

1. Pull this repository with VSC.
2. Start the Service : mvn clean install quarkus:dev or mvn clean install quarkus:test.
3. Modify ComplexServiceExample.bpmn and ServiceExample.java.
4. Modify Tests. 


# Test
A Simple Test Example is provided in the test Folder. 

Copyright 2024 www.piu.de