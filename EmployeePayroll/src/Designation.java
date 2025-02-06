public enum Designation{

    TeamLeader(100000, 10, 10000, "team leader"),
    Engineer(50000, 5, 5000, "engineer");

    Designation(int s, int t, int d, String title){
        this.salary = s;
        this.taxPercentile = t;
        this.deductions = d;
        this.title = title;
    }

    public int getTaxPercentile() {
        return taxPercentile;
    }

    public int getDeductions() {
        return deductions;
    }

    public int getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }

    private int taxPercentile;
    private int deductions;
    private int salary;
    private String title;


}