import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses;
    private int tuitionBalance;
    private final int costOfCourse = 500;

    private static final int MIN_ID = 1000;
    private static final int MAX_ID = 9999;
    private static final Random random = new Random();
    private static final Set<Integer> generatedIDs = new HashSet<>();

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - Entry Level\n2 - Junior\n3 - Mid Level\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();

        System.out.println(firstName + " " + lastName + " " + gradeYear +" " + studentID);
    }

    //Generate an Unique ID for Student
    private void setStudentID() {
        this.studentID = generateUniqueID();
    }

    private static String generateUniqueID() {
        int newID;
        do {
            newID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        } while (generatedIDs.contains(newID));
        generatedIDs.add(newID);

        return String.valueOf(newID);
    }

    // Enrol in courses
    public void enroll(){}

}

