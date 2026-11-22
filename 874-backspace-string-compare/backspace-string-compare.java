class Solution {
     public boolean backspaceCompare(String S, String T) {
    Stack<Character> st = new Stack<>();
    Stack<Character> st2 = new Stack<>();
    for(int i=0;i<S.length();i++){
        char ch = S.charAt(i);
        if(ch == '#'){
            if(!st.isEmpty()){
            st.pop();
        }}
        else{
            st.push(ch);
        }
    }
 for(int i=0;i<T.length();i++){
        char ch = T.charAt(i);
        if(ch =='#'){
          if(!st2.isEmpty()){
            st2.pop();
        }}
        else{
            st2.push(ch);
        }
    }
        return st.equals(st2);

    }
}