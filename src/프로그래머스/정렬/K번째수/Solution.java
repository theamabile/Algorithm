/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.����.K��°��
 * Date : 2020. 09. 14
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.����.K��°��;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
		for(int i=0; i<commands.length ; i++) {		// �ѹ� �������� �� �ѹ� ã��
			// �򰥸��ϱ� �����ϱ� ���� ������ ��Ƶα�
			int startIndex = commands[i][0]-1;	 // 1		
			int endIndex = commands[i][1];
			int pick = commands[i][2] - 1;		// -1�� �� ������ �ε����� Ȱ���ϱ� ���ؼ�

			// 1. �и��ؼ� �ٸ� �迭�� �ֱ�(���� �ϱ� ����), ���� �Ѽ�X
            System.out.printf("%d, %d", commands[i][0],commands[i][1]);
			int[] newArr = Arrays.copyOfRange(array, startIndex, endIndex);
            
			// 2. ����
			Arrays.sort(newArr);
			answer[i] = newArr[pick];		// cmd�� [i]��°�� �ι�° ���Ұ� �����ε� �迭�� index �������� �����Ǳ� ������ -1����
		}
        
        return answer;
    }
}