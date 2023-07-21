package com.jtl.chapter10.innerclass;

//匿名内部类 1.本质是类 2.该类名字隐藏了 3.同时还是一个对象

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}


interface IA{
    public void cry();
}

class Father{
    public Father(String name){
        System.out.println("Father的构造器被调用 " + name);
    }
    public void test(){

    }
}

class Outer02{
    private int n1 = 100;
    public void m1(){
        //基于接口的匿名内部类
        //1.需求：想使用IA接口，并创建对象
        //2.传统方式，要写一个类，然后让类implements该接口，并创建对象
        //3.如果我们要的类只是使用一次，后面不再使用，那么传统方法太麻烦
        //4.可以使用匿名内部类简化开发
        //5.obj的编译类型 IA
        //6.obj的运行类型 就是匿名内部类 Outer02$1
        /*
            底层：会分配 类名 Outer02$1
            class XXXX implements IA{
                @Override
                public void cry() {
                    System.out.println("obj call cry()");
                }
            }
         */
        //7.底层在创建匿名内部类Outer02$1，
        // 立即创建了Outer02$1对象实例，并把地址返回给obj
        //8.匿名内部类使用一次，就不能再使用了，
        // 因为你无法用类名创建对象，只能用这个obj
        IA obj = new IA(){
            @Override
            public void cry() {
                System.out.println("obj call cry()");
            }
        };
        System.out.println("IA的运行类型：" + obj.getClass());//class com.jtl.chapter10.innerclass.Outer02$1
        obj.cry();

        //基于类的匿名内部类
        //1.obj2的编译类型 Father
        //2.obj2的运行类型 就是匿名内部类 Outer02$2
         /*
            底层会创建匿名类
            class  Outer02$2 extends Father{
            }
         */
        //如果写成这样：Father obj2 = new Father("jtl");
        //编译类型和运行类型都是Father，这就不是匿名内部类了
        //3.如果Father是抽象类（abstract）,匿名内部类必须实现Father的方法
        Father obj2 = new Father("jtl"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写Father的test（）方法");
            }
        };
        obj2.test();


    }

}