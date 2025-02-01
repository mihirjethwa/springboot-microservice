#Spring Boot Microservices Project
#Overview
This project demonstrates a microservices architecture using Spring Boot , Spring Cloud , Docker , and PostgreSQL . The system includes:

Eureka Server : A service registry for registering and discovering microservices.  
Config Server : Centralized configuration management using GitHub as the backend.  
API Gateway : Acts as a single entry point for all microservices, providing routing, load balancing, and security.  
Microservices : Individual services that communicate with each other via REST APIs.  
PostgreSQL : Initialized using Docker for database persistence.  
DBeaver Cloud : Used for managing and visualizing the database.  
This architecture ensures scalability, maintainability, and flexibility for future enhancements.

##Features
**Service Discovery** :
Eureka Server for registering and discovering microservices dynamically.
Eureka Client integrated into each microservice for automatic registration.
**Centralized Configuration** :
Config Server fetches configuration files from a GitHub repository.
Each microservice retrieves its configuration from the Config Server.
**API Gateway** :
Routes requests to appropriate microservices.
Provides load balancing and security (e.g., authentication/authorization).
**Database Management** :
PostgreSQL initialized via Docker for local development.
DBeaver Cloud for database visualization and management.
**Scalability** :
Designed to scale horizontally by adding more instances of microservices.

##Prerequisites
Before running the project, ensure you have the following installed:

Java 17 or higher
Maven (for building the project)
Docker (for initializing PostgreSQL)
Git (for cloning the repository and accessing configuration files)
DBeaver Cloud (optional, for database management)
