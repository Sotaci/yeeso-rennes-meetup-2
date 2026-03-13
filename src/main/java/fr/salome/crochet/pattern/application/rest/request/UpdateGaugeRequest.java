package fr.salome.crochet.pattern.application.rest.request;

import fr.salome.crochet.pattern.domain.entities.values.Gauge;

public record UpdateGaugeRequest(int nbStitches, int nbRows, int width, int height) {

	public static Gauge toEntity(UpdateGaugeRequest request) {
		return new Gauge(
				request.nbStitches(),
				request.nbRows(),
				request.width(),
				request.height()
		);
	}
}
