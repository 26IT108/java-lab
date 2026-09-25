public class Driver {

    public static void main(String[] args) {

        Employee[] employees = {
                new FullTime("Rahul", 101, 50000),
                new PartTime("Priya", 102, 80, 250),
                new Intern("Amit", 103, 12000)
        };

        double total = 0;

        for (Employee e : employees) {

            System.out.println(e.name + " Salary = " + e.monthlySalary());

            total += e.monthlySalary();

            if (e instanceof Intern) {
                System.out.println("Note: This employee is an Intern.");
            }
        }

        System.out.println("Total Salary = " + total);
    }
}