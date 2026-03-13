package fr.salome.crochet.pattern.domain.specifications;

import fr.salome.crochet.kernel.Result;
import fr.salome.crochet.kernel.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class PatternNameSpecification implements Specification<String> {

	/**
	 * Le nom d'un pattern doit être composé uniquement de lettres (avec accents), chiffres, espaces, tirets, apostrophes <br>
	 * Longueur : 1-200 caractères
	 */
	private static final int MAX_LENGTH = 200;
	private static final Pattern REGEX = Pattern.compile("^[\\p{L}\\d\\s'-]+$");

	@Override
	public Result<String> isSatisfiedBy(String name) {
		if (name == null || name.isBlank()) {
			return Result.failure(List.of("Pattern name is required"));
		}

		final var errors = new ArrayList<String>();
		if (!REGEX.matcher(name).matches()) {
			errors.add("Pattern name contains invalid characters");
		}
		if (name.length() > MAX_LENGTH) {
			errors.add("Pattern name is too long");
		}

		return errors.isEmpty() ? Result.success(name) : Result.failure(errors);
	}
}
