package com.jtl.chapter10.innerclass;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.control.Cell;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        //匿名内部类当作实参直接传递，简洁高效
        //1.参数是实现了Bell接口的匿名内部类，就是传一个对象进去
        //2.重写了ring方法
        //3. 形参bell接受了：new Bell() { InnerClassExercise02$1
        //            @Override
        //            public void ring() {
        //                System.out.println("懒猪起床了");
        //            }
        //        }
        Cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        Cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴们起床了");
            }
        });

        //第二种方法：类->实现Bell-->硬编码
        //要用好几次，用这种，如果我只需要用一次，而且想要更灵活的话，用第一种
        Cellphone.alarmClock(new Test());
    }
}


interface Bell{
    void ring();
}

class Cellphone {
    public static void alarmClock(Bell bell){
        System.out.println(bell.getClass());
        bell.ring();//动态绑定,运行传进来的ring方法
    }
}

class Test implements Bell{
    @Override
    public void ring() {
        System.out.println("测试类打铃了");
    }
}
