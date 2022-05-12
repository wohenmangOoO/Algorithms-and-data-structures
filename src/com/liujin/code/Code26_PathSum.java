package com.liujin.code;
// 测试链接：https://leetcode.com/problems/path-sum
//能否组成路径和
public class Code26_PathSum {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static boolean isSum = false;
    public static boolean hasPathSum(TreeNode root, int sum){
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }
    public static void process(TreeNode x, int preSum, int sum){
        //叶子结点
        if (x.left == null && x.right == null){
            if (x.val + preSum == sum){
                isSum = true;
            }
            return;
        }
        //非叶子结点
        preSum += x.val;
        if (x.left != null){
            process(x.left, preSum, sum);
        }
        if (x.right != null){
            process(x.right, preSum, sum);
        }
    }
}
