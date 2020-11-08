package com.lemon.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lemoon on 2020/11/7 5:01 PM
 */
public class Test {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    public void test1() {
        Collections.sort(employees, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        });
    }
}
