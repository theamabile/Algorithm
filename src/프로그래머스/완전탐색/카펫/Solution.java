package ���α׷��ӽ�.����Ž��.ī��;

import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        ArrayList<Integer> yellowSubs = new ArrayList<Integer>();
        
        int x = 0;
        int y = 0;
        
        getSubs(yellow, yellowSubs);
        if(yellowSubs.size() <= 0) {
            // ������ ���� (1, 2, 3, 7, 11�� ���� �Ҽ�)
            x = yellow + 2;
            y = 3;
        } else {
            for(Integer w : yellowSubs) {
                int h = yellow/w;
                int brownCnt = (w*2) + (h*2) + 4;  
                if(brownCnt == brown) {
                    // �� �迭�� ����. ���ΰ� ������ 2�پ� �߰�
                    x = w + 2;
                    y = h + 2;  
                    break;
                }
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
    
    public void getSubs(int num, ArrayList<Integer> subs) {
        for(int i=2 ; i<=num/2 ; i++) {
            if( num%i== 0 && Math.sqrt(num) <= i) {
                subs.add(i);
            }
        }
        
    }
    
}