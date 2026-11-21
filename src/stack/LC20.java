package stack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *     每个右括号都有一个对应的相同类型的左括号。

 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([])"
 * 输出：true
 *
 * 示例 5：
 * 输入：s = "([)]"
 * 输出：false

 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class LC20 {
    static Map j = new HashMap<Character, Character>();
    static {

        j.put('(', ')');
        j.put('[', ']');
        j.put('{', '}');
    }


    public boolean judge(String str) {
        char[] chars = str.toCharArray();

        if (chars == null || chars.length == 0 || chars.length % 2 != 0) return false;
        if (chars[0] == ')' || chars[0] == ']' || chars[0] == '}') return false;
        //List<Character> charsa = IntStream.range(0, chars.length).mapToObj(i -> chars[i]).collect(Collectors.toList());
        int leftIndex = 0;
        LinkedList linkedList = new LinkedList();
        while (leftIndex < chars.length) {
            Character a = chars[leftIndex];
            if (isLeft(a)) {
                linkedList.addLast(a);
                leftIndex++;
            } else {
                if (linkedList != null && !linkedList.isEmpty()) {
                    Character last = (Character) linkedList.removeLast();

                    if (j.get(last) != a) {
                        return false;
                    }
                    leftIndex++;
                } else {
                    return false;
                }
            }
        }

        if (linkedList == null || linkedList.isEmpty()) {
            return true;
        }

        return false;
    }


    public boolean isLeft(char left) {
        if (left == '[' || left == '{' || left == '(') {
            return true;
        }
        return false;
    }
}
