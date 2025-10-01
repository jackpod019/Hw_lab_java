package lab7_2;

// FixedSalary.java (จากปฏิบัติการที่ 6)
public class FixedSalary {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double weeklySalary;

    public FixedSalary(String firstName, String lastName, String ssn, double weeklySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = ssn;
        this.weeklySalary = weeklySalary;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
