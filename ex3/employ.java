//3
class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

class Programmer extends Employee {
    private int linesOfCode;

    public Programmer(String name, double baseSalary, int linesOfCode) {
        super(name, baseSalary);
        this.linesOfCode = linesOfCode;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + linesOfCode * 0.01;
    }
}

public class employ {
    public static void main(String[] args) {
        Employee employee = new Employee("Kabil", 20000);
        Manager manager = new Manager("Thiru", 30000, 5000);
        Programmer programmer = new Programmer("Karthi", 29000, 3000);

        System.out.println("Employee's Salary: " + employee.calculateSalary());
        System.out.println("Manager's Salary: " + manager.calculateSalary());
        System.out.println("Programmer's Salary: " + programmer.calculateSalary());
    }
}

