package lizeteng.data_structures_and_algorithms.linkedlist.exercise;

/**
 * Middle node of linked list.
 *
 * @author lizeteng
 * @date 2018/12/23
 */
public class MiddleOfTheLinkedList {

    public static Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);

        System.out.println(middleNode(head).val);
    }
}
