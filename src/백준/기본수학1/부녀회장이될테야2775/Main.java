/**
 * BaekJoon
 * Category : 백준.기본수학1.부녀회장이될테야2775
 * Date : 2021. 6. 12.
 * User : theamabile@gmail.com
 */
package 백준.기본수학1.부녀회장이될테야2775;

import java.util.Scanner;

public class Main {

	//첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다
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
		data[1][2] = 3;		// 누적값
		
		for(int i=1 ; i<=maxK ; i++) {
			data[i][1] = 1;		//	1호는 무조건 1명
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
