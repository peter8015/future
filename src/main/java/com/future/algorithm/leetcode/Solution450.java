package com.future.algorithm.leetcode;


import com.future.algorithm.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * * 输出：[5,4,6,2,null,null,7]
 * * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * 链接：https://leetcode.cn/problems/delete-node-in-a-bst
 */
public class Solution450 {
    TreeNode root;

    /**
     * 递归解法：
     * 二叉搜索树（binary search tree BST）的特点是根节点的值大于左子节点的值小于右子节点的值。（val左 < val根 < val右）
     * 删除节点有三种情况：
     * 情况一：被删除节点只包含左子节点，用左子节点代替删除节点。
     * 情况二：被删除节点只包含右子节点，用右子节点代替删除节点。
     * 情况三：被删除节点包含左子节点和右子节点，根据BST特点，把左子节点放在右子节点下的左子节点位置，这种情况确定符合BST的特点。
     * <p>
     * 时间复杂度：O(n), n为节点个数
     * 空间复杂度：O(n)，n为节点个数
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        this.root = root;

        if (root == null) return null;

        root = delete(root, key);

        return root;
    }

    private TreeNode delete(TreeNode curr, int key) {
        if (root == null) {
            return null;
        }

        if (key > curr.val) {
            curr.right = delete(curr.right, key);
        } else if (key < curr.val) {
            curr.left = delete(curr.left, key);
        } else {
            if (curr.left == null || curr.right == null) {
                return curr.left == null ? curr.right : curr.left;
            }

            TreeNode temp = curr.left;
            while (temp.right != null) {
                temp = temp.right;
            }

            int val = temp.val;
            deleteNode(root, val);
            curr.val = val;
        }

        return curr;
    }


    @Test
    public void t1() {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t6.right = t7;

        TreeNode r = deleteNode(t5, 3);
        assertEquals(t2.val, r.left.val);

    }


}
