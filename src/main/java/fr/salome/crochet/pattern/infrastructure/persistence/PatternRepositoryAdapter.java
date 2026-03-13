package fr.salome.crochet.pattern.infrastructure.persistence;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import fr.salome.crochet.pattern.infrastructure.persistence.dbos.PatternDbo;
import fr.salome.crochet.pattern.infrastructure.persistence.repositories.PatternCrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PatternRepositoryAdapter implements PatternRepositoryPort {
	private final PatternCrudRepository repository;

	public PatternRepositoryAdapter(PatternCrudRepository repository) {
		this.repository = repository;
	}

	@Override
	public Pattern findById(UUID id) {
		return repository.findById(id)
				.map(PatternDbo::toDomain)
				.orElse(null);
	}

	@Override
	public Pattern create(Pattern pattern) {
		return save(pattern);
	}

	@Override
	public Pattern update(Pattern pattern) {
		return save(pattern);
	}

	private Pattern save(Pattern pattern) {
		final var saved = repository.save(PatternDbo.fromDomain(pattern));

		return PatternDbo.toDomain(saved);
	}
}
