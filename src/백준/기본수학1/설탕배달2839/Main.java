/**
 * BaekJoon
 * Category : ����.�⺻����1.�������2839
 * Date : 2021. 7. 11.
 * User : theamabile@gmail.com
 */
package ����.�⺻����1.�������2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = n/5;
		int answer = -1;
		
		if(n%3 == 0) {	// 3�� ����� �ƴϸ� ������ 5�� ȥ��. 3�� ������� 5�� ȥ�տ��� �� ���� ��� ���� ���� ���� ����.
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
