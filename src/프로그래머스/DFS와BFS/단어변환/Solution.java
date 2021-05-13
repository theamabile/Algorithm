/**
 * KaKao Programmers / BaekJoon
 * Category : ���α׷��ӽ�.DFS��BFS.�ܾȯ
 * Date : 2021. 5. 13.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.DFS��BFS.�ܾȯ;

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    
    public static class Word implements Comparable<Word>{
        String word;
        int changeCnt;
        
        Word(String word, int changeCnt) {
            this.word = word;
            this.changeCnt = changeCnt;
        }
        
        @Override
		public int compareTo(Word w) {
			return w.changeCnt - this.changeCnt;
		}
        
        public int compareWords(String str) {
            if(word.equals(str))
                return word.length();
            char[] strChars = str.toCharArray();
            char[] wordChars = word.toCharArray();
            int result = 0;
            
            for(int i=0 ; i<strChars.length ; i++) {
                if(strChars[i] == wordChars[i]) {
                    result++;
                }
            }
            
            return result;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];      // �̹� �ٲ�� �ܾ�� �ݺ� �ȵ�����
        
        // 0. target ���ڰ� words�� �ִ��� �Ǻ�
        // 0-1. ������? �ٷ� ����. 0����
        boolean hasTarget = false;
        for(int i=0 ; i<words.length ; i++) {
            if(words[i].equals(target)) {
                hasTarget = true;
                visited[i] = true;
                break;
            }
        }
        
        if(!hasTarget)
            return 0;       // ��ȯ�� �� ������ 0�� ����
        

        PriorityQueue<Word> que = new PriorityQueue<Word>(Collections.reverseOrder());
         // 1. target�� Queue�� �߰�
        que.add( new Word(target, 0) );
        
        while(!que.isEmpty()) {
            Word current = que.poll();
            
            System.out.println("���� �ܾ� - " + current.word);
            // 1-1. �� �ܾ��� beginCnt�� begin.length-1�� ������? ����
            int beginCnt = current.compareWords(begin);
            if(beginCnt == begin.length()-1) {
                answer = current.changeCnt + 1;
                break;
            }
                
            
            // 2. que���� ������, �� �ܾ�� �ѱ��� �ٸ� �ܾ�(���� �ܾ�) ã��
            // 2-1. ���� �ܾ ���� beginCnt ���� ũ�� que�� �߰�
            // 2-2. ���� �ܾ��� idx�� �湮�ߴٰ� ǥ��
            // 2-3. ����++
            
            for(int i=0 ; i<words.length ; i++) {
                if(visited[i] == true)
                    continue;
                
                int sameCnt = current.compareWords(words[i]);
                if(sameCnt == words[i].length()-1) {
                    System.out.println("  > ť�� �߰� - " + words[i] + " / ��ġ�� ���ڼ� : "+sameCnt);
                    que.add(new Word(words[i], current.changeCnt + 1) );
                    visited[i] = true;
                }
            }
        }
       
        return answer;
    }
}

// System.out.println("���� �ܾ� = "+words[nextWordIdx] + " / idx : "+nextWordIdx);
            
/** begin ���ڼ� n * words length��ŭ �ݺ�
n-1, n-2, n-3 ... ���� ���ڰ� ���� �ܾ� ã��
��ȯ ���ϴ� ��� : target���ڰ� words�� ���� 

// 0. target ���ڰ� words�� �ִ��� �Ǻ�
// 0-1. ������? �ٷ� ����. 0����
// 1. ù �� �ܾ Queue�� �߰�
// 1-1. �� �ܾ target�� ������? ����
// 2. que���� ������, words���� �ش� �ܾ�� ��ġ�� ���ڼ��� ���� �ܾ� ã��
// 3. words�� �ش� �ܾ que�� �߰�
// 4. ���� ++
// 5.

// begin�� n-1�� ��ŭ ����, target�� 1�� ������
  words[i]�� ù��° ���ڰ� begin�� �ִ�?, target�� �ִ�?
// begin�� n-2�� ��ŭ ����, target�� 2�� ������
// begin�� n-3�� ��ŭ ����, target�� 3�� ������
// target�� ���� ������ ���ڼ��� �������� ����

// 2, 1, 0, 1, 0, 0
// 1, 

**/


/*

["hot",, "lot", "log"]
// ���� �ܾ�� �ѱ��� �ٲ� ��ȭ �Ҽ� �ִ� �ܾ� �� begin�� ���� ����� �ܾ� ã��
cog  (Ÿ�ٰ� 3���� ��ħ, begin�� 0�� ��ħ)     * � ��ġ���� �Ǵ� �ʿ�
  - dog (Ÿ�ٰ� 2���� ��ħ, begin�� 0�� ��ħ)
    - dot  (dog�� 2���� ��ħ, begin�� 1�� ��ħ) 
      - hot (dog�� 2���� ��ħ, begin�� 2�� ��ħ)     // begin.length-1 ��ŭ ��ġ�� ����
      = lot
    - log (dog�� 2���� ��ħ, begin�� 0�� ��ħ) 
  - log (Ÿ�ٰ� 2���� ��ħ)

// 0. target ���ڰ� words�� �ִ��� �Ǻ�
// 0-1. ������? �ٷ� ����. 0����
// 1. target�� Queue�� �߰�
// 1-1. �� �ܾ��� beginCnt�� begin.length-1�� ������? ����
// 2. que���� ������, �� �ܾ�� �ѱ��� �ٸ� �ܾ�(���� �ܾ�) ã��
// 2-1. ���� �ܾ ���� beginCnt ���� ũ�� que�� �߰�
// 2-2. ���� �ܾ��� idx�� �湮�ߴٰ� ǥ��
// 2-3. ����++




*/