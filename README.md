
# Book Library Management Application

## Build tools
The project is built using JDK 11.
I decided to use Spring Boot with Maven to create this app. Spring offers a handful toolset that speeds up work.
Also, it’s simple and easy to understand.
There is a good base of knowledge all around the Internet, so that also gives Spring an advantage. 

## Frameworks and libraries
1 Application frameworks 
   - Spring Boot
2 Testing libraries
	- JUnit 5 - provided in Spring Boot Test
3 Others
	- Jackson - for JSON serialization / deserialization,
	- Thymeleaf - although it’s capable of much more, I used it for generating error pages.
	- HTTP.cat

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

The result can be seen on `localhost:8080`, endpoints go right after the port.