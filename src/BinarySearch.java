/**
 * 二分查找法
 * Created by 邱永臣 on 2016-06-21.
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int a[] = {1, 3, 5, 5, 5, 5, 5, 7, 9};
        System.out.println(binarySearch.getPos(a, a.length, 5));
    }

    /**
     * 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，
     * 若不存在该元素，返回-1。
     * 若该元素出现多次，请返回第一次出现的位置。
     * <p>
     * 稍微复杂的思路：将最小指针min与最大指针max都逼向最左边的元素，也就是第一次出现。
     */
    private int getPos(int[] A, int n, int val) {
        int min = 0, max = n - 1, middle;

        while (min < max) {
            middle = min + (max - min) / 2; // 防止(min + max)溢出
            if (A[middle] == val)
                max = middle;
            else if (A[middle] > val)
                max = middle - 1;
            else if (A[middle] < val)
                min = middle + 1;
        }

        return A[min] == val ? min : -1;
    }

    // 最简单的思路，利用中间的数作为参考，找到了就往前(或往后)遍历。
    public int getPosB(int[] A, int n, int val) {

        int min = 0, max = n - 1, middle;

        while (min <= max) {
            middle = (min + max) / 2;

            if (A[middle] == val) {
                // 向前遍历，找出第一次出现的那个数
                while (middle - 1 >= min && A[middle - 1] == val)
                    middle--;
                return middle;
            }

            if (A[middle] > val) max = middle - 1;
            if (A[middle] < val) min = middle + 1;
        }

        return -1;
    }
}
