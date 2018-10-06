package studentdbapp;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String classYear;
    private int studentID;
    private List<String> courses = new ArrayList<>();
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student's name and year
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter your last name: ");
        this.lastName = in.nextLine();
        System.out.print("Enter your class year (Freshman, Sophomore, Junior, Senior): ");
        this.classYear = in.nextLine();

        this.studentID = setStudentID();
    }

    // Generate an ID
    private int setStudentID(){
        id++;
        switch(classYear){
            case "Freshman":
                return 10000 + id;
            case "Sophomore":
                return 20000 + id;
            case "Junior":
                return 30000 + id;
            case "Senior":
                return 40000 + id;
            default:
                return id;
        }
    }

    // Enroll in courses
    public void enroll(){
        String course;
        do{
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            course = in.nextLine();
            if (!course.equals("Q")) {
                courses.add(course);
                tuitionBalance += costOfCourse;
            }
        }while(!course.equals("Q"));

        Iterator<String> itr = courses.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    // View Balance
    public int getTuitionBalance(){
        return tuitionBalance;
    }

    // Pay Tuition
    public void payTuition(){
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment! Current Tuition Balance is $" + tuitionBalance);
    }

    // Show Status
    @Override
    public String toString(){
        return "Name: " + firstName + " " +  lastName + "\n" +
                "Class Year: " + classYear + "\n" +
                "Student ID: " + studentID + "\n" +
                "Tuition Balance: " + tuitionBalance + "\n" +
                "Courses: " + courses.toString();
    }
}
