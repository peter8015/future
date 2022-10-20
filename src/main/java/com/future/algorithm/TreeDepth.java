package com.future.algorithm;

import org.junit.jupiter.api.Test;

public class TreeDepth {


    public int depth(TreeNode root) {
        if(root == null) {
            return 0;

        }

        int left = depth(root.left);
        int right = depth(root.right);

        return left >= right ? (left + 1) : (right + 1);
    }


    @Test
    public void t1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(depth(t1));

    }
}

