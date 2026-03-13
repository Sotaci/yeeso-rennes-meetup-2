package fr.salome.crochet.kernel;

public record Success<T>(T value) implements Result<T> {}
