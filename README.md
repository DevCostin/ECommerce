# ECommerce

### About
A project built with hexagonal arquitecture that provides an endpoint for searching the applicable offer based on the date for a product from a H2 database.

### Requirements
For this project you need to install maven

### Instalation
In the ECommerce folder:
- Build aplication: open the terminal and execute command "mvn install" to build the project
- Run aplication, you have two options:
	- Exec command "mvn	exec:java"
	- Exec command "mvn spring-boot:run"

### How to use it
This application provides an endpoint at port 8080, at path "/prices"
To get a price we have to give the parameters:
 - date: the date we want to know the offer, format: "yyyy-MM-dd-HH.mm.ss"
 - productId: the id of the product
 - brandId: the id of the brand
 
Example: "/prices?date=2020-06-14-10.00.00&productId=35455&brandId=1"

### Technologies
 - Spring Boot
 - Lombok