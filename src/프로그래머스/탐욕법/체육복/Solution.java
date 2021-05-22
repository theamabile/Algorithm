/**
 * KaKao Programmers
 * Category : 프로그래머스.탐욕법.체육복
 * Date : 2021. 5. 22.
 * User : theamabile@gmail.com
 */
package 프로그래머스.탐욕법.체육복;

import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        HashSet<Integer> lents = new HashSet<Integer>();
        for(int r : reserve) {
            lents.add(r);
        }
        
        // lost와 reserve 중복 제거
        for(int i=0 ; i<lost.length ; i++) {
            if(lents.contains(lost[i])) {
                lents.remove(lost[i]);
                lost[i] = -1;       // 비교대상에서 제외 시켜주기. (1~5범주 벗어나면됨. 카운트 안되는게 목적)
                answer++;           // 다른 친구에게 빌려주진 못하지만 일단 수업은 듣기 가능
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