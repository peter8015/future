package com.future.algorithm.leetcode;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
 */
public class Solution3 {

    @Test
    public void t() {
        assertEquals(3, lengthOflongestSubString("abcabcbb"));
        assertEquals(1, lengthOflongestSubString("bbbbb"));
        assertEquals(3, lengthOflongestSubString("pwwkew"));
    }

    @Test
    public void t1() {
        assertEquals(3, lengOfLongest("abcabcbb"));
        assertEquals(1, lengOfLongest("bbbbb"));
        assertEquals(3, lengOfLongest("pwwkew"));
    }

    /**"abcabcbb"
     *  slip window
     *  abc, i... r
     *  0, s.charAt(i - 1)  sets.remove
     * @param s
     * @return
     */
    private int lengOfLongest(String s) {
        int len = s.length();
        Set<Character> sets = new HashSet();
        int right = -1, r = 0;

        for(int i = 0; i < len; i++) {
            if(i != 0) {
                sets.remove(s.charAt(i - 1));
            }

            while(right + 1 < len && !sets.contains(s.charAt(right + 1))) {
                sets.add(s.charAt(right + 1));
                right++;
            }
            r = Math.max(r, right - i + 1);

        }
        return r;
    }

    /**
     * 开始的解法,有问题
     */
//    public int lengthOflongestSubString(String s) {
//        if (s.equals(" ")) {
//            return 0;
//        }
//
//        int size = 0, max = 0;
//
//        Set<Character> sets = new HashSet();
//        char[] chars = s.toCharArray();
//        int len = chars.length;
//
//        for (int i = 0; i < len; i++) {
//            if (sets.contains(chars[i])) {
//                size = sets.size();
//                max = size > max ? size : max;
//                sets.clear();
//            }
//            sets.add(chars[i]);
//        }
//        return max;
//    }
//

    /**
     * 滑动窗口
     * 利用左右指针进行判断，并结合set进行去重
     * 时间复杂度：O(n), N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
     * 空间复杂度：O(∣Σ∣)，其Σ 表示字符集（即字符串中可以出现的字符），
     */
    public int lengthOflongestSubString(String s) {
        //右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int len = s.length(), r = -1, ans = 0;
        // 哈希集合，记录每个字符是否出现过
        Set<Character> sets = new HashSet();

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                // left pointer move one step, s remove a char
                sets.remove(s.charAt(i - 1));
            }

            while (r + 1 < len && !sets.contains(s.charAt(r + 1))) {
                // move the right pointer
                sets.add(s.charAt(r + 1));
                r++;
            }
            ans = Math.max(ans, r - i + 1);
        }
        return ans;
    }

}
