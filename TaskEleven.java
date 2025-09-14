import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class TaskEleven {

    private String name;
    private double salary;
    private List<Employee> subordinates;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee e) {
        subordinates.add(e);
    }

    public double getSalary() {
        return salary;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String getName() {
        return name;
    }
}

class Organization {

    /**
     * TO-DO: Convert this iterative method into a recursive one.
     * \*
     * This method calculates the total salary of a manager and all their subordinates.
     * The current implementation uses a Stack to perform a depth-first traversal of the hierarchy.
     * \*
     *
     * @param manager The root employee of the hierarchy to sum up.
     * @return The total salary.
     */

    public double calculateTotalSalary(Employee manager) {
        return manager.getSalary() + sumSalariesOfList(manager.getSubordinates());
    }

    private double sumSalariesOfList(List<Employee> employees) {

        if (employees.isEmpty()) {
            return 0;
        }

        return calculateTotalSalary(employees.getFirst()) + sumSalariesOfList(employees.subList(1, employees.size()));
    }

    public static void main(String[] args) {
        // Create employees
        Employee manager = new Employee("Alice", 100);
        Employee emp1 = new Employee("Bob", 3);
        Employee emp2 = new Employee("Charlie", 2);
        Employee emp3 = new Employee("Diana", 1);
        Employee emp4 = new Employee("Diana", 7);
        Employee emp5 = new Employee("Diana", 1000);

        // Build hierarchy
        manager.addSubordinate(emp1);
        manager.addSubordinate(emp2);
        emp2.addSubordinate(emp3);
        emp3.addSubordinate(emp4);
        emp3.addSubordinate(emp5);
        // Calculate total salary
        Organization org = new Organization();
        double total = org.calculateTotalSalary(manager);
        System.out.println("Total salary for Alice and her team: " + total);
    }
}
