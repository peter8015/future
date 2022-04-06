package com.future.algorithm.jianzhi;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 题目：罗马数字转换为整数
 * 链接：https://leetcode.com/problems/two-sum/
 * 分析：1. 熟悉字典表  2. 组合规则  3. 注意提示
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * 示例 1:
 * <p>
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: s = "IV"
 * 输出: 4
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 */
public class RomeToInteger {

    static Map<Character, Integer> dict = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public void t1() {
        String s1 = "I";
        String s2 = "V";
        String s3 = "VI";

        int r1 = romeToIntx(s1), r2 = romeToIntx(s2), r3 = romeToIntx(s3);

        assertEquals(1, r1);
        assertEquals(5, r2);
        assertEquals(6, r3);
    }


    @Test
    public void t2() {
        String s1 = "I";
        String s2 = "V";
        String s3 = "VI";

        int r1 = romeToInt(s1), r2 = romeToInt(s2), r3 = romeToInt(s3);

        assertEquals(1, r1);
        assertEquals(5, r2);
        assertEquals(6, r3);
    }

    public static int romeToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        int r = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int value = dict.get(s.charAt(i));
            if (i < n - 1 && value < dict.get(s.charAt(i + 1))) {
                r -= value;
            } else {
                r += value;
            }
        }
        return r;
    }

    public static int romeToIntx(String s) {
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            int value = dict.get(s.charAt(i));
            if (i < n - 1 && value < dict.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
