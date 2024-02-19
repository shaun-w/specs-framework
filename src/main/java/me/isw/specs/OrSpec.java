package me.isw.specs;

public class OrSpec<T> extends CompositeSpecification<T> {
    private final Specification<T> left;
    private final Specification<T> right;

    public OrSpec(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T entity) {
        return left.isSatisfiedBy(entity) || right.isSatisfiedBy(entity);
    }
}
