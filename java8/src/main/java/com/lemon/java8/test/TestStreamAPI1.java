package com.lemon.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by lemoon on 2020/11/12 8:38 AM
 * 一、stream的三个操作步骤：
 * <p>
 * 1。创建Stream
 * <p>
 * 2。中间操作
 * <p>
 * 3。终止操作(终端操作)
 */
public class TestStreamAPI1 {

    public void test1() {
        //1.可以通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb,", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
//        stream4.forEach(System.out::println);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        new TestStreamAPI1().test1();
    }
}
