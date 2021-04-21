/**
 * KaKao Programmers / BaekJoon
 * Category : ����.DFS.�ִܰ��1753
 * Date : 2021. 4. 21.
 * User : theamabile@gmail.com
 */
package ����.���ͽ�Ʈ��.�ִܰ��1753;

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
	
	// �켱���� ť�� Ÿ������ ����Ϸ��� Comparable<Node>�� implement �޾ƾ���
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
		
		// weight�� �ִ밪 ���� ū ���� ����
		Arrays.fill(dist, INF);
		dist[start-1] = 0;		// �ڱ� �ڽŰ��� �Ÿ��� 0��
		
//		for(int i=0 ; i<lineCnt ; i++) {
//			int s = inputs[i][0] - 1;
//			int d = inputs[i][1] - 1;		// �ε����� �־����
//			int weight = inputs[i][2];
//			
//			nodes[s][d] = weight;
//		}
		
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		que.add(new Node(0, 0));
		
		while(!que.isEmpty()) {	// ť�� ������� ���������� �ݺ�. ��� ����
			Node current = que.poll();
			
			// curren�� ����� ��� ��ȸ
			for(int i=0 ; i<nodes[current.index].length ; i++) {
				// �ڱ� �ڽ��� �ƴϰ�, ���� ���� �̾��� ����
				if(i != current.index && nodes[current.index][i] != 0) { 
					
					// ��������� ���� ����ġ ���� �̾��� ����� ����ġ�� ���� ����  ����� �ּ� �Ÿ� ���� ��. �� ���� ���� ����
					if(dist[i] > current.weight + nodes[current.index][i] ) {
						dist[i] = current.weight + nodes[current.index][i];
						
						// ���� ��� ��ȣ(index)�� ��������� ����ġ�� ����. Queue�� ��� �Ǿ� ��� �̾ �˻� ������.
						// dist[i]���� ũ�� �̹� �ּ� ���� �ƴϱ� ������ ���̻� ���� ��ġ�� ����. ���� ť�� ���� ����
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


