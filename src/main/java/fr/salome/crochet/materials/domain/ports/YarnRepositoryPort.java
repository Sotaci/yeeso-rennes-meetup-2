package fr.salome.crochet.materials.domain.ports;

import fr.salome.crochet.materials.domain.entities.Yarn;

import java.util.List;
import java.util.UUID;

public interface YarnRepositoryPort {
	List<Yarn> findAll();
	List<Yarn> findAllById(List<UUID> yarnIds);
}
