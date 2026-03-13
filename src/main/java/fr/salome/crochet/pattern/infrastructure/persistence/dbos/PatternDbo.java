package fr.salome.crochet.pattern.infrastructure.persistence.dbos;

import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.PatternState;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.EmbeddedColumnNaming;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pattern")
public class PatternDbo {

	@Id
	private UUID id;
	private String name;
	@Enumerated(EnumType.STRING)
	private PatternState state;
	@Embedded
	@EmbeddedColumnNaming("gauge_%s")
	private GaugeDbo gauge;
	private List<String> instructions;

	public PatternDbo() {
	}

	public PatternDbo(UUID id, String name, PatternState state, GaugeDbo gauge, List<String> instructions) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.gauge = gauge;
		this.instructions = instructions;
	}

	public static PatternDbo fromDomain(Pattern pattern) {
		return new PatternDbo(pattern.id().value(), pattern.name(), pattern.state(), GaugeDbo.fromDomain(pattern.gauge()), pattern.instructions());
	}

	public static Pattern toDomain(PatternDbo dbo) {
		return new Pattern(dbo.getId(), dbo.getName(), dbo.getState(), dbo.getInstructions(), GaugeDbo.toDomain(dbo.getGauge()));
	}
}
