package fr.salome.crochet.pattern.domain.exceptions;

import fr.salome.crochet.pattern.domain.entities.values.PatternId;

public class PatternNotFoundException extends Exception {
	private PatternNotFoundException(String message) {
		super(message);
	}

	public static PatternNotFoundException of(PatternId id) {
		return new PatternNotFoundException("Pattern with id %s not found".formatted(id));
	}
}
