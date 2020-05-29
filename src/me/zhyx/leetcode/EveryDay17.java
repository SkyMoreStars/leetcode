package me.zhyx.leetcode;

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
    }
}
