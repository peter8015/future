package com.future.algorithm.jianzhi;

import com.future.algorithm.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllOthers {


    @Test
    public void t1() {
        TreeNode root = generateTree("");
        TreeNode rootA = generateTree("a");
        TreeNode rootMirror = generateTree("mirror");

        //求⼆叉树的最⼩深度

        //求树中节点个数
        assertEquals(7, numOfTreeNode(root));
        //求树中叶子节点个数
        assertEquals(4, numOfChildNode(root));
        //求树中第k层节点的个数
        int k = 3;
        assertEquals(4, numOfLevelNode(root, k));
        //完全二叉树
        //平衡二叉树
        //二叉查找树
        //求两个二叉树是否完全相同
        assertTrue(isSameTree(root, root));
        assertFalse(isSameTree(root, rootA));
        //互为镜像
        assertTrue(isMirror(root, rootMirror));
        assertFalse(isMirror(root, rootA));
        //前中后序遍历
        //判断合法的二叉查找树
    }


    @Test
    public void t2() {
        int k = 1;

        System.out.println(++k);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }

        if(t1.val != t2.val) {
            return false;
        }

        boolean left = isMirror(t1.left, t2.right);
        boolean right = isMirror(t1.right, t2.left);

        return left && right;
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        }

        if((a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        boolean left = isSameTree(a.left, b.left);
        boolean right = isSameTree(a.right, b.right);

        return left && right;
    }

    public TreeNode generateTree(String flag) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);



        if(flag.equals("a")) {
            t1.left = t2;
            t1.right = t3;
            t2.left = t4;
            t2.right = t5;
            t3.left = t6;
            t3.right = t7;
            t4.left = t8;
        } if (flag.equals("mirror")) {
            t1.left = t3;
            t1.right = t2;
            t3.left = t7;
            t3.right = t6;
            t2.left = t5;
            t2.right = t4;
        } else {
            t1.left = t2;
            t1.right = t3;
            t2.left = t4;
            t2.right = t5;
            t3.left = t6;
            t3.right = t7;
        }
        return t1;
    }


    //求树中节点个数
    public int numOfTreeNode(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);


        return left + right + 1;
    }

    //求二叉树中叶子节点个数
    int numOfChildNode(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        int left = numOfChildNode(root.left);
        int right = numOfChildNode(root.right);

        return left + right;
    }


    //求二叉树中第level层节点的个数
    public int numOfLevelNode(TreeNode root, int level) {
        if(root == null || level < 1) {
            return 0;
        }

        if(level == 1) {
            return 1;
        }

        int left = numOfLevelNode(root.left, level - 1);
        int right = numOfLevelNode(root.right, level - 1);

        return left + right;
    }
}
