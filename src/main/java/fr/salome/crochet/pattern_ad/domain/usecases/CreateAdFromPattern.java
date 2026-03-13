package fr.salome.crochet.pattern_ad.domain.usecases;

import fr.salome.crochet.pattern_ad.domain.entities.PatternAd;
import fr.salome.crochet.pattern_ad.domain.ports.PatternAdRepositoryPort;

import java.util.UUID;

public class CreateAdFromPattern {
	private final PatternAdRepositoryPort repository;

	public CreateAdFromPattern(PatternAdRepositoryPort repository) {
		this.repository = repository;
	}

	public PatternAd create(UUID patternId, String name, long price) {
		final var ad = PatternAd.create(patternId, name, price);
		return repository.create(ad);
	}
}