package fr.salome.crochet.pattern.domain.entities.values;

import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;

/**
 * Value object — représente un échantillon de crochet <br>
 * Constructeur public pour la couche infrastructure (désérialisation). <br>
 * Utiliser la factory method {@link #of(int, int, int, int)} pour créer une instance validée.
 */
public record Gauge(int nbStitches, int nbRows, int width, int height) {

	// Factory method avec validation
	public static Gauge of(int nbStitches, int nbRows, int width, int height) throws PatternDomainException {
		if (nbStitches <= 0 || nbRows <= 0 || width <= 0 || height <= 0) {
			throw PatternDomainException.invalidGaugeValues();
		}
		return new Gauge(nbStitches, nbRows, width, height);
	}
}
