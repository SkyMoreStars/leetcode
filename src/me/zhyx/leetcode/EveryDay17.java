package me.zhyx.leetcode;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Stack;

import static javax.swing.UIManager.put;

/**
 * @auther zhyx
 * @Date 2020/5/28 8:23
 * @Description
 */
public class EveryDay17 {
    public static void main(String[] args) {
        EveryDay17 everyDay17 = new EveryDay17();
        System.out.println(everyDay17.isValid("()()()()()({}{}{}{}{})"));
    }

    /**
     * 给定一个只包括‘{’,'}',[,],(,)
     * 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 空字符串可以k被认为有效字符串
     */
    public boolean isValid(String s){
        HashMap<Character, Character> characterHashMap = new HashMap<>();
        characterHashMap.put(']','[');
        characterHashMap.put('}','{');
        characterHashMap.put(')','(');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(characterHashMap.containsKey(c)){
                char topElement=stack.empty()?'#':stack.pop();
                if(topElement!=characterHashMap.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.empty();
=======
import java.util.Arrays;

/**
 * @author: yx.zh
 * @date: 2020-05-06 11:25
 **/
public class EveryDay17 {
    /**
     * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
     * 如果剩余少于 k 个字符， 则将剩余的所有全部反转。
     * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     * 要求:
     *
     * 该字符串只包含小写的英文字母。
     * 给定字符串的长度和 k 在[1, 10000]范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-string-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String reverseStr(String s, int k) {
        char [] str =s.toCharArray();
        

        return Arrays.toString(str);
>>>>>>> origin/master
    }
}
