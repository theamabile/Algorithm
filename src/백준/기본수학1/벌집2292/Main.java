/**
 * BaekJoon
 * Category : 백준.기본수학1.벌집2292
 * Date : 2021. 3. 6.
 * User : theamabile@gmail.com
 */

package 백준.기본수학1.벌집2292;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dest = sc.nextInt();
		
		int begin, end = 1;
		int n = 0;
		
		while(true) {
			begin = end + 1;
			end = (begin-1) + (6 * n); 
			n++;
			if(dest <= end) {
				break;
			}
		}
		System.out.println(n);
	}
}