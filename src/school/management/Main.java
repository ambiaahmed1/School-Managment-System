package school.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Teacher t1 = new Teacher("Lizzy", 500);
        Teacher t2 = new Teacher("Mellisa", 700);
        Teacher t3 = new Teacher("Vanderhorn", 600);
        Teacher t4 = new Teacher("Jay", 600);

        Student s1 = new Student("Tamasha", 80);
        Student s2 = new Student("Sally", 90);
        Student s3 = new Student("Dan", 98);

        Student mathStudent1 = new Student("Sam", 80);
        Student mathStudent2 = new Student("Rone", 90);

        List<Student> studentList = new ArrayList<>();
        List<Student> mathStudentList = new ArrayList<>();

        mathStudentList.add(mathStudent1);
        mathStudentList.add(mathStudent2);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        List<Teacher> teacherList = new ArrayList<>();

        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);
        teacherList.add(t4);

        //create school
        School college = new School(teacherList, studentList, "Evergreen Technical School");

        Classroom mathClass = new Classroom(t1, mathStudentList, 20, "Math");
        Classroom englishClass = new Classroom(t1, studentList, 20, "English");
        Classroom scienceClass = new Classroom(t1, studentList, 20, "Science");


        englishClass.addStudent(s3);

        List<Classroom> classList = new ArrayList<Classroom>();
        classList.add(mathClass);
        classList.add(englishClass);
        classList.add(scienceClass);

        s1.payfees(5000);
        s2.payfees(10000);

        t1.receiveSalary(20000);
        System.out.println(college.getAllStudents(studentList));

        //college.addStudents(studentList);
        System.out.println("this is the student size" + college.getStudentListSize(studentList));

        //college.addStudentToClass(mathClass.getId(), mathStudent1);
        System.out.println("Size ==============>" + mathClass.getStudentSize());
        college.addTeacher(new Teacher("Dan", 7000));

        college.addStudent(new Student("Toby", 65));

        System.out.println("all students" + college.getAllStudentName(studentList) + "end all students");

        System.out.println("====================Simple School Simulation====================");
        //System.out.println(college.toString());
        System.out.println("Welcome to " + college.getSchoolName());
        System.out.println("Total Students: " + college.getStudentListSize(studentList));
        System.out.println("Total Teachers: " + college.getTeacherListSize(teacherList));
        System.out.println("Total Classes: " + college.getCLassSize(classList));
        System.out.println("Total Class Names: " + college.getClassNames(classList));

        System.out.println("Total Revenue: " + college.getTotalMoneyEarned());


        System.out.println("==============================School Simulation==============================");
        // System.out.println(studentList.toString());

        //Scenario 1 : Add 3 Student and 3 Teacher
        //Scenario 2: Remove 1 Student and 1 Teacher
        //Scenario 3: Update 1 Student


        //Scenario 2 : Student 1 pays 5000 to the school
        //             Student 2 pays 10000 to the school
        //The school should have 15000 total money earned.
        //Scenario 3: Teacher 1 receives salary 500.
        //            Teacher 2 receives salary 500.
        //            Teacher 3 receives salary 500.
        //The school should now have 15000-1500 = 13500.

        college.updateStudentById(s1.getId(), "new Name123", 10);
        college.updateClassById(classList, englishClass.getId(), t1, studentList, 20, "Java");

       // System.out.println(college.getClassList());
       // System.out.println(college.getStudentList());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("1. Add Student\t\t\t\t\t5. Add Teacher\t\t\t\t\t 9.Add class");
            System.out.println("2. Update Student\t\t\t\t6. Update Teacher\t\t\t\t 10.Update class");
            System.out.println("3. Remove Student\t\t\t\t7. Remove Teacher\t\t\t\t 11.Remove class");
            System.out.println("4. View Students\t\t\t\t8. View Teachers\t\t\t\t 12.View Class");



            System.out.println();
            System.out.println("13. Add Students to Class\t\t15.Change School Name");
            System.out.println("14. Get All Average Grade\t\t\t\t\t");


            System.out.print("\nYour Selection: ");
            int selection = scanner.nextInt();


            switch (selection) {
                case 1:
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    System.out.println("Enter grade: ");
                    int grade = scanner.nextInt();
                    studentList.add(new Student(name, grade));

                    System.out.println("Student successfully added. Student count: " + college.getStudentListSize());
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Enter ID to remove: ");
                    System.out.println(college.getAllStudents(studentList));
                    int id0 = scanner.nextInt();
                    college.removeStudentById(id0);

                    System.out.println("Student successfully removed. Student count: " + college.getStudentListSize());
                    break;

                case 4:
                    System.out.println("All Students: " + college.getAllStudents(studentList));
                    break;
                   /* System.out.println("Enter name: ");
                    String name1 = scanner.next();
                    System.out.println("Enter salary: ");
                    int salary = scanner.nextInt();
                    teacherList.add(new Teacher(name1, salary));
                    System.out.println("Teacher successfully added. Teacher count: " + college.getTeacherListSize());
                    break;*/
                case 5:

                    break;
                case 6:
                    System.out.println("All Teacher: " + college.getAllTeachers(teacherList));
                    break;
                case 7:
                    System.out.println("Enter Id to remove");
                    System.out.println(college.getAllTeachers(teacherList));
                    int id2 = scanner.nextInt();
                    college.removeTeacherById(id2);
                    System.out.println("Student successfully removed. Teacher count: " + college.getTeacherListSize());
                    break;
                case 8:
                    System.out.println("All Teacher: " + college.getAllTeachers(teacherList));
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 12:
                    System.out.println("All Classes: " + college.getAllClasses(classList));
                    break;
                case 11:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }
}
