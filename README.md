# notification-microservices

## Local Development

This Docker Compose setup is intended only for local development. It runs a PostgreSQL 15 container and initializes two databases: userservice and conditionservice.

### Setup

1. Create a .env file
```env 
    POSTGRES_CONTAINER_NAME=postgres
    POSTGRES_PORT=5432
    POSTGRES_USER=postgres
    POSTGRES_PASSWORD=postgres
    POSTGRES_MULTIPLE_DATABASES=userservice,conditionservice
```


2. Start PostgreSQL

Run `docker-compose up -d` from the project root.
The container will run PostgreSQL on localhost:5433 and create the specified databases using an initialization script located in the ./init folder.

3. Run a microservice

Navigate to the microservice folder (e.g. userservice/) and run:

`mvn spring-boot:run`

