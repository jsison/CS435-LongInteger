
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
        
        if(s.contains("-")){
            s = s.replaceAll("-","");
            setSign(true);
        }
        if(s.contains("\n")){
            s = s.replaceAll("\n","");
        }
        //While there are still characters in the string
        //take the last 4 and inserts it in front of last node inserted
        while(s.length() > 0){
            if(s.length() < 4){
                stringData = Integer.parseInt(s);
                s = "";
                list.insertFirst(stringData);
            }
            else{
                stringData = Integer.parseInt(s.substring(s.length() - 4));
                s = s.substring(0,s.length()-4);
                list.insertFirst(stringData);
            }
        }
    }


    public void output() {
        Node temp = list.first();
        if(temp == null){
            return;
        }
        if(getSign()){
            System.out.print("-");
        }
        if(temp.getData() == 0){
            temp = list.after(temp);
            System.out.print(temp.getData());
        }
        while (list.after(temp) != null){
            temp = list.after(temp);
            System.out.printf("%04d", temp.getData());
            //System.out.print(" ");
        }
        System.out.printf("\n");
    }

    public boolean getSign() {
        return this.isNegative;
    }

    public void setSign(boolean isNegative) {
        this.isNegative = isNegative;
    }

    public int getDigitCount() {
        int x = 0;
        int count = 0;
        x = list.first().getData();
        while(x > 0){
            x = x/10;
            count++;
        }
        return count + ((list.size()-1)*4);
    }

    public boolean equalTo(LongInteger i) {
        Node tempX = list.last(); //Being Checked
        Node tempY = i.list.last();
        
        if(this.getSign() != i.getSign()){
            return false;
        }
        
        if(list.size() != i.list.size()){
            return false;
        }

        while(this.getPrevious(tempX) != null && i.getPrevious(tempY) != null){
            if(tempX.getData() != tempY.getData()){
                return false;
            }
           tempX = this.getPrevious(tempX);
           tempY = i.getPrevious(tempY);
        }

        return true;
    }

    public boolean lessThan(LongInteger i) {
        Node tempX = list.last();
        Node tempY = i.list.last();
 
        if(this.equalTo(i)){

            return false;
        }
        if(this.isNegative & !i.isNegative){
            return true;
        }
        if(this.isNegative & i.isNegative){
            if(list.size() > i.list.size()){
                return true;
            }
            else if(list.size() == i.list.size()){
                while(this.getPrevious(tempX) != null && i.getPrevious(tempY) != null){
                    tempX = this.getPrevious(tempX);
                    tempY = i.getPrevious(tempY);
                }
                if(tempX.getData() > tempY.getData()){
                    return true;
                }
            }
        }
        else if(!this.isNegative & !i.isNegative){
            if(list.size() < i.list.size()){
                return true;
            }
            else if(list.size() == i.list.size()){
                while(this.getPrevious(tempX) != null && i.getPrevious(tempY) != null){
                    tempX = this.getPrevious(tempX);
                    tempY = i.getPrevious(tempY);
                }
                if(tempX.getData() < tempY.getData()){
                   return true;
                }
            }
        }
        else if(this.greaterThan(i)){
            return false;
        }
        return false;
    }

    public boolean greaterThan(LongInteger i) {
        Node tempX = list.last();
        Node tempY = i.list.last();
        
        if(this.equalTo(i)){
            return false;
        }
        if(!this.isNegative & i.isNegative){
            return true;
        }
        if(this.isNegative & i.isNegative){
            if(list.size() < i.list.size()){
                return true;
            }
            else if(list.size() == i.list.size()){
                while(this.getPrevious(tempX) != null && i.getPrevious(tempY) != null){
                    tempX = this.getPrevious(tempX);
                    tempY = i.getPrevious(tempY);
                }
                if(tempX.getData() < tempY.getData()){
                   return true;
                }
            }
        }
        else if(!this.isNegative & !i.isNegative){
            if(list.size() > i.list.size()){
                return true;
            }
            else if(list.size() == i.list.size()){
                while(this.getPrevious(tempX) != null && i.getPrevious(tempY) != null){
                    tempX = this.getPrevious(tempX);
                    tempY = i.getPrevious(tempY);
                }
                if(tempX.getData() > tempY.getData()){
                   return true;
                }
            }
        }
        else if(this.lessThan(i)){
            return false;
        }      
        return false;
    }

    public Node getNext(Node p) {
        return list.after(p);
    }

    public Node getPrevious(Node p) {
        return list.before(p);
    }

    public Node getFirst() {
        Node temp = list.first();
        return temp;
    }

    public Node getLast() {
        Node temp = list.last();
        return temp;
    }

    public boolean isLast(Node p) {
        if(list.after(p) == null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFirst(Node p) {
        if(p == list.first())
        {
            return true;
        }
        return false;
    }

    public LongInteger add(LongInteger i) {
        Node x = list.last(); //A Long Integer
        Node y = i.list.last(); //B Long Integer
        SimpleList newList = new DLLSimpleList();
        LongInteger newInteger = new LongInteger();
        newInteger.list = newList;
        
        
        int sumOF = 0;
        int sumUF = 0;
        int sum = 0;
        
        //Both LongIntegers are null
        if(list.last() == null || i.list.last() == null){
            return null;
        }
        
        //(A)If A is empty and B is not or vice versa
        if(x == null && y != null){
            return i;
        }
        else if(y == null && x != null){
            newInteger.list = list;
            return i;
        }
        
        //*******************-A + B****************************
        if(getSign() == true && i.getSign() == false){
            //System.out.println("-A+B");
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = -x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if (sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = -x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = -x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = -x.getData() + y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = -x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    newInteger.setSign(true);
                }
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
        }
        //*******************A + -B****************************
        if(getSign() == false && i.getSign() == true){
            //System.out.println("A+-B");
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = x.getData() + -y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = -y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if (sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = x.getData() + -y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = x.getData() + -y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                while(y != null){
                    sum = -y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                    newInteger.setSign(true);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
        }
        //*******************A + B****************************
        if(getSign() == false && i.getSign() == false){
            //If A has one node and B has more than one
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if (sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = x.getData() + y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
        }
        //*******************-A + -B****************************
        if(getSign() == true && i.getSign() == true){
            //System.out.println("-A+-B");
            //If A has one node and B has more than one
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if (sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = x.getData() + y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
        }
        return i;
    }

    public LongInteger subtract(LongInteger i) {
        Node x = list.last();
        Node y = i.list.last();
        SimpleList newList = new DLLSimpleList();
        LongInteger newInteger = new LongInteger();
        newInteger.list = newList;
        
        //A and B are null
        if(x == null && y == null){
            return null;
        }
        
        int sumOF = 0;
        int sumUF = 0;
        int sum = 0;
        
        if(x == null && y != null){
            return i;
        }
        else if (y == null && x != null){
            newInteger.list = list;
            return newInteger;
        }
        
        //*******************-A - -B****************************
        if(getSign() == true && i.getSign() == true){
            //System.out.println("-A--B");
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = -x.getData() - -y.getData();
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = -y.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                newInteger.list = newList;
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = -x.getData() - -y.getData();
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = -x.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = -x.getData() - -y.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = -x.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    newInteger.setSign(true);
                }
                while(y != null){
                    sum = -y.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                newInteger.list = newList;
                return newInteger;
            }
        }
        //*******************-A - B****************************
        if(getSign() == true && i.getSign() == false){
            //System.out.println("-A-B");
            //If A has one node and B has more than one
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if (sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = x.getData() + y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
        }
        //*******************A - -B****************************
        if(getSign() == false && i.getSign() == true){
            //System.out.println("A--B");
            //If A has one node and B has more than one
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if (sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = x.getData() + y.getData();
                sumOF = UtilityOperations.overFlow(sum);
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = x.getData() + y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = x.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                while(y != null){
                    sum = y.getData() + sumOF;
                    sumOF = UtilityOperations.overFlow(sum);
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                if(sumOF > 0){ newList.insertFirst(sumOF); }
                newInteger.list = newList;
                return newInteger;
            }
        }
        //*******************A - B****************************
        if(getSign() == false && i.getSign() == false){
            //System.out.println("A-B");
            if(list.isFirst(x) == true && i.list.isFirst(y) == false){
                sum = x.getData() - y.getData();
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(y != null){
                    sum = y.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                }
                newInteger.list = newList;
                newInteger.setSign(true);
                return newInteger;
            }
            else if (i.list.isFirst(y) == true && list.isFirst(x) == false){
                sum = x.getData() - y.getData();
                sumUF = UtilityOperations.underFlow(sum);
                x = list.before(x);
                y = i.list.before(y);
                newList.insertFirst(sumUF);
                while(x != null){
                    sum = x.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                newInteger.list = newList;
                return newInteger;
            }
            else{
                while(x != null && y != null){
                    sum = x.getData() - y.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                    y = i.list.before(y);
                }
                while(x != null){
                    sum = x.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    x = list.before(x);
                }
                while(y != null){
                    sum = y.getData();
                    sumUF = UtilityOperations.underFlow(sum);
                    newList.insertFirst(sumUF);
                    y = i.list.before(y);
                    newInteger.setSign(true);
                }
                newInteger.list = newList;
                return newInteger;
            }
        }
        return i;
    }

    public LongInteger multiply(LongInteger i) {
        LongInteger returnLong = new LongInteger();
        returnLong.list.insertFirst(0);

        SimpleList innerLoop = new DLLSimpleList();
        SimpleList outerLoop = new DLLSimpleList();
        
        LongInteger storeOuter = new LongInteger();
        Node multiplicand = i.list.last();
        Node multiplier = list.last();
        Node prevInt = null;
        
        int countOne = 0;
        int countTwo = 1;

        int product, overflow = 0, underflow = 0;
        
        if(list.isEmpty() == true || i.list.isEmpty() == true ){
            return null;
        }
        
        if(this.list.size() < i.list.size()){
            while(multiplier != null){
                while(multiplicand != null){
                    product = multiplier.getData() * multiplicand.getData() + overflow;
                    //System.out.println(multiplier.getData() + "*" + multiplicand.getData() + "+" + overflow + "=" + product);                 
                    overflow = UtilityOperations.overFlow(product);
                    underflow = UtilityOperations.underFlow(product);
                    innerLoop.insertFirst(underflow);
                    multiplicand = i.list.before(multiplicand);
                }
                innerLoop.insertFirst(overflow);
                overflow = 0;
                multiplicand = i.list.last();
                multiplier = list.before(multiplier);
                
                outerLoop = innerLoop;
                storeOuter.list = outerLoop;
                returnLong = storeOuter.add(returnLong);
                prevInt = outerLoop.last();
                innerLoop = new DLLSimpleList();
                innerLoop.insertFirst(0);
                for(int x = 0; x < countOne; x++){                 
                    innerLoop.insertFirst(0);
                }
                countOne++;
            }
        }
        //if Multiplicand > Multiplier
        else{
            while(multiplicand != null){
                while(multiplier != null){
                    product = multiplier.getData() * multiplicand.getData() + overflow;
                    //System.out.println(multiplier.getData() + "*" + multiplicand.getData() + "+" + overflow + "=" + product); 
                    overflow = UtilityOperations.overFlow(product);
                    underflow = UtilityOperations.underFlow(product);
                    innerLoop.insertFirst(underflow);
                    multiplier = list.before(multiplier);
                }               
                innerLoop.insertFirst(overflow);
                overflow = 0;
                multiplier = list.last();
                multiplicand = i.list.before(multiplicand);
                outerLoop = innerLoop;
                storeOuter.list = outerLoop;
                returnLong = storeOuter.add(returnLong);
                prevInt = outerLoop.last();
                innerLoop = new DLLSimpleList();
                for(int x = 0; x < countTwo; x++){                 
                    innerLoop.insertFirst(0);
                }
                countTwo++;                
            }            
        }

        if(getSign() == true && i.getSign() == false){
            returnLong.setSign(true);
        }
        else if(getSign() == false && i.getSign() == true){
            returnLong.setSign(true);
        }
        else if(getSign() == true && i.getSign() == true){
            returnLong.setSign(false);
        }

        return returnLong;
    }

    public LongInteger power(int p) {
        LongInteger temp = new LongInteger();
        temp.list = list;
        for(int x = 0; x < p; x++){
            temp = temp.multiply(temp);
        }
        
//        if(temp.getSign()){
//            if(p % 2 == 0){
//                temp.setSign(false);
//            }
//        }
//        if(p < 0 || p == 0){
//            temp = new LongInteger();
//            temp.list.insertFirst(1);
//            return temp;
//        }
//        while(p != 0){
//            if(p%2 ==1){
//                p = p-1;
//                temp = temp.multiply(temp);
//            }
//            if(p%2 == 2){
//                p = p /2;
//                for(int x = 0; x < p; x++){
//                    temp = temp.multiply(temp);
//                }
//            }
//        }
        return temp;
    }

    public LongInteger divide(LongInteger i) {
        return i;
    }

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
