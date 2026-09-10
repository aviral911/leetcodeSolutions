class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0}; // {sum, count}
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        int avg = sum / count;

        if (avg == node.val) {
            ans++;
        }

        return new int[]{sum, count};
    }
}