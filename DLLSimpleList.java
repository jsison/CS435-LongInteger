
package cs435longinteger;

/**
 * @author  Jeremy Sison NJIT Email: jas84@njit.edu
 */
public class DLLSimpleList implements SimpleList<DLLNode> {

    private DLLNode head;
    private DLLNode tail;
    private int size;

    public DLLSimpleList() {
        this.size = 0;

    }

    @Override
    public void insertFirst(int data) {
        DLLNode temp = new DLLNode(data);
        
        //If the linked list has no items in it
        //Next and Prev is NULL because of no items
        //set temp as new head
        if (head == null){
            temp.setPrev(null);
            temp.setNext(null);
            head = temp;
        }
        //If the linked list >= 1
        //set temp.next to head
        //set head.prev to temp
        //set temp.prev = null
        //set temp as new head
        else{
            temp.setPrev(null);
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
        
    }

    @Override
    public void insertLast(int data) {
        DLLNode temp = new DLLNode(data);
        
        //If the linked list has no items in it
        //Next and Prev is NULL because of no items
        //set temp as new head
        if (head == null){
            temp.setPrev(null);
            temp.setNext(null);
            head = temp;
        }
        //Creates tail if a node cannot both be head and tail
        //if head next is empty
        //set temp prev head
        //set temp next null
        //set temp as new tail
        else if(head.getNext() == null){
            temp.setPrev(head);
            temp.setNext(null);
            head.setNext(temp);
            tail = temp;
        }
        //If the linked list >= 1
        //Temp.prev is set to tail
        //Temp.next is set as null
        //tail.next is temp
        //set temp as new tail
        else{
            temp.setPrev(tail);
            temp.setNext(head);
            tail = temp;
        }
      
    }

    @Override
    public DLLNode first() {
        return head;
    }

    @Override
    public DLLNode last() {
        return tail;
    }

    @Override
    public boolean isFirst(DLLNode n) {
        if (n == head){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isLast(DLLNode n) {
        if (n == tail){
            return true;
        } 
        else {
            return false;
        }
    }

    @Override
    public DLLNode before(DLLNode n) {
        return n.getPrev();
    }

    @Override
    public DLLNode after(DLLNode n) {
        return n.getNext();
    }

    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        DLLNode temp = head;
        while (temp != null){
            size++;
            temp = temp.getNext();
        }
        return size;
    }


}
