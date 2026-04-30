package inner;

import java.util.ArrayList;
import java.util.Iterator;

public class AnonymousEx extends Outer {


    ArrayList list = new ArrayList(){
        @Override
        public Iterator iterator() {
            return super.iterator();
        }
    };

    public void listAdd(){
        System.out.println(this.toString());
        list.iterator();

    }



    public static void main(String[] args) {
        AnonymousEx anonymous = new AnonymousEx();
        anonymous.listAdd();
    }
}
