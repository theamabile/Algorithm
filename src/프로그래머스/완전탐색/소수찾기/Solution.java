package 프로그래머스.완전탐색.소수찾기;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public String[] strArray;
    public String[] combi;
    public boolean[] visited;
    public Set<Integer> primeSet;
    
    public int solution(String numbers) {
        int answer = 0;
        
        strArray = numbers.split("");
        visited = new boolean[strArray.length];
        primeSet = new HashSet<>();
        
        for(int i=1 ; i<=strArray.length ; i++) { // 글자수 조합. len이 4면 1, 2, 3, 4
            combi = new String[i];
            makeCombi(0, i, strArray.length);
        }
        
        // 최대 7자리, 숫자카드 중복 됨.
        
        
        return primeSet.size();
    }
    
    // start:자리 시작 인덱스, end:자리 끝 인덱스
    public void makeCombi(int start, int end, int length){
        if(start == end) {
            // 숫자를 다 만들었으므로 소수 검사
            findPrime();
        } else {
            for(int i=0 ; i<length ; i++) { // 숫자가 5, 1, 2, 0이라면 해당 자리수로 4번 넣어볼거임
                if(!visited[i]) {       // 아직 안들린 숫자면
                    visited[i] = true; 
                    combi[start] = strArray[i];
                    makeCombi(start+1, end, length);     // 다음 자릿수 만들어주렴
                    visited[i] = false; 
                }
            }
        }
    }
    
    // 소수면 set에 추가
    public void findPrime() {
        String temp = "";
        for(String c : combi) {
            temp += c;
        }
        int num = Integer.parseInt(temp);
        
        if(num <= 1 ) {     // 0이나 1이면 추가 안함
            return;
        }
        
        boolean isPrime = false;
        for(int i=2 ; i<=Math.sqrt(num) ; i++) {  // 36이면, 2<6   2,3,4,5,6  36/2
            if(num%i == 0) {
                isPrime = true;
                break;
            }
        }
        
        if(!isPrime) {
            primeSet.add(num);
        }
        
    }
    
}