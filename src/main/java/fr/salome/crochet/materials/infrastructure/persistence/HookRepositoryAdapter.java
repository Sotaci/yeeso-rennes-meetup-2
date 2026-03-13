package fr.salome.crochet.materials.infrastructure.persistence;

import fr.salome.crochet.materials.domain.entities.Hook;
import fr.salome.crochet.materials.domain.ports.HookRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class HookRepositoryAdapter implements HookRepositoryPort {
	@Override
	public List<Hook> findAll() {
		return List.of();
	}

	@Override
	public List<Hook> findAllById(List<UUID> hookIds) {
		return List.of();
	}
}
