package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 16:17
 **/
public class ThreadState  {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("test");
            }
        });
        String state = thread.getState().toString();
        System.out.println(state);//NEW
        thread.start();
        state=thread.getState().toString();
        System.out.println(state);//RUNNABLE
        while (!state.equals(Thread.State.TERMINATED.toString())){
            Thread.sleep(100);
            state=thread.getState().toString();
            System.out.println(state);
        }


    }
}
