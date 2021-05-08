package 개념공부.DFS와BFS;
import java.util.ArrayList;
public class DFS_matrix {

	// 행렬
	static int[][] arr = {
			{0,1,1,1,0,0,0},
			{1,0,0,0,1,0,0},
			{1,0,0,1,0,0,0},
			{1,0,1,0,0,0,0},
			{0,1,0,0,0,1,1},
			{0,0,0,0,1,0,1},
			{0,0,0,0,1,1,0}
		};
	
	static int n = 7;
	static boolean[] visited = new boolean[n];
	

	public static void main(String[] args) {
		visited[0] = true;
		DFS(0);
	}
	
	public static void DFS(int index) {
		
		System.out.println(index+1);
		
		if(index == n) {
			return;
		}
		
		for(int i=0 ; i<n ; i++) {
			if(i == index)
				continue;
			
			if(arr[index][i] == 1 && visited[i] == false) {
				visited[i] = true;
				DFS(i);
			}
			
		}
		
	}
}

