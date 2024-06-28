# MediLaboSolutions

MediLaboSolutions is a comprehensive medical management application, designed to facilitate the management of patients, medical notes and risk assessments.

This application consists of several microservices communicating via a RESTFUL architecture.

## Table of Contents
- Overview
- Architecture
- Prerequisites
- Installation
- Locally
- With Docker
- Usage
- Green Code

## Overview
MediLaboSolutions provides a user interface and several APIs to manage patient data, medical notes, and risk assessments. The application is divided into several microservices:

- **Client Service**: User interface to interact with the application services.
- **Patient Service**: Manages patient information.
- **Note Service**: Manages medical notes for patients.
- **Assessment Service**: Risk assessments based on medical notes.
- **Gateway Service**: Single entry point to access all microservices.
- **Discovery Service**: Service discovery to register and locate microservices.

## Architecture
The application's architecture uses the following technologies and tools:

Spring Boot
- Spring Cloud Netflix Eureka (Service Discovery)
- Spring Cloud Gateway (API Gateway)
- MongoDB (for storing notes)
- MariaDB (for storing patient information)
- Docker (for containerization)
- Maven (for dependency management and project build)

## Prerequisites

Before installing the application, ensure you have the following tools installed on your machine:

- Java 17 or higher
- Maven 3.6.3 or higher
- Docker and Docker Compose

## Installation

### Locally

1. Clone the application repository:
git clone https://github.com/loutix/MediLaboSolutions
2. cd medilabosolutions
3. execute the command : docker-compose up --build
4. http://localhost:8090/login
5. Login with user :
   User : user
   Password : user

## Usage
The application can be accessed through the Gateway service. http://localhost:8090/login
The Gateway service is secured by login and password.

URLs to interact with the services:
- client-service: http://localhost:8090/client-service/
- patient-service: http://localhost:8090/patient-service/
- note-service: http://localhost:8090/note-service/
- assessment-service: http://localhost:8090/assessment-service/
Use Postman or any other HTTP client to interact with the RESTFUL APIs.


Sure, here's the section on Green Code added to the README:

## Green Code
Understanding Green Code

Green Code refers to the practice of writing software that is energy-efficient and has a minimal impact on the environment.
The main goal is to reduce the carbon footprint associated with the use of digital technologies.

This is achieved by optimizing the code to use fewer resources, such as CPU, memory, and power, thus prolonging the lifespan of hardware and reducing energy consumption.

## Identifying Inefficient Code
To identify parts of the code that consume memory or other resources inefficiently, consider the following strategies:

- **Profiling Tools**: Use profiling tools to monitor the application's performance and identify bottlenecks.
- **Code Reviews**: Regular code reviews can help spot inefficient code patterns and suggest optimizations.
- **Logging and Monitoring**: Implement logging and monitoring to track resource usage over time and identify anomalies.
- **Automated Tests**: Write automated tests to benchmark and measure the performance impact of code changes.

## Recommendations for “Green” improvement of the project
- Filter as much information as possible at the database level. In mongoDB, use of aggregation.
- Reduce the size of docker images using the ".dockerignore" file.
- Reduce the size of the repository using the ".gitignore" file.
- Use static contents for image files, "bootstrap.min.css", "bootstrap.bundle.min.js".
- Improve code quality with SonarQube.
- Measuring the environmental score of EcoIndex websites.