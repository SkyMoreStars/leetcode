package me.zhyx.leetcode;

import java.util.Stack;

/**
 * @auther zhyx
 * @Date 2020/7/23 8:44
 * @Description
 */
public class EveryDay41 {

    /**
     * 设计一个栈的实现，能够随时返回栈中最小元素。
     */
    private Stack<Integer> stack;
    private Stack<Integer> minValStack;

    public EveryDay41() {
        stack=new Stack<>();
        minValStack=new Stack<>();
    }

    public Integer getMinVal(){
        if(minValStack.empty()){
            throw new RuntimeException("Stack is empty");
        }
        return minValStack.peek();
    }

    public void pushStack(Integer val){
        Integer tempMin=Integer.MAX_VALUE;
        if(!minValStack.empty()){
            tempMin=minValStack.peek();
        }
        if(tempMin>val){
            tempMin=val;
        }
        this.stack.push(val);
        this.minValStack.push(tempMin);
    }

    public Integer popStack(){
        if(stack.empty()&&minValStack.empty()){
            throw new RuntimeException("Stack is empty !");
        }
        Integer val = stack.pop();
        minValStack.pop();
        return val;
    }

    public static void main(String[] args) {
        EveryDay41 everyDay41 = new EveryDay41();
        everyDay41.pushStack(1);
        everyDay41.pushStack(2);
        everyDay41.pushStack(3);
        everyDay41.pushStack(4);
        everyDay41.pushStack(6);
        everyDay41.pushStack(-1);
        System.out.println(everyDay41.getMinVal());
        System.out.println(everyDay41.popStack());
        System.out.println(everyDay41.getMinVal());
    }
}
