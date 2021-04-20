/**
 * KaKao Programmers
 * Category : 프로그래머스.해시.완주하지못한선수
 * Date : 2021. 4. 5.
 * User : theamabile@gmail.com
 */
package 프로그래머스.해시.완주하지못한선수;

import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);   // 참여
        Arrays.sort(completion);    // 완주
        
        for(int i=0 ; i<participant.length-1 ; i++) {
            if(participant[i].equals(completion[i]) == false) {     // 순서가 같지 않은 순간 완주 안한 애가 있는것.
                answer = participant[i];
                break;
            }
        }
        
        if(answer.equals("")) { // 순회를 했는데도 비어있으면
            answer = participant[participant.length-1];
        }
        
        return answer;
    }
}