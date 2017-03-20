/*
 * Do NOT change this file
 */
package cs435longinteger;
/**
 *
 * @param <N> subclass of Node
 */
public interface SimpleList <N extends Node> {
    
    public void insertFirst(int data);
    public void insertLast(int data);
    
    public N first();
    public N last();
    
    public boolean isFirst(N n);
    public boolean isLast(N n);
    
    public N before(N n);
    public N after(N n);
    
    public boolean isEmpty();
    public int size();
    
}
