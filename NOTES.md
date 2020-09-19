# Notes

## H2 Database first test

### Problems
#### 1. H2 URL setup
At first I was unable to log in via the 
 browser UI at `http://localhost:8080/h2-console`. 
 Error:
 ```
Database "mem:testdb2" not found, either pre-create it or allow remote database creation (not recommended in secure environments) [90149-200] 90149/90149 (Help)
``` 
As it turns out, the URL is configured by the property `spring.datasource.url`.
After setting it in `\src\main\resources\application.properties` I managed to log in.


## Validation annotations
To have access to the package `javax.validation` the followind dependency has to be
included in the pom:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
Adding to `@Valid` annotation to `com.partosb.udemy.ppmtool.web.ProjectController.createNewProject`
resulted in a more concise and readable error message in the log instead of an exception stacktrace.
The response changed from 500 to 400 as well.

