package me.zhyx.base;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author: yx.zh
 * @date: 2020-06-20 13:31
 **/
public class ThreadDemo3 implements Callable<Boolean> {
    private String url;
    private String localName;
    public ThreadDemo3 (String url,String localName){
        this.localName=localName;
        this.url=url;
    }
    @Override
    public Boolean call() {
        WebImageDownloadTest1 webImageDownload = new WebImageDownloadTest1();
        webImageDownload.DownloadImage(url,localName);
        return true;
    }

    public static void main(String[] args) {
        ThreadDemo3 threadDemo1 = new ThreadDemo3("http://www.zmxtea.com/resource/1.png","1.jpg");
        ThreadDemo3 threadDemo2 = new ThreadDemo3("http://www.zmxtea.com/resource/2.png","2.jpg");
        ThreadDemo3 threadDemo3 = new ThreadDemo3("http://www.zmxtea.com/resource/3.png","3.jpg");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> submit1 = executorService.submit(threadDemo1);
        Future<Boolean> submit2 = executorService.submit(threadDemo2);
        Future<Boolean> submit3 = executorService.submit(threadDemo3);
        try {
            System.out.println(submit1.get());
            System.out.println(submit2.get());
            System.out.println(submit3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class WebImageDownloadTest1{
    public void DownloadImage(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}