package test2;

import java.util.Scanner;

public class Test2_2 {
  public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	
	System.out.println("Enter the String: ");
	String s=in.nextLine();
	System.err.println(s);
	s = s.replaceAll(" +", " ");
	System.out.println("Result :" +s);
}
}
