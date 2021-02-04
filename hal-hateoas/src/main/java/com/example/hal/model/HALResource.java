package com.example.hal.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;;

public class HALResource extends ResourceSupport{

	private final Map<String, ResourceSupport> embedded = new HashMap<String, ResourceSupport>();

    @JsonInclude(Include.NON_EMPTY)
    @JsonProperty("_embedded")
    public Map<String, ResourceSupport> getEmbeddedResources() {
        return embedded;
    }

    public void embed(String relationship, ResourceSupport resource) {

        embedded.put(relationship, resource);
    }
}
