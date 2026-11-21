class Solution {
    public int calPoints(String[] operations) { 
    Stack<Integer> st = new Stack<>();
    for(int i=0;i<operations.length;i++){
        String op = operations[i];
        if(op.equals("C")){
            st.pop();
        }
      else  if(op.equals("D")){
            st.push(st.peek()*2);
        }
else if(op.equals("+")){
      int last = st.pop();
      int sec = st.peek();
      st.push(last);
      st.push(sec+last);
        }
        else{
            st.push(Integer.parseInt(op));
        }
    }
    int sum=0;
    while (!st.isEmpty()){
        sum+= st.pop();
    }
    return sum;

  }
 }