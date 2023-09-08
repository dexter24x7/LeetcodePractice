package Stack;

import java.util.ArrayList;
import java.util.List;

//155. Min Stack
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    List<Integer> stack;
    List<Integer> minList;

    public MinStack() {
        stack = new ArrayList<>();
        minList = new ArrayList<>();
        minList.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        int prevMin = getMin();
        minList.add(Math.min(val,prevMin));
    }

    public void pop() {
        stack.remove(stack.size()-1);
        minList.remove(minList.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minList.get(minList.size()-1);
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
