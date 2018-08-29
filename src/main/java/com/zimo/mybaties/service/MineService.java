package com.zimo.mybaties.service;

public class MineService {
    /**
     * 冰雹猜想
     * @param num
     */
    public static void iceImage(long num){
        System.out.println("N 的值为： "+num);
        if (num == 1l){
            System.out.println("执行完毕，N的值变成1");
            return ;
        }
        if (num%2==0){
            //偶数
            num /=2;
            iceImage(num);
        } else {
            //奇数
            num = 3*num +1;
            iceImage(num);
        }
    }


    public static void main(String arg[]){
        MineService.iceImage(197196131161010086l);
        System.out.println(printII());
    }
    public static double printII(){
        double s =( 5800/4.0)*5;
        return s;
    }
}
