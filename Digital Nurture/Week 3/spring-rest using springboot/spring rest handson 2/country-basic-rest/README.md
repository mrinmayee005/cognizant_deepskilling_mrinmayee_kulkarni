# Country Basic REST Service

This project demonstrates RESTful web services for managing country data.

## Project Structure

```
country-basic-rest/
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
│   │   │               │   └── CountryService.java
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

## Testing with Postman

### Get India Country:
1. Create a new GET request
2. URL: `http://localhost:8083/country`
3. Click Send
4. Click on "Headers" tab to view HTTP header details

### Get All Countries:
1. Create a new GET request
2. URL: `http://localhost:8083/countries`
3. Click Send

### Get Country by Code:
1. Create a new GET request
2. URL: `http://localhost:8083/countries/in` (try with different cases: IN, in, In)
3. Click Send

## Testing with Browser

Open your browser and navigate to:
- `http://localhost:8083/country`
- `http://localhost:8083/countries`
- `http://localhost:8083/countries/in`

To view HTTP headers:
1. Press F12 to open Developer Tools
2. Go to 'Network' tab
3. Navigate to any of the above URLs
4. Click on the request in the Network tab
5. View the following sections:
   - General
   - Response Headers
   - Request Headers

## Key Concepts Demonstrated

- **@RestController**: Marks the class as a REST controller
- **@GetMapping**: Maps HTTP GET requests to handler methods
- **@RequestMapping**: Maps HTTP requests to handler methods (can be used with any HTTP method)
- **@PathVariable**: Extracts values from the URL path
- **Bean transformation to JSON**: Spring automatically converts Java objects to JSON
- **Service Layer**: Business logic separation
- **Case-insensitive matching**: Country code matching is case-insensitive

## What happens in the controller method?

1. The controller receives the HTTP request
2. It calls the service method to get the data
3. The service returns a Country object (or List of Country objects)
4. Spring's HTTP message converter automatically converts the Java object to JSON
5. The JSON response is sent back to the client with appropriate HTTP headers

## How is the bean converted into JSON response?

Spring Boot uses Jackson library by default for JSON conversion. When a controller method returns an object:
1. Spring's `HttpMessageConverter` intercepts the response
2. Jackson serializes the Java object to JSON
3. The `Content-Type` header is set to `application/json`
4. The JSON response is sent to the client

## References

- Dispatcher Servlet: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-servlet
- Spring REST (Getting Started): https://spring.io/guides/gs/rest-service/
- Request Mapping: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping
