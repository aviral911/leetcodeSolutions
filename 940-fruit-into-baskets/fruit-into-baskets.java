class Solution {
    public int totalFruit(int[] fruits) {
        int max=0;
        int n=fruits.length;
        int s=0,e=0;
        int fr[]=new int[n];
        int type=0;
        while(e<n){
            int ft =fruits[e];
            // include or expand
            if(fr[ft]==0)type++;
            fr[ft]++;

            // shrink
            while(type > 2){
                int sft = fruits[s];
                fr[sft]--;
                if(fr[sft]  == 0 )type--;
                s++;
            }

            int size = e-s +1;
            max = Math.max(max,size);
            e++;
        }
        return max;
    }
}