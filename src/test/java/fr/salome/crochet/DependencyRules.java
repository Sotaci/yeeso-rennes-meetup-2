package fr.salome.crochet;

import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class DependencyRules {
	private DependencyRules() {
	}

	public static ArchRule onlyAccessFromTo(String from, String... to) {
		return classes()
				.that()
				.resideInAPackage(from)
				.should()
				.onlyAccessClassesThat()
				.resideInAnyPackage(to);
	}

	public static ArchRule noDependenciesFromTo(String from, String... to) {
		return noClasses()
				.that()
				.resideInAPackage(from)
				.should()
				.dependOnClassesThat()
				.resideInAnyPackage(to);
	}
}
