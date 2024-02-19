package me.isw.specs;

import me.isw.specs.doubles.DummyEntity;
import me.isw.specs.doubles.FalseSpec;
import me.isw.specs.doubles.TrueSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class XOrSpecTest {

    @Test
    @DisplayName("Given true xor true, then false")
    void trueAndTrue() {
        Specification<DummyEntity> specification = new XOrSpec<>(new TrueSpec(), new TrueSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isFalse();
    }

    @Test
    @DisplayName("Given true xor false, then true")
    void trueAndFalse() {
        Specification<DummyEntity> specification = new XOrSpec<>(new TrueSpec(), new FalseSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isTrue();
    }

    @Test
    @DisplayName("Given false xor false, then false")
    void falseAndFalse() {
        Specification<DummyEntity> specification = new XOrSpec<>(new FalseSpec(), new FalseSpec());

        assertThat(specification.isSatisfiedBy(new DummyEntity())).isFalse();
    }
}
