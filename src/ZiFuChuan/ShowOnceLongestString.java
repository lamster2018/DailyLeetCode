package ZiFuChuan;

import java.util.Arrays;

/**
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 *
 * 类似于 重复，首次，的问题，可以用数组来做记录
 *
 * key是字符值ASCII值，或者与'a'的差值，刚好对应下标，
 * 值是其上一次出现的位置，或者key是出现的次数
 *
 */
public class ShowOnceLongestString {
    public static void main(String[] args) {
        String str = "abcaefghi";//6
        System.out.println(getLongest(str));
    }

    private static int getLongest(String originStr) {
        int curLen = 0;
        int maxLen = 0;
        int[] charIdxArr = new int[26];//数组，key是字符值ASCII，刚好对应下标，值是其上一次出现的位置。
        Arrays.fill(charIdxArr, -1);
        for (int curIdx = 0, len = originStr.length() - 1; curIdx < len; curIdx++) {
            int chrValue = originStr.charAt(curIdx) - 'a';//ASCII 码差值,可以直接映射到数组
            int preIdx = charIdxArr[chrValue];//该字符上一次出现的位置
            if (preIdx < 0 || curIdx - preIdx > curLen) {//如果没出现过，或者重复出现的位置两者距离比现在的距离大
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curIdx - preIdx;
            }
            charIdxArr[chrValue] = curIdx;//把本次出现的字符的位置记录到数组
        }
        maxLen = Math.max(maxLen, curLen);//最后结束再做一次判断，很可能最后结束了
        return maxLen;
    }
}
