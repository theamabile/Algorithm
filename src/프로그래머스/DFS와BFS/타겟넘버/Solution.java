/**
 * KaKao Programmers
 * Category : 프로그래머스.DFS와BFS.타겟넘버
 * Date : 2021. 4. 22.
 * User : theamabile@gmail.com
 */
package 프로그래머스.DFS와BFS.타겟넘버;


/*
사용할 수 있는 숫자가 담긴 배열 numbers,
타겟 넘버 target이 매개변수로 주어질 때 
숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
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