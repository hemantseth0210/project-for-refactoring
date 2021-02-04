package com.example.hal.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.hateoas.core.EmbeddedWrappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hal.model.Customer;
import com.example.hal.model.Email;
import com.example.hal.model.Home;
import com.example.hal.model.Profile;

/*
 * https://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support/25874652#25874652
 * http://keaplogik.blogspot.com/2015/01/spring-hateoas-embedded-resources-with.html
 * 
 * 
 */

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<Resource> getProfile() {
		Resource primary = new Resource(new Email("neo@matrix.net", "primary"));
		Resource home = new Resource(new Email("t.anderson@matrix.net", "home"));
		EmbeddedWrappers wrappers = new EmbeddedWrappers(true);
		List<EmbeddedWrapper> embeddeds = Arrays.asList(wrappers.wrap(primary), wrappers.wrap(home));
		Resources<EmbeddedWrapper> embeddedEmails = new Resources(embeddeds, linkTo(ProfileController.class).withSelfRel());
		return ResponseEntity.ok(new Resource(new Profile("Thomas", "Anderson", embeddedEmails), linkTo(ProfileController.class).withSelfRel()));
	}
	
	@RequestMapping(value = "/profile1", method = RequestMethod.GET)
    public ResponseEntity<Resource> getProfile1() {
		Resource primary = new Resource(new Email("neo@matrix.net", "primary"));
		Resource home = new Resource(new Home("10212 Solstice Loop", "32771"));
		EmbeddedWrappers wrappers = new EmbeddedWrappers(true);
		List<EmbeddedWrapper> embeddeds = Arrays.asList(wrappers.wrap(primary), wrappers.wrap(home));
		Resources<EmbeddedWrapper> embeddedEmails = new Resources(embeddeds, linkTo(ProfileController.class).withSelfRel());
		return ResponseEntity.ok(new Resource(new Profile("Thomas", "Anderson", embeddedEmails), linkTo(ProfileController.class).withSelfRel()));
	}
}
