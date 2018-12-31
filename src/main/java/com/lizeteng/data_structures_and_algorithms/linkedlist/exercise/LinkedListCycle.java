package lizeteng.data_structures_and_algorithms.linkedlist.exercise;

/**
 * Determine if it has a cycle in linked list.
 *
 * @author lizeteng
 * @date 2018/12/23
 */
public class LinkedListCycle {

    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = head;

        System.out.println(hasCycle(head));
    }
}
