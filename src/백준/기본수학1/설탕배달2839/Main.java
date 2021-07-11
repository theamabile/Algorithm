/**
 * BaekJoon
 * Category : 백준.기본수학1.설탕배달2839
 * Date : 2021. 7. 11.
 * User : theamabile@gmail.com
 */
package 백준.기본수학1.설탕배달2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = n/5;
		int answer = -1;
		
		if(n%3 == 0) {	// 3의 배수가 아니면 무조건 5랑 혼합. 3의 배수여도 5와 혼합에서 더 좋은 결과 값이 있을 수도 있음.
			answer = n/3;
		}
		
		
		for(int i=0 ; i<cnt ; i++) {
			int temp = n - 5 * (i+1);
			if(temp%3 == 0) {
				int newAnswer = (i+1) + temp/3;
				
				if(answer < 0 || answer > newAnswer) {
					answer = newAnswer;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
