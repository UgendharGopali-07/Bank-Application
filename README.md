# 🏦 Banking Application

A **Spring Boot-based Banking App** to manage users and accounts.

## Features
- 👤 **User Management**
  - Add new users
  - Fetch user details
  - Delete users
  - View accounts & watchlist
- 💳 **Account Management**
  - Create new account
  - Fetch account details
  - Delete accounts

## Technologies
- Java 17
- Spring Boot
- REST APIs
```
com.BankingApp
│
├─ controller
│   ├─ UserController.java
│   └─ AccountController.java
│
├─ service
│   ├─ UserService.java
│   ├─ AccountService.java
│   └─ DeletionService.java
│
├─ repository
│   ├─ UserRepository.java
│   └─ AccountRepository.java
│
├─ model
│   ├─ User.java
│   └─ Account.java
```
## Setup & Run

1. **Clone the repository**
```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>

POST /account
Body: { "userId": 1 }
```
2. **Build the project**  
    Ensure you have Maven or Gradle installed:
```bash
./mvnw clean install
```
3. **Run the application**
```bash
./mvnw spring-boot:run
```
4. **Test APIs**  
    Use Postman or cURL to interact with endpoints.
   
