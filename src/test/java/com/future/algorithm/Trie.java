package com.future.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 链接：https://leetcode.cn/problems/implement-trie-prefix-tree
 * 复杂度分析
 *
 * 时间复杂度：初始化为 O(1)O(1)，其余操作为 O(|S|)O(∣S∣)，其中 |S|∣S∣ 是每次插入或查询的字符串的长度。
 * 空间复杂度：O(|T|\cdot\Sigma)O(∣T∣⋅Σ)，其中 |T|∣T∣ 为所有插入字符串的长度之和，\SigmaΣ 为字符集的大小，本题 \Sigma=26Σ=26。
 * timers 7
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.isWord = false;
    }

    @Test
    public void t1() {
        Trie trie = new Trie();

        trie.insert("abc");
        trie.insert("abcd");

        assertTrue(trie.search("abc"));
        assertFalse(trie.search("abcde"));
        assertTrue(trie.startWith("ab"));
        assertFalse(trie.startWith("abe"));
    }

    public void insert(String word) {
        TrieNode current = root;
        int len = word.length();

        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
                current.children[index].isWord = false;
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);

        return node != null && node.isWord;
    }

    public boolean startWith(String word) {
        return find(word) != null;
    }

    private TrieNode find(String prefix) {
        TrieNode current = root;
        int len = prefix.length();

        for (int i = 0; i < len; i++) {
            int index = prefix.charAt(i) - 'a';
            if ((current = current.children[index]) == null) {
                return null;
            }
        }
        return current;
    }


}


class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}