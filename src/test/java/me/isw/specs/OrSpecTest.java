package me.isw.specs;

import me.isw.specs.doubles.DummyEntity;
import me.isw.specs.doubles.FalseSpec;
import me.isw.specs.doubles.TrueSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrSpecTest {

    @Test
    @DisplayName("Given true or true, then true")
    void trueAndTrue() {
        Specification<DummyEntity> specification = new OrSpec<>(new TrueSpec(), new TrueSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isTrue();
    }

    @Test
    @DisplayName("Given true or false, then true")
    void trueAndFalse() {
        Specification<DummyEntity> specification = new OrSpec<>(new TrueSpec(), new FalseSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isTrue();
    }

    @Test
    @DisplayName("Given false or false, then false")
    void falseAndFalse() {
        Specification<DummyEntity> specification = new OrSpec<>(new FalseSpec(), new FalseSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isFalse();
    }
}
