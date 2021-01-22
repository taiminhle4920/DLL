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
    public String peakFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List!");
        return head.data;
    }

    public String peakLast(){
        if(isEmpty()) throw new RuntimeException("Empty List!");
        return tail.data;
    }

    public String removeFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List!");
        //get the data from head and move the head to the next node, decrease the size by 1
        String data = head.data;
        head = head.next;
        --size;
        // if the list is empty, set the tail to null
        if(isEmpty())   tail = null;  
        // clean the previous node
        else head.prev = null;   
        return data;
    }

    public String removeLast(){
        // get the data from the tail and move the tail to the previous node, decrease the size by 1
        if(isEmpty()) throw new RuntimeException("Empty List!");
        String data = tail.data;
        tail = tail.prev;
        --size;
        // the list is empty, set the head to null
        if(isEmpty()) head = null;
        // memory clean up
        else tail.next = null;
        return data;
    }
    public String remove(Node node){
        //if the node is at head or tail, it can be remove by the previous method
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();
        node.next.prev = node.prev;
        node.prev.next = node.next;
       // store data temporary
        String data = node.data;
        // clean up memory
        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }
    public String removeAt(int index){
        if(index <= 0 || index >= size) throw new IllegalArgumentException();
        int i;
        Node trav;
        if(index < size/2){
            for(i = 0, trav = head; i != index; i++)
                trav = trav.next;
        } else{
            for(i = size-1, trav = tail; i != index; i--)
                trav= trav.prev;
        }
        return remove(trav);  
    }
    
    public boolean remove(Object obj){
        Node trav = head;
        if(obj == null){
            for(trav = head; trav != null; trav = trav.next){
                if(trav.data == null){
                    remove(trav);
                    return true;
                }
            }
        } else{
            for(trav = head; trav != null; trav = trav.next){
                if(obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }
    
    public int indexOf(Object obj){
        int index = 0;
        Node trav = head;
        if(obj == null){
            for(trav = head; trav != null; trav = trav.next, index++){
                if(trav.data == null)
                return index;
            }
        } else {
            for(trav = head; trav != null; trav = trav.next, index++){
                if(obj.equals(trav.data))
                return index;
            }
        }
        return -1;
    }
    
    public boolean contain(Object obj){
        return indexOf(obj) != -1;
    }
    
    public boolean hasNext(){
        Node trav = head;
        if(trav.next != null)
            return true;
        return false;
    }
    public String next(){
        Node trav = head;
        String data = trav.data;
        trav = trav.next;
        return data;
    }

    @Override public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node trav = head;
        while (trav != null){
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(" ]");
            return sb.toString();
    }
    
    public static void main(String[] args) {
       DLL list = new DLL();
        list.addFirst("1");
    }
}
