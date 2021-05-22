/**
 * KaKao Programmers 
 * Category : 프로그래머스.DFS와BFS.여행경로
 * Date : 2021. 5. 22 
 * User : theamabile@gmail.com
 */
package 프로그래머스.DFS와BFS.여행경로;
import java.util.ArrayList;
import java.util.Collections;

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
        
        ArrayList<Ticket> todo = new ArrayList<Ticket>();
        for(int i=0 ; i<tickets.length ; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                todo.add(new Ticket(i, tickets[i][1]));
            }
        }
        Collections.sort(todo);
        
        if(todo.size() <= 0) {  
            return;
        }

        for(Ticket t : todo) {
            visited[t.index] = true;
            DFS(t.dest, visited);
            visited[t.index] = false;  
            
            if(answer.size() != tickets.length+1) {     
                answer.remove(answer.size()-1); 
            }   
        }               
        
    }
}