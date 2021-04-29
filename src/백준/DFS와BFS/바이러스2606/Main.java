/**
 * KaKao Programmers / BaekJoon
 * Category : 백준.DFS와BFS.바이러스2606
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package 백준.DFS와BFS.바이러스2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
 * 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 */

/*
 * 첫째 줄에는 컴퓨터의 수가 주어진다. 
 * 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
 * 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
 * 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
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
