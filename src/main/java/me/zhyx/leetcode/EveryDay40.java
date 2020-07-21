package me.zhyx.leetcode;

import java.util.Stack;

/**
 * @auther zhyx
 * @Date 2020/7/21 9:11
 * @Description
 */
public class EveryDay40 {

    /**
     * 设计用两个栈实现队列
     */
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public EveryDay40() {
        stackPush=new Stack<>();
        stackPop=new Stack<>();
    }
    private void pushToPop(){
        if(stackPop.empty()&&!stackPush.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
    public void add(Integer value){
        stackPush.push(value);
        this.pushToPop();
    }

    public int pop(){
        if(stackPush.empty()&&stackPop.empty()){
            throw new RuntimeException("Queue is empty");
        }
        this.pushToPop();
        return stackPop.pop();
    }

    /**
     * 返回栈顶元素
     */
    public int peek(){
        if(stackPush.empty()&&stackPop.empty()){
            throw new RuntimeException("Queue is empty");
        }
        this.pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        EveryDay40 everyDay40 = new EveryDay40();
        everyDay40.add(1);
        everyDay40.add(2);
        everyDay40.add(3);
        everyDay40.add(4);
        everyDay40.add(5);
        System.out.println(everyDay40.pop());
        System.out.println(everyDay40.pop());
        System.out.println(everyDay40.pop());
        System.out.println(everyDay40.pop());
        System.out.println(everyDay40.peek());
        System.out.println(everyDay40.peek());
        System.out.println(everyDay40.peek());
        System.out.println(everyDay40.peek());
    }

}
