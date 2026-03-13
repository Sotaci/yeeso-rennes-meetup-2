package fr.salome.crochet.pattern.application.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePatternRequest(String name) {
}
