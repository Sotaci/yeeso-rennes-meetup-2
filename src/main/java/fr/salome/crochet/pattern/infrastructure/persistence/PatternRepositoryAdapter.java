package fr.salome.crochet.pattern.infrastructure.persistence;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import fr.salome.crochet.pattern.infrastructure.persistence.dbos.PatternDbo;
import fr.salome.crochet.pattern.infrastructure.persistence.repositories.PatternCrudRepository;
import fr.salome.crochet.pattern_ad.PatternAdAPI;
import fr.salome.crochet.pattern_test_ad.PatternTestAdAPI;
import org.springframework.stereotype.Component;

@Component
public class PatternRepositoryAdapter implements PatternRepositoryPort {
	private final PatternCrudRepository repository;
	private final PatternTestAdAPI patternTestAd;
	private final PatternAdAPI patternAd;

	public PatternRepositoryAdapter(PatternCrudRepository repository, PatternTestAdAPI patternTestAd, PatternAdAPI patternAd) {
		this.repository = repository;
		this.patternTestAd = patternTestAd;
		this.patternAd = patternAd;
	}

	@Override
	public Pattern findById(PatternId id) throws PatternNotFoundException {
		return repository.findById(id.value())
				.map(PatternDbo::toDomain)
				.orElseThrow(() -> PatternNotFoundException.of(id));
	}

	@Override
	public Pattern create(Pattern pattern) {
		return save(pattern);
	}

	@Override
	public Pattern update(Pattern pattern) {
		return save(pattern);
	}

	@Override
	public Pattern publishForTest(Pattern pattern) throws PatternDomainException {
		patternTestAd.create(pattern.id().value(), pattern.name());

		return update(pattern);
	}

	@Override
	public Pattern publishForSale(Pattern pattern, long price) throws PatternDomainException {
		patternAd.create(pattern.id().value(), pattern.name(), price);

		return update(pattern);
	}

	private Pattern save(Pattern pattern) {
		final var saved = repository.save(PatternDbo.fromDomain(pattern));

		return PatternDbo.toDomain(saved);
	}
}
