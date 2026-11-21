package org.example.dfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3.深度奇偶前序筛选
 * 递归二叉树
 * 题目描述：
 * 给定一棵二叉树的根节点 root，根节点深度定义为 0。
 * <p>
 * 按照前序顺序（根节点 -> 左子树 -> 右子树）访问二叉树的每个节点，设当前节点深度为 depth。
 * 当节点值绝对值的奇偶性与深度的奇偶性一致（abs(node.val) % 2 == depth % 2）时，将该节点值加入结果：
 * - 深度为偶数的层，只保留节点值绝对值为偶数的节点；
 * - 深度为奇数的层，只保留节点值绝对值为奇数的节点。
 * <p>
 * 节点不满足保留条件时，其左右子树仍继续访问。
 * <p>
 * 返回按前序访问顺序排列的合格节点值序列。
 * 输入：
 * 二叉树的层序序列：从根节点开始，自上而下、自左向右依次为各位置的值。
 * # 表示该位置为空节点，空节点没有子节点；空树用 [] 表示。
 * 输入不一定是完全二叉树。例如 [12,7,18,4,9,15,21] 表示一棵 3 层完全二叉树；[8,3,#,1,6] 表示根只有左子树的非完全二叉树。
 * <p>
 * 输出：
 * 合格节点值序列，按前序访问顺序排；无合格节点时输出 []。
 * <p>
 * 约束条件：
 * 0 <= 二叉树节点数 <= 2000
 * -10^9 <= Node.val <= 10^9
 * 节点值可以为负数、零或重复值
 * 空树返回空序列 []
 * 补充说明：
 * <p>
 * 收起
 * 示例1
 * 输入：
 * [12,7,18,4,9,15,21]
 * 输出：
 * [12,7,4]
 * 说明：
 * 12✓          深度 0（保留绝对值为偶数的节点）
 * /  \
 * 7✓    18✗      深度 1（保留绝对值为奇数的节点）
 * / \    / \
 * 4✓  9✗ 15✗ 21✗   深度 2（保留绝对值为偶数的节点）
 * <p>
 * 前序访问顺序：12、7、4、9、18、15、21，其中合格的是 12、7、4。
 * <p>
 * 示例2
 * 输入：
 * [8,3,#,1,6]
 * 输出：
 * [8,3,6]
 * 说明：
 * 非完全二叉树：根只有左子树
 * <p>
 * 8✓        深度 0
 * /
 * 3✓          深度 1
 * / \
 * 1✗  6✓        深度 2
 * <p>
 * 前序访问顺序：8、3、1、6；1 为奇数但深度 2 要求偶数，不保留。
 * <p>
 * 示例3
 * 输入：
 * [3,#,6,#,5]
 * 输出：
 * []
 * 说明：
 * 示例3（右斜链，全部不符合）
 * 输入：[3,#,6,#,5]
 * 输出：[]
 * <p>
 * 3✗       深度 0
 * \
 * 6✗     深度 1
 * \
 * 5✗   深度 2
 */
public class DFSFilter {

    Node treeNode;

    class Node {
        Node parent;
        int value;
        String sign;
        Node left;
        Node righ;
        int depth;
        public Node() {

        }
        public Node(String sign) {
            this.sign = sign;
        }
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public String binaryTree(String tree) {

        if (tree == null || tree.isEmpty()
                || !tree.startsWith("[") || !tree.endsWith("]")) throw new IllegalArgumentException("param error.");

        ArrayDeque<Node> queue = new ArrayDeque<>();
        String[] treeNodeArray = tree.substring(1, tree.length() - 1).split(",");

        int index = 1;
        int depth = 0;

        //初始化
        Node node = new Node();
        node.value = Integer.parseInt(treeNodeArray[0]);
        node.depth = depth;
        node.left = new Node("#");
        node.righ = new Node("#");
        queue.offer(node);
        treeNode = node;

        /**
         * 1 根节点
         * 2- 左子树 - 添加到根节点 （当前值是否是# ） #无左子树
         *    右子树 - 添加到根节点 （当前值是否是#）#无右子树
         * 3.左子树 - 左子子树添加到-左子树节点
         *           左子树的右子树-左子树节点
         * 4、右子树 - 右子树的左子树添加到 - 右节点
         *
         *  1
         *  - 2-3
         *     2-4-5
         *     3-6-7
         *      4-8-9
         *      5 - 10 11
         *
         *
         */
        //添加左子树 + 右子树
        while (!queue.isEmpty() && index < treeNodeArray.length) {
            depth++;
            Node parent = queue.poll();
            /**
             * 左子树
             */
            if (!"#".equals(treeNodeArray[index])) {
                if (Integer.parseInt(treeNodeArray[index]) < parent.value) {
                    node = parent.left;
                    node.value = Integer.parseInt(treeNodeArray[index]);
                    node.depth = depth;
                    node.parent = parent;
                    node.sign = "";
                    node.left = new Node("#");
                    node.righ = new Node("#");
                    //parent.left = node;
                    queue.offer(node);
                }
            }
            index++;
            if (!"#".equals(treeNodeArray[index])) {
                if (parent.righ != null
                        && Integer.parseInt(treeNodeArray[index]) > parent.value) {
                    node = parent.righ;
                    node.value = Integer.parseInt(treeNodeArray[index]);
                    node.depth = depth;
                    node.parent = parent;
                    node.sign = "";
                    node.left = new Node("#");
                    node.righ = new Node("#");
                    queue.offer(node);
                }
            }
            index++;
        }


        List<Integer> a = each();
        return a.toString();
    }

    public List each() {

        List<Integer> resultList = new ArrayList<>();
        ArrayDeque<Node> que = new ArrayDeque<>();
        if ((Math.abs(treeNode.value) % 2) == (treeNode.depth % 2)) {
            que.offer(treeNode);
        }

        if (treeNode != null) {
            while (!que.isEmpty()) {
                Node node = que.poll();
                if (node.left != null && !"#".equals(node.left.sign)
                        && (Math.abs(node.left.value) % 2) == (node.left.depth % 2)) {
                    que.offer(node.left);
                }
                if (node.righ != null && !"#".equals(node.righ.sign)
                        && (Math.abs(node.righ.value) % 2) == (node.righ.depth % 2)) {
                    que.offer(node.righ);
                }

                if (node != null && !"#".equals(node.sign)) {
                    resultList.add(node.value);
                }
            }
        }
        return resultList;
    }
}
