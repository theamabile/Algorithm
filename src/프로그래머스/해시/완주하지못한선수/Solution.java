/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.�ؽ�.�����������Ѽ���
 * Date : 2021. 4. 5.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.�ؽ�.�����������Ѽ���;

import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);   // ����
        Arrays.sort(completion);    // ����
        
        for(int i=0 ; i<participant.length-1 ; i++) {
            if(participant[i].equals(completion[i]) == false) {     // ������ ���� ���� ���� ���� ���� �ְ� �ִ°�.
                answer = participant[i];
                break;
            }
        }
        
        if(answer.equals("")) { // ��ȸ�� �ߴµ��� ���������
            answer = participant[participant.length-1];
        }
        
        return answer;
    }
}