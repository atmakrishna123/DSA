import java.util.*;
class StackADT {
    int maxSize;
    int top;
    int stackArray[];
    StackADT(int size) {
        maxSize = size;
        top = -1;
        stackArray = new int[maxSize];
    }
    void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed");
        }
    }
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }else {
            int val = stackArray[top--];
            System.out.println(val + " popped");
            return val;
        }
    }
    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            System.out.println("Top element is: " + stackArray[top]);
            return stackArray[top];
        }
    }
    boolean isEmpty() {
        return (top == -1);
    }
    boolean isFull() {
        return (top == maxSize - 1);
    }
}
public class Stack {
    public static void main(String[] args) {
        StackADT stack = new StackADT(5);
        stack.push(20);
        stack.push(30);
        stack.push(44);
        stack.push(15);
        stack.push(25);
        stack.pop();
        stack.pop();
        stack.peek();
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack full? " + stack.isFull());
    }
}
