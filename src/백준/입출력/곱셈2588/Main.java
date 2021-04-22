/**
 * KaKao Programmers / BaekJoon
 * Category : ¹éÁØ.ÀÔÃâ·Â.°ö¼À2588
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package ¹éÁØ.ÀÔÃâ·Â.°ö¼À2588;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
        
        int hundred = B/100;
        int ten = (B%100)/10;
        int one = B%10;
        int sum = (A*one) + ((A*ten)*10) + ((A*hundred)*100);
        
        System.out.println( A*one );           
        System.out.println( A*ten );  
        System.out.println( A*hundred ); 
		System.out.println( sum );
	}

}
