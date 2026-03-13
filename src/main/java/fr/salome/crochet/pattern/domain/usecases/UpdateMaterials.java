package fr.salome.crochet.pattern.domain.usecases;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;
import fr.salome.crochet.pattern.domain.ports.MaterialValidatorPort;
import fr.salome.crochet.pattern.domain.ports.PatternRepositoryPort;

import java.util.List;
import java.util.UUID;

public class UpdateMaterials {
	private final PatternRepositoryPort repository;
	private final MaterialValidatorPort materialValidator;

	public UpdateMaterials(PatternRepositoryPort repository, MaterialValidatorPort materialValidator) {
		this.repository = repository;
		this.materialValidator = materialValidator;
	}

	public Pattern updateYarns(PatternId id, List<UUID> newYarns) throws PatternDomainException, PatternNotFoundException {
		// validation de l'existence des IDs
		materialValidator.validateYarnIds(newYarns);

		final var pattern = repository.findById(id);
		pattern.updateMaterials(pattern.materials().withYarns(newYarns));
		return repository.update(pattern);
	}

	private Pattern updateHooks(PatternId id, List<UUID> newHooks) throws PatternDomainException, PatternNotFoundException {
		// validation de l'existence des IDs
		materialValidator.validateHookIds(newHooks);

		final var pattern = repository.findById(id);
		pattern.updateMaterials(pattern.materials().withHooks(newHooks));
		return repository.update(pattern);
	}
}
