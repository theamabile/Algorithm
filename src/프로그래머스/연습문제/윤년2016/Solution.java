/**
 * KaKao Programmers / BaekJoon
 * Category : ���α׷��ӽ�.��������.����2016
 * Date : 2021. 4. 30.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.��������.����2016;

public class Solution {

	public static void main(String[] args) {
		String answer = "";
		String[] dow = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };

		int a = 1;
		int b = 1;

		int days = 0;
		if (a > 2) { // ������ 2���� ����
			int evenMonth = a / 2 - 1; // ¦���޿��� 2�� ����
			int oddMonth = (a / 2) + a % 2; // 1

			if (a % 2 == 1)
				--oddMonth;

			days = evenMonth * 30 + oddMonth * 31 + 29 + b;

			System.out.printf("evenMonth - %d / oddMonth-%d / days-%d \n ", evenMonth, oddMonth, days);

		} else {
			int evenMonth = a / 2;
			days = 31 * evenMonth + b;
		}

		System.out.printf("days : %d / %s \n", days, dow[(days-1)%7] );

	}

}
