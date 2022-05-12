package com.liujin.code;
// 测试链接：https://leetcode.com/problems/same-tree
//二叉树 判断两棵树结构是否相同
public class Code19_SameTree {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        // 都不为空
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

