import java.util.Date;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Date enrollmentDate;
    private final Date dateOfBirth;
    private final Faculty faculty;
    private boolean isGraduated;

    public Student(String firstName, String lastName, String email, Date enrollmentDate, Date dateOfBirth, Faculty faculty, boolean isGraduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
        this.faculty = faculty;
        this.isGraduated = isGraduated;

    }
    public boolean isGraduated() {
        return isGraduated;
    }
    public Faculty getFaculty() {
        return faculty;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setGraduated(boolean graduated) {
        this.isGraduated = graduated;
    }
}