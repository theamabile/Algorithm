/**
 * KaKao Programmers / BaekJoon
 * Category : ���α׷��ӽ�.�����ڵ�ç����1.������������
 * Date : 2021. 4. 30.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.�����ڵ�ç����1.������������;

class Solution {
	public static void main(String[] args) {
		int n = 125;
        int answer = 0;
        int idx = 0;
        
        while(true) {
        	System.out.println(Math.pow(3, idx));
            if(n - (int)Math.pow(3, ++idx) <= 0)
                break;
        }
        
        int[] arr = new int[idx];
        System.out.println("idx:"+idx+"/arr.length:"+arr.length);
        
        int temp = n;
        for(int i=0 ; i<arr.length ; i++) {
            int pivot = (int)Math.pow(3, arr.length-(i+1));
            arr[i] = temp / pivot;
            temp = temp % pivot;
        }
        
        // 10�������� �ٲٱ�
        for(int i=0 ; i<arr.length ; i++) {
            answer += arr[i] * Math.pow(3, i);
        }
        
        System.out.println("\n answer:"+answer);
        
    }
}