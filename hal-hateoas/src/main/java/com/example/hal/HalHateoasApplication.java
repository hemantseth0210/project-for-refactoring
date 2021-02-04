package com.example.hal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * https://docs.spring.io/spring-hateoas/docs/current/reference/html/#configuration.at-enable
 * 
 * Currently embeding single object is not supported in spring hateoas, there is
 * an open feature request/defect https://github.com/spring-projects/spring-hateoas/issues/270
 * 
 * 
 * https://www.baeldung.com/spring-hateoas-tutorial
 * https://github.com/eugenp/tutorials/tree/master/spring-security-rest
 * https://www.baeldung.com/spring-rest-hal
 * https://stackoverflow.com/questions/42855943/how-to-get-a-response-in-hal-format-with-spring-hateoas
 * https://opencredo.com/blogs/hal-hypermedia-api-spring-hateoas/
 */
@SpringBootApplication
public class HalHateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HalHateoasApplication.class, args);
	}

}
