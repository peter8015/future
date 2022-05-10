package com.future.algorithm;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * 简单
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例：
 * 输入："()[]{}"  输出：true
 * 输入："([)"     输出：false
 * 输入："((([])))"输出：true
 */
public class Letcode20 {
    private static Map<Character, Character> DICT = new HashMap<>();

    static {
        DICT.put(')', '(');
        DICT.put('}', '{');
        DICT.put(']', '[');
    }

    @Test
    public void t2() {
        String s1 = "()[]{}";
        String s2 = "([)";
        String s3 = "((([])))";
        String s4 = "()(){}[](((])))";
        String s5 = "([}}])";

        assertTrue(isValid_1(s1));
        assertFalse(isValid_1(s2));
    }

    //O(n) O(n)
    public boolean isValid_1(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()
                    || c == ')' && stack.pop() != '('
                    || c == ']' && stack.pop() != '['
                    || c == '}' && stack.pop() != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 时间复杂度 O(n)
     * 空间复杂度：O(n + ∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，
     * 栈中的字符数量为 O(n)，而哈希表使用的空间为 O(∣Σ∣)，相加即可得到总空间复杂度。
     */
    public boolean isValid_2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len % 2 != 0) return false;

        Stack<Character> data = new Stack();

        for (int i = 0; i < len; i++) {
            char c = chars[i];

            if (DICT.containsKey(c)) {
                if (data.isEmpty() || data.peek() != DICT.get(c)) {
                    return false;
                }
                data.pop();
            } else {
                data.push(c);
            }
        }

        if (data.isEmpty()) {
            return true;
        }
        return false;
    }



    //"()[]{}"
    //"{[()]}"
    public boolean isValid_3(String s) {
        while (true) {
            int l = s.length();

            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");

            if (s.length() == l)
                return l == 0;
        }
    }
}