package testStaticFunction;

/**
 * Created by Andrew on 2016/6/16.
 */
public class NewStaticFunction {
    private static int b=6;
    public static void testStatic(){
        int a=5;
        System.out.println(a+"  "+b);
        try {
            a=7;
            b=8;
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a+"  "+b);
    }
    int getSum(int [][]numbers){
        int total=0;
        for (int[]number:
             numbers) {
            for (int one:
                 number) {
                total+=one;
            }
        }
        return total;
    }
}
