package studentdbapp;
import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args){
        // Ask how many new students we want to add
        System.out.print("Enter number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int studentNumbers =  in.nextInt();
        Student[] students = new Student[studentNumbers];

        // Create a number of new students
        for(int i = 0; i < studentNumbers; i++){
            Student stu = new Student();
            stu.enroll();
            students[i] = stu;
        }

        for(int j = 0; j < studentNumbers; j++){
            System.out.print(students[j].toString());
        }
    }
}
