package me.isw.specs;

import me.isw.specs.samples.EntityData;
import me.isw.specs.samples.SampleSpecs;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IntegrationTest {

    @Test
    void canAccessRestrictedAreaScenarios() {
        /*
         * Access to Restricted Area
         * Conditions:
         * Age: Above 18
         * Security Clearance: Level 3 or higher
         * Not on Security Blacklist
         * Evaluation:
         * If (Age >= 18) AND (Security Clearance >= 3) AND (NOT on Security Blacklist), then Access Granted.
         */

        EntityData matchingEntity = EntityData.Builder.builder().setAge(21).setClearance(4).setBlacklisted(false).createEntityData();
        assertThat(SampleSpecs.canAccessRestrictedArea.isSatisfiedBy(matchingEntity)).isTrue();

        EntityData nonMatchingEntityAge = EntityData.Builder.builder().setAge(20).setClearance(4).setBlacklisted(false).createEntityData();
        assertThat(SampleSpecs.canAccessRestrictedArea.isSatisfiedBy(nonMatchingEntityAge)).isFalse();

        EntityData nonMatchingEntitySecurityClearance = EntityData.Builder.builder().setAge(21).setClearance(2).setBlacklisted(false).createEntityData();
        assertThat(SampleSpecs.canAccessRestrictedArea.isSatisfiedBy(nonMatchingEntitySecurityClearance)).isFalse();

        EntityData nonMatchingEntityBlacklisted = EntityData.Builder.builder().setAge(21).setClearance(4).setBlacklisted(true).createEntityData();
        assertThat(SampleSpecs.canAccessRestrictedArea.isSatisfiedBy(nonMatchingEntityBlacklisted)).isFalse();
    }

    @Test
    void canAccessMembershipBenefitsScenarios() {
        /*
         * Theme: Can have membership benefits
         * Conditions:
         * If (((Age < 21) AND (Membership Type is Standard)) OR ((Age >= 21) AND (Membership Type is Premium)))
         * AND (NOT a Student), then Extra Benefits Granted.
         */

        EntityData matchingEntityUnder21 = EntityData.Builder.builder().setAge(19).setMembershipType('S').setStudent(false).createEntityData();
        assertThat(SampleSpecs.canHaveMembershipBenefits.isSatisfiedBy(matchingEntityUnder21)).isTrue();

        EntityData matchingEntityOver21 = EntityData.Builder.builder().setAge(22).setMembershipType('P').setStudent(false).createEntityData();
        assertThat(SampleSpecs.canHaveMembershipBenefits.isSatisfiedBy(matchingEntityOver21)).isTrue();

        EntityData nonMatchingEntityOver21 = EntityData.Builder.builder().setAge(22).setMembershipType('S').setStudent(false).createEntityData();
        assertThat(SampleSpecs.canHaveMembershipBenefits.isSatisfiedBy(nonMatchingEntityOver21)).isFalse();

        EntityData nonMatchingEntityStudent = EntityData.Builder.builder().setAge(19).setMembershipType('S').setStudent(true).createEntityData();
        assertThat(SampleSpecs.canHaveMembershipBenefits.isSatisfiedBy(nonMatchingEntityStudent)).isFalse();
    }

    @Test
    void isEligibleForAnotherCitizenship() {
        /*
         * Theme: Is eligible for another citizenship
         * Conditions:
         * If (Citizenship is 'UK' XOR Citizenship is 'IE') AND (No convictions), then is eligible
         */
        EntityData matchingEntityUK = EntityData.Builder.builder().setCitizenships(List.of("UK")).setConvictions(false).createEntityData();
        assertThat(SampleSpecs.isEligibleForAnotherCitizenship.isSatisfiedBy(matchingEntityUK)).isTrue();

        EntityData matchingEntityIE = EntityData.Builder.builder().setCitizenships(List.of("IE")).setConvictions(false).createEntityData();
        assertThat(SampleSpecs.isEligibleForAnotherCitizenship.isSatisfiedBy(matchingEntityIE)).isTrue();

        EntityData nonMatchingEntityAlreadyDualCitizen = EntityData.Builder.builder().setCitizenships(List.of("UK", "IE")).setConvictions(false).createEntityData();
        assertThat(SampleSpecs.isEligibleForAnotherCitizenship.isSatisfiedBy(nonMatchingEntityAlreadyDualCitizen)).isFalse();

        EntityData nonMatchingEntityHasConvictions = EntityData.Builder.builder().setCitizenships(List.of("UK")).setConvictions(true).createEntityData();
        assertThat(SampleSpecs.isEligibleForAnotherCitizenship.isSatisfiedBy(nonMatchingEntityHasConvictions)).isFalse();
    }
}
