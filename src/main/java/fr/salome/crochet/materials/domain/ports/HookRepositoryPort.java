package fr.salome.crochet.materials.domain.ports;

import fr.salome.crochet.materials.domain.entities.Hook;
import fr.salome.crochet.materials.domain.entities.Yarn;

import java.util.List;
import java.util.UUID;

public interface HookRepositoryPort {
	List<Hook> findAll();
	List<Hook> findAllById(List<UUID> hookIds);
}
