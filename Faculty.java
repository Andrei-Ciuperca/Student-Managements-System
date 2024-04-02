import java.util.ArrayList;

public class Faculty  {
    private final String name;
    private final String abbreviation;
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private final StudyField studyField;
    private static final ArrayList<Faculty> faculties = new ArrayList<>();


    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
        faculties.add(this);
        FileManagement.loggingFile("Created new Faculty: " + name + " " + abbreviation + " " + studyField);
    }

    public String toString(){
        return name+ ";" + abbreviation + ";" + studyField;
    }
    public String toStudentString(Student student) {


        return student.getFirstName() + ";" +
                student.getLastName() + ";" +
                student.getEmail() + ";" +
                student.getEnrollmentDate() + ";" +
                student.getDateOfBirth() + ";" +
                student.getFaculty().getAbbreviation() + ";" +
                student.isGraduated() + ";" +
                "\n";
    }

    public static Faculty getFacultyByAbbreviation(String abbreviation){
        for (Faculty faculties : faculties) {
            if (faculties.getAbbreviation().equals(abbreviation)) {
                return faculties;
            }
        }
        return null;
    }
    // General Operations
    public static void displayStudentFaculty(String email){
        for (Student student : studentList) {
            if (student.getEmail().equals(email)) {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " belongs to the " + student.getFaculty().getName() + " faculty.");
            }
        }
    }


    public static void displayAllFaculties() {
        System.out.println("Here are all the faculties:");

        for (Faculty faculty : faculties) {
            System.out.println("Name: " + faculty.getName() + ", Abbreviation: " + faculty.getAbbreviation() + ", Study Field: " + faculty.getStudyField());
        }

    }

    public static void displayAllFacultiesOfAField(StudyField studyField){
        System.out.println("Here are all the faculties belonging to " + studyField);
        for (Faculty faculty : faculties){
            if (faculty.getStudyField().equals(studyField)){
                System.out.println(faculty.getName());
            }
        }
    }

    // Faculty Operations
    public void createStudent(Student student){
        //System.out.println(student.getFirstName() + " " + student.getLastName() + " was added to the student list in the " + student.getFaculty().getName());
        studentList.add(student);
        student.setGraduated(false);

        FileManagement.loggingFile("Student: " + student.getFirstName() + " " + student.getLastName() + " was added to the student list in the " + student.getFaculty().getName());
    }


    public static void graduateStudent(String email){
        for (Student student : studentList){
            if (student.getEmail().equals(email)) {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " has graduated from: " + student.getFaculty().getName());
                student.setGraduated(true);
                FileManagement.loggingFile("Student: " + student.getFirstName() + " " + student.getFirstName() + " was graduated");
            }
        }
    }


    public static void displayStudents(String abbreviation, boolean isGraduated){
        for (Student student : studentList) {
            if (student.getFaculty().getAbbreviation().equals(abbreviation) && !student.isGraduated() && !isGraduated) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            } else if (student.getFaculty().getAbbreviation().equals(abbreviation) && student.isGraduated() && isGraduated) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
    }


    public static void isStudentFromFaculty(String abbreviation, String email){
        for (Student student : studentList) {
            if (student.getFaculty().getAbbreviation().equals(abbreviation) && student.getEmail().equals(email)) {
                System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " does belong to faculty: " + student.getFaculty().getName());
            }
        }
    }
    public static ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public StudyField getStudyField() {
        return studyField;
    }
}