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

    public int length(){
        Node temp = head;
        int count = 0;
        if(head == null){
            count = 0;
        }else count = 1;


        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void display(){
        if(head == null)
            return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("");
    }

//    public boolean isEmpty(){
//        return head == null;
//    }

//    public void deleteFirst(){
//        if(isEmpty()){
//            return;
//        }
//        else{
//            head = head.next;
//        }
//    }

    public void deleteFirst(){
        if(head == null)
            return;
        head = head.next;
    }

    // void delete(int index)
    // void deleteLast()
    // boolean search(int data)
    // Node maxNode()
    // Node minNode()
    // void sortByPositionToEnd(int to, int end)
    public void deleteLast(){
        if(head == null)
            return;

        // if linkedlist has only one node
        if(head.next == null){
            deleteFirst();
        }
        Node temp = head; // temp find the last node to delete
        Node previous = null; // record node before temp
        while(temp.next != null){
            previous = temp; // gan lai previous
            temp = temp.next;
        }
        previous.next = null;
    }

    //delete index
    public void delete(int index){
        if(index == 0 ){
            deleteFirst();
            return;
        }
        else if(index == length() - 1){
            deleteLast();
            return;
        }
        else{
            Node preNodeDelete = head; // find node at index < index wanna delete >
            for(int i = 1; i < index; i++){
                preNodeDelete = preNodeDelete.next;
            }
            preNodeDelete.next = preNodeDelete.next.next;
        }
    }

    //delete using while instead of for
    public void delete2(int index){
        Node tmp = head;
        if(index == 0){
            deleteFirst();
        }else if(index == length() -1 ){
            deleteLast();
        }else{
            int count = 0;
            // points to node at the right before node need to delete
            while(count < index -1 ){
                count++;
                tmp = tmp.next; // tmp.next: is the node needed to delete
            }
            tmp.next = tmp.next.next; // linked node at the right before and right after node need to delete
        }
    }

    public void Sort(){
        if(head == null){
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node tmp = head;
            while (tmp.next != null) { // compare 3 va 2
                if (tmp.getData() > tmp.next.getData()) {// 3 > 2
                    int a = tmp.getData();// cho a = 3
                    tmp.setData(tmp.next.getData());// sap xep lai cho tmp = 2
                    tmp.next.setData(a); // temp.next = 3
                    swapped = true; // set thanh cong thi cho no lap tiep
                }
                tmp = tmp.next;
            }

        } while (swapped) ;
    }

    void SortAtPosition(int start, int end){
        if(start > end || end < 0 || start < 0){
            return;
        }
        Node tmp = head;
        int i = 0;
        while(i < start){
            tmp = tmp.next;
            i++;
        }
        while(i < end){
            Node tmp2 = tmp.next;
            while(tmp2 != null){
                if(tmp.getData() > tmp2.getData()){
                    int a = tmp.getData();// gan gia tri cho a
                    tmp.setData(tmp2.getData()); // thay doi gia tri cua tmp thanh tmp2
                    tmp2.setData(a);
                }
                tmp = tmp.next;
                i++;
            }
        }

    }

    // Viet ham delete theo while. hint: using count
    public boolean search(int data){
        if(head == null)
            return false;
        Node temp = head;
        /**
         * temp != null: sd khi muon all node trong linkedlist dem ra xu ly
         * hay làm gì đó.
         * Câu lệnh này sẽ lấy từ node đầu tiên đến khi nào kết thúc ( temp == null)
         *
         * temp.next != null: sử dụng khi cần tìm ra nốt cuối cùng và gán cho temp
         */

        while(temp != null){
            if(temp.getData() == data)
                return true;
        }
        return false;
    }
// Btvn sort()

    public Node searchAtPosition(int index){
        if(index < 0 || index >= length())
            return null;
        Node temp = head;
        for(int i = 0; i <= index;i++){
            temp = temp.next;
        }
        return temp;
    }
    // giải thích tsao khi dùng for thì temp nó là node tại vị trí index
    //for(int i = 0; i <= index;i++){
    //            temp = temp.next;
    //        }
    // nếu dùng:
//    for(int i = 0; i < index;i++){
//        temp = temp.next;
//    }
    // tihf nó chỉ trả về trước vị trí index

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        System.out.println("Sau khi addFirst: ");
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        linkedList.display();
        //3 -> 2 -> 1

        System.out.println("Sau khi addLast: ");
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(5);
        // 1 -> 2 -> 3
        linkedList.display();
        System.out.println("Length: ");
        linkedList.length();
        linkedList.display();

        System.out.println("Xoa phan tu dau tien: ");
        linkedList.deleteFirst();
        linkedList.display();

        System.out.println("Xoa phan tu cuoi: ");
        linkedList.deleteLast();
        linkedList.display();

        System.out.println("Xoa tai vi tri: ");
        linkedList.delete(3);
        linkedList.display();

        System.out.println("Xoa them dung vong lap while: ");
        linkedList.delete2(1);
        linkedList.display();

        System.out.println("Sap xep phan tu: ");
        linkedList.Sort();
        linkedList.display();
    }



}
