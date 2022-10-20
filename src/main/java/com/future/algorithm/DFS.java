package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * 深度优先搜索(deep first search): 用的是回溯思想，非常适合用递归。
 * 适合用栈来实现。
 */
public class DFS {
    @Test
    public void t1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        //1 2 4 5 3 6 7
        dfs(node1);
    }


    public void dfs(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }

        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if(!Objects.isNull(node.right)) {
                stack.push(node.right);
            }
            if(!Objects.isNull(node.left)) {
                stack.push(node.left);
            }
        }
    }



}



