package com.jtl.chapter10.innerclass;
//静态内部类
public class StaticIInnerClass {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        //外部其他类，访问静态内部类的方法
        //1.因为静态内部类可以通过类名直接访问（前提是满足访问权限）
        Outer05.StaticInnerClass01 staticInnerClass01 = new Outer05.StaticInnerClass01();
        staticInnerClass01.say();
        //2.编写一个方法，可以返回静态内部类的实例
        Outer05.StaticInnerClass01 staticClass = outer05.getStaticClass();
        staticClass.say();
        //3.直接写个静态方法返回，就不用创建对象了
        Outer05.StaticInnerClass01 staticClass01 = Outer05.getStaticClass01();
        staticClass01.say();

    }
}

class Outer05{
    private int n1 = 1;
    private static String name = "Jtl";
    //静态内部类
    //1.放在外部类的成员位置
    //2.用static修饰
    //3.可以直接访问外部类的所用静态成员，但不能直接访问非静态成员
    //4.可以添加任意访问修饰符，因为它的地位就是一个成员
    static class StaticInnerClass01{
        private static String name = "cqh";
        public void say(){
            //就近原则，输出cqh
            System.out.println(name);
            //访问外部类重名成员：
            System.out.println("外部类name=" + Outer05.name);
        }
    }
    public StaticInnerClass01 getStaticClass(){
        return new StaticInnerClass01();
    }

    public static StaticInnerClass01 getStaticClass01(){
        return new StaticInnerClass01();
    }
}

//小结：内部类有四种：
/*
1.局部内部类 2.匿名内部类***** 3.成员内部类 4.静态内部类
其中匿名内部类：new class/interface(){};
 */
