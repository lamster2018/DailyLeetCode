package ZiFuChuan;

/**
 * 第一个只出现一次的字符位置,不是流。流是需要insert的时候记录的
 */
public class FirstShowOnceString {
    public static void main(String[] args) {

    }

    private static int get(String str) {
        int[] charIdxArr = new int[256];//ASCII 去映射
        for (int i = 0, len = str.length() - 1; i < len; i++) {
            charIdxArr[str.charAt(i)]++;// str.chat 实际上可以对应一个idx，也就是该字符在数组里的位置，记录其出现次数
        }//一定要先全部跑完一遍，否则会出现  abbbbbbbbbbbccccca这样的字符
        for (int i = 0, len = str.length() - 1; i < len; i++) {
            if (charIdxArr[str.charAt(i)] == 1) {
                return i;//第二次遍历就谁先是只出现1次，就是那个位置
            }
        }
        return -1;
    }
}
