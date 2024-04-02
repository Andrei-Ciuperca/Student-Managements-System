import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class FileManagement {

    // Logging
    public static void loggingFile(String logText){
        try {
            File file = new File("LogFile.txt");
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(logText + " " + new Date());
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Saving Faculties and Students
    public static void writeToFile(List<Faculty> faculties) {
        try {
            // Saving faculties and students
            System.out.println("Saving data");
            File file = new File("Faculties.txt");
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Faculty faculty : faculties) {
                // Saving the faculty name, abbreviation, study field
                bufferedWriter.write(faculty.toString());
                bufferedWriter.newLine();

                // Saving the students
                for (Student student : faculty.getStudentList()) {
                    if (Objects.equals(student.getFaculty().getName(), faculty.getName())) {
                        bufferedWriter.write(faculty.toStudentString(student));
                    }
                }

                // Separate faculties with a blank line
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Data saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void readFromFile() {
        try {
            File file = new File("Faculties.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");

                    if (data.length == 3) {
                        // Faculty information
                        String facultyName = data[0];
                        String facultyAbbreviation = data[1];
                        StudyField studyField = StudyField.valueOf(data[2]);
                        new Faculty(facultyName, facultyAbbreviation, studyField);
                    } else if (data.length == 7) {
                        // Student information
                        String firstName = data[0];
                        String lastName = data[1];
                        String email = data[2];
                        String enrollmentDateString = data[3];
                        String dateOfBirthString = data[4];
                        String abbreviation = data[5];
                        boolean graduated = Boolean.parseBoolean(data[6]);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                        Date enrollmentDate = dateFormat.parse(enrollmentDateString);
                        Date dateOfBirth = dateFormat.parse(dateOfBirthString);

                        Faculty studentFaculty = Faculty.getFacultyByAbbreviation(abbreviation);

                        Student student = new Student(firstName, lastName, email, enrollmentDate, dateOfBirth, studentFaculty, graduated);


                        if (studentFaculty != null) {
                            studentFaculty.createStudent(student);
                        }
                    }
            }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

