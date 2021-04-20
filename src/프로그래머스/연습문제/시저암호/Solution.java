/**
 * KaKao Programmers / BaekJoon
 * Category : 프로그래머스.연습문제.시저암호
 * Date : 2020. 9. 18.
 * User : theamabile@gmail.com
 */
package 프로그래머스.연습문제.시저암호;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
       char[] charArr = s.toCharArray();
		char[] resultChar = new char[charArr.length];
		
		for(int i=0 ; i<charArr.length ; i++) {
			if(charArr[i] == ' ') {		// 공백이면 패스
				resultChar[i] = charArr[i];
			} else {
				int code = 0;
				int pivotCode = 'A';
				if(Character.isLowerCase(charArr[i])) {
					pivotCode = 'a';
				}  
				
				int startDis = (int)(charArr[i] + n) - pivotCode; 	// 'A'와 떨어져 있는 거리를 구함
				
				// 만약 'A'와 떨어져있는 거리가 25을 초과하여 다른 문자를 가르키면 안되기 때문에 %로 나누어 처리함.
				code = pivotCode + (startDis % 26);			// 26은 알파벳 갯수
					
				char moveChar = (char)code;
				resultChar[i] = moveChar;
			}
		}

		answer = String.valueOf(resultChar);
        
        return answer;
    }
}