# 🍽️ Online Table Reservation System (OTRS)

> Backend for a Microservices-based Restaurant Table Reservation System
A scalable and modular backend system built using Spring Boot microservices. It powers restaurant search and table reservations, featuring secure inter-service communication (OAuth 2.0), service discovery, centralized configuration, and event-driven architecture using Kafka and ActiveMQ. Deployed via Docker on AWS EC2, it also integrates a basic AI chatbot (via Groq LLM) for natural language support.
---

## 🧩 Features

- 🔍 Search restaurants by name or cuisine
- 📅 Book tables with user authentication
- 🛡️ OAuth 2.0 based security between services
- 📦 Microservices architecture with service discovery (Eureka)
- ⚙️ Centralized config management with Spring Cloud Config
- 📊 Monitoring using Prometheus, Grafana, and Micrometer
- 🧠 AI-powered reservation assistant (Groq LLM-based Python service)
- 🚢 Containerized and deployed using Docker & EC2

---

## 🧩 Pre-requisites

Before running the backend services, make sure your system meets the following requirements:

💻 System Requirements

RAM: Minimum 8 GB (recommended for running multiple services smoothly)

CPU: Modern multi-core processor (older machines may struggle)

Disk Space: ~2 GB free space for Docker images and logs

🧰 Software Requirements

Java 11+ – Required to build and run Spring Boot microservicesInstall via: AdoptOpenJDK or your preferred JDK

Docker & Docker Compose – For container orchestrationGet Docker

Git – To clone the repositoryInstall Git

⚠️ **On low-spec machines, running all services at once may cause memory issues.**

---
## 📐 Architecture Overview

```plaintext
[ AngularJS Frontend (NGINX) ]
              |
     API Gateway (Zuul)
              |
   ------------------------------------------------
   |        |            |             |           |
User Svc  Restaurant Svc Booking Svc  Auth Svc   AI Chat Svc
```
---

## 🚀 Tech Stack

### Backend
- Java 11, Spring Boot
- Eureka Service Discovery
- Spring Cloud Config Server
- gRPC & REST APIs
- Kafka for event driven architecture
- Docker, Maven

### Frontend
- AngularJS
- NGINX

### DevOps & Cloud
- AWS EC2
- Docker Compose
- Prometheus, Grafana, Micrometer

### AI Integration
- Python microservice powered by Groq LLM
- Chat UI support for table reservation queries

---

## 🔧 Microservices

| Service             | Port | Description                             |
|---------------------|------|-----------------------------------------|
| API Gateway         | 8765 | Routes traffic to backend services      |
| Config Server       | 8888 | Centralized configuration management    |
| Eureka Discovery    | 8761 | Service registry and discovery          |
| User Service        | 8081 | Manages user data and login/auth        |
| Restaurant Service  | 8082 | Handles restaurant info and listings    |
| Booking Service     | 8083 | Manages table reservations              |
| Auth Service        | 8084 | OAuth 2.0 authentication flow           |
| AI Chat Service     | 5001 | NLP-based reservation assistant         |

---

## 🛠️ How to Run (Development Setup)
Option 1: Run All Services Using Docker Compose
1. **Clone the repo:**
   ```bash
   git clone https://github.com/automateAll/online-table-reservation-system.git
   cd online-table-reservation-system
   ```
2. **Start all backend services using Docker Compose:**

    ```bash
   docker-compose up --build
   ```

Option 2: Run Individual Microservices Manually (for testing/debugging)

1. **Build all services using Maven:**

    ```bash
    mvn clean package
    ```


2. **Navigate to the target directory of any microservice and run its JAR:**

    ```bash
    cd <microservice-name>/target
    java -jar <service-name>.jar
   ```
   For example:
    ```bash
    cd user-service/target
    java -jar user-service.jar
   ```
---

## 🙌 Contributions

Feel free to fork this repo and raise a pull request. Ideas and improvements are welcome!

## 📬 Contact

Created by [Amandeep Bhatti](https://www.linkedin.com/in/amandeep-singh-bhatti-23072322/) — let's connect!