package fr.salome.crochet.pattern.domain.entities;

import fr.salome.crochet.pattern.domain.entities.values.Gauge;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pattern {

	// ID encapsulé dans un value object
	private final PatternId id;

	private String name;
	private final List<String> instructions;

	// value object
	private Gauge gauge;


	// constructeur utilisé uniquement par la couche infrastructure
	public Pattern(UUID id, String name, List<String> instructions, Gauge gauge) {
		this.id = new PatternId(id);
		this.name = name;
		this.gauge = gauge;
		this.instructions = instructions;
	}

	private Pattern(String name) {
		this.id = new PatternId(UUID.randomUUID());
		this.name = name;
		this.gauge = null;
		this.instructions = new ArrayList<>();
	}

	// factory method, utilisée pour créer un nouveau pattern
	public static Pattern create(String name) {
		return new Pattern(name);
	}

	/*
	 * mise a jour
	 */

	public void updateName(String name) {
		this.name = name;
	}

	public void updateGauge(Gauge gauge) {
		this.gauge = gauge;
	}

	public void updateInstruction(int index, String content) {
		if (index >= instructions.size()) {
			this.instructions.add(content);
			return;
		}
		this.instructions.set(index, content);
	}

	/*
	 * accesseurs pour le mapping
	 */

	public PatternId id() {
		return id;
	}

	public String name() {
		return name;
	}

	public Gauge gauge() {
		return gauge;
	}

	public List<String> instructions() {
		return instructions;
	}
}
