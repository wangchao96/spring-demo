import java.util.*;

public class JVMDemo {
    public static void outOfMemoryErrorTest() {
        List<Byte[]> list = new ArrayList<Byte[]>();
        while (true) {
            Byte[] a = new Byte[1024 * 1024];
            list.add(a);
        }
    }

    public static void stackOverflowErrorTest() {
        stackOverflowErrorTest();
    }

    public static void main(String[] args) {
//        outOfMemoryErrorTest();
//        stackOverflowErrorTest();
        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(2);
        list2.add(1);

        Set<List<Integer>> set = new HashSet<List<Integer>>();
        set.add(list1);
        set.add(list2);

        System.out.println(set);
    }
}
