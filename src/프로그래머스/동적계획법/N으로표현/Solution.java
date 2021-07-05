/**
 * KaKao Programmers
 * Category : 프로그래머스.동적계획법.N으로표현
 * Date : 2021. 6. 29.
 * User : theamabile@gmail.com
 */
package 프로그래머스.동적계획법.N으로표현;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		int N = 2;
		int number = 11;
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		// number가 N의 숫자조합으로 이루어졌는지 판단 NN or NNNN

		// 배열 만들기
		for (int i = 0; i < 9; i++) { // 최소값이 8보다 크면 -1 리턴 하면됨(범위는 8개까지)
			list.add(new ArrayList<Integer>());
		}
		

//		ArrayList<Integer> currentList = list.get(1);
//		ArrayList<Integer> prevList = list.get(0);
//		int j = 0;
//		int num = N;

		ArrayList<Integer> currentList;
		ArrayList<Integer> leftList;
		ArrayList<Integer> rightList;

		list.get(1).add(N);
		
		for(int i = 2; i < 5 ; i++) { // 1번방은 N이 1개 쓰인 값들로 이루어져 있으므로 그 다음부터 시작
			currentList = list.get(i);
			
			for(int j=1 ; j <= i ; j++) {
				leftList = list.get(j);		// i가 2면, [1, 2](0,1), [] ()
				rightList = list.get(i-j);

				System.out.println(i + "개 사용 --------------- left index : "+j+"("+leftList.size()+")"+" / right index : "+(i-j)+"("+rightList.size()+")");
				
				for(int n=0 ; n<leftList.size() ; n++) {
					int leftNum = leftList.get(n);

					for(int m=0 ; m<rightList.size() ; m++) {
						int rightNum = rightList.get(m);

						System.out.println(i+" *** "+ n + " - leftNum : "+leftNum+" /// "+ m +" - rightNum : "+rightNum);
				
						if(rightNum == 60) {
							System.out.println(" + :"+(leftNum + rightNum));
							System.out.println(" - :"+(leftNum - rightNum));
							System.out.println(" * :"+(leftNum * rightNum));
							System.out.println(" / :"+(leftNum / rightNum));
						}
						currentList.add(leftNum + rightNum);
						currentList.add(leftNum - rightNum);
						currentList.add(leftNum * rightNum);
						if(leftNum != 0 && rightNum != 0) {
							currentList.add(leftNum / rightNum);
						}
					}
				}
				//System.out.println("--------------- left size : "+leftList.size()+" / right size : "+rightList.size());
			}
			
			// 55, 555와 같은 숫자 만들어주기
			int sum = 0;
			for(int k=0 ; k<i ; k++) {
				sum += N * Math.pow(10, k);
			}
			currentList.add(sum);
			
		}

		//System.out.println("list size : "+list.size());
			//System.out.println(i+" / size : "+currentList.size());
		
		int answer = -1;
		for (int i = 1; i < list.size(); i++) {
			currentList = list.get(i);
			for(int a : currentList) {
				System.out.println(i+" > "+a);
			}
			if(currentList.contains(number)) {
				answer = i;
				break;
			}			
		}

		System.out.println(answer);
		
		
	}

}


/*
 * j : 1 / prev size : 1
j : 5 / prev size : 5
j : 25 / prev size : 25
j : 125 / prev size : 125
j : 625 / prev size : 625
j : 3125 / prev size : 3125
j : 15625 / prev size : 15625
 * 
 * */