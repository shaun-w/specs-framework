package me.isw.specs.samples;

import me.isw.specs.Specification;

public class SampleSpecs {

    static SampleSpecElements.AgeOver21 ageOver21 = new SampleSpecElements.AgeOver21();
    static SampleSpecElements.AgeUnder21 ageUnder21 = new SampleSpecElements.AgeUnder21();
    static SampleSpecElements.IsUkCitizen isUkCitizen = new SampleSpecElements.IsUkCitizen();
    static SampleSpecElements.IsIrishCitizen isIrishCitizen = new SampleSpecElements.IsIrishCitizen();
    static SampleSpecElements.SecurityClearanceIsGreaterThan3 securityClearanceIsHigh = new SampleSpecElements.SecurityClearanceIsGreaterThan3();
    static SampleSpecElements.IsOnSecurityBlacklist onSecurityBlacklist = new SampleSpecElements.IsOnSecurityBlacklist();
    static SampleSpecElements.HasStandardMembership hasStandardMembership = new SampleSpecElements.HasStandardMembership();
    static SampleSpecElements.HasPremiumMembership hasPremiumMembership = new SampleSpecElements.HasPremiumMembership();
    static SampleSpecElements.IsStudent isStudent = new SampleSpecElements.IsStudent();
    static SampleSpecElements.HasConvictions hasConvictions = new SampleSpecElements.HasConvictions();

    /*
     * Conditions:
     * Age: Above 21
     * Security Clearance: Level 3 or higher
     * Not on Security Blacklist
     * Evaluation:
     * If (Age >= 21) AND (Security Clearance >= 3) AND (NOT on Security Blacklist), then Access Granted.
     */
    public static Specification<EntityData> canAccessRestrictedArea =
            ageOver21.and(securityClearanceIsHigh)
                    .and(onSecurityBlacklist.not());

    /*
     * Theme: Can have membership benefits
     * Conditions:
     * If (((Age < 21) AND (Membership Type is Standard)) OR ((Age >= 21) AND (Membership Type is Premium)))
     * AND (NOT a Student), then Extra Benefits Granted.
     */
    public static Specification<EntityData> canHaveMembershipBenefits =
            (ageUnder21.and(hasStandardMembership)
                    .or(ageOver21.and(hasPremiumMembership)))
                    .and(isStudent.not());


    /*
     * Theme: Is eligible for another citizenship
     * Conditions:
     * If (Citizenship is 'UK' XOR Citizenship is 'IE') AND (No convictions), then is eligible
     */
    public static Specification<EntityData> isEligibleForAnotherCitizenship =
            isUkCitizen.xor(isIrishCitizen)
                    .and(hasConvictions.not());
}
