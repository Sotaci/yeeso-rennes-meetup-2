package fr.salome.crochet.pattern.domain.ports;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternNotFoundException;

public interface PatternRepositoryPort {
	Pattern findById(PatternId id) throws PatternNotFoundException;

	Pattern create(Pattern pattern);

	Pattern update(Pattern pattern);

	Pattern publishForTest(Pattern pattern) throws PatternDomainException;

	Pattern publishForSale(Pattern pattern, long price) throws PatternDomainException;
}
