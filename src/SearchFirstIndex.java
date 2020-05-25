import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。要求时间复杂度为O(n)
 */
public class SearchFirstIndex {
    public static void main(String[] args) {
        String test = "aabbccddeegg";
        System.out.println("firstIndex:" + searchFirstIndex(test));
        System.out.println("firstIndex:" + searchFirstIndexByArray(test));
    }

    public static int searchFirstIndex(String origin) {
        if (origin == null) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, len = origin.length(); i < len; i++) {
            char c = origin.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);//出现一次，记录其位置
            }
        }//遍历一次找到了所有全部只出现一次的字符
        int firstIndex = origin.length() + 1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0 && entry.getValue() < firstIndex) {
                firstIndex = entry.getValue();//第二次遍历去找出现1次的字符的位置，然后对比位置更前的那个
            }
        }
        if (firstIndex > origin.length()) return -1;//处理边界值
        return firstIndex;
    }

    public static int searchFirstIndexByArray(String origin) {
        if (origin == null) return -1;
        int[] arr = new int[256];
        for (int i = 0, len = origin.length(); i < len; i++) {
            arr[origin.charAt(i)]++;
        }
        int firstIndex = -1;
        for (int j = 0, len = origin.length(); j < len; j++) {
            if (arr[origin.charAt(j)] == 1) {
                firstIndex = j;
                break;
            }
        }
        return firstIndex;
    }
}
