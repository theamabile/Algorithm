/**
 * KaKao Programmers / BaekJoon
 * Category : ���α׷��ӽ�.DFS��BFS.��Ʈ��ũ
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.DFS��BFS.��Ʈ��ũ;

import java.util.Queue;
import java.util.LinkedList;

/*
��ǻ���� ���� n, 
���ῡ ���� ������ ��� 2���� �迭 computers�� �Ű������� �־��� ��,
��Ʈ��ũ�� ������ return
*/
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        Queue<Integer> comList = new LinkedList<Integer>();
        for(int i=0 ; i<n ; i++ ){
            comList.add(i);
        }

        boolean[] visited = new boolean[n];
        while(!comList.isEmpty()) {
            int index = comList.poll();
            if(visited[index] == false) {
                answer++;
                DFS(index, comList, computers, visited);
            }
        }

        return answer;
    }

    public void DFS(int index, Queue<Integer> comList, int[][] computers, boolean[] visited) {

        for(int i=0 ; i<computers.length ; i++) {
            if(!visited[i] && computers[index][i] == 1) {
                visited[i] = true;
                comList.remove(i);
                DFS(i, comList, computers, visited);
            }            
        }

    }
}
