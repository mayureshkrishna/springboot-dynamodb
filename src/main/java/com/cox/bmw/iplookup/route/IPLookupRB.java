/**
 * 
 */
package com.cox.bmw.iplookup.route;

import static org.apache.camel.model.rest.RestParamType.body;

import org.apache.camel.Exchange;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cox.bmw.commons.base.AbstractRouteBuilder;
import com.cox.bmw.commons.model.message.ResponseHeader;
import com.cox.bmw.iplookup.api.model.AccountsSearchRequest;
import com.cox.bmw.iplookup.api.model.AccountsSearchResponse;
import com.cox.bmw.iplookup.util.LocalConstants;


@SpringBootApplication
@ComponentScan("com.cox.bmw")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
public class IPLookupRB extends SpringBootServletInitializer implements LocalConstants {

	public static void main(String[] args) {
		SpringApplication.run(IPLookupRB.class, args);
	}


	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(
				new CamelHttpTransportServlet(), "/iplookup/v1/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

	private static final Logger LOG = LoggerFactory.getLogger(IPLookupRoute.class);

	@Component
	class IPLookupRoute extends AbstractRouteBuilder {

		
		public IPLookupRoute() {
			super(LOG);
		}
		
		@Override
		public void configure() throws Exception {

			getContext().setTracing(true);
			super.configure();

			restConfiguration()
			.contextPath("/iplookup/v1").apiContextPath("/api-doc")
			.apiProperty("api.title", "IPLookup REST API")
			.apiProperty("api.version", "1.0")
			.apiProperty("cors", "true")
			.apiContextRouteId("doc-api")
			.bindingMode(RestBindingMode.json);

			rest("/accountsSearch").description("IPLookup Search REST service")
			.consumes("application/json").produces("application/json")
			.post("/").type(AccountsSearchRequest.class).description("Search Account by IP")
			.outType(AccountsSearchResponse.class)
			//.param().type(body).name("AccountsSearchRequest").description("Search Account by IP Input").endParam()
		.route().routeId("accountsSearch-api")
			.to("direct:accountsSearch-route");
			//.endRest();

			rest("/ping").description("IPLookup Ping REST service")
			.produces("application/json")
			.get("/").description("Ping for Liveliness Probe")
			.outType(ResponseHeader.class)
			.route().routeId("iplookup-ping-api")
			.to("direct:iplookupPing-route");
			
			rest("/setup").description("IPLookup Setup REST service")
			.produces("application/json")
			.get("/").description("Setup for Creating table")
			.outType(ResponseHeader.class)
			.route().routeId("iplookup-setup-api")
			.to("direct:iplookupSetup-route");

			//Resource: IPLookupProcessor
			// Operation: accountsSearch
			from("direct:accountsSearch-route")
			.routeId("accountsSearch-route").description("accountsSearch-route")
			.to("bean:iplookupProcessor?method=accountsSearch");

			// Operation: Ping
			from("direct:iplookupPing-route")
			.routeId("iplookupPing-route").description("iplookupPing-route")
			.to("bean:iplookupProcessor?method=ping");
			
			// Operation: Setup
			from("direct:iplookupSetup-route")
			.routeId("iplookupSetup-route").description("iplookupSetup-route")
			.to("bean:iplookupProcessor?method=setup");

		}
	}
}