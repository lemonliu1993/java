package com.lemon.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by lemoon on 2020/11/8 3:20 PM
 * Java8内置的四大核心函数式接口
 * <p>
 * Consumer<T>:消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T>:供给型接口
 * T get();
 * <p>
 * Function<T,R>:函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T>:断言型接口
 * boolean test(T t);
 */
public class TestLambda3 {

    //Predicate<T> 断言型接口：
    public void test4(){
        List<String> list= Arrays.asList("hello","lemon","aa","ok");
        List<String> stringList = filterStr(list, (x) -> x.length() >= 3);
        System.out.println(stringList);
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> stringList = new ArrayList<>();
        for(String str:list){
            if(predicate.test(str)){
                stringList.add(str);
            }
        }
        return stringList;
    }

    //Function<T,R> 函数型接口：
    public void test3() {
        String s = strHandler("\t\t\t hello world", (str) -> str.trim());
        System.out.println(s);
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }


    //Supplier<T>：供给型接口:
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);
    }


    //需求：产生制定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    //Consumer<T>:消费型接口：
    public void test1() {
        happy(1000, (m) -> {
            System.out.println("刚哥喜欢大保健，消费" + m);
        });
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    public static void main(String[] args) {
        new TestLambda3().test1();
        new TestLambda3().test2();
        new TestLambda3().test3();
        new TestLambda3().test4();
    }
}
