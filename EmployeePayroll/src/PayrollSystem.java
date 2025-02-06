import java.util.*;

public class PayrollSystem{
    private static PayrollSystem instance;
    public IPayoutStrategy payoutStrategy;

    List<Employee> employeeList = new ArrayList<>();


    private PayrollSystem(){
    }

    public void setPayoutStrategy(IPayoutStrategy strategy){
        this.payoutStrategy = strategy;
    }


    public void addEmployee(Employee emp){
        employeeList.add(emp);
    }

    public boolean removeEmployee(Employee emp){
        employeeList.remove(emp);
        return true;
    }


    public void markAttendance(Employee emp, boolean isPresent){
        if(isPresent)
            emp.setAttendanceCounter(1);
    }


    public PayoutRecord computeSalary(Employee emp){
        return payoutStrategy.calculatePayout(emp);
    }



    public static PayrollSystem getInstance(){
        if(instance == null){
            synchronized(PayrollSystem.class){
                if(instance == null)
                    instance = new PayrollSystem();
            }
        }

        return instance;
    }
}