/**
 * BaekJoon
 * Category : ����.�⺻����1.�γ�ȸ���̵��׾�2775
 * Date : 2021. 6. 12.
 * User : theamabile@gmail.com
 */
package ����.�⺻����1.�γ�ȸ���̵��׾�2775;

import java.util.Scanner;

public class Main {

	//ù ��° �ٿ� Test case�� �� T�� �־�����. �׸��� ������ ���̽����� �Է����� ù ��° �ٿ� ���� k, �� ��° �ٿ� ���� n�� �־�����
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCnt = sc.nextInt();
		int[][] input = new int[testCnt][2];
		int maxK = -999;
		int maxN = -999;
		for(int i=0 ; i<testCnt ; i++) {
			input[i][0] = sc.nextInt();		//k
			input[i][1] = sc.nextInt();		//n
			if(input[i][0] > maxK) {
				maxK = input[i][0];
			}
			if(input[i][1] > maxN) {
				maxN = input[i][1];
			}
		}
		
		int[][] data = new int[maxK+1][maxN+1];
		data[1][1] = 1;
		data[1][2] = 3;		// ������
		
		for(int i=1 ; i<=maxK ; i++) {
			data[i][1] = 1;		//	1ȣ�� ������ 1��
			for(int j=2 ; j<=maxN ; j++) {
				if(i == 1) {
					data[i][j] = data[i][j-1] + j; 
				} else {
					data[i][j] = data[i][j-1] + data[i-1][j]; 
				}
			}
		}
		
		for(int i=0 ; i<testCnt ; i++) {
			int k = input[i][0];
			int n = input[i][1];
			System.out.println(data[k][n]);
		}
		
		
		// ��a���� bȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� bȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ� �Ѵ١� 
		// 1   3  => 6     /  2  3 => 10
		// 0�� : 1 2 3 4  5  6 7 8 9
		//        1     2       3           4             5                 6
		// 1�� : 1(1) 3(1+2)  6(1+2+3)  10(1+2+3+4)   15(1+2+3+4+5)    21(1+2+3+4+5+6)
		// 2�� : 1(1) 4(1+3) 10(1+3+6)  20(1+3+6+10)  35(1+3+6+10+15)
		// 3�� : 1(1) 5(1+4) 15(1+4+10) 35(1+4+10+20) 70(1+4+10+20+35)
		// 4�� : 1(1) 6(1+5) 21(1+5+15) 56(1+5+15+35)
	//¦ = (ȣ��+1)* �ø�(ȣ��/2) = 12 14   // Ȧ = 
	
		/* 
		 * 2: +1��
		 * 3: arr[��-1][ȣ] + 3+(��-1)
		 * 4: 
		*/ 
	}

}
