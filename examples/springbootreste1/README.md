## REST

## Spring Boot
- It is a build tool for autoconfiguration of Spring Application.
- It provides default configuration for spring application for automatically for robust development

#### The way to Create Springboot Application
  1. manually
  2. webservice (https://start.spring.io/)
  3. IDE (IntelliJ Ultimately /Spring STS)

## pom.xml

## parent
use in child maven file which inherits parent file 

### version
chosen version of springboot which inherit the version of parent which applies to all dependencies.

## dependencies
### spring-boot-starter-web
upon compilation return fat jar (java archive) or war (web archive) file with classes and tomcat servlet

## build
### org.springframework.boot
build the spring boot application

## @SpringBootApplication

The combination of

### 1. @SpringbootConfiguration

### 2. @ComponentScan 
- use to find stereotype annotation classes
### 3. @EnableAutoConfiguration
what specify spring boot enable autoconfiguration of own beans in the classpath

By default, springboot scan everything inside main package and its sub packages

### attribute

## @Controller
- It automatically provides the functionality as an action on servlet run on web container
- It uses above class for exposing end points 

## @RestMapping(<url_path>)
- automatically create mapping of path over base url
- The default method is GET. We can define POST, PUT, DELETE
- It locates static page in resources/static folder and render the page as a body

## @ResponseBody
- can place above class or method level. 
- It returns the object as response body instead of searching response as static resource.

## @RestController
combination of the following annotations
-  @Controller
-  @ResponseBody

## application.properties
add own and existing properties that are know by springboot.

### server.port= <port_number>
It uses to run application on other than default port
