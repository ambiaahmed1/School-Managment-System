package school.management;

import java.util.concurrent.atomic.AtomicInteger;

public class Teacher {


    int id;
    String name;
    int salary;
    int salaryEarned;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);


    public int getSalaryEarned() {
        return salaryEarned;
    }

    public void setSalaryEarned(int salaryEarned) {
        this.salaryEarned += salaryEarned;
    }

    public int getId() {
        return id;
    }

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Teacher(String name, int salary) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.salary = salary;
    }

    public void receiveSalary(int salary) {
        this.salaryEarned += salary;
        School.updateTotalMoneySpent(salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", salaryEarned=" + salaryEarned +
                '}';
    }
}
