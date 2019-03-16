import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(4);
        set.add(5);
        set.add(3);
        set.add(6);
        set.add(7);
        set.add(1);
        set.add(2);
        System.out.println(set);
        LinkedHashMap linkedHashMap = new LinkedHashMap((int)(10/0.75 +1) , 0.75f, true);
//        linkedHashMap.
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
        Integer i = null;
        while (iterator.hasNext()){
            i = iterator.next();
            System.out.println(i);
            iterator.remove();
        }
    }

}
