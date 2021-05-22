/**
 * KaKao Programmers / BaekJoon
 * Category : ���α׷��ӽ�.DFS��BFS.������
 * Date : 2021. 5. 16.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.DFS��BFS.������;
import java.util.ArrayList;
import java.util.Collections;


/* 1. ICN �̸� �߰�

---DFS
0. ICN�� answer�� �߰�
1. answer�� ������ ticket.length+1�̸� (�� �����߾�)
   break
   
2. ICN���� �� �� �ִ� ����� ã�Ƽ� todo�� ����
3. todo sort
// for todo �� ��ŭ
//   if(visited�� false�� (���� �湮 ������) )
//       visited[i] = ture;
         DFS(ticket[i][1] // ������, visited )
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
        
        // ���� ��ġ���� �湮 ������ ����� ������������ ������ ���� �ݺ� ��Ű��
        // ��� �湮 ������ ��ΰ� 1�� �̻� �� ��
        //   -> �ε����� ������ Ƽ���� ���信 ����� Ƽ����.(������ �̸� �� ����)
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
        
        // �湮 ������ ���� ���� = ���������� �����ų� ���̻� �� ���� ���� �߸��� ���
        if(todo.size() <= 0) {  
            return;
        }
                         
        // ���ĺ� ������ ���̶� ������ �� ��ΰ� ��� �湮 �� �� �ִ� ��ΰ� �ƴ� ���� ����
        //   -> ���� ��ġ���� �� �� �ִ� �� ��� ������
        for(Ticket t : todo) {
            visited[t.index] = true;
            DFS(t.dest, visited);
            visited[t.index] = false;  
            
            //  DFS�� ������ ���ٰ� ���� ��, ���⼭ ������� ��ΰ� tickets.length+1���� �ƴϸ� �߸��� ����� 
            if(answer.size() != tickets.length+1) {     
                answer.remove(answer.size()-1);     // ����
            }   
        }               
        
    }
}