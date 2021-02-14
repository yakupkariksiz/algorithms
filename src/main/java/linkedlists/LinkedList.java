package linkedlists;

import java.util.ArrayList;
import java.util.List;

class LinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode _01 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode _02 = new SinglyLinkedListNode(5);
        SinglyLinkedListNode _03 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode _04 = new SinglyLinkedListNode(2);

        _01.next = _02;
        _02.next = _03;
        _03.next = _04;

        SinglyLinkedListNode _11 = new SinglyLinkedListNode(7);
        SinglyLinkedListNode _12 = new SinglyLinkedListNode(8);
        SinglyLinkedListNode _13 = new SinglyLinkedListNode(5);
        SinglyLinkedListNode _14 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode _15 = new SinglyLinkedListNode(6);
        SinglyLinkedListNode _16 = new SinglyLinkedListNode(44);

        _11.next = _12;
        _12.next = _13;
        _13.next = _14;
        _14.next = _15;
        _15.next = _16;
        _16.next = _04;

        System.out.println(findMergeNode(_01, _11));

        printLinkedList(_01);
        printLinkedList(_11);
    }

    static void printLinkedList(SinglyLinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print(" null ");
        System.out.println();
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

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;

        while (current1 != null) {
            current2 = head2;
            while (current2 != null) {
                if (current1 == current2) {
                    return current1.data;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }

        return 0;
    }

    static boolean hasCycle(Node head) {
        Node current = head;
        List<Node> visits = new ArrayList<>();
        while (current != null) {
            if (visits.contains(current)) {
                return true;
            }
            visits.add(current);
            current = current.next;
        }
        return false;
    }
}

class Node {
    int data;
    Node next;
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
