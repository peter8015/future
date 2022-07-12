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
        trie.insert("abd");
        trie.insert("abcde");

        assertTrue(trie.search("abd"));
        assertFalse(trie.search("abdc"));
        assertTrue(trie.startWith("abc"));
        assertFalse(trie.startWith("abh"));
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

    public boolean startWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String word) {
        TrieNode current = root;
        int len = word.length();

        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';

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
        children = new TrieNode[256];
        isWord = false;
    }
}