package com.lemon.java8.entity;

/**
 * Created by lemoon on 2023/3/12 23:05
 */
public class Employee {

    private int id;
    private String name;
    private Long age;
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee() {

    }

    public Employee(String name, Long age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int id, String name, Long age, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String show() {
        return "测试方法引用！";
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Long age) {
        this.name = name;
        this.age = age;
    }
}
