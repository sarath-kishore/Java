public class MonthlyPayout implements IPayoutStrategy{
    private int workingDays;
    private int paidLeaves;

    MonthlyPayout(){
        this.workingDays = 20;
        this.paidLeaves = 4;
    }

    public PayoutRecord calculatePayout(Employee employee){
        // apply formula
        int totalPayout = employee.getDesignation().getSalary();
        int totalLeaves = workingDays - employee.getAttendanceCounter();
        int lossOfPay =  0;
        System.out.println("totalLeaves: " + totalLeaves);
        if(totalLeaves > paidLeaves)
            lossOfPay = (totalLeaves - paidLeaves) * (totalPayout / workingDays);


        totalPayout -= lossOfPay;
        totalPayout -= employee.getDesignation().getDeductions();

        int totalTax = (totalPayout * employee.getDesignation().getTaxPercentile())/100;

        totalPayout -= totalTax;

        return new PayoutRecord( employee.getName(), employee.getDesignation().getTitle(), totalLeaves, lossOfPay, totalTax, employee.getDesignation().getDeductions(), employee.getDesignation().getSalary(), totalPayout);
    }
}