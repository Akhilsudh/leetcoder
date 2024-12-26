package Grind75;
import java.util.*;

public class _13_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(1);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}


class MyQueue {
    Stack<Integer> readStack;
    Stack<Integer> writeStack;

    public MyQueue() {
        readStack = new Stack<>();
        writeStack = new Stack<>();
    }

    public void push(int x) {
        writeStack.push(x);
    }
    public int pop() {
        if(readStack.isEmpty()) {
            while(!writeStack.empty()) {
                readStack.push(writeStack.pop());
            }
        }
        return readStack.pop();
    }

    public int peek() {
        if(readStack.isEmpty()) {
            while(!writeStack.empty()) {
                readStack.push(writeStack.pop());
            }
        }
        return readStack.peek();
    }

    public boolean empty() {
        return readStack.isEmpty() && writeStack.isEmpty();
    }
}
