package com.future.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Title  2195. 向数组中追加 K 个整数]
 * 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，
 * 并使结果数组的元素和 最小 。
 * 返回追加到 nums 中的 k 个整数之和。
 * <p>
 * 输入：nums = [1,4,25,10,25], k = 2
 * 输出：5
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
 * nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。
 * <p>
 * 链接：https://leetcode.cn/problems/append-k-integers-with-minimal-sum
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i], k <= 109
 */
public class Solution2195 {

    @Test
    public void t1() {
        int[] nums = new int[]{1, 4, 25, 10, 25};
        int k = 2, k1 = 3, k2 = 4;

//        assertEquals(5, minimalKSum(nums, k));
//        assertEquals(10, minimalKSum(nums, k1));
//        assertEquals(16, minimalKSum(nums, k2));


        assertEquals(5, mSum(nums, k));
        assertEquals(10, mSum(nums, k1));
        assertEquals(16, mSum(nums, k2));

    }

    /**
     * 思路：
     * 1. 只循环一次，利用set进行去重，next表示新加入的值。
     * 2. 当数组中的值（num）小于k时，进行顺序填充。res表示顺序填充值的和，在遍历时next++时减去num再加上新的值next。直接计算出新加入值的总和。
     * O(n)
     * 执行用时：32 ms, 在所有 Java 提交中击败了43.46%的用户
     * https://leetcode.cn/problems/append-k-integers-with-minimal-sum/solution/xiang-shu-zu-zhong-zhui-jia-k-ge-zheng-s-9vdv/
     *
     * @param nums
     * @param k
     * @return
     */
    public long minimalKSum(int[] nums, int k) {
        // next new element
        int next = k + 1;
        // sum of all new elements from 0,ex: k=4 {0,1,2,3,4} sum=(1+4)*4/2=10
        long r = (1L + k) * k / 2;

        // use set remove duplicates
        Set<Integer> sets = new HashSet();
        for (int num : nums) {
            sets.add(num);
        }

        for (int num : sets) {
            // can be added elements
            if (num <= k) {
                while (sets.contains(next)) {
                    next++;
                }
                r = r - num + next;
                next++;
            }
        }
        return r;
    }

    /**
     * O(nlogn)
     * 看不懂
     * 执行用时：19 ms, 在所有 Java 提交中击败了77.45%的用户
     */
    public long minKSum(int[] nums, int k) {
        long ans = 0, start = 1;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length && k > 0; i++) {
            // 存在未出现的数字
            if (start < nums[i]) {
                int cnt = (int) (nums[i] - start) > k ? k : (int) (nums[i] - start);
                // 不存在的数据累计
                ans += (2L * start + cnt - 1) * cnt / 2;
                k -= cnt;
            }
            start = nums[i] + 1;
        }

        // 不存在的数据累计
        if (k > 0) {
            ans += (2L * start + k - 1) * k / 2;
        }
        return ans;
    }

    /**
     * 执行用时：43 ms, 在所有 Java 提交中击败了34.31%
     * https://leetcode.cn/problems/append-k-integers-with-minimal-sum/solution/pai-xu-bian-li-by-endlesscheng-81er/
     */
    public long minimalKSum1(int[] nums, int k) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        long sum = 0;

        for (int num : nums) {
            if (!set.contains(num) && num <= k) {
                k++;
                sum += num;
            }
            set.add(num);
        }

        long res = (long) (1 + k) * k / 2 - sum;
        return res;
    }

    public long mSum(int[] nums, int k) {
        long r = (1L + k) * k / 2;
        int next = k + 1;

        Set<Integer> sets = new HashSet();
        for (int num : nums) {
            sets.add(num);
        }

        for (int num : sets) {
            if (num <= k) {
                while (sets.contains(next)) {
                    next++;
                }
                r = r - num + next;
                next++;
            }
        }
        return r;
    }


}



