package fr.salome.crochet.pattern.application.rest.response;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.PatternState;

import java.util.List;
import java.util.UUID;

public record PatternResponse(UUID id,
							  String name,
							  PatternState state,
							  GaugeResponse gauge,
							  List<String> instructions,
							  MaterialsResponse materials
) {

	public static PatternResponse fromEntity(Pattern pattern) {
		return new PatternResponse(
				pattern.id().value(),
				pattern.name(),
				pattern.state(),
				GaugeResponse.fromEntity(pattern.gauge()),
				pattern.instructions(),
				MaterialsResponse.fromDomain(pattern.materials())
		);
	}
}