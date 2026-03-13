package fr.salome.crochet.pattern_ad;

import fr.salome.crochet.pattern_ad.domain.entities.PatternAd;

import java.util.UUID;

public interface PatternAdAPI {
	PatternAd create(UUID patternId, String name, long price);
}
