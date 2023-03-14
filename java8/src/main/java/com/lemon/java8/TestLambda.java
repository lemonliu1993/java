package com.lemon.java8;

import com.lemon.java8.entity.Employee;
import org.junit.Test;

import java.util.*;

/**
 * Created by lemoon on 2023/3/11 23:56
 */
public class TestLambda {
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<Integer>(com);
    }

    //Lambda 表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 20L, 10000.0),
            new Employee("李四", 31L, 13000.0),
            new Employee("王五", 42L, 15000.0),
            new Employee("赵六", 53L, 17000.0),
            new Employee("田七", 64L, 10000.0)
    );

    //需求：获取当前公司中员工年龄大于35的员工信息
    @Test
    public void test3() {
        List<Employee> employees = filterEmployees(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //优化方式一：策略设计模式
    @Test
    public void test4() {
        List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }


}
