package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 19:51
 **/
public class UnDrawingTest {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        new Drawing(account,50,"你自己").start();
        new Drawing(account,100,"女朋友").start();
    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    Account account;
    /**
     * 取了多少钱
     */
    int drawingMoney;
    /**
     * 现在手里有多少钱
     */
    int nowMoney;
    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.money-drawingMoney<0){
                System.out.println("钱不够取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额
            account.money=account.money-drawingMoney;
            nowMoney=nowMoney+drawingMoney;
            System.out.println(account.name+"余额为："+account.money);
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }

    }

}