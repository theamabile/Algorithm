/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.���ð�ť.��ɰ���
 * Date : 2021. 5. 1.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.���ð�ť.��ɰ���;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Task {
        public int index;
        public int progress;
        public int speed;
        public boolean isDone;
        
        Task(int index, int progress, int speed, boolean isDone) {
            this.index = index;
            this.progress = progress;
            this.speed = speed;
            this.isDone = isDone;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
       
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Task> que = new LinkedList<Task>();
        
        // 1. ������� Queue�� �߰�
        for(int i=0 ; i<progresses.length ; i++) {
            que.add(new Task(i, progresses[i], speeds[i], false));
        }
        
        
        // 2. �� ������ ���� ���൵ ������Ʈ - �Ϸ��Ϸ� �ݺ� ���� ��� �ֵ��� ť���� ���� �Ǹ� ����
        while(!que.isEmpty()) {
            for(Task task : que) {
                task.progress += task.speed;
                if(task.progress >= 100) {
                    task.progress = 100;
                    task.isDone = true;
                }
            }
            
        // 3. Queue �� �տ� �ִ� �ְ� �Ϸ� ���� ��� �� �ڿ� �Ϸ�Ǿ� �ִ� �ֵ鵵 �Բ� ����
            int doneCnt = 0;
             while(!que.isEmpty() && que.peek().isDone) {
                doneCnt++;
                que.remove();
            }
        
        // 4. ���� �� ���� ī��Ʈ �� answer �迭�� �߰�
            if(doneCnt > 0) {
                result.add(doneCnt);
            }
        }
        
        for(int i=0 ; i<result.size() ; i++) {
            System.out.println(result.get(i));
        }
        
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}