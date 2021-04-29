/**
 * KaKao Programmers / BaekJoon
 * Category : ����.DFS��BFS.���̷���2606
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package ����.DFS��BFS.���̷���2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * ��� �� 1�� ��ǻ�Ͱ� �� ���̷����� �ɷȴ�. 
 * ��ǻ���� ���� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ������ �־��� ��, 
 * 1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

/*
 * ù° �ٿ��� ��ǻ���� ���� �־�����. 
 * ��ǻ���� ���� 100 �����̰� �� ��ǻ�Ϳ��� 1�� ���� ���ʴ�� ��ȣ�� �Ű�����. 
 * ��° �ٿ��� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ��ǻ�� ���� ���� �־�����. 
 * �̾ �� ����ŭ �� �ٿ� �� �־� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ��ǻ���� ��ȣ ���� �־�����.
 */

public class Main {

	static int n;
	static int m;
	
	static boolean[] visited;
	static Set<Integer> infection;
	static boolean[][] connect;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		

		connect = new boolean[n][n];
		infection = new HashSet<Integer>();
		visited = new boolean[n];
		
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			connect[from][to] = true;
			connect[to][from] = true;
		}


		DFS(0);
		
		System.out.println(infection.size());
		
	}
	
	public static void DFS(int index) {
		
		if(visited[index] == true)
			return;
		
		for(int i=0 ; i<n ; i++) {
			if(connect[index][i] == true && visited[i] == false) {
				infection.add(i);
				visited[index] = true;
				DFS(i);
			}
		}
	}
	
}
