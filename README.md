# Touristo - Tourism has never been so easy

<div style="margin-bottom: 30px;" align="center">
<img src="https://raw.githubusercontent.com/Canestin/assets/main/img/touristo.png" alt="Touristo Banner"  height="150">
</div>

## Project description

This project aims to help tourism agencies in France by providing intelligent solutions for tourists' demands and constraints. With the vast number of sites, monuments, festivals, and museums in France, tourists often face limitations such as limited time, proximity of locations, budget constraints, and specific preferences for certain types of sites.

The goal is to assist tourism agencies in offering tailored solutions that consider these constraints. Two specific requirements are focused on: the estimated or precise period to which a site belongs and its location. This allows tourists to make choices based on the desired time period and the specific place they want to visit.

For example, tourists may want to visit as many medieval sites as possible in the "Ile de France" region during a summer week, or they may prefer to visit a maximum number of museums with minimal transportation within the Savoie department for ten days in January.

## Main features

The main features of this project include:

1. Site data structures: Comprehensive data structures will be designed to describe historical sites, monuments, museums, streets, and squares, along with their relationships.

2. Constraints and filters: The project will define the main constraints, filters, and use cases that will be used to assist tourists in their decision-making process.

3. Algorithm design: The necessary algorithms will be developed based on the proposed data structures and constraints to provide intelligent solutions for tourists' requests.

4. Simple database integration: The project will showcase the usage of a simple database to store and retrieve relevant data.

5. Backend system (T3): The backend system will be built and implemented, incorporating the previous steps, including the algorithm design and database integration.

6. Frontend interface: An appropriate frontend interface will be designed and implemented to interact with the backend system, allowing users to input their preferences and receive intelligent recommendations.

7. Testing: A reasonable level of testing will be conducted to ensure the reliability and functionality of the T3 system.

## Technologies

1. The backend of the application is developed using the following technologies:

- Spring Boot: A Java-based framework for building robust and scalable web applications.
- Java: The primary programming language used for the backend development.
- Database: A simple database system will be utilized to store and retrieve relevant data.
- RESTful APIs: APIs will be designed and implemented to facilitate communication between the frontend and backend components.

2. The frontend interface will be developed using the following technologies:

- React: A JavaScript library for building user interfaces.
- HTML/SCSS: The standard web technologies for designing and styling the user interface.
- JavaScript: The programming language used for client-side scripting and interactivity.

## Installation

To install and run the application locally, follow these steps:

1. Make sure you have Java JDK (version 8 or higher) and Maven installed on your machine.

2. Clone the project repository from GitHub.

3. Open a console/terminal and navigate to the project directory.

4. Edit the src/main/resources/application.properties file to configure database connection settings. For example, for MySQL:

```
spring.datasource.url=jdbc:mysql://localhost:3306/touristo
spring.datasource.username=root
spring.datasource.password=your_password
```

If you have an IDE, you have nothing more to do, open the project with it and launch it.

If you want to run it with Visual Studio Code:

A. Install mvn :

- For Windows, this tutorial can help you : https://www.youtube.com/watch?v=km3tLti4TCM
- For Mac OS : https://www.youtube.com/watch?v=j0OnSAP-KtU

B. Run the following command to build the application :

```
mvn clean install
```

C. Once the build is complete, run the following command to launch the application:

```
mvn spring-boot:run
```

The application will be accessible at http://localhost:8080

## API routes

Here are the main routes exposed by the API :

| Method | Route                         | Description                                      |
| ------ | ----------------------------- | ------------------------------------------------ |
| POST   | /api/sites/add-many            | Add many sites                                   |
| GET    | /api/sites/{id}                | Retrieve a site                                  |
