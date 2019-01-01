package lizeteng.data_structures_and_algorithms.linkedlist.exercise;

/**
 * Merge two sorted linked lists.
 *
 * @author lizeteng
 * @date 2018/12/23
 */
public class MergeTwoSortedLinkedLists {

    public static Node mergeTwoLists(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }

        Node node = new Node(0), tempNode = node;

        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                tempNode.next = n2;
                n2 = n2.next;
            } else {
                tempNode.next = n1;
                n1 = n1.next;
            }

            tempNode = tempNode.next;
        }

        if (n1 == null) {
            tempNode.next = n2;
        } else {
            tempNode.next = n1;
        }

        return node.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        n1.next = new Node(1);
        Node n2 = new Node(2);
        n2.next = new Node(3);

        mergeTwoLists(n1, n2).printAll();
    }
}
