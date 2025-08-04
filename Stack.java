public class Stack {
    private int[] stack;
    private int top, capacity;
    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = item;
        System.out.println(item + " pushed");
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int item = stack[top--];
        System.out.println(item + " popped");
        return item;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        System.out.println("Top element is: " + stack[top]);
        return stack[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity - 1;
    }
    public int size() {
        return top + 1;
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); 
        stack.pop();
        stack.pop();
        stack.peek();
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack full? " + stack.isFull());
        System.out.println("Stack size: " + stack.size());
    }
}
