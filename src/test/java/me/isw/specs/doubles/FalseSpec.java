package me.isw.specs.doubles;

import me.isw.specs.CompositeSpecification;

public class FalseSpec extends CompositeSpecification<DummyEntity> {
    @Override
    public boolean isSatisfiedBy(DummyEntity entity) {
        return false;
    }
}
