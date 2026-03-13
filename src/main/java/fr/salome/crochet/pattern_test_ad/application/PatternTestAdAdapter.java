package fr.salome.crochet.pattern_test_ad.application;

import fr.salome.crochet.pattern_test_ad.PatternTestAdAPI;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PatternTestAdAdapter implements PatternTestAdAPI {
	@Override
	public void create(UUID patternId, String name) {

	}
}
