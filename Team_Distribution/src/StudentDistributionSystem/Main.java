package StudentDistributionSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Objects
        StudentDB mainDB = new StudentDB();
        StudentInput studentInpObj = new StudentInput(scanner);
        StudentDistributor teamEngine = new StudentDistributor(mainDB);


        /*---------------Header----------------*/
        // Instructions
        System.out.println("\n");
        System.out.println("╔══ Student Distribution System ══╗");
        System.out.println("║  Command                        ║");
        System.out.println("║  Add Student          →  1      ║");
        System.out.println("║  Make Teams           →  2      ║");
        System.out.println("║  Show Students        →  3      ║");
        System.out.println("║  Exit                 →  4      ║");
        System.out.println("╚═════════════════════════════════╝");
        // Code
        System.out.println("┌─ code ──────────────────────────┐");
        System.out.println("│  code = semester * 10 + section │");
        System.out.println("│  e.g. sem 3, sec 2  →  code 32  │");
        System.out.println("└─────────────────────────────────┘");



        
        while(true){
            System.out.print("\nEnter command: ");
            int cmd;

            while(true){
                try{
                    cmd = scanner.nextInt();
                    break;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("command is not corrct");
                }
            }


            if (cmd == 1) {
                System.out.println("\n── Add Student ───────────────────");
                System.out.print("Enter number of students: ");
                int size = scanner.nextInt();
                scanner.nextLine();

                for (int i = 1; i <= size; i++) {
                    Student tmp = studentInpObj.takeInput();
                    mainDB.addStudent(tmp);
                }

            } else if (cmd == 2) {
                System.out.println("\n── Make Teams ────────────────────");
                System.out.print("Enter section/code: ");

                int code = scanner.nextInt();

                System.out.print("Enter team size: ");
                int teamSize = scanner.nextInt();
                teamEngine.generate(code, teamSize);

            } else if (cmd == 3) {
                System.out.println("\n── Show Students ─────────────────");
                System.out.print("Enter section/code: ");
                int code = scanner.nextInt();
                mainDB.showStudents(code);

            } else if (cmd == 4) {
                System.out.println("\nExiting...");
                break;

            } else {
                System.out.println("\n  ✖  Invalid command!");
            }

            System.out.println("────────────────────────────────── ✓");

        }

    }
}