package test2;

import java.util.Scanner;

public class Test2_1 {

	  
    public static void main(String[] args) {
        int row;
        int column;
//        int arr2D[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("请输入矩阵的行数");
        Scanner in=new Scanner(System.in);
        row=in.nextInt();
        System.out.println("请输入矩阵的列数");
        column=in.nextInt();

        int[][] array=new int[row][column];
        //清除缓存
        in.nextLine();
        //转换数组
        for (int i=0;i<row;i++) {
            System.out.println("输入第"+(i+1)+"行，每个数用逗号分隔");
            String numbers=in.nextLine();
            String []number=numbers.split(",");
            for (int j=0;j<column;j++){
                array[j][i]=Integer.parseInt(number[j]);
            }
        }

        for (int x[]:array){
            for(int e:x){
                System.out.print(e+" ");
            }
            System.out.println();
        }

    }
  
}  