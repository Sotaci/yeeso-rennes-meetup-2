package fr.salome.crochet.materials.domain.usecases;

import fr.salome.crochet.materials.domain.ports.HookRepositoryPort;
import fr.salome.crochet.materials.domain.ports.YarnRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ValidateMaterialsIds {

	private final HookRepositoryPort hookRepository;
	private final YarnRepositoryPort yarnRepository;

	public ValidateMaterialsIds(HookRepositoryPort hookRepository, YarnRepositoryPort yarnRepository) {
		this.hookRepository = hookRepository;
		this.yarnRepository = yarnRepository;
	}

	public boolean hooksExist(List<UUID> hookIds) {
		return Optional.ofNullable(hookIds)
				.map(ids -> {
					final var found = hookRepository.findAllById(ids);
					return found.size() == hookIds.size();
				}).orElse(false);
	}

	public boolean yarnsExist(List<UUID> yarnIds) {
		return Optional.ofNullable(yarnIds)
				.map(ids -> {
					final var found = yarnRepository.findAllById(ids);
					return found.size() == yarnIds.size();
				}).orElse(false);
	}
}
