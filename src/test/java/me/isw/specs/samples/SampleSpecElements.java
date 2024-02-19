package me.isw.specs.samples;

import me.isw.specs.CompositeSpecification;

public class SampleSpecElements {
    static class AgeOver21 extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.age() >= 21;
        }
    }

    static class AgeUnder21 extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.age() < 21;
        }
    }

    static class SecurityClearanceIsGreaterThan3 extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.clearance() > 3;
        }
    }

    static class IsOnSecurityBlacklist extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.blacklisted();
        }
    }

    static class HasPremiumMembership extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.membershipType() == 'P';
        }
    }

    static class HasStandardMembership extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.membershipType() == 'S';
        }
    }

    static class IsStudent extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.student();
        }
    }

    static class IsUkCitizen extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.citizenship().contains("UK");
        }
    }

    static class IsIrishCitizen extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.citizenship().contains("IE");
        }
    }

    static class HasConvictions extends CompositeSpecification<EntityData> {

        @Override
        public boolean isSatisfiedBy(EntityData entity) {
            return entity.convictions();
        }
    }
}
