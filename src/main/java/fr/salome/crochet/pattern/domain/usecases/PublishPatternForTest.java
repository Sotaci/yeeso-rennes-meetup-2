package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import fr.salome.crochet.pattern_test_ad.PatternTestAdAPI;

public class PublishPatternForTest {
	private final PatternRepositoryPort repository;

	public PublishPatternForTest(PatternRepositoryPort repository) {
		this.repository = repository;
	}

	public Pattern execute(PatternId id) throws PatternDomainException, PatternNotFoundException {
		final var pattern = repository.findById(id);

		pattern.publishForTest();
		return repository.publishForTest(pattern);
	}
}
