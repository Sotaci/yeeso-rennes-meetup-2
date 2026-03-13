package fr.salome.crochet.pattern.infrastructure.persistence.dbos;

import fr.salome.crochet.pattern.domain.entities.values.Gauge;
import jakarta.persistence.Embeddable;

import java.util.Optional;

@Embeddable
public record GaugeDbo(int nbStitches, int nbRows, int width, int height) {

	public static GaugeDbo fromDomain(Gauge gauge) {
		return Optional.ofNullable(gauge)
				.map(g -> new GaugeDbo(g.nbStitches(), g.nbRows(), g.width(), g.height()))
				.orElse(null);
	}

	public static Gauge toDomain(GaugeDbo gaugeDbo) {
		return Optional.ofNullable(gaugeDbo)
				.map(dbo -> new Gauge(dbo.nbStitches(), dbo.nbRows(), dbo.width(), dbo.height()))
				.orElse(null);
	}
}
