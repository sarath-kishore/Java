public class WeeklyPayout implements IPayoutStrategy{

    private int workingDays;
    private int paidLeaves;

    WeeklyPayout(){
        this.workingDays = 5;
        this.paidLeaves = 2;
    }

    public PayoutRecord calculatePayout(Employee employee){
        // apply formula
        int totalPayout = employee.getDesignation().getSalary();
        int totalLeaves = workingDays - employee.getAttendanceCounter();
        int lossOfPay =  0;

        if(totalLeaves > paidLeaves)
            lossOfPay = (totalLeaves - paidLeaves) * (totalPayout / workingDays);


        totalPayout -= lossOfPay;
        totalPayout -= employee.getDesignation().getDeductions();

        int totalTax = (totalPayout * employee.getDesignation().getTaxPercentile())/100;

        totalPayout -= totalTax;

        return new PayoutRecord( employee.getName(), employee.getDesignation().getTitle(), totalLeaves, lossOfPay, totalTax, employee.getDesignation().getDeductions(), employee.getDesignation().getSalary(), totalPayout);
    }

}