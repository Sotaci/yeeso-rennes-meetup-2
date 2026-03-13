package fr.salome.crochet.pattern_ad.domain.entities;

import fr.salome.crochet.pattern_ad.domain.entities.values.PatternAdId;

import java.util.UUID;

public class PatternAd {
	private final PatternAdId id;
	private final UUID patternId;
	private final String name;
	private long price;

	public PatternAd(PatternAdId id, UUID patternId, String name, long price) {
		this.id = id;
		this.patternId = patternId;
		this.name = name;
		this.price = price;
	}

	private PatternAd(UUID patternId, String name, long price) {
		this.id = new PatternAdId(UUID.randomUUID());
		this.patternId = patternId;
		this.name = name;
		this.price = price;
	}

	public static PatternAd create(UUID patternId, String name, long price) {
		return new PatternAd(patternId, name, price);
	}

	public PatternAdId getId() {
		return id;
	}

	public UUID getPatternId() {
		return patternId;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}
}
