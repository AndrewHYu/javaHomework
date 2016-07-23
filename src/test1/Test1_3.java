/**
 * 
 */
package test1;

import java.util.Scanner;

/**
 * @author 69569
 *
 */
public class Test1_3 {
     public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your name:");
		String name=in.nextLine();
		
		System.out.println("Enter your telephone number: ");
		String tel=in.nextLine();
		
		System.out.println("Enter your address: ");
		String address=in.nextLine();
		
		System.out.println("Enter your post number: ");
		String post=in.nextLine();
		
		System.out.println("Name: " +name);
		System.out.println("Tel: "+tel);
		System.out.println("Addr: " +address);
		System.out.println("post: "+post);
		
		
	}
}
