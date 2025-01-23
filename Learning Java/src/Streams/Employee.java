package Streams;
public class Employee implements Comparable<Employee> {
    int employeeID;
    String department;
    String name;
    double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    Employee(int empID, String dept, String name, double sal){
        this.employeeID = empID;
        this.department = dept;
        this.name = name;
        this.salary = sal;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }
}
