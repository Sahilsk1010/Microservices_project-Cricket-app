Here’s the updated **README.md** with the correct URL structure, and without the code snippets. It reflects the service names and how to access them via the **API Gateway**.

---

# Microservices Project - Fantasy Game

This project uses a **microservices architecture** with services like **Admin**, **Batsman**, **Bowler**, **Field**, **API Gateway**, and **Eureka Server**. The **Eureka Server** handles service discovery, and the **API Gateway** routes requests to the appropriate services.

### Services
1. **Eureka Server**: Registers and discovers services.
2. **Admin Service**: Manages matches, players, users, leaderboard, and user picks.
3. **Batsman Service**: Handles CRUD operations related to batsman stats.
4. **Bowler Service**: Handles CRUD operations related to bowler stats.
5. **Field Service**: Handles CRUD operations related to fielding stats.
6. **API Gateway**: Routes requests to the appropriate service.

---

## Prerequisites

Ensure you have the following installed:
- **Java 17+**
- **Maven**
- **Postman** (optional for testing)

---

## Project Structure

```
microservices-project/
├── admin-service/
├── batsman-service/
├── bowler-service/
├── field-service/
├── api-gateway/
├── eureka-server/
└── pom.xml (Parent pom file)
```

---

## How to Run the Project Locally

### Step 1: Start **Eureka Server**

1. Navigate to the `eureka-server` directory.
2. Run the Eureka Server application:

   ```bash
   mvn spring-boot:run
   ```

3. The **Eureka Server** will be available at `http://localhost:8761`. Services will register here.

---

### Step 2: Start **Admin**, **Batsman**, **Bowler**, and **Field Services**

1. Navigate to each service directory (`admin-service`, `batsman-service`, `bowler-service`, `field-service`).
2. Run each service:

   ```bash
   mvn spring-boot:run
   ```

Each service will automatically register with the **Eureka Server**.

---

### Step 3: Start **API Gateway**

1. Navigate to the `api-gateway` directory.
2. Run the **API Gateway** application:

   ```bash
   mvn spring-boot:run
   ```

The **API Gateway** will be available at `http://localhost:8080`.

---

### Step 4: Access Services Through the **API Gateway**

You can access each service via the **API Gateway** using URLs formatted as:

`http://localhost:8080/{SERVICE-NAME}/api/{SERVICE-ENDPOINT}`

Here are some example routes:

- **Admin Service** (Add Match, User Updates, etc.):
  - `GET http://localhost:8080/ADMIN-SERVICE/api/users/leaderboard`  
    *Fetches the leaderboard. Body should be according to the model.*

  - `POST http://localhost:8080/ADMIN-SERVICE/api/users/{userId}/pick`  
    *Add a player pick for a user. Body should be according to the model.*

- **Batsman Service** (CRUD for Batsman Stats):
  - `POST http://localhost:8080/BATSMAN-SERVICE/api/batsman`  
    *Create a new batsman. Body should be according to the model.*

  - `GET http://localhost:8080/BATSMAN-SERVICE/api/stats/{id}`  
    *Fetch batsman stats by ID. Body should be according to the model.*

- **Bowler Service** (CRUD for Bowler Stats):
  - `POST http://localhost:8080/BOWLER-SERVICE/api/bowler`  
    *Create a new bowler. Body should be according to the model.*

  - `GET http://localhost:8080/BOWLER-SERVICE/api/stats/{id}`  
    *Fetch bowler stats by ID. Body should be according to the model.*

- **Field Service** (CRUD for Field Stats):
  - `POST http://localhost:8080/FIELD-SERVICE/api/field`  
    *Create a new field stat. Body should be according to the model.*

  - `GET http://localhost:8080/FIELD-SERVICE/api/stats/{id}`  
    *Fetch field stats by ID. Body should be according to the model.*

---

### Example Request and Response Body

For the endpoints mentioned above, the **request body** and **response body** will follow the structure defined in each service's model (e.g., `User`, `Batsman`, `Bowler`, `Field`, etc.).

---

## Service Configuration

### Example Service Configuration in Eureka (application.yml)

Each service should register itself with **Eureka Server** using this configuration:



## Conclusion

- **Eureka Server** registers and manages all services.
- **API Gateway** is the entry point for all requests.
- **Microservices** like Admin, Batsman, Bowler, and Field handle specific operations.
- Services can be accessed via the **API Gateway** on `http://localhost:8080`.

Let me know if you need further clarifications!

--- 

This version keeps the instructions clear without including the actual model code, while ensuring you understand the process flow through Eureka Server and the API Gateway.
