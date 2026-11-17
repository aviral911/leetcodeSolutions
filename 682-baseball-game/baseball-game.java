class Solution {
    public int calPoints(String[] operations) { 
    Stack<Integer> st = new Stack<>();
    int a =0, b=0,sum=0;
    for(String s: operations){
        switch(s){
            case "+": a= st.pop(); b = st.peek(); st.push(a);st.push(a+b); break;
            case "D":  st.push(2*st.peek()); break;
            case "C": st.pop();break;
            default : st.push(Integer.parseInt(s));
     }
    }
    while(!st.isEmpty()){
        sum += st.pop();

    }
    return sum;
  }
 }