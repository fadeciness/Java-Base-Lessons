package com.github.fadeciness.lesson8.homework;

import com.github.fadeciness.lesson8.homework.employee.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OldestEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Иван", 25, 10_000),
                new Employee("Владимир", 26, 11_000),
                new Employee("Сергей", 27, 12_000),
                new Employee("Владимир", 28, 13_000),
                new Employee("Петр", 29, 14_000),
                new Employee("Дмитрий", 30, 15_000),
                new Employee("Валерий", 31, 16_000),
                new Employee("Юрий", 32, 17_000),
                new Employee("Константин", 33, 18_000),
                new Employee("Михаил", 34, 19_000),
                new Employee("Максим", 35, 20_000)
        );

        int oldestEmployeeLimit = 3;

        String message = employees.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .skip(employees.size() - oldestEmployeeLimit)
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "N самых старших сотрудников зовут: ", ";"));
        System.out.println(message);
    }
}
