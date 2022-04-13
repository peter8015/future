package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * [1,2,3,0,0,0]  m=3  [2,4,5,6]  n=4
 * 给定两个"非递减顺序排列"的整数数组num1 和 num2, 另有两个整数m和n，
 * 分别代码两个数组中的元素的个数，请你合并nums2到nums1，并且使合并后的
 * 数组同样也按非递减顺序排列。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
 */
public class MergeSortArray {
    @Test
    public void t1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{3, 5, 6};
        int m = 3, n = 3;

        mergex(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 直接排序
     * 时间复杂度为：O((m+n)log(m+n))
     * 排序序列长度为 m+n，套用快速排序的时间复杂度即可，平均情况为 O((m+n)log(m+n))。
     * 空间复杂度：O(log(m+n))。
     * 排序序列长度为 m+n，套用快速排序的空间复杂度即可，平均情况为 O(log(m+n))。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针：利用已排序特性，我们可以使用双指针方法。这一方法将两个数组看作队列，
     * 每次从两个数组头部取出比较小的数字放到结果中。
     * 时间复杂度：O(m+n)
     * 指针移动，单调递增，最多移动O(m+n)
     * 空间复杂度：o(m+n)
     * 需要建立中间数组sorted
     */
    public void mergex(int[] nums1, int m, int[] nums2, int n) {
        // TODO: 4/11/22 add bound logic
        if (m == 0) {
        }
        if (n == 0) {
            return;
        }
        // TODO: 4/11/22 add result define sorted
        int[] sorted = new int[m + n];

        // TODO: 4/11/22 add pointer p1,p2
        int p1 = 0, p2 = 0, cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        // TODO: 4/11/22  return nums1 = sorted
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

}
