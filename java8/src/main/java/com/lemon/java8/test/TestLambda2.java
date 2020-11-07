package com.lemon.java8.test;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Created by lemoon on 2020/11/7 3:24 PM
 * 一、Lambda表达式的基础语法：Java8引入了一个新的操作符 "->" 该操作符称为箭头操作符或Lambda操作符
 * 箭头操作符将Lambda表达式拆分成两部分：
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体
 * <p>
 * <p>
 * 语法格式一：无参数，无返回值
 * ()->System.out.println("Hello Lambda!");
 * <p>
 * <p>
 * 语法格式二：一个参数，无返回值
 * (x)->System.out.println(x);
 * <p>
 * 语法格式三：若只有一个参数，小括号可以不写
 * x -> System.out.println(x);
 * <p>
 * <p>
 * 语法格式四：有两个以上的参数，有返回值，并且Lambda中有多条语句
 * Comparator<Integer> com = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * <p>
 * 语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 * Comparator<Integer> com = (x, y) ->
 * Integer.compare(x, y);
 * <p>
 * 语法格式六：Lambda表达式的参数类型可以省略不屑，因为JVM编译器通过上下文推断出，数据类型，即"类型推断"
 * (Integer x,Integer y) -> Integer.compare(x,y);
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二、Lambda表达式需要"函数式接口"的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以使用注解@FunctionInterface修饰
 * 可以检查是否是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };

        r.run();

        System.out.println("------------------------");

        Runnable r1 = () -> {
            System.out.println("Hello World!");
        };

        r1.run();
    }


    public void test2() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("lemon world");
    }


    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    public void test4() {
        Comparator<Integer> com = (x, y) ->
                Integer.compare(x, y);
    }


    //需求：对一个树进行运算
    public void test6() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }
}
