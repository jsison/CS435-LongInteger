/*
 * Do NOT change this class 
 */

package cs435longinteger;

public class DLLNode extends Node{
    
    private DLLNode prev;
    private DLLNode next;


    DLLNode(int newData) {
        super(newData);
        this.next = null;
        this.prev = null;
        
    }

    public void setPrev(DLLNode n) {
        this.prev = n;
    }

    public DLLNode getPrev() {
        return this.prev;
    }
    
    public void setNext(DLLNode n) {
        this.next = n;
    }

    public DLLNode getNext() {
        return this.next;
    }
}
