# Touristo - Tourism has never been so easy

<div style="margin-bottom: 30px;" align="center">
<img src="https://raw.githubusercontent.com/Canestin/assets/main/img/touristo.png" alt="Touristo Banner"  height="230">
</div>

## Project description

To write...

## Main features

To write...

## Technologies

The backend of the application is developed using the following technologies:

To write...

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
| POST   | /api/site/add-many            | Add many sites                                   |
| GET    | /api/site/{id}                | Retrieve a site                                  |
