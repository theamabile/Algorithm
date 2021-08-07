/**
 * KaKao Programmers
 * Category : ���α׷��ӽ�.īī������ε�2019.����ä�ù�
 * Date : 2021. 8. 7.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.īī������ε�2019.����ä�ù�;

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
                // �α� �߰�
                sb.append(uid);
                sb.append("/���� �������ϴ�.");
                log.add(sb.toString());
                continue;
            }
            
            String nickName = recordSplits[2];
            if(cmd.equals("enter")) {
                nickNames.put(uid, nickName);

                sb.append(uid);
                sb.append("/���� ���Խ��ϴ�.");
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