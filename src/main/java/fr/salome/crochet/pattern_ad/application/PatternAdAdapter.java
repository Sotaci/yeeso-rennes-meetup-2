package fr.salome.crochet.pattern_ad.application;

import fr.salome.crochet.pattern_ad.PatternAdAPI;
import fr.salome.crochet.pattern_ad.domain.entities.PatternAd;
import fr.salome.crochet.pattern_ad.domain.usecases.CreateAdFromPattern;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PatternAdAdapter implements PatternAdAPI {

	private final CreateAdFromPattern createAdFromPattern;

	public PatternAdAdapter(CreateAdFromPattern createAdFromPattern) {
		this.createAdFromPattern = createAdFromPattern;
	}


	@Override
	public PatternAd create(UUID patternId, String name, long price) {
		return createAdFromPattern.create(patternId, name, price);
	}
}
