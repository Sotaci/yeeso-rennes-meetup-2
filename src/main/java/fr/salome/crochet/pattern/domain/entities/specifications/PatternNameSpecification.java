package fr.salome.crochet.pattern.domain.entities.specifications;

import fr.salome.crochet.kernel.Result;
import fr.salome.crochet.kernel.Specification;

import java.util.ArrayList;
import java.util.regex.Pattern;

public final class PatternNameSpecification implements Specification<String> {

	/**
	 * Le nom d'un pattern doit être composé uniquement de lettres (avec accents), chiffres, espaces, tirets, apostrophes <br>
	 * Longueur : 1-200 caractères
	 */
	private static final int MAX_LENGTH = 200;
	private static final java.util.regex.Pattern REGEX = Pattern.compile("^[\\p{L}\\d\\s'-]+$");

	@Override
	public Result<String> isSatisfiedBy(String name) {
		final var errors = new ArrayList<String>();

		if (name == null || name.isBlank()) {
			errors.add("Pattern name is required");
		} else {
			if (!REGEX.matcher(name).matches()) {
				errors.add("Pattern name contains invalid characters");
			}
			if (name.length() > MAX_LENGTH) {
				errors.add("Pattern name is too long");
			}
		}

		return errors.isEmpty() ? Result.success(name) : Result.failure(errors);
	}
}
