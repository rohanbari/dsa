/*
 Copyright 2025 Rohan Bari <rohanbari@outlook.com>

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package problems;

import java.util.LinkedList;
import java.util.List;

import problems.ds.TreeNode;

public class FlattenBTree {

    /**
     * Given the root of a binary tree, flatten the tree into a "linked list".
     * 
     * @param root The B-Tree to flatten
     */
    private void flatten(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        preOrder(result, root, false);

        TreeNode prev = null;

        for (TreeNode node : result) {
            node.lhs = null;
            if (prev != null) {
                prev.rhs = node;
            }

            prev = node;
        }
    }

    private void preOrder(List<TreeNode> result, TreeNode root, boolean print) {
        if (root == null) {
            return;
        }

        if (print) {
            System.out.println(root.val);
        } else {
            result.add(root);
        }

        preOrder(result, root.lhs, print);
        preOrder(result, root.rhs, print);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.lhs = node1;
        root.rhs = node2;
        node1.lhs = node3;
        node1.rhs = node4;
        node2.lhs = null;
        node2.rhs = node5;

        new FlattenBTree().flatten(root);
        new FlattenBTree().preOrder(null, root, true);
    }
}
