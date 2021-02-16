package stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

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
        back.push(value);
    }

    void dequeue() {
        shiftStacks();
        front.pop();
    }

    T peek() {
        shiftStacks();
        return front.peek();
    }

    private void shiftStacks() {
        if (front.isEmpty()) {
            while (!back.isEmpty()) {
                front.push(back.pop());
            }
        }
    }
}