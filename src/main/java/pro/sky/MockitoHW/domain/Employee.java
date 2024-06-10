package pro.sky.MockitoHW.domain;

public class Employee {
    private String fullNameOfWorker;
    private int department;
    private int salary;

    public Employee(String fullNameOfWorker, int department, int salary) {
        this.fullNameOfWorker = fullNameOfWorker;
        this.department = department;
        this.salary = salary;
    }

    public String getFullNameOfWorker() {
        return this.fullNameOfWorker;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return fullNameOfWorker + " " + department + " " + salary;
    }
}