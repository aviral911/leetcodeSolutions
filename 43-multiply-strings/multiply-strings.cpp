class Solution {
public:
    string multiply(string num1, string num2) {
        int prod = 1,m = num1.size(),n=num2.size(),sum= 0;
        vector<int> res(m+n);
        for(int i = m-1;i >= 0;i --){
            for(int j = n-1;j >= 0;j --){
                prod = (num1[i]-'0')*(num2[j]-'0');
                int p1 = i+j, p2 = i+j+1;
                sum = prod + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        string str= "";
        for(int i = 0;i < res.size();i++){
            if(!(res[i]==0 && str.length()==0)){
                str+=to_string(res[i]);
            }
        }
        return str.length() == 0? "0" : str;
    }
};