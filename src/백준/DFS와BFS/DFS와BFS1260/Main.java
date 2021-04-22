/**
 * BaekJoon
 * Category : 백준.DFS와BFS.DFS와BFS1260
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package 백준.DFS와BFS.DFS와BFS1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
 * 정점 번호는 1번부터 N번까지이다.
 */

/**
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 
 * 간선의 개수 M(1 ≤ M ≤ 10,000), 
 * 탐색을 시작할 정점의 번호 V가 주어진다. 
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 */
public class Main {

	static boolean[][] connect;		
	static int n;		// 정점의 갯수
	static int m;		// 간선 갯수


	static boolean[] visitedDFS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());		// 정점의 갯수
		m = Integer.parseInt(st.nextToken());		// 간선 갯수
		int v = Integer.parseInt(st.nextToken());		// 시작 노드 번호
		
		connect = new boolean[n][n];
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;		// 정점의 갯수
			int to = Integer.parseInt(st.nextToken()) - 1;		// 간선 갯수
			
			connect[from][to] = true;
			connect[to][from] = true;
		}

		visitedDFS = new boolean[n];
		DFS(v-1);
		System.out.println();
		BFS(v);
	}

	// 깊이 우선 탐색 - Stack 
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
	
	// 너비 우선 탐색 - Queue
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
