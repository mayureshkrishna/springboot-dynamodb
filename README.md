# CUSTOMER COMMENTS Spring Boot REST Service with Camel using Maven


### Pre-requisites

#### 1. Maven

Spring Boot is compatible with Apache Maven 3.2 or above. If you don’t already have Maven installed you can follow the instructions at maven.apache.org.

#### 2. GIT Bash

On Windows, if you don't already have GIT Bash installed, download [GIT Bash here](https://git-scm.com/downloads)


## Clone Code and Run

Clone Code in a working directory using

```
$ ssh://git@coxrepo.corp.cox.com/bmw/customer-comments.git
```

Once you have cloned the code, you can now run the Spring Boot REST service using

```
$ mvn clean spring-boot:run
```

If you want to run with a specific environment application properties, then make sure to have a property file with environment name. For e.g. application-dev.properties
Now you can run with application-dev.properties using:

```
$ mvn clean spring-boot:run -Dspring.profiles.active=dev
```

You should see similar to following

```
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Customer Comments - Camel and Spring Boot 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ customer-comments ---
[INFO] Deleting C:\Data\Workspace\BMW\customer-comments\target
[INFO]
[INFO] >>> spring-boot-maven-plugin:1.5.1.RELEASE:run (default-cli) > test-compile @ customer-comments >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ customer-comments ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ customer-comments ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 38 source files to C:\Data\Workspace\BMW\customer-comments\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ customer-comments ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Data\Workspace\BMW\customer-comments\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ customer-comments ---
[INFO] No sources to compile
[INFO]
[INFO] <<< spring-boot-maven-plugin:1.5.1.RELEASE:run (default-cli) < test-compile @ customer-comments <<<
[INFO]
[INFO] --- spring-boot-maven-plugin:1.5.1.RELEASE:run (default-cli) @ customer-comments ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.1.RELEASE)

2017-02-16 14:09:36.585  INFO 20868 --- [           main] c.c.b.c.c.route.CustomerCommentsRB       : Starting CustomerCommentsRB on CATL0W107D70M12 with PID 20868 (C:\Data\Workspace\BMW\customer-comme
nts\target\classes started by mkrishna in C:\Data\Workspace\BMW\customer-comments)
2017-02-16 14:09:36.592  INFO 20868 --- [           main] c.c.b.c.c.route.CustomerCommentsRB       : No active profile set, falling back to default profiles: default
2017-02-16 14:09:36.680  INFO 20868 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@
12fe9ff7: startup date [Thu Feb 16 14:09:36 EST 2017]; root of context hierarchy
2017-02-16 14:09:38.940  INFO 20868 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration' of type [class
 org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-02-16 14:09:39.076  INFO 20868 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'validator' of type [class org.springframework.validation.beanvalidation.LocalValidatorFactory
Bean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-02-16 14:09:39.099  INFO 20868 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.apache.camel.spring.boot.CamelAutoConfiguration' of type [class org.apache.camel.spring.b
oot.CamelAutoConfiguration$$EnhancerBySpringCGLIB$$c445761f] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-02-16 14:09:40.757  INFO 20868 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2017-02-16 14:09:40.782  INFO 20868 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-02-16 14:09:40.785  INFO 20868 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.11
2017-02-16 14:09:41.058  INFO 20868 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2017-02-16 14:09:41.059  INFO 20868 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 4383 ms
2017-02-16 14:09:41.439  INFO 20868 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'CamelServlet' to [/customer/account/v1/*]
2017-02-16 14:09:41.443  INFO 20868 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2017-02-16 14:09:41.453  INFO 20868 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'errorPageFilter' to: [/*]
2017-02-16 14:09:41.454  INFO 20868 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2017-02-16 14:09:41.454  INFO 20868 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2017-02-16 14:09:41.455  INFO 20868 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2017-02-16 14:09:41.456  INFO 20868 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2017-02-16 14:09:42.229  INFO 20868 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWe
bApplicationContext@12fe9ff7: startup date [Thu Feb 16 14:09:36 EST 2017]; root of context hierarchy
2017-02-16 14:09:42.390  INFO 20868 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.Str
ing, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-02-16 14:09:42.391  INFO 20868 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView o
rg.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-02-16 14:09:42.443  INFO 20868 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.
ResourceHttpRequestHandler]
2017-02-16 14:09:42.443  INFO 20868 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.Resource
HttpRequestHandler]
2017-02-16 14:09:42.511  INFO 20868 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resou
rce.ResourceHttpRequestHandler]
2017-02-16 14:09:43.679  INFO 20868 --- [           main] o.a.c.i.converter.DefaultTypeConverter   : Loaded 200 type converters
2017-02-16 14:09:44.038  INFO 20868 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-02-16 14:09:44.195  INFO 20868 --- [           main] o.a.camel.spring.boot.RoutesCollector    : Loading additional Camel XML routes from: classpath:camel/*.xml
2017-02-16 14:09:44.196  INFO 20868 --- [           main] o.a.camel.spring.boot.RoutesCollector    : Loading additional Camel XML rests from: classpath:camel-rest/*.xml
2017-02-16 14:09:44.201  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Apache Camel 2.18.2 (CamelContext: camel-1) is starting
2017-02-16 14:09:44.204  INFO 20868 --- [           main] o.a.c.m.ManagedManagementStrategy        : JMX is enabled
2017-02-16 14:09:44.378  INFO 20868 --- [           main] o.a.c.i.DefaultRuntimeEndpointRegistry   : Runtime endpoint registry is in extended mode gathering usage statistics of all incoming and outgoi
ng endpoints (cache limit: 1000)
2017-02-16 14:09:44.966  INFO 20868 --- [           main] o.a.camel.component.http4.HttpComponent  : Created ClientConnectionManager org.apache.http.impl.conn.PoolingHttpClientConnectionManager@2a1422
77
2017-02-16 14:09:45.347  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : StreamCaching is not in use. If using streams then its recommended to enable stream caching. See mo
re details at http://camel.apache.org/stream-caching.html
2017-02-16 14:09:45.930  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: commentsSearch-route started and consuming from: direct://commentsSearch-route
2017-02-16 14:09:45.931  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: commentsCreate-route started and consuming from: direct://commentsCreate-route
2017-02-16 14:09:45.933  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: commentsUpdate-route started and consuming from: direct://commentsUpdate-route
2017-02-16 14:09:45.934  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: commentsDelete-route started and consuming from: direct://commentsDelete-route
2017-02-16 14:09:45.948  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: icoms-api-gateway started and consuming from: direct://apiGateway
2017-02-16 14:09:45.951  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-search-api started and consuming from: servlet:/comments/search/?httpMethodRestrict
=POST
2017-02-16 14:09:45.953  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-create-api started and consuming from: servlet:/comments/create/?httpMethodRestrict
=POST
2017-02-16 14:09:45.960  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-update-api started and consuming from: servlet:/comments/update/?httpMethodRestrict
=POST
2017-02-16 14:09:45.973  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-delete-api started and consuming from: servlet:/comments/delete/?httpMethodRestrict
=POST
2017-02-16 14:09:45.979  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: doc-api started and consuming from: servlet:/api-doc?httpMethodRestrict=GET&matchOnUriPrefix
=true
2017-02-16 14:09:45.995  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Total 10 routes, of which 10 are started.
2017-02-16 14:09:45.997  INFO 20868 --- [           main] o.a.camel.spring.SpringCamelContext      : Apache Camel 2.18.2 (CamelContext: camel-1) started in 1.783 seconds
2017-02-16 14:09:46.176  INFO 20868 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-02-16 14:09:46.290  INFO 20868 --- [           main] c.c.b.c.c.route.CustomerCommentsRB       : Started CustomerCommentsRB in 11.009 seconds (JVM running for 24.865)
```

Now your service is up and running on localhost:8080. You can run the service at [http://localhost:8080/customer/account/v1/comments/search](http://localhost:8080/customer/account/v1/comments/search)

### REQUEST BODY - JSON
```
{"siteId":"609","accountNumber":"023464302","startDate":"2017021","endDate":"20170215","directives":null}
```

### RESPONSE BODY - JSON

```
[
  {
    "commentId": "20170214001",
    "entryDate": "20170214",
    "sequenceNumber": "001",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214002",
    "entryDate": "20170214",
    "sequenceNumber": "002",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214003",
    "entryDate": "20170214",
    "sequenceNumber": "003",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214004",
    "entryDate": "20170214",
    "sequenceNumber": "004",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214005",
    "entryDate": "20170214",
    "sequenceNumber": "005",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214006",
    "entryDate": "20170214",
    "sequenceNumber": "006",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214007",
    "entryDate": "20170214",
    "sequenceNumber": "007",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214008",
    "entryDate": "20170214",
    "sequenceNumber": "008",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214009",
    "entryDate": "20170214",
    "sequenceNumber": "009",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214010",
    "entryDate": "20170214",
    "sequenceNumber": "010",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214011",
    "entryDate": "20170214",
    "sequenceNumber": "011",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214012",
    "entryDate": "20170214",
    "sequenceNumber": "012",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214013",
    "entryDate": "20170214",
    "sequenceNumber": "013",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214014",
    "entryDate": "20170214",
    "sequenceNumber": "014",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214015",
    "entryDate": "20170214",
    "sequenceNumber": "015",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214016",
    "entryDate": "20170214",
    "sequenceNumber": "016",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214017",
    "entryDate": "20170214",
    "sequenceNumber": "017",
    "commentLineText": "XAVIENT TEST UPDATE",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214018",
    "entryDate": "20170214",
    "sequenceNumber": "018",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214019",
    "entryDate": "20170214",
    "sequenceNumber": "019",
    "commentLineText": "TEST TESTING TEST2",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214020",
    "entryDate": "20170214",
    "sequenceNumber": "020",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170214021",
    "entryDate": "20170214",
    "sequenceNumber": "021",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170213001",
    "entryDate": "20170213",
    "sequenceNumber": "001",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170213002",
    "entryDate": "20170213",
    "sequenceNumber": "002",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170213003",
    "entryDate": "20170213",
    "sequenceNumber": "003",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170213004",
    "entryDate": "20170213",
    "sequenceNumber": "004",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170213005",
    "entryDate": "20170213",
    "sequenceNumber": "005",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170213006",
    "entryDate": "20170213",
    "sequenceNumber": "006",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170213007",
    "entryDate": "20170213",
    "sequenceNumber": "007",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170210001",
    "entryDate": "20170210",
    "sequenceNumber": "001",
    "commentLineText": "JASON HILL IS TESTING THE LENGTH OF",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170210002",
    "entryDate": "20170210",
    "sequenceNumber": "002",
    "commentLineText": "THESE COMMENTS BY MAKING A LONG",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170210003",
    "entryDate": "20170210",
    "sequenceNumber": "003",
    "commentLineText": "POINTLESS STATEMENTS ABOUT NOTHING,",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170210004",
    "entryDate": "20170210",
    "sequenceNumber": "004",
    "commentLineText": "NOTHING AT ALL, EXCEPT FOR THIS ONE 40",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170210005",
    "entryDate": "20170210",
    "sequenceNumber": "005",
    "commentLineText": "CHARACTER STATEMENT: 1234567890123456789",
    "userId": "COXWEBUSER"
  },
  {
    "commentId": "20170210006",
    "entryDate": "20170210",
    "sequenceNumber": "006",
    "commentLineText": "012345678901234567890.",
    "userId": "COXWEBUSER"
  }
]
```
