package StudentDistributionSystem;
import java.util.*;


public class StudentDB {

    // 81 - semester * 10 + section
    private final Map<Integer, ArrayList<Student>> studentData = new HashMap<>();

    StudentDB(){
        for(int i = 10; i < 90; i++ ){
            studentData.put(i, new ArrayList<>());
        }
    }


    public void addStudent(Student student) {
        int code = student.getSemester() * 10 + student.getSection();
        studentData.get(code).add(student);
    }

    public void showStudents(int code) {

        ArrayList<Student> students = studentData.get(code);

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    ArrayList<Student> secStudents(int code){
        return new ArrayList<>(studentData.get(code));
    }



}