# Spring Beans Wiring

This repository explores different ways to wire beans in Spring, focusing on legacy configurations. The project is structured into three branches, each demonstrating a distinct approach:

- **alpha**: Uses XML configuration (`applicationContext.xml`).
- **beta**: Uses Java-based configuration (`AppConfig.java`).
- **gamma**: Uses annotation-based configuration (`@Service`, `@Repository`, `@PostConstruct`).

## Purpose
The goal of this project is to understand the evolution of dependency injection and bean management in Spring, this according to my course of Network Computing 2. By working through these three approaches, we gain insight into how applications were traditionally built and how modern Spring Boot applications have simplified the process.

This exploration also aims to reinforce fundamental concepts of web applications, emphasizing a **layered architecture**:


1. **Data Access Layer**: Manages data persistence and retrieval.
2. **Business Logic Layer**: Defines the configuration and dependency injection mechanisms.
3. **Presentation Layer**: Exposes services to be consumed by controllers or external clients.



## Branches Overview
Each branch contains an implementation of a simple service-based application following the layered architecture pattern.

### **alpha - XML Configuration**
- Beans are defined in `applicationContext.xml`.
- Dependencies are injected using `<bean>` elements.
- Requires manual configuration of component scanning and dependency resolution.

### **beta - Java Configuration**
- Beans are defined in `AppConfig.java` using `@Configuration` and `@Bean`.
- Dependencies are resolved through explicit method calls.
- Reduces XML complexity while keeping full control over the bean lifecycle.

### **gamma - Annotation-Based Configuration**
- Uses annotations such as `@Component`, `@Service`, and `@Repository`.
- Dependency injection is handled by `@Autowired`.
- Simplifies configuration by leveraging component scanning.

## Getting Started
### **Cloning the Repository**
```sh
git clone https://github.com/RonyOz/Spring-Wiring-Beans.git
cd Spring-Wiring-Beans
```

### **Switching Between Implementations**
To explore a specific configuration approach, checkout the corresponding branch:
```sh
git checkout alpha  # For XML-based configuration
git checkout beta   # For Java-based configuration
git checkout gamma  # For Annotation-based configuration
```

### **Running the Application**
Each branch contains a simple Spring application that can be run using:
```sh
mvn clean package
```
Then, deploy the generated `.war` or `.jar` file to Tomcat.

## Reference
This project was developed as part of an exploration guided by [Domiciano's Repository](https://github.com/Domiciano/Compunet2-251).
