public class SortDemo {
    /**
     * 冒泡排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return
     */
    public static int[] bubbleSort(int[] a, int n) {
        boolean flag;
        for (int i = n - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return a;
    }

    /**
     * 快速排序
     *
     * @param a 待排序数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @return
     */
    public static int[] quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = a[i];
            while (i < j) {
                while (i < j && a[j] >= x) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] <= x) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i++];
                }
            }
            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
        return a;
    }

    /**
     * 直接插入排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return
     */
    public static int[] insertSort(int[] a, int n) {
        int i, j, k;
        for (i = 1; i < n; i++) {
            for (j = i - 1; j > 0; j--) {
                if (a[i] > a[j]) {
                    break;
                }
            }
            if (j != i - 1) {
                int temp = a[i];
                for (k = i - 1; k > j; k--) {
                    a[k + 1] = a[k];
                }
                a[j + 1] = temp;
            }
        }
        return a;
    }

    /**
     * 选择排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return
     */
    public static int[] selectionSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n ; j++) {
                if(a[j] < min){
                    min = j;
                }
            }
            if (i != min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }

        }
        return a;
    }
}
