package com.kk;

import org.apache.commons.io.FileUtils;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class PictureDownload extends Thread{

    private String url;
    private String name;

    public PictureDownload(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }


    public static void main(String[] args) {
        PictureDownload t1 = new PictureDownload("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2699863970,3643884691&os=896086540,305703528&simid=4283923611,802066007&pn=8&rn=1&di=177540&ln=1628&fr=&fmq=1605319601055_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa3.att.hudong.com%2F02%2F38%2F01300000237560123245382609951.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","1.jpg");
        PictureDownload t2 = new PictureDownload("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3225163326,3627210682&os=350330249,2599662640&simid=3515799065,357855384&pn=16&rn=1&di=171710&ln=1628&fr=&fmq=1605319601055_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fi1.sinaimg.cn%2FIT%2F2010%2F0419%2F201041993511.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","2.jpg");
        PictureDownload t3 = new PictureDownload("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3437217665,1564280326&os=2072654899,2518511731&simid=4239509109,801615866&pn=13&rn=1&di=53240&ln=1628&fr=&fmq=1605319601055_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Ffile02.16sucai.com%2Fd%2Ffile%2F2014%2F0829%2F372edfeb74c3119b666237bd4af92be5.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","3.jpg");

        t1.start();
        t2.start();
        t3.start();

    }

}



//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }

    }
}
