class Employee {
    String name;
    String dob;
    int id;

    Employee(String name, String dob, int id) {
        this.name = name;
        this.dob = dob;
        this.id = id;
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Employee ID: " + id);
    }
}

class Manager extends Employee {
    double salary;

    Manager(String name, String dob, int id, double salary) {
        super(name, dob, id);
        this.salary = salary;
    }

    void display() {
        super.display();
        System.out.println("Salary: " + salary);
    }
}

class SalesManager extends Manager {
    double commission;

    SalesManager(String name, String dob, int id, double salary, double commission) {
        super(name, dob, id, salary);
        this.commission = commission;
    }

    void display() {
        super.display();
        System.out.println("Commission: " + commission);
    }
}

class Main {
    public static void main(String[] args) {
        Employee e = new Employee("Ravi", "01-01-2000", 101);
        System.out.println("----- Employee Details -----");
        e.display();
        Manager m = new Manager("Amit", "02-02-1995", 102, 50000);
        System.out.println("\n----- Manager Details -----");
        m.display();
        SalesManager sm = new SalesManager("Neha", "03-03-1992", 103, 60000, 10000);
        System.out.println("\n----- Sales Manager Details -----");
        sm.display();
    }
}   