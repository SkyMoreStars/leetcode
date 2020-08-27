package me.zhyx.base;

import java.util.concurrent.Exchanger;

/**
 * @author: yx.zh
 * @date: 2020-08-27 15:43
 **/
public class ExchangerTest {

    private static class Weapon{
        private String name;
        private int combatPower;

        public Weapon(String name, int combatPower) {
            this.name = name;
            this.combatPower = combatPower;
        }

        @Override
        public String toString() {
            return
                    "兵器='" + name + '\'' +
                    ", 战斗力=" + combatPower
                  ;
        }
    }

    static Exchanger<Weapon> userExchanger=new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            Weapon weapon1 = new Weapon("屠龙刀", 15);
            try {
                System.out.println(Thread.currentThread().getName() + "拥有" + weapon1.toString());
                weapon1=userExchanger.exchange(weapon1);
                System.out.println(Thread.currentThread().getName() + "交换到了" + weapon1.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"张三").start();
        new Thread(()->{
            Weapon weapon2 = new Weapon("倚天剑", 16);
            try {
                System.out.println(Thread.currentThread().getName() + "拥有" + weapon2.toString());
                weapon2=userExchanger.exchange(weapon2);
                System.out.println(Thread.currentThread().getName() + "交换到了" + weapon2.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"李四").start();
    }
}
