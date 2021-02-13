package com.lemon.jvm;

/**
 * Created by lemoon on 2021/2/13 4:03 PM
 * 在java中，可作为GC Rootts的对象有：
 *
 * 1.虚拟机栈(栈帧中的本地变量表)中引用的对象
 * 2.方法区中的类静态属性应用的对象
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中JNI(即一般说的Native方法)中引用的对象
 */
public class GCRootDemo {
    private byte[] byteArray = new byte[100*1024*1024];

    private static GCRootDemo t;
    private static final GCRootDemo t3 = new GCRootDemo();

    public static void m1(){
        GCRootDemo t1= new GCRootDemo();
        System.gc();
        System.out.println("第一次gc完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
