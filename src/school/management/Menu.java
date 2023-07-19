package school.management;

import java.util.List;
import java.util.Scanner;

public class Menu {


    public static void welcomeScreen() {
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1. Add Student\t\t\t\t\t6. Add Teacher\t\t\t\t\t 9.Add class");
        System.out.println("2. Update Student\t\t\t\t7. Update Teacher\t\t\t\t 10.Update class");
        System.out.println("3. Remove Student\t\t\t\t8. Remove Teacher\t\t\t\t 11.Remove class");
        System.out.println("4. View Students\t\t\t\t9. View Teachers\t\t\t\t 12.View Class");
        System.out.println("5. Pay Fees\t\t\t\t\t\t10. Pay Salaries\t\t\t\t");
        System.out.println();
        System.out.println("13. Add Students to Class\t\t15.Change School Name");
        System.out.println("14. Get All Average Grade\t\t\t\t\t");
        System.out.print("\nYour Selection: ");
    }

    public static void menuPromptOne(Scanner scanner, School college, List<Student> studentList) {
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter grade: ");
        int grade = scanner.nextInt();
        studentList.add(new Student(name, grade));
        System.out.println("Student successfully added. Student count: " + college.getStudentListSize());
    }

    public static void menuPromptSix(Scanner scanner, School college, List<Teacher> teacherList) {
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter salary: ");
        int salary = scanner.nextInt();
        teacherList.add(new Teacher(name, salary));
        System.out.println("Student successfully added. Teacher count: " + college.getAllTeachers(teacherList));
    }

/*    public static void menuPromptNine(Scanner scanner, School college, List<Classroom> classroomList, Teacher teacher, List<Student> studentList, int size, String className) {
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter salary: ");
        int salary = scanner.nextInt();
        classroomList.add(new Classroom(teacher, studentList, size, className));
        System.out.println("Student successfully added. Teacher count: " + college.getAllClasses(classroomList));
    }*/


    public static void menuPromptEight(List<Teacher> teacherList, School college) {
        System.out.println("All Teacher: " + college.getAllTeachers(teacherList));
    }

    public static void menuPromptThree(Scanner scanner, List<Student> studentList, School college) {
        System.out.println("Enter ID to remove: ");
        System.out.println(college.getAllStudents(studentList));
        int id0 = scanner.nextInt();
        college.removeStudentById(id0);

        System.out.println("Student successfully removed. Student count: " + college.getStudentListSize());
    }

    public static void menuPromptEleven(Scanner scanner, List<Classroom> classroomList, School college) {
        System.out.println("Enter ID to remove: ");
        System.out.println(college.getAllClasses(classroomList));
        int id0 = scanner.nextInt();
        college.removeClassById(id0);

        System.out.println("Student successfully removed. Student count: " + college.getAllClasses(classroomList));
    }

    public static void menuPromptTwelve(School college, List<Classroom> classList) {
        System.out.println("All Classes: " + college.getAllClasses(classList));
    }

    public static void menuPromptNine(School college, List<Teacher> teacherList) {
        System.out.println("All Classes: " + college.getAllTeachers(teacherList));
    }

    public static void menuPromptFour(School college, List<Student> studentList) {
        System.out.println("All Students: " + college.getAllStudents(studentList));
    }

    public static void menuPromptFive(School college, List<Student> studentList, Scanner scanner) {
        System.out.println("Find your username name here: " + college.getAllStudents(studentList));
        System.out.print("Enter username to login: ");
        String username = scanner.next();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(username)) {
                System.out.print("Enter password to login: ");
                String password = scanner.next();
                if (password.equals("123")) {
                    System.out.print("Please enter fee amount: ");
                    int fee = scanner.nextInt();
                    studentList.get(i).payfees(fee);
                    System.out.print("Fee is paid! Total Fees Paid: " + studentList.get(i).getFeesPaid());
                }
            }
        }
    }
}

