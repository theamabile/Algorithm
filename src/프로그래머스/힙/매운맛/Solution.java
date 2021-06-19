/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.��.�ſ��
 * Date : 2021. 6. 19.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.��.�ſ��;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        // �ѹ��� �ֱ�
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