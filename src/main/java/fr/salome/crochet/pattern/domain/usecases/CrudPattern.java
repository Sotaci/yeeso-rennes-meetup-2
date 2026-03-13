package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.kernel.Result;
import fr.salome.crochet.kernel.Success;
import fr.salome.crochet.kernel.Failure;
import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.Gauge;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;
import fr.salome.crochet.pattern.domain.exceptions.PatternValidationException;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import fr.salome.crochet.pattern.domain.specifications.InstructionContentSpecification;
import fr.salome.crochet.pattern.domain.specifications.PatternNameSpecification;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class CrudPattern {
	private final PatternRepositoryPort repository;

	public CrudPattern(PatternRepositoryPort repository) {
		this.repository = repository;
	}

	public Pattern create(String name) throws PatternValidationException {
		/*final var result = new PatternNameSpecification().isSatisfiedBy(name);
		return switch (result) {
			case Success<String> ignored -> repository.create(Pattern.create(name));
			case Failure<String>(var errors) -> throw new PatternValidationException(errors);
		};*/
		return repository.create(Pattern.create(name));
	}

	public Pattern getById(PatternId id) throws PatternNotFoundException {
		return repository.findById(id);
	}

	/**
	 * Mise à jour partielle
	 */

	public Pattern updateName(PatternId id, String name) throws PatternDomainException, PatternValidationException, PatternNotFoundException {
		final var result = new PatternNameSpecification().isSatisfiedBy(name);
		return switch (result) {
			case Success<String> ignored -> {
				final var pattern = repository.findById(id);
				pattern.updateName(name);
				yield repository.update(pattern);
			}
			case Failure<String>(var errors) -> throw new PatternValidationException(errors);
		};
	}

	public Pattern updateInstruction(PatternId id, int index, String instruction) throws PatternDomainException, PatternValidationException, PatternNotFoundException {
		final var result = new InstructionContentSpecification().isSatisfiedBy(instruction);
		return switch (result) {
			case Success<String> ignored -> {
				final var pattern = repository.findById(id);
				pattern.updateInstruction(index, instruction);
				yield repository.update(pattern);
			}
			case Failure<String>(var errors) -> throw new PatternValidationException(errors);
		};
	}

	public Pattern updateGauge(PatternId id, Gauge newGauge) throws PatternDomainException, PatternNotFoundException {
		final var pattern = repository.findById(id);
		pattern.updateGauge(newGauge);

		return repository.update(pattern);
	}
}
