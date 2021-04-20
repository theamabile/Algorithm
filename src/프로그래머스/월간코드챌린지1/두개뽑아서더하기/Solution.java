/**
 * KaKao Programmers / BaekJoon
 * Category : 프로그래머스.월간코드챌린지1
 * Date : 2021. 4. 7.
 * User : theamabile@gmail.com
 */
package 프로그래머스.월간코드챌린지1.두개뽑아서더하기;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0 ; i<numbers.length-1 ; i++) {
            for(int j=i+1 ; j<numbers.length ; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        
        // int index = 0;
        // answer = new int[set.size()];
        // for(Integer s : set) {
        //     answer[index++] = s;            
        // }
        answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}