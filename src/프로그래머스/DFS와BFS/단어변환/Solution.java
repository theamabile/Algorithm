/**
 * KaKao Programmers / BaekJoon
 * Category : 프로그래머스.DFS와BFS.단어변환
 * Date : 2021. 5. 13.
 * User : theamabile@gmail.com
 */
package 프로그래머스.DFS와BFS.단어변환;

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
        boolean[] visited = new boolean[words.length];      // 이미 바꿨던 단어면 반복 안돌거임
        
        // 0. target 글자가 words에 있는지 판별
        // 0-1. 없으면? 바로 종료. 0리턴
        boolean hasTarget = false;
        for(int i=0 ; i<words.length ; i++) {
            if(words[i].equals(target)) {
                hasTarget = true;
                visited[i] = true;
                break;
            }
        }
        
        if(!hasTarget)
            return 0;       // 변환할 수 없으면 0을 리턴
        

        PriorityQueue<Word> que = new PriorityQueue<Word>(Collections.reverseOrder());
         // 1. target을 Queue에 추가
        que.add( new Word(target, 0) );
        
        while(!que.isEmpty()) {
            Word current = que.poll();
            
            System.out.println("현재 단어 - " + current.word);
            // 1-1. 비교 단어의 beginCnt가 begin.length-1과 같으면? 종료
            int beginCnt = current.compareWords(begin);
            if(beginCnt == begin.length()-1) {
                answer = current.changeCnt + 1;
                break;
            }
                
            
            // 2. que에서 빼오고, 비교 단어와 한글자 다른 단어(다음 단어) 찾기
            // 2-1. 다음 단어가 현재 beginCnt 보다 크면 que에 추가
            // 2-2. 현재 단어의 idx를 방문했다고 표시
            // 2-3. 과정++
            
            for(int i=0 ; i<words.length ; i++) {
                if(visited[i] == true)
                    continue;
                
                int sameCnt = current.compareWords(words[i]);
                if(sameCnt == words[i].length()-1) {
                    System.out.println("  > 큐에 추가 - " + words[i] + " / 겹치는 글자수 : "+sameCnt);
                    que.add(new Word(words[i], current.changeCnt + 1) );
                    visited[i] = true;
                }
            }
        }
       
        return answer;
    }
}

// System.out.println("다음 단어 = "+words[nextWordIdx] + " / idx : "+nextWordIdx);
            
/** begin 글자수 n * words length만큼 반복
n-1, n-2, n-3 ... 개의 문자가 같은 단어 찾기
변환 못하는 경우 : target문자가 words에 없음 

// 0. target 글자가 words에 있는지 판별
// 0-1. 없으면? 바로 종료. 0리턴
// 1. 첫 비교 단어를 Queue에 추가
// 1-1. 비교 단어가 target과 같으면? 종료
// 2. que에서 빼오고, words에서 해당 단어와 겹치는 글자수가 많은 단어 찾기
// 3. words의 해당 단어를 que에 추가
// 4. 과정 ++
// 5.

// begin과 n-1개 만큼 같고, target과 1개 같은거
  words[i]의 첫번째 글자가 begin에 있니?, target에 있니?
// begin과 n-2개 만큼 같고, target과 2개 같은거
// begin과 n-3개 만큼 같고, target과 3개 같은거
// target과 같은 갯수가 글자수와 같아지면 종료

// 2, 1, 0, 1, 0, 0
// 1, 

**/


/*

["hot",, "lot", "log"]
// 현재 단어에서 한글자 바꿔 변화 할수 있는 단어 중 begin과 가장 비슷한 단어 찾기
cog  (타겟과 3글자 겹침, begin과 0개 겹침)     * 몇개 겹치는지 판단 필요
  - dog (타겟과 2글자 겹침, begin과 0개 겹침)
    - dot  (dog와 2글자 겹침, begin과 1개 겹침) 
      - hot (dog와 2글자 겹침, begin과 2개 겹침)     // begin.length-1 만큼 겹치면 종료
      = lot
    - log (dog와 2글자 겹침, begin과 0개 겹침) 
  - log (타겟과 2글자 겹침)

// 0. target 글자가 words에 있는지 판별
// 0-1. 없으면? 바로 종료. 0리턴
// 1. target을 Queue에 추가
// 1-1. 비교 단어의 beginCnt가 begin.length-1과 같으면? 종료
// 2. que에서 빼오고, 비교 단어와 한글자 다른 단어(다음 단어) 찾기
// 2-1. 다음 단어가 현재 beginCnt 보다 크면 que에 추가
// 2-2. 현재 단어의 idx를 방문했다고 표시
// 2-3. 과정++




*/