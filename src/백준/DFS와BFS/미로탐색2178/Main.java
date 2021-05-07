/**
 * BaekJoon
 * Category : 백준.DFS와BFS.미로탐색2178
 * Date : 2021. 5. 3.
 * User : theamabile@gmail.com
 */
package 백준.DFS와BFS.미로탐색2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Vector2D {
		int x;
		int y;
		int moveCnt;
		
		Vector2D(int x, int y, int moveCnt) {
			this.x = x;
			this.y = y;
			this.moveCnt = moveCnt;
		}
	}
	
	static int[][] maze =  {
			 {1,0,1,1,1,1}
			,{1,0,1,0,1,0}
			,{1,0,1,0,1,1}
			,{1,1,1,0,1,1}
	};
	
	static int[][] move = {
			{-1, 0},		// up
			{+1, 0},		// down
			{0, -1},		// left
			{0, +1}			// right
	};
	
	static int n = 4;		
	static int m = 6;
	
	static final int INF = 9999;
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int n = Integer.parseInt(st.nextToken());		// 정점의 갯수
//		int m = Integer.parseInt(st.nextToken());		// 간선 갯수
//		
//		int[][] maze = new int[n][m];
//		for(int i=0 ; i<n ; i++) {
//			st = new StringTokenizer(br.readLine());
//			String rows = st.nextToken();
//			String[] rowArr = rows.split("");
//			for(int j=0 ; j<m ; j++) {
//				maze[i][j] = Integer.parseInt(rowArr[j]);
//			}
//		}	
		
//		
//		int[][] maze = {
//				 {1,0,1,1,1,1}
//				,{1,0,1,0,1,0}
//				,{1,0,1,0,1,1}
//				,{1,1,1,0,1,1}
//		};
		
		int[][] maze = {
				 {1, 1, 0, 1, 1, 0}
				,{1, 1, 0, 1, 1, 0}
				,{1, 1, 1, 1, 1, 1}
				,{1, 1, 1, 1, 0, 1}
		};
		
		
		
		/*
		 * 현재 위치를 방문했다고 표시
		 * 현재 위치에서 좌우 상하로 이동 가능한 곳이 있는지 확인한다
		 *   > 갈 수 있으면
		 * 
		 * */
		
		visited = new boolean[n][m];
		
		Queue<Vector2D> que = new LinkedList<Vector2D>();
		que.add( new Vector2D(0, 0, 1) );
		
		int result = INF;
		
		System.out.println("n-1 : "+(n-1));
		
		while(!que.isEmpty()) {
			Vector2D current = que.poll();
			
			System.out.printf("%d -  y : %d / x : %d\n", current.moveCnt, current.y, current.x);
			
			if(current.y == n-1 && current.x == m-1) {
				if(result > current.moveCnt) {
					result = current.moveCnt;
				}
				break;
			}
			
			visited[current.y][current.x] = true;
			
			for(int k=0 ; k<4 ; k++) {
				int i = current.y + move[k][0];
				int j = current.x + move[k][1];

				
				if(i >= n || i < 0 || j >= m || j < 0) {			// 미로 범위 초과
					continue;	
				}

				//System.out.printf("\t===> 방문 가능 : %d / 여부 : %b \n", maze[i][j], visited[i][j]);
				
				if(maze[i][j] == 0) {			// 막혀있음
					continue;
				}
				if(visited[i][j] == true) {		// 이미 방문 했음
					continue;
				}
				
				que.add( new Vector2D(j, i, current.moveCnt + 1) );
				System.out.printf("\t===> i: %d / j: %d \n", i, j);
				
			}
			
		}
		
		System.out.println("result : "+result);
		
		
		// (1,0), (1,1)
//		Stack<Vector2D> stack = new Stack<Vector2D>();
		
//				stack.add( new Vector2D(0, 0) );
//				while(!stack.isEmpty()) {
//					Vector2D current = stack.pop();
//					
//					visited[current.y][current.x] = true;
//					
//					for(int k=0 ; k<4 ; k++) {
//						int i = current.y + move[k][0];
//						int j = current.x + move[k][1];
//
//						if(i > n-1 || i < 0 || j > m-1 || j < 0) {			// 미로 범위 초과
//							continue;	
//						}
//
//						System.out.printf("\t===> 방문 가능 : %d / 여부 : %b \n", maze[i][j], visited[i][j]);
//						
//						if(maze[i][j] == 0) {			// 막혀있음
//							continue;
//						}
//						if(visited[i][j] == true) {		// 이미 방문 했음
//							continue;
//						}
//						
//						que.add( new Vector2D(j, i) );
//						
//						int cnt = DFS(j, i, moveCnt+1);
//						if(minCnt > cnt) {
//							minCnt = cnt;
//						}
//					}
//					
//				}
		
		
		
		
		
		
//		int cnt = DFS(0, 0, 1);
//		System.out.println(cnt);
	}
	
	public static int DFS(int x, int y, int moveCnt) {
		
		if(x >= n && y >= m)
			return moveCnt;

		visited[x][y] = true;

		System.out.printf("%d -  y : %d / x : %d\n", moveCnt, y, x);
		
		int minCnt = INF;
		
		for(int k=0 ; k<4 ; k++) {
			int i = y + move[k][0];
			int j = x + move[k][1];
			
			System.out.printf(" >> i : %d / j : %d \n", i, j);

			if(i > n-1 || i < 0 || j > m-1 || j < 0) {			// 미로 범위 초과
				continue;	
			}

			System.out.printf("\t===> 방문 가능 : %d / 여부 : %b \n", maze[i][j], visited[i][j]);
			
			if(maze[i][j] == 0) {			// 막혀있음
				continue;
			}
			if(visited[i][j] == true) {		// 이미 방문 했음
				continue;
			}

			int cnt = DFS(j, i, moveCnt+1);
			if(minCnt > cnt) {
				minCnt = cnt;
			}
		}
		
		if(minCnt == INF) {
			return moveCnt;
		} else {
			return minCnt;
		}
	}

}
