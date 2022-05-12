package com.liujin.code;
// 测试链接：https://leetcode.com/problems/balanced-binary-tree
//判断一棵树是否是平衡二叉树
public class Code24_BalancedBinaryTree {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static class Info {
        public boolean isBalanced;
        public int height;
        Info(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }
    public static Info process(TreeNode root){
        //如果为空的话，说明没有子节点是平衡，高度为0
        if (root == null){
            return new Info(true,0);
        }
        //root != null
        Info laftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(laftInfo.height, rightInfo.height)+1;
        boolean isBalanced = laftInfo.isBalanced && rightInfo.isBalanced && Math.abs(laftInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, height);
    }

}

