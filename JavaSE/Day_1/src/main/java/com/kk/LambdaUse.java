package com.kk;

/*
推导Lambda表达式
 */
public class LambdaUse {


    //3.静态内部类
    static class Like2 implements ILike{
        public void lambda() {
            System.out.println("i like lambda --> 2");
        }
    }


    public static void main(String[] args) {


        ILike like = new Like();
        like.lambda();

        Like2 like2 = new Like2();
        like2.lambda();


        //4.局部内部类
        class Like3 implements ILike{

            public void lambda() {
                System.out.println("i like lambda --> 3");
            }
        }

        Like3 like3 = new Like3();
        like3.lambda();


        //5.匿名内部类,没有类的名称，必须借助接口或者父类
        ILike like4 = new ILike() {

            public void lambda() {
                System.out.println("i like lambda --> 4");
            }
        };
        like4.lambda();

        //6.用Lambda简化
        ILike like5 = () -> {System.out.println("i like lambda --> 5");};
        like5.lambda();


    }
}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{

    public void lambda() {
        System.out.println("i like lambda --> 1");
    }
}