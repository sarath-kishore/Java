// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = PayrollSystem.getInstance();
        Employee engineer1 = new Employee("John", 1L, Designation.Engineer);
        Employee engineer2 = new Employee("Ben", 2L, Designation.Engineer);
        Employee engineer3 = new Employee("Paul", 3L, Designation.Engineer);
        Employee tl1 = new Employee("Kim", 4L, Designation.TeamLeader);
        Employee tl2 = new Employee("Stacy", 5L, Designation.TeamLeader);

        payrollSystem.addEmployee(engineer1);
        payrollSystem.addEmployee(engineer2);
        payrollSystem.addEmployee(engineer3);
        payrollSystem.addEmployee(tl1);
        payrollSystem.addEmployee(tl2);

        payrollSystem.markAttendance(engineer1, true);
        payrollSystem.markAttendance(engineer1, true);
        payrollSystem.markAttendance(engineer1, false);
        payrollSystem.markAttendance(engineer1, true);
        payrollSystem.markAttendance(engineer1, true);


        System.out.println(engineer1.getAttendanceCounter());

        payrollSystem.setPayoutStrategy(new WeeklyPayout());
        System.out.println(payrollSystem.computeSalary(engineer1));

        payrollSystem.setPayoutStrategy(new BiWeeklyPayout());
        System.out.println(payrollSystem.computeSalary(engineer1));

        payrollSystem.setPayoutStrategy(new MonthlyPayout());
        System.out.println(payrollSystem.computeSalary(engineer1));
    }
}