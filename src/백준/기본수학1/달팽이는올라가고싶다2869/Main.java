/**
 * BaekJoon
 * Category : ����.�⺻����1.�����̴¿ö󰡰�ʹ�2869
 * Date : 2021. 7. 11.
 * User : theamabile@gmail.com
 */
package ����.�⺻����1.�����̴¿ö󰡰�ʹ�2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a  = Integer.parseInt(st.nextToken());		
		int b = Integer.parseInt(st.nextToken());		
		int v = Integer.parseInt(st.nextToken());	
		
		int answer = (v-b) / (a-b);
		if( (v-b)%(a-b) != 0 ) {		// ������ �������� ������ �ѹ� �� ���ߵ�
			++answer;
		} 
		
		System.out.println(answer);
	}

}
