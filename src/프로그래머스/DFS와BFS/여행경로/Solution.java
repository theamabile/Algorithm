/**
 * KaKao Programmers / BaekJoon
 * Category : 프로그래머스.DFS와BFS.여행경로
 * Date : 2021. 5. 16.
 * User : theamabile@gmail.com
 */
package 프로그래머스.DFS와BFS.여행경로;
import java.util.ArrayList;
import java.util.Collections;


/* 1. ICN 미리 추가

---DFS
0. ICN을 answer에 추가
1. answer의 갯수가 ticket.length+1이면 (다 도착했쓰)
   break
   
2. ICN으로 갈 수 있는 목록을 찾아서 todo에 저장
3. todo sort
// for todo 수 만큼
//   if(visited가 false면 (아직 방문 안했음) )
//       visited[i] = ture;
         DFS(ticket[i][1] // 목적지, visited )
         visited[i] = false;

*/


class Solution {
    
    static String[][] tickets;
    static ArrayList<String> answer;
        
    static class Ticket implements Comparable<Ticket> {
        int index;
        String dest;
        
        public Ticket(int index, String dest) {
            this.index = index;
            this.dest = dest;
        }

		@Override
		public int compareTo(Ticket t) {
			// TODO Auto-generated method stub
			return this.dest.compareTo(t.dest);
		}
    }
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.answer = new ArrayList<String>();
        
        DFS("ICN", new boolean[tickets.length]);
        
        return answer.toArray(new String[tickets.length + 1]);
    }
    
    public void DFS(String current, boolean[] visited) {
        
        if(answer.size() >= tickets.length+1)
            return;
        
        answer.add(current);
        
        // 현재 위치에서 방문 가능한 목록을 오름차순으로 정렬한 다음 반복 시키기
        // 모두 방문 가능한 경로가 1개 이상 일 때
        //   -> 인덱스가 앞쪽인 티켓이 정답에 가까운 티켓임.(도착지 이름 순 정렬)
        ArrayList<Ticket> todo = new ArrayList<Ticket>();
        for(int i=0 ; i<tickets.length ; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                todo.add(new Ticket(i, tickets[i][1]));
            }
        }
        Collections.sort(todo);
        
        System.out.println(" current : "+current);
        for(Ticket t : todo) {
             System.out.println("      > "+t.dest);
        }     
        
        // 방문 가능한 곳이 없음 = 정상적으로 끝났거나 더이상 갈 곳이 없는 잘못된 경로
        if(todo.size() <= 0) {  
            return;
        }
                         
        // 알파벳 순서가 앞이라서 갔지만 그 경로가 모두 방문 할 수 있는 경로가 아닐 수도 있음
        //   -> 현재 위치에서 갈 수 있는 곳 모두 가보기
        for(Ticket t : todo) {
            visited[t.index] = true;
            DFS(t.dest, visited);
            visited[t.index] = false;  
            
            //  DFS는 끝까지 들어갔다가 오는 것, 여기서 만들어진 경로가 tickets.length+1개가 아니면 잘못된 경로임 
            if(answer.size() != tickets.length+1) {     
                answer.remove(answer.size()-1);     // 제거
            }   
        }               
        
    }
}