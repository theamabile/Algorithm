/**
 * KaKao Programmers
 * Category : 프로그래머스.동적계획법.N으로표현
 * Date : 2021. 6. 29.
 * User : theamabile@gmail.com
 */
package 프로그래머스.동적계획법.N으로표현;

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        
		// 배열 만들기
		for (int i = 0; i < 9; i++) { // 최소값이 8보다 크면 -1 리턴 하면됨(범위는 8개까지)
			list.add(new HashSet<Integer>());
		}

		HashSet<Integer> currentList;
		HashSet<Integer> leftList;
		HashSet<Integer> rightList;

		list.get(1).add(N);
		
		for(int i=2 ; i<9 ; i++) {
			currentList = list.get(i);
			
			for(int j=1 ; j <= i ; j++) {
				leftList = list.get(j);		
				rightList = list.get(i-j);
                
				for(int leftNum : leftList) {
					for(int rightNum : rightList) {
						currentList.add(leftNum + rightNum);
						currentList.add(leftNum - rightNum);
						currentList.add(leftNum * rightNum);
						if(leftNum != 0 && rightNum != 0) {
							currentList.add(leftNum / rightNum);
						}
					}
				}
			}
			
			// 55, 555와 같은 숫자 만들어주기
			int sum = 0;
			for(int k=0 ; k<i ; k++) {
				sum += N * Math.pow(10, k);
			}
			currentList.add(sum);
            
		}
		
		int answer = -1;
		for (int i = 1; i < list.size(); i++) {
			currentList = list.get(i);
			if(currentList.contains(number)) {
				answer = i;
				break;
			}			
		}
		
        return answer;
    }
}