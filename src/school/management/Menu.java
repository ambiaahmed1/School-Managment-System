package school.management;

import java.sql.SQLOutput;
import java.util.ArrayList;
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
        System.out.println("13. Add Students to Class\t\t17.Change School Name");
        System.out.println("14. Get All Average Grade\t\t\t\t\t");
        System.out.println("15. School Earnings Report\t\t\t\t\t");
        System.out.println("16. School Expense Report\t\t\t\t\t");
        System.out.println("17. All School Data\t\t\t\t\t");
        System.out.print("\nYour Selection: ");
    }

    public static void menuPromptOne(Scanner scanner, School college, List<Student> studentList) {
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

        public static void menuPromptNine1(Scanner scanner, School college, List<Classroom> classroomList, List<Teacher> teacherList, List<Student> studentList) {
        //create a new class what do you need?
        //Assign a teacher
        //Assign a list of students
        //Classroom size
        //Classroom or subject name
        System.out.println("Enter class room name: ");
        String name = scanner.next();
        System.out.println("Enter class room size: ");
        int size = scanner.nextInt();
        System.out.println("Assign students to class by ids: " + college.getAllStudents(studentList));
        List<Student> studentlist1 = new ArrayList<Student>();
        for(int i =0; i<size; i++) {
            System.out.println("Enter student ids to assign to class " + name);
            int ids = scanner.nextInt();
            if(studentList.get(i).getId() == ids) {
                studentlist1.add(studentList.get(i));
            }
        }
        System.out.println("Assign teacher to class by id: " + college.getAllTeachers(teacherList));
        int teacherId = scanner.nextInt();
        for(int i=0; i<teacherList.size(); i++) {
            if(teacherList.get(i).getId() ==teacherId) {
                classroomList.add(new Classroom(teacherList.get(i),studentlist1, size, name));
                break;
            }
        }
        System.out.println("Class is created: " + college.getAllClasses(classroomList));
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

    public static void allSchoolData(School college, List<Classroom> classroomList, List<Student> studentList, List<Teacher> teacherList) {
        System.out.println(college.getSchoolName());
        System.out.println(college.getAllClasses(classroomList));
        System.out.println(college.getAllTeachers(teacherList));
        System.out.println(college.getAllStudents(studentList));
        System.out.println(college.toString());
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

    public static void menuPromptTen (School college, List<Teacher> teacherList, Scanner scanner) {
        System.out.println("Find your teacher name here: " + college.getAllTeachers(teacherList));
        System.out.print("Enter your name to login: ");
        String username = scanner.next();
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().equals(username)) {
                System.out.print("Enter password to login: ");
                String password = scanner.next();
                if (password.equals("123")) {
                    System.out.print("Pay this teacher salary: ");
                    int salary = scanner.nextInt();
                    teacherList.get(i).receiveSalary(salary);
                    System.out.print("Salary is paid! Total Salary Earned: " + teacherList.get(i).getSalaryEarned());
                }
            }
        }
    }


    public static void menuPrompTwo(Scanner scanner, School college, List<Student> studentList) {
        System.out.println("Existing students: " + college.getAllStudents(studentList));
        System.out.println("Enter Student ID: ");
        int id =  scanner.nextInt();
        System.out.println("Enter Student Name: ");
        String name =  scanner.next();
        System.out.println("Enter Student Grade: ");
        int grade =  scanner.nextInt();
        college.updateStudentById(id, name, grade);

        System.out.println("Student successfully updated! " + college.getAllStudents(studentList));
    }

    public static void menuPrompSeven(Scanner scanner, School college, List<Teacher> teacherList) {
        System.out.println("Existing students: " + college.getAllTeachers(teacherList));
        System.out.println("Enter Teacher ID: ");
        int id =  scanner.nextInt();
        System.out.println("Enter Teacher Name: ");
        String name =  scanner.next();
        System.out.println("Enter Teacher Salary: ");
        int salary =  scanner.nextInt();
        college.updateTeacherById(id, name, salary);

        System.out.println("Student successfully updated! " + college.getAllTeachers(teacherList));
    }
}

