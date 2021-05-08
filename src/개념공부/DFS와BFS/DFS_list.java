package 개념공부.DFS와BFS;
import java.util.ArrayList;

public class DFS_list {

	// 인접 리스트
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	
	static int n = 7;
	static boolean[] visited = new boolean[n];
	

	public static void main(String[] args) {
		for(int i=0 ; i<n ; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		// 1
		list.get(0).add(1);
		list.get(0).add(2);
		
		// 2
		list.get(1).add(0);
		list.get(1).add(4);
		
		// 3
		list.get(2).add(0);
		list.get(2).add(3);
		
		// 4
		list.get(3).add(0);
		list.get(3).add(2);
		
		// 5
		list.get(4).add(1);
		list.get(4).add(5);
		list.get(4).add(6);
		
		// 6
		list.get(5).add(4);
		list.get(5).add(6);
		
		// 7
		list.get(6).add(4);
		list.get(6).add(5);
				
		DFS(0);
	}
	
	public static void DFS(int index) {
		visited[index] = true;
		
		System.out.println(index+1);
		
		if(index == n) {
			return;
		}
		
		ArrayList<Integer> connect = list.get(index);
		
		for(int i : connect) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}
}

