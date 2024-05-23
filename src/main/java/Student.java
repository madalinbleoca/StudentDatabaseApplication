import java.util.*;

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

    // Enrol in courses plus value of tuition balance
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

        courses = enrolledCourses.toString();
    }

    //Balance and tuition payment
    public void viewBalance() {
        System.out.println("Your balance is: €" + tuitionBalance);
    }

    public void payTuition() {
        System.out.print("Enter your payment: €");
        Scanner scanner = new Scanner(System.in);
        try {
            int payment = scanner.nextInt();
            tuitionBalance -= payment;
            System.out.println("Thank you for your payment of €" + payment);
            viewBalance();
        }catch(NoSuchElementException elementException) {
            System.out.println("Invalid input. Please enter a valid payment.");
        }catch (IllegalStateException stateException) {
            System.out.println("Transaction is close.");
        }
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: €" + tuitionBalance;
    }
}

