/**
 * KaKao Programmers
 * Category : 프로그래머스.정렬.K번째수
 * Date : 2020. 09. 14
 * User : theamabile@gmail.com
 */
package 프로그래머스.정렬.K번째수;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
		for(int i=0; i<commands.length ; i++) {		// 한번 돌때마다 값 한번 찾음
			// 헷갈리니까 이해하기 쉽게 변수로 담아두기
			int startIndex = commands[i][0]-1;	 // 1		
			int endIndex = commands[i][1];
			int pick = commands[i][2] - 1;		// -1을 한 이유는 인덱스로 활용하기 위해서

			// 1. 분리해서 다른 배열에 넣기(정렬 하기 위함), 원본 훼손X
            System.out.printf("%d, %d", commands[i][0],commands[i][1]);
			int[] newArr = Arrays.copyOfRange(array, startIndex, endIndex);
            
			// 2. 정렬
			Arrays.sort(newArr);
			answer[i] = newArr[pick];		// cmd의 [i]번째의 두번째 원소가 갯수인데 배열은 index 형식으로 관리되기 때문에 -1해줌
		}
        
        return answer;
    }
}