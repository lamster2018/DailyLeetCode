package ZiFuChuan;

/**
 * 输入三个字符 a、b、c，则它们的组合有a b c ab ac bc abc。当然我们还是可以借鉴全排列的思路，利用问题分解的思路，最终用递归解决。不过这里介绍一种比较巧妙的思路 —— 基于位图。
 * 假设原有元素n个，最终的组合结果有2^n - 1. 可以使用2^n - 1个位，1表示取该元素，0表示不取。 所以a表示001,取ab是011。
 * 001,010,011,100,101,110,111。对应输出组合结果为：a,b,ab,c,ac,bc,abc。
 * 因此可以循环 1~2^n-1(字符串长度)，然后输出对应代表的组合即可。
 */
public class StringCombination {
    public static void main(String[] args) {
        String sss = "abc";
        combination(sss.toCharArray());
    }

    public static void combination(char[] s) {
        if (s.length == 0) {
            return;
        }
        int len = s.length;
        int n = 1 << len;
        //从1循环到2^len-1
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            //查看第一层循环里面的任意一种取值当中的哪一位是1[比如ab,011]， 如果是1，对应的字符就存在，打印当前组合。
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    // 对应位上为1，则输出对应的字符
                    sb.append(s[j]);
                }
            }
            System.out.print(sb + " ");
        }
    }
}
