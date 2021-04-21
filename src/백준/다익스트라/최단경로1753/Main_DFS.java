/**
 * KaKao Programmers / BaekJoon
 * Category : 백준.DFS
 * Date : 2021. 4. 21.
 * User : theamabile@gmail.com
 */
package 백준.다익스트라.최단경로1753;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_DFS {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int nodeCnt = sc.nextInt();
		int lineCnt = sc.nextInt();
		int start = sc.nextInt();
		
		int[][] nodes = new int[nodeCnt][nodeCnt];
		for(int i=0 ; i<lineCnt ; i++) {
			int s = sc.nextInt() - 1;
			int d = sc.nextInt() - 1;		// 인덱스로 넣어놓기
			int weight = sc.nextInt();
			
			nodes[s][d] = weight;
		}
		
		
//		int nodeCnt = 5;
//		int lineCnt = 6;
//		int start = 1;
//		int[][] inputs = new int[][] {
//			{5, 1, 1}
//			,{1, 2, 2}
//			,{1, 3, 3}
//			,{2, 3, 4}
//			,{2, 4, 5}
//			,{3, 4, 6}
//		};
//		
//		int[][] nodes = new int[nodeCnt][nodeCnt];
//		for(int i=0 ; i<lineCnt ; i++) {
//			int s = inputs[i][0] - 1;
//			int d = inputs[i][1] - 1;		// 인덱스로 넣어놓기
//			int weight = inputs[i][2];
//			
//			nodes[s][d] = weight;
//		}
		
		
		for(int i=0 ; i<nodeCnt ; i++) {
			if(i == start-1) {
				System.out.println(0);
			} else {
				int result = DFS(start-1, i, 0, nodes, new boolean[nodeCnt]);
				if(result < 0)	
					System.out.println("INF");
				else
					System.out.println(result);
			}
		}
	}
	
	public static int DFS(int num, int dest, int weight, int[][] nodes, boolean[] visited) {
		
		visited[num] = true;		
		
		// 목적지에 도착했거나  연결된 노드 중에서 더이상 이동할 노드가 없음(모든 노드 방문=스택에 존재)
		if(num == dest) {
			visited[num] = false;
		} else {

			// 이동 할 수 있는 노드가 있는지 검사
			int cnt = 0;
			for(int i=0 ; i<nodes[num].length ; i++) {
				if(visited[i] == false && nodes[num][i] != 0) { // 방문하지 않았고 갈 수 있으면
					cnt++;
				}
			}
			
			if( cnt == 0 ) {
				visited[num] = false;
				weight = -1; // INF
				
			} else {	// 더 가야함
				// 현재 노드에서 목적지로 갈 수 있음
				if(nodes[num][dest] != 0) {
					weight += nodes[num][dest];
				} else {
					int min = 999;

					// 우회해서 방문할 곳 찾기
					for(int i=0 ; i<nodes[num].length ; i++) {
						if(visited[i] == false && nodes[num][i] != 0) { // 방문하지 않았고 갈 수 있으면
							weight += nodes[num][i];	// 누적
							visited[i] = true;
							int result = DFS(i, dest, weight, nodes, visited);
							if(result < min)
								min = result;
						}
					}
					
					weight = min;
				}
			}
		}
		
		return weight;
	}
}
