
package cs435longinteger;

/**
 *
 * @author Jeremy Sison NJIT Email: jas84@njit.edu
 */
public class LongInteger {

    private SimpleList list = new DLLSimpleList();
    private boolean isNegative = false;

    public LongInteger() {
    }
    
    public LongInteger(String s) {
        int stringData;
        
        //While there are still characters in the string
        //take the last 4 and inserts it in front of last node inserted
        while(s.length() > 0){
            if(s.length() < 4){
                stringData = Integer.parseInt(s.substring(s.length()));
                s = s.substring(0,s.length());
                System.out.println(stringData);
            }
            else{
                stringData = Integer.parseInt(s.substring(s.length() - 4));
                s = s.substring(0,s.length()-4);
                System.out.println(stringData);
            }
        }
    }

   /* 
    public void output() {
    }

    public boolean getSign() {

    }

    public void setSign(boolean isNegative) {

    }

    public int getDigitCount() {

    }

    public boolean equalTo(LongInteger i) {

    }

    public boolean lessThan(LongInteger i) {

    }

    public boolean greaterThan(LongInteger i) {

    }

    public Node getNext(Node p) {

    }

    public Node getPrevious(Node p) {

    }

    public Node getFirst() {

    }

    public Node getLast() {

    }

    public boolean isLast(Node p) {

    }

    public boolean isFirst(Node p) {

    }

    public LongInteger add(LongInteger i) {

    }

    public LongInteger subtract(LongInteger i) {

    }

    public LongInteger multiply(LongInteger i) {

    }

    public LongInteger power(int p) {

    }

    public LongInteger divide(LongInteger i) {

    }
*/
}
