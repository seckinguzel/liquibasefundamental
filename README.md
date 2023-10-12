# Liquibase Fundamental Microservice

Liquibase Fundamental Microservice is a simple microservice project that demonstrates the usage of Liquibase for database version control and management. This README provides an overview of the project structure and explains how Liquibase is used to create a database table.

## Project Structure

The project consists of the following components:

- `src/main/resources/db/changelog/`: This directory contains Liquibase change log files that define database schema changes. The main change log file is `changelog-master.xml`.

- `src/main/java/com/databasemanagement/liquibasefundamental/Controller.java`: This is the main controller class that defines REST API endpoints for managing people records in the database.

- `src/main/java/com/databasemanagement/liquibasefundamental/PersonRepository.java`: This is the Spring Data JPA repository interface for interacting with the "Person" entity.

- `src/main/java/com/databasemanagement/liquibasefundamental/Person.java`: This is the entity class that represents a "Person" and is mapped to the database table.

## Liquibase Change Log

The `changelog-master.xml` file is the main Liquibase change log that includes other change log files. Here is an example of its contents:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
                   http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.1.xsd">
    <changeSet id="createPersonTable" author="your_name">
        <createTable tableName="person">
            <column name="id" type="serial">
                <constraints primaryKey="true"/>
            </column>
            <column name="name" type="varchar(255)"/>
            <column name="height" type="varchar(255)"/>
        </createTable>
    </changeSet>
</databaseChangeLog>
This change log creates a "person" table with columns for "id," "name," and "height."

Microservice Endpoints

The microservice exposes the following REST API endpoints for managing people records:

POST /api/add: Adds a new person record to the database. It expects a "name" parameter in the request.
GET /api/person: Retrieves a list of all people records in the database.
Database Interaction

The database interaction is handled through the PersonRepository interface. It extends CrudRepository and provides a custom query method for finding people by name.

Entity Class

The Person class represents the "Person" entity and is mapped to the database table. It contains properties such as "id," "name," and "height," which correspond to the database columns.

Getting Started
To run the microservice, follow these steps:
git clone https://github.com/your-github-account/liquibase-fundamental-microservice.git
Navigate to the project directory:
cd liquibase-fundamental-microservice
Build and run the microservice using your preferred build tool (e.g., Maven or Gradle).
Access the microservice using the defined REST API endpoints.

Database Migration

The database schema changes are managed using Liquibase. You can define new change sets in the change log files to modify the database schema. Liquibase will apply these changes automatically when the microservice starts.
