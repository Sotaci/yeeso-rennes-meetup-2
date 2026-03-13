package fr.salome.crochet.pattern.infrastructure.persistence.repositories;

import fr.salome.crochet.pattern.infrastructure.persistence.dbos.PatternDbo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatternCrudRepository extends CrudRepository<PatternDbo, UUID> {
}
