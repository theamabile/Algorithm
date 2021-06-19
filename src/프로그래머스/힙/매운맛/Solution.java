/**
 * KaKao Programmers
 * Category : 프로그래머스.힙.매운맛
 * Date : 2021. 6. 19.
 * User : theamabile@gmail.com
 */
package 프로그래머스.힙.매운맛;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        // 한번에 넣기
	    heap.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));        
        
        while(true) {
            if(heap.peek() >= K)
                break;
            
            if(heap.size() == 1 && heap.peek() < K)
                return -1;
            
            int firstMin = heap.poll();
            int secondMin = heap.poll();
            
            int temp = firstMin + (secondMin * 2);
            
            heap.add(temp);
        }
        
        if(scoville.length == heap.size())
            return -1;
        
        return scoville.length - heap.size();
    }
}