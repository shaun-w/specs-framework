package me.isw.specs;

import me.isw.specs.doubles.DummyEntity;
import me.isw.specs.doubles.FalseSpec;
import me.isw.specs.doubles.TrueSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotSpecTest {

    @Test
    @DisplayName("Given true, then false")
    void trueAndTrue() {
        Specification<DummyEntity> specification = new NotSpec<>(new TrueSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isFalse();
    }

    @Test
    @DisplayName("Given false, then true")
    void trueAndFalse() {
        Specification<DummyEntity> specification = new NotSpec<>(new FalseSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isTrue();
    }

}
