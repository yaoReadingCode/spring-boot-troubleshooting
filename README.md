# spring-boot-troubleshooting

### Run local
```
./gradlew build && java -Dspring.config=. -jar build/libs/spring-boot-troubleshooting.jar
```

Then open a browser to `http://localhost:9200/v1/fizzbuzz/12345` and you will see (in the console):

```
WARN  o.e.j.server.handler.ErrorHandler - EXCEPTION
javax.servlet.ServletException: Circular view path [error]: would dispatch back to the current handler URL [/error] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
	at org.springframework.web.servlet.view.InternalResourceView.prepareForRendering(InternalResourceView.java:205)
	at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:145)
	at org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:303)
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1286)
  <rest of stack trace omitted for brevity>
```
