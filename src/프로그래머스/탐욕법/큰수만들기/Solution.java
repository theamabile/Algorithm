/**
 * KaKao Programmers / BaekJoon
 * Category : 프로그래머스.탐욕법.큰수만들기
 * Date : 2021. 5. 23.
 * User : theamabile@gmail.com
 */
package 프로그래머스.탐욕법.큰수만들기;

public class Solution {

}


/*
 * #include <iostream>
#include <string>
#include <vector>
#include <algorithm>    //sort 함수

using namespace std;

string solution(string number, int k) {
    string answer = "";
    
    // char cstr[number.length()];
    // int i = 0;
    // for(int i=0 ; i<number.length() ; i++) {
    //     cstr[i] = number.at(i);
    //     cout << number.substr(i, 1) << endl;
    // 
    
    vector<char> cstr;
    for(int i=0 ; i<number.length() ; i++) {
        cstr.push_back(number.at(i));
    }
    sort(cstr.begin(), cstr.end());
    
    char max = cstr[cstr.size()-1];
    char mid = cstr[k];
    
    cout << "max : " << max << " / mid : " << mid << endl;

    for(int j=0 ; j<k; j++) {
        if(number.at(j) <= mid ) {
            
            cout << "number.at(j) : " << number.at(j) << endl;
            number.erase(number.begin(), number.begin()+j);     // 문자열에서 지우기
        }
    }
    
    cout << "answer : " << number << endl;
    
     // 남겨 둬야 하는 숫자를 만나면 앞에꺼 다 지우기
//         if( number.at(j) > mid) {
//             for(int n=0 ; n<j ; n++) {
//                 number.erase(n, 1);     // 문자열에서 지우기
//                 cout << "지우고 난 후 : " << number << endl;
               
//                 //cnt++;
//             }
//         }
    
    return number;
}


/*
1. 제일 큰 수 
pivot = 1; 1 <> 2  //1231234
pivot = 2; 2 <> 3  //231234
pivot = 3; 3 <> 1  //31234

1 9 2 4
4 1 3 2

1 2 3 1 2 3 4
7 6 5 7 6 5 4

1231234
12 제거  k>1개남음  31234

4177252841 : 41 제거   k>2개남음  77252841
77252841 : i=1부터 2 제거   k>1개남음   7752841
7752841  : i=2부터 2 제거  k>0개 남음(종료) 775841 

6자리


4개 
*/
