package fr.salome.crochet.pattern.domain.entities;

import fr.salome.crochet.pattern.domain.entities.values.Gauge;
import fr.salome.crochet.pattern.domain.entities.values.Materials;
import fr.salome.crochet.pattern.domain.entities.values.PatternId;
import fr.salome.crochet.pattern.domain.entities.values.PatternState;
import fr.salome.crochet.pattern.domain.exceptions.PatternDomainException;
import fr.salome.crochet.pattern.domain.exceptions.PatternValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pattern {

	// ID encapsulé dans un value object
	private final PatternId id;

	private String name;
	private PatternState state;
	private final List<String> instructions;

	// value object
	private Gauge gauge;
	private Materials materials;

	// constructeur utilisé uniquement par la couche infrastructure
	public Pattern(UUID id, String name, PatternState state, List<String> instructions, Gauge gauge, Materials materials) {
		this.id = new PatternId(id);
		this.name = name;
		this.state = state;
		this.gauge = gauge;
		this.instructions = instructions;
		this.materials = materials;
	}

	private Pattern(String name) {
		this.id = new PatternId(UUID.randomUUID());
		this.name = name;
		this.state = PatternState.IN_PROGRESS;
		this.gauge = null;
		this.instructions = new ArrayList<>();
		this.materials = Materials.empty();
	}

	// factory method, utilisée pour créer un nouveau pattern
	public static Pattern create(String name) throws PatternValidationException {
		return new Pattern(name);
	}

	/*
	 * mise a jour
	 */

	public void updateName(String name) throws PatternDomainException {
		validateUpdateAllowed();

		this.name = name;
	}

	public void updateGauge(Gauge gauge) throws PatternDomainException {
		validateUpdateAllowed();

		this.gauge = gauge;
	}

	public void updateInstruction(int index, String content) throws PatternDomainException {
		validateUpdateAllowed();

		if (index < 0) {
			throw PatternDomainException.invalidInstructionIndex();
		}

		if (index >= instructions.size()) {
			this.instructions.add(content);
			return;
		}

		this.instructions.set(index, content);
	}

	public void updateMaterials(Materials materials) throws PatternDomainException {
		validateUpdateAllowed();

		this.materials = materials;
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

	public PatternState state() {
		return state;
	}

	public Materials materials() {
		return materials;
	}

	public boolean isNew() {
		return state == PatternState.IN_PROGRESS;
	}

	public boolean isPublished() {
		return state == PatternState.PUBLISHED;
	}

	public boolean isInTesting() {
		return state == PatternState.IN_TESTING;
	}

	public void publishForSale() throws PatternDomainException {
		validatePublication();
		this.state = PatternState.PUBLISHED;
	}

	public void publishForTest() throws PatternDomainException {
		validatePublicationForTest();
		this.state = PatternState.IN_TESTING;
	}





	// On utilise des checked exceptions : le domaine est obligé de fournir son contrat "complet"
	// Signale la violation d'un invariant et doit être gérée par le 'caller' → on rend les erreurs métiers visibles intentionnelles
	private void validateUpdateAllowed() throws PatternDomainException {
		if (isInTesting()) {
			throw PatternDomainException.alreadyPublishedForTest(id);
		}

		if (isPublished()) {
			throw PatternDomainException.alreadyPublishedForSale(id);
		}
	}





	private void validatePublication() throws PatternDomainException {
		if (instructions.isEmpty()) {
			throw PatternDomainException.cannotPublishEmptyInstructions(id);
		}

		if (isPublished()) {
			throw PatternDomainException.alreadyPublishedForSale(id);
		}
	}

	private void validatePublicationForTest() throws PatternDomainException {
		validatePublication();
		if (isInTesting()) {
			throw PatternDomainException.alreadyPublishedForTest(id);
		}
	}
}
