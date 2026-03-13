package fr.salome.crochet.pattern_ad.infrastructure;

import fr.salome.crochet.pattern_ad.domain.entities.PatternAd;
import fr.salome.crochet.pattern_ad.domain.ports.PatternAdRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PatternAdRepositoryAdapter implements PatternAdRepositoryPort {
	@Override
	public List<PatternAd> findAll() {
		return List.of();
	}

	@Override
	public Optional<PatternAd> findById(UUID id) {
		return Optional.empty();
	}

	@Override
	public Optional<PatternAd> findByPatternId(UUID patternId) {
		return Optional.empty();
	}

	@Override
	public PatternAd create(PatternAd patternAd) {
		return null;
	}

	@Override
	public PatternAd update(PatternAd patternAd) {
		return null;
	}
}
