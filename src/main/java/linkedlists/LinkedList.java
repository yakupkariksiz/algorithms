package linkedlists;

class LinkedList {

    public static void main(String[] args) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
        DoublyLinkedListNode second = new DoublyLinkedListNode(2);
        DoublyLinkedListNode third = new DoublyLinkedListNode(3);
        DoublyLinkedListNode fourth = new DoublyLinkedListNode(4);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        DoublyLinkedListNode node = reverse(head);
        while (node != null) {
            System.out.print(node.data + " <-> ");
            node = node.next;
        }
        System.out.print(" null ");
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode current = head;
        int cursor = 0;
        if (0 == position) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.data = data;
            newNode.next = current;
            return newNode;
        }
        SinglyLinkedListNode previous = null;
        while (current != null) {
            if (cursor == position) {
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
                newNode.next = current;
                previous.next = newNode;
            }
            previous = current;
            current = current.next;
            cursor++;
        }
        return head;
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode current = head;
        if (current == null) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            head = newNode;
            return head;
        }
        if (data <= current.data) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            newNode.next = head;
            newNode.prev = head.prev;
            head = newNode;
            return head;
        }
        DoublyLinkedListNode previous = null;
        while (current != null) {
            if (data <= current.data) {
                DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
                return head;
            }
            previous = current;
            current = current.next;
        }
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        newNode.prev = previous;
        previous.next = newNode;
        return head;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode newHead = null;
        while (current != null) {
            DoublyLinkedListNode next = current.next;
            DoublyLinkedListNode prev = current.prev;
            current.next = prev;
            current.prev = next;
            newHead = current;
            current = next;
        }
        return newHead;
    }
}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }
}

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }
}
