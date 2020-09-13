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



