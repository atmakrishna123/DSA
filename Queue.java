import java.util.*;
public class Queue {
    private int[] queue;
    private int size,capacity,front,rear;
    public Queue(int capacity){
        this.capacity=capacity;
        queue=new int[capacity];
        front=size=0;
        rear=-1;
    }
    public void enqueue(int value){
        if (size==capacity){
            System.out.println("Queue Overflow");
        }
        rear=(rear+1)%capacity;
        queue[rear]=value;
        size++;
        System.out.println("Added item: "+value);
    }
    public int dequeue(){
        if (isEmpty()){
            System.out.println("Queue is Empty. Dequeue operation unsuccessfull.");
            return -1;
        }
        int item=queue[front];
        front=(front+1)%capacity;
        System.out.println("Removed element:"+item);
        size--;
        return(item);
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("Queue is Empty. Peek operation failed");
        }
        int item=queue[front];
        System.out.println("The top element is: "+item);
        return(item);
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return(size);
    }
    public static void main(String[] args){
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); 
        System.out.println(queue.dequeue() + " dequeued");
        System.out.println(queue.dequeue() + " dequeued");
        System.out.println("Front element: " + queue.peek());
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Current queue size: " + queue.size());
    }
}
