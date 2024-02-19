package me.isw.specs;

public interface Specification<T> {
    boolean isSatisfiedBy(T entity);

    Specification<T> and(Specification<T> specification);

    Specification<T> or(Specification<T> specification);

    Specification<T> xor(Specification<T> specification);

    Specification<T> not();
}
