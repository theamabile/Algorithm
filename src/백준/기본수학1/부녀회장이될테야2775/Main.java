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
		
	}

}
