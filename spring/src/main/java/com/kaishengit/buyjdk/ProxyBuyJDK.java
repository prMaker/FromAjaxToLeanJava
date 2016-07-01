package com.kaishengit.buyjdk;

/**
 * Created by Administrator on 2016/7/1.
 */
public class ProxyBuyJDK implements Inter{

    private OneBuyJDK oneBuy;

    public ProxyBuyJDK(OneBuyJDK oneBuy){
        this.oneBuy = oneBuy;
    }

    @Override
    public String buyFood() {
        String food = null;
        try{
            System.out.println("前置通知~~~~~");
            food = oneBuy.buyFood();
            System.out.println("后置通知~~~~~");
        }catch (Exception e){
            System.out.println("异常通知~~");
        }finally{
            System.out.println("最终通知");
        }
        return food;
    }
}
