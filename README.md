
# Book Library Management Application Instructions

## Preface
Tried my best to create an app basing on provided requirements. It might be imperfect, but I put all I know to create it. I would be glad to hear what could be done better, where I made mistakes so I can improve myself further.
I focused on providing good backend resources more than designing a better frontend. Using React or Vue.js would make this site work and look much better without any doubt. 
With more time to work on it, I’m certain I would give it a try.  

## Build tools
The project is built using JDK 11.
I decided to use Spring Boot with Maven to create this app. Spring offers a handful toolset that speeds up work. Also, it’s simple and easy to understand. There is a good base of knowledge all around the Internet, so that also gives Spring an advantage. 

## Frameworks and libraries
	1. Application frameworks
	I decided not to use reactive programming due to lack of time. Whole project bases on Spring Boot.
	2. Testing libraries
	- JUnit 5 - it’s a standard
	4. Others
	- Jackson - for JSON serialization / deserialization; it’s more intuitive to me than GSon,
	- Thymeleaf - although it’s capable of much more, I used it for generating error pages.
	- HTTP.cat- did you notice?

## Design patterns
I focused the project around MVC pattern - it’s simple and suited the task nicely. 

## Endpoints
- `/details` endpoint, requiring parameter „isbn” (`/details?isbn=`), providing a book user was searching for, basing on provided ISBN 13. If the book doesn’t have such number, then user has to look for by book’s ID. If there’s no such book, throws a 404 Not Found Error via WrongIdException.
- `/books` endpoint, requiring parameter „pages” (`/books?pages=`), providing a first book with required amount of pages. If the book pages >= pages provided by user, the book is then returned.
- ` /categories/books`, requiring an id (`/categories/book?=id`), which returns a list of books that belong to specified category.
- `/categories` endpoint, returning a list of all categories available.
- `/top-authors` endpoint, returning a list of top authors with their averageRating, sorted in descending order
- `/all-books` endpoint, returning list of all books


## Building and running
To build the app, use `mvn clean package spring-boot:repackage` command inside Book-Library-App folder
To run it, issue `java -jar Book-Library-App-0.0.1-SNAPSHOT.jar` command in /target directory (or just `java -jar target/Book-Library-App-0.0.1-SNAPSHOT.jar`)

The result can be seen on `localhost:8080`, endpoint go right after the port.