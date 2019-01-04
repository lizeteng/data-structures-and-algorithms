package lizeteng.data_structures_and_algorithms.linkedlist.exercise;

/**
 * Remove the n-th node from the end of list.
 *
 * @author lizeteng
 * @date 2018/12/23
 */
public class RemoveNthNodeFromEndOfLinkedList {

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) {
            return null;
        }

        Node fast = head;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }

        Node slow = head, prev = null;

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);

        removeNthFromEnd(head, 1).printAll();;
    }
}
