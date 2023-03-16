package com.github.fadeciness.lesson8.homework.employee;

public class Employee {
    private final String name;
    private final int age;
    private final int salary;

    public Employee(String name, int age, int salary) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be not-positive");
        }
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary cannot be not-positive");
        }
        this.name = name.trim();
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
