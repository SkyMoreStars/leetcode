package me.zhyx.base;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author: yx.zh
 * @date: 2020-06-20 08:20
 * 继承Thread 方法
 **/
public class ThreadDemo2 implements Runnable {
    private String url;
    private String localName;
    public ThreadDemo2 (String url,String localName){
        this.localName=localName;
        this.url=url;
    }
    @Override
    public void run() {
        WebImageDownloadTest webImageDownload = new WebImageDownloadTest();
        webImageDownload.DownloadImage(url,localName);
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1("http://www.zmxtea.com/resource/1.png","1.jpg");
        ThreadDemo1 threadDemo2 = new ThreadDemo1("http://www.zmxtea.com/resource/2.png","2.jpg");
        ThreadDemo1 threadDemo3 = new ThreadDemo1("http://www.zmxtea.com/resource/3.png","3.jpg");
        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();
    }
}

class WebImageDownloadTest {
    public void DownloadImage(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}