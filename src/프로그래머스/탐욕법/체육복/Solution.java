/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.Ž���.ü����
 * Date : 2021. 5. 22.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.Ž���.ü����;

import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        HashSet<Integer> lents = new HashSet<Integer>();
        for(int r : reserve) {
            lents.add(r);
        }
        
        // lost�� reserve �ߺ� ����
        for(int i=0 ; i<lost.length ; i++) {
            if(lents.contains(lost[i])) {
                lents.remove(lost[i]);
                lost[i] = -1;       // �񱳴�󿡼� ���� �����ֱ�. (1~5���� ������. ī��Ʈ �ȵǴ°� ����)
                answer++;           // �ٸ� ģ������ �������� �������� �ϴ� ������ ��� ����
            }
        }

        
        for(int i=0 ; i<lost.length ; i++) {
            if(lents.contains(lost[i]-1)) {
                answer++;
                lents.remove(lost[i]-1);
            } else if(lents.contains(lost[i]+1)) {
                answer++;
                lents.remove(lost[i]+1);
            }
        }
        
        return answer;
    }
}