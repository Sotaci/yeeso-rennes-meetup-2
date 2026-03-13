package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;

public class CreatePattern {

	private final PatternRepositoryPort repository;

	public CreatePattern(PatternRepositoryPort repository) {
		this.repository = repository;
	}

	public Pattern execute(String name) {
		return repository.create(Pattern.create(name));
	}
}
