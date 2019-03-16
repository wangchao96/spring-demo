import java.util.Arrays;

public class BinarySearchDemo {
    /**
     * 二分查找-递归版本
     *
     * @param nums 查找数组
     * @param l    查找左边界
     * @param r    查找又边界
     * @param x    查询目标
     * @return
     */
    public static int binarySearchWithRecursion(int[] nums, int l, int r, int x) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (x == nums[mid]) {
                return mid;
            } else if (x < nums[mid]) {
                // 搜索前半部分
                return binarySearchWithRecursion(nums, l, mid - 1, x);
            } else {
                // 搜索后半部分
                return binarySearchWithRecursion(nums, mid + 1, r, x);
            }
        }
        return -1;
    }

    /**
     * 二分查询-非递归版本
     *
     * @param nums 查找数组
     * @param x    查询目标
     * @return
     */
    public static int binarySearch(int[] nums, int x) {
        int l = 0;
        int r = nums.length;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (x == nums[mid]) {
                return mid;
            } else if (x < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
