/**
 * KaKao Programmers 
 * Category : ���α׷��ӽ�.���ð�ť.�ֽİ���
 * Date : 2021. 5. 1.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.���ð�ť.�ֽİ���;

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