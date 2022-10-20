package com.future.jdk;

import com.future.algorithm.TreeNode;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void t1() {
        TreeNode node = new TreeNode(1);
        node = null;

        Optional<TreeNode> optional = Optional.ofNullable(node);
        System.out.println(optional.isPresent());

        TreeNode node1 = optional.orElse(new TreeNode(2));
        System.out.println(node1);

    }
}


