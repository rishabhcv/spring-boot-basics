# Spring Boot Introduction 
This project was created for re-learning Spring-Boot concepts. I wanted to document my learning, as well as provide a small tutorial with 
this repository.

### Important Features
1. Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".     
2. Provide common non functional features :
   - Embedded servers (Tomcat/Jetty/Undertow)       
   - Metrics & Health Checks (How many times the services were hit? How many times did they fail?)            
   - Externalized configuration  (properties file with configuration for different environments)      
3. Quick Starter Projects with Auto Configuration 
   - JPA
   - Web
 
What Spring Boot is NOT?      
   -Zero Code Generation        
   -Neither an application server nor a web server!     
   
#### Before Spring Boot
We had to do the following to create a Spring application :
1. Decide which dependencies and which versions to use?             
2. Implement default exception handling.        
3. Create complete Spring configuration file; define component-scan.        
4. Create a View Resolver for JSP.       
5. To Implement Internationalization, we had to implement a message source amd locale resolver.         
6. Configure web-xml with the Dispatcher Servlet.     


### A Simple Rest Service     
1. Use [Spring Initializr](https://start.spring.io/) to create a new Spring Boot Application. Select __Web__ as a dependency.      
2. Create a Books bean.       
   Add fields like __id, name & author__, add constructors, getters and setters.
2. Create a Rest Controller.      
   Annotate your controller with *@RestController*  and add a *@GetMapping* method for mapping your request to the specific URL. Add 
   dummy data.     
   ```java
   @RestController
   public class BooksController {
	 @GetMapping("/books")
	 public List<Books> getBooks() {
		return Arrays.asList(new Books(1, "Spring", "Rod Johnson"));
	  }
   }
   ```
3. Run the Spring Boot app. On your Web Browser, hit https://loclahost:8080/books it should respond with :      
   ``` [{"id":1,"name":"Spring","author":"Rod Johnson"}] ```

#### How does it work?
1. The magic of *@SpringBootApplication*. What is Auto Configuration?        
   - This is indicates that this class is a Spring context file.
   - It enables Auto Configuration
   - It enables Component Scan (Scans the context file's package/sub packages for Spring beans)
   
__Q: What is Auto Configuration?__          
Spring Boot looks at a) Frameworks available on the CLASSPATH b) Existing configuration for the application.
Based on these, Spring Boot provides basic configuration needed to configure the application with these frameworks.
This is called Auto Configuration. This is opposite to the Spring framework's manual configuration using xmls.     

As soon as we added in Spring Boot Starter Web as a dependency in our project,
Spring Boot Autoconfiguration sees that Spring MVC is on the classpath. It autoconfigures dispatcherServlet, a default error page and 
webjars. If you add Spring Boot Data JPA Starter, you will see that Spring Boot Auto Configuration auto configures a datasource and an Entity 
Manager. You should only ever add one *@SpringBootApplication* or *@EnableAutoConfiguration* annotation.         

__Q : Where is Spring Boot Auto Configuration implemented?__        
All auto configuration logic is implemented in spring-boot-autoconfigure.jar. All auto configuration logic for mvc, data, jms and 
other frameworks is present in a single jar.         

__Q : What is the difference between RequestMapping and GetMapping?__        
RequestMapping is generic - you can use with GET, POST, PUT or any of the other request methods using the method attribute on the annotation.
GetMapping is specific to GET request method. It’s just an extension of RequestMapping to improve clarity.      

### Useful Links 
__1. [Spring Actuator](https://dzone.com/articles/spring-boot-actuator-a-complete-guide)__        
__2. [Spring Developer-Tools & Live Refresh](https://dzone.com/articles/spring-boot-developer-tools-and-live-reload)__
