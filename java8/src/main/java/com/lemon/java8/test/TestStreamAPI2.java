package com.lemon.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by lemoon on 2020/11/13 9:02 AM
 * 一、stream的三个操作步骤：
 * <p>
 * 1。创建Stream
 * <p>
 * 2。中间操作
 * <p>
 * 3。终止操作(终端操作)
 */
public class TestStreamAPI2 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );

    //中间操作


    /**
     * 映射
     * map——接收Lambda，将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素
     * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    public void test5(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eeee");
        list.stream()
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);


        System.out.println("----------------------");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("----------------------");

        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharater);

//        stream.forEach((sm)->{
//            sm.forEach(System.out::println);
//        });

        System.out.println("----------------------");

        list.stream()
                .flatMap(TestStreamAPI2::filterCharater)
                .forEach(System.out::println);

    }

    public static Stream<Character> filterCharater(String str){
        List<Character> list = new ArrayList<>();
        for(Character character:str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }

    /**
     * 筛选与切片
     * filter——接收Lambda，从流中排除某些元素
     * limit——截断流，使其元素不超过给定数量
     * skip(n)——跳过元素，返回一个扔掉了n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
     * distinct——筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */

    public void test4() {
        employees.stream()
                .filter((e) -> {
                    return e.getAge() < 35;
                })
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }


    public void test3() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路");
                    return e.getAge() > 35;
                })
                .limit(2)
                .forEach(System.out::println);
    }


    //内部迭代：迭代操作由Stream API完成
    public void test1() {

        //中间操作,不会执行任何操作
        Stream<Employee> stream = employees.stream()
                .filter((e) -> {
                    System.out.println("中间操作");
                    return e.getAge() > 35;
                });

        //终止操作，一次性执行全部内容，即"惰性求值"
        stream.forEach(System.out::println);
    }

    //外部迭代
    public void test2() {
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
//        new TestStreamAPI2().test1();
//        new TestStreamAPI2().test4();
        new TestStreamAPI2().test5();
    }
}
