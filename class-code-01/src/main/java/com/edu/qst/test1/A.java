package com.edu.qst.test1;

public class A {
    private int age;
    public A() {
        System.out.println("A无参构造");
    }
    public A(int age) {
        this.age = age;
        System.out.println(age);
    }
}
class B extends A{
    public B() {
        super(5);
    }
}
