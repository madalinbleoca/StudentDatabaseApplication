import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
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
    public void enroll() {
        StringBuilder enrolledCourses = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter course to enroll. Press Q to quit: ");
            String course = scanner.nextLine();

            if (course.equalsIgnoreCase("Q")) {
                break;
            }

            if (!enrolledCourses.isEmpty()) {
                enrolledCourses.append(", ");
            }
            enrolledCourses.append(course);
            tuitionBalance += costOfCourse;
        }
        scanner.close();

        courses = enrolledCourses.toString();

        System.out.println("ENROLLED IN: " + courses);
        System.out.println("TUITION BALANCE: " + tuitionBalance);
    }

}

