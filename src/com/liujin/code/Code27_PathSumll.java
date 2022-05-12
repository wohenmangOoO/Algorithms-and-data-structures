package com.liujin.code;

import java.util.ArrayList;
import java.util.List;

// 测试链接：https://leetcode.com/problems/path-sum-ii
//收集达标路径和
public class Code27_PathSumll {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        process(root, path, 0, targetSum, ans);
        return ans;
    }
    public static void process(TreeNode x,List<Integer> path, int preSum, int sum, List<List<Integer>> ans ){
        //叶子结点
        if (x.left == null && x.right == null) {
            if (preSum + x.val == sum) {
                path.add(x.val);
                ans.add(copy(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        //非叶子结点
        //path要清理节点，因为path是引用传递，process是按值传递，函数调用他会复制一份给过去
        preSum += x.val;
        path.add(x.val);
        if (x.left != null){
            process(x.left, path, preSum, sum, ans);
        }
        if (x.right != null){
            process(x.right, path, preSum, sum, ans);
        }
        //清理节点
        path.remove(path.size()-1);
    }
    //拷贝路径
    public static List<Integer> copy(List<Integer> path){
        List<Integer> ans = new ArrayList<>();
        for (Integer cur : path) {
            ans.add(cur);
        }
        return ans;
    }
}
