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
            Menu.welcomeScreen();

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    Menu.menuPromptOne(scanner, college, studentList);
                    break;
                case 2:
                    Menu.menuPrompTwo(scanner, college, studentList);
                    break;
                case 3:
                    Menu.menuPromptThree(scanner, studentList, college);

                    break;

                case 4:
                    Menu.menuPromptFour(college, studentList);
                    break;
                case 5:
                    Menu.menuPromptFive(college, studentList, scanner);
                    //Send student list
                    //Select student
                    //Login username/password
                    //Pay fees

                    break;
                case 6:
                    Menu.menuPromptSix(scanner, college, teacherList);
                    break;
                case 7:
                    Menu.menuPrompSeven(scanner, college, teacherList);
                    break;
                case 8:
                    Menu.menuPromptEight(teacherList, college);

                    break;
                case 9:
                    //Menu.menuPromptNine(college, teacherList);
                    Menu.menuPromptNine1(scanner, college, classList, teacherList, studentList);
                    break;
                case 10:
                    Menu.menuPromptTen(college, teacherList, scanner);

                    break;
                case 12:
                    Menu.menuPromptTwelve(college, classList);
                    break;
                case 11:
                    Menu.menuPromptEleven(scanner, classList, college);
                    break;

                case 17:
                    Menu.allSchoolData(college, classList, studentList, teacherList);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }
}
