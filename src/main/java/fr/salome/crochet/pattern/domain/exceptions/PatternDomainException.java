package fr.salome.crochet.pattern.domain.exceptions;

import fr.salome.crochet.pattern.domain.entities.values.PatternId;

public class PatternDomainException extends Exception {

	private PatternDomainException(String message) {
		super(message);
	}
	
	// Factory methods for domain errors

	public static PatternDomainException cannotPublishEmptyInstructions(PatternId id) {
		return new PatternDomainException("Cannot publish empty pattern with id %s".formatted(id));
	}

	public static PatternDomainException alreadyPublishedForSale(PatternId id) {
		return new PatternDomainException("Pattern with id %s already has an associated sale ad, cannot be modified".formatted(id.value()));
	}

	public static PatternDomainException alreadyPublishedForTest(PatternId id) {
		return new PatternDomainException("Pattern with id %s already has an associated test ad, cannot be modified".formatted(id.value()));
	}

	public static PatternDomainException invalidInstructionIndex() {
		return new PatternDomainException("Invalid instruction index, it should be a positive number");
	}

	public static PatternDomainException invalidGaugeValues() {
		return new PatternDomainException("Invalid gauge values, values should be positive numbers");
	}
}
