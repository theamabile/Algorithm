/**
 * KaKao Programmers / BaekJoon
 * Category : ���α׷��ӽ�.��������.������ȣ
 * Date : 2020. 9. 18.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.��������.������ȣ;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
       char[] charArr = s.toCharArray();
		char[] resultChar = new char[charArr.length];
		
		for(int i=0 ; i<charArr.length ; i++) {
			if(charArr[i] == ' ') {		// �����̸� �н�
				resultChar[i] = charArr[i];
			} else {
				int code = 0;
				int pivotCode = 'A';
				if(Character.isLowerCase(charArr[i])) {
					pivotCode = 'a';
				}  
				
				int startDis = (int)(charArr[i] + n) - pivotCode; 	// 'A'�� ������ �ִ� �Ÿ��� ����
				
				// ���� 'A'�� �������ִ� �Ÿ��� 25�� �ʰ��Ͽ� �ٸ� ���ڸ� ����Ű�� �ȵǱ� ������ %�� ������ ó����.
				code = pivotCode + (startDis % 26);			// 26�� ���ĺ� ����
					
				char moveChar = (char)code;
				resultChar[i] = moveChar;
			}
		}

		answer = String.valueOf(resultChar);
        
        return answer;
    }
}