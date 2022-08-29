import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {
        // 奖池
        int[] a = new int[49];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

        // 49选6
        int[] b = new int[6];
        int n = a.length;
        for (int i = 0; i < b.length; i++) {
            // 随机抽取下标
            int aIndex = (int) (Math.random() * n);

            // 获得中奖号码
            b[i] = a[aIndex];

            // 奖池去掉被选中的号码，的总长度-1
            // 用数组最后一个值顶替被选中的值
            a[aIndex] = a[n-1];
            n--;
        }

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
    }

}
