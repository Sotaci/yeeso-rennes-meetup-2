package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.Gauge;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;

import java.util.UUID;

public class UpdatePatternGauge {

	private final PatternRepositoryPort repository;

	public UpdatePatternGauge(PatternRepositoryPort repository) {
		this.repository = repository;
	}

	public Pattern execute(UUID id, Gauge newGauge) {
		final var pattern = repository.findById(id);
		if (pattern == null) {
			return null;
		}
		pattern.updateGauge(newGauge);
		return repository.update(pattern);
	}
}
