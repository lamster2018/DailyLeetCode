import com.sun.xml.internal.rngom.parse.host.Base
import java.lang.StringBuilder

/**
 * 转7进制
 * 数学法，断除递归
 * api法，java提供了进制转换
 * api的内部实现，是定义了一个全局char的字符表，进制转换的时候
 * 局部变量char[33],去字符表找，然后从后往前填充
 * 最后new String，所以重点是两个，一个是全局字符，一个是char数组
 * 用stringBuilder也很香
 * https://leetcode-cn.com/problems/base-7/
 */
fun main() {
    val int = -7
    print("result:" + Base7.convertToBase7Math(int))
}

class Base7 {
    companion object {
        fun convertToBase7Math(num: Int): String {
            var sb: StringBuilder = StringBuilder()
            var n = num
            if (num < 0) n = num * -1
            while (n >= 7) {
                sb.insert(0, n % 7)
                n /= 7
            }
            sb.insert(0, n % 7)
            if (num < 0) {
                sb.insert(0, '-')
            }
            return sb.toString()
        }
    }
}