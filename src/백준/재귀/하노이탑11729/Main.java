/**
 * BaekJoon
 * Category : ����.���.�ϳ���ž
 * Date : 2021. 4. 20.
 * User : theamabile@gmail.com
 */
package ����.���.�ϳ���ž;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	// �ð� ������ System.out ���� �ʰ� Buffer�� ���
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		bw.write( (int)Math.pow(2, n) - 1 + "\n" );
		
		hanoi(n, 1, 3, 2);
		
		bw.close();
	}
	
	// n���� ������ �������� �̵��ϱ� ���� �̵� ������ ����ϴ� �Լ� 
	public static void hanoi(int n, int source, int dest, int other) throws IOException {
		if(n == 1) {
			bw.write(source + " "+ dest + "\n" );	 // ������ 1���� �ٷ� ���(�ű�� �۾� �ʿ�X)
			return;
		} else {
			hanoi(n-1, source, other, dest);
			bw.write(source + " " + dest + "\n" );
			hanoi(n-1, other, dest, source);
		}
	}
	
}