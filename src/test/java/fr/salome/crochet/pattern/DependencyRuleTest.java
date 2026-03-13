package fr.salome.crochet.pattern;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import fr.salome.crochet.DependencyRules;
import fr.salome.crochet.pattern.domain.entities.Pattern;
import fr.salome.crochet.pattern.domain.entities.values.Gauge;
import fr.salome.crochet.pattern.domain.entities.values.PatternState;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "fr.salome.crochet.pattern", importOptions = ImportOption.DoNotIncludeTests.class)
class DependencyRuleTest {

	private static final String ROOT_PACKAGE = "fr.salome.crochet.pattern";
	private static final String KERNEL_PACKAGE = "fr.salome.crochet.kernel..";
	private static final String DOMAIN_PACKAGE = "%s.domain..".formatted(ROOT_PACKAGE);
	private static final String USECASES_PACKAGE = "%s.domain.usecases..".formatted(ROOT_PACKAGE);
	private static final String APPLICATION_PACKAGE = "%s.application..".formatted(ROOT_PACKAGE);
	private static final String INFRASTRUCTURE_PACKAGE = "%s.infrastructure..".formatted(ROOT_PACKAGE);

	@ArchTest
	static final ArchRule domainShouldBePure = DependencyRules.onlyAccessFromTo(DOMAIN_PACKAGE,
			DOMAIN_PACKAGE,
			KERNEL_PACKAGE,
			"java.."
	);

	@ArchTest
	static final ArchRule applicationShouldOnlyRelyOnDomainAndCore = DependencyRules.onlyAccessFromTo(APPLICATION_PACKAGE,
			APPLICATION_PACKAGE,
			DOMAIN_PACKAGE,
			KERNEL_PACKAGE,
			"java..",
			"org.springframework..",
			"jakarta.."
	);

	@ArchTest
	static final ArchRule infrastructureShouldOnlyRelyOnDomain = DependencyRules.onlyAccessFromTo(INFRASTRUCTURE_PACKAGE,
			INFRASTRUCTURE_PACKAGE,
			DOMAIN_PACKAGE,
			"java..",
			"org.springframework..",
			"jakarta..",
			// Pattern infra is allowed to access root of patternAd and patternTestAd modules
			"fr.salome.crochet.pattern_ad",
			"fr.salome.crochet.pattern_test_ad"
	);

	@ArchTest
	static final ArchRule usecasesShouldNotCallEachOther = DependencyRules.noDependenciesFromTo(USECASES_PACKAGE, USECASES_PACKAGE);

	@ArchTest
	static final ArchRule fullyQualifiedConstructorShouldBeUsedForDbMapping = noClasses()
			.that()
			.resideOutsideOfPackages(INFRASTRUCTURE_PACKAGE)
			.should()
			.callConstructor(Pattern.class.getName(), "id", "name", "state", "instructions", "gauge");
}
