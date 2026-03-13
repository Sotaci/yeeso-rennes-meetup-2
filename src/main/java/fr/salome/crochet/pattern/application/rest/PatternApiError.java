package fr.salome.crochet.pattern.application.rest;

import org.springframework.http.HttpStatus;

import java.util.List;

public record PatternApiError(HttpStatus status, List<String> errors) {
	public static PatternApiError notFound(final String message) {
		return new PatternApiError(HttpStatus.NOT_FOUND, List.of(message));
	}

	public static PatternApiError conflict(final String message) {
		return new PatternApiError(HttpStatus.CONFLICT, List.of(message));
	}

	public static PatternApiError validationError(final List<String> messages) {
		return new PatternApiError(HttpStatus.BAD_REQUEST, messages);
	}
}
