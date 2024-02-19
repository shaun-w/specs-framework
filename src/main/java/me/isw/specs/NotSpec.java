package me.isw.specs;

public class NotSpec<T> extends CompositeSpecification<T> {
    private final Specification<T> spec;

    public NotSpec(Specification<T> spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(T entity) {
        return !spec.isSatisfiedBy(entity);
    }
}
