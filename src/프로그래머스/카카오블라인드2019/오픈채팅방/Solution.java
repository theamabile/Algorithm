/**
 * KaKao Programmers
 * Category : 프로그래머스.카카오블라인드2019.오픈채팅방
 * Date : 2021. 8. 7.
 * User : theamabile@gmail.com
 */
package 프로그래머스.카카오블라인드2019.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nickNames = new HashMap<String, String>();
        ArrayList<String> log = new ArrayList<String>();
        
        for(int i=0 ; i<record.length ; i++) {
            StringBuffer sb = new StringBuffer();
        
            String[] recordSplits = record[i].split(" ");
            String cmd = recordSplits[0].toLowerCase();
            String uid = recordSplits[1];
            
            if(recordSplits.length == 2) {      // Leave
                // 로그 추가
                sb.append(uid);
                sb.append("/님이 나갔습니다.");
                log.add(sb.toString());
                continue;
            }
            
            String nickName = recordSplits[2];
            if(cmd.equals("enter")) {
                nickNames.put(uid, nickName);

                sb.append(uid);
                sb.append("/님이 들어왔습니다.");
                log.add(sb.toString());
            } else if(cmd.equals("change")) {
                nickNames.put(uid, nickName);
            }
        }
        
        String[] answer = new String[log.size()];
        for(int i=0 ; i<answer.length ; i++) {
            StringBuffer sb = new StringBuffer();
            String[] logSplit = log.get(i).split("/");
            String nickName = nickNames.get(logSplit[0]);
            
            sb.append(nickName);
            sb.append(logSplit[1]);
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}