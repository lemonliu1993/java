package com.lemon.java8.lambda;

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

    //优化方式二：匿名内部类
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getAge() >= 35;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式三： Lambda表达式
    @Test
    public void test6() {
        List<Employee> list = filterEmployee(employees, (e) -> e.getAge() <= 35);
        list.forEach(System.out::println);

        System.out.println("-----------------------------------------");

        List<Employee> list2 = filterEmployee(employees, (e) -> e.getSalary() >= 10000);
        list2.forEach(System.out::println);
    }

    //优化方式四：Stream API
    @Test
    public void test7() {
        employees.stream()
                .filter((e) -> e.getAge() <= 35)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");

        employees.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }


}
