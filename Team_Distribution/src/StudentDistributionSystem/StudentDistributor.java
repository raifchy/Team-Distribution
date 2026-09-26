package StudentDistributionSystem;

import java.util.ArrayList;
import java.util.Collections;


interface Distributor {
    void generate(int code, int teamSize);
    void result(ArrayList<Student>[] teams);
}
// Project Distribution



class StudentDistributor implements Distributor{

    private final StudentDB mainDB;
    StudentDistributor(StudentDB mainDB){
        this.mainDB = mainDB;
    }
    @Override
    public void generate(int code, int teamSize){

        ArrayList<Student> secStudents = mainDB.secStudents(code);

        // min ------ max sort
        secStudents.sort((a, b) -> Double.compare(a.getCg(), b.getCg()));

        int total_student = secStudents.size();
        int total_team = total_student / teamSize;
        System.out.println("total team " + total_team);

        if(total_student % teamSize != 0)
            total_team = total_team + 1;


        ArrayList<Student>[] teams = new ArrayList[total_team];
        for (int i = 0; i < total_team; i++) {
            teams[i] = new ArrayList<>();
        }



        // assign student in team

        boolean order = true;
        int curStudent = 0;
        ArrayList<Student> hold = new ArrayList<>();

        for(Student student : secStudents){
            hold.add(student);
            curStudent++;
            if( (hold.size() == total_team) || (curStudent == total_student) ){
                if(order == false)
                    Collections.reverse(hold);

                int cur = 0;
                while(cur < Math.min(total_team,hold.size()) ){
                    teams[cur].add(hold.get(cur));
                    cur++;
                }

                hold.clear();
                order = !order;
            }
        }

        // Print Team
        result(teams);

    }

    @Override
    public void result( ArrayList<Student>[] teams){
        int teamNo = 0;
        for (ArrayList<Student> team : teams) {
            teamNo++;
            System.out.println("\n── Team " + teamNo + " ───────────────────────");
            for (Student student : team) {
                System.out.printf("  %-15s │ %s │ Sem %-2d │ Sec %d │ CG %.2f%n",
                        student.getName(), student.getId(), student.getSemester(),
                        student.getSection(), student.getCg());
            }

        }
    }

}