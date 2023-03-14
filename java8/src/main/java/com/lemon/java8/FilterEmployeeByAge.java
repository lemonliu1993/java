package com.lemon.java8;

import com.lemon.java8.entity.Employee;

/**
 * Created by lemoon on 2023/3/14 23:36
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
