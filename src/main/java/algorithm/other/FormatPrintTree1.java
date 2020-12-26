package algorithm.other;

/**
 * @description: 格式化打印菜单树1 - 递归遍历子节点，直接打印，时间复杂度为 O(n^2 + n) -> O(n^2)，print打印方法的复杂度约为 O(nlogh)
 * 给定一组数据：
 * ("id","pid","name")
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
 * @author liufb
 * @create: 2020/6/22 9:27
 **/
public class FormatPrintTree1 {
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
        FormatPrintTree1 fpt = new FormatPrintTree1();
        fpt.formatPrint(array);
    }

    /**
     * 格式化打印
     *
     * @param array Node数组
     */
    private void formatPrint(Node[] array) {
        int currentNodeId = 0;
        int level = 0;
        formatPrint(array, currentNodeId, level);
    }

    /**
     * 格式化打印
     *
     * @param array    Node数组
     * @param parentId 父节点ID
     * @param level    层级
     */
    private void formatPrint(Node[] array, int parentId, int level) {
        for (Node node : array) {
            if (node.parentId == parentId) {
                print(node.name, level);
                formatPrint(array, node.id, level + 1);
            }
        }
    }

    /**
     * 打印
     *
     * @param name     node名称
     * @param indentationNum 缩进数量
     */
    private void print(String name, int indentationNum) {
        for (int i = 1; i <= indentationNum; i++) {
            System.out.print("    ");
        }
        System.out.println(name);
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
