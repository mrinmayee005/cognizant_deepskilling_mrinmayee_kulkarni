# Country Complete REST Service with MockMVC Tests

This project demonstrates RESTful web services for managing country data with comprehensive MockMVC testing.

## Project Structure

```
country-complete-rest/
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
│       └── java/
│           └── com/
│               └── cognizant/
│                   └── springlearn/
│                       └── SpringLearnApplicationTests.java
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

## Running Tests

### Using IntelliJ IDEA:
1. Right-click on `SpringLearnApplicationTests.java`
2. Select "Run 'SpringLearnApplicationTests'"

### Using Maven Command Line:
```bash
mvn clean test
```

## Test Cases

### Test 1: contextLoads()
Tests if the CountryController is loaded properly by the Spring context.

```java
@Test
public void contextLoads() {
    assertNotNull(countryController);
}
```

### Test 2: testGetCountry()
Tests the GET /country endpoint:
- Verifies HTTP status is 200 OK
- Checks if the response contains "code" field
- Verifies the value of "code" is "IN"
- Checks if the response contains "name" field
- Verifies the value of "name" is "India"

```java
@Test
public void testGetCountry() throws Exception {
    ResultActions actions = mvc.perform(get("/country"));
    actions.andExpect(status().isOk());
    actions.andExpect(jsonPath("$.code").exists());
    actions.andExpect(jsonPath("$.code").value("IN"));
    actions.andExpect(jsonPath("$.name").exists());
    actions.andExpect(jsonPath("$.name").value("India"));
}
```

### Test 3: testGetCountryException()
Tests the exception scenario when country code is not found:
- Verifies HTTP status is 404 Not Found

```java
@Test
public void testGetCountryException() throws Exception {
    ResultActions actions = mvc.perform(get("/countries/az"));
    actions.andExpect(status().isNotFound());
}
```

## MockMVC Key Concepts

### @AutoConfigureMockMvc
Configures MockMvc for testing Spring MVC controllers without starting a full HTTP server.

### MockMvc
The main entry point for server-side Spring MVC test support.

### Test Methods:
- **get()**: Creates a GET request builder
- **perform()**: Executes the request
- **andExpect()**: Adds expectations for the result
- **status().isOk()**: Verifies HTTP status is 200
- **status().isNotFound()**: Verifies HTTP status is 404
- **jsonPath().exists()**: Verifies a JSON field exists
- **jsonPath().value()**: Verifies a JSON field has a specific value

## Step-by-Step Test Implementation

### Step 1: Test loading CountryController
```java
@Autowired
private CountryController countryController;

@Test
public void contextLoads() {
    assertNotNull(countryController);
}
```

### Step 2: Invoke the service
```java
@Test
public void testGetCountry() throws Exception {
    ResultActions actions = mvc.perform(get("/country"));
}
```

### Step 3: Check HTTP Status
```java
@Test
public void testGetCountry() throws Exception {
    ResultActions actions = mvc.perform(get("/country"));
    actions.andExpect(status().isOk());
}
```

### Step 4: Check if code exists
```java
@Test
public void testGetCountry() throws Exception {
    ResultActions actions = mvc.perform(get("/country"));
    actions.andExpect(status().isOk());
    actions.andExpect(jsonPath("$.code").exists());
}
```

### Step 5: Check code value
```java
@Test
public void testGetCountry() throws Exception {
    ResultActions actions = mvc.perform(get("/country"));
    actions.andExpect(status().isOk());
    actions.andExpect(jsonPath("$.code").exists());
    actions.andExpect(jsonPath("$.code").value("IN"));
}
```

### Step 6: Check name field
```java
@Test
public void testGetCountry() throws Exception {
    ResultActions actions = mvc.perform(get("/country"));
    actions.andExpect(status().isOk());
    actions.andExpect(jsonPath("$.code").exists());
    actions.andExpect(jsonPath("$.code").value("IN"));
    actions.andExpect(jsonPath("$.name").exists());
    actions.andExpect(jsonPath("$.name").value("India"));
}
```

## References

- Dispatcher Servlet: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-servlet
- Spring REST (Getting Started): https://spring.io/guides/gs/rest-service/
- Request Mapping: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping
- Server Side Testing: https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/testing.html#spring-mvc-test-server
