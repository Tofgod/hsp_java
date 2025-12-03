package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        List list = new ArrayList();
        List list = new LinkedList();
//        List list = new Vector();

        list.add("DAS0");
        list.add("DAS1");
        list.add("DAS2");
        list.add("DAS3");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        for(Object o : list){
            System.out.println(o);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }





    }
}
