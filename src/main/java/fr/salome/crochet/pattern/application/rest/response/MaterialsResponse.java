package fr.salome.crochet.pattern.application.rest.response;

import fr.salome.crochet.pattern.domain.entities.values.Materials;

import java.util.List;
import java.util.UUID;

public record MaterialsResponse(List<UUID> yarnsIds, List<UUID> hookIds) {

	public static MaterialsResponse fromDomain(Materials materials) {
		return new MaterialsResponse(materials.yarnIds(), materials.hookIds());
	}
}
