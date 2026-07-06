# Country Exception REST Service

This project demonstrates RESTful web services for managing country data with exception handling.

## Project Structure

```
country-exception-rest/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognizant/
│   │   │           └── springlearn/
│   │   │               ├── SpringLearnApplication.java
│   │   │               ├── controller/
│   │   │               │   └── CountryController.java
│   │   │               ├── service/
│   │   │               │   ├── CountryService.java
│   │   │               │   └── exception/
│   │   │               │       └── CountryNotFoundException.java
│   │   │               └── model/
│   │   │                   └── Country.java
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

## API Endpoints

### 1. Get India Country Details

**Endpoint:** `GET /country`

**Request:**
```
http://localhost:8083/country
```

**Response:**
```json
{
  "code": "IN",
  "name": "India"
}
```

### 2. Get All Countries

**Endpoint:** `GET /countries`

**Request:**
```
http://localhost:8083/countries
```

**Response:**
```json
[
  { "code": "IN", "name": "India"},
  { "code": "US", "name": "United States"},
  { "code": "JP", "name": "Japan"},
  { "code": "DE", "name": "Germany"}
]
```

### 3. Get Country by Code (Case Insensitive)

**Endpoint:** `GET /countries/{code}`

**Request:**
```
http://localhost:8083/countries/in
```

**Response:**
```json
{
  "code": "IN",
  "name": "India"
}
```

### 4. Get Country by Code - Exception Scenario

**Endpoint:** `GET /countries/{code}`

**Request:**
```
http://localhost:8083/countries/az
```

**Response:**
```json
{
  "timestamp": "2019-10-02T03:27:54.521+0000",
  "status": 404,
  "error": "Not Found",
  "message": "Country not found",
  "path": "/countries/az"
}
```

## Testing with Postman

### Test Exception Scenario:
1. Create a new GET request
2. URL: `http://localhost:8083/countries/az` (invalid country code)
3. Click Send
4. You should receive a 404 Not Found response with error details

## Testing with curl

### Test Exception Scenario:
```bash
curl -i http://localhost:8083/countries/az
```

Expected output:
```
HTTP/1.1 404 
Content-Type: application/json;charset=UTF-8
...

{
  "timestamp": "2019-10-02T03:27:54.521+0000",
  "status": 404,
  "error": "Not Found",
  "message": "Country not found",
  "path": "/countries/az"
}
```

## Key Concepts Demonstrated

- **@ResponseStatus**: Maps exceptions to HTTP status codes
- **Custom Exception**: Creating domain-specific exceptions
- **Exception Handling**: Throwing exceptions from service layer
- **throws clause**: Declaring exceptions in method signatures
- **Automatic Error Response**: Spring Boot's default error response for exceptions

## Exception Handling Flow

1. When a country code is not found in the list, `CountryService.getCountry()` throws `CountryNotFoundException`
2. The exception is annotated with `@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")`
3. Spring Boot automatically converts this exception to a JSON error response
4. The response includes:
   - timestamp: When the error occurred
   - status: HTTP status code (404)
   - error: Error type ("Not Found")
   - message: Custom error message
   - path: The request path that caused the error

## CountryNotFoundException Details

The `CountryNotFoundException` class:
- Extends `RuntimeException`
- Annotated with `@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")`
- This tells Spring to return HTTP 404 status when this exception is thrown
- The "reason" attribute provides the error message in the response

## References

- Dispatcher Servlet: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-servlet
- Spring REST (Getting Started): https://spring.io/guides/gs/rest-service/
- Request Mapping: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping
