/**
 * KaKao Programmers 
 * Category : 프로그래머스.스택과큐.주식가격
 * Date : 2021. 5. 1.
 * User : theamabile@gmail.com
 */
package 프로그래머스.스택과큐.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0 ; i<prices.length ; i++) {
            answer[i] = prices.length - i - 1; 
            for(int j=i+1 ; j<prices.length ; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                } 
            }
        }
                
        return answer;
    }
}