import java.util.LinkedList;
import java.util.Queue;

public class TestTree {

    static class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }
    }

    static Node build() {
        //通过build方法构建一棵树，返回树的根节点
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    public static void preOrder(Node root) {
        //先序遍历
        //1.先访问根节点
        // 2.再访问左子树
        // 3.最后访问右子树
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void middleOrder(Node root) {
        //中序遍历
        //1.先访问左子树
        // 2.再访问根节点
        // 3.最后访问右子树
        if(root == null) {
            return;
        }
        middleOrder(root.left);
        System.out.print(root.val + " ");
        middleOrder(root.right);
    }

    public static void lastOrder(Node root) {
        //后序遍历
        //1.先访问左子树
        // 2.再访问右子树
        // 3.最后访问根节点
        if(root == null) {
            return;
        }
        lastOrder(root.left);
        lastOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrder1(Node root) {
        //层序遍历
        //不需递归，一层一层地访问
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.print(front.val + " ");
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = build();
        preOrder(root);
        //A B D E G C F
        System.out.println();
        middleOrder(root);
        //D B G E A C F
        System.out.println();
        lastOrder(root);
        //D G E B F C A
        System.out.println();
        levelOrder1(root);
        //A B C D E F G 
    }
}
