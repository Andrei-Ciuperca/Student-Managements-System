import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean shouldFinish = false;

        // A faculty for each study field (For testing purposes)
//       Faculty T = new Faculty("Transport", "T", StudyField.MECHANICAL_ENGINEERING);
//       // Faculty CSI = new Faculty("Computer Science", "CSI", StudyField.SOFTWARE_ENGINEERING);
//        Faculty FN = new Faculty("Food and Nutrition", "FN", StudyField.FOOD_TECHNOLOGY);
//        Faculty UD = new Faculty("Urban Design", "UD", StudyField.URBANISM_ARCHITECTURE);
//        Faculty DFSPH = new Faculty("DEPARTMENT OF FOOD SAFETY AND PUBLIC HEALTH", "DFSPH", StudyField.VETERINARY_MEDICINE);
//
//        // Hard coded students
//        Student student2 = new Student("Sebastian", "Finciuc", "sebastian.finciuc@gmail.com", new Date(), new Date(), FN, false);
//        FN.createStudent(student2);
//        Student student1 = new Student("Andrei", "Ciuperca", "sebastian.finciuc@gmail.com", new Date(), new Date(), FN, false);
//        FN.createStudent(student1);
//        Student student3 = new Student("Dragos", "Carp", "sebastian.finciuc@gmail.com", new Date(), new Date(), T, false);
//        T.createStudent(student3);


        while(!shouldFinish) {
            System.out.print("""
                    TUM Board Command Line\s
                    \t1. General Operations\s
                    \t2. Faculty Operations\s
                    \t3. File Management\s
                    \t4. Quit (Auto-saves Faculties and Students)
                    Please chose one of the above options:\s""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("""
                            General options:\s
                            \t1.Create a new faculty
                            \t2.Search for a students faculty by email
                            \t3.Display all University faculties
                            \t4.Display all faculties belonging to a field.""");
                    switch (scanner.nextInt()) {
                        case 1 -> {
                            scanner.nextLine(); // Consume the newline character left by nextInt()

                            System.out.println("Enter Faculty Name: ");
                            String fName = scanner.nextLine();
                            System.out.println("Enter Faculty Abbreviation: ");
                            String fAbbreviation = scanner.nextLine();
                            System.out.println("""
                                    Enter Study Field: \s  +
                                    \t1.Mechanical Engineering
                                    \t2.Software Engineering
                                    \t3.Food technology
                                    \t4.Urbanism Architecture
                                    \t5.Veterinary medicine""");

                            switch (scanner.nextInt()){
                                case 1 -> {
                                    StudyField field = StudyField.MECHANICAL_ENGINEERING;
                                    new Faculty(fName, fAbbreviation, field);

                                }
                                case 2 -> {
                                    StudyField field = StudyField.SOFTWARE_ENGINEERING;
                                    new Faculty(fName, fAbbreviation, field);
                                }
                                case 3 -> {
                                    StudyField field = StudyField.FOOD_TECHNOLOGY;
                                    new Faculty(fName, fAbbreviation, field);
                                }
                                case 4 -> {
                                    StudyField field = StudyField.URBANISM_ARCHITECTURE;
                                    new Faculty(fName, fAbbreviation, field);
                                }
                                case 5 -> {
                                    StudyField field = StudyField.VETERINARY_MEDICINE;
                                    new Faculty(fName, fAbbreviation, field);
                                }
                            }
                            break;
                        }
                        case 2 -> {
                            scanner.nextLine();
                            System.out.println("Enter student email: ");
                            String sEmail = scanner.nextLine();

                            Faculty.displayStudentFaculty(sEmail);
                        }
                        case 3 -> Faculty.displayAllFaculties();
                        case 4 -> {
                            scanner.nextLine();
                            //System.out.println("Enter a Study Field: "); //TODO: transform this into a pick the field
                            System.out.println("""
                                    Enter Study Field: \s  +
                                    \t1.Mechanical Engineering
                                    \t2.Software Engineering
                                    \t3.Food technology
                                    \t4.Urbanism Architecture
                                    \t5.Veterinary medicine""");

                            switch (scanner.nextInt()){
                                case 1 -> {
                                    StudyField field = StudyField.MECHANICAL_ENGINEERING;
                                    Faculty.displayAllFacultiesOfAField(field);                                }
                                case 2 -> {
                                    StudyField field = StudyField.SOFTWARE_ENGINEERING;
                                    Faculty.displayAllFacultiesOfAField(field);                                }
                                case 3 -> {
                                    StudyField field = StudyField.FOOD_TECHNOLOGY;
                                    Faculty.displayAllFacultiesOfAField(field);                                }
                                case 4 -> {
                                    StudyField field = StudyField.URBANISM_ARCHITECTURE;
                                    Faculty.displayAllFacultiesOfAField(field);
                                }
                                case 5 -> {
                                    StudyField field = StudyField.VETERINARY_MEDICINE;
                                    Faculty.displayAllFacultiesOfAField(field);
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("""
                            Faculty options:\s
                            \t1.Create a new student
                            \t2.Graduate student by email
                            \t3.Display all enrolled students in a faculty
                            \t4.Display all students graduated from a faculty
                            \t5.Check if student belongs to faculty""");
                    switch (scanner.nextInt()) {
                        case 1 -> {
                            scanner.nextLine();
                            System.out.println("Enter student first name: ");
                            String sFirstName = scanner.nextLine();
                            System.out.println("Enter student last name: ");
                            String sLastName = scanner.nextLine();
                            System.out.println("Enter student email: ");
                            String sEmail = scanner.nextLine();
                            System.out.println("Enter Faculty Abbreviation: ");
                            String fAbbreviation = scanner.nextLine();

                            Faculty studentFaculty = Faculty.getFacultyByAbbreviation(fAbbreviation);

                            Student student = new Student(sFirstName, sLastName, sEmail, new Date(), new Date(), studentFaculty, false);
                            System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " has been created and added to the: " + studentFaculty.getName() + " faculty");
                            studentFaculty.createStudent(student);
                        }
                        case 2 -> {
                            scanner.nextLine();
                            System.out.println("Enter email of student you'd like to graduate: ");
                            String sEmail = scanner.nextLine();

                            Faculty.graduateStudent(sEmail);
                        }
                        case 3 -> {
                            scanner.nextLine();
                            System.out.println("Enter faculty abbreviation: ");
                            String abbreviation = scanner.nextLine();
                            System.out.println("Students enrolled in " + abbreviation + ":");
                            Faculty.displayStudents(abbreviation, false);
                        }
                        case 4 -> {
                            scanner.nextLine();
                            System.out.println("Enter faculty abbreviation: ");
                            String abbreviation = scanner.nextLine();
                            System.out.println("Students graduated from " + abbreviation + ":");
                            Faculty.displayStudents(abbreviation, true);

                        }
                        case 5 -> {
                            scanner.nextLine();
                            System.out.println("Enter student email");
                            String sEmail = scanner.nextLine();
                            System.out.println("Enter faculty abbreviation");
                            String abbreviation = scanner.nextLine();

                            Faculty.isStudentFromFaculty(abbreviation, sEmail);
                        }
                    }
                    break;

                case 3:
                    System.out.println("""
                            File Management options:\s
                            \t1.Save all changes made to Students/Faculties\s
                            \t2.Load from saved file
                            """);
                    switch (scanner.nextInt()) {
                        case 1 -> {
                            FileManagement.writeToFile(Faculty.getFaculties());
                            System.out.println("Saved all Faculties and Students!");
                            FileManagement.loggingFile("Saved all Faculties and their respective Students into Faculties.txt");
                        }
                        case 2 -> {
                            FileManagement.readFromFile();
                            System.out.println("Loaded all Faculties and Students!");
                            FileManagement.loggingFile("Loaded Faculties and Students from Faculties.txt");
                        }
                    }break;
                case 4:
                    shouldFinish = true;
                    FileManagement.writeToFile(Faculty.getFaculties());
                    break;

                default:
                    System.out.println("world");
            }
        }

    }
}