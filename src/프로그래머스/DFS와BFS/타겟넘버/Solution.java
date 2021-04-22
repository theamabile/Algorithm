/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.DFS��BFS.Ÿ�ٳѹ�
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.DFS��BFS.Ÿ�ٳѹ�;


/*
����� �� �ִ� ���ڰ� ��� �迭 numbers,
Ÿ�� �ѹ� target�� �Ű������� �־��� �� 
���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
*/
class Solution {
    
    int cnt;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        DFS(0, +numbers[0]);
        DFS(0, -numbers[0]);
        
        answer = cnt;
       
        return answer;
    }
   
    
    public void DFS(int index, int value) {
        if(index >= numbers.length-1) {
            if(value == target) {
                ++cnt;
            }
            return;
        }
        
        ++index;
        
        DFS(index, value + numbers[index]);
        DFS(index, value - numbers[index]);
    }
    
}