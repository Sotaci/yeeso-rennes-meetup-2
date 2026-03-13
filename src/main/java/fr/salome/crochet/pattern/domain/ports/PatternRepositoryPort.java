package fr.salome.crochet.pattern.domain.ports;

import fr.salome.crochet.pattern.domain.entities.Pattern;

import java.util.UUID;

public interface PatternRepositoryPort {
	Pattern findById(UUID id);

	Pattern create(Pattern pattern);

	Pattern update(Pattern pattern);
}
