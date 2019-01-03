package lizeteng.data_structures_and_algorithms.linkedlist.exercise;

/**
 * Singly linked list node.
 *
 * @author lizeteng
 * @date 2018/12/23
 */
public class Node {

    public int val;

    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public void printAll() {
        Node node = this;

        while (node != null) {
            System.out.print(node.val + " ");

            node = node.next;
        }

        System.out.println();
    }
}
