package com.future.algorithm.leetcode;


import com.future.algorithm.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 输入：root = [1,2,3,4,5]
 * 输出：[4,2,5,1,3]
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class Solution94 {

    @Test
    public void t1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
//
//        List<Integer> r = inorderTraverse(t1);
//        assertEquals(4, r.get(0).intValue());
//        assertEquals(5, r.get(2).intValue());


        List<Integer> r = inorderTra(t1);
        assertEquals(4, r.get(0).intValue());
        assertEquals(5, r.get(2).intValue());

    }

    /**
     * 递归实现
     * 代码简单，时间复杂度高，会有重复计算
     * 一般有两个方法来实现，内嵌的方法用于递归
     * 时间复杂度：O(n), n为二叉树节点个数
     * 空间复杂度：O(n)，递归的栈的深度
     * @param root
     * @return
     */
    private List<Integer> inorderTraverse(TreeNode root) {
        List<Integer> r = new ArrayList();
        if (root == null) { return r; }

        inorder(root, r);

        return r;
    }

    private void inorder(TreeNode root, List<Integer> r) {
        if (root == null) {
            return;
        }
        inorder(root.left, r);
        r.add(root.val);
        inorder(root.right, r);
    }

    /**
     * 迭代实现
     * 中序遍历的特点：left root right
     * 根据中序遍历的特点，把left遍历完再反向拿出，用stack来存储。
     * 然后在pop出依次进行处理
     *
     */
    @Deprecated
    public List<Integer> inorderTra1(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> r = new ArrayList();
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;

        while (curr != null && !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            TreeNode node = s.pop();
            r.add(node.val);

            curr = node.right;
        }
        return r;
    }


    public List<Integer> inorderTra(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);

            curr = node.right;
        }
        return res;
    }






















}
