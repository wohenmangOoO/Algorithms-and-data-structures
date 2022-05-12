package com.liujin.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
//二叉树按层遍历并收集节点
public class Code23_BinaryTreeLevelOrderTraversalll {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        //用一个队列把当前这一层装起来，这一层节点有多少个就需要找多少次当前这个节点的左数和右数也就是下一层
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(0,curAns);
        }
        return ans;
    }
}
