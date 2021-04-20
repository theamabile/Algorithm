package ���α׷��ӽ�.����Ž��.�Ҽ�ã��;

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
        
        for(int i=1 ; i<=strArray.length ; i++) { // ���ڼ� ����. len�� 4�� 1, 2, 3, 4
            combi = new String[i];
            makeCombi(0, i, strArray.length);
        }
        
        // �ִ� 7�ڸ�, ����ī�� �ߺ� ��.
        
        
        return primeSet.size();
    }
    
    // start:�ڸ� ���� �ε���, end:�ڸ� �� �ε���
    public void makeCombi(int start, int end, int length){
        if(start == end) {
            // ���ڸ� �� ��������Ƿ� �Ҽ� �˻�
            findPrime();
        } else {
            for(int i=0 ; i<length ; i++) { // ���ڰ� 5, 1, 2, 0�̶�� �ش� �ڸ����� 4�� �־����
                if(!visited[i]) {       // ���� �ȵ鸰 ���ڸ�
                    visited[i] = true; 
                    combi[start] = strArray[i];
                    makeCombi(start+1, end, length);     // ���� �ڸ��� ������ַ�
                    visited[i] = false; 
                }
            }
        }
    }
    
    // �Ҽ��� set�� �߰�
    public void findPrime() {
        String temp = "";
        for(String c : combi) {
            temp += c;
        }
        int num = Integer.parseInt(temp);
        
        if(num <= 1 ) {     // 0�̳� 1�̸� �߰� ����
            return;
        }
        
        boolean isPrime = false;
        for(int i=2 ; i<=Math.sqrt(num) ; i++) {  // 36�̸�, 2<6   2,3,4,5,6  36/2
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