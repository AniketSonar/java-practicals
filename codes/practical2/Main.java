import employee.Emp;

class Main {
    public static void main(String[] args) {
        Emp e1 = new Emp("Ravi", 101, "A", 50000);
        e1.calculateAllowances();
        e1.calculateGrossPay();
        e1.calculatePF();
        e1.calculateIncomeTax();
        e1.calculateNetPay();
        e1.display();
    }
}