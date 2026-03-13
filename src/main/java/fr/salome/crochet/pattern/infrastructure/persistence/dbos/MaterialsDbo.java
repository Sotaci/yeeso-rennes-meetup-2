package fr.salome.crochet.pattern.infrastructure.persistence.dbos;

import fr.salome.crochet.pattern.domain.entities.values.Materials;
import jakarta.persistence.Embeddable;

import java.util.List;
import java.util.UUID;

@Embeddable
public record MaterialsDbo(List<UUID> yarnIds, List<UUID> hookIds) {

	public static MaterialsDbo fromDomain(Materials materials) {
		return new MaterialsDbo(materials.yarnIds(), materials.hookIds());
	}

	public static Materials toDomain(MaterialsDbo dbo) {
		return new Materials(dbo.yarnIds(), dbo.hookIds());
	}
}
