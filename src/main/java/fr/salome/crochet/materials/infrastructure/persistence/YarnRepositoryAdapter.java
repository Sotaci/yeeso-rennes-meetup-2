package fr.salome.crochet.materials.infrastructure.persistence;

import fr.salome.crochet.materials.domain.entities.Yarn;
import fr.salome.crochet.materials.domain.ports.YarnRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class YarnRepositoryAdapter implements YarnRepositoryPort {
	@Override
	public List<Yarn> findAll() {
		return List.of();
	}

	@Override
	public List<Yarn> findAllById(List<UUID> yarnIds) {
		return List.of();
	}
}
