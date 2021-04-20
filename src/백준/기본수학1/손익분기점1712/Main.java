/**
 * BaekJoon
 * Category : 백준.기본수학1.손익분기점1712
 * Date : 2021. 3. 6.
 * User : theamabile@gmail.com
 */

package 백준.기본수학1.손익분기점1712;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
				
		int bep = 1;
		
		if(c <= b) {
			bep = -1;
		}
		else {
			bep = (a / (c - b) ) + 1;
		}

		System.out.println(bep);	
		
	}

}