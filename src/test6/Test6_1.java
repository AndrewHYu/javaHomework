package test6;

/**
 * Created by Andrew on 2016/6/12.
 */
public class Test6_1 {

    public static void main(String[]args){

        Calculation calculation=new Calculation();
        calculation.start();

        GetResult getResult=new GetResult(calculation);
        Thread thread=new Thread(getResult);
        thread.start();
    }
}
    class Calculation extends Thread{
        private int total;
        @Override
        public void run() {
            int i=0;
            while(i<100){
                //为了看到运行结果让线程休眠100毫秒
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                total=total+i*i;
                i++;
            }
        }
        public int gettotal(){
            return total;
        }
    }
    class GetResult implements Runnable{

        Calculation thread;
        public GetResult(Calculation thread){
            this.thread=thread;
        }
        @Override
        public void run() {
//            thread.interrupt();
//            Thread.interrupted();
//            thread.isInterrupted();
            System.out.println("线程名;"+thread.getName());
            while(thread.isAlive()){
                System.out.println("结果是"+thread.gettotal());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
