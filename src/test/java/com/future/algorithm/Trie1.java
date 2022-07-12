package com.future.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Trie1 {
    //根节点，根节点是不存储任何字母的，从根节点的
    //子节点开始存储
    private TrieNode root;

    public Trie1() {
        root = new TrieNode();
    }

    //插入字符串
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //判断字符有没有创建，如果没有创建就创建
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
                //中间的字符不是完整的单词
                current.children[index].isWord = false;
            }
            current = current.children[index];
        }
        //最后一个字符才能构成一个完整的单词
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = find(word);
        return current != null && current.isWord;
    }

    public boolean startWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String str) {
        TrieNode current = root;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int index = str.charAt(i) - 'a';
            if ((current = current.children[index]) == null)
                return null;
        }
        return current;
    }

    @Test
    public void t1() {
        Trie1 trie = new Trie1();

        trie.insert("abcdef");
        trie.insert("abcfde");
        trie.insert("abcehi");
        trie.insert("abcehabc");

//        assertTrue(trie.search("abc"));
//        assertTrue(trie.search("abd"));
        assertFalse(trie.startWith("aaaa"));
        assertTrue(trie.startWith("abc"));

    }
}
