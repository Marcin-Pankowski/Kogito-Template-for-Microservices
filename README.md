# Kogito Template for Microservices

This template facilitates the construction of a microservice using Kogito and PostgreSQL. It includes a simple process example and provides test cases, which should initially be corrected to practice integration testing.

# 8 Easy Steps
1. Start the docker container for the postgres DB
docker-compose -f docker-compose/docker-compose-postgresql-ONLY.yml up

2. Define an DTO what data does the process need to be started sucessfully.

3. Define an DTO as a process return.

4. Define the service with an BPMN process.

5. Develop the needed services.

6. Develop the needed controllers (optional)

7. Develop the needed unit tests

8. Develop the needed integration tests

# Build the Process
mvn clean install

# Develop the Process
mvn quarkus:dev
(wait until kogito is started and press d)
Develop the need functionality with ease!

# Develop the Tests
mvn quarkus:test
Develop the needed Tests with ease!