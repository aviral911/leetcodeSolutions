class Solution {
public boolean isAnagram(String s, String t) {
char a[]=s.toCharArray();
char b[]=t.toCharArray();
if(s.length()!=t.length()) return false;
for(int i=0;i<a.length;i++){
    boolean flag=false;
    for(int j=0;j<b.length;j++){
        if(a[i]==b[j]){
            b[j]= ' ';
               flag =true;
            break;
         }
      }
      if(flag == false) return false;
   }
   return true;
 }
}