package com.jtl.chapter10.innerclass;

//成员内部类

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer04 obj = new Outer04();
        obj.test();
        //外部其他类，使用成员内部类的2种方式
        //1.
        Outer04.MemberInnerClass memberInnerClass = obj.new MemberInnerClass();
        //2.在外部类中，编写一个方法，可以返回MemberInnerClass对象
        Outer04.MemberInnerClass memberInnerClass1 = obj.getMemberInnerClass();



    }
}
class Outer04{
    private int n1 = 1;
    public String name = "jtl";
    class MemberInnerClass{
        //1.成员内部类,定义在外部类的成员位置上
        //2.可以添加任意访问修饰符，因为它的地位就是一个成员
        private int n1 = 0;
        public void say(){
            //可以直接访问外部类的所有成员,包括私有的
            System.out.println("外部类n1 = " + Outer04.this.n1);
            System.out.println("内部类n1 = " + n1 + " name = " + name);
        }
    }
    //方法：返回成员内部类的实例
    public MemberInnerClass getMemberInnerClass(){
        return new MemberInnerClass();
    }

    public void test(){
        //使用成员内部类->创建成员内部类的对象
        new MemberInnerClass().say();
    }
}
