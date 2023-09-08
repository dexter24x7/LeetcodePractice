package Stack;
//232. Implement Queue using Stacks

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> stk1;
    Stack<Integer> stk2;

    public ImplementQueueUsingStacks() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    public void push(int x) {
        while(!stk1.isEmpty())
            stk2.push(stk1.pop());
        stk2.push(x);
        while(!stk2.isEmpty())
            stk1.push(stk2.pop());
    }

    public int pop() {
        return stk1.pop();
    }

    public int peek() {
        return stk1.peek();
    }

    public boolean empty() {
        return stk1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
