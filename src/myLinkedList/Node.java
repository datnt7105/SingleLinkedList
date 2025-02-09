package myLinkedList;
// tao 1 linked list to save int number
// su dung kieu du lieu gi


public class Node {
     public int data;
     public Node next;

    public Node() {
    }

    // de truyen data vao
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }



    public int getData() {
        return data;
    }

    public void setData(int data){
        this.data = data;

    }


}
