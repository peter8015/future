package com.future.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * 广度优先搜索（breath first search）：通俗的讲，就是一种地毯式的层层推进，从顶点开始，依次往外遍历。
 * 适合用队列来实现。
 */
public class BFS {

    @Test
    public void t1() {

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);


        //1 2 3 4 5 6 7
        bfs(node1);
    }

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static <T> T requireNonNull(T obj) {
        if(obj == null)
            throw new NullPointerException();
        return obj;
    }

    /**
     * 记忆法和费曼学习法
     *
     * bfs：广度优先遍历，通俗一点讲就是一种地毯式的遍历方法，适合用队列来实现。
     * 就像扫荡一样。
     * @param root
     */
    public void bfs(TreeNode root) {
        if(!Objects.isNull(root)) {
            return;
        }

    }

}


