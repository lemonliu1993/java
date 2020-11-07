package com.lemon.java8.test;

/**
 * Created by lemoon on 2020/11/7 10:59 AM
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
