public class DLL {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    class Node{
        String data;
        Node next, prev;
        public Node(String data){
            this.data = data;
        }
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else 
            return false;
    }
    
    public int size(){
        return size;
    }

    public void clear(){
        Node curNode = head;
        while(curNode != null){
            Node next = curNode.next;
            curNode.prev = curNode.next = null;
            curNode.data = null;
            curNode = next;
        }
        head = tail = curNode = null;
        size = 0;
    }

    public void addFirst(String elem){
        if(isEmpty()){
            head = tail = new Node(elem);
        } else{
            head.prev = new Node(elem);
            head = head.next;
        }
    }

    public void addLast(String elem){
        if(isEmpty()){
            head = tail = new Node(elem);
        } else{
            tail.next = new Node(elem);
            tail = tail.next;
        }
    }

    
    public static void main(String[] args) {
       DLL list = new DLL();
        list.addFirst("1");
    }
}
