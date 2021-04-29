function solution(arr)
{
    var answer = [];
    
    let num = -1;
    for(let a of arr) {
        if(a == num) {
            continue;
        }  
        answer.push(a);
        num = a;
    }
    
    return answer;
}