package com.liujin.code;

import java.util.HashMap;

//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
//用先序数组和中序数组重建一棵树(二叉树)
public class Code22_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode buildTree(int [] pre, int [] in){
        if (pre == null || in == null || pre.length != in.length){
            return null;
        }
        //每次都要通过循环去找in里面的头节点，所以我们提前把它全部给记好下一次需要就去里面拿
        HashMap<Integer,Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }
        return f(pre, 0, pre.length-1, in, 0, in.length-1, valueIndexMap);

    }
    public static TreeNode f(int [] pre, int L1, int R1, int [] in, int L2, int R2, HashMap<Integer,Integer> valueIndexMap){
        //有可能会出现一半树，另一半没有了如果继续下去就越界了
        if (L1 > R1){
            return null;
        }
        //在先序中第一个就是头节点
        TreeNode head = new TreeNode(pre[L1]);
        //有可能会出现两组数组中都只有一个头节点的情况
        if (L1 == R1){
            return head;
        }
        int find = valueIndexMap.get(pre[L1]);
        head.left = f(pre, L1+1, find+L1-L2, in, L2, find-1, valueIndexMap);
        head.right = f(pre, L1+find-L2+1, R1, in, find+1, R2, valueIndexMap);
        return head;

    }





}


