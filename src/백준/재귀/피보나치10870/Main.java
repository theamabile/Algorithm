/**
 * BaekJoon
 * Category : ����.���.�Ǻ���ġ
 * Date : 2021. 4. 20.
 * User : theamabile@gmail.com
 * Time : 20:14-19
 */
package ����.���.�Ǻ���ġ10870;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Fibonacci(n));
	}
	
	public static int Fibonacci(int n) {
		if(n==0) {
			return 0;
		} else if(n<=2) {
			return 1;
		}
		
		return Fibonacci(n-1) + Fibonacci(n-2);
	}

}
