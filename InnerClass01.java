package com.jtl.chapter10.innerclass;

//局部内部类
//定义在方法中/代码块
//作用域在方法体或者代码块中
//本质还是一个类
public class InnerClass01 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m1();
    }
}

class Outer{//外部类
    private int n1 = 1;
    private void m2(){
        System.out.println("Outer m2()");
    }
    public void m1(){//方法
        //1.局部内部类是定义在外部类的局部位置，通常在方法
        //3.不能添加访问修饰符，但是可以用final修饰，使局部内部类无法被继承
        //4.作用域：仅仅在定义它的方法或代码块中
        class Inner{
            public void InnerFunction(){//局部内部类，本质还是一个类，可以理解为一个局部变量就像String temp = “”；一样
                //2.局部内部类可以直接访问外部类的成员，包括私有的
                System.out.println("n1 = " + n1);
                m2();
            }
        }
        //5.外部类在方法中，可以创建内部类的实例然后调用方法
        Inner inner = new Inner();
        inner.InnerFunction();

    }

}