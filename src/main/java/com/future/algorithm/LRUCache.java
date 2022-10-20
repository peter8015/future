package com.future.algorithm;

import java.util.HashMap;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 *      LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 *      int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *      void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 */
public class LRUCache {
    HashMap<Integer, Node> map;
    DoubleLinkedList cache;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        cap = capacity;
    }

    public void put(int key, int val) {
        Node newNode = new Node(key, val);

        if (map.containsKey(key)) {
            cache.delete(map.get(key));
            cache.addFirst(newNode);
            map.put(key, newNode);
        } else {
            if (map.size() == cap) {
                int k = cache.deleteLast();
                map.remove(k);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);

        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int val = map.get(key).val;
        put(key, val);

        return val;
    }
}

/**
 * head: recently used
 * tail: LRU
 */
class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int delete(Node n) {
        int key = n.key;
        n.next.prev = n.prev;
        n.prev.next = n.next;

        return key;
    }

    public int deleteLast() {
        if (head.next == tail) return -1;

        return delete(tail.prev);
    }

    public static void main(String[] args) {
        int capacity = 2;
        int key = 1;
        int value = 1;

        //Your LRUCache object will be instantiated and called as such:
        LRUCache obj = new LRUCache(capacity);
        int param_1 = obj.get(key);
        obj.put(key, value);
    }

}

class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}