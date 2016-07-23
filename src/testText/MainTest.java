package testText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Andrew on 2016/7/22.
 */
public class MainTest {
    public static void  main(String[]args){
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\27032\\Desktop\\新建 文本文档.txt");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String str;
          for (int i=0;(str=bufferedReader.readLine())!=null;i++){
              if (i<29||(str.length()>0&&(str.charAt(0)=='q'||str.charAt(0)=='s'))){
                  System.out.println(str.substring(1));
              }
//              System.out.println(str);]
//                String str=bufferedReader.readLine();
//                System.out.println(str);
            }

//            System.out.println(str.indexOf("RESULT"));
//            System.out.println(str.indexOf("            "));
//            str.substring(str.indexOf("RESULT"),str.indexOf("            "));
//            System.out.println(str);
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
