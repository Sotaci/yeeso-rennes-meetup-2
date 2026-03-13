package fr.salome.crochet.pattern.domain.entities.specifications;

import fr.salome.crochet.kernel.Result;
import fr.salome.crochet.kernel.Specification;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class InstructionContentSpecification implements Specification<String> {
	/**
	 * Le contenu d'une instruction doit contenir au moins un caractère non-blanc <br>
	 * Longueur : 1-5000 caractères
	 */
	private static final int MAX_LENGTH = 5000;
	public static final Pattern REGEX = Pattern.compile("^(?=.*\\S).+$", Pattern.DOTALL);

	@Override
	public Result<String> isSatisfiedBy(String content) {
		final var errors = new ArrayList<String>();

		if (content == null || content.isEmpty()) {
			errors.add("Instruction content is required");
		} else {
			if (!REGEX.matcher(content).matches()) {
				errors.add("Instruction content is not valid");
			}
			if (content.length() > MAX_LENGTH) {
				errors.add("Instruction content is too long");
			}
		}

		return errors.isEmpty() ? Result.success(content) : Result.failure(errors);
	}
}
