package ZiFuChuan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，
 * 第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class FirstShowOnceChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input string:");
        String inputStr = scanner.nextLine();
        for (char c : inputStr.toCharArray()) {
            insert(c);
        }
        System.out.println(getFirstShowOnceChar());
    }

    private static int[] git = new int[256];//256位的仓库，字符最多是0~255，下标就是对应的ASCII码，值就是出现的次数
    private static Queue<Character> queue = new LinkedList<>();

    private static void insert(char input) {
        git[input]++;//插入一个字符记录出现次数
        queue.offer(input);//因为要记录 第一个，只出现一次的字符，第一个，这个记录方式用先进先出的方式。
        while (!queue.isEmpty() && git[queue.peek()] > 1) {//队是先进先出，也就是第一个，每次insert一个数，都去判断队首是不是出现次数超1了
            //因为这个queue会不断的往里塞，出现goog这样的数据，当第二个g出现的时候，队里已经有goo的数据了，因为oo进队的时候，git[queue.peek()] > 1还是为false的，
            // 第二个g进来的时候，要循环去清理之前的队
            queue.poll();//超了，那原来的队首就不再是我们想要的第一个 只出现1次的，后续的话，这个队可能有很多值，但是我们只要第一个，也就是队首
        }
    }

    private static char getFirstShowOnceChar() {
        return queue.isEmpty() ? '$' : queue.peek();
    }
}
