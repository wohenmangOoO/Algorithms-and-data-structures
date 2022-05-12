package com.liujin.code;
//判断是否是搜索二叉树
public class Code25_IsBinaraySearchTree {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isValidBST(TreeNode root) {

        return process(root).isBST;
    }
    public static class Info{
        public boolean isBST;
        public int max;
        public int min;
        Info(boolean isBST, int max, int min){
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
    public static Info process(TreeNode x){
        /**不能返回0，如果返回0就乱了你最小值最大值都是0
         *  假如你x是-5 左边最大值0<-5 右边最小值 -5<0 ，条件不成立
         *  本来应该是搜索树的，因为0导致搜索树不成立，所以我们返回空交给上一层来判断处理*/
        if (x == null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        if (leftInfo != null){
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null){
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isBST = true;
        //如果isBST是搜索树就是true不是false 改成！是的话就进不去false不是就进去true
        if (leftInfo != null && !leftInfo.isBST){
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST){
            isBST = false;
        }
        //leftMax < x   rightMin > x  来决定是否是搜索树
        boolean leftMax = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMin = rightInfo == null ? true : (rightInfo.min > x.val);
        if (!leftMax || !rightMin){
            isBST = false;
        }
        return new Info(isBST, max, min);
    }


}

