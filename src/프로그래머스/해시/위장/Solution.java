/**
 * KaKao Programmers 
 * Category : ���α׷��ӽ�.�ؽ�.����
 * Date : 2021. 6. 12.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.�ؽ�.����;

import java.util.*;

class Solution {
  
    public int solution(String[][] clothes) {
        int answer = 1;
        int n = clothes.length;
        
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for(int i=0 ; i<n ; i++) {
            if(!hash.containsKey(clothes[i][1])) {
                hash.put(clothes[i][1], 1);     
            } else {
                int cnt = hash.get(clothes[i][1]);
                hash.put(clothes[i][1], ++cnt);
            }
        }
        
        int size = hash.size(); 

        if(size > 1) {
            for( String key : hash.keySet() ) {
                int cnt = hash.get(key) +1;
                answer *= cnt;
            }
            answer -= 1;            
        } else {
            answer = n;
        }
        
        return answer;
    }
   
}