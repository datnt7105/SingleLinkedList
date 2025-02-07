package myLinkedList;

public class MyLinkedList {
    private Node head ;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        //check case head = null
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        // sau cau lenh nay, tum duoc node cuoi cung
        // va duoc gan cho temp
        //nv cuoi cung:
        temp.next = newNode;// -> DONE
    }

    // them vao vi tri bat ki
    public void add(int data, int index){
        Node newNode = new Node(data);
        if(index == 0){
            addFirst(data);
            return;
        }else{
            Node temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            //index: 1
            // 1 -> 2 -> 3 // temp = 1, temp.next = 2 = nextNode
            // 4
            Node nextNode = temp.next;
            temp.next = newNode; // temp.next = 4 = newNode
            newNode.next = nextNode;
            // -> 1 -> 4 -> 2 -> 3
        }
        //1. public int length()
        //2. public void display()
        //3. public void deleteFirst()

    }




    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        //3 -> 2 -> 1

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        // 1 -> 2 -> 3
    }



}
