/**
 * KaKao Programmers
 * Category : 프로그래머스.스택과큐.기능개발
 * Date : 2021. 5. 1.
 * User : theamabile@gmail.com
 */
package 프로그래머스.스택과큐.기능개발;

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
        
        // 1. 순서대로 Queue에 추가
        for(int i=0 ; i<progresses.length ; i++) {
            que.add(new Task(i, progresses[i], speeds[i], false));
        }
        
        
        // 2. 각 아이템 별로 진행도 업데이트 - 하루하루 반복 돌며 모든 애들이 큐에서 제거 되면 종료
        while(!que.isEmpty()) {
            for(Task task : que) {
                task.progress += task.speed;
                if(task.progress >= 100) {
                    task.progress = 100;
                    task.isDone = true;
                }
            }
            
        // 3. Queue 맨 앞에 있는 애가 완료 됐을 경우 그 뒤에 완료되어 있는 애들도 함께 빼냄
            int doneCnt = 0;
             while(!que.isEmpty() && que.peek().isDone) {
                doneCnt++;
                que.remove();
            }
        
        // 4. 빼낼 때 갯수 카운트 후 answer 배열에 추가
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