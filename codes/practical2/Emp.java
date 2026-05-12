package employee;

public class Emp {
    String name;
    int empId;
    String category;
    double basicPay;
    double HRA;
    double DA;
    double allowance;
    double providentFund;
    double grossPay;
    double incomeTax;
    double netPay;

    public Emp(String name, int empId, String category, double basicPay) {
        this.name = name;
        this.empId = empId;
        this.category = category;
        this.basicPay = basicPay;
    }

    public void calculateAllowances() {
        HRA = 0.20 * basicPay;
        DA = 0.10 * basicPay;
        allowance = 0.05 * basicPay;
    }

    public void calculateGrossPay() {
        grossPay = basicPay + HRA + DA + allowance;
    }

    public void calculatePF() {
        providentFund = 0.12 * basicPay;
    }

    public void calculateIncomeTax() {
        incomeTax = 0.10 * grossPay;
    }

    public void calculateNetPay() {
        netPay = grossPay - (providentFund + incomeTax);
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Category: " + category);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("HRA: " + HRA);
        System.out.println("DA: " + DA);
        System.out.println("Allowance: " + allowance);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("Provident Fund: " + providentFund);
        System.out.println("Income Tax: " + incomeTax);
        System.out.println("Net Pay: " + netPay);
    }
}