package me.isw.specs;

public abstract class CompositeSpecification<T> implements Specification<T> {
    @Override
    public Specification<T> and(Specification<T> specification) {
        return new AndSpec<>(this, specification);
    }

    @Override
    public Specification<T> or(Specification<T> specification) {
        return new OrSpec<>(this, specification);
    }

    @Override
    public Specification<T> xor(Specification<T> specification) {
        return new XOrSpec<>(this, specification);
    }

    @Override
    public Specification<T> not() {
        return new NotSpec<>(this);
    }
}
