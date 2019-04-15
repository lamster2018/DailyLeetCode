import java.util.ArrayList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。
 * 例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 * <p>
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 */
public class AddToArrayForm {
    public static void main(String[] args) {
        int[] tA = new int[]{0};
        int tK = 0;
        List<Integer> arrayList = addToArrayForm(tA, tK);
        System.out.println(arrayList.toString());
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        if (A.length < 1 || A.length > 10000 || K < 0 || K > 10000) return null;
        List<Integer> result = new ArrayList<>();
        int temp = 0;
        boolean carry = false;
        int index = A.length - 1;
        while (index >= 0 || K != 0 || carry) {
            if (index >= 0) temp += A[index];
            index--;
            temp += K % 10;
            K = K / 10;
            if (carry) {
                temp++;
                carry = false;
            }
            if (temp >= 10) {
                carry = true;
                temp -= 10;
            }
            result.add(0, temp);
            temp = 0;
        }
        return result;
    }
}
