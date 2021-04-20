/**
 * BaekJoon
 * Category : πÈ¡ÿ.¿Á±Õ.∆—≈‰∏ÆæÛ
 * Date : 2021. 4. 20.
 * User : theamabile@gmail.com
 * Time : 20:05 - 20:09
 */
package πÈ¡ÿ.¿Á±Õ.∆—≈‰∏ÆæÛ;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Factorial(n));
	}
	
	public static  int Factorial(int n) {
		if(n<=1)
			return 1;
		
		return n * Factorial(n-1);
	}
}
