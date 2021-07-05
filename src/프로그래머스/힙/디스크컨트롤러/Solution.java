/**
 * KaKao Programmers
 * Category : 프로그래머스.힙.디스크컨트롤러
 * Date : 2021. 6. 26.
 * User : theamabile@gmail.com
 */
package 프로그래머스.힙.디스크컨트롤러;

import java.util.PriorityQueue;

import java.util.*;

class Solution {
    // reqTime 시간 순 정렬이 기본
    static class Task implements Comparable<Task>{
        private int reqTime;
        private int taskTime;
        private int startTime;
        
        public Task(int reqTime, int taskTime) {
            this.reqTime = reqTime;
            this.taskTime = taskTime;
        }
        
        public int compareTo(Task t) {      
            return this.getReqTime() > t.getReqTime() ? 1 : -1;
		}
        
        public int getReqTime() {
            return reqTime;
        }
        public int getTaskTime() {
            return taskTime;
        }
        public int getStartTime() {
            return startTime;
        }
        
        public void start(int startTime) {
            this.startTime = startTime;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
       
        PriorityQueue<Task> que = new PriorityQueue<Task>();
        PriorityQueue<Task> nextTasks = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if(t1.getTaskTime() < t2.getTaskTime()) {
                    return -1;
                } else if(t1.getTaskTime() > t2.getTaskTime()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        
        int deltaTime = 0;
        int sum = 0;
        
        
        for(int[] job : jobs) {
            que.add(new Task(job[0], job[1]));
        }
        
        
        Task current = que.poll();
        
        for(int i=0; i<jobs.length ; i++) {
            if(current.getReqTime() > deltaTime) {
               deltaTime += (current.getReqTime() - deltaTime);
            }
            
            current.start(deltaTime);
            deltaTime += current.getTaskTime();

            // 응답시간 누적
            int waitTime = current.getStartTime() - current.getReqTime();
            int resTime = waitTime + current.getTaskTime();

            sum += resTime;
            
            // 다음꺼 찾기
            nextTasks.clear();
            for(Task t : que) {
                if(t.getReqTime() <= deltaTime) {
                    nextTasks.add(t);
                }
            }

            if(nextTasks.isEmpty()) {
                current = que.poll();       
            } else {
                current = nextTasks.poll();
            }
            
            que.remove(current);
        }
        
        return sum/jobs.length;
    }
}