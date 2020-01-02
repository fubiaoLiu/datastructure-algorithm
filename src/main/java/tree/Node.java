package tree;

import java.util.List;

/**
 * @description: N叉树节点
 * @author: FuBiaoLiu
 * @date: 2020/1/2
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};
