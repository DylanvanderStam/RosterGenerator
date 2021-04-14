package model;

import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<Employee> employees;

    public Company(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
        newUser();
    }

    public void newUser() {
        Employee emp = new Employee("Dylan", "van der Stam", "test", "0612345678", "test123");
        this.employees.add(emp);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
