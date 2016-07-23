package test1;

public class Test1_4 {
    public static void main(String[] args) {
        int[] b = new int[10];
        int k = 0;
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = (int) (Math.random() * 100);
            for (int j = 0; j < i + 1; j++) {
                if ((i != j) && b[i] == b[j])
                    b[i] = (int) (Math.random() * 100);
            }
        }
        System.out.print("随机生成的数组：");
        for(int i = 0; i<b.length;i++){
            System.out.print(b[i]+"  ");
        }
        System.out.println();
        System.out.println("--------------------------");
        System.out.print("排序后的数组：");
        for (int i = 0; i < b.length; i++) {
            k = i;
            for (int j = k + 1; j < b.length; j++) {
                 if(b[j]<b[k]){
                     k=j;
                 }
            }
            if(k != i){
                temp = b[i];
                b[i] = b[k];
                b[k] = temp;
            }
            System.out.print(b[i]+"  ");
             
        }
       
    }
}