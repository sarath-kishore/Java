public class PayoutRecord {

    @Override
    public String toString() {
        return "PayoutRecord{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", leaveCount=" + leaveCount +
                ", lossOfPay=" + lossOfPay +
                ", taxAmount=" + taxAmount +
                ", deductions=" + deductions +
                ", grossSalary=" + grossSalary +
                ", netSalary=" + netSalary +
                '}';
    }

    String name, title;
    int leaveCount;

    public PayoutRecord(String name, String title, int leaveCount, int lossOfPay, int taxAmount, int deductions, int grossSalary, int netSalary) {
        this.name = name;
        this.title = title;
        this.leaveCount = leaveCount;
        this.lossOfPay = lossOfPay;
        this.taxAmount = taxAmount;
        this.deductions = deductions;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
    }

    int lossOfPay;

    public int taxAmount;
    public int deductions;
    public int grossSalary;
    public int netSalary;

}
