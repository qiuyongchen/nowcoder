/**
 * Created by DELL on 2016-06-24.
 */
public class MaxSub {
    public static void main(String[] args) {
        int[] a = {1, 3, 12, 8, 10, -3, 35, 27};
        int[] b = {1, 3, -99, 8, 10, -3, 35, 27, -100};
        int[] c = {1, 3, 12, 8, 10, -3, -100, -1000};
        int[] d = {10000, 3, 12, 82, 10, -3, 35, -19999};
        MaxSub maxSub = new MaxSub();
        System.out.println(maxSub.findMaxSubBetter(a));
        System.out.println(maxSub.findMaxSubBetter(b));
        System.out.println(maxSub.findMaxSubBetter(c));
        System.out.println(maxSub.findMaxSubBetter(d));
    }

    /**
     * O(N*N)
     */
    int findMaxSub(int[] a) {
        int max = Integer.MIN_VALUE;
        int length = a.length;
        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] - a[j] > max)
                    max = a[i] - a[j];
            }
        }
        return max;
    }

    /**
     * 使用动态规划来计算最大差值，复杂度为 O(n)
     * 思路：
     * 从最后一位开始，sub[i]表示a[i]与其后面所有元素的差值的最大一个
     * sub[i] = a[i] - a[i + 1] （sub[i + 1] < 0，
     * 这表明a[i]是从i到最后一个元素里最小的那个，因为它与后面所有元素的差都是负数）
     * sub[i] = a[i] - a[i + 1] + sub[i + 1] (sub[i + 1] >= 0，
     * 这表明依旧有元素比a[i + 1]小，我们要加上a[i + 1]与后面最小那个数的差值)
     */
    int findMaxSubBetter(int[] a) {
        int max = Integer.MIN_VALUE;
        int length = a.length;
        int A = 0, B = length - 1;
        int i = 0;
        int[] sub = new int[length + 1];

        for (i = length - 2; i >= 0; i--) {
            sub[i] = sub[i + 1] < 0 ?
                    a[i] - a[i + 1] :
                    a[i] - a[i + 1] + sub[i + 1];

            if (sub[i + 1] < 0) {
                sub[i] = a[i] - a[i + 1];
                B = i + 1;
            } else {
                sub[i] = a[i] - a[i + 1] + sub[i + 1];
            }

            if (sub[i] > max) {
                A = i;
                max = sub[i];
            }
        }

        System.out.print(max);
        System.out.print(" ");
        System.out.print(A);
        System.out.print(" ");
        System.out.print(B);
        return max;
    }
}

/*
{1,3, 12, 8, 10, -3, 35, 27}
 4 6  15  11 13  -30 8  0
 */