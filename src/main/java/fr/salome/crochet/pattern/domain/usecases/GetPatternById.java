package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;

import java.util.UUID;

public class GetPatternById {

	private final PatternRepositoryPort repository;

	public GetPatternById(PatternRepositoryPort repository) {
		this.repository = repository;
	}

	public Pattern execute(UUID id) {
		return repository.findById(id);
	}
}
