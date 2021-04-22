/**
 * BaekJoon
 * Category : ����.DFS��BFS.DFS��BFS1260
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package ����.DFS��BFS.DFS��BFS1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, 
 * �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. 
 * ���� ��ȣ�� 1������ N�������̴�.
 */

/**
 * ù° �ٿ� ������ ���� N(1 �� N �� 1,000), 
 * ������ ���� M(1 �� M �� 10,000), 
 * Ž���� ������ ������ ��ȣ V�� �־�����. 
 * ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. �Է����� �־����� ������ ������̴�.
 */
public class Main {

	static boolean[][] connect;		
	static int n;		// ������ ����
	static int m;		// ���� ����


	static boolean[] visitedDFS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());		// ������ ����
		m = Integer.parseInt(st.nextToken());		// ���� ����
		int v = Integer.parseInt(st.nextToken());		// ���� ��� ��ȣ
		
		connect = new boolean[n][n];
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;		// ������ ����
			int to = Integer.parseInt(st.nextToken()) - 1;		// ���� ����
			
			connect[from][to] = true;
			connect[to][from] = true;
		}

		visitedDFS = new boolean[n];
		DFS(v-1);
		System.out.println();
		BFS(v);
	}

	// ���� �켱 Ž�� - Stack 
	public static void DFS(int v){
		if(visitedDFS[v] == true)
			return;
		
		System.out.printf("%d ", (v+1));
		visitedDFS[v] = true;
		
		for(int i=0 ; i<n ; i++) {
			if(connect[v][i] == false || visitedDFS[i] == true)
				continue;
			DFS(i);
		}
	}
	
	// �ʺ� �켱 Ž�� - Queue
	public static void BFS(int v){
		int start = v-1;
		boolean[] visited = new boolean[n];
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int current = que.poll();
			System.out.printf("%d ", (current+1));
			
			for(int i=0 ; i<n ; i++) {
				if(connect[current][i] == false || visited[i] == true)
					continue;
				
				que.add(i);
				visited[i] = true;
			}
		}
	}

}
