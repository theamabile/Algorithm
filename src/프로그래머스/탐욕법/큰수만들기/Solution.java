/**
 * KaKao Programmers / BaekJoon
 * Category : ���α׷��ӽ�.Ž���.ū�������
 * Date : 2021. 5. 23.
 * User : theamabile@gmail.com
 */
package ���α׷��ӽ�.Ž���.ū�������;

public class Solution {

}


/*
 * #include <iostream>
#include <string>
#include <vector>
#include <algorithm>    //sort �Լ�

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
            number.erase(number.begin(), number.begin()+j);     // ���ڿ����� �����
        }
    }
    
    cout << "answer : " << number << endl;
    
     // ���� �־� �ϴ� ���ڸ� ������ �տ��� �� �����
//         if( number.at(j) > mid) {
//             for(int n=0 ; n<j ; n++) {
//                 number.erase(n, 1);     // ���ڿ����� �����
//                 cout << "����� �� �� : " << number << endl;
               
//                 //cnt++;
//             }
//         }
    
    return number;
}


/*
1. ���� ū �� 
pivot = 1; 1 <> 2  //1231234
pivot = 2; 2 <> 3  //231234
pivot = 3; 3 <> 1  //31234

1 9 2 4
4 1 3 2

1 2 3 1 2 3 4
7 6 5 7 6 5 4

1231234
12 ����  k>1������  31234

4177252841 : 41 ����   k>2������  77252841
77252841 : i=1���� 2 ����   k>1������   7752841
7752841  : i=2���� 2 ����  k>0�� ����(����) 775841 

6�ڸ�


4�� 
*/
