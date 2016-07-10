/**
 * Created by qiuyongchen on 16/7/10.
 */
public class MinNumInRotateArray {

    public static void main(String[] args) {


    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        // 往后扫描，遇到递减则说明找到最小元素。
        for (int i = 0, head = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                if (array[i + 1] < array[i])
                    return array[i + 1];
            }
        }

        return array[0];
    }
}
