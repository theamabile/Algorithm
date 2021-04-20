/**
 * KaKao Programmers
 * Category : 프로그래머스/완전탐색
 * Date : ??
 * User : theamabile@gmail.com
 */

package 프로그래머스.완전탐색.모의고사;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] supo1 = {1, 2, 3, 4, 5}; 
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 
        
        int[] scores = new int[3];
        
        for(int i=0 ; i<answers.length ; i++) {
            if( answers[i] == supo1[i%supo1.length] ) {
                scores[0]++;
            }
            
            if( answers[i] == supo2[i%supo2.length] ) {
                scores[1]++;
            }
            
            if( answers[i] == supo3[i%supo3.length] ) {
                scores[2]++;
            }
        }
        
        int max = Math.max( scores[0], Math.max(scores[1], scores[2]) );
        
        ArrayList<Integer> answerTemp = new ArrayList<>();
        if(scores[0] == max) {
            answerTemp.add(1);
        }
        if(scores[1] == max) {
            answerTemp.add(2);
        }
        if(scores[2] == max) {
            answerTemp.add(3);
        }
        
        answer = answerTemp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
}