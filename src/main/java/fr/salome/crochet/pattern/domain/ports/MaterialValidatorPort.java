package fr.salome.crochet.pattern.domain.ports;

import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;

import java.util.List;
import java.util.UUID;

public interface MaterialValidatorPort {
	void validateYarnIds(List<UUID> yarnIds) throws PatternDomainException;

	void validateHookIds(List<UUID> hookIds) throws PatternDomainException;
}
