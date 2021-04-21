/**
 * KaKao Programmers / BaekJoon
 * Category : 백준.DFS.최단경로1753
 * Date : 2021. 4. 21.
 * User : theamabile@gmail.com
 */
package 백준.다익스트라.최단경로1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = 99999;
	
	// 우선순위 큐의 타입으로 사용하려면 Comparable<Node>을 implement 받아야함
	public static class Node implements Comparable<Node> {
		int index;
		int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return  Integer.compare(weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int nodeCnt = Integer.parseInt(st.nextToken());
	    int lineCnt = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    int start = Integer.parseInt(st.nextToken());
        
		int[] dist = new int[nodeCnt];
		int[][] nodes = new int[nodeCnt][nodeCnt];
		for(int i=0 ; i<lineCnt ; i++) {
			st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
			
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
//		int[] dist = new int[nodeCnt];
//		int[][] nodes = new int[nodeCnt][nodeCnt];
		
		// weight의 최대값 보다 큰 수로 셋팅
		Arrays.fill(dist, INF);
		dist[start-1] = 0;		// 자기 자신과의 거리는 0임
		
//		for(int i=0 ; i<lineCnt ; i++) {
//			int s = inputs[i][0] - 1;
//			int d = inputs[i][1] - 1;		// 인덱스로 넣어놓기
//			int weight = inputs[i][2];
//			
//			nodes[s][d] = weight;
//		}
		
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		que.add(new Node(0, 0));
		
		while(!que.isEmpty()) {	// 큐가 비어있지 않을때까지 반복. 비면 나감
			Node current = que.poll();
			
			// curren와 연결된 노드 순회
			for(int i=0 ; i<nodes[current.index].length ; i++) {
				// 자기 자신이 아니고, 현재 노드와 이어진 노드면
				if(i != current.index && nodes[current.index][i] != 0) { 
					
					// 현재까지의 누적 가중치 값과 이어진 노드의 가중치를 더한 값과  저장된 최소 거리 값과 비교. 더 작은 값을 넣음
					if(dist[i] > current.weight + nodes[current.index][i] ) {
						dist[i] = current.weight + nodes[current.index][i];
						
						// 현재 노드 번호(index)와 현재까지의 가중치를 넣음. Queue에 등록 되야 계속 이어서 검사 가능함.
						// dist[i]보다 크면 이미 최소 값이 아니기 때문에 더이상 비교할 가치가 없음. 따라서 큐에 저장 안함
						que.add( new Node(i, current.weight + nodes[current.index][i]) );		
					}
				}
 			}
			
		}
		
		
		for (int i = 0; i < nodeCnt; i++) {
			if(dist[i] >= INF) {
				
				System.out.println("INF"); 
			} else {
				System.out.println(dist[i]); 
			}			
		}
		
		bw.close();
	    br.close();
	        
	}
		
}


