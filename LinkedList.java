public class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node head;
    public void insert(int item){
        Node newNode = new Node(item);
        if (head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public void delete(int key){
        if (head==null){
            return;
        }
        if (head.data==key){
            head=head.next;
            return;
        }
        Node temp=head;
        while (temp.next!=null && temp.next.data!=key){
            temp=temp.next;
        }
        if (temp.next!=null){
            temp.next=temp.next.next;
        }
    }
    public boolean search(int key){
        Node temp=head;
        while (temp!=null){
            if (temp.data==key){
                return(true);
            }
            temp=temp.next;
        }
        return(false);
    }
    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(15);
        list.insert(25);
        list.display(); 
        list.delete(15);
        list.display(); 
        System.out.println(list.search(5));  
        System.out.println(list.search(100)); 
    }
}
