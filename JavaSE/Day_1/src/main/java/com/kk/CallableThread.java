package com.kk;

import java.util.concurrent.*;

//线程创建方式3：实现Callable接口
/*
1.可以定义返回值
2.可以抛出异常
 */
public class CallableThread implements Callable<Boolean> {

    private String url; //网络图片地址
    private String name; //保存的文件名

    public CallableThread(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片的执行体
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThread t1 = new CallableThread("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2699863970,3643884691&os=896086540,305703528&simid=4283923611,802066007&pn=8&rn=1&di=177540&ln=1628&fr=&fmq=1605319601055_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa3.att.hudong.com%2F02%2F38%2F01300000237560123245382609951.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","1.jpg");
        CallableThread t2 = new CallableThread("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2699863970,3643884691&os=896086540,305703528&simid=4283923611,802066007&pn=8&rn=1&di=177540&ln=1628&fr=&fmq=1605319601055_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa3.att.hudong.com%2F02%2F38%2F01300000237560123245382609951.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","2.jpg");
        CallableThread t3 = new CallableThread("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2699863970,3643884691&os=896086540,305703528&simid=4283923611,802066007&pn=8&rn=1&di=177540&ln=1628&fr=&fmq=1605319601055_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa3.att.hudong.com%2F02%2F38%2F01300000237560123245382609951.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdownNow();
    }


}
