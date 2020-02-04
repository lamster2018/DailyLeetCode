import java.util.*

/**
 * #代表退格
 * 这个用栈最好做，不是退格就进栈，是退格就出栈上一个元素
 * 最后比较两个栈
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/comments/
 */
fun main() {
    val s = "ab#c"
    val t = "ad#cd"
    print("result----" + BackspaceStringCompare.backspaceCompare(s, t))
}

class BackspaceStringCompare {
    companion object {
        fun backspaceCompare(S: String, T: String): Boolean {
            var sStack = Stack<Char>()
            var tStack: Stack<Char> = Stack()
            for (x in S) {
                if (x == '#') {
                    sStack.pop()
                } else {
                    sStack.push(x)
                }
            }

            for (y in T) {
                if (y == '#') {
                    tStack.pop()
                } else {
                    tStack.push(y)
                }
            }

            return sStack == tStack
        }
    }
}