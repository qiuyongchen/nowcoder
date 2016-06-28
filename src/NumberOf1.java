/**
 * Created by 邱永臣 on 2016-06-25.
 */
public class NumberOf1 {

    public static void main(String[] args) {

    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     *
     * @param n
     * @return
     */
    int numberOf1(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1); // 假设n为11110，则第一次运算11110 & 11101 = 11100，也就是消掉了一个1
            count++;
        }

        return count;
    }

}
