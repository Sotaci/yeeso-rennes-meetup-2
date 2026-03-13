package fr.salome.crochet.kernel;

// Specification pattern
public interface Specification<T> {
	Result<T> isSatisfiedBy(T candidate);
}
