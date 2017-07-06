# Spring Boot REST Service with Camel and Integration with DynamoDB using Maven


### Pre-requisites

#### 1. Maven

Spring Boot is compatible with Apache Maven 3.2 or above. If you don’t already have Maven installed you can follow the instructions at maven.apache.org.

#### 2. GIT Bash

On Windows, if you don't already have GIT Bash installed, download [GIT Bash here](https://git-scm.com/downloads)

#### 3. Local DynamoDB

Make sure you have local DynamoDB running. ReferTo: [http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)


## Clone Code and Run

Clone Code in a working directory using

```
$ https://github.com/mayureshkrishna/springboot-dynamodb.git
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
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building IPLookup - Camel and Spring Boot 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ iplookup ---
[INFO] Deleting C:\Data\Workspace\BMW\iplookup\target
[INFO] 
[INFO] >>> spring-boot-maven-plugin:1.5.1.RELEASE:run (default-cli) > test-compile @ iplookup >>>
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:copy-resources (copy-resources) @ iplookup ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ iplookup ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ iplookup ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 18 source files to C:\Data\Workspace\BMW\iplookup\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ iplookup ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ iplookup ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] <<< spring-boot-maven-plugin:1.5.1.RELEASE:run (default-cli) < test-compile @ iplookup <<<
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.1.RELEASE:run (default-cli) @ iplookup ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.1.RELEASE)

2017-07-06 03:32:14.156  INFO 15920 --- [           main] com.cox.bmw.iplookup.route.IPLookupRB    : Starting IPLookupRB on CATL0W107D70M12 with PID 15920 (C:\Data\Workspace\BMW\iplookup\target\classes started by mkrishna in C:\Data\Workspace\BMW\iplookup)
2017-07-06 03:32:14.245  INFO 15920 --- [           main] com.cox.bmw.iplookup.route.IPLookupRB    : The following profiles are active: dev
2017-07-06 03:32:15.004  INFO 15920 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@fe2681d: startup date [Thu Jul 06 03:32:14 EDT 2017]; root of context hierarchy
2017-07-06 03:32:37.508  INFO 15920 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration' of type [class org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-07-06 03:32:38.385  INFO 15920 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'validator' of type [class org.springframework.validation.beanvalidation.LocalValidatorFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-07-06 03:32:38.516  INFO 15920 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.apache.camel.spring.boot.CamelAutoConfiguration' of type [class org.apache.camel.spring.boot.CamelAutoConfiguration$$EnhancerBySpringCGLIB$$576c5480] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-07-06 03:32:47.242  INFO 15920 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2017-07-06 03:32:47.421  INFO 15920 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-07-06 03:32:47.424  INFO 15920 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.11
2017-07-06 03:32:48.721  INFO 15920 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2017-07-06 03:32:48.721  INFO 15920 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 33789 ms
2017-07-06 03:32:49.812  INFO 15920 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'CamelServlet' to [/iplookup/v1/*]
2017-07-06 03:32:49.814  INFO 15920 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2017-07-06 03:32:49.860  INFO 15920 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'errorPageFilter' to: [/*]
2017-07-06 03:32:49.860  INFO 15920 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2017-07-06 03:32:49.860  INFO 15920 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2017-07-06 03:32:49.860  INFO 15920 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2017-07-06 03:32:49.860  INFO 15920 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2017-07-06 03:33:03.641  INFO 15920 --- [           main] o.a.c.i.converter.DefaultTypeConverter   : Loaded 200 type converters
2017-07-06 03:33:04.421  INFO 15920 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@fe2681d: startup date [Thu Jul 06 03:32:14 EDT 2017]; root of context hierarchy
2017-07-06 03:33:04.850  INFO 15920 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-07-06 03:33:04.851  INFO 15920 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-07-06 03:33:04.905  INFO 15920 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-06 03:33:04.905  INFO 15920 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-06 03:33:05.650  INFO 15920 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-06 03:33:06.637  INFO 15920 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-07-06 03:33:06.979  INFO 15920 --- [           main] o.a.camel.spring.boot.RoutesCollector    : Loading additional Camel XML routes from: classpath:camel/*.xml
2017-07-06 03:33:06.980  INFO 15920 --- [           main] o.a.camel.spring.boot.RoutesCollector    : Loading additional Camel XML rests from: classpath:camel-rest/*.xml
2017-07-06 03:33:06.982  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Apache Camel 2.18.3 (CamelContext: camel-1) is starting
2017-07-06 03:33:06.984  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Tracing is enabled on CamelContext: camel-1
2017-07-06 03:33:06.984  INFO 15920 --- [           main] o.a.c.m.ManagedManagementStrategy        : JMX is enabled
2017-07-06 03:33:07.224  INFO 15920 --- [           main] o.a.c.i.DefaultRuntimeEndpointRegistry   : Runtime endpoint registry is in extended mode gathering usage statistics of all incoming and outgoing endpoints (cache limit: 1000)
2017-07-06 03:33:09.664  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : StreamCaching is not in use. If using streams then its recommended to enable stream caching. See more details at http://camel.apache.org/stream-caching.html
2017-07-06 03:33:09.993  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: accountsSearch-route started and consuming from: direct://accountsSearch-route
2017-07-06 03:33:09.995  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: iplookupPing-route started and consuming from: direct://iplookupPing-route
2017-07-06 03:33:09.997  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: iplookupSetup-route started and consuming from: direct://iplookupSetup-route
2017-07-06 03:33:10.000  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: accountsSearch-api started and consuming from: servlet:/accountsSearch/?httpMethodRestrict=POST
2017-07-06 03:33:10.001  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: iplookup-ping-api started and consuming from: servlet:/ping/?httpMethodRestrict=GET
2017-07-06 03:33:10.002  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: iplookup-setup-api started and consuming from: servlet:/setup/?httpMethodRestrict=GET
2017-07-06 03:33:10.003  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: doc-api started and consuming from: servlet:/api-doc?httpMethodRestrict=GET&matchOnUriPrefix=true
2017-07-06 03:33:10.003  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Total 7 routes, of which 7 are started.
2017-07-06 03:33:10.005  INFO 15920 --- [           main] o.a.camel.spring.SpringCamelContext      : Apache Camel 2.18.3 (CamelContext: camel-1) started in 3.023 seconds
2017-07-06 03:33:10.378  INFO 15920 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-07-06 03:33:10.393  INFO 15920 --- [           main] com.cox.bmw.iplookup.route.IPLookupRB    : Started IPLookupRB in 64.039 seconds (JVM running for 166.106)
2017-07-06 03:33:55.875  INFO 15920 --- [nio-8080-exec-1] o.a.c.c.s.CamelHttpTransportServlet      : Initialized CamelHttpTransportServlet[name=CamelServlet, contextPath=]
2017-07-06 03:33:57.252  INFO 15920 --- [nio-8080-exec-1] o.a.camel.processor.interceptor.Tracer   : ID-CATL0W107D70M12-51601-1499326381296-0-2 >>> from(servlet:/accountsSearch/?httpMethodRestrict=POST) --> pipeline <<< Pattern:InOut, Headers:{accept=*/*, accept-encoding=gzip, deflate, br, accept-language=en-US,en;q=0.8, breadcrumbId=ID-CATL0W107D70M12-51601-1499326381296-0-1, cache-control=no-cache, CamelHttpCharacterEncoding=UTF-8, CamelHttpMethod=POST, CamelHttpPath=/accountsSearch, CamelHttpQuery=null, CamelHttpServletRequest=org.apache.catalina.connector.RequestFacade@127559db, CamelHttpServletResponse=org.springframework.boot.web.support.ErrorPageFilter$ErrorWrapperResponse@753fe1dd, CamelHttpUri=/iplookup/v1/accountsSearch, CamelHttpUrl=http://localhost:8080/iplookup/v1/accountsSearch, CamelServletContextPath=/accountsSearch/, clientid=test, clienttransactionid=testcleinttransid, connection=keep-alive, content-length=88, Content-Type=application/json, host=localhost:8080, origin=chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop, postman-token=6be9045d-b2bb-cd43-7a26-7bb57a581f64, user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36}, BodyType:org.apache.camel.converter.stream.InputStreamCache, Body:[Body is instance of org.apache.camel.StreamCache]
2017-07-06 03:33:57.253  INFO 15920 --- [nio-8080-exec-1] o.a.camel.processor.interceptor.Tracer   : ID-CATL0W107D70M12-51601-1499326381296-0-2 >>> pipeline --> setHeader[CamelInterceptedEndpoint, ] <<< Pattern:InOut, Headers:{accept=*/*, accept-encoding=gzip, deflate, br, accept-language=en-US,en;q=0.8, breadcrumbId=ID-CATL0W107D70M12-51601-1499326381296-0-1, cache-control=no-cache, CamelHttpCharacterEncoding=UTF-8, CamelHttpMethod=POST, CamelHttpPath=/accountsSearch, CamelHttpQuery=null, CamelHttpServletRequest=org.apache.catalina.connector.RequestFacade@127559db, CamelHttpServletResponse=org.springframework.boot.web.support.ErrorPageFilter$ErrorWrapperResponse@753fe1dd, CamelHttpUri=/iplookup/v1/accountsSearch, CamelHttpUrl=http://localhost:8080/iplookup/v1/accountsSearch, CamelServletContextPath=/accountsSearch/, clientid=test, clienttransactionid=testcleinttransid, connection=keep-alive, content-length=88, Content-Type=application/json, host=localhost:8080, origin=chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop, postman-token=6be9045d-b2bb-cd43-7a26-7bb57a581f64, user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36}, BodyType:org.apache.camel.converter.stream.InputStreamCache, Body:[Body is instance of org.apache.camel.StreamCache]
2017-07-06 03:33:57.261  INFO 15920 --- [nio-8080-exec-1] o.a.camel.processor.interceptor.Tracer   : ID-CATL0W107D70M12-51601-1499326381296-0-2 >>> setHeader[CamelInterceptedEndpoint, ] --> Processor@0x4eed631 <<< Pattern:InOut, Headers:{accept=*/*, accept-encoding=gzip, deflate, br, accept-language=en-US,en;q=0.8, breadcrumbId=ID-CATL0W107D70M12-51601-1499326381296-0-1, cache-control=no-cache, CamelHttpCharacterEncoding=UTF-8, CamelHttpMethod=POST, CamelHttpPath=/accountsSearch, CamelHttpQuery=null, CamelHttpServletRequest=org.apache.catalina.connector.RequestFacade@127559db, CamelHttpServletResponse=org.springframework.boot.web.support.ErrorPageFilter$ErrorWrapperResponse@753fe1dd, CamelHttpUri=/iplookup/v1/accountsSearch, CamelHttpUrl=http://localhost:8080/iplookup/v1/accountsSearch, CamelInterceptedEndpoint=servlet:/accountsSearch/?httpMethodRestrict=POST, CamelServletContextPath=/accountsSearch/, clientid=test, clienttransactionid=testcleinttransid, connection=keep-alive, content-length=88, Content-Type=application/json, host=localhost:8080, origin=chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop, postman-token=6be9045d-b2bb-cd43-7a26-7bb57a581f64, user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36}, BodyType:org.apache.camel.converter.stream.InputStreamCache, Body:[Body is instance of org.apache.camel.StreamCache]
2017-07-06 03:33:57.277  INFO 15920 --- [nio-8080-exec-1] o.a.camel.processor.interceptor.Tracer   : ID-CATL0W107D70M12-51601-1499326381296-0-2 >>> (accountsSearch-api) Processor@0x4eed631 -->  <<< Pattern:InOut, Headers:{accept=*/*, accept-encoding=gzip, deflate, br, accept-language=en-US,en;q=0.8, breadcrumbId=ID-CATL0W107D70M12-51601-1499326381296-0-1, cache-control=no-cache, CamelHttpCharacterEncoding=UTF-8, CamelHttpMethod=POST, CamelHttpPath=/accountsSearch, CamelHttpQuery=null, CamelHttpServletRequest=org.apache.catalina.connector.RequestFacade@127559db, CamelHttpServletResponse=org.springframework.boot.web.support.ErrorPageFilter$ErrorWrapperResponse@753fe1dd, CamelHttpUri=/iplookup/v1/accountsSearch, CamelHttpUrl=http://localhost:8080/iplookup/v1/accountsSearch, CamelInterceptedEndpoint=servlet:/accountsSearch/?httpMethodRestrict=POST, CamelServletContextPath=/accountsSearch/, clientid=test, clienttransactionid=testcleinttransid, connection=keep-alive, content-length=88, Content-Type=application/json, host=localhost:8080, origin=chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop, postman-token=6be9045d-b2bb-cd43-7a26-7bb57a581f64, serviceName=undefined, transactionId=ID-CATL0W107D70M12-51601-1499326381296-0-1, user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36}, BodyType:org.apache.camel.converter.stream.InputStreamCache, Body:[Body is instance of org.apache.camel.StreamCache]
2017-07-06 03:33:57.287  INFO 15920 --- [nio-8080-exec-1] o.a.camel.processor.interceptor.Tracer   : ID-CATL0W107D70M12-51601-1499326381296-0-2 >>> (accountsSearch-api)  --> direct://accountsSearch-route <<< Pattern:InOut, Headers:{accept=*/*, accept-encoding=gzip, deflate, br, accept-language=en-US,en;q=0.8, breadcrumbId=ID-CATL0W107D70M12-51601-1499326381296-0-1, cache-control=no-cache, CamelHttpCharacterEncoding=UTF-8, CamelHttpMethod=POST, CamelHttpPath=/accountsSearch, CamelHttpQuery=null, CamelHttpServletRequest=org.apache.catalina.connector.RequestFacade@127559db, CamelHttpServletResponse=org.springframework.boot.web.support.ErrorPageFilter$ErrorWrapperResponse@753fe1dd, CamelHttpUri=/iplookup/v1/accountsSearch, CamelHttpUrl=http://localhost:8080/iplookup/v1/accountsSearch, CamelInterceptedEndpoint=servlet:/accountsSearch/?httpMethodRestrict=POST, CamelServletContextPath=/accountsSearch/, clientid=test, clienttransactionid=testcleinttransid, connection=keep-alive, content-length=88, Content-Type=application/json, host=localhost:8080, origin=chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop, postman-token=6be9045d-b2bb-cd43-7a26-7bb57a581f64, serviceName=undefined, transactionId=ID-CATL0W107D70M12-51601-1499326381296-0-1, user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36}, BodyType:com.cox.bmw.iplookup.api.model.AccountsSearchRequest, Body:com.cox.bmw.iplookup.api.model.AccountsSearchRequest@aba0ba1
2017-07-06 03:33:57.290  INFO 15920 --- [nio-8080-exec-1] o.a.camel.processor.interceptor.Tracer   : ID-CATL0W107D70M12-51601-1499326381296-0-2 >>> (accountsSearch-route) direct://accountsSearch-route --> bean://iplookupProcessor?method=accountsSearch <<< Pattern:InOut, Headers:{accept=*/*, accept-encoding=gzip, deflate, br, accept-language=en-US,en;q=0.8, breadcrumbId=ID-CATL0W107D70M12-51601-1499326381296-0-1, cache-control=no-cache, CamelHttpCharacterEncoding=UTF-8, CamelHttpMethod=POST, CamelHttpPath=/accountsSearch, CamelHttpQuery=null, CamelHttpServletRequest=org.apache.catalina.connector.RequestFacade@127559db, CamelHttpServletResponse=org.springframework.boot.web.support.ErrorPageFilter$ErrorWrapperResponse@753fe1dd, CamelHttpUri=/iplookup/v1/accountsSearch, CamelHttpUrl=http://localhost:8080/iplookup/v1/accountsSearch, CamelInterceptedEndpoint=servlet:/accountsSearch/?httpMethodRestrict=POST, CamelServletContextPath=/accountsSearch/, clientid=test, clienttransactionid=testcleinttransid, connection=keep-alive, content-length=88, Content-Type=application/json, host=localhost:8080, origin=chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop, postman-token=6be9045d-b2bb-cd43-7a26-7bb57a581f64, serviceName=undefined, transactionId=ID-CATL0W107D70M12-51601-1499326381296-0-1, user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36}, BodyType:com.cox.bmw.iplookup.api.model.AccountsSearchRequest, Body:com.cox.bmw.iplookup.api.model.AccountsSearchRequest@aba0ba1

```

Now your service is up and running on localhost:8080. 

You can run initial setup at [http://localhost:8080/iplookup/v1/setup](http://localhost:8080/iplookup/v1/setup)

You can run the service at [http://localhost:8080/iplookup/v1/accountsSearch](http://localhost:8080/iplookup/v1/accountsSearch)

### REQUEST BODY - JSON
```
{"ipAddress":"10.2.1.3","timeStamp":"2017-06-26T11:49:26.885Z","sourcePortNumber":"123"}
```

### RESPONSE BODY - JSON

```
{
    "responseHeader": {
        "success": "true",
        "serviceName": "customer-comments",
        "resourceName": "comments",
        "operationName": "search",
        "version": "1.0",
        "transactionId": "ID-CATL0W107D70M12-51601-1499326381296-0-1",
        "sessionId": null,
        "duration": null,
        "exitTimestamp": null,
        "messages": null
    },
    "account": {
        "accountNumber9": "000001604",
        "accountStatus": "Active",
        "accountType": "Residential",
        "siteId": "436",
        "dataService": [
            {
                "occurrence": "1",
                "status": "active"
            }
        ]
    },
    "blockType": null,
    "ipFormat": "ipv4"
}
```
