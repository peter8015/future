package com.future.algorithm.leetcode;

import com.future.algorithm.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution236 {


    /**
     * 递归解法：
     *
     * @param
     * @param p
     * @param q
     * @return
     */
    public int dfs(TreeNode root, TreeNode p, TreeNode q) {



        return 0;

    }

    private int lowestCommonAncer(TreeNode t3, int p, int q) {

        return 0;
    }

    //    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    @Test
    public void t1() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);

        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t1.left = t0;
        t1.right = t8;
        t2.left = t7;
        t2.right = t4;

        int p = 5, q = 1;

        int r = lowestCommonAncer(t3, p, q);
        assertEquals(3, r);
    }


}



