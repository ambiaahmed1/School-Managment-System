package school.management;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Classroom {

    public int id;
    public String className;
    public int roomNumber;
    private Teacher teacher;
    private List<Student> studentList;
    private int size;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);



    public Classroom(Teacher teacher, List<Student> studentList, int size, String className) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.teacher = teacher;
        this.studentList = studentList;
        this.size = size;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getStudentSize() {
        return studentList.size();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public void addStudents(List<Student> studentList) {
        if (size >= 20) {
            System.out.println("Class does not have any room...");
        } else {
            // studentList.add()
        }

    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", roomNumber=" + roomNumber +
                ", teacher=" + teacher +
                ", studentList=" + studentList +
                ", size=" + size +
                '}';
    }


}
