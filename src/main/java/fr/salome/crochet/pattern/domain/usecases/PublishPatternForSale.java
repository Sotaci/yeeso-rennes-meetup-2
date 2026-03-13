package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.kernel.Failure;
import fr.salome.crochet.kernel.Success;
import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;
import fr.salome.crochet.pattern.domain.exceptions.PatternValidationException;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;
import fr.salome.crochet.pattern.domain.specifications.PatternPriceSpecification;
import fr.salome.crochet.pattern_ad.PatternAdAPI;

public class PublishPatternForSale {
	private final PatternRepositoryPort repository;

	public PublishPatternForSale(PatternRepositoryPort repository) {
		this.repository = repository;
	}

	public Pattern execute(PatternId id, Long price) throws PatternDomainException, PatternNotFoundException, PatternValidationException {
		final var result = new PatternPriceSpecification().isSatisfiedBy(price);
		return switch (result) {
			case Success<Long> ignored -> {
				final var pattern = repository.findById(id);

				// validation de l'opération et mise à jour de l'état
				pattern.publishForSale();
				yield repository.publishForSale(pattern, price);
			}
			case Failure(var errors) -> throw new PatternValidationException(errors);
		};
	}
}
