import java.util.*;

public class subSet {

    public static void main(String[] args) {
        int[] first = new int[]{1, 2, 2};
        List<List<Integer>> res = subsets(first);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }
    }

    /**
     * 重复集合求子集
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        if (nums.length == 0 || nums == null)
            return new ArrayList<List<Integer>>();
        Arrays.sort(nums); //排序
        dfs(nums, 0, item, set);  //递归调用
        List<List<Integer>> res = new ArrayList<List<Integer>>(set);
        res.add(new ArrayList<Integer>());  //最后加上一个空集
        return res;
    }

    private static void dfs(int[] nums, int start, List<Integer> item, Set<List<Integer>> set) {
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            //item是以整数为元素的动态数组，而res是以数组为元素的数组，在这一步，当item增加完元素后，item所有元素构成一个完整的子串，
            // 再由res纳入
            set.add(new ArrayList<Integer>(item));
            System.out.println(set);
            dfs(nums, i + 1, item, set);
            item.remove(item.size() - 1);
        }
    }
}
