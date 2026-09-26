package StudentDistributionSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInput {

    private Scanner scanner;

    public StudentInput(Scanner scanner) {
        this.scanner = scanner;
    }

    Student takeInput() {

        String name = scanner.nextLine();
        int id; // A
        while (true) {
            try {
                id = scanner.nextInt();
                break;
            } catch (InputMismatchException exception) {
                scanner.next();
                System.out.println("Invalid ID. Enter a whole number:");
            }
        }

        char sec;
        while (true) {
            try {
                sec = scanner.next().charAt(0);
                if(sec < 'A' || sec > 'F')
                    throw new SectionException();
                break;
            } catch (SectionException e) {
                System.out.println(e.getMessage());
            }
        }




        int semester;
        while (true) {
            try {
                semester = scanner.nextInt();
                break;
            } catch (InputMismatchException exception) {
                scanner.next();
                System.out.println("Invalid semester. Enter a whole number:");
            }
        }
        
        double cg;
        while (true) {
            try {
                cg = scanner.nextDouble();
                break;
            } catch (InputMismatchException exception) {
                scanner.next();
                System.out.println("Invalid CG. Enter a number:");
            }
        }


        scanner.nextLine();

        int section = sec - 'A' + 1;

        Student studentTmp = new Student(name, id,section, semester, cg);
        return studentTmp;
    }
}