package com.lemon.java8.lambda;

import com.lemon.java8.entity.Employee;
import com.lemon.java8.lambda.MyPredicate;

/**
 * Created by lemoon on 2023/3/14 23:36
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
