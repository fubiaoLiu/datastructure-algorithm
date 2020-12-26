package algorithm.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 格式化打印菜单树2 - 借助 Map、List实现，时间复杂度为 O(2n) -> O(n)
 * 给定一组数据：
 * {
 *     (1,0,"AA")
 *     (2,1,"BB")
 *     (3,1,"CC")
 *     (4,3,"DD")
 *     (5,3,"EE")
 *     (6,2,"FF")
 *     (7,2,"GG")
 *     (8,4,"HH")
 *     (9,5,"II")
 * }
 *
 * 和数据结构:
 * Node{
 *     Integer id;
 *     Integer parentId;
 *     String name;
 * }
 *
 * 要求按以下格式输出：
 * AA
 *      BB
 *              FF
 *              GG
 *      CC
 *              DD
 *                      HH
 *              EE
 *                      II
 *
 * @author liufb
 * @since2020/6/22 9:27
 **/
public class FormatPrintTree2 {
    private static final String TAB = "    ";

    public static void main(String[] args) {
        Node[] array = new Node[]{
                new Node(1, 0, "AA"),
                new Node(2, 1, "BB"),
                new Node(3, 1, "CC"),
                new Node(4, 3, "DD"),
                new Node(5, 3, "EE"),
                new Node(6, 2, "FF"),
                new Node(7, 2, "GG"),
                new Node(8, 4, "HH"),
                new Node(9, 5, "II")
        };
        FormatPrintTree2 fpt = new FormatPrintTree2();
        fpt.formatPrint(array);
    }

    /**
     * 格式化打印
     *
     * @param array Node数组
     */
    private void formatPrint(Node[] array) {
        Map<Integer, List<Node>> map = new HashMap<>(array.length);
        for (Node node : array) {
            List<Node> nodes = map.computeIfAbsent(node.parentId, k -> new ArrayList<>());
            nodes.add(node);
        }
        int parentId = 0;
        String indentation = "";
        formatPrint(map, parentId, indentation);
    }

    /**
     * 格式化打印
     *
     * @param map         node map
     * @param parentId    父节点ID
     * @param indentation 缩进字符串
     */
    private void formatPrint(Map<Integer, List<Node>> map, int parentId, String indentation) {
        List<Node> nodes = map.get(parentId);
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        for (Node node : nodes) {
            System.out.println(indentation + node.name);
            formatPrint(map, node.id, indentation + TAB);
        }
    }

    private static class Node {
        Integer id;
        Integer parentId;
        String name;

        public Node(Integer id, Integer parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }
}
