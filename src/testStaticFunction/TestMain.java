package testStaticFunction;

/**
 * Created by Andrew on 2016/6/16.
 */
public class TestMain {
/*    public static void main(String[]args){
//        NewStaticFunction.testStatic();
//        NewStaticFunction.testStatic();
        System.out.println(Integer.MAX_VALUE);
        NewStaticFunction  newStaticFunction=new NewStaticFunction();
        int[][]w=new int[3][];
        int []r={5,8};
        String[]f={"ddd","sss"};
        String [] a = {"1","2","3"};
        System.out.println(newStaticFunction.getSum(new int[][]{{2,3,4},{3}}));

    }*/
/*    String str="Hi";
    char[] ch={'L','I','K','E'};
    public static void main(String[]rags){
        TestMain testMain=new TestMain();
        testMain.change(testMain.str,testMain.ch);
        System.out.println(testMain.str);
        System.out.println(testMain.ch);
        Boolean flag = true;
    }
    public void change(String str,char ch[]){
        str="How are you";
        ch[1]='u';
    }*/

    static int total = 10;
    public static void main (String args [ ]) {
        new TestMain( );
        int  x=4;
        System.out.println("value  is  "+ ((x>4) ? 99.9:9));
        int c;
        c = 2;
        System.out.println(c);
        System.out.println(c++);
        System.out.println(c);
/*        try {
            new BufferedReader(new FileInputStream("a.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
 /*   int  j=0;
    do{
        System.out.println( "j  is "+j++);
        if (j==3) {continue  loop;}
    }while(j<10);*/
    }
    public  final  static  native  int  w( );
//    abstract  final  double  hyperbolicCosine( );

    public TestMain ( ) {
         System.out.println("In test");
         System.out.println(this);
         int temp = this.total;
         if (temp > 5) {
             System.out.println(temp);
             }
         }
}
