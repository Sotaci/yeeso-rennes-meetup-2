package fr.salome.crochet.pattern.domain.exceptions;

import java.util.List;

public class PatternValidationException extends Exception {
	private final List<String> errors;

	public PatternValidationException(List<String> errors) {
		super();
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}
}