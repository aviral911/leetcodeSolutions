class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
int[] nums3 = new int[m + n];
              for (int i = 0; i < m; i++) {
    nums3[i]=nums1[i];
}
for (int j = 0; j < n; j++) {
    nums3[m+j] = nums2[j];
}
  Arrays.sort(nums3);
  for(int i=0;i<nums3.length;i++){
    nums1[i]=nums3[i];
  }
    }
}