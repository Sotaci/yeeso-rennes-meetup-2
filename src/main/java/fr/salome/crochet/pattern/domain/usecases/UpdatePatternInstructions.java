package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;

import java.util.UUID;

public class UpdatePatternInstructions {
	private final PatternRepositoryPort repository;

	public UpdatePatternInstructions(PatternRepositoryPort repository) {
		this.repository = repository;
	}

	public Pattern execute(UUID id, int index, String content) {
		final var pattern = repository.findById(id);

		if (pattern == null) {
			return null;
		}

		pattern.updateInstruction(index, content);
		return repository.update(pattern);
	}
}
