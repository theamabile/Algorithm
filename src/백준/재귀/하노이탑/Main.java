/**
 * BaekJoon
 * Category : 백준.재귀.하노이탑
 * Date : 2021. 4. 20.
 * User : theamabile@gmail.com
 */
package 백준.재귀.하노이탑;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	// 시간 때문에 System.out 쓰지 않고 Buffer로 사용
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		bw.write( (int)Math.pow(2, n) - 1 + "\n" );
		
		hanoi(n, 1, 3, 2);
		
		bw.close();
	}
	
	// n개의 원반이 목적지로 이동하기 위한 이동 내역을 출력하는 함수 
	public static void hanoi(int n, int source, int dest, int other) throws IOException {
		if(n == 1) {
			bw.write(source + " "+ dest + "\n" );	 // 원반이 1개면 바로 출력(옮기는 작업 필요X)
			return;
		} else {
			hanoi(n-1, source, other, dest);
			bw.write(source + " " + dest + "\n" );
			hanoi(n-1, other, dest, source);
		}
	}
	
}