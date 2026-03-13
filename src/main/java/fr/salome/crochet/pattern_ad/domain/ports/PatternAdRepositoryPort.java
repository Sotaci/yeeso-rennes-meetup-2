package fr.salome.crochet.pattern_ad.domain.ports;

import fr.salome.crochet.pattern_ad.domain.entities.PatternAd;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatternAdRepositoryPort {

	List<PatternAd> findAll();

	Optional<PatternAd> findById(UUID id);

	Optional<PatternAd> findByPatternId(UUID patternId);

	PatternAd create(PatternAd patternAd);

	PatternAd update(PatternAd patternAd);
}
