package com.jtl.chapter10.innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.f1();
    }
}


class Outer03 {
    private int n1 = 1;

    public void f1() {
        //创建一个基于类的匿名内部类
        //作用域仅仅在定义它的方法或代码块中，因为它就是局部变量
        Person p = new Person() {
            private int n1 = 0;
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法");
                //3.可以直接访问外部类的所有成员，包括私有的
                //当外部类和匿名内部类成员重名的时候，就近原则，
                // 如果要访问外部的，用(外部类名.this.属性)-->这个就是外部类的一个对象，哪个对象调的方法就是哪个
                System.out.println("访问内部类成员 n1 = " + n1);
                System.out.println("访问外部类成员 n1 = " + Outer03.this.n1 );
            }
        };
        //1.动态绑定机制，运行类型是匿名内部类 Outer03$1,调用子类方法
        p.hi();


        //2.也可以直接调用,就是对象.方法
        // 因为匿名内部类本身也是返回对象
        //对于那种只需要使用一次的方法很方便
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法");
            }
        }.hi();

    }
}

class Person {
    public void hi() {
        System.out.println("Person call hi()");
    }
}
