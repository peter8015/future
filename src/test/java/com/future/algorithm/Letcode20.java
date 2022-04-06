package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 给定一个只包含大中小括号的字符串，判断字符器是否合法。
 * 示例：
 * 输入："()[]{}"  输出：true
 * 输入："([)"     输出：false
 * 输入："((([])))"输出：true
 */
public class Letcode20 {

    @Test
    public void t2() {
        String s1 = "()[]{}";
        String s2 = "([)";
        String s3 = "((([])))";
        String s4 = "()(){}[](((])))";
        String s5 = "([}}])";

        assertTrue(isValid(s3));
    }


    public boolean isValid(String s) {
        //boundary
        if (s == null) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }

        //dictionary
        Map<Character, Character> dict = new HashMap();
        dict.put('(', ')');
        dict.put('[', ']');
        dict.put('{', '}');

        //stack
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && c == dict.get(stack.peek())) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}



