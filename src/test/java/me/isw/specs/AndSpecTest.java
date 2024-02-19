package me.isw.specs;

import me.isw.specs.doubles.DummyEntity;
import me.isw.specs.doubles.FalseSpec;
import me.isw.specs.doubles.TrueSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AndSpecTest {

    @Test
    @DisplayName("Given true and true, then true")
    void trueAndTrue() {
        Specification<DummyEntity> specification = new AndSpec<>(new TrueSpec(), new TrueSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isTrue();
    }

    @Test
    @DisplayName("Given true and false, then false")
    void trueAndFalse() {
        Specification<DummyEntity> specification = new AndSpec<>(new TrueSpec(), new FalseSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isFalse();
    }

    @Test
    @DisplayName("Given false and false, then false")
    void falseAndFalse() {
        Specification<DummyEntity> specification = new AndSpec<>(new FalseSpec(), new FalseSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isFalse();
    }
}
