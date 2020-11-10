package com.lemon.java8.test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by lemoon on 2020/11/9 9:12 AM
 * <p>
 * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * (可以理解为方法引用是Lambda表达式的另外一种变现形式)
 * <p>
 * 前提：参数列表和返回值类型一致
 * <p>
 * 主要有三种语法格式：
 * <p>
 * 对象::实例方法名
 * <p>
 * 类::静态方法名
 * <p>
 * 类::实例方法名
 * <p>
 * 注意：
 * 1.Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
 * 2.若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName:method
 * <p>
 * <p>
 * 二、构造器引用：
 * <p>
 * 格式：
 * ClassName::new
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * <p>
 * 三、数组引用：
 * <p>
 * Type::new;
 */
public class TestMethodRef {


    //数组引用
    public void test7() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }

    //构造器可用
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
    }

    public void test6() {
        Function<Integer, Employee> fun = (x) -> new Employee(x);

        Function<Integer, Employee> fun2 = Employee::new;

        Employee employee = fun2.apply(101);
        System.out.println(employee);
    }


    //类::实例方法名
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> np1 = String::equals;
    }

    //类::静态方法名
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
    }

    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup1 = emp::getAge;
        Integer num = sup1.get();
        System.out.println(num);

    }
}
