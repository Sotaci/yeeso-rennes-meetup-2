package fr.salome.crochet.pattern.application.rest.response;

import fr.salome.crochet.pattern.domain.entities.values.Gauge;

public record GaugeResponse(int nbStitches, int nbRows, int width, int height) {

	public static GaugeResponse fromEntity(Gauge gauge) {
		return new GaugeResponse(
				gauge.nbStitches(),
				gauge.nbRows(),
				gauge.width(),
				gauge.height()
		);
	}
}
