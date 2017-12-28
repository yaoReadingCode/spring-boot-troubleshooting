# spring-boot-troubleshooting

### Run local
```
./gradlew build && java -Dspring.config=. -jar build/libs/spring-boot-troubleshooting.jar
```

Then open a browser to `http://localhost:9200/v1/fizzbuzz/12345` and you will see (in the browser):

```
Problem accessing /error. Reason:

Not Found
```

And in the console:

```
WARN  o.s.web.servlet.PageNotFound - No mapping found for HTTP request with URI [/v1/fizzbuzz/12345] in DispatcherServlet with name 'dispatcherServlet'
```
