package me.isw.specs.samples;

import java.util.List;

public record EntityData(int age, List<String> citizenship, int clearance, boolean blacklisted, char membershipType, boolean student,
                         boolean convictions) {

    @Override
    public String toString() {
        return "EntityData[" +
                "age=" + age + ", " +
                "citizenship=" + citizenship + ", " +
                "clearance=" + clearance + ", " +
                "blacklisted=" + blacklisted + ", " +
                "membershipType=" + membershipType + ", " +
                "student=" + student + ", " +
                "convictions=" + convictions + ']';
    }

    public static class Builder {
        private int age;
        private List<String> citizenships;
        private int clearance;
        private boolean blacklisted;
        private char membershipType;
        private boolean student;
        private boolean convictions;

        public static Builder builder() {
            return new Builder();
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setCitizenships(List<String> citizenships) {
            this.citizenships = citizenships;
            return this;
        }

        public Builder setClearance(int clearance) {
            this.clearance = clearance;
            return this;
        }

        public Builder setBlacklisted(boolean blacklisted) {
            this.blacklisted = blacklisted;
            return this;
        }

        public Builder setMembershipType(char membershipType) {
            this.membershipType = membershipType;
            return this;
        }

        public Builder setStudent(boolean student) {
            this.student = student;
            return this;
        }

        public Builder setConvictions(boolean convictions) {
            this.convictions = convictions;
            return this;
        }

        public EntityData createEntityData() {
            return new EntityData(age, citizenships, clearance, blacklisted, membershipType, student, convictions);
        }
    }

}
