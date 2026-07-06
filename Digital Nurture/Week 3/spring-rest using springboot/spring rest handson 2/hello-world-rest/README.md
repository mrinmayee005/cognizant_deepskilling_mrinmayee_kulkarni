# Hello World REST Service

This project demonstrates a simple RESTful web service that returns "Hello World!!".

## Project Structure

```
hello-world-rest/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognizant/
│   │   │           └── springlearn/
│   │   │               ├── SpringLearnApplication.java
│   │   │               └── controller/
│   │   │                   └── HelloController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## How to Run

### Using IntelliJ IDEA:
1. Open the project in IntelliJ IDEA
2. Right-click on `SpringLearnApplication.java`
3. Select "Run 'SpringLearnApplication'"

### Using Maven Command Line:
```bash
mvn spring-boot:run
```

## Testing the Service

### Using Browser:
Open your browser and navigate to:
```
http://localhost:8083/hello
```

Expected Response:
```
Hello World!!
```

### Using Postman:
1. Create a new GET request
2. URL: `http://localhost:8083/hello`
3. Click Send

Expected Response:
```
Hello World!!
```

### Using curl:
```bash
curl http://localhost:8083/hello
```

## Viewing HTTP Headers

### In Chrome Browser:
1. Press F12 to open Developer Tools
2. Go to 'Network' tab
3. Navigate to `http://localhost:8083/hello`
4. Click on the request in the Network tab
5. View the following sections:
   - General
   - Response Headers
   - Request Headers

### In Postman:
1. Make the request
2. Click on the "Headers" tab to view HTTP header details

## Key Concepts Demonstrated

- **@RestController**: Marks the class as a REST controller
- **@GetMapping**: Maps HTTP GET requests to handler methods
- **Bean transformation to JSON**: Spring automatically converts the return value to JSON
- **Logging**: SLF4J logging for debugging and monitoring

## References

- Dispatcher Servlet: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-servlet
- Spring REST (Getting Started): https://spring.io/guides/gs/rest-service/
- Request Mapping: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping
