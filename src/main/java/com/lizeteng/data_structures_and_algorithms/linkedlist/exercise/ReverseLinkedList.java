package lizeteng.data_structures_and_algorithms.linkedlist.exercise;

/**
 * Reverse a singly linked list.
 *
 * @author lizeteng
 * @date 2018/12/28
 */
public class ReverseLinkedList {

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;

        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);

        head.printAll();
        reverseList(head).printAll();
    }
}
