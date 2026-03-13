package fr.salome.crochet.pattern.application.rest.response;

import fr.salome.crochet.pattern.domain.entities.Pattern;

import java.util.List;
import java.util.UUID;

public record PatternResponse(UUID id, String name, GaugeResponse gauge, List<String> instructions) {

	public static PatternResponse fromEntity(Pattern pattern) {
		return new PatternResponse(
				pattern.id().value(),
				pattern.name(),
				GaugeResponse.fromEntity(pattern.gauge()),
				pattern.instructions()
		);
	}
}