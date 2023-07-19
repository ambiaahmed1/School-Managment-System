package school.management;

import java.util.ArrayList;
import java.util.List;

public class School {

    private Student student;
    private Teacher teacher;
    private Classroom classroom;
    private static int totalMoneyEarned;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    private String schoolName;

    public static int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public static void setTotalMoneySpent(int totalMoneySpent) {
        School.totalMoneySpent = totalMoneySpent;
    }

    public int getStudentNoInClass(List<Student> studentList) {
        return studentList.size();
    }

    private static int totalMoneySpent;
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Classroom> classList;

    public List<Classroom> getClassList() {
        return classList;
    }

    public void setClassList(List<Classroom> classList) {
        this.classList = classList;
    }

    public int getCLassSize(List<Classroom> classList) {
        return classList.size();
    }

    public ArrayList<String> getClassNames(List<Classroom> classList) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Classroom classroom : classList) {
            arrayList.add(classroom.getClassName());
        }
        return arrayList;

    }

    public School(List<Teacher> teacherList, List<Student> studentList, String schoolName) {
        this.teacherList = teacherList;
        this.studentList = studentList;
        this.schoolName = schoolName;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public static int updateTotalMoneyEarned(int totalMoneyEarned) {
        School.totalMoneyEarned += totalMoneyEarned;
        return totalMoneyEarned;
    }

/*    public Classroom createClassroom(Teacher teacher, List<Student>List<Student> studentList) {
        return new Classroom(teacher, this.studentList);
    }*/

    public static int updateTotalMoneySpent(int totalMoneySpent) {
        if (totalMoneyEarned < totalMoneySpent) {
            System.out.println("Not enough funds..");
        } else {
            School.totalMoneyEarned -= totalMoneySpent;
            School.totalMoneySpent += totalMoneySpent;
        }

        return totalMoneyEarned;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public int getTeacherCount() {
        return teacherList.size();
    }

    public int getStudentCount() {
        return studentList.size();
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teacherList.remove(teacher);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public void removeStudentById(int id) {
        studentList.removeIf(student -> student.getId() == id);
    }

    public void updateStudentById(int id, String name, int grade) {
        studentList.removeIf(student -> student.getId() == id);
        studentList.add(new Student(name, grade));
    }
/*

    public void addStudentToClass(int id, Student student) {
        classList.stream().filter(classroom -> classroom.getId() == id);
        classList.add(student);
    }
*/

    public void updateClassById(List<Classroom> classList, int id, Teacher teacher, List<Student> studentList, int size, String courseName) {
        classList.removeIf(classroom -> classroom.getId() == id);
        classList.add(new Classroom(teacher, studentList, size, courseName));
    }

    public int getGradeAverage(List<Student> studentList) {
        int totalGrade = 0;
        for (int i = 0; i < studentList.size(); i++) {
            totalGrade += studentList.get(i).getGrade();
        }
        return totalGrade / studentList.size();

    }

    public void addTeacherById(int id) {
        teacherList.removeIf(teacher -> teacher.getId() == id);
    }

    public void removeTeacherById(int id) {
        teacherList.removeIf(teacher -> teacher.getId() == id);
    }

    public void removeTeacherByName(String name) {
        teacherList.removeIf(teacher -> teacher.getName() == name);
    }

/*    public void addStudents(List<Student> studentList) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add((Student) studentList);
    }*/

    public List<Student> getAllStudents(List<Student> studentList) {
        ArrayList<Student> arrayList = new ArrayList<Student>();
        for (Student student : studentList) {
            arrayList.add(student);
        }
        return arrayList;
    }

    public List<Teacher> getAllTeachers(List<Teacher> teacherList) {
        ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
        for (Teacher teacher : teacherList) {
            arrayList.add(teacher);
        }
        return arrayList;
    }

    public List<Classroom> getAllClasses(List<Classroom> classList) {
        ArrayList<Classroom> arrayList = new ArrayList<Classroom>();
        for (Classroom classroom : classList) {
            arrayList.add(classroom);
        }
        return arrayList;
    }

    public List<String> getAllStudentName(List<Student> studentList) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Student student : studentList) {
            arrayList.add(student.getName());
        }
        return arrayList;
    }


    public int getStudentListSize(List<Student> studentList) {
        return studentList.size();
    }

    public int getStudentListSize() {
        return studentList.size();
    }

    public int getTeacherListSize() {
        return studentList.size();
    }


    public int getTeacherListSize(List<Teacher> teacherList) {
        return teacherList.size();
    }


    public void addStudent(Student student) {
        studentList.add(student);
    }

    public String toString() {
        return "Total Money Earned " + getTotalMoneyEarned() + "\nTotal Teachers: " + getTeacherCount()
                + "\nTotal Students: " + getStudentCount() + "\nTotal Salary Spent: " + getTotalMoneySpent() + "\n";
    }
}
