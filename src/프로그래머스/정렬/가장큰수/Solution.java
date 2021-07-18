/**
 * KaKao Programmers
 * Category : 프로그래머스.정렬.가장큰수
 * Date : 2021. 7. 18.
 * User : theamabile@gmail.com
 */
package 프로그래머스.정렬.가장큰수;

import java.util.*;
import java.util.Collections;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int[] tempNumbers = new int[numbers.length];
        
        int sum = 0;
        for(int i=0 ; i<numbers.length ; i++) {
            sum += numbers[i];
        }
        if(sum == 0) {
            return "0";
        }
        
        
		for(int i=0 ; i<numbers.length ; i++) {
            String str = String.valueOf(numbers[i]);
            StringBuffer sb = new StringBuffer();
			
			while(sb.length() < 4) {
				sb.append(str);
			}
			
			if(sb.length() > 4) {
				tempNumbers[i] = Integer.parseInt(sb.toString().substring(0, 4));
			} else {
				tempNumbers[i] = Integer.parseInt(sb.toString());
			}
		}
		
		
		int temp = 0;
		for(int i=0 ; i<numbers.length ; i++) {
			int max = tempNumbers[i];
			for(int j=i+1 ; j<numbers.length ; j++) {
				if(max < tempNumbers[j]) {
					max = tempNumbers[j];
					
					// 자리 바꾸기
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
					
					temp = tempNumbers[i];
					tempNumbers[i] = tempNumbers[j];
					tempNumbers[j] = temp;
				}
			}
		}
        
        StringBuffer sb = new StringBuffer();
        for(int i=0 ; i<numbers.length ; i++) {
            sb.append(String.valueOf(numbers[i]));
        }
        
        
        return sb.toString();
    }
}
