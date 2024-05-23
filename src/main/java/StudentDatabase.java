
public class StudentDatabase {
    public static void main(String[] args) {
        System.out.println("Welcome again!");

        Student student_1 = new Student();
        student_1.enroll();
        student_1.payTuition();

        System.out.println("——————————————————————————————————————————————————————");
        System.out.println(student_1.toString());

    }
}
