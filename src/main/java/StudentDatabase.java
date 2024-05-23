import java.util.Scanner;

public class StudentDatabase {
    public static void main(String[] args) {
        System.out.println("Welcome again!");
        System.out.print("Enter number of new students to enroll: ");
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = scanner.nextInt();
        Student[] students = new Student[numOfStudents];

        for (int n = 0; n < numOfStudents; n++) {
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
            System.out.println("——————————————————————————————————————————————————————");
            System.out.println(students[n].toString());
        }
    }
}
