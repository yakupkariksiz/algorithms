package stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

class TaleOfTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();

    }
}

class MyQueue<T> {
    Deque<T> front = new ArrayDeque<>();
    Deque<T> back = new ArrayDeque<>();

    T data;

    void enqueue(T value) {
        while (front.peek() != null) {
            T popped = front.pop();
            back.push(popped);
        }
        back.push(value);
    }

    void dequeue() {
        while (back.peek() != null) {
            T popped = back.pop();
            front.push(popped);
        }
        front.pop();
    }

    T peek() {
        while (back.peek() != null) {
            T popped = back.pop();
            front.push(popped);
        }
        return front.peek();
    }
}