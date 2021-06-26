/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.��.���߿켱����ť
 * Date : 2021. 6. 26.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.��.���߿켱����ť;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> queAsc = new PriorityQueue<Integer>();
        PriorityQueue<Integer> queDesc = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(String str : operations) {
            String oper = str.substring(0,1);
        
            String strNum = str.substring(str.indexOf(" "), str.length()).trim();
            if(oper.equals("I") == true) {
                int num = Integer.parseInt(strNum);
                queAsc.add(num);
                queDesc.add(num);
            } else {
                if(queAsc.isEmpty()) {
                    continue;
                }
                
                if(strNum.contains("-") == true) {
                    int num = queAsc.poll();            // �ּҰ� ����
                    queDesc.remove(num);
                } else {
                    int num = queDesc.poll();            // �ִ밪 ����
                    queAsc.remove(num);
                }
            }
        }
        
        
        int[] answer = new int[2];
        if(!queAsc.isEmpty()) {
            answer[0] = queDesc.peek();
            answer[1] = queAsc.peek();
        }
        
        return answer;
    }
}