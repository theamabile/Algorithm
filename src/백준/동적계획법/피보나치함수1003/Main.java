/**
 * BaekJoon
 * Category : 백준.동적계획법.피보나치함수1003
 * Date : 2021. 4. 23.
 * User : theamabile@gmail.com
 */
package 백준.동적계획법.피보나치함수1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] fibo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		int[] nums = new int[cnt];
		
		int max = -1;
		for(int i=0 ; i<cnt ; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			nums[i] = n;
			if(max < nums[i]) {
				max = nums[i];
			}
		}

		fibo = new int[max+1];
		Arrays.fill(fibo, -1);
		fibonacci( max );
		
		for(int i=0 ; i<cnt ; i++) {
			if( nums[i] == 0 ) {
				bw.write("1 0\n");
			} else {
				int zero = fibo[ nums[i]-1 ];
				int one = fibo[ nums[i] ];
				bw.write(zero+" "+one+"\n");	
			}
		}
		
		br.close();
		bw.close();
	}
	
	static int fibonacci(int n) {
		if(fibo[n] == -1) {
			if(n == 0) {
				fibo[0] = 0;
			} else if(n == 1) {
				fibo[1] = 1;
			} else {
				fibo[n] =  fibonacci(n-1) + fibonacci(n-2);
			}
		}
		return fibo[n];
	}
	

}
