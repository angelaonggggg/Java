import java.util.*;

// enum
enum Subject {
    English, Mathematics, Science
}

enum SchoolGrade {
    D, P, F
}

enum Gender {
    Male, Female
}

class Result {
    // Get the average marks
    private static double getAverage(double m1, double m2) {
        return (m1 + m2) / 2.0;
    }

    // Get final marks
    private static int getFinalMark(double m1, double m2) {
        double average = getAverage(m1, m2);
        return (int) Math.round(average);
    }

    // Evaluates and returns the grade of a subject
    private static SchoolGrade getAGrade(int mark) {
        if (mark >= 75)
            return SchoolGrade.D;
        else if (mark >= 50)
            return SchoolGrade.P;
        else
            return SchoolGrade.F;
    }

    // Display Message
    private static void displayMessage(SchoolGrade grade) {
        switch (grade) {
            case D:
                System.out.println("Not bad");
                break;
            case P:
                System.out.println("You passed");
                break;
            default:
                System.out.println("Keep it up for better grade");
        }
    }

    // Get a subject
    private static Subject getASubject() {
        int k = (int) (Math.random() * 3);
        switch (k) {
            case 0:
                return Subject.English;
            case 1:
                return Subject.Mathematics;
            default:
                return Subject.Science;
        }
    }

    // Get a gender
    private static Gender getAGender() {
        int k = (int) (Math.random() * 2);
        if (k == 0)
            return Gender.Male;
        else
            return Gender.Female;
    }

    public static void main(String[] args) {
        // Variables
        String name;
        Gender gender;
        int age;
        Subject subject1, subject2;
        double mark1, mark2;

        // Loop 3 times for 3 students
        for (int k = 1; k <= 3; k++) {
            name = "Student" + k;
            gender = getAGender();
            subject1 = getASubject();
            // Do-while loop to check that the 2 subjects are not the same
            do {
                subject2 = getASubject();
            } while (subject1 == subject2);

            // Generate marks for the subjects
            mark1 = Math.random() * 100.0;
            mark2 = Math.random() * 100.0;

            // Age min 15, max 30
            age = (int) (Math.random() * 16 + 15);
            double average = getAverage(mark1, mark2);
            int finalMark = getFinalMark(mark1, mark2);
            SchoolGrade grade = getAGrade(finalMark);

            // Display the result
            System.out.printf("\nName: %s%n", name);
            System.out.printf("Gender: %s%n", gender);
            System.out.printf("Age: %d%n", age);
            System.out.printf("Subject1: %s, Mark: %.1f%n", subject1, mark1);
            System.out.printf("Subject2: %s, Mark: %.1f%n", subject2, mark2);
            System.out.printf("Average: %.1f%n", average);
            System.out.printf("Final Mark: %d%n", finalMark);
            System.out.printf("Grade: %s%n", grade);
            displayMessage(grade);
        }
    }
}
