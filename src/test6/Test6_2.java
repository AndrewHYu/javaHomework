package test6;

import java.text.DecimalFormat;

/**
 * Created by Andrew on 2016/6/13.
 */
public class Test6_2 {
    volatile static double balance=0;
    public static void main(String[]args){

        Thread take=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    double count=Double.parseDouble(new DecimalFormat("#.00").format(Math.random()*100));
                    if (balance>count) {
                        System.out.println("已取出:"+count);
                        balance = balance - count;
                    }else{
                        System.out.println("-----余额不足------");
                    }
                }
            }
        });
        Thread deposit=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    double count=Double.parseDouble(new DecimalFormat("#.00").format(Math.random()*100));
                        System.out.println("已存入:"+count);
                        balance = balance + count;
                }
            }
        });
        deposit.start();
        take.start();

    }

}
