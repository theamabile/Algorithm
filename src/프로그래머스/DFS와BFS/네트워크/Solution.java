/**
 * KaKao Programmers / BaekJoon
 * Category : 프로그래머스.DFS와BFS.네트워크
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package 프로그래머스.DFS와BFS.네트워크;

import java.util.Queue;
import java.util.LinkedList;

/*
컴퓨터의 개수 n, 
연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
네트워크의 개수를 return
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
