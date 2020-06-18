import java.util.Arrays;

/**
 * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子
 */
public class IsContinuous {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 0, 3, 4, 5};
        int[] a2 = new int[]{8, 0, 3, 4, 5};
        System.out.println(check(a1));
        System.out.println(check(a2));
    }

    private static boolean check(int[] cards) {
        if (cards.length < 5) return false;//不够5张不是顺子

        Arrays.sort(cards);//癞子是0，直接放前面

        int cnt = 0;//统计癞子数量
        for (int card : cards) {
            cnt += (card == 0 ? 1 : 0);
        }

        //癞子都在前面
        for (int i = cnt, len = cards.length - 1; i < len; i++) {
            if (cards[i + 1] == cards[i]) return false;//如果两张牌一样，肯定是不能凑顺子的
            int need = cards[i + 1] - cards[i] - 1;//计算两张牌之间差多少，如果刚好差1，那就不用用癞子来补
            cnt -= need;//补癞子的数量
        }

        return cnt >= 0;//如果癞子不够，说明凑不了顺子
    }
}
