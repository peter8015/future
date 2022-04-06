package com.macro.mall.algorithm;

import java.util.PriorityQueue;

//中位数

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MiddleNum {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MiddleNum() {
        queMin = new PriorityQueue<>((a,b) -> (b - a));
        queMax = new PriorityQueue<>((a,b) -> (a - b));
    }

    //O(logn)
    public void addNum(int num) {
        //exception

        if(queMin.isEmpty() || num < queMin.peek()) {
            queMin.offer(num);
            if(queMin.size() > queMax.size() + 1) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if(queMax.size() > queMin.size() + 1) {
                queMin.offer(queMax.poll());
            }
        }
    }

    //O(1)
    public int findNum() {
        if(queMin.size() > queMax.size()) {
            return queMin.peek();
        }

        return (queMin.peek() + queMax.peek()) / 2;
    }



}
